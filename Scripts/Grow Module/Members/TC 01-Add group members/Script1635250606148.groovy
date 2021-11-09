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

//Navigate to Members tab for a selected group
WebUI.delay(2)
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)

//Add people icon on page is clicked no people data exist else Add peple icon on header is clicked 

    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/button_groupMembers_addPeopleOnTabHeader'), FailureHandling.CONTINUE_ON_FAILURE)

//Add member informations on Add people lightbox and Save
	if(Role!='')
	{

		if(Role!='Participant')
	{
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/select_addPeople_role'))

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'growGroupRole\']//span[text()=\'' + Role) + 
    '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	}
	}
	
	
	WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), FailureHandling.CONTINUE_ON_FAILURE)
		
WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), LastName, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_firstName'), FirstName, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_phoneNumber'), Phone, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_email'), Email, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_dateOfBirth'))

WebUI.delay(2)

/*WebUI.selectOptionByLabel(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/select_addPeople_month'), 
    DOBMonth, false)

WebUI.selectOptionByLabel(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/select_addPeople_year'), 
    DOBYear, false)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_dobDay', [('day') : 'DOBDate']), 
    FailureHandling.CONTINUE_ON_FAILURE)*/

if (Gender == 'Male') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_male'), FailureHandling.CONTINUE_ON_FAILURE)
}

if (Gender == 'Female') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_feMale'), FailureHandling.CONTINUE_ON_FAILURE)
}

if ((Gender == 'Decline') || (Gender == '')) {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_declineToAnswer'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredCommunication == 'Email') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredEmail'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredCommunication == 'Text') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredtext'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredCommunication == 'Phone') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredPhonecall'), 
        FailureHandling.CONTINUE_ON_FAILURE)
	
	
}

if (PreferredCommunication == 'All') {
	WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredPhonecall'),
		FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredtext'),
		FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredEmail'),
		FailureHandling.CONTINUE_ON_FAILURE)
}

if (PrimaryContact == 'Yes') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_primaryContact'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

/*if (DOBYear != '')
{
	

	WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_dateOfBirth'), FailureHandling.CONTINUE_ON_FAILURE)


	//Calendar plugin Implementation starts here- card 768
	int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DOBMonth)

	CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/calendar_addPeople_dob'),
			DOBDate.toInteger(), dobMonthInt, DOBYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE)
	//Calendar plugin Implementation Ends here- card 768

}*/


WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/textarea_addPeople_comments'), Comments, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

