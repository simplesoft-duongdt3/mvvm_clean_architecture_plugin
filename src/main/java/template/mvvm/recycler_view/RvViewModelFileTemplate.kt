package template.mvvm.recycler_view

import template.FileTemplate
import java.util.*

class RvViewModelFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "${featureName}ViewModel"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "RvViewModelTemplate"
    override val subFolderNames = listOf("viewmodel")
}
