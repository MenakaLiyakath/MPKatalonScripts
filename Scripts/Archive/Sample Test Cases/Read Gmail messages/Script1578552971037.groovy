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


CustomKeywords.'com.testwithhari.katalon.plugins.Gmail.readLatestEMailBodyContent'('qa.rdwrcr@gmail.com', 'Menlo#123', 'Inbox')

/*String gmailContent=CustomKeywords.'com.testwithhari.katalon.plugins.Gmail.readLatestEMailBodyContent'('qa.rdwrcr@gmail.com', 'Menlo#123', 'Inbox')

println "gmailContent"+gmailContent

String[] gmailContentSplit = gmailContent.split('Temporary Password  ')

			def gmailSplitedString = gmailContentSplit[0]

			println('gmailSplitedString::::' + gmailSplitedString)

			String[] gmailContentSplit1 = gmailSplitedString.split('Login Here Click here to begin')

			def splitPassword = gmailContentSplit1[0]

			println('splitPassword::' + splitPassword)*/