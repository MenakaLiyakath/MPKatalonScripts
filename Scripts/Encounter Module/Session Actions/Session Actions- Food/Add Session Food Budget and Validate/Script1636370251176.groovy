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

def totalSessionParticipant = CustomKeywords.'verificationFunctions.calculateTotalParticipantsandVolunteers.calculateParticipant'()

/*WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'), 
 FailureHandling.CONTINUE_ON_FAILURE)*/

def totalSessionVolunteer = CustomKeywords.'verificationFunctions.calculateTotalParticipantsandVolunteers.calculateVolunteer'()

println('totalSessionParticipant' + totalSessionParticipant)

println('totalSessionVolunteer' + totalSessionVolunteer)

def expectedProjected = totalSessionParticipant + totalSessionVolunteer

println('expectedProjected' + expectedProjected)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionOverview'))

WebUI.delay(1)

SessionMeetingNumber = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_numberOfMeetings'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFood'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/button_foodBudget_editFoodBudget'))

WebUI.delay(1)

WebDriver driver = DriverFactory.getWebDriver()

def meetingXpath = '//tr//td[contains(@id,\'meeting-\')]'

List<WebElement> meetingsOnBudget = driver.findElements(By.xpath(meetingXpath))

def totalMeetings = meetingsOnBudget.size()

println('totalMeetings' + totalMeetings)

println('SessionMeetingNumber' + SessionMeetingNumber)

WebUI.verifyMatch(totalMeetings.toString(), SessionMeetingNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/icon_foodBudget_closeIcon'))

def budgetValue = 0

def totalBudgetValue = 0

def actualValue = 1

def totalActualValue = 0

for (def meetingNumber = 0; meetingNumber < totalMeetings; meetingNumber++) {
	println('meetingNumber' + meetingNumber)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/button_foodBudget_editFoodBudget'))

	//Validate the Projected value  - Card#765 changes
	if (meetingNumber == 0) {
		WebUI.delay(2)

		def projectedCompleteText = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/label_foodBudget_projected'),
				FailureHandling.CONTINUE_ON_FAILURE)

		//def projectedCompleteText=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/label_foodBudget_projected'),'innerText', FailureHandling.CONTINUE_ON_FAILURE)
		println('projectedCompleteText' + projectedCompleteText)

		String[] projectedCompleteTextSplitArray = projectedCompleteText.split('\\: ')

		def projectedCompleteTextSplited = projectedCompleteTextSplitArray[1]

		String[] projectedCompleteTextSplitArray1 = projectedCompleteTextSplited.split(' ')

		def actualProjectedValue = projectedCompleteTextSplitArray1[0]

		WebUI.verifyMatch(actualProjectedValue, expectedProjected.toString(), false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	// Card#765 changes Ends here
	println('budgetValue' + budgetValue)

	println('totalBudgetValue' + totalBudgetValue)

	//Input budget value and actual value
	budgetValue = (budgetValue + 10)

	totalBudgetValue = (totalBudgetValue + budgetValue)

	println('budgetValue' + budgetValue)

	actualValue = (actualValue * 2)

	totalActualValue = (totalActualValue + actualValue)

	println('actualValue' + actualValue)

	def xpathOfPlannedBudget = 'planned-budget-input-' + meetingNumber

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//td//span/following-sibling::input[@id=\'' + xpathOfPlannedBudget) +
			'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(1)
	WebUI.setText(dynamicObject, budgetValue.toString(), FailureHandling.CONTINUE_ON_FAILURE)

	def xpathOfActualSpent = 'actual-spent-input-' + meetingNumber

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//td//span/following-sibling::input[@id=\'' + xpathOfActualSpent) +
			'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(1)
	WebUI.setText(dynamicObject, actualValue.toString(), FailureHandling.CONTINUE_ON_FAILURE)

	def differenceString

	if (budgetValue == actualValue) {
		difference = (budgetValue - actualValue)

		differenceString = '$ 0.00'
	}

	if (budgetValue < actualValue) {

		def xpathOfFoodDifferenceColor = 'foodBudgetDifferenceColor' + meetingNumber

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//td//span[@class=\'budgetDifference over-food-budget-text\'][@id=\'' + xpathOfFoodDifferenceColor) + '\']',
				true, FailureHandling.CONTINUE_ON_FAILURE)

		def finalBudgetMeeting = WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		println "finalBudgetMeeting"+finalBudgetMeeting

		difference = (actualValue - budgetValue)

		differenceString = (('-$ ' + difference.toString()) + '.00')
	}

	if (actualValue < budgetValue) {

		def xpathOfFoodDifferenceColor = 'foodBudgetDifferenceColor' + meetingNumber

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//td//span[@class=\'budgetDifference under-food-budget-text\'][@id=\'' + xpathOfFoodDifferenceColor) + '\']',
				true, FailureHandling.CONTINUE_ON_FAILURE)

		def finalBudgetMeeting = WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		println "finalBudgetMeeting"+finalBudgetMeeting

		difference = (budgetValue - actualValue)

		differenceString = (('$ ' + difference.toString()) + '.00')
	}

	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), differenceString, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/button_foodBudget_save'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2)

	//Validate Attendance
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

	WebUI.delay(1)

	def meetingAttendanceXpath = '//table[@id=\'total-attendance\']//tr[@class=\'total-row\']//td[@class=\'meeting-cell\']'

	List<WebElement> meetingAttendanceLabel = driver.findElements(By.xpath(meetingAttendanceXpath))

	def meetingAttendance = meetingAttendanceLabel.get(meetingNumber).getText()

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFood'))

	WebUI.delay(2)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/button_foodBudget_editFoodBudget'))

	WebUI.delay(1)

	println('meetingNumber' + meetingNumber)

	def xpathOfActualAttendance = 'actual-att-' + meetingNumber

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//td[@id=\'' + xpathOfActualAttendance) + '\']', true,
			FailureHandling.CONTINUE_ON_FAILURE)

	println('meetingAttendance on attendance page' + meetingAttendance)

	println('attendance on lightbox' + WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE))

	def attendanceOnFoodBudgetLightbox = WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	if (attendanceOnFoodBudgetLightbox == '') {
		attendanceOnFoodBudgetLightbox = '0'
	}

	WebUI.verifyMatch(attendanceOnFoodBudgetLightbox, meetingAttendance, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/icon_foodBudget_closeIcon'))
}

