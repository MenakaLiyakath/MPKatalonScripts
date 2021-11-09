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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.delay(1)

def sessionTileXpath="//div[@id='itemHeader']"

WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> sessionTileList = driver.findElements(By.xpath(sessionTileXpath))
def totalSessionTile=sessionTileList.size()
if(totalSessionTile!=0)
{


for (i = 1; i < totalSessionTile; i++)
{
	sessionTileList.get(i).click()

    WebUI.delay(2)

    String sessionEndDate = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'), 
        'value')

    String sessionEndHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeHours'), 
        'value')

    String sessionEndMin = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeMinutes'), 
        'value')

    String enddateandtime = (((((sessionEndDate + ' ') + sessionEndHour) + ':') + sessionEndMin) + ':') + '00'

    println('enddateandtime::' + enddateandtime)

    Date date1 = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss.SSSSSS').parse(enddateandtime)

    println('Converted Session End Date' + date1)

    Date date = Calendar.getInstance().getTime()

    println('Current Date:::' + date)

    println('date::' + date)

    if (date1 < date) {
        numberofSessionsHeld_AllSessionType = (numberofSessionsHeld_AllSessionType + 1)

        sessiontype_sessionoverview = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionTypes'))

        println('numberofSessionsHeld_AllSessionType:' + numberofSessionsHeld_AllSessionType)

        println('sessiontype_sessionoverview:::::' + sessiontype_sessionoverview)

        switch (sessiontype_sessionoverview) {
            case 'ACTS Retreat':
                println('Session type:ACTS Retreat ')

                ACTSRetreat_totalsession = (ACTSRetreat_totalsession + 1)

                ACTSRetreat_totalparticipant = (calculateParticipant() + ACTSRetreat_totalparticipant)

                //***************************************
                WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

                WebUI.delay(2)

                WebDriver driver = DriverFactory.getWebDriver()

                def checkboxXpath = '//td[@class=\'body-cell align-middle grow\'][text()=\'Participant\']/following-sibling::td//input'

                List<WebElement> totalCheckBoxpersession = driver.findElements(By.xpath(checkboxXpath))

                println('Total Checkboxes:::' + totalCheckBoxpersession.size())

                totcheckbox = totalCheckBoxpersession.size()

                totalCheckACTS = totcheckbox

                //finaltotalcheckbox=finaltotalcheckbox+totcheckbox
                totchecked = 0

                for (def checked = 0; checked < totalCheckBoxpersession.size(); checked++) {
                    def checkedprop = totalCheckBoxpersession.get(checked).getAttribute('checked')

                    if (checkedprop == 'true') {
                        totchecked = (totchecked + 1)
                    }
                }
                
                //***************************************
                totalCheckACTS = (totalCheckACTS + totcheckbox)

                totalCheckedACTS = (totalCheckedACTS + totchecked)

                println('totalCheckACTS:::' + totalCheckACTS)

                println('totalCheckedACTS:::' + totalCheckedACTS)

                if ((totalCheckACTS > 0) && (totalCheckedACTS > 0)) {
                    ACTSRetreat_attendancepercent = ((totalCheckedACTS / totalCheckACTS) * 100)

                    ACTSpercent = Math.round(ACTSRetreat_attendancepercent)

                    println('ACTS percent::::' + ACTSpercent)
                }
                
                break
            case 'Alpha':
                println('Session type:Alpha ')

                Alpha_totalsession = (Alpha_totalsession + 1)

                Alpha_totalparticipant = (calculateParticipant() + Alpha_totalparticipant)

                /*	def totalCheckAlpha=calculatesessionpercent().totcheckbox
			 def totalCheckedAlpha=calculatesessionpercent().totchecked*/
                //***************************************
                WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

                WebUI.delay(2)

                WebDriver driver = DriverFactory.getWebDriver()

                def checkboxXpath = '//td[@class=\'body-cell align-middle grow\'][text()=\'Participant\']/following-sibling::td//input'

                List<WebElement> totalCheckBoxpersession = driver.findElements(By.xpath(checkboxXpath))

                println('Total Checkboxes:::' + totalCheckBoxpersession.size())

                totcheckbox1 = totalCheckBoxpersession.size()

                //finaltotalcheckbox=finaltotalcheckbox+totcheckbox
                totchecked1 = 0

                for (def checked = 0; checked < totalCheckBoxpersession.size(); checked++) {
                    def checkedprop = totalCheckBoxpersession.get(checked).getAttribute('checked')

                    if (checkedprop == 'true') {
                        totchecked1 = (totchecked1 + 1)
                    }
                }
                
                //***************************************
                totalCheckAlpha = (totalCheckAlpha + totcheckbox1)

                totalCheckedAlpha = (totalCheckedAlpha + totchecked1)

                println('totalCheckAlpha:::' + totalCheckAlpha)

                println('totalCheckedAlpha:::' + totalCheckedAlpha)

                if ((totalCheckedAlpha > 0) && (totalCheckAlpha > 0)) {
                    Alpha_attendancepercent = ((totalCheckedAlpha / totalCheckAlpha) * 100)

                    Alphapercent = Math.round(Alpha_attendancepercent)

                    println('Alpha percent::::' + Alphapercent)
                }
                
                break
            case 'Christian Experience Weekend':
                println('Session type:Christian Experience Weekend ')

                Christianexperienceweekend_totalsession = (Christianexperienceweekend_totalsession + 1)

                Christianexperienceweekend_totalparticipant = (calculateParticipant() + Christianexperienceweekend_totalparticipant)

                /*	def totalCheckChristianexperienceweekend=calculatesessionpercent().totcheckbox
			 def totalCheckedChristianexperienceweekend=calculatesessionpercent().totchecked*/
                //***************************************
                WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

                WebUI.delay(2)

                WebDriver driver = DriverFactory.getWebDriver()

                def checkboxXpath = '//td[@class=\'body-cell align-middle grow\'][text()=\'Participant\']/following-sibling::td//input'

                List<WebElement> totalCheckBoxpersession = driver.findElements(By.xpath(checkboxXpath))

                println('Total Checkboxes:::' + totalCheckBoxpersession.size())

                totcheckbox2 = totalCheckBoxpersession.size()

                //finaltotalcheckbox=finaltotalcheckbox+totcheckbox
                totchecked2 = 0

                for (def checked = 0; checked < totalCheckBoxpersession.size(); checked++) {
                    def checkedprop = totalCheckBoxpersession.get(checked).getAttribute('checked')

                    if (checkedprop == 'true') {
                        totchecked2 = (totchecked2 + 1)
                    }
                }
                
                //***************************************
                totalCheckChristianexperienceweekend = (totalCheckChristianexperienceweekend + totcheckbox2)

                totalCheckedChristianexperienceweekend = (totalCheckedChristianexperienceweekend + totchecked2)

                println('totalCheckChristianexperienceweekend:::' + totalCheckChristianexperienceweekend)

                println('totalCheckedChristianexperienceweekend:::' + totalCheckedChristianexperienceweekend)

                if ((totalCheckChristianexperienceweekend > 0) && (totalCheckedChristianexperienceweekend > 0)) {
                    Christianexperienceweekend_attendancepercent = ((totalCheckedChristianexperienceweekend / totalCheckChristianexperienceweekend) * 
                    100)

                    ChristExpPercent = Math.round(Christianexperienceweekend_attendancepercent)

                    println('Christian Experience Weekend percent::::' + ChristExpPercent)
                }
                
                break
            case 'ChristLife':
                println('Session type:ChristLife ')

                Christlife_totalsession = (Christlife_totalsession + 1)

                Christlife_totalparticipant = (calculateParticipant() + Christlife_totalparticipant)

                /*def totalCheckChristLife=calculatesessionpercent().totcheckbox
			 def totalCheckedChristLife=calculatesessionpercent().totchecked*/
                //***************************************
                WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

                WebUI.delay(2)

                WebDriver driver = DriverFactory.getWebDriver()

                def checkboxXpath = '//td[@class=\'body-cell align-middle grow\'][text()=\'Participant\']/following-sibling::td//input'

                List<WebElement> totalCheckBoxpersession = driver.findElements(By.xpath(checkboxXpath))

                println('Total Checkboxes:::' + totalCheckBoxpersession.size())

                totcheckbox3 = totalCheckBoxpersession.size()

                totchecked3 = 0

                //finaltotalcheckbox=finaltotalcheckbox+totcheckbox
                for (def checked = 0; checked < totalCheckBoxpersession.size(); checked++) {
                    def checkedprop = totalCheckBoxpersession.get(checked).getAttribute('checked')

                    if (checkedprop == 'true') {
                        totchecked3 = (totchecked3 + 1)
                    }
                }
                
                //***************************************
                totalCheckChristLife = (totalCheckChristLife + totcheckbox3)

                totalCheckedChristLife = (totalCheckedChristLife + totchecked3)

                println('totalCheckChristLife:::' + totalCheckChristLife)

                println('totalCheckedChristLife:::' + totalCheckedChristLife)

                if ((totalCheckChristLife > 0) && (totalCheckedChristLife > 0)) {
                    Christlife_attendancepercent = ((totalCheckedChristLife / totalCheckChristLife) * 100)

                    christlifepercent = Math.round(Christlife_attendancepercent)

                    println('ChristLife percent::::' + christlifepercent)
                }
                
                break
            case 'Cursillo':
                println('Session type:Cursillo ')

                Cursillo_totalsession = (Cursillo_totalsession + 1)

                Cursillo_totalparticipant = (calculateParticipant() + Cursillo_totalparticipant)

                /*def totalCheckCursillo=calculatesessionpercent().totcheckbox
			 def totalCheckedCursillo=calculatesessionpercent().totchecked*/
                //***************************************
                WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

                WebUI.delay(2)

                WebDriver driver = DriverFactory.getWebDriver()

                def checkboxXpath = '//td[@class=\'body-cell align-middle grow\'][text()=\'Participant\']/following-sibling::td//input'

                List<WebElement> totalCheckBoxpersession = driver.findElements(By.xpath(checkboxXpath))

                println('Total Checkboxes:::' + totalCheckBoxpersession.size())

                totcheckbox4 = totalCheckBoxpersession.size()

                //finaltotalcheckbox=finaltotalcheckbox+totcheckbox
                totchecked4 = 0

                for (def checked = 0; checked < totalCheckBoxpersession.size(); checked++) {
                    def checkedprop = totalCheckBoxpersession.get(checked).getAttribute('checked')

                    if (checkedprop == 'true') {
                        totchecked4 = (totchecked4 + 1)
                    }
                }
                
                //***************************************
                totalCheckCursillo = (totalCheckCursillo + totcheckbox4)

                totalCheckedCursillo = (totalCheckedCursillo + totchecked4)

                println('totalCheckCursillo:::' + totalCheckCursillo)

                println('totalCheckedCursillo:::' + totalCheckedCursillo)

                if ((totalCheckCursillo > 0) && (totalCheckedCursillo > 0)) {
                    Cursillo_attendancepercent = ((totalCheckedCursillo / totalCheckCursillo) * 100)

                    Cursillopercent = Math.round(Cursillo_attendancepercent).toString()

                    println('Cursillo percent::::' + Cursillopercent)
                }
                
                break
            case 'Life in the Spirit':
                println('Session type:Life in the Spirit ')

                Lifeinthespirit_totalsession = (Lifeinthespirit_totalsession + 1)

                Lifeinthespirit_totalparticipant = (calculateParticipant() + Lifeinthespirit_totalparticipant)

                /*def totalCheckLifeinthespirit=calculatesessionpercent().totcheckbox
			 def totalCheckedLifeinthespirit=calculatesessionpercent().totchecked*/
                //***************************************
                WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsAttendance/link_sessionsAttendance_sessionAttendance'))

                WebUI.delay(2)

                WebDriver driver = DriverFactory.getWebDriver()

                def checkboxXpath = '//td[@class=\'body-cell align-middle grow\'][text()=\'Participant\']/following-sibling::td//input'

                List<WebElement> totalCheckBoxpersession = driver.findElements(By.xpath(checkboxXpath))

                println('Total Checkboxes:::' + totalCheckBoxpersession.size())

                totcheckbox5 = totalCheckBoxpersession.size()

                //finaltotalcheckbox=finaltotalcheckbox+totcheckbox
                totchecked5 = 0

                for (def checked = 0; checked < totalCheckBoxpersession.size(); checked++) {
                    def checkedprop = totalCheckBoxpersession.get(checked).getAttribute('checked')

                    if (checkedprop == 'true') {
                        totchecked5 = (totchecked5 + 1)
                    }
                }
                
                //***************************************
                totalCheckLifeinthespirit = (totalCheckLifeinthespirit + totcheckbox5)

                totalCheckedLifeinthespirit = (totalCheckedLifeinthespirit + totchecked5)

                println('totalCheckLifeinthespirit:::' + totalCheckLifeinthespirit)

                println('totalCheckedLifeinthespirit:::' + totalCheckedLifeinthespirit)

                if ((totalCheckLifeinthespirit > 0) && (totalCheckedLifeinthespirit > 0)) {
                    Lifeinthespirit_attendancepercent = ((totalCheckedLifeinthespirit / totalCheckLifeinthespirit) * 100)

                    Lifeinthespiripercent = Math.round(Lifeinthespirit_attendancepercent)

                    println('Lifeinthespiri percent::::' + Lifeinthespiripercent)
                }
                
                break
            default:
                System.out.println('Default ')}
        
        WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
    } else {
        WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
    }
    
    numberofRegisteredParticipants_AllSessionType = (((((Lifeinthespirit_totalparticipant + Cursillo_totalparticipant) + 
    Christlife_totalparticipant) + Christianexperienceweekend_totalparticipant) + Alpha_totalparticipant) + ACTSRetreat_totalparticipant)
}

