package com.example.deeplink

sealed class GetDeeplinkResult
data class GetDeeplinkSuccess(val deeplink: Deeplink): GetDeeplinkResult()
data object GetDeeplinkError: GetDeeplinkResult()
