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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.IFEQ

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Click on Create Form for Grow
WebUI.click(findTestObject('module_formBuilder/button_formBuilder_createNewForm', [('name') : 'growName']))

//Validate Wizard
def fbTitle = 'Create New Form - ' + growName

def fbWizardLabel = WebUI.getText(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/label_fbWizardLightbox_createForm'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(fbWizardLabel, fbTitle, false, FailureHandling.CONTINUE_ON_FAILURE)

//Input Form Details on Wizard
WebUI.setText(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/input_fbWizardLightbox_formName'), 
    formName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_nameNext'))

if (formType == 'Group member registration') {
    WebUI.click(findTestObject('module_formBuilder/FB_Grow/Form Builder Wizard Lightbox - Grow/radio_fbWizardLightbox_groupMemberRegistration'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_purposeNext'), FailureHandling.CONTINUE_ON_FAILURE)
	
	//verifying participant radio button is selected & default selsction is participant
	
	WebUI.verifyElementChecked(findTestObject('module_formBuilder/FB_Grow/Form Builder Wizard Lightbox - Grow/radio_fbWizardLightbox_participants'), 1, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(findTestObject('module_formBuilder/FB_Grow/Form Builder Wizard Lightbox - Grow/dropDowndefault_fbWizardLightbox_participant'), 0, FailureHandling.CONTINUE_ON_FAILURE)
if (participantOrLeader == 'participant') {
	
if (participant !='Participant') {

    WebUI.click(findTestObject('module_formBuilder/FB_Grow/Form Builder Wizard Lightbox - Grow/dropDown_fbWizardLightbox_participant'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/FB_Grow/Form Builder Wizard Lightbox - Grow/dropDownValue_fbWizardLightbox_participant', 
            [('participantRole') : 'participant']), FailureHandling.CONTINUE_ON_FAILURE)
}

}

	WebUI.click(findTestObject('module_formBuilder/FB_Grow/Form Builder Wizard Lightbox - Grow/button_fbWizardLightbox_groupRoleNext'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_continueToForm'), FailureHandling.CONTINUE_ON_FAILURE)
	
}

// sample