def TotalParticipantCheckboxes = ((((totalCheckACTS + totalCheckAlpha) + totalCheckChristianexperienceweekend) + totalCheckChristLife) + 
totalCheckCursillo) + totalCheckLifeinthespirit

println('TotalParticipantCheckboxes::::::' + TotalParticipantCheckboxes)

def TotalParticipantChecked = ((((totalCheckedACTS + totalCheckedAlpha) + totalCheckedChristianexperienceweekend) + totalCheckedChristLife) + 
totalCheckedCursillo) + totalCheckedLifeinthespirit

println('TotalParticipantChecked::::::::' + TotalParticipantChecked)

def FinalPercent = 0

if (TotalParticipantCheckboxes > 0) {
    FinalPercent = ((TotalParticipantChecked / TotalParticipantCheckboxes) * 100)
}

def FinalRoundpercent = Math.round(FinalPercent).toString() + '%'

println('FinalRoundpercent::::' + FinalRoundpercent)

//numberofRegisteredParticipants_AllSessionType=Lifeinthespirit_totalparticipant+Cursillo_totalparticipant+Christlife_totalparticipant+Christianexperienceweekend_totalparticipant+Alpha_totalparticipant+ACTSRetreat_totalparticipant
println('numberofRegisteredParticipants_AllSessionType:::::' + numberofRegisteredParticipants_AllSessionType)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_stats'), FailureHandling.CONTINUE_ON_FAILURE)

