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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

/* Connect to QA DB */
CustomKeywords.'cKDbActions.dbActions.connectDB'()

/* Clear QA DB tables */
//Clear tables for public schema
CustomKeywords.'cKDbActions.dbActions.executeTruncateDatabaseTablesQuery'()

//Clear tables for grow schema
CustomKeywords.'cKDbActions.dbActions.executeTruncateDatabaseGrowTablesQuery'()

//Create organization and insert Shani details to org and person/HH tables
CustomKeywords.'cKDbActions.dbActions.createMenloOrg'()

CustomKeywords.'cKDbActions.dbActions.personHHInsert'()

CustomKeywords.'cKDbActions.dbActions.insertUserAssociation'()

//Add default Session and Grow types
/*
 * CustomKeywords.'cKDbActions.dbActions.updateSessionOrg'()
 * CustomKeywords.'cKDbActions.dbActions.updateRetreatOrg'()
 */
/* Close connection for QA DB */
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()

