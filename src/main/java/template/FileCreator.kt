package template

import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement


class FileCreator(private val project: Project) {
    fun createTemplateFile(template: FileTemplate, destinationDirectory: PsiDirectory): PsiElement {
        var newDestinationDirectory = destinationDirectory
        val fileTemplate = FileTemplateManager.getInstance(project).getInternalTemplate(template.templateFileName)
        val templateProperties = FileTemplateManager.getInstance(project).defaultProperties

        template.subFolderNames.forEach { name ->
            val findSubdirectory = newDestinationDirectory.findSubdirectory(name)
            if (findSubdirectory != null) {
                newDestinationDirectory = findSubdirectory
            } else {
                newDestinationDirectory = newDestinationDirectory.createSubdirectory(name)
            }
        }

        return FileTemplateUtil.createFromTemplate(
                fileTemplate,
                template.resultFileName,
                template.getProperties(templateProperties),
                newDestinationDirectory
        )
    }
}