//To Validate total participants on stats page for all session type
def totparticipantonstatus = WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants'), FailureHandling.CONTINUE_ON_FAILURE)

int totparticipant_int = Integer.parseInt(totparticipantonstatus)

if (totparticipant_int == numberofRegisteredParticipants_AllSessionType) {
    println('Total Session participants Matches')
} else {
    println('Total Session participants does not Match')
}

//To Validate total session on stats page for all session type
def totsessiononstatus = WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions'), FailureHandling.CONTINUE_ON_FAILURE)

int totsession_int = Integer.parseInt(totsessiononstatus)

println('Total number of sessions on Stats (integer) is :::::' + totsession_int)

if (numberofSessionsHeld_AllSessionType == totsession_int) {
    println('Total Session Matches')
} else {
    println('Total Session does not Match')
}

//To Validate Percent for all Session types
def totpercentageallsessiontype = WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants'), FailureHandling.CONTINUE_ON_FAILURE)

if (FinalRoundpercent.equals(totpercentageallsessiontype)) {
    println('Percentage matches for all session types')
} else {
    println('Percentage does not match for all session types')
}

//To validate total participants and session for each session type
println('ACTS Part::::' + ACTSRetreat_totalparticipant)

println('Alpha Part::::' + Alpha_totalparticipant)

