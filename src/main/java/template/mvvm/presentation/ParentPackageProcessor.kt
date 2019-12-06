package template.mvvm.presentation

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import java.io.File

class ParentPackageProcessor {
    fun getParentPackage(project: Project, destinationPath: PsiDirectory): String {
        val projectPath = project.presentableUrl ?: ""
        var folderPath = destinationPath.virtualFile.presentableUrl
        if (folderPath.startsWith(projectPath)) {
            folderPath = folderPath.substring(projectPath.length)
        }
        val srcPrefix = File.pathSeparator + "src"
        if (folderPath.startsWith(srcPrefix)) {
            folderPath = folderPath.substring(srcPrefix.length)
        }
        val javaPrefix = "java"
        val indexOfJava = folderPath.indexOf(string = javaPrefix, startIndex = 0, ignoreCase = false)
        if (indexOfJava >= 0) {
            folderPath = folderPath.substring(indexOfJava + javaPrefix.length)
        }
        val kotlinPrefix = "kotlin"
        val indexOfKotlin = folderPath.indexOf(string = kotlinPrefix, startIndex = 0, ignoreCase = false)
        if (indexOfKotlin >= 0) {
            folderPath = folderPath.substring(indexOfKotlin + kotlinPrefix.length)
        }

        val builder = StringBuilder()
        for (index in folderPath.indices) {
            if (folderPath[index] == File.separatorChar) {
                if (index != 0) {
                    builder.append(".")
                }
            } else {
                builder.append(folderPath[index])
            }
        }
        folderPath = builder.toString()
        return folderPath
    }
}
