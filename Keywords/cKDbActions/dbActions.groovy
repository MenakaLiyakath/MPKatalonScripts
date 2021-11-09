package cKDbActions

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
import java.sql.ResultSet
import org.postgresql.Driver
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import org.postgresql.jdbc.PgConnection
import org.postgresql.jdbc.PgResultSet
import org.postgresql.jdbc.PgStatement
import java.sql.*

public class dbActions {
	/**
	 \* in order to fix a java error, we renamed this class postgressConn -> postgresConn, and renamed the keyword package postgressConn -> postgresConnect
	 \* 
	 \* 
	 */
	private static PgConnection connection = null;

	@Keyword

	def connectDB() {

		//Load driver class for your specific database type


		//String conn =  GlobalVariable.pgConnection
		String conn =  'jdbc:postgresql://ec2-52-4-83-214.compute-1.amazonaws.com:5432/dbophphj62hg8s?currentSchema=public&sslmode=require'

		if (connection != null && !connection.isClosed()) {

			connection.close()

		}
		connection = DriverManager.getConnection(conn, GlobalVariable.pgUser, GlobalVariable.pgUserPassword)
		//connection = DriverManager.getConnection(conn, 'u5loc59d0j9drk', 'p205a9c7129611a401f8a4b161c8b8e710f1f9a5b63a174a5ac0bb4b879d9bdaa')
		connection.setAutoCommit(true);
		println(connection.isClosed())
		return connection

	}

	/**
	 \* execute a SQL query on database
	 \* @param queryString SQL query string
	 \* @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	@Keyword

	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet resultSet = stm.executeQuery(queryString)

		ResultSetMetaData metadata = resultSet.getMetaData()
		int columnCount = metadata.getColumnCount()
		List<List<String>> rowList = new LinkedList<List<String>>()

		while (resultSet.next()) {
			List<String> row = new LinkedList<>()

			for(int i = 1; i <=columnCount; i++) {
				Object value = resultSet.getObject(i)
				row.add(value)
			}

			rowList.add(row)
		}

		for(List<String> row: rowList) {
			for(String data: row) {
				System.out.print(data + " ")
			}
			System.out.println()
		}

		return rowList

	}

	@Keyword
	def updateQuery(String queryString) {

		Statement stm = connection.createStatement()

		stm.executeUpdate(queryString)



	}

	@Keyword
	def executeInsertCustomSettingQuery(sessionId,String customValue,String truefalse) {
		sessionId = sessionId.toString();
		println(sessionId);
		String stringSessionId = sessionId.replace("[", "");
		println(stringSessionId);
		stringSessionId = stringSessionId.replace("]", "");
		println(stringSessionId);
		Statement stm = connection.createStatement()
		String queryString = "INSERT INTO public.custom_session_settings(fk_session_id, fk_name, display) VALUES('" + stringSessionId + "', '"+customValue+"', "+truefalse+")"
		stm.executeUpdate(queryString)
	}



	@Keyword
	def executeTruncateDatabaseTablesQuery() {
		println(connection.isClosed())
		println(GlobalVariable.pgUser)
		Statement stm = connection.createStatement()

		String queryString = "CREATE OR REPLACE FUNCTION truncate_tables(username IN VARCHAR) returns void as \$\$ \n" +
				"DECLARE \n"+
				"statements CURSOR FOR \n"+
				"SELECT tablename FROM pg_tables \n"+
				"WHERE tableowner = username AND schemaname = 'public' AND tablename IN ('forms','organizations','custom_session_settings', 'food_responsibility','groups', 'persons', 'person_organization_associations','retreat_datetimes', 'retreat_day_notes','retreat_participants', 'retreat_session_associations', 'retreat_volunteers', 'retreats', 'retreat_notes','session_participants', 'session_volunteers', 'sessions','session_groups','retreat_groups','session_meeting_notes','session_meetings','session_notes','session_participant_attendance','organization_session_types','session_volunteer_attendance'); \n"+
				"BEGIN \n"+
				"FOR stmt IN statements LOOP \n"+
				"EXECUTE 'TRUNCATE TABLE ' || quote_ident(stmt.tablename) || ' CASCADE;'; \n"+
				"END LOOP; \n"+
				"END; \n"+
				"\$\$ LANGUAGE plpgsql; \n"+
				"SELECT truncate_tables('"+GlobalVariable.pgUser+"'); "

		println(queryString);
		stm.execute(queryString)

	}

	@Keyword
	def executeTruncateDatabaseGrowTablesQuery() {
		//	def username=GlobalVariable.
		Statement stm = connection.createStatement()
		String queryString = "CREATE OR REPLACE FUNCTION truncate_tables(username IN VARCHAR) returns void as \$\$ \n" +
				"DECLARE \n"+
				"statements CURSOR FOR \n"+
				"SELECT tablename FROM pg_tables \n"+
				"WHERE tableowner = username AND schemaname = 'grow' AND tablename IN ('group_members','group','grow_group_events'); \n"+
				"BEGIN \n"+
				"FOR stmt IN statements LOOP \n"+
				"EXECUTE 'TRUNCATE TABLE grow.' || quote_ident(stmt.tablename) || ' CASCADE;'; \n"+
				"END LOOP; \n"+
				"END; \n"+
				"\$\$ LANGUAGE plpgsql; \n"+
				"SELECT truncate_tables('"+GlobalVariable.pgUser+"'); "
		println(queryString);
		stm.execute(queryString)
	}

	@Keyword
	def personHHInsert() {
		Statement stm = connection.createStatement()
		String seedQuery="select public.fn_seed_managed_lookup_table(lookup_table_id) from public.lookup_tables where deleted_timestamp is null;"

		println(seedQuery);
		stm.execute(seedQuery)
		String queryString = "SELECT public.fn_person_household_insert_PROCESS((SELECT pk_id from organizations WHERE name='Menlo Innovations'),  'MissionPathways', 'QA', 'test.email@mission-pathways.com',  '(902) 568-9051', '', '',null, null, '', null, null, false, null, null, null, null, null, null, null, null, null, null, 'Adult', false, '') AS person_id;"
		println(queryString);
		stm.execute(queryString)

	}
	/*
	 @Keyword
	 def executeTruncateDatabaseEventsTablesQuery() {
	 Statement stm = connection.createStatement()
	 String queryString = "CREATE OR REPLACE FUNCTION truncate_tables(username IN VARCHAR) returns void as \$\$ \n" +
	 "DECLARE \n"+
	 "statements CURSOR FOR \n"+
	 "SELECT tablename FROM pg_tables \n"+
	 "WHERE tableowner = username AND schemaname = 'grow' AND tablename IN ('grow_group_events'); \n"+
	 "BEGIN \n"+
	 "FOR stmt IN statements LOOP \n"+
	 "EXECUTE 'TRUNCATE TABLE grow.' || quote_ident(stmt.tablename) || ' CASCADE;'; \n"+
	 "END LOOP; \n"+
	 "END; \n"+
	 "\$\$ LANGUAGE plpgsql; \n"+
	 "SELECT truncate_tables('"+GlobalVariable.pgUser+"'); "
	 println(queryString);
	 stm.execute(queryString)
	 }
	 */


