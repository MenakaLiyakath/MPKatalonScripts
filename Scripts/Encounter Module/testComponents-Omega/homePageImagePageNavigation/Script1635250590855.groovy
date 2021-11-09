import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('null'), [('loginUrl') : GlobalVariable.globalLoginUrl, ('username') : GlobalVariable.globalTestUser
        , ('password') : GlobalVariable.globalTestUserPassword, ('neworlastlogin') : ''], FailureHandling.CONTINUE_ON_FAILURE)

println('Logged IN')

if (moduleName == 'Encounter') {
    WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/button_manage_createSessionButton'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (moduleName == 'Grow') {
    WebUI.click(findTestObject('CommonPageObjects/page_home/image_homePage_grow'))

    WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('module_grow/page_group/button_group_addGroup'), 1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (moduleName == 'Inform') {
    WebUI.click(findTestObject('CommonPageObjects/page_home/image_homePage_inform'))

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('module_inform/dropDown_inform_SessionType'), 1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (moduleName == 'Profiles') {
    WebUI.click(findTestObject('CommonPageObjects/page_home/image_homePage_profiles'))

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('module_profiles/button_Profiles_addPerson'), 0, FailureHandling.CONTINUE_ON_FAILURE)
}

