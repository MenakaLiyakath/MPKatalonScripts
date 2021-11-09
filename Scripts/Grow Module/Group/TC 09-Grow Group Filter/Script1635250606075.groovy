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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



def groupTileXpath="//div[@id='itemHeader']"
WebDriver driver = DriverFactory.getWebDriver()

 WebUI.comment('validate with group name')
 //validate with group name
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), GroupName, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 //WebDriver driver = DriverFactory.getWebDriver()
 List<WebElement> groupTileList = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile=groupTileList.size()
 if (totalGroupTile>0)
 {
 for(def nameCount=0;nameCount<totalGroupTile;nameCount++)
 {
 def growNameFlag='false'
 def growGroupName=groupTileList.get(nameCount).getText()
 if (growGroupName.contains(GroupName))
 growNameFlag='true'
 WebUI.verifyMatch(growNameFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.comment('validate with group type')
 //validate with group type
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), GroupType, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 List<WebElement> groupTileList1 = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile1=groupTileList1.size()
 if (totalGroupTile1>0)
 {
 for(def typeCount=0;typeCount<totalGroupTile1;typeCount++)
 {
 def xpathCollectionIndex1=typeCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex1+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 def actualGroupType=WebUI.getText(findTestObject('Object Repository/module_grow/page_group/tab_group_details/input_group_typeValue'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyMatch(actualGroupType, GroupType, false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), GroupType, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.comment('validate with group Focus')
 //validate with group Focus
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Focus, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 List<WebElement> groupTileList2 = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile2=groupTileList2.size()
 if (totalGroupTile2>0)
 {
 for(def focusCount=0;focusCount<totalGroupTile2;focusCount++)
 {
 def focusFlag='false'
 def xpathCollectionIndex2=focusCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex2+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 def actualGroupFocus=WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_details/input_group_Focus'),'value', FailureHandling.CONTINUE_ON_FAILURE)
 if (actualGroupFocus.contains(Focus))
 focusFlag='true'
 WebUI.verifyMatch(focusFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Focus, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.comment('validate with group PrimaryLocation')
 //validate with group PrimaryLocation
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), PrimaryLocation, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 List<WebElement> groupTileList3 = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile3=groupTileList3.size()
 if (totalGroupTile3>0)
 {
 for(def locationCount=0;locationCount<totalGroupTile3;locationCount++)
 {
 def locationFlag='false'
 def xpathCollectionIndex3=locationCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex3+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 def actualGroupLocation=WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_details/input_group_Location'),'value', FailureHandling.CONTINUE_ON_FAILURE)
 if (actualGroupLocation.contains(PrimaryLocation))
 locationFlag='true'
 WebUI.verifyMatch(locationFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), PrimaryLocation, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.comment('validate with group Address')
 //validate with group Address
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Address, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 List<WebElement> groupTileList4 = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile4=groupTileList4.size()
 if (totalGroupTile4>0)
 {
 for(def addressCount=0;addressCount<totalGroupTile4;addressCount++)
 {
 def addressFlag='false'
 def xpathCollectionIndex4=addressCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex4+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 def actualAddressLocation=WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_details/input_group_Location'),'value', FailureHandling.CONTINUE_ON_FAILURE)
 if (actualAddressLocation.contains(Address))
 addressFlag='true'
 WebUI.verifyMatch(addressFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Address, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.comment('validate with group Room Details')
 //validate with group Room Details
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Room, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 List<WebElement> groupTileList5 = driver.findElements(By.xpath(groupTileXpath))
 def totalRoomTile5=groupTileList5.size()
 if (totalRoomTile5>0)
 {
 for(def roomCount=0;roomCount<totalRoomTile5;roomCount++)
 {
 def roomFlag='false'
 def xpathCollectionIndex5=roomCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex5+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 def actualRoom=WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_details/input_group_Room'),'value', FailureHandling.CONTINUE_ON_FAILURE)
 if (actualRoom.contains(Room))
 roomFlag='true'
 WebUI.verifyMatch(roomFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Room, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.comment('validate with group notes Details')
 //validate with group notes Details
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), GroupNotes, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 List<WebElement> groupTileList6 = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile6=groupTileList6.size()
 if (totalGroupTile6>0)
 {
 for(def notesCount=0;notesCount<totalGroupTile6;notesCount++)
 {
 def notesFlag='false'
 def xpathCollectionIndex6=notesCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex6+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 def actualNotes=WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_group/tab_group_details/textarea_group_Notes'),'value', FailureHandling.CONTINUE_ON_FAILURE)
 if (actualNotes.contains(GroupNotes))
 notesFlag='true'
 WebUI.verifyMatch(notesFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), GroupNotes, FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 
WebUI.comment('validate with Active/inactive Details')
//validate with Active/inactive checkbox is not checked
//Validate for Active groups
if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), 2, FailureHandling.CONTINUE_ON_FAILURE))
	WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), FailureHandling.CONTINUE_ON_FAILURE)
if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'),2, FailureHandling.CONTINUE_ON_FAILURE))
	WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSideBar_people'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), 2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), 2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), FailureHandling.CONTINUE_ON_FAILURE)
List<WebElement> groupTileList7 = driver.findElements(By.xpath(groupTileXpath))
def totalGroupTile7=groupTileList7.size()
if (totalGroupTile7>0)
{
	for(def activeCount=0;activeCount<totalGroupTile7;activeCount++)
	{
		def xpathCollectionIndex7=activeCount+1
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex7+']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_details/radio_group_active'), 2, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), 2, FailureHandling.CONTINUE_ON_FAILURE))
			WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), FailureHandling.CONTINUE_ON_FAILURE)
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'),2, FailureHandling.CONTINUE_ON_FAILURE))
			WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), FailureHandling.CONTINUE_ON_FAILURE)

	}
}

//Validate for Inactive groups

if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), 2, FailureHandling.CONTINUE_ON_FAILURE))
	WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), FailureHandling.CONTINUE_ON_FAILURE)
