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

import java.awt.print.Printable
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject




/*
 def totSess_ManageSession = WebUI.getNumberOfTotalOption(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'))
 for (sessioncount = 1; sessioncount < totSess_ManageSession; sessioncount++)
 {
 WebUI.selectOptionByIndex(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), sessioncount)
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))
 WebUI.delay(2)
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFood'))
 WebUI.delay(1)
 */
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodResponsibility/checkbox_foodResponsibility_select'))

WebDriver driver = DriverFactory.getWebDriver()

def xpath="//tr[@id='volunteer-row']//input[@type='checkbox']"


List<WebElement> foodvolunteerCheckboxList = driver.findElements(By.xpath(xpath))

def foodvolunteerCheckbox_size = foodvolunteerCheckboxList.size()



if(foodvolunteerCheckbox_size>0)
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodResponsibility/button_foodResponsibility_foodResponsibilities'))
	def responsibilityXpath="//textarea[starts-with(@id, 'responsibility-input-')]"
	def meetingsXpath="//input[starts-with(@id, 'meeting-input-')]"
	def notesXpath="//textarea[starts-with(@id, 'notes-input-')]"
	List<WebElement> responsibilityList = driver.findElements(By.xpath(responsibilityXpath))
	List<WebElement> meetingsList = driver.findElements(By.xpath(meetingsXpath))
	List<WebElement> notesList = driver.findElements(By.xpath(notesXpath))

	println "responsibility text area total  "+responsibilityList.size()
	println "Meeting text area total  "+meetingsList.size()
	println "Notes text area total  "+notesList.size()

	WebUI.delay(3)
	for(i=0;i<foodvolunteerCheckbox_size;i++)
	{
		responsibilityList.get(i).clear()
		meetingsList.get(i).clear()
		notesList.get(i).clear()
		responsibilityList.get(i).sendKeys("responsibility  "+i)
		meetingsList.get(i).sendKeys("meeting  "+i)
		notesList.get(i).sendKeys("note  "+i)

	}
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/lightbox_sessionFood_foodResponsibility/button_foodResponsibility_save'))
	WebUI.delay(2)
	

}

/*}*/