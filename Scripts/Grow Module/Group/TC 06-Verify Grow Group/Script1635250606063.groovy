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

//Validate Group tile
WebUI.delay(5)
WebUI.verifyElementPresent(WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'itemContainer\']//div[@id=\'itemHeader\']//div[text()=\'' + 
        GroupName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE), 2, FailureHandling.CONTINUE_ON_FAILURE)


//Validate Group Name
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'itemContainer\']//div[@id=\'itemHeader\']//div[text()=\'' + GroupName) + '\']/ancestor::div[@id=\'itemHeader\']', true, FailureHandling.CONTINUE_ON_FAILURE)



//Validate Group Location
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'itemContainer\']//div[@id=\'itemHeader\']//div[text()=\'' + 
    GroupName) + '\']/ancestor::div[@id=\'itemHeader\']//following-sibling::div//div[@id=\'groupLocation\'][text()=\'') + 
    PrimaryLocation) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

//Validate Audience

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','//div[@id=\'itemContainer\']//div[@id=\'itemHeader\']//div[text()=\''+GroupName+'\']/ancestor::div[@id=\'itemHeader\']//following-sibling::div//div[@id=\'groupAudience\'][text()=\''+Audience+'\']',true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

