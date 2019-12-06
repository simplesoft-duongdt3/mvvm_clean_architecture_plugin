package template.mvvm.recycler_view

import template.FileTemplate
import java.util.*

class RvFragmentLayoutFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "fragment_" + convertToUnderScoreText(featureName)

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "RvFragmentLayoutTemplate"
    override val subFolderNames = listOf<String>()
}