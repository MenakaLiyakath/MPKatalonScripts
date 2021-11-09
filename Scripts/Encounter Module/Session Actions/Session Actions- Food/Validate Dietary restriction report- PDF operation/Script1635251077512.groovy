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
import org.apache.commons.io.FileUtils as FileUtils
import org.apache.commons.io.comparator.LastModifiedFileComparator as LastModifiedFileComparator
import org.apache.commons.io.filefilter.WildcardFileFilter as WildcardFileFilter
import java.awt.Desktop as Desktop
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement



def dietRestList=[]
def nameList=[]
def addIndex=0
WebDriver driver = DriverFactory.getWebDriver()
def dietRestricElementXpath = "//div[@id='participantsTable']//tr[@class='participant-row']//td"
List<WebElement> dietRestricElementList = driver.findElements(By.xpath(dietRestricElementXpath))
def dietRestricElementListSize = dietRestricElementList.size()

for (def dietRestIndex = 6; dietRestIndex < dietRestricElementListSize;dietRestIndex+=9)
{
	List<WebElement> dietRestricElementList1 = driver.findElements(By.xpath(dietRestricElementXpath))
	def dietRestricElementValue=dietRestricElementList1.get(dietRestIndex).text
	def participantLastNameValue=dietRestricElementList1.get(dietRestIndex-5).text
	def participantFirstNameValue=dietRestricElementList1.get(dietRestIndex-4).text
	def name=participantLastNameValue+", "+participantFirstNameValue
	println "dietRestricElementValue"+dietRestricElementValue
	println "participantLastNameValue"+participantLastNameValue
	println "participantFirstNameValue"+participantFirstNameValue
	println "name"+name
	if(dietRestricElementValue!='')
	{
//		dietRestList.add(dietRestricElementValue)
		nameList.add(name)
		
		println dietRestList.get(addIndex)
		addIndex=addIndex+1
		println "addIndex"+addIndex
		
	}
}
println dietRestList.size()

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFood'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)

//Click on Dietary Restriction

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/button_sessionFood_dietaryRestriction'), FailureHandling.CONTINUE_ON_FAILURE)

/*//Open and get text from downloaded pdf


 String dirPath1 = 'D:\\MenakaDownloads\\'
 File latestFileDownloaded = getLatestFilefromDir(dirPath1)
 println(latestFileDownloaded.name)
 def pdfContent=CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getAllText'(dirPath1+latestFileDownloaded.name)
 println pdfContent
 def contentFlag
 for(listValueIndex=0;listValueIndex<dietRestList.size();listValueIndex++)
 {
	 def actualText=
 }
 
 if (pdfContent.toString().contains(" beeeeeeans"))
 {
 contentFlag='true'
 }
 else 
 {
 contentFlag='false'
 }
 WebUI.verifyMatch(contentFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
 
 //Method to get latest file from downloads
 private File getLatestFilefromDir(String dirPath) {
 File dir = new File(dirPath)
 File[] files = dir.listFiles()
 if ((files == null) || (files.length == 0)) {
 }
 File lastModifiedFile = files[0]
 for (int i = 1; i < files.length; i++) {
 if (lastModifiedFile.lastModified() < files[i].lastModified()) {
 lastModifiedFile = (files[i])
 }
 }
 return lastModifiedFile
 }

 //*/