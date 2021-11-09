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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

//Navigate to Members tab for a selected group
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)

//Add people icon on page is clicked no people data exist else Add peple icon on header is clicked
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/button_groupMembers_addPeopleOnTabHeader'), FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.comment('Check for duplicate values on field')

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), 
    'Peop', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Verify if create new and similar records spans are displayed')

WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_similarRecordsFound'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_createNewRecord'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Split the total similar records and convert it to integer')

def similarRecordText = WebUI.getText(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_similarRecordsFound'), 
    FailureHandling.CONTINUE_ON_FAILURE)

String[] splitArray = similarRecordText.split('\\(')

def totalSimilarRecords1 = splitArray[1]

String[] splitArray1 = totalSimilarRecords1.split('\\)')

def totalSimilarRecords2 = splitArray1[0]

def totalSimilarRecordFinal = totalSimilarRecords2

WebUI.comment('Get the total count of options in last name dropdown and validate it against the total similar records')

WebDriver driver = DriverFactory.getWebDriver()

def similairOptionsXpath = '//ng-select[@id=\'last-name\']//div[@class=\'ng-option\']//span'

List<WebElement> similairOptions = driver.findElements(By.xpath(similairOptionsXpath))

def totSimilarRecordObjects = similairOptions.size() - 1

println('totSimilarRecordObjects' + totSimilarRecordObjects)

WebUI.verifyMatch(totalSimilarRecordFinal, totSimilarRecordObjects.toString(), false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Create New /Select existing')

WebUI.comment('Create New')

//WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_createNewRecord'),FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('changes for card 282')
WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), 
    LastName,FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_createNewRecord'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_firstName'), 
   FirstName,FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_phoneNumber'), 
    Phone, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_email'), 
    Email,FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndAddNew'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),
	LastName,FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_createNewRecord'),2, FailureHandling.CONTINUE_ON_FAILURE)
	


WebUI.delay(2)

WebUI.comment('Select Existing Similair records')

WebUI.comment('From other Grow Group')

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),'Peop', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'last-name\']//div//span[contains(text(),\'PeopleLname1\')]', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_existingPersonNote'), 
    2)

WebUI.comment('Validate all member related fields are disabled and non member fields are editable')

WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_clearFields'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_firstName'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_phoneNumber'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_dateOfBirth'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_male'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_feMale'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_declineToAnswer'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredEmail'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredtext'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredPhonecall'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_primaryContact'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/textarea_addPeople_comments'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/select_addPeople_role'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Enter value in editable field')

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_primaryContact'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/textarea_addPeople_comments'), 
    'Test Comment', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Clear fields and validate all field values are set to default')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_clearFields'))

WebUI.delay(1)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_firstName'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_firstName'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_phoneNumber'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_phoneNumber'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_email'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_male'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_male'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_feMale'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_feMale'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_declineToAnswer'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/radio_addPeople_declineToAnswer'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredEmail'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredEmail'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredtext'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredtext'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/checkBox_addPeople_preferredPhonecall'), 
    2)

/*WebUI.comment('Select Existing Similair records from Session participant')

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),'par', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'last-name\']//div//span[contains(text(),\'Participantlast-10\')]',
	true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndAddNew'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Select Existing Similair records from Session volunteer')

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),'vol', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'last-name\']//div//span[contains(text(),\'volunteer1\')]',
	true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndAddNew'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Select Existing Similair records from Retreat participant')

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),'retreat', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'last-name\']//div//span[contains(text(),\'retreatparticipant\')]',
	true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndAddNew'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Select Existing Similair records from Retreat volunteer')

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'),'vol', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'last-name\']//div//span[contains(text(),\'volret\')]',
	true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndAddNew'),
	FailureHandling.CONTINUE_ON_FAILURE)
*/
WebUI.comment('Select similar record and save and close')

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), 
    'Peop', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'last-name\']//div//span[contains(text(),\'PeopleLname1\')]', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/select_addPeople_role'))

def Role = 'Leader'

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'growGroupRole\']//span[text()=\'' + Role) + 
    '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/button_addPeople_saveAndClose'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Validated added members exist on Table')



//WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'leadershipKendoGrid\']//kendo-grid-list//table//td//span[text()=\''+TestParticipantLname+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'leadershipKendoGrid\']//kendo-grid-list//table//td//span[text()=\''+LastName+'\']', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

