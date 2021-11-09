package customOmegaKeywords

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


import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement


import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDate as LocalDate
//import java.time.Period;
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.Month as Month
import java.time.Period as Period
//import com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword as SetDateCalendarKeyword



public class customKeywordsOmega {

	@Keyword

	def LogintoOmega(def navigateUrl,def userName,def password) {
		//Login to Application
		WebUI.openBrowser(navigateUrl, FailureHandling.CONTINUE_ON_FAILURE)

		def neworlastlogin = WebUI.getText(findTestObject('page_login/link_login_dontRememberPassword'))
		if (neworlastlogin == 'Not your account?') {
			WebUI.click(findTestObject('page_login/link_login_dontRememberPassword'))

			WebUI.delay(2)
		}

		WebUI.setText(findTestObject('page_login/input_login_email'), userName, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), password, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('page_login/button_login_logIn'))

		WebUI.delay(1)
		WebUI.maximizeWindow()

	}

	@Keyword

	def KendoFilter(def cssValue,def filterOptions)
	{
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> options = driver.findElements(By.cssSelector(cssValue));

		def optionssize=options.size()
		println "optionssize"+optionssize

		for(def index=0;index<optionssize;index++){

			List<WebElement> options1 = driver.findElements(By.cssSelector(cssValue));
			WebElement optionElement = options1.get(index)
			println "optionElement.getText()"+optionElement.getText()
			if (optionElement.getText().equals(filterOptions))
			{
				optionElement.click();
				break
			}
		}

	}




	@Keyword

	def ageCalculator(def DateOfBirthYear,def DateOfBirthDay,def DateOfBirthMonth,def dateofBirthonsession)

	{
		def dateofBirthonsessionwithtime = dateofBirthonsession + ' 00:00:00'


		if (dateofBirthonsession != '') {
			Date participantDOBconverted = new SimpleDateFormat('MM-dd-yyyy hh:mm:ss').parse(dateofBirthonsessionwithtime)

			println('Converted Session End Date' + participantDOBconverted)

			Date date1 = Calendar.getInstance().getTime()

			print('Current date::' + date1)

			LocalDate today = LocalDate.now()

			print('Current local date date::' + today //Today's date
					)

			int DateOfBirthYear_int = Integer.parseInt(DateOfBirthYear)

			int DateOfBirthDay_int = Integer.parseInt(DateOfBirthDay)

			int dobMonth

			//switch(DateOfBirthMonth.toString().toLowerCase()) {
			switch (DateOfBirthMonth.toLowerCase()) {
				case 'jan':
					dobMonth = 1

					break
				case 'feb':
					dobMonth = 2

					break
				case 'mar':
					dobMonth = 3

					break
				case 'apr':
					dobMonth = 4

					break
				case 'may':
					dobMonth = 5

					break
				case 'june':
				case 'jun':
					dobMonth = 6

					break
				case 'july':
				case 'jul':
					dobMonth = 7

					break
				case 'august':
				case 'aug':
					dobMonth = 8

					break
				case 'september':
				case 'sep':
				case 'sept':
					dobMonth = 9

					break
				case 'october':
				case 'oct':
					dobMonth = 10

					break
				case 'november':
				case 'nov':
					dobMonth = 11

					break
				case 'december':
				case 'dec':
					dobMonth = 12

					break
			}

			LocalDate birthday = LocalDate.of(DateOfBirthYear_int, dobMonth, DateOfBirthDay_int)

			//LocalDate birthday = LocalDate.of(2000, Month.JANUARY, 11);  //Birth date
			Period p = Period.between(birthday, today)

			println('Age**********' + p)

			def completeage = p.toString()

			String[] completeage_split

			completeage_split = completeage.split('Y')

			def age = completeage_split[0].toString().replace('P', '')

			print('Final Age:::' + age)
		}
	}


	@Keyword

	def dobMonthConversion(DateOfBirthMonth)

	{
		int dobMonth
		switch (DateOfBirthMonth.toLowerCase()) {
			case 'jan':
				dobMonth = 1

				break
			case 'feb':
				dobMonth = 2

				break
			case 'mar':
				dobMonth = 3

				break
			case 'apr':
				dobMonth = 4

				break
			case 'may':
				dobMonth = 5

				break
			case 'june':
			case 'jun':
				dobMonth = 6

				break
			case 'july':
			case 'jul':
				dobMonth = 7

				break
			case 'august':
			case 'aug':
				dobMonth = 8

				break
			case 'september':
			case 'sep':
			case 'sept':
				dobMonth = 9

				break
			case 'october':
			case 'oct':
				dobMonth = 10

				break
			case 'november':
			case 'nov':
				dobMonth = 11

				break
			case 'december':
			case 'dec':
				dobMonth = 12

				break
		}
		return dobMonth
	}

	@Keyword

	def monthConversion(month)

	{
		int intMonth
		switch (month.toLowerCase()) {
			case 'jan':
				intMonth = 1

				break
			case 'feb':
				intMonth = 2

				break
			case 'mar':
				intMonth = 3

				break
			case 'apr':
				intMonth = 4

				break
			case 'may':
				intMonth = 5

				break
			case 'june':
			case 'jun':
				intMonth = 6

				break
			case 'july':
			case 'jul':
				intMonth = 7

				break
			case 'august':
			case 'aug':
				intMonth = 8

				break
			case 'september':
			case 'sep':
			case 'sept':
				intMonth = 9

				break
			case 'october':
			case 'oct':
				intMonth = 10

				break
			case 'november':
			case 'nov':
				intMonth = 11

				break
			case 'december':
			case 'dec':
				intMonth = 12

				break
		}
		return intMonth
	}


	@Keyword

	def intMonthConversion(month)

	{
		def strMonth
		switch (month.toString().toLowerCase()) {
			case '1':
				strMonth = 'jan'

				break
			case '2':
				strMonth = 'feb'

				break
			case '3':
				strMonth = 'mar'

				break
			case '4':
				strMonth = 'apr'

				break
			case '5':
				strMonth = 'may'

				break
			case '6':
				strMonth = "jun"

				break

			case '7':
				strMonth = "jul"

				break

			case '8':
				strMonth = "aug"

				break

			case '9':
				strMonth = "sep"

				break

			case '10':
				strMonth = "oct"

				break

			case '11':
				strMonth = "nov"

				break

			case '12':
				strMonth = "dec"

				break
		}
		return strMonth
	}

	@Keyword

	def pickCalendarDate(def selectMonth)

	{
		int	selectMonthInt
		switch (selectMonth.toLowerCase()) {
			case 'jan':
			case 'january':
				selectMonthInt = 1

				break
			case 'feb':
			case 'february':
				selectMonthInt = 2

				break
			case 'mar':
			case 'march':
				selectMonthInt = 3

				break
			case 'apr':
			case 'april':
				selectMonthInt = 4

				break
			case 'may':
				selectMonthInt = 5

				break
			case 'june':
			case 'jun':
				selectMonthInt = 6

				break
			case 'july':
			case 'jul':
				selectMonthInt = 7

				break
			case 'august':
			case 'aug':
				selectMonthInt = 8

				break
			case 'september':
			case 'sep':
			case 'sept':
				selectMonthInt = 9

				break
			case 'october':
			case 'oct':
				selectMonthInt = 10

				break
			case 'november':
			case 'nov':
				selectMonthInt = 11

				break
			case 'december':
			case 'dec':
				selectMonthInt = 12

				break
		}

		return selectMonthInt

	}

	@Keyword

	def profilePageFilterValidation(def columnXpath,def filterOptions,def filterValue)
	{
		def containFlag,startWithFlag,endsWithFlag
		if(WebUI.verifyElementNotPresent(findTestObject('module_profiles/label_profiles_noRecordsAvailable'), 2))
		{

			WebDriver driver = DriverFactory.getWebDriver()
			List<WebElement> columnValueElements = driver.findElements(By.xpath(columnXpath))

			def columnValueCount=columnValueElements.size()
			println "optionssize"+columnValueCount

			if(filterOptions=='Is equal to')
			{
				for(def index=1;index<columnValueCount;index++){
					List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
					WebElement columnValue = columnValueElements1.get(index)
					println "columnValueElements1.getText()"+columnValue.getText()
					WebUI.verifyMatch(filterValue, columnValue.getText(), false, FailureHandling.CONTINUE_ON_FAILURE)


				}

				if(filterOptions=='Is not equal to')
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()
						WebUI.verifyNotMatch(filterValue, columnValue.getText(), false, FailureHandling.CONTINUE_ON_FAILURE)


					}

				}

				if(filterOptions=='Contains')
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()
						if(columnValue.getText().contains(filterValue))
							containFlag="true"
						else
							containFlag="false"

						WebUI.verifyNotMatch(containFlag,"true", false, FailureHandling.CONTINUE_ON_FAILURE)



					}

				}

				if(filterOptions=='Does not contain')
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()
						if(columnValue.getText().contains(filterValue))
							containFlag="true"
						else
							containFlag="false"

						WebUI.verifyNotMatch(containFlag,"false", false, FailureHandling.CONTINUE_ON_FAILURE)



					}

				}

				if(filterOptions=='Starts with')
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()

						if(columnValue.getText().startsWith(filterValue))
							startWithFlag="true"
						else
							startWithFlag="false"
						WebUI.verifyMatch(startWithFlag, "true", false, FailureHandling.CONTINUE_ON_FAILURE)



					}

				}

				if(filterOptions=='Ends with')
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()

						if(columnValue.getText().endsWith(filterValue))
							endsWithFlag="true"
						else
							endsWithFlag="false"
						WebUI.verifyMatch(endsWithFlag, "true", false, FailureHandling.CONTINUE_ON_FAILURE)



					}

				}

				if((filterOptions=='Is null')||(filterOptions=='Is empty'))
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()
						WebUI.verifyMatch(columnValue.getText(),"", false, FailureHandling.CONTINUE_ON_FAILURE)

					}

				}

				if(filterOptions=='Is not empty')
				{
					for(def index=1;index<columnValueCount;index++){
						List<WebElement> columnValueElements1 = driver.findElements(By.xpath(columnXpath))
						WebElement columnValue = columnValueElements1.get(index)
						println "columnValueElements1.getText()"+columnValue.getText()
						WebUI.verifyNotMatch(columnValue.getText(),"", false, FailureHandling.CONTINUE_ON_FAILURE)

					}

				}
			}
		}
	}


	@Keyword

	def convertMonthName(def month)

	{
		def convertedMonthValue
		switch (month.toLowerCase()) {
			case 'jan':
				convertedMonthValue = "January"

				break
			case 'feb':
				convertedMonthValue = "February"

				break
			case 'mar':
				convertedMonthValue = "March"

				break
			case 'apr':
				convertedMonthValue = "April"

				break
			case 'may':
				convertedMonthValue = "May"

				break
			case 'june':
			case 'jun':
				convertedMonthValue = "June"

				break
			case 'july':
			case 'jul':
				convertedMonthValue = "July"

				break
			case 'august':
			case 'aug':
				convertedMonthValue = "August"

				break
			case 'september':
			case 'sep':
			case 'sept':
				convertedMonthValue = "September"

				break
			case 'october':
			case 'oct':
				convertedMonthValue = "October"

				break
			case 'november':
			case 'nov':
				convertedMonthValue = "November"

				break
			case 'december':
			case 'dec':
				convertedMonthValue = "December"

				break
		}
		return convertedMonthValue
	}


}
