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


WebUI.comment('Validate the account details on user account table')

WebUI.comment('input filter values')

WebUI.delay(2)
WebUI.setText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_lastName'),
		LastName)

WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

WebUI.delay(2)

WebUI.setText(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoInput_userAccounts_firstName'),
		FirstName)

WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/kendoFilter_userAccounts_firstName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

WebUI.delay(2)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//tr//td)[6]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE),Admin, false, FailureHandling.CONTINUE_ON_FAILURE)



def accessValueEncounter
def accessValueModule

if (EncounterAccess != '') {
	
	switch (EncounterAccess.toString().toLowerCase()) {
		case 'r':
			accessValueEncounter='Read Only'

			break
		case 'rw':
			accessValueEncounter = 'Read/Write'

			break
		case 'rwc':
			accessValueEncounter = 'Read/Write/Create'
			break
	}
}
else
	accessValueEncounter='None'

if (GrowModuleAccess != '') {

	switch (GrowModuleAccess.toString().toLowerCase()) {
		case 'r':
			accessValueModule='Read Only'

			break
		case 'rw':
			accessValueModule = 'Read/Write'

			break
		case 'rwc':
			accessValueModule = 'Read/Write/Create'
			break
	}
}
else
	accessValueModule='None'
	
	if(Admin.toString().toLowerCase()=='yes')
	{
		accessValueModule = 'Read/Write/Create'
		accessValueEncounter = 'Read/Write/Create'
		
	}

WebUI.delay(2)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//tr//td)[7]', true, FailureHandling.CONTINUE_ON_FAILURE)

println "WebUI.getText(dynamicObject)"+WebUI.getText(dynamicObject)

WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE),accessValueEncounter, false, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//tr//td)[8]', true, FailureHandling.CONTINUE_ON_FAILURE)
println "WebUI.getText(dynamicObject)"+WebUI.getText(dynamicObject)

WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE),accessValueModule, false, FailureHandling.CONTINUE_ON_FAILURE)

