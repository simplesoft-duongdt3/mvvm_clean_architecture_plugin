package template.mvvm.simple

import template.FileTemplate
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class FragmentLayoutFileTemplate(private val featureName: String, private val parentPackage: String) : FileTemplate() {
    override val resultFileName: String
        get() = "fragment" + convertToUnderScoreText(featureName)

    override fun getProperties(templateProperties: Properties): Properties? {
        return getDefaultProperties(featureName = featureName, folderPath = parentPackage, templateProperties = templateProperties)
    }

    override val templateFileName: String = "SimpleFragmentLayoutTemplate"
    override val subFolderNames = listOf<String>()

    private fun convertToUnderScoreText(input: String): String {
        val m: Matcher = Pattern.compile("([A-Z])").matcher(input)
        val sb = StringBuffer()
        while (m.find()) {
            m.appendReplacement(sb, "_" + m.group().toLowerCase())
        }
        m.appendTail(sb)
        return sb.toString()
    }
}