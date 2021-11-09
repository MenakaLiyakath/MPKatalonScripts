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

if (Admin.toString().toLowerCase() != 'yes') {
    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    if (Admin.toString().toLowerCase() == 'yes') {
        WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_assignAccess/checkBox_asignAccess_admin'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'encounter_access\']//div[@class=\'ng-value ng-star-inserted\']//span[@class=\'ng-value-label ng-star-inserted\']', 
            true, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), 'Read/Write/Create', false, 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'grow_access\']//div[@class=\'ng-value ng-star-inserted\']//span[@class=\'ng-value-label ng-star-inserted\']', 
            true, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), 'Read/Write/Create', false, 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        if (EncounterAccess != '') {
            WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/dropDown_editAccess_encounterModuleAccessLevel'), 
                FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

            switch (EncounterAccess.toString().toLowerCase()) {
                case 'r':
                    WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_encounterAccessReadOnly'), 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    break
                case 'rw':
                    WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_encounterAccessReadWrite'), 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    break
                case 'rwc':
                    WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_encounterAccessReadWriteCreate'), 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    break
            }
        } else {
            WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_encounterAccessNone'), 
                FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        if (GrowModuleAccess != '') {
            WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/dropDown_editAccess_growModuleAccessLevel'), 
                FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

            switch (GrowModuleAccess.toString().toLowerCase()) {
                case 'r':
                    WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_growAccessReadOnly'), 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    break
                case 'rw':
                    WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_growAccessReadWrite'), 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    break
                case 'rwc':
                    WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_growAccessReadWriteCreate'), 
                        FailureHandling.CONTINUE_ON_FAILURE)

                    break
            }
        } else {
            WebUI.click(findTestObject('module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/option_editAccess_growAccessNone'), 
                FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
    
    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/module_settings/page_settings_manageUsers/page_settings_userAccounts/lightBox_userAccounts_editAccess/button_editAccess_save'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

