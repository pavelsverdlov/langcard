package com.svp.infrastructure.mvpvs.commutate


import android.app.Activity

interface ICommutativeElement {
    val operation: ActivityOperationItem
    val activity: Activity
}