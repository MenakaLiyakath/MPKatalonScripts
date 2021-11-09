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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;




def finalRating=0
def rating
def sessionRatingTotal
def totalRatings=0

def sessionTileXpath="//div[@id='itemHeader']"

WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> sessionTileList = driver.findElements(By.xpath(sessionTileXpath))
def totalSessionTile=sessionTileList.size()
println "totalSessionTile"+totalSessionTile
if(totalSessionTile!=0)
{


	for (i = 0; i < totalSessionTile; i++)
	{
		def sessionTileXpath1="//div[@id='itemHeader']"
		List<WebElement> sessionTileList1 = driver.findElements(By.xpath(sessionTileXpath1))
		sessionTileList1.get(i).click()
		WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
		String sessionEndDate=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'),'value')
		String sessionEndHour=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeHours'),'value')
		String sessionEndMin=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeMinutes'),'value')

		String enddateandtime=sessionEndDate+" "+sessionEndHour+":"+sessionEndMin+":"+"00"




		println "sessionEndDate::"+sessionEndDate

		Date date1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(enddateandtime);

		println "Converted Session End Date"+date1

		Date date = Calendar.getInstance().getTime();

		println "Current Date:::"+date
		println "date::"+date


		if(date1<date)
		{



			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/link_sessionFeedback_sessionFeedback'))
			WebUI.delay(2)

			

			def columnValuesXpath="//div[@id='sessionParticipantFeedbackTableContainer']//tr//td"

			List<WebElement> totalColumnValues = driver.findElements(By.xpath(columnValuesXpath))


			totColumnsSize=totalColumnValues.size()
			println "Total Columns:::"+ totalColumnValues.size()
			def totalFeedback=totColumnsSize/7
			totalRatings=totalRatings+totalFeedback
			println "totalRatings"+totalRatings
			println "Total totalFeedback:::"+totalFeedback
			if(totColumnsSize>0)
			{

				for(int columnIndex=4;columnIndex<totColumnsSize;columnIndex+=7)
				{
					println "columnIndex"+columnIndex
					WebElement columnElement=totalColumnValues.get(columnIndex)
					rating=columnElement.getText()
					println "rating"+rating
					finalRating=finalRating+Integer.parseInt(rating)
				}


			}
			WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
			WebUI.delay(2)


		}
		else
		{
			WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
		}

	}

	println "totalRatings"+totalRatings
	WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_stats'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//td[@id=\'sessionRatingLabel\']//following-sibling::td', true, FailureHandling.CONTINUE_ON_FAILURE)
	sessionRatingTotal=WebUI.getText(dynamicObject)
	println "sessionRatingTotal"+sessionRatingTotal
	String[] sessionRatingTotalFinal=sessionRatingTotal.split(" out")
	println "sessionRatingTotalFinal"+sessionRatingTotalFinal[0]
	def sessionRatingTotalFinalInt=Integer.parseInt(sessionRatingTotalFinal[0])
	println "sessionRatingTotalFinalInt"+sessionRatingTotalFinalInt
	if(totalRatings!=0)
	{
	def ratingToVerify=finalRating/totalRatings
	WebUI.verifyMatch(sessionRatingTotalFinalInt.toString(), ratingToVerify.toString(), false, FailureHandling.CONTINUE_ON_FAILURE)
	}
}