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
import java.io.File as File
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

//Navigate to members tab
WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)

/*
 String excelFile01 = 'Data Files\\File01.xlsx'
 // Create file
 ExcelKeywords.createExcelFile(excelFile01)
 // Verify file is created
 File file1 = new File(excelFile01)
 assert file1.exists() == true
 // Create some new sheets for File01
 workbook01 = ExcelKeywords.getWorkbook(excelFile01)
 ExcelKeywords.createExcelSheet(workbook01 // Create default sheet
 )
 ExcelKeywords.createExcelSheets(workbook01, ['File01Sheet01', 'File01Sheet02' // Create list of sheets with name
 ])
 ExcelKeywords.saveWorkbook(excelFile01, workbook01)
 // Verify sheets created
 String[] ExpectedListSheetFile1 = ['Sheet0', 'Sheet1', 'File01Sheet01', 'File01Sheet02']
 workbookFile01 = ExcelKeywords.getWorkbook(excelFile01)
 assert ExcelKeywords.getSheetNames(workbookFile01) == ExpectedListSheetFile1
 // Write some data to File01Sheet01 in File01
 workbook01 = ExcelKeywords.getWorkbook(excelFile01)
 sheet01 = ExcelKeywords.getExcelSheet(workbook01, 'File01Sheet01')
 ExcelKeywords.setValueToCellByIndex(sheet01, 0, 0, 'Email')
 ExcelKeywords.setValueToCellByIndex(sheet01, 1, 0, 'PeopleLname1@menlo.com')
 ExcelKeywords.setValueToCellByIndex(sheet01, 2, 0, 'PeopleLname2@menlo.com')
 ExcelKeywords.setValueToCellByIndex(sheet01, 3, 0, 'PeopleLname3@menlo.com')
 ExcelKeywords.setValueToCellByIndex(sheet01, 0, 1, 'Phone')
 ExcelKeywords.setValueToCellByIndex(sheet01, 1, 1, '7347778891')
 ExcelKeywords.setValueToCellByIndex(sheet01, 2, 1, '7347778892')
 ExcelKeywords.setValueToCellByIndex(sheet01, 3, 1, '7347778893')
 // Save data of File01
 ExcelKeywords.saveWorkbook(excelFile01, workbook01)
 // Read data from File01
 workbook01 = ExcelKeywords.getWorkbook(excelFile01)
 sheet01 = ExcelKeywords.getExcelSheet(workbook01, 'File01Sheet01')
 def email1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 0)
 def email2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 0)
 def email3 = ExcelKeywords.getCellValueByIndex(sheet01, 3, 0)
 def phone1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 1)
 def PhoneNumber1 = (((('(' + phone1.substring(0, 3)) + ') ') + phone1.substring(3, 6)) + '-') + phone1.substring(6)
 def phone2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 1)
 def PhoneNumber2 = (((('(' + phone2.substring(0, 3)) + ') ') + phone2.substring(3, 6)) + '-') + phone2.substring(6)
 def phone3 = ExcelKeywords.getCellValueByIndex(sheet01, 3, 1)
 def PhoneNumber3 = (((('(' + phone3.substring(0, 3)) + ') ') + phone3.substring(3, 6)) + '-') + phone3.substring(6)
 println(email1)
 println(email2)
 println(email3)
 println(phone1)
 println(phone2)
 println(phone3)
 println PhoneNumber1
 println PhoneNumber2
 println PhoneNumber3*/
def email1 = findTestData('Grow-People').getValue(5, 1)

def email2 = findTestData('Grow-People').getValue(5, 2)

def email3 = findTestData('Grow-People').getValue(5, 3)

println('email1' + email1)

println('email2' + email2)

println('email3' + email3)

WebUI.verifyElementNotClickable(findTestObject('Object Repository/module_grow/page_group/tab_group_members/button_members_email'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'leadershipKendoGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'leadershipKendoGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'leadershipKendoGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/module_grow/page_group/tab_group_members/button_members_email'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/button_members_email'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'More\')]',
		true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' +
		email1) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' +
		email2) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' +
		email3) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_communication/input_communicationEmail_subject'),
		'Test Email', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_communication/input_communication_body'),
		'Email communication testing', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_communication/button_communication_send'),
		FailureHandling.CONTINUE_ON_FAILURE)

//Uncheck all checkboxes
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'leadershipKendoGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'leadershipKendoGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'leadershipKendoGrid\']//table[@class=\'k-grid-table\']//tbody//tr//td[text()=\'' +
		email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

