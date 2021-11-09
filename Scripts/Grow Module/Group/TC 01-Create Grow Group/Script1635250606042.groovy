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

if (AddGroupVia == 'Overview') {
    WebUI.click(findTestObject('module_grow/page_group/button_group_addGroup'))
}

if (AddGroupVia == 'Group') {
    WebUI.click(findTestObject('module_grow/page_group/button_group_addGroup'), FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(2)

WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_active'))

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Name'), GroupName)

if (GroupType != '') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/input_group_Type'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'groupType\']//div[@class=\'ng-option\']//span[@class=\'ng-option-label\'][text()=\'' + 
        GroupType) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(2)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Focus'), Focus)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Location'), PrimaryLocation)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/textarea_group_Address'), Address)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Room'), Room)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/textarea_group_Notes'), GroupNotes)

if (IsActive.toString().toLowerCase() == 'no') {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/radio_group_inActive'), FailureHandling.CONTINUE_ON_FAILURE)
}

if (Audience == 'Open') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_audienceOpen'))
}

if (Audience == 'Select Audience') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_selectAudience'))
}

if (Audience == 'By Invite') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_audienceByInvite'))
}

WebUI.click(findTestObject('module_grow/page_group/tab_group_details/button_group_save'))

WebUI.delay(2)

//Customize Registration Form
WebUI.click(findTestObject('module_grow/page_group/tab_group_details/button_group_customizeRegistrationForm'))

//Customize gender display
println('customizeGenderContatDisplay' + customizeGenderContatDisplay)

if (customizeGenderContatDisplay == 'yes') {
    println('customizeGenderContatRequired' + customizeGenderContatRequired)

    if (customizeGenderContatRequired == 'yes') {
        WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/checkBox_customizeForm_gender'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
} else {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/toggle_customizeForm_gender'))
}

//Customize DOB display
println('customizeDOBDisplay' + customizeDOBDisplay)

if (customizeDOBDisplay == 'yes') {
    //Customize DOB display
    println('customizeDOBRequired' + customizeDOBRequired)

    if (customizeDOBRequired == 'yes') {
        WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/checkBox_customizeForm_dateOfBirth'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
} else {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/toggle_customizeForm_dateOfBirth'))
}

//Customize Church Affiliation display
println('customizeChurchAffilationDisplay' + customizeChurchAffilationDisplay)

if (customizeChurchAffilationDisplay == 'yes') {
    println('customizeChurchAffiliationRequired' + customizeChurchAffiliationRequired)

    if (customizeChurchAffiliationRequired == 'yes') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/checkBox_customizeForm_parishChurchAffiliationRequired'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    println('customizeChurchAffilationIsMember' + customizeChurchAffilationIsMember)

    if (customizeChurchAffilationIsMember == 'yes') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/radio_customizeForm_areYouMember'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    println('customizeChurchAttend' + customizeChurchAttend)

    if (customizeChurchAttend == 'yes') {
        WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/radio_customizeForm_doYouAttend'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
} else {
    WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/toggle_customizeForm_parishChurchAffiliationDisplay'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

//Customize Spirituality display
println('customizeSpiritualityDisplay' + customizeSpiritualityDisplay)

if (customizeSpiritualityDisplay == 'yes') {
    //Customize Spirituality display
    println('customizeSpiritualityRequired' + customizeSpiritualityRequired)

    if (customizeSpiritualityRequired == 'yes') {
        WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/checkBox_customizeForm_spirituality'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
} else {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/toggle_customizeForm_spirituality'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

//Set comments 
if (customizeComments != '') {
    WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/textArea_customizeForm_additionalCommentsHelperText'), 
        customizeComments)
}

//Customize Preferred Contact display
println('customizePreferredContatDisplay' + customizePreferredContatDisplay)

if (customizePreferredContatDisplay == 'yes') {
    //Customize Preferred Contact display
    println('customizePreferredContatRequired' + customizePreferredContatRequired)

    if (customizePreferredContatRequired == 'yes') {
        WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/checkBox_customizeForm_preferredContactMethod'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
} else {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/toggle_customizeForm_preferredContactMethod'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

//Customize Payments
if (customizePmtsFeeDisplay == 'yes') {
    //Customize Payments Fee toggle
    println('customizePaymentsFee' + customizePmtFeeRequired)

    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/toggle_customizeForm_pmtFee'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    if (customizePmtFeeRequired == 'yes') {
        WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/input_customizeForm_pmtfeeRequired'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/textarea_customizeForm_pmtfeeDescription'), 
        customizePmtFeeDescription, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/input_customizeForm_pmtfeeLabel'), 
        customizePmtFeeLabel, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/input_customizeForm_pmtfeePrice'), 
        customizePmtPrice, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/button_customizeForm_update'))

//End of Customize registration form
if (registerMemberViaForm == 'Yes') {
    GlobalVariable.globalizedGrowMemberRegLink = WebUI.getText(findTestObject('Object Repository/module_grow/page_group/tab_group_details/link_group_registration'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

