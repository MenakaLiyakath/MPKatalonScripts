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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Click on Created members')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'divGrowGroupMembersContainer\']//tr//td[text()=\'' +FirstName) + '\']//preceding-sibling::td//span[text()=\'') + LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.comment('Validate Basic Info Tab')


def lastNameOnBasicInfo = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_lastName'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(lastNameOnBasicInfo, LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

if (FirstName != '') {
	def firstNameOnBasicInfo = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_firstName'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(firstNameOnBasicInfo, FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)
}

def phoneOnBasicInfo = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_phoneNumber'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

if (Phone != '') {
	if (!(Phone.substring(0, 1) == '(')) {
		Phone = ((((('(' + Phone.substring(0, 3)) + ') ') + Phone.substring(3, 6)) + '-') + Phone.substring(6))
	}

	WebUI.verifyMatch(phoneOnBasicInfo, Phone, false, FailureHandling.CONTINUE_ON_FAILURE)
}

def emailBasicInfo = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_emailAddress'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(emailBasicInfo, Email, false, FailureHandling.CONTINUE_ON_FAILURE)

def dobOnBasicInfo = WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_dob'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

/*if(dobOnBasicInfo!="")
{
	println "dobOnBasicInfo"+dobOnBasicInfo
	int dobDateInteger=Integer.parseInt(DOBDate)
	println "dobDateInteger"+dobDateInteger

	if (dobDateInteger < 10) {
		DOBDate = ('0' + DOBDate)
	}

	println "DOBDate"+DOBDate

	def month = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.dobMonthConversion'(DOBMonth)

	DOBMonth = month.toString()

	def finalDOB = (((DOBMonth + '-') + DOBDate) + '-') + DOBYear

	println "finalDOB"+finalDOB

	WebUI.verifyMatch(dobOnBasicInfo, finalDOB, false, FailureHandling.CONTINUE_ON_FAILURE)
}
*/
if (Parish != 'Parish') {
	def parishOnBasicinfo = WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/input_basicInfo_parish'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(Parish, parishOnBasicinfo, false, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.comment('Gender Validation')

if (Gender == 'Male') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/radio_basicInfor_male'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Gender == 'Female') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/radio_basicInfor_female'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Gender == 'Decline') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/radio_basicInfor_declineToAnswer'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.comment('Prefferred contact validation')

if (PreferredCommunication == 'Email') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactEmail'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredCommunication == 'Text') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactText'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredCommunication == 'Phone') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContacPhone'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredCommunication == 'All') {
	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactEmail'),
			1, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContactText'),
			1, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMember_basicInfoTab/checkBox_basicInfo_preferedContacPhone'),
			1, FailureHandling.CONTINUE_ON_FAILURE)
}




WebUI.comment('Navigate to Faith Journey Tab')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_faithJourney'), FailureHandling.CONTINUE_ON_FAILURE)

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
LocalDateTime now = LocalDateTime.now()
println "Curr"+dtf.format(now)

def currentDateString=dtf.format(now).toString()

println "currentDateString"+currentDateString
def timeframeDate=currentDateString+" - Ongoing"

println "timeframeDate"+timeframeDate
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'container-faith-journey\']//div[@class=\'row current-experience-rows experience-rows\']//a[text()=\''+GroupName+'\']//ancestor::div[@class=\'row current-experience-rows experience-rows\']//div[text()=\'Member\']//ancestor::div[@class=\'row current-experience-rows experience-rows\']//div//span[text()=\''+timeframeDate+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Navigate to Journey points Tab')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_journeyPoints'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/dropdown_journeyPoints_experience'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'experience-dropdown\']//div//span[@class=\'ng-option-label\'][text()=\''+GroupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

def keyGroupNameOnJourneyPoints=WebUI.getText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/label_journeyPoints_keyDetailGroupName'), FailureHandling.CONTINUE_ON_FAILURE)
//def keyGroupNameOnJourneyPoints=WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/label_journeyPoints_keyDetailGroupName'), focusOnDetails, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(keyGroupNameOnJourneyPoints, GroupName, false, FailureHandling.CONTINUE_ON_FAILURE)
/*if(focusOnDetails!='')
{
	def keyFocusOnJourneyPoints=WebUI.getText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/label_journeyPoints_keyDetailFocus'), FailureHandling.CONTINUE_ON_FAILURE)
	//def keyFocusOnJourneyPoints=WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/label_journeyPoints_keyDetailFocus'), focusOnDetails, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(keyFocusOnJourneyPoints, focusOnDetails, false, FailureHandling.CONTINUE_ON_FAILURE)
}*/


WebUI.verifyElementChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/radio_journeyPoints_active'), 1, FailureHandling.CONTINUE_ON_FAILURE)

if(Role!="")
{
	def roleOnJourneyPoints=WebUI.getText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/input_journeyPoints_role'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(roleOnJourneyPoints, Role, false, FailureHandling.CONTINUE_ON_FAILURE)
}
if(PrimaryContact!='')
{
	if(PrimaryContact=='Yes')
		WebUI.verifyElementChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/checkBox_journeyPoints_primaryContact'), 1, FailureHandling.CONTINUE_ON_FAILURE)
	else
		WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/checkBox_journeyPoints_primaryContact'), 0, FailureHandling.CONTINUE_ON_FAILURE)

}

def commentsOnJourneyPoints=WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMember_journeyPoints/textArea_journeyPoints_comments'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_basicInfo'), FailureHandling.CONTINUE_ON_FAILURE)



