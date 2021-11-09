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

if (filterColumn == 'Last Name') {
    WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), filterValue, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))
	
    CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)
	
	WebUI.delay(1)
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.profilePageFilterValidation'("//kendo-grid[@id='peopleKendoGrid']//td[@aria-colindex='1']", filterOptions, filterValue)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_clear'))
}

if (filterColumn == 'First Name') {
    WebUI.setText(findTestObject('module_profiles/input_profiles_firstName'), filterValue, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_firstName'))

    CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)
	WebUI.delay(1)
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.profilePageFilterValidation'("//kendo-grid[@id='peopleKendoGrid']//td[@aria-colindex='2']", filterOptions, filterValue)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_clear'))
}

if (filterColumn == 'Email Address') {
    WebUI.setText(findTestObject('module_profiles/input_profiles_emailAddress'), filterValue, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_email'))

    CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)
	WebUI.delay(1)
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.profilePageFilterValidation'("//kendo-grid[@id='peopleKendoGrid']//td[@aria-colindex='3']", filterOptions, filterValue)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_clear'))
}

if (filterColumn == 'Phone Number') {
    WebUI.setText(findTestObject('module_profiles/input_profiles_phoneNumber'), filterValue, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_phoneNumber'))

    CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)
	WebUI.delay(1)
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.profilePageFilterValidation'("//kendo-grid[@id='peopleKendoGrid']//td[@aria-colindex='4']", filterOptions, filterValue)

    WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_clear'))
}



