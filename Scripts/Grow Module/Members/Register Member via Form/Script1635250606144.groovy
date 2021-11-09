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

WebUI.navigateToUrl(GlobalVariable.globalizedGrowMemberRegLink, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.delay(2)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_firstName'), 
    FirstName)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_lastName'), 
    LastName)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_email'), 
    Email)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_phone'), 
    Phone)

if (PreferredCommunication == 'Email') {
    WebUI.check(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/checkBox_registration_email'))
}

if (PreferredCommunication == 'Text') {
    WebUI.check(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/checkBox_registration_text'))
}

if (PreferredCommunication == 'Phone') {
    WebUI.check(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_phone'))
}

if (PreferredCommunication == 'All') {
    WebUI.check(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/checkBox_registration_email'))

    WebUI.check(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/checkBox_registration_text'))

    WebUI.check(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_phone'))
}

if (((DOBYear != '') && (DOBMonth != '')) && (DOBDate != '')) {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/button_registration_dob'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/dropDown_registration_year'), 
        DOBYear, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/dropDown_registration_month'), 
        DOBMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/label_registration_selectDate', 
            [('sessionStartDate') : DOBDate]), FailureHandling.CONTINUE_ON_FAILURE)
}

if (Gender != '') {
    if (Gender.toString().toLowerCase() == 'male') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/radio_registration_male'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (Gender.toString().toLowerCase() == 'female') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/radio_registration_female'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (Gender.toString().toLowerCase() == 'decline') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/radio_registration_declineToAnswer'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}


if (WebUI.verifyElementPresent(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/label_registration_doYouAttendchurchparish'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)) {
    if (ConfirmAttending != '') {
        if (ConfirmAttending == 'Yes') {
            WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/radioButton_registration_isAttendingYes'), 
                FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_parish'), 
                Parish, FailureHandling.CONTINUE_ON_FAILURE)
        } else {
            WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/radioButton_registration_isAttendingNo'), 
                FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
}

if (WebUI.verifyElementPresent(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/label_registration_areYouMember'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)) {
    if (Areyouamember != '') {
        if (Areyouamember == 'No') {
            WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/radio_registration_areYouMemberNo'), 
                FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/input_registration_parish'), 
                Parish, FailureHandling.CONTINUE_ON_FAILURE)
        } else {
            WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/radio_registration_areYouMemberYes'), 
                FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
}


WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/textArea_registration_additionalComments'), 
    Comments)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/button_registration_continuetoPayment'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/button_registration_continuetoPayment'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/page_payment/label_payment_description'), 
            FailureHandling.CONTINUE_ON_FAILURE), GlobalVariable.globalPmtDesc, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/page_payment/label_payment_feeLabel'), 
            FailureHandling.CONTINUE_ON_FAILURE), GlobalVariable.globalPmtFeeLabel, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/page_payment/label_payment_price'), 
            FailureHandling.CONTINUE_ON_FAILURE), GlobalVariable.globalPmtPrice, false, FailureHandling.CONTINUE_ON_FAILURE)

    if (PayNow == 'yes') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/page_payment/radio_payment_now'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/page_group_registration/page_payment/radio_payment_later'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/button_registration_signUpNow'))
} else {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/page_group_registration/button_registration_signUpNow'))
}

