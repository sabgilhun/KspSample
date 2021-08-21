package org.sabgil.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.*
import java.io.OutputStream

class MyProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        logger.info("메세지", null)
        logger.error("ㄷㄱ")
        return emptyList()
//        require(false)
//        val symbols = resolver
//            .getSymbolsWithAnnotation(MyAnnotation::class.java.canonicalName) // annotation 이름으로 심볼 이터레이터 가져오기
//            .filterIsInstance(KSClassDeclaration::class.java) // class 타겟인 annotation 이므로 안해도 될듯
//
//        symbols.iterator().hasNext()
//        if (!symbols.iterator().hasNext()) {
//            return emptyList()
//        }
//
//        val file: OutputStream = codeGenerator.createNewFile(
//            dependencies = Dependencies(false),
//            packageName = "com.morfly",
//            fileName = "GeneratedFunctions"
//        )
//        file.write("package com.morfly\n".toByteArray())
//        symbols.forEach { it.accept(Visitor(file), Unit) }
//
//        file.close()
//        print("build....")
//        val unableToProcess = symbols.filterNot { it.validate() }.toList()
//        return unableToProcess
    }

    inner class Visitor(private val file: OutputStream) : KSVisitorVoid() {
        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        }

        override fun visitPropertyDeclaration(property: KSPropertyDeclaration, data: Unit) {
        }

        override fun visitTypeArgument(typeArgument: KSTypeArgument, data: Unit) {
        }
    }
}