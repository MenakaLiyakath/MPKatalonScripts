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


 String[] splitAttendance=Attendance.split(",")
 def splitarraySize=splitAttendance.size()
 for(int arrayIndexcnt=0;arrayIndexcnt<splitarraySize;arrayIndexcnt++)
 {
	 def xPathindex=arrayIndexcnt+1
	 def xPathindexString=xPathindex.toString()
	 if(splitAttendance[arrayIndexcnt]=="yes")
	 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','(//table[@id=\'individualAttendanceTable\']//td[text()=\''+LastName+'\']/ancestor::tr//td[text()=\''+FirstName+'\']/ancestor::tr//td[text()=\''+participantOrVolunteer+'\']/ancestor::tr//td[@class=\'individual-attendance-cell\']//input)['+xPathindexString+']',true, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.click(dynamicObject)
 }

 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/button_sessionsAttendance_save'))
 WebUI.delay(2)