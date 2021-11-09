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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/tab_editParticipant_basicInfo'))

WebUI.delay(1)


WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_lastName'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_firstName'), 
    FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_phoneNumber'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_email'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/textarea_editParticipant_skills'), 
    Skills, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_parish'), 
    Church, FailureHandling.CONTINUE_ON_FAILURE)

switch (Gender) {
    case 'Male':
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_male'))

        break
    case 'Female':
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_female'))

        break
    case 'Decline to Answer':
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_declineToAnswer'))
}

if (PreferredContactMethodEmail != '') {
    if (PreferredContactMethodEmail == 'Yes') {
		
		
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_email'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodText != '') {
    if (PreferredContactMethodText == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_text'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodPhoneCall != '') {
    if (PreferredContactMethodPhoneCall == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_phoneCall'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (DateOfBirthYear != '') {
    WebUI.clearText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_dateOfbirth'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/button_editParticipant_dateOfBirthButton'), 
        FailureHandling.CONTINUE_ON_FAILURE)
	
	
	//Calendar plugin Implementation starts here- card 768
	int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DateOfBirthMonth)

	CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/calendar_editParticipant_dob'),
			DateOfBirthDay.toInteger(), dobMonthInt, DateOfBirthYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE)
	//Calendar plugin Implementation Ends here- card 768

/*    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/select_editParticipant_year'), 
        DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/select_editParticipant_month'), 
        DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

    daySelection = new TestObject('daySelection')

    daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' + DateOfBirthDay) + 
        '\']', true)

    WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)*/
}

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/tab_editParticipant_journeyPoints'))

WebUI.delay(2)

if (Retreat != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/select_editParticipant_experience'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//span[@class=\'ng-option-label\'][text()=\'' + 
        Retreat) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}



if (AdditionalComments != '') {
    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/textarea_editParticipant_comments'), 
        AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Spirituality != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_spirituality'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_spirituality'), 
        Spirituality, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/select_editParticipant_spirituality'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}



if(ConfirmAttending=='Yes')
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_yes'))
}

if(ConfirmAttending=='No')
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_no'))
}
if(ConfirmAttending=='Maybe')
{
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_maybe'))
}
if((ConfirmAttending=='No Reply')||(ConfirmAttending==''))
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_noReply'))
	ConfirmAttending=''
}

WebUI.delay(2)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/button_editParticipant_save'), 
    FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tr[@id=\'participantsTableHeaderRow\']//following::tr[@class=\'retreat-participant-row\']//td[text()=\''+LastName+'\']//following::td[text()=\''+FirstName+'\']//following::td[text()=\''+Email+'\']//following::td[text()=\''+ConfirmAttending+'\']',
	true, FailureHandling.CONTINUE_ON_FAILURE)



WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)