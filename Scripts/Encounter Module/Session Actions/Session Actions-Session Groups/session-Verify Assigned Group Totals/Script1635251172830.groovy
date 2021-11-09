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


WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/label__groupAssignment_1groupTableNumberOfParticipants')).substring(14,WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/label__groupAssignment_1groupTableNumberOfParticipants')).length()-1 ), Group1Expected, false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/label__groupAssignment_2groupTableNumberOfParticipants')).substring(14,WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/label__groupAssignment_2groupTableNumberOfParticipants')).length()-1 ), Group2Expected, false)

