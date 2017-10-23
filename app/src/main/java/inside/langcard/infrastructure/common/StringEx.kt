package com.svp.infrastructure.common

import java.util.Formatter
import java.util.Locale

object StringEx {
    //    private final static Formatter format = new Formatter();
    fun toString(i: Int): String {
        return String.format(Locale.getDefault(), "%d", i)
    }
}
