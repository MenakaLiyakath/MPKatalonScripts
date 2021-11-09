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

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'))
WebUI.verifyElementNotClickable(findTestObject('Object Repository/module_grow/page_group/tab_group_members/button_groupMembers_deletePeopleOnPage'), FailureHandling.CONTINUE_ON_FAILURE)

def deleteGroupMembersCount=findTestData('Data Files/Delete group members').getRowNumbers()

for(def deleteGroupMembersindex=1; deleteGroupMembersindex<=deleteGroupMembersCount; deleteGroupMembersindex++)
{

	def LastName=findTestData('Data Files/Delete group members').getValue(2, deleteGroupMembersindex)
	def FirstName=findTestData('Data Files/Delete group members').getValue(3, deleteGroupMembersindex)

	WebUI.modifyObjectProperty(dynamicobject, 'xpath', 'equals', '//div[@id=\'divGrowGroupMembersContainer\']//tr//td[text()=\''+FirstName+'\']//preceding-sibling::td//span[text()=\''+LastName+'\']//ancestor::td//preceding-sibling::td//input[@type=\'checkbox\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicobject, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/button_groupMembers_deletePeopleOnPage'))

for(def deleteGroupMembersindex1=1; deleteGroupMembersindex1<=deleteGroupMembersCount; deleteGroupMembersindex1++)
{

	def LastName1=findTestData('Data Files/Delete group members').getValue(2, deleteGroupMembersindex1)
	def FirstName1=findTestData('Data Files/Delete group members').getValue(3, deleteGroupMembersindex1)
	def memberName=LastName1+", "+FirstName1

	WebUI.modifyObjectProperty(dynamicobject, 'xpath', 'equals', '//ul[@id=\'groupTypesList\']//li[text()=\''+memberName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(dynamicobject, 2, FailureHandling.CONTINUE_ON_FAILURE)

}

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_members_confirmDelete/button_confirmDelete_delete'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)


for(def deleteGroupMembersindex2=1; deleteGroupMembersindex2<=deleteGroupMembersCount; deleteGroupMembersindex2++)
{

	def LastName2=findTestData('Data Files/Delete group members').getValue(2, deleteGroupMembersindex2)
	def FirstName2=findTestData('Data Files/Delete group members').getValue(3, deleteGroupMembersindex2)

	WebUI.modifyObjectProperty(dynamicobject, 'xpath', 'equals', ((('//div[@id=\'divGrowGroupMembersContainer\']//tr//td[text()=\'' +FirstName2) + '\']//preceding-sibling::td//span[text()=\'') + LastName2) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementNotPresent(dynamicobject, 2, FailureHandling.CONTINUE_ON_FAILURE)

}

WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CommonPageObjects/page_home/image_homePage_profiles'), FailureHandling.CONTINUE_ON_FAILURE)

for(def deleteGroupMembersindex3=1; deleteGroupMembersindex3<=deleteGroupMembersCount; deleteGroupMembersindex3++)
{
	def filterOptions='Is equal to'
	def groupName=findTestData('Data Files/Delete group members').getValue(1, 1)
	def LastName3=findTestData('Data Files/Delete group members').getValue(2, deleteGroupMembersindex3)
	def FirstName3=findTestData('Data Files/Delete group members').getValue(3, deleteGroupMembersindex3)

	WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), LastName3)

	WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))

	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

	WebUI.delay(1)

	WebUI.setText(findTestObject('module_profiles/input_profiles_firstName'), FirstName3)

	WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_firstName'))



	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

	WebUI.delay(1)

	WebUI.comment('click and open person')

	WebUI.modifyObjectProperty(dynamicobject, 'xpath', 'equals', '//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//tr//td[text()=\''+Email+'\']//preceding-sibling::td//span[text()=\''+LastName+'\']',
			true)

	WebUI.click(dynamicobject)
	
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/tab_editPeople_faithJourney'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.modifyObjectProperty(dynamicobject, 'xpath', 'equals', '//div[@id=\'journey-points-tab-container\']//faith-journey-experience-table//a[text()=\''+groupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementNotPresent(dynamicobject, 2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/tab_editPeople_journeyPoints'), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementNotPresent(findTestObject('module_profiles/lightBox_findPeople_editPeople/label_journeyPoints_noJourneyPoints'), 2, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/icon_editPeople_close'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
	WebUI.delay(1)
	
	

}



