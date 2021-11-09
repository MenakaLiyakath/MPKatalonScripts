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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.math.RoundingMode;
import java.text.DecimalFormat;




//sessiontype
//def totSess_ManageSession = WebUI.getNumberOfTotalOption(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'))

def totalRatings=0
def ratings=0
def sessionTileXpath="//div[@id='itemHeader']"

WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> sessionTileList = driver.findElements(By.xpath(sessionTileXpath))
def totalSessionTile=sessionTileList.size()
println "totalSessionTile"+totalSessionTile
if(totalSessionTile!=0)
{


	for (i = 0; i < totalSessionTile-1; i++)
	{
		def sessionTileXpath1="//div[@id='itemHeader']"
		List<WebElement> sessionTileList1 = driver.findElements(By.xpath(sessionTileXpath1))
		sessionTileList1.get(i).click()
for (i = 1; i < totSess_ManageSession; i++) {
    WebUI.selectOptionByIndex(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), 
        i)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))

    def sessiontypeonsessionpage = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select_sessionOverview_sessionTypes'), 
        'textContent').replaceAll('×', '')

    println('sessiontype::::::::::::' + SessType)

    println('sessiontypeonsessionpage::' + sessiontypeonsessionpage)

    def sessionpage = sessiontypeonsessionpage.toString()

    def sessionvar = SessType.toString()

    if (sessionvar.equalsIgnoreCase(sessionpage)) {
        String sessionEndDate = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'), 
            'value')

        String sessionEndHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeHours'), 
            'value')

        String sessionEndMin = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeMinutes'), 
            'value')

        String enddateandtime = (((((sessionEndDate + ' ') + sessionEndHour) + ':') + sessionEndMin) + ':') + '00'

        println('sessionEndDate::' + sessionEndDate)

        Date date1 = new SimpleDateFormat('yyyy-MM-dd hh:mm:ss').parse(enddateandtime)

        println('Converted Session End Date' + date1)

        Date date = Calendar.getInstance().getTime()

        println('Current Date:::' + date)

        println('date::' + date)

        if (date1 < date) {
            
//Navigate to Feedback and take count of ratings and sum of rating values
			
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/link_sessionFeedback_sessionFeedback'))
			WebUI.delay(2)
	
			WebDriver driver = DriverFactory.getWebDriver()
	
			def columnValuesXpath="//div[@id='sessionParticipantFeedbackTableContainer']//tr//td"
	
			List<WebElement> totalColumnValues = driver.findElements(By.xpath(columnValuesXpath))
			
			totColumnsSize=totalColumnValues.size()
			println "Total Columns:::"+ totalColumnValues.size()
			def totalFeedback=totColumnsSize/7
			totalRatings=totalRatings+totalFeedback
			
			if(totColumnsSize>0)
			{
	
				for(int columnIndex=4;columnIndex<totColumnsSize;columnIndex+=7)
				{
					println "columnIndex"+columnIndex
					WebElement columnElement=totalColumnValues.get(columnIndex)
					rating=columnElement.getText()
					println "rating"+rating
					ratings=ratings+Integer.parseInt(rating)
				}
	
			
			}
			
				 
        }
        
        WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
    } else {
        WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
    }
}
	}}
println "ratings"+ratings
WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_stats'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Select session type from dropdown
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionTypeDropdown\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

println "SessType"+SessType
WebUI.modifyObjectProperty(dynamicObject,'xpath' , 'equals','//ng-select[@id=\'sessionTypeDropdown\']//span[@class=\'ng-option-label\'][text()=\''+SessType+'\']' , true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//td[@id=\'sessionRatingLabel\']//following-sibling::td', true, FailureHandling.CONTINUE_ON_FAILURE)
sessionRatingTotal=WebUI.getText(dynamicObject)
println "sessionRatingTotal"+sessionRatingTotal
String[] sessionRatingTotalFinal=sessionRatingTotal.split(" out")
println "sessionRatingTotalFinal"+sessionRatingTotalFinal[0]
def sessionRatingTotalFinalInt=sessionRatingTotalFinal[0]
println "sessionRatingTotalFinalInt"+sessionRatingTotalFinal[0]
def ratingToVerify=ratings/totalRatings
println "ratingToVerify"+ratingToVerify
//Round the rating to 2 decimal 
DecimalFormat df = new DecimalFormat("###.##")
def ratingToVerifyRoundValue=df.format(ratingToVerify)

println "ratingToVerifyRoundValue"+ratingToVerifyRoundValue
WebUI.verifyMatch(ratingToVerifyRoundValue.toString(), sessionRatingTotalFinalInt,false, FailureHandling.CONTINUE_ON_FAILURE)
