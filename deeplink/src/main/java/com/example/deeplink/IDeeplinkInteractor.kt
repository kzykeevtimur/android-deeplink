package com.example.deeplink

interface IDeeplinkInteractor {
    fun getDeeplink(deeplink: String): GetDeeplinkResult
}
