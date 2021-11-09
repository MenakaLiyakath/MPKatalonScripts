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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Open Browser and navigate to URL
//Prasanna committed changes

WebUI.openBrowser(GlobalVariable.globalLoginUrl)

println('userName' + userName)

println('password' + password)

WebUI.maximizeWindow(FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.setText(findTestObject('page_login/input_login_email'), userName)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), password)

WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

//Navigate to Retreat tab and create a new retreat
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),
		FailureHandling.CONTINUE_ON_FAILURE)

if(WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/Retreat_tile_size_check'), 5, FailureHandling.CONTINUE_ON_FAILURE))
{
	//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/Retreat_tile_size_check'), FailureHandling.CONTINUE_ON_FAILURE)	
	WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/Retreat_tile_size_check'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment('true')
} else {
	WebUI.comment('No Retreat is available to click')
	return
}

//Retreat registration link implementation
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_retreatOverview_customizeRegistrationForms'), FailureHandling.CONTINUE_ON_FAILURE)
	

//Verifying the retreat customize participant registration lightbox and the values.
if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreat_customizeRegForm'), 10, FailureHandling.CONTINUE_ON_FAILURE)) {
	//
		WebUI.comment('text verification block')
	if (WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/button_retreatcustomizeForm_update'), FailureHandling.CONTINUE_ON_FAILURE)) {
		
		if (ChildCareRequestDisplay == 'yes') {
			println ('ChildCareRequired' + ChildCareRequired)
				if(ChildCareRequired == 'yes'){
					WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired'), FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.comment('Child care request checked successfully')
				} else {
						WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_childcarerequestDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.comment('Toggling done successfully')
					}
		} else {
					WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_childcarerequestDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
					//WebUI.waitForElementNotClickable('Object Repository/module_encounter(SessionOrRetreat)/module_retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired', 10,true, FailureHandling.CONTINUE_ON_FAILURE)
					//WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
					//WebUI.verifyElementNotVisible('Object Repository/module_encounter(SessionOrRetreat)/module_retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired', FailureHandling.CONTINUE_ON_FAILURE)
					//WebUI.verifyElementNotClickable('Object Repository/module_encounter(SessionOrRetreat)/module_retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired', FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.comment('Toggling done successfully')
		}
		
		if(DietaryRestrictionsDisplay == 'yes'){
			println('DietaryRestrictions Required ' + DietaryRestrictionsRequired)
					if(DietaryRestrictionsRequired == 'yes') {
						WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatdietaryrestrictionsRequired'), FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.comment('Dietary Restrictions checked successfully')
					} else {
						WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_dietaryrestrictionsDisplay'), FailureHandling.CONTINUE_ON_FAILURE)WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.comment('Toggling done successfully')
					}
			} else {
					WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_dietaryrestrictionsDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.comment('Dietary restrictions toggling done successfully')
			}
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/button_retreatcustomizeForm_update'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.comment('Customize Retreat Registration Form updated successfully')
	} else {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/button_retreatcustomizeForm_close'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.comment('close block')
	}
	
} else {
		WebUI.comment('Customize Retreat Participant Registration Form lightbox is FAILED to display')
		return
	}
	WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)
	
if (WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'), FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.comment('Save button is in disabled state')
} else {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.comment('Save button click is successful')
	}

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
