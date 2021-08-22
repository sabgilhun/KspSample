package org.sabgil.processor

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.*
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

        logger.warn("round: $round, ${symbols.toList().size}")

        symbols.iterator().hasNext()
        if (!symbols.iterator().hasNext()) {
            return emptyList()
        }

        // codeGenerator 를 통해 새파일을 생성합니다.
        val file: OutputStream = codeGenerator.createNewFile(
            dependencies = Dependencies(false),
            packageName = "com.sabgil",
            fileName = "GeneratedFile$round"
        )

        if (round++ < 10) {
            file += "package com.sabgil\n\nimport org.sabgil.annotation.MyAnnotation\n\n@MyAnnotation\ninterface MyInterface$round"
        }
//
//        symbols.forEach { it.accept(Visitor(file), "start") }
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
        return if (round < 10) {
            symbols.toList()
        } else {
            emptyList()
        }
    }

    var round = 0

    inner class Visitor(private val file: OutputStream) : KSVisitor<String, Int> {
        override fun visitAnnotated(annotated: KSAnnotated, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitAnnotation(annotation: KSAnnotation, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitCallableReference(reference: KSCallableReference, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitClassDeclaration(
            classDeclaration: KSClassDeclaration,
            data: String
        ): Int {
            logger.warn("class")
            return 0
        }

        override fun visitClassifierReference(reference: KSClassifierReference, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitDeclaration(declaration: KSDeclaration, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitDeclarationContainer(
            declarationContainer: KSDeclarationContainer,
            data: String
        ): Int {
            TODO("Not yet implemented")
        }

        override fun visitDynamicReference(reference: KSDynamicReference, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitFile(file: KSFile, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitModifierListOwner(
            modifierListOwner: KSModifierListOwner,
            data: String
        ): Int {
            TODO("Not yet implemented")
        }

        override fun visitNode(node: KSNode, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitParenthesizedReference(
            reference: KSParenthesizedReference,
            data: String
        ): Int {
            TODO("Not yet implemented")
        }

        override fun visitPropertyAccessor(accessor: KSPropertyAccessor, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitPropertyDeclaration(property: KSPropertyDeclaration, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitPropertyGetter(getter: KSPropertyGetter, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitPropertySetter(setter: KSPropertySetter, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitReferenceElement(element: KSReferenceElement, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitTypeAlias(typeAlias: KSTypeAlias, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitTypeArgument(typeArgument: KSTypeArgument, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitTypeParameter(typeParameter: KSTypeParameter, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitTypeReference(typeReference: KSTypeReference, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitValueArgument(valueArgument: KSValueArgument, data: String): Int {
            TODO("Not yet implemented")
        }

        override fun visitValueParameter(valueParameter: KSValueParameter, data: String): Int {
            TODO("Not yet implemented")
        }
    }
}