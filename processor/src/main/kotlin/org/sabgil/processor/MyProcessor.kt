package org.sabgil.processor

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*
import com.google.devtools.ksp.validate
import org.sabgil.annotation.MyAnnotation
import java.io.OutputStream

class MyProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    operator fun OutputStream.plusAssign(str: String) {
        this.write(str.toByteArray())
    }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        //resolver 를 통해 원하는 심볼들을 찾을 수 있습니다.
        val symbols = resolver
            .getSymbolsWithAnnotation(MyAnnotation::class.java.canonicalName) // annotation 원하는 심볼을 필터링 할 수 있습니다.
            .filterIsInstance(KSClassDeclaration::class.java)

        symbols.iterator().hasNext()
        if (!symbols.iterator().hasNext()) {
            return emptyList()
        }

        // codeGenerator 를 통해 새파일을 생성합니다.
        val file: OutputStream = codeGenerator.createNewFile(
            dependencies = Dependencies(false),
            packageName = "com.sabgil",
            fileName = "GeneratedFile"
        )

        // interface 에서만 사용될 수 있도록 강제
        if (symbols.any { it.classKind != ClassKind.INTERFACE }) {
            logger.error("인터페이스만 가능!!")
        }

        file += "package com.sabgil\n"

        val visitor = Visitor(file)
        symbols.forEach { it.accept(visitor, Unit) }

        file.close()

        return symbols.filterNot { it.validate() }.toList()
    }

    inner class Visitor(
        private val file: OutputStream
    ) : KSVisitorVoid() {

        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
            file += "\n" +
                    "fun ${classDeclaration.simpleName.getShortName().lowercase()}() {\n"

            file += "\tprint(\n"
            file += "\t\t\"\"\"\n"

            classDeclaration.getAllProperties().forEach {
                it.accept(this, Unit)
            }

            file += "\t\t\"\"\"\n"
            file += "\t)\n"
            file += "}"
        }

        override fun visitPropertyDeclaration(property: KSPropertyDeclaration, data: Unit) {
            file += "\t\t${property.simpleName.asString()}: ${property.type.resolve().declaration.simpleName.asString()}\n"
        }
    }
}
