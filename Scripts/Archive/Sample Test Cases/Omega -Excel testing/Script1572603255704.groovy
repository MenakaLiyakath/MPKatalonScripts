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

//String excelVerificationStepsFile = 'Data Files\\VerificationStepsFileOmega.xlsx'
String excelVerificationStepsFile = 'Data Files\\VerificationStepsFileOmega.dat'

String excelSortTableFile = 'Data Files\\sortTableFileOmega.xls'


// Create two files

ExcelKeywords.createExcelFile(excelVerificationStepsFile)

ExcelKeywords.createExcelFile(excelSortTableFile)

// Verify files are created

File excelVerificationStepsFile1 = new File(excelVerificationStepsFile)

File excelSortTableFile1 = new File(excelSortTableFile)

assert excelVerificationStepsFile1.exists() == true


assert excelSortTableFile1.exists() == true



// Create some new sheets for excelVerificationStepsFile

verificationStepsWorkbook = ExcelKeywords.getWorkbook(excelVerificationStepsFile)

ExcelKeywords.createExcelSheet(verificationStepsWorkbook) // Create default sheet

ExcelKeywords.createExcelSheets(verificationStepsWorkbook,['verificationSteps']) // Create list of sheets with name

ExcelKeywords.saveWorkbook(excelVerificationStepsFile, verificationStepsWorkbook)

// Create a new sheet for File02

sortTableworkbook = ExcelKeywords.getWorkbook(excelSortTableFile)

ExcelKeywords.createExcelSheet(sortTableworkbook) // Create a sheet with name

ExcelKeywords.createExcelSheets(sortTableworkbook,['E1-SessParCTK1'])

ExcelKeywords.saveWorkbook(excelSortTableFile, sortTableworkbook)


// Write some data to File01Sheet01 in excelVerificationStepsFile

verificationStepsWorkbook1=ExcelKeywords.getWorkbook(excelVerificationStepsFile)
verificationSheet01=ExcelKeywords.getExcelSheet(verificationStepsWorkbook1, 'verificationSteps')
ExcelKeywords.setValueToCellByIndex(verificationSheet01, 0, 0, 'dataFileName')
ExcelKeywords.setValueToCellByIndex(verificationSheet01, 0, 1, 'xpathOfTable')
ExcelKeywords.setValueToCellByIndex(verificationSheet01, 0, 2, 'numberOfSkipRows')
ExcelKeywords.setValueToCellByIndex(verificationSheet01, 1, 0, 'E1-SessParCTK1')
ExcelKeywords.setValueToCellByIndex(verificationSheet01, 1, 1, '//div[@id=\'participantsTable\']//table')
ExcelKeywords.setValueToCellByIndex(verificationSheet01, 1, 2, '1')

// Save data of File01

ExcelKeywords.saveWorkbook(excelVerificationStepsFile, verificationStepsWorkbook1)
