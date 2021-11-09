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
/*
Connection connection = null
ResultSet actorData
String conn = 'jdbc:postgresql://ec2-184-73-181-132.compute-1.amazonaws.com:5432/dc8sbi4snlpr71?currentSchema=public&sslmode=require'
if ((connection != null) && !(connection.isClosed())) {
	connection.close()
}
connection = DriverManager.getConnection(conn, 'esppvwlxwwrvxc', '9da0a84dcd6ec0e05ac55b790ed7b1c466e11fd44c8158c99d28b993e53e6216')

*/
Connection connection = null

ResultSet actorData

String conn = GlobalVariable.pgConnection
if ((connection != null) && !(connection.isClosed())) {
	connection.close()
}
connection =  DriverManager.getConnection(conn, GlobalVariable.pgUser, GlobalVariable.pgUserPassword)

/*Get PK id for created user*/
actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'SELECT * FROM public.persons where email_address=\'test.email@mission-pathways.com\'')

def personPkId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorData, 
    1, 1)

println('personPkId' + personPkId)

/*Get organization id for menlo org from public.organization*/
ResultSet actorDataOrg

actorDataOrg = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'SELECT * FROM public.organizations where name=\'Menlo Innovations\'')

def organizationPkId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataOrg, 
    1, 1)

println('organizationPkId' + organizationPkId)

/*Insert fk_organization_id and fk_person_id to public.person_organization_associations*/
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((('INSERT INTO public.person_organization_associations(' + 
    'fk_person_id, fk_organization_id)') + 'VALUES (\'') + personPkId) + '\',\'') + organizationPkId) + '\')')

/* Add timezone to Organization*/
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ('INSERT INTO public.organizations(' + 
    'timezone)') + 'VALUES (\'America/Detroit\')')

/*Get the pk_id from public.permissions*/
ResultSet actorDataPermission

actorDataPermission = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'SELECT * FROM public.permissions where permission_name=\'Read/Write/Create\'')

def permissionPkId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataPermission, 
    1, 1)

println('permissionPkId' + permissionPkId)

/*Insert public.user_permissions*/
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.user_permissions(' + 
    'fk_person_id, is_admin, encounter_access_level, grow_access_level)') + 'VALUES (\'') + personPkId) + '\',\'true\',\'') + 
    permissionPkId) + '\',\'') + permissionPkId) + '\')')

/*Update fk_person_id to public.organization_user_associations*/
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ('UPDATE public.organization_user_associations SET fk_person_id=\'' + 
    personPkId) + '\'')

/*Close DB connection*/
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()

