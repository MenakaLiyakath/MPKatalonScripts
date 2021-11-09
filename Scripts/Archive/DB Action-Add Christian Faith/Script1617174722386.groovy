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

/* Merge Records testing 123*/

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

/*Get default_terms_of_christian_faith_id from public.default_terms_of_christian_faith*/


ResultSet actorChristianFaith


actorChristianFaith=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_terms_of_christian_faith where terms_of_christian_faith_name='Atheist'")
def atheistId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 1)
def atheistSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 3)

actorChristianFaith=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_terms_of_christian_faith where terms_of_christian_faith_name='Agnostic'")
def agnosticId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 1)
def agnosticSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 3)

actorChristianFaith=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_terms_of_christian_faith where terms_of_christian_faith_name='Christian'")
def christianId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 1)
def christianSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 3)

actorChristianFaith=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_terms_of_christian_faith where terms_of_christian_faith_name='Non-Christian'")
def nonChristianId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 1)
def nonChristianSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 3)

actorChristianFaith=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_terms_of_christian_faith where terms_of_christian_faith_name='Undecided'")
def undecidedId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 1)
def undecidedSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 3)

actorChristianFaith=CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, "SELECT * FROM public.default_terms_of_christian_faith where terms_of_christian_faith_name='Other'")
def othertId=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 1)
def otherSort=CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorChristianFaith, 1, 3)



/*Insert organization_id,terms_of_christian_faith_name,default_terms_of_christian_faith_id to public.terms_of_christian_faith*/


CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.terms_of_christian_faith("
	+"organization_id, terms_of_christian_faith_name,default_terms_of_christian_faith_id,sort_order1)"
	+"VALUES ('"+organizationPkId+"','Atheist','"+atheistId+"','"+atheistSort+"')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.terms_of_christian_faith("
	+"organization_id, terms_of_christian_faith_name,default_terms_of_christian_faith_id,sort_order1)"
	+"VALUES ('"+organizationPkId+"','Agnostic','"+agnosticId+"','"+agnosticSort+"')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.terms_of_christian_faith("
	+"organization_id, terms_of_christian_faith_name,default_terms_of_christian_faith_id,sort_order1)"
	+"VALUES ('"+organizationPkId+"','Christian','"+christianId+"','"+christianSort+"')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.terms_of_christian_faith("
	+"organization_id, terms_of_christian_faith_name,default_terms_of_christian_faith_id,sort_order1)"
	+"VALUES ('"+organizationPkId+"','Non-Christian','"+nonChristianId+"','"+nonChristianSort+"')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.terms_of_christian_faith("
	+"organization_id, terms_of_christian_faith_name,default_terms_of_christian_faith_id,sort_order1)"
	+"VALUES ('"+organizationPkId+"','Undecided','"+undecidedId+"','"+undecidedSort+"')"
	)

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection,
	"INSERT INTO public.terms_of_christian_faith("
	+"organization_id, terms_of_christian_faith_name,default_terms_of_christian_faith_id,sort_order1)"
	+"VALUES ('"+organizationPkId+"','Other','"+othertId+"','"+otherSort+"')"
	)



/*Close DB connection*/
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()

