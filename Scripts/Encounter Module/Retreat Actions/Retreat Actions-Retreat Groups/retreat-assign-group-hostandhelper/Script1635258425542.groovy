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
if(GroupName.toString().contains('Group1'))
{

	
	if(GroupName.toString().contains('Helper1') )
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_helperOneDropdownOne'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

	if(GroupName.toString().contains('Helper2'))
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_helperTwoDropdownOne'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

	if(GroupName.toString().contains('Host1'))
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_hostOneDropdownOne'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

	if(GroupName.toString().contains('Host2'))
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_hostTwoDropdownOne'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

}

if(GroupName.toString().contains('Group2'))
{

	if(GroupName.toString().contains('Helper1'))
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_helperOneDropdownTwo'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

	if(GroupName.toString().contains('Helper2'))
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_helperTwoDropdownTwo'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

	if(GroupName.toString().contains('Host1'))
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_hostOneDropdownTwo'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

	if(GroupName.toString().contains('Host2'))

		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_groupAssignment/select_groupAssignment_hostTwoDropdownTwo'), LastName+', '+FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_save'))
