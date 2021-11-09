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
/*This script is to add group types for menlo org via DB*/
/*Connect to QA DB* for adding religious affilitation*/
/*Testing Process is going on 26-10-2021 test*/
/*Comment added by tester*/
Connection connection = null
ResultSet actorData
String conn = GlobalVariable.pgConnection
if ((connection != null) && !(connection.isClosed())) {
	connection.close()
}
connection =  DriverManager.getConnection(conn, GlobalVariable.pgUser, GlobalVariable.pgUserPassword)
connection.setAutoCommit(false)
/*Get organization id for menlo org from public.organization*/
ResultSet actorDataOrg
actorDataOrg=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.organizations where name='Menlo Innovations'")
def organizationPkId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataOrg, 1, 1)
println "organizationPkId"+organizationPkId
/*Get default_group_type_id from grow.default_group_types*/


ResultSet actorGroupTypes

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Events'")
def EventsId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)
/*Insert organization_id,group_type,color_code,default_group_type_id to public.organization_session_types*/

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Retreat'")
def RetreatId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Adult Faith Formation'")
def AdultFaithFormationId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Planning'")
def PlanningId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Social Ministry'")
def SocialMinistryId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Discipleship'")
def DiscipleshipId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)

actorGroupTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM grow.default_group_types where group_type='Connect'")
def ConnectId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorGroupTypes, 1, 1)


CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
		"INSERT INTO grow.organization_group_types("
		+"organization_id, group_type,default_group_type_id,color_code)"
		+"VALUES ('"+organizationPkId+"','Events','"+EventsId+"','#D5A6E6')"
		)
		
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
			"INSERT INTO grow.organization_group_types("
			+"organization_id, group_type,default_group_type_id,color_code)"
			+"VALUES ('"+organizationPkId+"','Retreat','"+RetreatId+"','#FAC6E5')"
			)
			
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
				"INSERT INTO grow.organization_group_types("
				+"organization_id, group_type,default_group_type_id,color_code)"
				+"VALUES ('"+organizationPkId+"','Adult Faith Formation','"+AdultFaithFormationId+"','#FDC788')"
				)
				
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
				"INSERT INTO grow.organization_group_types("
					+"organization_id, group_type,default_group_type_id,color_code)"
					+"VALUES ('"+organizationPkId+"','Planning','"+PlanningId+"','#EFB3AB')"
					)
					
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
				"INSERT INTO grow.organization_group_types("
						+"organization_id, group_type,default_group_type_id,color_code)"
						+"VALUES ('"+organizationPkId+"','Social Ministry','"+SocialMinistryId+"','#40C4FF')"
						)
						
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
				"INSERT INTO grow.organization_group_types("
							+"organization_id, group_type,default_group_type_id,color_code)"
							+"VALUES ('"+organizationPkId+"','Discipleship','"+DiscipleshipId+"','#8BBDD9')"
							)
							
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
				"INSERT INTO grow.organization_group_types("
								+"organization_id, group_type,default_group_type_id,color_code)"
								+"VALUES ('"+organizationPkId+"','Connect','"+ConnectId+"','#B7DDB0')"
								)
/*Close DB connection*/
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()
