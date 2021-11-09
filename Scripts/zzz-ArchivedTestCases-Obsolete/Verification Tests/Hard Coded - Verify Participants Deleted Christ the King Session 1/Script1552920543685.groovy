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

actualParticipantsTBODYtext = WebUI.getText(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

System.out.print('Actual: \n' + actualParticipantsTBODYtext)

System.out.println()

assert !(actualParticipantsTBODYtext.contains('Participantlast-A Participantfirst1 (734) 777-8888 p1@menloinnovations.com Christ The King Session 1 thanks veggie No'))

assert !(actualParticipantsTBODYtext.contains('Participantlast-B Participantfirst2 (734) 777-8889 p1@menloinnovations.com Christ The King Session 1 thanks veggie No'))

assert !(actualParticipantsTBODYtext.contains('Participantlast-C Participantfirst3 (734) 777-8890 p1@menloinnovations.com Christ The King Session 1 thanks veggie No'))

assert actualParticipantsTBODYtext.contains('Participantlast-D Participantfirst4 (734) 777-8891 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-E Participantfirst5 (734) 777-8892 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-F Participantfirst6 (734) 777-8893 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-G Participantfirst7 (734) 777-8894 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-H Participantfirst8 (734) 777-8895 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-I Participantfirst9 (734) 777-8896 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-J Participantfirst10 (734) 777-8897 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-K Participantfirst11 (734) 777-8898 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-L Participantfirst12 (734) 777-8899 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-M Participantfirst13 (734) 777-8900 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-N Participantfirst14 (734) 777-8901 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-O Participantfirst15 (734) 777-8902 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-P Participantfirst16 (734) 777-8903 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-Q Participantfirst17 (734) 777-8904 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-S Participantfirst19 (734) 777-8906 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-T Participantfirst20 (734) 777-8907 p1@menloinnovations.com none no kids veggie thanks')

assert actualParticipantsTBODYtext.contains('Participantlast-U Participantfirst21 (734) 777-8908 p1@menloinnovations.com none no kids veggie thanks')