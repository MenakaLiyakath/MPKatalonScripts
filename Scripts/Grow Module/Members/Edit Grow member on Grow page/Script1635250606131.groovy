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
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.Month as Month
import java.time.Period as Period

WebUI.comment(' Basic Info Tab')

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_lastName'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

if (FirstName != '') {
    WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_firstName'), 
        FirstName, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Phone != '') {
    WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_phoneNumber'), 
        Phone, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Email != '') {
    WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_emailAddress'), 
        Email, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Parish != 'Parish') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/dropDown_basicInfo_currentChruchParish'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id = \'parish\']//div//span[@class=\'ng-option-label\'][text()=\'' + 
        Parish) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Gender == 'Male') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/radio_basicInfor_male'))
}

if (Gender == 'Female') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/radio_basicInfor_female'))
}

if (Gender == 'Decline') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/radio_basicInfor_declineToAnswer'))
}

if (PreferredCommunication == 'Email') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactEmail'))
}

/*if (PreferredCommunication == 'Text') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactText'))
}*/

if (PreferredCommunication == 'Phone') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContacPhone'))
}

if (PreferredCommunication == 'All') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactEmail'))

    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactText'))

    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContacPhone'))
}

WebUI.comment('Journey points Tab')

/*if(personActive=='Inactive')
WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/radio_journeyPoints_inActive'), FailureHandling.CONTINUE_ON_FAILURE)
*/

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_journeyPoints'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/dropdown_journeyPoints_experience'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//div//span[@class=\'ng-option-label\'][text()=\'' + 
    GroupName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

if (PrimaryContact != '') {
    if (PrimaryContact == 'Yes') {
        WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/checkBox_journeyPoints_primaryContact'))
    }
}

/*if (DOBYear != '')
{
	

	WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_dateOfBirth'), FailureHandling.CONTINUE_ON_FAILURE)


	//Calendar plugin Implementation starts here- card 768
	int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DOBMonth)

	CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/calendar_addPeople_dob'),
			DOBDate.toInteger(), dobMonthInt, DOBYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE)
	//Calendar plugin Implementation Ends here- card 768

}
*/

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/textArea_journeyPoints_comments'), 
    Comments, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(4)
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/button_basicInfo_save'))

