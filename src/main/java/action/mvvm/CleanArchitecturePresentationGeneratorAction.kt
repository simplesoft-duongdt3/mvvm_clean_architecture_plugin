package action.mvvm

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import template.FileCreator
import template.mvvm.presentation.*
import util.DialogProvider


class CleanArchitecturePresentationGeneratorAction : AnAction() {
    private val dialogProvider = DialogProvider()
    override fun actionPerformed(event: AnActionEvent) {
        val project: Project? = event.project
        project?.let {
            val featureName =
                    dialogProvider.showInputDialog(project, "Create Presentation files", "Input feature's name")
            WriteCommandAction.runWriteCommandAction(project) {
                createDomainFiles(featureName, project, event)
            }
        }
    }

    private fun createDomainFiles(featureName: String,
                                  project: Project,
                                  event: AnActionEvent
    ) {
        if (featureName.isNotBlank()) {
            val fileCreator = FileCreator(project)
            val destinationPath = event.getData(LangDataKeys.PSI_ELEMENT) as PsiDirectory

            val parentPackage = ParentPackageProcessor().getParentPackage(project, destinationPath)
            val featureNameAfterTrim = featureName.trim()
            createPresenterFile(featureNameAfterTrim, fileCreator, destinationPath, parentPackage)
            createFragmentFile(featureNameAfterTrim, fileCreator, destinationPath, parentPackage)
            createFragmentLayoutFile(featureNameAfterTrim, fileCreator, destinationPath, parentPackage)
            createDiFile(featureNameAfterTrim, fileCreator, destinationPath, parentPackage)
        }
    }

    private fun createPresenterFile(
            featureNameAfterTrim: String,
            fileCreator: FileCreator,
            destinationPath: PsiDirectory,
            parentPackage: String
    ) {
        val template = ViewModelFileTemplate(featureNameAfterTrim, parentPackage)
        fileCreator.createTemplateFile(template, destinationPath)
    }

    private fun createDiFile(
            featureNameAfterTrim: String,
            fileCreator: FileCreator,
            destinationPath: PsiDirectory,
            parentPackage: String
    ) {
        val template = DiFileTemplate(featureNameAfterTrim, parentPackage)
        fileCreator.createTemplateFile(template, destinationPath)
    }

    private fun createFragmentFile(
            featureNameAfterTrim: String,
            fileCreator: FileCreator,
            destinationPath: PsiDirectory,
            parentPackage: String
    ) {
        val template = FragmentFileTemplate(featureNameAfterTrim, parentPackage)
        fileCreator.createTemplateFile(template, destinationPath)
    }

    private fun createFragmentLayoutFile(
            featureNameAfterTrim: String,
            fileCreator: FileCreator,
            destinationPath: PsiDirectory,
            parentPackage: String
    ) {
        val template = FragmentLayoutFileTemplate(featureNameAfterTrim, parentPackage)
        fileCreator.createTemplateFile(template, destinationPath)
    }
}