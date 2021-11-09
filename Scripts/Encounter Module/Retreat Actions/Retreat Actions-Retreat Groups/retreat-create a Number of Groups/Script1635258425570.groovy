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

WebUI.delay(1)

println "numberOfGroups"+numberOfGroups
if(addGroupbyIcon=='yes')
{
	for(def totGroupCount=1;totGroupCount<=numberOfGroups;totGroupCount++)
	{
		
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_addGroupIcon'), FailureHandling.CONTINUE_ON_FAILURE)
	}
}
if(addGroupbyIcon=='no')
{
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/input_createGroup_numberOfGroups'), numberOfGroups.toString())

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_createGroup'))
}
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_save'))
WebUI.delay(2)

