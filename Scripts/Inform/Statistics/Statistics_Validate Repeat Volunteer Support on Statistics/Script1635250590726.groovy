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

WebUI.comment("Adding the Existing Volunteer")
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_quickAdd'),
	FailureHandling.CONTINUE_ON_FAILURE)

for (def rowindex = 1; rowindex <= findTestData('RepeatVolunteerSupport').getRowNumbers(); rowindex++) {
	def LastName = findTestData('RepeatVolunteerSupport').getValue(1, rowindex)
	def FirstName = findTestData('RepeatVolunteerSupport').getValue(2, rowindex)
def name = (LastName + ', ') + FirstName
println name

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_lastName'),
   LastName, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'lastNameInput\']//div//span[text()=\'' +  name) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/button_createProfile_saveAndAddNew'),
	FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.comment("Close lightbox after adding volunteers")
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/icon_createProfile_close'), FailureHandling.CONTINUE_ON_FAILURE)


def globalizedVolunteerCountDetails=GlobalVariable.globalizedVolunteerCount
println "globalizedVolunteerCountDetails"+globalizedVolunteerCountDetails
def totalRepeatedVolunteer=findTestData('RepeatVolunteerSupport').getRowNumbers()

println "totalRepeatedVolunteers"+totalRepeatedVolunteer
def totalVolunteers1=globalizedVolunteerCountDetails
println "totalVolunteers1"+totalVolunteers1
WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/CommonPageObjects/page_home/button_homepage_stats'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.comment("Percentage Calculation for Repeat Volunteer Support")
def RepeatvolunteerPercentageValue= (totalRepeatedVolunteer/totalVolunteers1)*100
def RepeatedvolunteerPercentage=Math.round(RepeatvolunteerPercentageValue)
println "volunteerPercentage"+RepeatedvolunteerPercentage
def RepeatVolunteerSupportText= totalRepeatedVolunteer+" of "+totalVolunteers1+" volunteers, "+RepeatedvolunteerPercentage+"% of total volunteers"
WebUI.comment("Validating the Repeat Volunteer Support in statistics")
println "Repeat Volunteer SupportText" +RepeatVolunteerSupportText

WebUI.verifyMatch(RepeatVolunteerSupportText,WebUI.getText(findTestObject('Object Repository/module_inform/label_inform_repeatVolunteerSupport'), FailureHandling.CONTINUE_ON_FAILURE), false, FailureHandling.CONTINUE_ON_FAILURE)






