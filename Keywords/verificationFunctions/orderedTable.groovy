package verificationFunctions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

@Keyword
public class orderedTable {


	
	def verifyOrderedTable(String dataFileName,String xpathOfTable,int numberOfSkipRows){
		WebDriver driver = DriverFactory.getWebDriver()

		println dataFileName
		def abc="define"
		println abc
		println xpathOfTable
		WebElement Table = driver.findElement(By.xpath(xpathOfTable))
		List<WebElement> actualRowsFromUITable = Table.findElements(By.tagName('tr'))

		int actualRowCount = actualRowsFromUITable.size() - numberOfSkipRows;

		TestData expectedPeopleDataSet = findTestData(dataFileName);

		// find actual and expected table headers
		ArrayList<WebElement> actualHeaderRow = actualRowsFromUITable.get(0).findElements(By.tagName('th'));
		ArrayList<String> expectedHeaderRow = expectedPeopleDataSet.getColumnNames();

		// assert table headers
		if (expectedHeaderRow != actualHeaderRow.text){
			System.out.println("Header Rows\nExpected :" + expectedHeaderRow + "\nActual :" + actualHeaderRow.text);
			WebUI.verifyMatch('bad',"header rows didn't match",false);
		}

		// test length matches
		int expectedNumberOfPeople = expectedPeopleDataSet.getRowNumbers();

		if (actualRowCount != expectedNumberOfPeople) {
			String message = "number of actual rows<" + actualRowCount + "> doesn't match expected<" + expectedNumberOfPeople +">";
			WebUI.verifyMatch('bad',message,false);
		}


		// find actual and expected table content
		// actual skipping header and empty row

		ArrayList<ArrayList<WebElement>> actualTableTextByRows = new ArrayList<ArrayList<WebElement>>();

		for (int row = 0; row < actualRowCount; row++) {
			ArrayList<WebElement> tdsFromTrRow = actualRowsFromUITable.get(row + numberOfSkipRows).findElements(By.tagName('td'))

			actualTableTextByRows.add( tdsFromTrRow.text );
		}


		if (actualTableTextByRows != expectedPeopleDataSet.getAllData()){

			System.out.println(actualTableTextByRows);
			System.out.println(expectedPeopleDataSet.getAllData());

			String errorMessage = "actual table doesn't match expected table.";
			WebUI.verifyMatch('bad',errorMessage,false);
		}
	}

}
