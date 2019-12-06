package template.mvvm.recycler_view

import template.FileTemplate
import java.util.*

class RvDomainUseCaseFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "Get${featureName}UseCase"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "RvDomainUseCaseTemplate"
    override val subFolderNames = listOf("domain", "usecase")
}