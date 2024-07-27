package com.example.deeplink

import org.junit.Assert
import org.junit.Test

class DeeplinkInteractorTest {

    private val interactor = DeeplinkInteractor()

    @Test
    fun `general profile deeplink, wrong mode, parse error`() {
        // given
        val deeplink = "https://com.example/general/profile?mode=open"
        val expected = GetDeeplinkError

        // when
        val actual = interactor.getDeeplink(deeplink)

        // then
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `general profile deeplink, mode edit, parse success`() {
        // given
        val deeplink = "https://com.example/general/profile?mode=edit"
        val mode = "edit"
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
        val deeplink = "https://com.example/supply/tutorial-list?type=money_withdrawal"
        val type = "money_withdrawal"
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
