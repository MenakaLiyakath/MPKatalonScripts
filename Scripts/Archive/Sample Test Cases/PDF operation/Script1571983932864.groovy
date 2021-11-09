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
import org.apache.commons.io.FileUtils as FileUtils
import org.apache.commons.io.comparator.LastModifiedFileComparator as LastModifiedFileComparator
import org.apache.commons.io.filefilter.WildcardFileFilter as WildcardFileFilter
import java.awt.Desktop as Desktop

/*def latestPDF=getTheNewestFile("D:\\MenakaDownloads\\","pdf")
if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
{
System.out.println("not supported");
return;
}
Desktop desktop = Desktop.getDesktop();
   desktop.open(File);              //opens the specified file


 Get the newest file for a specific extension 
public File getTheNewestFile(String filePath, String ext) {
	File theNewestFile = null;
	File dir = new File(filePath);
	FileFilter fileFilter = new WildcardFileFilter("*." + ext);
	File[] files = dir.listFiles(fileFilter);

	if (files.length > 0) {
		*/
/** The newest file comes first **/
/*
		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		theNewestFile = files[0];
	}

	return theNewestFile;
}*/
String dirPath1 = 'D:\\MenakaDownloads\\'

File latestFileDownloaded = getLatestFilefromDir(dirPath1)

println(latestFileDownloaded.name)

/*if (!(Desktop.isDesktopSupported())) //check if Desktop is supported by Platform or not
{
    System.out.println('not supported')

    return null
}

Desktop desktop = Desktop.getDesktop()

desktop.open(latestFileDownloaded) //opens the specified file
*/
def pdfContent=CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getAllText'(dirPath1+latestFileDownloaded.name)
println pdfContent
def contentFlag
if (pdfContent.toString().contains(" beeeeeeans"))
{
	 contentFlag='true'
}
else 
{
	contentFlag='false'
}

WebUI.verifyMatch(contentFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
private File getLatestFilefromDir(String dirPath) {
    File dir = new File(dirPath)

    File[] files = dir.listFiles()

    if ((files == null) || (files.length == 0)) {
    }
    
    File lastModifiedFile = files[0]

    for (int i = 1; i < files.length; i++) {
        if (lastModifiedFile.lastModified() < files[i].lastModified()) {
            lastModifiedFile = (files[i])
        }
    }
    
    return lastModifiedFile
}

