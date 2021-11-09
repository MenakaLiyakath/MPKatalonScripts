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

WebUI.click(findTestObject('module_grow/page_people/button_people_addPeople'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/dropdown_addPeople_group'))
if(GroupName!='')

{

	if(IsGroupActive.toString().toLowerCase()=='yes')
	{
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id = \'growGroupName\']//div//span[@class=\'ng-option-label\'][text()=\''+GroupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
		if(WebUI.verifyElementPresent(dynamicObject, 0, FailureHandling.CONTINUE_ON_FAILURE))
		{
			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

			if (Role != '') {
				if (Role != 'Participant') {
					WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/dropdown_addPeople_role'))

					WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'growGroupRole\']//span[text()=\'' +
							Role) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

					WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
				}
			}

			WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/input_addPeople_lastName'), FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.setText(findTestObject('module_grow/page_people/lightbox_people_addPeople/input_addPeople_lastName'), LastName, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.setText(findTestObject('module_grow/page_people/lightbox_people_addPeople/input_addPeople_firstName'), FirstName,
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.setText(findTestObject('module_grow/page_people/lightbox_people_addPeople/input_addPeople_phone'), Phone, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.setText(findTestObject('module_grow/page_people/lightbox_people_addPeople/input_addPeople_email'), Email, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.delay(2)

			if (Gender == 'Male') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/radio_addPeople_male'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			if (Gender == 'Female') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/radio_addPeople_feMale'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			if ((Gender == 'Decline') || (Gender == '')) {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/radio_addPeople_declineToAnswer'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			if (PreferredCommunication == 'Email') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_preferredEmail'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			if (PreferredCommunication == 'Text') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_preferredtext'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			if (PreferredCommunication == 'Phone') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_preferredPhonecall'),
						FailureHandling.CONTINUE_ON_FAILURE)
			}

			if (PreferredCommunication == 'All') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_preferredPhonecall'),
						FailureHandling.CONTINUE_ON_FAILURE)

				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_preferredtext'), FailureHandling.CONTINUE_ON_FAILURE)

				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_preferredEmail'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			if (PrimaryContact == 'Yes') {
				WebUI.click(findTestObject('module_grow/page_people/lightbox_people_addPeople/checkBox_addPeople_primaryContact'), FailureHandling.CONTINUE_ON_FAILURE)
			}

			WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndClose'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

		}
		else
		{
			
			WebUI.click(findTestObject('Object Repository/module_grow/page_people/lightbox_people_addPeople/icon_addPeople_close'), FailureHandling.CONTINUE_ON_FAILURE)
			
		}

	}
	else
	{
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id = \'growGroupName\']//div//span[@class=\'ng-option-label\'][text()=\''+GroupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementNotPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/module_grow/page_people/lightbox_people_addPeople/icon_addPeople_close'), FailureHandling.CONTINUE_ON_FAILURE)
	}
}



