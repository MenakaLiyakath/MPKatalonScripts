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
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import java.awt.Desktop

WebUI.comment("Navigate to Members tab for a selected group")
//Navigate to Members tab for a selected group
WebUI.delay(2)
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment("Add people icon on page is clicked no people data exist else Add peple icon on header is clicked")
//Add people icon on page is clicked no people data exist else Add peple icon on header is clicked
WebUI.click(findTestObject('module_grow/page_group/tab_group_members/button_groupMembers_addPeopleOnTabHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment("Changes for Card#335 starts here")
//Changes for Card#335 starts here
WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/input_addPeople_lastName'), LastName,
		FailureHandling.CONTINUE_ON_FAILURE)

def name=LastName+", "+FirstName
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//span[contains(@id,\'lastAndFirstNameLabel\')][text()=\''+name+'\']//span[text()=\' - Current Member\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 0, FailureHandling.CONTINUE_ON_FAILURE)

