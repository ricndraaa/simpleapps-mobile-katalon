import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startExistingApplication('id.co.juaracoding.mobile')

Mobile.verifyElementVisible(findTestObject('Mobile/Home/lbl_judul'), 10)
Mobile.tap(findTestObject('Mobile/Home/btn_login'), 10)

Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile/Login/lbl_judul'), 10)
Mobile.setText(findTestObject('Object Repository/Mobile/Login/input_username'), 'customer1', 10)
Mobile.setText(findTestObject('Object Repository/Mobile/Login/input_password'), 'Customer1@123', 10)

String captcha = CustomKeywords.'com.simpleapps.mobile.LoginKeywords.getCaptchaValue'()
Mobile.setText(findTestObject('Object Repository/Mobile/Login/input_captcha'), captcha, 10)

Mobile.tap(findTestObject('Object Repository/Mobile/Login/btn_login'), 10)

Mobile.delay(5)

