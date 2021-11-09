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

def participantName = (Lastname + ', ') + Firstname

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/button_userAccounts_addAccount'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_addAccount/label_addAccount_addUserAccount'),
		2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Changes for Card 142 starts here')

WebUI.comment('Select a participant from sheet for adding the account')

//Verify if only one checkbox is clickable
WebUI.modifyObjectProperty(dynamicObject1, 'xpath', 'equals', '//kendo-grid[@id=\'userAccountsGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'Participantlast-H\']//preceding-sibling::td//input',
		true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'userAccountsGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		Lastname) + '\']//preceding-sibling::td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(dynamicObject1, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_addAccount/button_addAccount_addAndContinue'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Assign access to selected user')

WebUI.verifyElementPresent(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/label_asignAccess_step2AssignAccess'),
		2, FailureHandling.CONTINUE_ON_FAILURE)

//Validate displayed participant name
/*WebUI.verifyMatch(WebUI.getText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/label_asignAccess_participantName'), 
 FailureHandling.CONTINUE_ON_FAILURE), participantName, false, FailureHandling.CONTINUE_ON_FAILURE)
 */
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//input[@id=\'admin_checkBox\']//ancestor::div[@class=\'light-box-content\'][contains(text(),\''+participantName+'\')]', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
/*WebUI.verifyElementPresent(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/label_asignAccess_participantName', 
 [('participantName') : Lastname]), 2, FailureHandling.CONTINUE_ON_FAILURE)*/

if (Admin.toString().toLowerCase() == 'yes') {

	WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/checkBox_asignAccess_admin'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'encounter_access\']//div[@class=\'ng-value ng-star-inserted\']//span[@class=\'ng-value-label ng-star-inserted\']', true, FailureHandling.CONTINUE_ON_FAILURE)


	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), 'Read/Write/Create', false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'grow_access\']//div[@class=\'ng-value ng-star-inserted\']//span[@class=\'ng-value-label ng-star-inserted\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), 'Read/Write/Create', false, FailureHandling.CONTINUE_ON_FAILURE)
} else {
	if (EncounterAccess != '') {
		WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/dropDown_asignAccess_encounterModuleAccessLevel'),
				FailureHandling.CONTINUE_ON_FAILURE)

		switch (EncounterAccess.toString().toLowerCase()) {
			case 'r':
				WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/option_asignAccess_encounterAccessReadOnly'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
			case 'rw':
				WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/option_asignAccess_encounterAccessReadWrite'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
			case 'rwc':
				WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/option_asignAccess_encounterAccessReadWriteCreate'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
		}
	}

	if (GrowModuleAccess != '') {
		WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/dropDown_asignAccess_growModuleAccessLevel'),
				FailureHandling.CONTINUE_ON_FAILURE)

		switch (GrowModuleAccess.toString().toLowerCase()) {
			case 'r':
				WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/option_asignAccess_growAccessReadOnly'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
			case 'rw':
				WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/option_asignAccess_growAccessReadWrite'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
			case 'rwc':
				WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/option_asignAccess_growAccessReadWriteCreate'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
		}
	}
}
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/button_asignAccess_asignAndContinue'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Validate participant on Account confirmationand Confirm')

WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_accountConfirmation/label_accountConfirmation_participantName'),
		FailureHandling.CONTINUE_ON_FAILURE), participantName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_accountConfirmation/button_accountConfirmation_confirm'),
		FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

