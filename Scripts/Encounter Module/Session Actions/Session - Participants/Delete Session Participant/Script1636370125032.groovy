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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod



	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.comment('Input filter values')
	
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/input_sessionsParticipants_lastName'),
		LastName)
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/kendoFilter_sessionsParticipants_lastName'))
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')
	
	WebUI.delay(1)
	
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/input_sessionsParticipants_firstName'),
		FirstName)
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/kendoFilter_sessionsParticipants_firstName'))
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')
	
	WebUI.delay(1)
	
	WebUI.comment('click and open person')
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','//kendo-grid[@id=\'participantsGrid\']//table[@class=\'k-grid-table\']//td[text()=\''+FirstName+'\']//ancestor::table[@class=\'k-grid-table\']//td//span[text()=\''+LastName+'\']//ancestor::table[@class=\'k-grid-table\']//td//input' , true)
	
	WebUI.click(dynamicObject)
	

    
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/icon_sessionsParticipants_delete'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_deleteParticipants/button_deleteParticipants_confirmDelete'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//div[@id=\'participantsTable\']//table//tr[@class=\'participant-row\']//td[text()=\''+LastName+'\']/following-sibling::td[text()=\''+FirstName+'\']/ancestor::tr//input',
		true)
	
	WebUI.verifyElementNotPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

