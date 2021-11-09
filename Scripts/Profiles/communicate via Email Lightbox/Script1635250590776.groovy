import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

def iconDisplay=WebUI.getAttribute(findTestObject('module_profiles/button_Profiles_email'), disabled, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(iconDisplay, "true", false, FailureHandling.CONTINUE_ON_FAILURE)



for (def rowindex = 1; rowindex <= findTestData('People').getRowNumbers(); rowindex++) {
	def LastName = findTestData('People').getValue(6, rowindex)
	def FirstName = findTestData('People').getValue(7, rowindex)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','//kendo-grid[@id=\'peopleKendoGrid\']//tbody//td[text()=\''+FirstName+'\']//preceding-sibling::td//span[text()=\''+LastName+'\']//ancestor::td//preceding-sibling::td//input[@type=\'checkbox\']', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.click(findTestObject('module_profiles/button_Profiles_email'), FailureHandling.CONTINUE_ON_FAILURE)
//validatio for Email

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','//tag-input[@id=\'to-address\']//div[contains(text(),more )]' , true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		
	for (def rowindex1 = 1; rowindex1 <= findTestData('People').getRowNumbers(); rowindex1++)
	 {
		def Email = findTestData('People').getValue(8, rowindex1)
	
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\''+Email+'\')]',true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)
	 }




