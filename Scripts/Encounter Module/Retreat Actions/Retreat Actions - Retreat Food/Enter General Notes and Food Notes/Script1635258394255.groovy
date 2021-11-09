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

import org.junit.After
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

WebUI.delay(2)
WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), retreatName, false)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'))
WebUI.delay(2)
def numberofdays=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'), 'value')




println "numberofdays:::"+numberofdays
int days = Integer.parseInt(numberofdays)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Retreat/Retreat Volunteer Page/sidebar/retreatFoodLink'))
WebUI.delay(2)

def foodnotesxpath = "//div[@id='retreatPage']//div[@class='food-notes-container']//textarea"
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> foodnotes = driver.findElements(By.xpath(foodnotesxpath))
def totSfoodnotes = foodnotes.size()
println(totSfoodnotes + ' total notes in the page')

if (days==totSfoodnotes)
{
	for (notescount =1; notescount<=totSfoodnotes;notescount++)
	{
		
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('(.//div[@id=\'retreatPage\']//div[@class=\'food-notes-container\']//textarea)[' + notescount) +
				']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.clearText(dynamicObject)

		WebUI.setText(dynamicObject, (notescount + ' - ') + MeetingFoodNoteBaseText, FailureHandling.CONTINUE_ON_FAILURE)


	}
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatFoodVolunteer/textArea_foodVolunteer_generalNotes'),"General notes entered")
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatFoodVolunteer/button_foodVolunteer_save'))
}
else
	println "Total food notes not matching with retreat days"
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/link_overview_overviewLink'))
WebUI.delay(2)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Retreat/Retreat Volunteer Page/sidebar/retreatFoodLink'))
WebUI.delay(2)
for (notescount1 =1; notescount1<=totSfoodnotes;notescount1++)
{
	def foodnotestext = "Test notes entered "

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('(.//div[@id=\'retreatPage\']//div[@class=\'food-notes-container\']//textarea)[' + notescount1) +
			']', true, FailureHandling.CONTINUE_ON_FAILURE)
	def foodnotestext_textarea =WebUI.getAttribute(dynamicObject,'value')
	println "foodnotestext_textarea::"+foodnotestext_textarea

	if (foodnotestext_textarea.equals(notescount1+" - "+MeetingFoodNoteBaseText))
		println "Notes for food notes " + notescount1 + " matches"
	else
		WebUI.verifyMatch("Notes for food notes " + notescount1 + " does not match", "Error", false, FailureHandling.STOP_ON_FAILURE)


}
def generalnotestext_textarea = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatFoodVolunteer/textArea_foodVolunteer_generalNotes'),'value')
def generalnotestext = "General notes entered"
println "generalnotestext_textarea:::"+generalnotestext_textarea

if (generalnotestext.equals(generalnotestext_textarea))
	println "General notes matches"
else
	WebUI.verifyMatch("General notes does not match" , "Error", false, FailureHandling.STOP_ON_FAILURE)
