package template.mvvm.simple

import template.FileTemplate
import java.util.*

class FragmentFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "${featureName}Fragment"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "SimpleFragmentTemplate"
    override val subFolderNames = listOf("view")
}