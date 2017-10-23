package com.svp.infrastructure.mvpvs.commutate

class ActivityOperationItem(
        //    Undefined(0);

        private val code: Int) {
    fun toInt(): Int {
        return code
    }

    fun `is`(key: Int): Boolean {
        return code == key
    }

    fun `is`(item: ActivityOperationItem): Boolean {
        return item.code == code
    }
}
