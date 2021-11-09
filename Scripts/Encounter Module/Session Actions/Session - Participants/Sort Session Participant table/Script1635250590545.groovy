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

import groovy.json.internal.ArrayUtils
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.String;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

def totSess_ManageSession = WebUI.getNumberOfTotalOption(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'))

for (i = 1; i < totSess_ManageSession; i++)
{
	WebUI.selectOptionByIndex(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), i)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'))

	WebUI.delay(2)

	WebDriver driver = DriverFactory.getWebDriver()

	def parColXpath="//td[@class='last-name-link']"

	List<WebElement> colVals = driver.findElements(By.xpath(parColXpath))

	def totcolumns = colVals.size()

	println "totcolumns:::::::"+totcolumns

	if(totcolumns>0)
	{


		//**************************Checks if the Participant Last name column is sorted alphabetically****************************

		String[] celltext = new String[totcolumns]
		for(colcnt=0;colcnt<totcolumns;colcnt++)
		{
			String celltext_1 = colVals.get(colcnt).getText()

			celltext[colcnt] = celltext_1
		}

		String[] sorted=sortString(celltext)
		if(Arrays.equals(celltext, sorted))
			println "Alphabetically sorted"
		else
			println "Alphabetically not sorted"


		//************************Clicks on Participant header and checks for sorting***************************************
		String[] participantcol = new String[totcolumns]
		for(j=0;j<totcolumns;j++)
		{
			String participantcol_1 = colVals.get(j).getText()

			participantcol[j] = participantcol_1
		}

		WebUI.delay(2)
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_LastName'))
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_LastName'))
		def parColXpath1="//td[@class='last-name-link']"

		List<WebElement> colVals1 = driver.findElements(By.xpath(parColXpath1))

		def totcolumns1 = colVals.size()

		ArrayUtils.reverse(participantcol)
		String[] participantcol1 = new String[totcolumns1]
		for(j1=0;j1<totcolumns;j1++)
		{
			String participantcol_2 = colVals1.get(j1).getText()

			participantcol1[j1] = participantcol_2
		}

		if(Arrays.equals(participantcol, participantcol1))
			println "Participant Sorting succesfull"
		else
			println "Participant Sorting not succesfull"

		//************************Clicks on Participant First Name header and checks for sorting***************************************

		String[] participantFNcol = new String[totcolumns]
		for(k=0;k<totcolumns;k++)
		{
			String parlname=colVals.get(k).getText()
			println "participant Last Name::::"+parlname
			def fnXpath="//td[@class='last-name-link'][text()=\'+parlname)+\'']'//following-sibling::td[1]"
			
			//td[@class='last-name-link'][text()='+parlname)+'']'//following-sibling::td)[1]
			//WebDriver driver = DriverFactory.getWebDriver()

			List<WebElement> fnValues = driver.findElements(By.xpath(fnXpath))

			String participantcolFN_1 = fnValues.get(k).getText()

			participantFNcol[k] = participantcolFN_1
		}

		WebUI.delay(2)
		ArrayUtils.reverse(participantFNcol)
		
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_FirstName'))
		
		
		
		def parfnColXpath1="//td[@class='last-name-link']"

		List<WebElement> fncolVals1 = driver.findElements(By.xpath(parfnColXpath1))

		def fntotcolumns1 = colVals.size()


		String[] fnparticipantcol1 = new String[fntotcolumns1]
		for(k1=0;k1<fntotcolumns1;k1++)
		{
			String parlname1 = fncolVals1.get(k1).getText()
			
			println "participant Last Name::::"+parlname1
			def fnXpath="//td[@class='last-name-link'][text()=\'+parlname)+\'']'//following-sibling::td[1]"

			//WebDriver driver = DriverFactory.getWebDriver()

			List<WebElement> fnValues1 = driver.findElements(By.xpath(fnXpath))
			String fnparticipantcol_2 = fnValues1.get(k1).getText()

			fnparticipantcol1[k1] = fnparticipantcol_2
		}

		if(Arrays.equals(participantFNcol, fnparticipantcol1))
			println "Participant Sorting succesfull"
		else
			println "Participant Sorting not succesfull"




		WebUI.click(findTestObject('null'))

	}
	else
		WebUI.click(findTestObject('null'))
}


def sortString(String[] x)
{
	int j;
	def val
	boolean flag = true;  // will determine when the sort is finished
	String temp;
	while ( flag )
	{
		flag = false;
		for ( j = 0;  j < x.length - 1;  j++ )
		{
			if ( x [ j ].compareToIgnoreCase( x [ j+1 ] ) > 0 )
			{                                             // ascending sort
				temp = x [ j ];
				x [ j ] = x [ j+1];     // swapping
				x [ j+1] = temp;
				flag = true;
			}
		}
	}

	return x
}