WebUI.delay(2)

//Validate the Final Total budget and Actual budget. Verify the Over and Under budget with color of the status bar
def differenceFinal

def differenceFinalString

if (totalBudgetValue > totalActualValue) {
	differenceFinal = (totalBudgetValue - totalActualValue)

	differenceFinalString = (('$' + differenceFinal.toString()) + '.00  under budget')

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'foodBudgetStatusText\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), differenceFinalString, false, FailureHandling.CONTINUE_ON_FAILURE)
}
if (totalActualValue < totalBudgetValue) {
	differenceFinal = (totalActualValue - totalBudgetValue)

	differenceFinalString = (('-$' + differenceFinal.toString()) + '.00   over budget')

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'foodBudgetStatusText\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), differenceFinalString, false, FailureHandling.CONTINUE_ON_FAILURE)
}

def totalBudgetOnPlan = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/label_foodBudget_totalBudget'),
		FailureHandling.CONTINUE_ON_FAILURE)

String[] splitTotalBudgetNumberFromString = totalBudgetOnPlan.split(' ')

def splittedBudgetNumber = splitTotalBudgetNumberFromString[2]

WebUI.verifyMatch(splittedBudgetNumber, totalBudgetValue.toString() + '.00', false, FailureHandling.CONTINUE_ON_FAILURE)

def actualOnPlan = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodBudget/label_foodBudget_amountSpent'),
		FailureHandling.CONTINUE_ON_FAILURE)

String[] splitTotalActualNumberFromString = actualOnPlan.split(' ')

def splittedActualNumber = splitTotalActualNumberFromString[1]

WebUI.verifyMatch(splittedActualNumber, totalActualValue.toString() + '.00', false, FailureHandling.CONTINUE_ON_FAILURE)

