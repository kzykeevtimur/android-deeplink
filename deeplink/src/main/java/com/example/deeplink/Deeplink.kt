package com.example.deeplink

sealed class Deeplink

data class GeneralProfileDeeplink(val mode: String) : Deeplink()
data object GeneralSupportDeeplink : Deeplink()

data class SupplyTaskCardDeeplink(val taskId: Int) : Deeplink()
data class SupplyTutorialDeeplink(val tutorialType: String) : Deeplink()

data class DemandProjectDeeplink(val projectId: Int, val filter: String) : Deeplink()
