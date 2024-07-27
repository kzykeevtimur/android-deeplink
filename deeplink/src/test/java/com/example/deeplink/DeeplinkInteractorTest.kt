package com.example.deeplink

import org.junit.Assert
import org.junit.Test

class DeeplinkInteractorTest {

    private val interactor = DeeplinkInteractor()

    @Test
    fun `general profile deeplink, wrong mode view, parse success`() {
        // given
        val deeplink = "https://com.example/general/profile?mode=open"
        val expected = GetDeeplinkError

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `general profile deeplink, mode view, parse success`() {
        // given
        val deeplink = "https://com.example/general/profile?mode=view"
        val mode = "view"
        val expected = GetDeeplinkSuccess(
            GeneralProfileDeeplink(mode)
        )

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `general support deeplink, parse success`() {
        // given
        val deeplink = "https://com.example/general/support"
        val expected = GetDeeplinkSuccess(GeneralSupportDeeplink)

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `supply task card deeplink, task id 10, parse success`() {
        // given
        val deeplink = "https://com.example/supply/taskCard?id=10"
        val taskId = 10
        val expected = GetDeeplinkSuccess(
            SupplyTaskCardDeeplink(taskId)
        )

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `supply tutorial deeplink, money withdraw tutorial, parse success`() {
        // given
        val deeplink = "https://com.example/supply/supply/tutorial-list?type=money_withdraw"
        val type = "money_withdraw"
        val expected = GetDeeplinkSuccess(
            SupplyTutorialDeeplink(type)
        )

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `demand project deeplink, project id 2, filter active, parse success`() {
        // given
        val deeplink = "https://com.example/demand/project?id=2&filter=active"
        val id = 2
        val filter = "active"
        val expected = GetDeeplinkSuccess(
            DemandProjectDeeplink(id, filter)
        )

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }
}
