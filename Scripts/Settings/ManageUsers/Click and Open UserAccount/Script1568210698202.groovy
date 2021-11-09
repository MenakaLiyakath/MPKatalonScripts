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

if(Admin.toString().toLowerCase()!='yes')
{

	def participantName = (Lastname + ', ') + Firstname

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'peopleKendoGrid\']//div//following-sibling::kendo-grid-list//table//td[text()=\''+Firstname+'\']//preceding-sibling::td[text()=\''+Lastname+'\']//preceding-sibling::td//input[@type=\'checkbox\']',
			true)


	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/icon_userAccounts_editIcon'),
			FailureHandling.CONTINUE_ON_FAILURE)

	if (EncounterAccess != '') {
		WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
		
		switch (EncounterAccess.toString().toLowerCase()) {
			case 'r':
				encouAccess='Read Only'

				break
			case 'rw':
				encouAccess='Read/Write'

				break
			case 'rwc':
				encouAccess='Read/Write/Create'
				break
		}
	}
	
	if (GrowModuleAccess != '') {
	
		WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
		switch (GrowModuleAccess.toString().toLowerCase()) {
			case 'r':
				growAccess='Read Only'

				break
			case 'rw':
				growAccess='Read/Write'

				break
			case 'rwc':
				growAccess='Read/Write/Create'
				break
		}
	}
	
	
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/label_editAccess_editAccess'),
			2, FailureHandling.CONTINUE_ON_FAILURE)

	//Validate displayed participant name

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//input[@id=\'admin_checkBox\']//ancestor::div[@class=\'light-box-content\'][contains(text(),\'' +
			participantName) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
	if(EncounterAccess!='')
	{
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/dropDown_editAccess_encounterModuleAccessLevel-selectedOption')
				, FailureHandling.CONTINUE_ON_FAILURE), encouAccess, false,FailureHandling.CONTINUE_ON_FAILURE)
	}
	else
		WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/dropDown_editAccess_encounterModuleAccessLevel-selectedOption')
				, FailureHandling.CONTINUE_ON_FAILURE), "None", false,FailureHandling.CONTINUE_ON_FAILURE)
	if(GrowModuleAccess!='')
	{
		WebUI.verifyMatch(WebUI.getText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/dropDown_editAccess_growModuleAccessLevel-selectedOption')
				, FailureHandling.CONTINUE_ON_FAILURE), growAccess, false,FailureHandling.CONTINUE_ON_FAILURE)
	}
	else
		WebUI.verifyMatch(WebUI.getText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/dropDown_editAccess_growModuleAccessLevel-selectedOption')
				, FailureHandling.CONTINUE_ON_FAILURE), "None", false,FailureHandling.CONTINUE_ON_FAILURE)

}