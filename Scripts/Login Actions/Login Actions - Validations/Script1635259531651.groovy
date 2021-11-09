import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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


//TC1 - Correct Username and Password
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('page_login/input_login_email'), 2)

WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/CommonPageObjects/img_common_home'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

//TC2 - Incorrect Username and Password
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('page_login/input_login_email'), 2)

WebUI.setText(findTestObject('page_login/input_login_email'), 'qatest@incorrect.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), '8SQVv/p9jVScEs4/2CZsLw==', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/page_login/span_worngEmailOrPassword') , 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

//TC3 - Correct Username and  incorrect Password
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('page_login/input_login_email'), 2)

WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), 'NaRTu7UBtmp/wAHDxOmFxg==', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('page_login/button_login_logIn'))
WebUI.verifyElementPresent(findTestObject('Object Repository/page_login/span_worngEmailOrPassword') , 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

//TC3 - Blank UserName and Password
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('page_login/input_login_email'), 2)

WebUI.setText(findTestObject('page_login/input_login_email'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/page_login/span_userNameBlank')  , 0, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent( findTestObject('Object Repository/page_login/span_passwordBlank') , 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

//TC4 - Validate password Eye icon
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('page_login/input_login_email'), 2)

WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/page_login/button_loginEyeIcon') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementAttributeValue( findTestObject('Object Repository/page_login/input_login_password') , 'type', 'text', 0, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.closeBrowser()

//TC5 - Forgot password
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)
WebUI.click( findTestObject('Object Repository/page_login/link_login_dontRememberPassword') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/page_login/input_login_forgotEmail') , "testqa@gmaiill.com", FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/page_login/span_resetConfirmation'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

