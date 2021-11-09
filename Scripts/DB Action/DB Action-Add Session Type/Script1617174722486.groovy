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

/*This script is to add session types for menlo org via DB*/

/*Connect to QA DB* for adding religious affilitation*/



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

/*Get default_session_type_id from public.default_session_types*/


ResultSet actorSessionTypes
actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Alpha'")
def AlphaId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='ChristLife'")
def ChristLifeId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Cursillo'")
def CursilloId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Christian Experience Weekend'")
def ChristianExperienceWeekendId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='ACTS Retreat'")
def ACTSRetreatId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Life in the Spirit'")
def LifeintheSpiritId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='RCIA'")
def RCIAId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Called & Gifted'")
def CalledGiftedtId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Growing Our Friendship with Jesus'")
def GrowingOurFriendshipwithJesustId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)


actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='Light of the World'")
def LightoftheWorldtId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)

actorSessionTypes=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_session_types where session_type='The 99 Experience'")
def The99ExperienceId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorSessionTypes, 1, 1)


/*Insert organization_id,session_type,color_code,default_session_type_id to public.organization_session_types*/

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
		"INSERT INTO public.organization_session_types("
		+"organization_id, session_type,default_session_type_id,color_code)"
		+"VALUES ('"+organizationPkId+"','Alpha','"+AlphaId+"','#98DED2')"
		)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','ChristLife','"+ChristLifeId+"','#FFF1AD')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','Cursillo','"+CursilloId+"','#FFDBAF')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','Christian Experience Weekend','"+ChristianExperienceWeekendId+"','#D6F2C7')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','ACTS Retreat','"+ACTSRetreatId+"','#ADB9B4')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','Life in the Spirit','"+LifeintheSpiritId+"','#FFB9A9')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','RCIA','"+RCIAId+"','#CEC7A6')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','Called & Gifted','"+CalledGiftedtId+"','#B8F0F0')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','Growing Our Friendship with Jesus','"+GrowingOurFriendshipwithJesustId+"','#F9BCBA')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','Light of the World','"+LightoftheWorldtId+"','#ADB9B4')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.organization_session_types("
	+"organization_id, session_type,default_session_type_id,color_code)"
	+"VALUES ('"+organizationPkId+"','The 99 Experience','"+The99ExperienceId+"','#98DED2')"
	)

/*Close DB connection*/
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()

