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
/*Connect to QA DB*/
Connection connection = null
ResultSet actorData
String conn = GlobalVariable.pgConnection
if ((connection != null) && !(connection.isClosed())) {
	connection.close()
}
connection =  DriverManager.getConnection(conn, GlobalVariable.pgUser, GlobalVariable.pgUserPassword)
connection.setAutoCommit(false)

/* Create a new organization*/

//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, "INSERT INTO public.organizations (name,timezone,country_code2) VALUES('New Organization','America/Detroit','US');")

/* Associate Admin to New Org */

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,"INSERT INTO public.organization_members (organization_id,person_id) VALUES((SELECT pk_id from organizations WHERE name='New Organization'), (SELECT pk_id from public.persons WHERE first_name='MissionPathways'));")
