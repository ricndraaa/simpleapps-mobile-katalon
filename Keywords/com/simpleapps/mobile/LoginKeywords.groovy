package com.simpleapps.mobile

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

class LoginKeywords {

	/**
	 * Membaca nilai captcha dari elemen captcha_value_hint (mode TESTING).
	 * Catatan: di getAttribute nama atributnya 'contentDescription',
	 * walaupun di XPath ditulis @content-desc.
	 */
	@Keyword
	String getCaptchaValue(int timeoutSeconds = 10) {
		TestObject captchaHint = findTestObject('Mobile/Login/lbl_captcha')

		if (captchaHint == null) {
			KeywordUtil.markFailedAndStop("Test Object 'Mobile/Login/lbl_captcha' tidak ditemukan di Object Repository.")
		}

		if (!Mobile.waitForElementPresent(captchaHint, timeoutSeconds, FailureHandling.OPTIONAL)) {
			KeywordUtil.markFailedAndStop('Elemen captcha tidak muncul. Apakah aplikasi dalam mode TESTING?')
		}

		long deadline = System.currentTimeMillis() + (timeoutSeconds * 1000L)

		while (System.currentTimeMillis() < deadline) {
			String value = Mobile.getAttribute(captchaHint, 'contentDescription', 2, FailureHandling.OPTIONAL)?.trim()
			if (value) {
				KeywordUtil.logInfo("Captcha terbaca: ${value}")
				return value
			}
			Mobile.delay(1)
		}

		KeywordUtil.markFailedAndStop("Nilai captcha tetap kosong setelah ${timeoutSeconds} detik.")
	}
}