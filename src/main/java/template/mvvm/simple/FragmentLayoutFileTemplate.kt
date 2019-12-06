package template.mvvm.simple

import template.FileTemplate
import java.util.*

class FragmentLayoutFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "fragment_" + convertToUnderScoreText(featureName)

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "SimpleFragmentLayoutTemplate"
    override val subFolderNames = listOf<String>()
}