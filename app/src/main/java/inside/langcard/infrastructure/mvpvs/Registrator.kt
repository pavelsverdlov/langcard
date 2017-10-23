package com.svp.infrastructure.mvpvs

import com.svp.infrastructure.mvpvs.view.IActivityView


object Registrator {
    fun <T : IActivityView> register(_class: Class<T>,
                                     pcreator: PresenterContainer.IPresenterCreator,
                                     stateCreator: ViewStateContainer.IViewStateCreator) {
        PresenterContainer.register(_class, pcreator)
        ViewStateContainer.register(_class, stateCreator)
    }
}
