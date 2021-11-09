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
import com.katalon.plugin.keyword.connection.DBType as DBType
import java.sql.Connection as Connection
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import java.sql.ResultSet as ResultSet
import org.postgresql.Driver as Driver
import java.sql.DriverManager as DriverManager
import java.sql.SQLException as SQLException
import java.sql.Statement as Statement
import org.postgresql.jdbc.PgConnection as PgConnection
import org.postgresql.jdbc.PgResultSet as PgResultSet
import org.postgresql.jdbc.PgStatement as PgStatement

/*Connect to QA DB* for adding skills*/
//connect QA DB
def skill = skillValue

Connection connection = null

ResultSet actorData

String conn = GlobalVariable.pgConnection

if ((connection != null) && !(connection.isClosed())) {
    connection.close()
}

connection = DriverManager.getConnection(conn, GlobalVariable.pgUser, GlobalVariable.pgUserPassword)

connection.setAutoCommit(false)

/*Get organization id for menlo org from public.organization*/
ResultSet actorDataOrg

actorDataOrg = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'SELECT * FROM public.organizations where name=\'Menlo Innovations\'')

def organizationPkId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataOrg, 
    1, 1)

println('organizationPkId' + organizationPkId)

/*// Add Skill 

Get lookup_default_id from public.lookup_defaults

println 'skillValue'+skillValue

println 'skill'+skill
ResultSet actorSkill
actorSkill=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.lookup_defaults where item_text='"+skill+"'")
def skillId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSkill, 1, 1)
println 'skillId'+skillId
def skillSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSkill, 1, 4)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.skills("
	+"organization_id, item_text,lookup_default_id,sort_order)"
	+"VALUES ('"+organizationPkId+"','"+skill+"','"+skillId+"','"+skillSort+"')"
	)*/
//Add Strength
/*Get lookup_default_id from public.lookup_defaults*/
if (strengthValue != '') {
    println('strengthValue' + strengthValue)

    ResultSet actorStrength

    actorStrength = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, ('SELECT * FROM public.lookup_defaults where item_text=\'' + 
        strengthValue) + '\'')

    def strengthID = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorStrength, 
        1, 1)

    println('strengthID' + strengthID)

    def strengthSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorStrength, 
        1, 4)

    CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((((('INSERT INTO public.strengths(' + 
        'organization_id, item_text,lookup_default_id,sort_order)') + 'VALUES (\'') + organizationPkId) + '\',\'') + strengthValue) + 
        '\',\'') + strengthID) + '\',\'') + strengthSort) + '\')')
}

if (interestValue != '') {
    println('interestValue' + interestValue)

    ResultSet actorInterest

    actorInterest = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, ('SELECT * FROM public.lookup_defaults where item_text=\'' + 
        interestValue) + '\'')

    def InterestID = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorInterest, 
        1, 1)

    println('InterestID' + InterestID)

    def InterestSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorInterest, 
        1, 4)

    CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((((('INSERT INTO public.interests(' + 
        'organization_id, item_text,lookup_default_id,sort_order)') + 'VALUES (\'') + organizationPkId) + '\',\'') + interestValue) + 
        '\',\'') + InterestID) + '\',\'') + InterestSort) + '\')')
}

if (spiritualgiftsValue != '') {
    println('spiritualgiftsValue' + spiritualgiftsValue)

    ResultSet actorSpiritualGifts

    actorSpiritualGifts = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
        ('SELECT * FROM public.lookup_defaults where item_text=\'' + spiritualgiftsValue) + '\'')

    def spiritualGiftValueID = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(
        actorSpiritualGifts, 1, 1)

    println('spiritualGiftValueID' + spiritualGiftValueID)

    def SpiritualSoft = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSpiritualGifts, 
        1, 4)

    CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((((('INSERT INTO public.spiritual_gifts(' + 
        'organization_id, item_text,lookup_default_id,sort_order)') + 'VALUES (\'') + organizationPkId) + '\',\'') + spiritualgiftsValue) + 
        '\',\'') + spiritualGiftValueID) + '\',\'') + SpiritualSoft) + '\')')
}

if (volunteerValue != '') {
    println('volunteerValue' + volunteerValue)

    ResultSet actorvolunteerGifts

    actorvolunteerGifts = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
        ('SELECT * FROM public.lookup_defaults where item_text=\'' + volunteerValue) + '\'')

    def volunteerGiftValueID = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(
        actorvolunteerGifts, 1, 1)

    println('volunteerGiftValueID' + volunteerGiftValueID)

    def volunteerGifts = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorvolunteerGifts, 
        1, 4)

    CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((((('INSERT INTO public.volunteer_interests(' + 
        'organization_id, item_text,lookup_default_id,sort_order)') + 'VALUES (\'') + organizationPkId) + '\',\'') + volunteerValue) + 
        '\',\'') + volunteerGiftValueID) + '\',\'') + volunteerGifts) + '\')')
}

if (thresholdValue != '') {
    println('thresholdValue' + thresholdValue)

    ResultSet actorthreshold

    actorthreshold = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, ('SELECT * FROM public.lookup_defaults where item_text=\'' + 
        thresholdValue) + '\'')

    def thresholdValueID = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorthreshold, 
        1, 1)

    println('thresholdValueID' + thresholdValueID)

    def threshold = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorthreshold, 
        1, 4)

    CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((((('INSERT INTO public.thresholds_of_conversion(' + 
        'organization_id, item_text,lookup_default_id,sort_order)') + 'VALUES (\'') + organizationPkId) + '\',\'') + thresholdValue) + 
        '\',\'') + thresholdValueID) + '\',\'') + threshold) + '\')')
}

if (regionsValue != '') {
    println('regionsValue' + regionsValue)

    ResultSet actorregions

    actorregions = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, ('SELECT * FROM public.lookup_defaults where item_text=\'' + 
        regionsValue) + '\'')

    def regionsValueID = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorregions, 
        1, 1)

    println('regionsValueID' + regionsValueID)

    def regions = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorregions, 
        1, 4)

    CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((((('INSERT INTO public.regions(' + 
        'organization_id, item_text,lookup_default_id,sort_order)') + 'VALUES (\'') + organizationPkId) + '\',\'') + regionsValue) + 
        '\',\'') + regionsValueID) + '\',\'') + regions) + '\')')
}

/*Close DB connection*/
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()