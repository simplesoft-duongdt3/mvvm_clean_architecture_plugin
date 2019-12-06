package action.mvvm

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import template.FileCreator
import template.mvvm.ParentPackageProcessor
import template.mvvm.recycler_view.*
import util.DialogProvider


class CleanArchitectureRvPresentationGeneratorAction : AnAction() {
    private val dialogProvider = DialogProvider()
    override fun actionPerformed(event: AnActionEvent) {
        val project: Project? = event.project
        project?.let {
            val featureName =
                    dialogProvider.showInputDialog(project, "Create RecyclerView Presentation files", "Input feature's name")
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

            val rvViewModelFileTemplate = RvViewModelFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvViewModelFileTemplate, destinationPath)

            val rvViewBinderFileTemplate = RvViewBinderFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvViewBinderFileTemplate, destinationPath)

            val rvModelFileTemplate = RvModelFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvModelFileTemplate, destinationPath)

            val rvItemLayoutFileTemplate = RvItemLayoutFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvItemLayoutFileTemplate, destinationPath)

            val rvFragmentLayoutFileTemplate = RvFragmentLayoutFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvFragmentLayoutFileTemplate, destinationPath)

            val rvFragmentFileTemplate = RvFragmentFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvFragmentFileTemplate, destinationPath)

            val rvDomainUseCaseFileTemplate = RvDomainUseCaseFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvDomainUseCaseFileTemplate, destinationPath)

            val rvDomainModelResultFileTemplate = RvDomainModelResultFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvDomainModelResultFileTemplate, destinationPath)

            val rvDomainModelEntityFileTemplate = RvDomainModelEntityFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvDomainModelEntityFileTemplate, destinationPath)

            val rvDomainDiFileTemplate = RvDomainDiFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvDomainDiFileTemplate, destinationPath)

            val rvDiFileTemplate = RvDiFileTemplate(featureNameAfterTrim, parentPackage)
            fileCreator.createTemplateFile(rvDiFileTemplate, destinationPath)
        }
    }

}