if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'),2, FailureHandling.CONTINUE_ON_FAILURE))
	WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), FailureHandling.CONTINUE_ON_FAILURE)
List<WebElement> groupTileList7_1 = driver.findElements(By.xpath(groupTileXpath))
def totalGroupTile7_1=groupTileList7_1.size()
if (totalGroupTile7_1>0)
{
	for(def inActiveCount=0;inActiveCount<totalGroupTile7_1;inActiveCount++)
	{
		def xpathCollectionIndex7_1=inActiveCount+1
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex7_1+']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_details/radio_group_inActive'), 2, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), 2, FailureHandling.CONTINUE_ON_FAILURE))
			WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_active'), FailureHandling.CONTINUE_ON_FAILURE)
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'),2, FailureHandling.CONTINUE_ON_FAILURE))
			WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/module_grow/page_overview/checkBox_groupOverview_inActive'), FailureHandling.CONTINUE_ON_FAILURE)

	}
}



WebUI.comment('validate with Audience Details')
 //validate with Audience Details
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Audience, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
 List<WebElement> groupTileList8 = driver.findElements(By.xpath(groupTileXpath))
 def totalGroupTile8=groupTileList8.size()
 if (totalGroupTile8>0)
 {
 for(def audienceCount=0;audienceCount<totalGroupTile8;audienceCount++)
 {
 def xpathCollectionIndex8=audienceCount+1
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@id=\'itemHeader\'])['+xpathCollectionIndex8+']', true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 if(Audience=='Open')
 {
 WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_details/radio_group_audienceOpen'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 }
 else if(Audience=='Select Audience')
 {
 WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_details/radio_group_selectAudience'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 }
 else
 WebUI.verifyElementChecked(findTestObject('Object Repository/module_grow/page_group/tab_group_details/radio_group_audienceByInvite'),2, FailureHandling.CONTINUE_ON_FAILURE)
 }
 WebUI.click(findTestObject('Object Repository/module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('module_grow/page_overview/input_pageOverview_search'), Audience, FailureHandling.CONTINUE_ON_FAILURE)
 }
 else
 WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_overview/label_pageOverview_noResultMatch'), 2, FailureHandling.CONTINUE_ON_FAILURE)
 