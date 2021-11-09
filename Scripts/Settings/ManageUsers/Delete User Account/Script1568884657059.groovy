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

WebUI.verifyElementNotClickable(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/icon_userAccounts_deleteicon'),
		FailureHandling.CONTINUE_ON_FAILURE)
WebUI.comment("Script variable for Single delete or multiple delete")
if (deleteSingle == 'yes') {
	WebUI.setText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_lastName'),
			Lastname, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_lastName'))

	WebUI.comment("Filter the user account which should be deleted")
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

	WebUI.delay(1)


	WebUI.setText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_firstName'),
			Firstname, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_firstName'))

	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

	WebUI.delay(1)


	def userName = (Lastname + ', ') + Firstname

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment("Click on the checkbox of the account to be deleted")
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//kendo-grid[@id=\'peopleKendoGrid\']//div//following-sibling::kendo-grid-list//table//td[text()=\'' +
			Firstname) + '\']//preceding-sibling::td[text()=\'') + Lastname) + '\']//preceding-sibling::td//input[@type=\'checkbox\']',
			true)

	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/icon_userAccounts_deleteicon'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(userName, WebUI.getText(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_deleteAccount/lightBox_deleteAccount_userAccountList'),
			FailureHandling.CONTINUE_ON_FAILURE), false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_deleteAccount/button_deleteAccount_delete'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//kendo-grid[@id=\'peopleKendoGrid\']//div//following-sibling::kendo-grid-list//table//td[text()=\'' +
			Firstname) + '\']//preceding-sibling::td[text()=\'') + Lastname) + '\']//preceding-sibling::td//input[@type=\'checkbox\']',
			true)

	WebUI.verifyElementNotPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
} else
{
	WebUI.comment("Get total rows and values from excel for multiple delete")
	for (def rowindex = 1; rowindex < findTestData('Settings-Delete Mutliple accounts').getRowNumbers(); rowindex++) {
		def LastName0 = findTestData('Settings-Delete Mutliple accounts').getValue(1, rowindex)

		def FirstName0 = findTestData('Settings-Delete Mutliple accounts').getValue(2, rowindex)
		def Admin = findTestData('Settings-Delete Mutliple accounts').getValue(5, rowindex)

		if (Admin.toString().toLowerCase() != 'yes') {

			println('LastName' + LastName0)

			println('FirstName' + FirstName0)

			WebUI.setText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_lastName'),
					LastName0, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_lastName'))

			CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

			WebUI.delay(1)



			WebUI.setText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_firstName'),
					FirstName0, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_firstName'))

			CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

			WebUI.delay(1)


			def name = (LastName0 + ', ') + FirstName0

			println(name)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//kendo-grid[@id=\'peopleKendoGrid\']//div//following-sibling::kendo-grid-list//table//td[text()=\'' +
					FirstName0) + '\']//preceding-sibling::td[text()=\'') + LastName0) + '\']//preceding-sibling::td//input[@type=\'checkbox\']',
					true)

			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}


	WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/icon_userAccounts_deleteicon'),
			FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment("Validate the account name on delete lightbox")
	for (def rowindex1 = 1; rowindex1 < findTestData('Settings-Delete Mutliple accounts').getRowNumbers(); rowindex1++) {
		def LastName1 = findTestData('Settings-Delete Mutliple accounts').getValue(1, rowindex1)

		def FirstName1 = findTestData('Settings-Delete Mutliple accounts').getValue(2, rowindex1)
		def Admin1 = findTestData('Settings-Delete Mutliple accounts').getValue(5, rowindex1)

		if (Admin1.toString().toLowerCase() != 'yes') {

			def name = (LastName1 + ', ') + FirstName1

			println(name)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ul[@id=\'userAccountsList\']//li[text()=\'' +
					name) + '\']', true)

			WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_deleteAccount/button_deleteAccount_delete'),
			FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment("Validate deleted accounts on User account table")
	for (def rowindex2 = 1; rowindex2 < findTestData('Settings-Delete Mutliple accounts').getRowNumbers(); rowindex2++) {
		def LastName2 = findTestData('Settings-Delete Mutliple accounts').getValue(1, rowindex2)

		def FirstName2 = findTestData('Settings-Delete Mutliple accounts').getValue(2, rowindex2)
		def Admin = findTestData('Settings-Delete Mutliple accounts').getValue(5, rowindex2)

		if (Admin.toString().toLowerCase() != 'yes') {

			WebUI.setText(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_lastName'), LastName2, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_lastName'))

			CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

			WebUI.delay(1)


			WebUI.setText(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_firstName'), FirstName2, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_firstName'))

			CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

			WebUI.delay(1)


			WebUI.verifyElementPresent(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_deleteAccount/label_deleteAccount_noRecordsAvailable'),
					2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

}

