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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Click on Create Form for Encounter/Grow
//WebUI.click(findTestObject('module_formBuilder/button_formBuilder_createNewForm', [('name') : 'sessionName']))
//WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals',//span[@id='group-header-name' and text()="${name}"]//following-sibling::span//button[@id='create-new'], true)
//WebUI.click(dynamicObject)
//Validate Wizard
println(sessionName)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//span[@id=\'group-header-name\' and text()=\'' + sessionName) + 
    '\']//following-sibling::span//button[@id=\'create-new\']', true)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

def fbTitle = 'Create New Form - ' + sessionName

def fbWizardLabel = WebUI.getText(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/label_fbWizardLightbox_createForm'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(fbWizardLabel, fbTitle, false, FailureHandling.CONTINUE_ON_FAILURE)

//Input Form Details on Wizard
WebUI.setText(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/input_fbWizardLightbox_formName'), 
    formName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_nameNext'))

if (formType == 'Volunteer') {
    WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/radio_fbWizardLightbox_volunteerRegistration'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    //Select Role for Volunteer
    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_purposeNext'), FailureHandling.CONTINUE_ON_FAILURE)

    if (volPrimaryRole != '') {
        WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/dropDown_fbWizardLightbox_primaryRole'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/dropDownValue_fbWizardLightbox_primaryRole', 
                [('primaryRole') : volPrimaryRole]))
    }
    
    if (volSecondaryRole != '') {
        WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/dropDown_fbWizardLightbox_secondaryRole'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/dropDownValue_fbWizardLightbox_secondaryRole', 
                [('secondaryRole') : volSecondaryRole]))
    }
    
    WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/button_fbWizardLightbox_rolePurposeNext'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_continueToForm'), FailureHandling.CONTINUE_ON_FAILURE)
} else if (formType == 'Participant') {
    WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/radio_fbWizardLightbox_participantRegistration'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_purposeNext'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_continueToForm'), FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/radio_fbWizardLightbox_sessionFeedback'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_purposeNext'), FailureHandling.CONTINUE_ON_FAILURE)

    if (feedBackAnonymous == 'yes') {
        WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/radio_fbWizardLightbox_feedbackAnonymousYes'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/radio_fbWizardLightbox_feedbackAnonymousNo'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('module_formBuilder/FB_Session/Form Builder Wizard Lightbox - Session/button_fbWizardLightbox_feedbackNext'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_formBuilder/button_fbWizardLightbox_continueToForm'), FailureHandling.CONTINUE_ON_FAILURE)
}