println('Christ exp weekend Part::::' + Christianexperienceweekend_totalparticipant)

println('christlife Part::::' + Christlife_totalparticipant)

println('cursillo Part::::' + Cursillo_totalparticipant)

println('lifeinspirit Part::::' + Lifeinthespirit_totalparticipant)

String[] arrayOfSessionTypes = ['ACTS Retreat', 'Alpha', 'Christian Experience Weekend', 'ChristLife', 'Cursillo', 'Life in the Spirit']

def sessionTypeToCheck

for (i = 0; i < arrayOfSessionTypes.length; i++) {
    sessionTypeToCheck = (arrayOfSessionTypes[i])

    WebUI.click(findTestObject('module_inform/image_inform_sessionTypeDropdownArrow'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//span[contains(@class,\'ng-option-label\') and text() = \'' + 
        sessionTypeToCheck) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)

    //def dropXpath="//span[@class='ng-option-label']"
    //CustomKeywords.'verificationFunctions.droppanelselection.dropValueSelection'(dropXpath,sessiontype_statuspage)
    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    println(sessionTypeToCheck)

    //sessiontype_sessionoverview1= WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select_sessionOverview_sessionTypes'),'textContent').replaceAll("×", "")
    switch (sessionTypeToCheck) {
        case 'ACTS Retreat':
            WebUI.verifyMatch(ACTSRetreat_totalsession.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(ACTSRetreat_totalparticipant.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(ACTSpercent.toString() + '%', WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            break
        case 'Alpha':
            println('Session type:Alpha ')

            WebUI.verifyMatch(Alpha_totalsession.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Alpha_totalparticipant.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Alphapercent.toString() + '%', WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            break
        case 'Christian Experience Weekend':
            println('Session type:Christian Experience Weekend ')

            WebUI.verifyMatch(Christianexperienceweekend_totalsession.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Christianexperienceweekend_totalparticipant.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(ChristExpPercent.toString() + '%', WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            break
        case 'ChristLife':
            println('Session type:ChristLife ')

            WebUI.verifyMatch(Christlife_totalsession.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Christlife_totalparticipant.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(christlifepercent.toString() + '%', WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            break
        case 'Cursillo':
            println('Session type:Cursillo ')

            WebUI.verifyMatch(Cursillo_totalsession.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Cursillo_totalparticipant.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Cursillopercent.toString() + '%', WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            break
        case 'Life in the Spirit':
            println('Session type:Life in the Spirit ')

            WebUI.verifyMatch(Lifeinthespirit_totalsession.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Lifeinthespirit_totalparticipant.toString(), WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.verifyMatch(Lifeinthespiripercent.toString() + '%', WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants')), 
                false, FailureHandling.CONTINUE_ON_FAILURE)

            break
        default:
            System.out.println('Default ')} //Method to check percent for each session type
} 
}
//Method for checking total match
//Method to return total session participants

def percentEachsessiontype(def sessionSpercent, def sessiontype) {
    def sessionSpercent1 = sessionSpercent.toString() + '%'

    def totpercentagesession = WebUI.getText(findTestObject('module_inform/label_inform_averageAttendanceByParticipants'))

    if (totpercentagesession.equals(sessionSpercent1)) {
        println('Percentage matches for ' + sessiontype)
    } else {
        println('Percentage does not match for ' + sessiontype)
    }
}

def sessionTypeCountMatch(def sessionType, def totSession, def totparticipant) {
    def totParticipantforsessiontype = WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants'))

    int totParticipantforsessiontype_int = Integer.parseInt(totParticipantforsessiontype)

    def totsessionforsessiontype = WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions'))

    int totsessionforsessiontype_int = Integer.parseInt(totsessionforsessiontype)

    if (totSession == totsessionforsessiontype_int) {
        println(('Total Session for Session type ' + sessionType) + ' matches')
    } else {
        println(('Total Session for Session type' + sessionType) + ' does not match')
    }
    
    if (totparticipant == totParticipantforsessiontype_int) {
        println(('Total participant for Session type ' + sessionType) + ' matches')
    } else {
        println(('Total participant for Session type' + sessionType) + ' does not match')
    }
}

def calculateParticipant() {
    def stattotalparticipant = 0

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'))

    if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'), 
        2, FailureHandling.OPTIONAL)) {
        def splitduplicatenotif = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'))

        String[] split1Array = splitduplicatenotif.split('for ')

        def splitedString = split1Array[1]

        println('splitedString::::' + splitedString)

        String[] split1Array1 = splitedString.split(' ')

        def totDuplicatetext = split1Array1[0]

        println('totDuplicatetext::' + totDuplicatetext)

        int totduplicate = Integer.parseInt(totDuplicatetext)

        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'))

        def duplicaterows = '//table[@class=\'table\']//tbody//tr'

        WebDriver driver = DriverFactory.getWebDriver()

        List<WebElement> duplicateRow = driver.findElements(By.xpath(duplicaterows))

        def totDuplicate = duplicateRow.size()

        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'))

        def finalDuplicateTotal = totDuplicate - totduplicate

        println('finalDuplicateTotal:::' + finalDuplicateTotal)

        def mainParticiXpath = '//tr[@class=\'participant-row\']'

        List<WebElement> participantsList = driver.findElements(By.xpath(mainParticiXpath))

        def totParticipantmain = participantsList.size()

        println('totParticipantmain:::::' + totParticipantmain)

        def totSessionParticipant = finalDuplicateTotal + totParticipantmain

        println('totSessionParticipant::::::::' + totSessionParticipant)

        stattotalparticipant = (stattotalparticipant + totSessionParticipant)
    } else {
        def mainParticiXpath = '//tr[@class=\'participant-row\']'

        WebDriver driver = DriverFactory.getWebDriver()

        List<WebElement> participantsList = driver.findElements(By.xpath(mainParticiXpath))

        def totParticipantmain = participantsList.size()

        println('totParticipantmain:::::' + totParticipantmain)

        stattotalparticipant = (stattotalparticipant + totParticipantmain)
    }
    
    return stattotalparticipant
}

