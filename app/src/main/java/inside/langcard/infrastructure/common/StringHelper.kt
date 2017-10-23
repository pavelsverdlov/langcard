package com.svp.infrastructure.common

import java.util.ArrayList

/**
 * Created by Pasha on 5/11/2015.
 */
object StringHelper {
    private val separator = "\n"
    fun splitByLineSeparator(text: String): Array<String> {
        val splitted = ArrayList<String>()
        for (str in text.split(separator.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if (!str.isEmpty()) {
                splitted.add(str)
            }
        }
        return splitted.toTypedArray()
    }

    fun joinByLineSeparator(text: Array<String>): String {
        if (text.size == 0) {
            return ""
        }
        val sb = StringBuilder()
        sb.append(text[0])
        for (i in 1 until text.size) {
            val txt = text[i]
            if (!txt.isEmpty()) {
                sb.append(separator).append(txt)
            }
        }
        return sb.toString()
    }

    fun endsWithLineSeparator(txt: String): Boolean {
        return txt.endsWith(separator)
    }

    fun trimLineSeparator(txt: String): String {
        return txt.substring(0, txt.length - separator.length)
    }

    fun endsWithLineSeparator(txt: CharSequence): Boolean {
        return txt.length != 0 && txt[txt.length - 1] == separator[0]
    }
}
