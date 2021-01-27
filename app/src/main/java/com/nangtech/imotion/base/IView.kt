package com.nangtech.imotion.base

interface IView<S : IState> {

    fun renderView(state: S)
}