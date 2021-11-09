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

WebUI.click(findTestObject('CommonPageObjects/img_common_home'))

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_findPeople'))

WebUI.delay(5)
def filterOptions="Is equal to"
def par1Name = (par1_LastName + ', ') + par1_FirstName

par1_LastName = par1_LastName.trim()

par1_FirstName = par1_FirstName.trim()

def par2Name = (par2_LastName + ', ') + par2_FirstName

par2_LastName = par2_LastName.trim()

par2_FirstName = par2_FirstName.trim()

println('par1Name:::::' + par1Name)

println('par2Name:::::' + par2Name)




//Click on Participant 1 on People page and get values
clickPnParticipantLastName(par1_LastName,filterOptions)

par1_PhoneNumber = WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_phoneNumber'), 
    'value')

par1_EmailAddress = WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_emailAddress'), 
    'value')

if (WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_parish'), 'textContent').equals(
    'Select...')) {
    par1_CurrentChurch = ''
} else {
    par1_CurrentChurch = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_parish'))
}

if ((WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_male'), 
    'checked') || WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_female'), 
    'checked')) || WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_declineToAnswer'), 
    'checked')) {
    if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_male'), 
        'checked')) {
        par1_Gender = 'Male'
    }
    
    if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_female'), 
        'checked')) {
        par1_Gender = 'Female'
    }
    
    if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_declineToAnswer'), 
        'checked')) {
        par1_Gender = 'Decline to Answer'
    }
} else {
    par1_Gender = 'Unspecified'
}

par1_dob=WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_dob'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
par1_dietRestriction=WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_dietaryRestrictions'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
par1_skills=WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_skills'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/icon_addPeople_close'))

WebUI.delay(2)

//Click on Participant 2 on People page and get values
clickPnParticipantLastName(par2_LastName,filterOptions)

par2_PhoneNumber = WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_phoneNumber'), 
    'value')

par2_EmailAddress = WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_emailAddress'), 
    'value')

if (WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_parish'), 'textContent').equals(
    'Select...')) {
    par2_CurrentChurch = ''
} else {
    par2_CurrentChurch = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_parish'))
}

if ((WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_male'), 
    'checked') || WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_female'), 
    'checked')) || WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_declineToAnswer'), 
    'checked')) {
    if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_male'), 
        'checked')) {
        par2_Gender = 'Male'
    }
    
    if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_female'), 
        'checked')) {
        par2_Gender = 'Female'
    }
    
    if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_declineToAnswer'), 
        'checked')) {
        par2_Gender = 'Decline to Answer'
    }
} else {
    par2_Gender = 'Unspecified'
}
par2_dob=WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_dob'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
par2_dietRestriction=WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_dietaryRestrictions'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
par2_skills=WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_skills'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/icon_addPeople_close'))

WebUI.delay(2)

//Merge records lightbox verification
WebUI.click(findTestObject('module_profiles/button_Profiles_mergeRecord'))

WebUI.delay(2)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_mergePeople/dropDown_mergePeople_recordDropDownOne'))

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/input_mergePeople_recordDropDownOne'), par1Name)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//ng-select[@id=\'recordDropDownOne\']//div//span[text()=\'' + 
    par1Name) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_mergePeople/dropDown_mergePeople_recordDropDownTwo'))

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/input_mergePeople_recordDropDownTwo'), par2Name)

WebUI.modifyObjectProperty(dynamicObject1, 'xpath', 'EQUALS', ('//ng-select[@id=\'recordDropDownTwo\']//div//span[text()=\'' + 
    par2Name) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject1, FailureHandling.CONTINUE_ON_FAILURE)

//Select Values on lightbox to merge records



par1_LastName_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_lastNameOneValue'))

par1_FirstName_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_firstNameOneValue'))

par1_EmailAddress_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_emailOneValue'))

par1_PhoneNumber_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_phoneOneValue'))

par1_Gender_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_genderOneValue'))

par1_CurrentChurch_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_parishOneValue'))

//Get Participant2 lightbox values
par2_LastName_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_lastNameTwoValue'))

par2_FirstName_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_firstNameTwoValue'))

par2_EmailAddress_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_emailTwoValue'))

par2_PhoneNumber_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_phoneTwoValue'))

par2_Gender_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_genderTwoValue'))

par2_CurrentChurch_mergerecord = WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_parishTwoValue'))

//Verify values on lightbox with people page values for Participant 1
WebUI.verifyMatch(par1_LastName_mergerecord, par1_LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par1_FirstName_mergerecord, par1_FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par1_EmailAddress_mergerecord, par1_EmailAddress, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par1_PhoneNumber_mergerecord, par1_PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par1_Gender_mergerecord, par1_Gender, false, FailureHandling.CONTINUE_ON_FAILURE)

println('par1_CurrentChurch::::::::' + par1_CurrentChurch)

println('par1_CurrentChurch_mergerecord:::' + par1_CurrentChurch_mergerecord)

WebUI.verifyMatch(par1_CurrentChurch, par1_CurrentChurch_mergerecord, false, FailureHandling.CONTINUE_ON_FAILURE)

//Verify values on lightbox with people page values for Participant 2
WebUI.verifyMatch(par2_LastName_mergerecord, par2_LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par2_FirstName_mergerecord, par2_FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par2_EmailAddress_mergerecord, par2_EmailAddress, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par2_PhoneNumber_mergerecord, par2_PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(par2_Gender_mergerecord, par2_Gender, false, FailureHandling.CONTINUE_ON_FAILURE)

println('par2_CurrentChurch::::::::' + par2_CurrentChurch)

println('par2_CurrentChurch_mergerecord:::' + par2_CurrentChurch_mergerecord)

WebUI.verifyMatch(par2_CurrentChurch, par2_CurrentChurch_mergerecord, false, FailureHandling.CONTINUE_ON_FAILURE)

//Verify if Merge button is enabled and Close icon is available
WebUI.delay(2)

WebUI.verifyElementNotHasAttribute(findTestObject('module_profiles/lightbox_findPeople_mergePeople/button_mergePeople_merge'), 
    'disabled', 2, FailureHandling.CONTINUE_ON_FAILURE)

println('experience1' + experience1)

println(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_experienceOneValue')))

println('experience2' + experience2)

println(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_experienceTwoValue')))

def experience1Match

def experience2Match

if (WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_experienceOneValue'), FailureHandling.CONTINUE_ON_FAILURE).contains(
    experience1)) {
    experience1Match = 'match'
} else {
    experience1Match = 'nomatch'
}

println('experience1Match' + experience1Match)

WebUI.verifyMatch(experience1Match, 'match', false, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_mergePeople/label_mergePeople_experienceTwoValue'), FailureHandling.CONTINUE_ON_FAILURE).contains(
    experience2)) {
    experience2Match = 'match'
} else {
    experience2Match = 'nomatch'
}

'experience2Match' + experience2Match

WebUI.verifyMatch(experience2Match, 'match', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_mergePeople/icon_mergePeople_close'))

def clickPnParticipantLastName(def filterValue,def filterOptions)
{
	WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), filterValue, FailureHandling.CONTINUE_ON_FAILURE)
	
		WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))
		
		CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)
		
		WebUI.delay(1)
		
		CustomKeywords.'customOmegaKeywords.customKeywordsOmega.profilePageFilterValidation'("//kendo-grid[@id='peopleKendoGrid']//td[@aria-colindex='1']", filterOptions, filterValue)
		WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
		
		
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//td//span[text()=\''+filterValue+'\']',
			true)
		
		WebUI.click(dynamicObject)
		
	
}