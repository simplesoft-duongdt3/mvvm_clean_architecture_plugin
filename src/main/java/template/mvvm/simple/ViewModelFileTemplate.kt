package template.mvvm.simple

import template.FileTemplate
import java.util.*

class ViewModelFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "${featureName}ViewModel"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "SimpleViewModelTemplate"
    override val subFolderNames = listOf("viewmodel")
}
