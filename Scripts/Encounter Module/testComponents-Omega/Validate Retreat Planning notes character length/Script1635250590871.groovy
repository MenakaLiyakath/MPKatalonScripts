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

WebUI.delay(2)
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'),planningRetreatNotes, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'))
println "Planning notes length::"+WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'),'value')
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'),'value').length().toString(),'4000' , false, FailureHandling.CONTINUE_ON_FAILURE)
