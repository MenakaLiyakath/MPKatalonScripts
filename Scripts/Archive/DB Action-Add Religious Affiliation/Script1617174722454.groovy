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

actorDataOrg = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'SELECT * FROM public.organizations where name=\'Menlo Innovations\'')

def organizationPkId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataOrg, 
    1, 1)

println('organizationPkId' + organizationPkId)

/*Get default_religious_affiliation_id from public.default_religious_affiliations*/
ResultSet actorReligiousAffiliation

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Buddhist\'')

def buddhistId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def buddhistSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Catholic\'')

def catholicId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def catholicSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Hindu\'')

def hinduId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def hinduSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Jewish\'')

def jewishId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def jewishSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Muslim\'')

def muslimId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def muslimSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Orthodox\'')

def orthodoxId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def orthodoxSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Protestant\'')

def protestantId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def protestantSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'Other\'')

def othertId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def otherSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

actorReligiousAffiliation = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 
    'SELECT * FROM public.default_religious_affiliations where religious_affiliation_name=\'None\'')

def nonetId = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 1)

def noneSort = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorReligiousAffiliation, 
    1, 3)

/*Insert organization_id,religious_affiliation_name,default_religious_affiliation_id to public.religious_affiliations*/
CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Buddhist\',\'') + buddhistId) + '\',\'') + buddhistSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Catholic\',\'') + catholicId) + '\',\'') + catholicSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Hindu\',\'') + hinduId) + '\',\'') + hinduSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Jewish\',\'') + jewishId) + '\',\'') + jewishSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Muslim\',\'') + muslimId) + '\',\'') + muslimSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Orthodox\',\'') + orthodoxId) + '\',\'') + orthodoxSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Protestant\',\'') + protestantId) + '\',\'') + protestantSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'Other\',\'') + othertId) + '\',\'') + otherSort) + '\')')

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(connection, ((((((('INSERT INTO public.religious_affiliations(' + 
    'organization_id, religious_affiliation_name,default_religious_affiliation_id,sort_order1)') + 'VALUES (\'') + organizationPkId) + 
    '\',\'None\',\'') + nonetId) + '\',\'') + noneSort) + '\')')

/*Close DB connection*/
CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()

