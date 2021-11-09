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



public class calculateTotalParticipantsandVolunteers {

	@Keyword
	//Method to calculate total participant in session
	def calculateParticipant() {
		def stattotalparticipant = 0

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'))

		if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'), 2, FailureHandling.OPTIONAL)) {
			def splitduplicatenotif = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'))

			String[] split1Array = splitduplicatenotif.split('for ')

			def splitedString = split1Array[1]

			println('splitedString::::' + splitedString)

			String[] split1Array1 = splitedString.split(' ')

			def totDuplicatetext = split1Array1[0]

			println('totDuplicatetext::' + totDuplicatetext)

			int totduplicate = Integer.parseInt(totDuplicatetext)
			WebUI.delay(2)

			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'))

			def duplicaterows = '//table[@class=\'table\']//tbody//tr'

			WebDriver driver = DriverFactory.getWebDriver()

			List<WebElement> duplicateRow = driver.findElements(By.xpath(duplicaterows))

			def totDuplicate = duplicateRow.size()
			WebUI.delay(2)

			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'))

			def finalDuplicateTotal = totDuplicate - totduplicate

			println('finalDuplicateTotal:::' + finalDuplicateTotal)

			def mainParticiXpath = '//div[@id=\'participantsTable\']//tr[@class=\'participant-row\']'

			List<WebElement> participantsList = driver.findElements(By.xpath(mainParticiXpath))

			def totParticipantmain = participantsList.size()

			println('totParticipantmain:::::' + totParticipantmain)

			def totSessionParticipant = finalDuplicateTotal + totParticipantmain

			println('totSessionParticipant::::::::' + totSessionParticipant)

			stattotalparticipant = (stattotalparticipant + totSessionParticipant)
		} else {
			def mainParticiXpath = '//div[@id=\'participantsTable\']//tr[@class=\'participant-row\']'

			WebDriver driver = DriverFactory.getWebDriver()

			List<WebElement> participantsList = driver.findElements(By.xpath(mainParticiXpath))

			def totParticipantmain = participantsList.size()

			println('totParticipantmain:::::' + totParticipantmain)

			stattotalparticipant = (stattotalparticipant + totParticipantmain)
		}

		//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'), FailureHandling.CONTINUE_ON_FAILURE)
		return stattotalparticipant
	}


	@Keyword

	//Method to calculate total volunteers in session

	def calculateVolunteer() {
		def stattotalVolunteer = 0



		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

		WebUI.delay(2)

		if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/label_sessionVolunteer_duplicateNotification'), 2, FailureHandling.OPTIONAL)) {
			def splitduplicatenotif = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/label_sessionVolunteer_duplicateNotification'))

			String[] split1Array = splitduplicatenotif.split('for ')

			def splitedString = split1Array[1]

			println('splitedString::::' + splitedString)

			String[] split1Array1 = splitedString.split(' ')

			def totDuplicatetext = split1Array1[0]

			println('totDuplicatetext::' + totDuplicatetext)

			int totduplicate = Integer.parseInt(totDuplicatetext)
			WebUI.delay(2)

			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_resolve'))

			def duplicaterows = '//table[@class=\'table\']//tbody//tr'

			WebDriver driver = DriverFactory.getWebDriver()

			List<WebElement> duplicateRow = driver.findElements(By.xpath(duplicaterows))

			def totDuplicate = duplicateRow.size()

			WebUI.delay(2)
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_duplicateVolunteer/button_duplicateVolunteer_close'))

			def finalDuplicateTotal = totDuplicate - totduplicate

			println('finalDuplicateTotal:::' + finalDuplicateTotal)

			def mainVolunteerXpath = '//table[@id=\'volunteersTable\']//tr[@class=\'volunteer-row\']'

			List<WebElement> VolunteersList = driver.findElements(By.xpath(mainVolunteerXpath))

			def totVolunteermain = VolunteersList.size()

			println('totVolunteermain:::::' + totVolunteermain)

			def totSessionVolunteer = finalDuplicateTotal + totVolunteermain

			println('totSessionVolunteer::::::::' + totSessionVolunteer)

			stattotalVolunteer = (stattotalVolunteer + totSessionVolunteer)
		} else {
			def mainVolunteerXpath = '//table[@id=\'volunteersTable\']//tr[@class=\'volunteer-row\']'

			WebDriver driver = DriverFactory.getWebDriver()

			List<WebElement> VolunteersList = driver.findElements(By.xpath(mainVolunteerXpath))

			def totVolunteermain = VolunteersList.size()

			println('totVolunteermain:::::' + totVolunteermain)

			stattotalVolunteer = (stattotalVolunteer + totVolunteermain)
		}
		//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'), FailureHandling.CONTINUE_ON_FAILURE)
		return stattotalVolunteer
	}
}
