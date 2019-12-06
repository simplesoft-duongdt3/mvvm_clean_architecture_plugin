package template.mvvm.presentation

import template.FileTemplate
import java.util.*

class FragmentFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "${featureName}Fragment"

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "MvvmFragmentTemplate"
    override val subFolderName: String = "view"
}