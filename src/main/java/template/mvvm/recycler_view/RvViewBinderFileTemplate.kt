package template.mvvm.recycler_view

import template.FileTemplate
import java.util.*

class RvViewBinderFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "${featureName}ViewBinder"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "RvViewBinderTemplate"
    override val subFolderNames = listOf("viewbinder")
}