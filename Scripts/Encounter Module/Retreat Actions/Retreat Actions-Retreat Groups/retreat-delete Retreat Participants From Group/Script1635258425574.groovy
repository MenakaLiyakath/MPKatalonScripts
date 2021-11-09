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

//WebUI.callTestCase(findTestCase('null'), [('loginUrl') : GlobalVariable.globalLoginUrl, ('username') : 'shani@menloinnovations.com'
//        , ('password') : 'tomedison1847!', ('neworlastlogin') : ''], FailureHandling.CONTINUE_ON_FAILURE)
//
//WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))
//
//WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), 'AlphaRetreat1', false, FailureHandling.CONTINUE_ON_FAILURE)
//
//WebUI.waitForElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)
//
//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'), FailureHandling.CONTINUE_ON_FAILURE)
//
//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_retreatGroupsMenu'))
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
TestData ourParticipantDataSet = findTestData(indicateDataFile)

ArrayList<Integer> indiciesToDelete = new ArrayList<>()

indiciesToDelete.add(4)

indiciesToDelete.add(8)

indiciesToDelete.add(9)


for (int index : indiciesToDelete) {
    lastNameCommaFirstName = ((ourParticipantDataSet.internallyGetValue('newParticipantRowLastNameCell', index) + ', ') + 
    ourParticipantDataSet.internallyGetValue('newParticipantRowFirstNameCell', index))

    WebUI.modifyObjectProperty(elementToDelete, 'xpath', 'EQUALS', ('.//td[contains(text(),\'' + lastNameCommaFirstName) + 
        '\')][1]/following::i[1]', true)

    WebUI.click(elementToDelete)
}


for (int index : indiciesToDelete) {
	lastNameCommaFirstName = ((ourParticipantDataSet.internallyGetValue('newParticipantRowLastNameCell', index) + ', ') +
		ourParticipantDataSet.internallyGetValue('newParticipantRowFirstNameCell', index))
	
    WebUI.modifyObjectProperty(elementToVerify, 'xpath', 'EQUALS', ('//table[@id=\'participantGroupTable\']//td[text()=\'' + 
        lastNameCommaFirstName) + '\']/ancestor::tr[1]', true)

	WebUI.modifyObjectProperty(elementToVerify, 'xpath', 'EQUALS',('//table[@id=\'participantGroupTable\']/tbody/tr/td[contains(text(),\'' + lastNameCommaFirstName + '\')]/ancestor::tr'), true)
	
    WebUI.verifyElementAttributeValue(elementToVerify, 'class', '', 0)
	System.out.println("Index : " + index)
}

