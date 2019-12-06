package template.mvvm.recycler_view

import template.FileTemplate
import java.util.*

class RvDomainModelResultFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "${featureName}Result"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "RvDomainModelResultEntityTemplate"
    override val subFolderNames = listOf("domain", "model")
}