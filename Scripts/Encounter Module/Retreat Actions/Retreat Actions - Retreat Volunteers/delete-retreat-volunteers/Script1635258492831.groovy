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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod


    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('(.//td[text()=\'' + LastName) + '\'])[1]/ancestor::tr[1]/td[@class=\'check-box-cell\'][1]/input', 
        true)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/button_retreatVolunteer_deleteButton'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ((('//li[contains(text(),\'' + LastName) + ', ') + FirstName) + 
        '\')]', true)

    WebUI.verifyElementPresent(dynamicObject, 1)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_delete/button_deleteVolunteer_conformDelete'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
