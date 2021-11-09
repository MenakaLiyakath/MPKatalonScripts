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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.katalon.plugin.keyword.connection.DBType as DBType
import java.sql.Connection as Connection
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.sql.ResultSet as ResultSet
import org.postgresql.Driver as Driver
import java.sql.DriverManager as DriverManager
import java.sql.SQLException as SQLException
import java.sql.Statement as Statement
import org.postgresql.jdbc.PgConnection as PgConnection
import org.postgresql.jdbc.PgResultSet as PgResultSet
import org.postgresql.jdbc.PgStatement as PgStatement

/*This script handles the navigation to required module on login based on input*/
//Variable definition



//Open Browser and navigate to URL
WebUI.openBrowser(GlobalVariable.globalLoginUrl)

println('userName' + GlobalVariable.globalTestUser)

println('password' + GlobalVariable.globalTestUserPassword)



WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('page_login/input_login_email'), 2)

WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('page_login/button_login_logIn'))

 
//Navigate to appropriate page Session/Retreat/Grow/People Profile
if (module != '') {
    if (module == 'session') {
        WebUI.delay(2)

        WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

        WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

        if (sessionOrRetreatName != '') {
            WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/label_sessionTile_sessionNameOnTile', 
                    [('sessionName') : sessionOrRetreatName]), FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
    
    if (module == 'retreat') {
        WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

        WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

        if (sessionOrRetreatName != '') {
            WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

            println('sessionOrRetreatName')

            WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/label_retreatTile_retreatNameOntile', 
                    [('retreatName') : sessionOrRetreatName]), FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
    
    if (module == 'people') {
        WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_findPeople'))
    }
    
    if (module == 'grow') {
        WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_grow'))
    }
    
    if (module == 'settings') {
        WebUI.click(findTestObject('Object Repository/CommonPageObjects/page_home/button_homePage_settings'), FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (module == 'form') {
        WebUI.click(findTestObject('Object Repository/CommonPageObjects/page_home/button_homePage_formBuilder'), FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (sidebarLink != '') {
        sidebarLinkObject = new TestObject('sidebarLinkObject')

        sidebarLinkObject.addProperty('xpath', ConditionType.EQUALS, ('//a[@id=\'' + sidebarLink) + '\']', true)

        WebUI.click(sidebarLinkObject)

        WebUI.delay(1)
    }
    
    WebUI.delay(2)
}

