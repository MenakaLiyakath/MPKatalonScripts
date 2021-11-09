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

def stattotalparticipant = 0

def totSess_ManageSession = WebUI.getNumberOfTotalOption(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'))

for (i = 1; i < totSess_ManageSession; i++) {
    WebUI.selectOptionByIndex(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), 
        i)

    //WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), "test", false)
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))

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
    
    WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
}

println('stattotalparticipant:::::::::' + stattotalparticipant)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'))

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_stats'))

def totparticipantonstatus = WebUI.getText(findTestObject('module_inform/label_inform_numberOfRegisteredParticipants'))

int totparticipant_int = Integer.parseInt(totparticipantonstatus)

if (totparticipant_int == stattotalparticipant) {
    println('Total Session participants Matches')
} else {
    println('Total Session participants does not Match')
}

