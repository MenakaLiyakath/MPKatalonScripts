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

WebUI.comment('input filter values')

WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), LastName)

WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

WebUI.delay(2)

WebUI.comment('click and open person')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//td//span[text()=\''+LastName+'\']',
		true)

WebUI.click(dynamicObject)

WebUI.delay(2)


WebUI.comment('Navigate to Faith Journey Tab')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_faithJourney'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'container-faith-journey\']//div[@class=\'row current-experience-rows experience-rows\']//a[text()=\''+GroupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_group/tab_group_details/button_group_customizeRegistrationForm'), 2, FailureHandling.CONTINUE_ON_FAILURE)


