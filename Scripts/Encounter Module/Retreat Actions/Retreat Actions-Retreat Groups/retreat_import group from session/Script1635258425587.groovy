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

/*Test case for below cards
Card#532 - validate the import feature Date: 20-June-19
Author: Menaka and Thiru 
*/
//Valdiate if import button is enable and click on it
WebUI.delay(3)

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_import'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_import'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(3)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

/*WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'), 
    FailureHandling.CONTINUE_ON_FAILURE)*/

WebUI.delay(3)

//Disassociate all sessions on overview Page
WebDriver driver = DriverFactory.getWebDriver()

def disassociateSessionXpath = '//div[@id=\'retreatPage\']//table//div//i'

List<WebElement> disassociateSessionList = driver.findElements(By.xpath(disassociateSessionXpath))

def totDisassociateSessionList = disassociateSessionList.size()
println "totDisassociateSessionList"+totDisassociateSessionList

for (def disassociateindex = 0; disassociateindex <= (totDisassociateSessionList - 1); disassociateindex++) {
    WebElement disassociateSessionElement = disassociateSessionList.get(disassociateindex)

    disassociateSessionElement.click()
}

WebUI.delay(3)



    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_retreatGroupsMenu'), 
        FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_import'),
		FailureHandling.CONTINUE_ON_FAILURE)

/*
    //Get the Group count from the Groups() label and delete all groups if available
    def numberOfGropus = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/label_createGroup_numberOfGroups'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    println('numberOfGropus' + numberOfGropus)

    //String[] splitGroupCaption = numberOfGropus.split("(")
    String[] splitGroupCaption = numberOfGropus.split('\\(')

    def splitGroupCaptionvalue = splitGroupCaption[1]

    String[] SplitGroupCount = splitGroupCaptionvalue.split('\\)')

    def SplitGroupCountvalue = SplitGroupCount[0].toInteger()

    if (SplitGroupCountvalue != 0) {
        for (def deleteGroups = 0; deleteGroups <= (SplitGroupCountvalue - 1); deleteGroups++) {
            WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'groupHeader\']//following::div[@class=\'row group-box-header\']//i', 
                true, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_save'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.delay(1)

        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/button_createGroup_import'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        def numberOfGropus1 = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/label_createGroup_numberOfGroups'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        //Verify if the total group count and participant count is 0 to validate that 
        String[] splitGroupCaption1 = numberOfGropus1.split('\\(')

        def splitGroupCaptionvalue1 = splitGroupCaption1[1]

        String[] SplitGroupCount1 = splitGroupCaptionvalue1.split('\\)')

        def SplitGroupCountvalue1 = SplitGroupCount1[0]

        WebUI.verifyMatch(SplitGroupCountvalue1, '0', false, FailureHandling.CONTINUE_ON_FAILURE)

        def numberOfParticpants = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatGroups/page_createGroup/label_createGroup_participantTable'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        String[] splitParticpantsCaption = numberOfParticpants.split('\\(')

        def splitParticpantsCaptionvalue = splitParticpantsCaption[1]

        String[] SplitParticpantsCount = splitParticpantsCaptionvalue.split('\\)')

        def SplitParticpantsCountvalue = SplitParticpantsCount[0]

        WebUI.verifyMatch(SplitParticpantsCountvalue, '8', false, FailureHandling.CONTINUE_ON_FAILURE)
    }


*/