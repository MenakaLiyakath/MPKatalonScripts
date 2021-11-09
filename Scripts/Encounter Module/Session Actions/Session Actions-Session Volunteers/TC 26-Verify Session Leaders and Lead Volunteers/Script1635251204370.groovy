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

WebUI.waitForElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeader(s)'), 0)
if((PrimaryRole=='Session Leader')||(SecondaryRole=='Session Leader'))
{
'Session Leaders'

def name=FirstName+" "+LastName
def sesleadFlag='0'
if(!(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeader(s)')).contains(name)))
sesleadFlag=1
WebUI.verifyMatch(sesleadFlag,'0',true,FailureHandling.CONTINUE_ON_FAILURE) 
}

'Lead Volunteers'
if((PrimaryRole=='Lead Volunteer')||(SecondaryRole=='Lead Volunteer'))
{


def name=FirstName+" "+LastName
def leadvolFlag='0'
if(!(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeaderText')).contains(name)))
{
leadvolFlag=1
WebUI.verifyMatch(leadvolFlag,'0',true,FailureHandling.CONTINUE_ON_FAILURE)
}
}
