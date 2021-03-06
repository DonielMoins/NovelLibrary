package io.github.gmathi.novellibrary.model

import java.io.Serializable

data class WebPage(var url: String, var chapter: String) : Serializable {

    var id: Long = -1L
    var redirectedUrl: String? = null
    var title: String? = null
    var filePath: String? = null
    var novelId: Long = -1L
    var sourceId: Int = -1
    var isRead: Int = 0
    var orderId: Long = -1L
    var metaData: HashMap<String, String?> = HashMap()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val webPage = other as WebPage?
        return if (webPage != null) url == webPage.url else false
    }

    fun copyFrom(other: WebPage?) {
        if (other != null) {
            id = if (other.id != -1L) other.id else id
            url = other.url
            chapter = other.chapter

            redirectedUrl = if (other.redirectedUrl != null) other.redirectedUrl else redirectedUrl
            title = if (other.title != null) other.title else title
            filePath = if (other.filePath != null) other.filePath else filePath
            novelId = if (other.novelId != -1L) other.novelId else novelId
            sourceId = if (other.sourceId != -1) other.sourceId else sourceId
            isRead = if (other.isRead != 0) other.isRead else isRead
            orderId = if (other.orderId != -1L) other.orderId else orderId

            other.metaData.keys.forEach {
                metaData[it] = other.metaData[it]
            }
        }
    }

    override fun hashCode(): Int {
        var result = url.hashCode()
        result = 31 * result + chapter.hashCode()
        return result
    }

}
