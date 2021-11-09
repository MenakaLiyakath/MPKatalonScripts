package verificationFunctions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement


import internal.GlobalVariable

public class attendanceCheckboxValidation {

	@Keyword

	def checkboxValidation(def dynamicObject) {

		WebDriver driver = DriverFactory.getWebDriver()
		def selectAllparticipantchkboxXpath = "//table[@id='individualAttendanceTable']//input[@class='selectAllForParticipant']"
		def selectAllmeetingchkboxXpath = "//table[@id='individualAttendanceTable']//input[@class='selectAllForMeeting']"

		List<WebElement> allParticipantChkbox = driver.findElements(By.xpath(selectAllparticipantchkboxXpath))
		List<WebElement> allMeetingChkbox = driver.findElements(By.xpath(selectAllmeetingchkboxXpath))

		int totParticipantandVolunteer = allParticipantChkbox.size()
		int totMeetingforSession = allMeetingChkbox.size()

		println "Total Participant and volunteer"+totParticipantandVolunteer
		println "Total Meeting"+totMeetingforSession


		int meetingCount=1

		while(meetingCount<=totMeetingforSession) {
			int totMeeting=0
			for(int participantCount=0;participantCount<totParticipantandVolunteer-1;participantCount++) {
				def xpathID="attendee"+participantCount+"-"+meetingCount

				WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//table[@id=\'individualAttendanceTable\']//input[@id=\''+xpathID+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

				if(WebUI.getAttribute(dynamicObject, 'checked',  FailureHandling.CONTINUE_ON_FAILURE)=='true')

					totMeeting=totMeeting+1
			}
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//tr[contains(@class,\'total-row\')]//td[contains(@class,\'meeting-cell\')])['+meetingCount+']', true, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.verifyMatch(WebUI.getText(dynamicObject), totMeeting.toString(), false, FailureHandling.CONTINUE_ON_FAILURE)
			meetingCount=meetingCount+1
		}
	}
}