	@Keyword
	def createMenloOrg(){
		Statement stm = connection.createStatement()
		String queryString = "INSERT INTO organizations (name,timezone,country_code2) VALUES('Menlo Innovations','America/Detroit','US');"
		stm.execute(queryString)

		/*	String queryString1 = "INSERT INTO organizations (name) VALUES('Menlo Innovations1');"
		 stm.execute(queryString1)*/
	}

	@Keyword
	def createNewOrg(){
		Statement stm = connection.createStatement()
		String queryString = "INSERT INTO public.organizations (name,timezone,country_code2) VALUES('New Organization','America/Detroit','US');"
		stm.execute(queryString)

	}


	@Keyword

	def insertUserAssociation()
	{
		Statement stm = connection.createStatement()
		String queryString = "INSERT INTO public.organization_users (organization_id,person_id,access_token,primary_organization,organization_administrator,encounter_permission_id,grow_permission_id) VALUES((SELECT pk_id from organizations WHERE name='Menlo Innovations'),(SELECT pk_id from public.persons WHERE first_name='MissionPathways'),'5dd56e0edbba100d1d1212db',TRUE,TRUE,(SELECT pk_id FROM public.permissions WHERE permission_name='Read/Write/Create'),(SELECT pk_id FROM public.permissions WHERE permission_name='Read/Write/Create'));"
		stm.execute(queryString)

		/*String queryString1 = "INSERT INTO public.organization_members (organization_id,person_id) VALUES((SELECT pk_id from organizations WHERE name='Menlo Innovations'),(SELECT pk_id from public.persons WHERE first_name='MissionPathways'));"
		 stm.execute(queryString1)*/


	}


	@Keyword
	def encounterGrowType()
	{
		Statement stm = connection.createStatement()
		String queryString = "INSERT INTO public.persons(first_name, last_name, email_address) VALUES ('MissionPathways','QA','test.email@mission-pathways.com');"
		stm.execute(queryString)
		/*String queryString1 = "INSERT INTO public.persons(first_name, last_name, email_address) VALUES ('MissionPathways1','QA1','mathi.k@ecgroup-intl.com');"
		 stm.execute(queryString1)*/



	}

	@Keyword

	def updateSessionOrg()
	{
		Statement stm = connection.createStatement()
		String queryString = "UPDATE sessions SET fk_organization_id = (SELECT pk_id from organizations WHERE name='Menlo Innovations');"
		stm.execute(queryString)
		/*String queryString1 = "UPDATE sessions SET fk_organization_id = (SELECT pk_id from organizations WHERE name='Menlo Innovations1');"
		 stm.execute(queryString1)*/
	}

	@Keyword

	def updateRetreatOrg()
	{
		Statement stm = connection.createStatement()
		String queryString = "UPDATE retreats SET fk_organization_id = (SELECT pk_id from organizations WHERE name='Menlo Innovations');"
		stm.execute(queryString)
		/*		String queryString1 = "UPDATE retreats SET fk_organization_id = (SELECT pk_id from organizations WHERE name='Menlo Innovations1');"
		 stm.execute(queryString1)*/
	}

	@Keyword

	def closeDatabaseConnection() {

		if (connection != null && !connection.isClosed()) {

			connection.close()

		}

		connection = null

	}


}
