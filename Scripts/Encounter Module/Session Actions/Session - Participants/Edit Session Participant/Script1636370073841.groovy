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





WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/input_sessionVolunteer_lastName'),
	LastName)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/kendoFilter_sessionVolunteer_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

WebUI.delay(1)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/input_sessionVolunteer_firstName'),
	FirstName)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/kendoFilter_sessionVolunteer_firstName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

WebUI.delay(1)

WebUI.comment('click and open person')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//kendo-grid[@id=\'participantsGrid\']//table[@class=\'k-grid-table\']//td[text()=\'' +
	FirstName) + '\']//ancestor::table[@class=\'k-grid-table\']//td//span[text()=\'') + LastName) + '\']', true)

WebUI.click(dynamicObject)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_basicInfo'))

WebUI.delay(1)


WebUI.verifyElementHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_email'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)
if(religiousAffiliation!='')
{
if(WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/dropDown_addParticipant_religiousAffiliation'), 0, FailureHandling.CONTINUE_ON_FAILURE))
{
WebUI.click((findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/dropDown_addParticipant_religiousAffiliation')), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'religious-affiliation-input\']//ng-dropdown-panel//div//span[text()=\''+religiousAffiliation+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject)
}
}

//christian faith 


			if (ChristianFaith != '') {
				WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'terms-of-christian-faith-input\']//input', true, FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.setText(dynamicObject, ChristianFaith, FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'terms-of-christian-faith-input\']//ng-dropdown-panel//div//span', true, FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		
			}
	
	

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_skills'), 
    Skills, FailureHandling.CONTINUE_ON_FAILURE)


switch (Gender) {
    case 'Male':
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_male'))

        break
    case 'Female':
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_female'))

        break
    case 'Decline to Answer':
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_declineToAnswer'))
}
if ((PreferredContactMethodEmail != ''))
{
if  (PreferredContactMethodEmail == 'Yes') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_preferredContactEmail'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}
}

if((PreferredContactMethodText != ''))
{
if  (PreferredContactMethodText.toString().toLowerCase() == 'yes') 

{
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/checkBox__editProfile_preferredContactText'), 
        FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	
	WebUI.comment("Changes for Card 801 starts here")
		
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_mobileCarrier'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'mobile-carrier-input\']//div//span[@class=\'ng-option-label\'][text()=\''+MobileCarrier+'\']',
		true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		if(MobileCarrier =='Other-NotListed')
		{
			
			
			WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_otherCarrier'), 2, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_otherCarrier'), OtherCarrier, FailureHandling.CONTINUE_ON_FAILURE)
				}
		WebUI.comment("Changes for Card 801 ends here")
	

}
}

if ((PreferredContactMethodPhoneCall != ''))
{
if  (PreferredContactMethodPhoneCall == 'Yes')

{
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_preferredContactPhoneCall'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}
 }

if (DateOfBirthYear != '') {

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_dateOfBirth'),
		FailureHandling.CONTINUE_ON_FAILURE)
	

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_selectYear'), 
        DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_selectMonth'), 
        DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

    daySelection = new TestObject('daySelection')

    daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' + DateOfBirthDay) + 
        '\']', true)

    WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
if(Church!='')
{
	WebUI.setText( findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_parish'), Church, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_journeyPoints'))

WebUI.delay(2)

if (Session != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_experience'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//span[@class=\'ng-option-label\'][text()=\'' + 
        Session) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

if (HaveAttended != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_participantAttended'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@class=\'row form-group\']//label[@id=\'participant-alpha-attended-label\']/following-sibling::div//ng-select//span[@class=\'ng-option-label\'][text()=\'' + 
        HaveAttended) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}



WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div//input[@id=\'participant-child-care-request-input\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.clearText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_childCareRequest'),
	'placeholder', FailureHandling.CONTINUE_ON_FAILURE), '# of children, ages of children', false, FailureHandling.CONTINUE_ON_FAILURE)

if (Childcare != '') {
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_childCareRequest'),
		Childcare, FailureHandling.CONTINUE_ON_FAILURE)
}

	if (RefSource != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/dropDown_addParticipant_referenceSource'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_referenceSourceDropdown'),
				RefSource)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//*[@id=\'referenceSourceDropdown\']//div//span[@class=\'ng-option-label\']', true)

		WebUI.click(dynamicObject)
	}

if (SeatingConnection != '') {
    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_seatWith'), 
        SeatingConnection, FailureHandling.CONTINUE_ON_FAILURE)
}

if (AdditionalComments != '') {
    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_comments'), 
        AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Spirituality != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_spirituality'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_spirituality'), 
        Spirituality, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_spirituality', 
            [('selectSpirituality') : Spirituality]), FailureHandling.CONTINUE_ON_FAILURE)
}

println('Age' + Age)

if (Age != '') {
    println('Age' + Age)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_participantAge'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_participantAge'), 
        Age, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/span_editProfile_participantAgeOption', 
            [('ageRange') : Age]), FailureHandling.CONTINUE_ON_FAILURE)
}


WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

