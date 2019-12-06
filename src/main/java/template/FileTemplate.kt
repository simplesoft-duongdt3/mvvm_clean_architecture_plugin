package template

import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import java.util.*

abstract class FileTemplate {

    abstract val templateFileName: String
    abstract val resultFileName: String
    abstract val subFolderNames: List<String>


    fun createTemplate(project: Project, destinationDirectory: PsiDirectory): PsiElement {
        val templateName = FileTemplateManager.getInstance(project).getInternalTemplate(templateFileName)
        val templateProperties = FileTemplateManager.getInstance(project).defaultProperties
        return FileTemplateUtil.createFromTemplate(templateName, resultFileName, getProperties(templateProperties), destinationDirectory)

    }

    fun getDefaultProperties(featureName: String, folderPath: String, templateProperties: Properties): Properties {
        templateProperties["FEATURE_NAME"] = featureName
        templateProperties["FEATURE_NAME_LOWER"] = featureName.substring(0, 1).toLowerCase() + featureName.substring(1)
        templateProperties["ROOT_PACKAGE"] = folderPath
        return templateProperties
    }

    abstract fun getProperties(templateProperties: Properties): Properties?
}