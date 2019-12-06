package template.mvvm.recycler_view

import template.FileTemplate
import java.util.*

class RvItemLayoutFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "item_" + convertToUnderScoreText(featureName)

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "RvItemLayoutTemplate"
    override val subFolderNames = listOf<String>()
}