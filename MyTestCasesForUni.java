package MyTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCasesForUni extends Parameters {

	@BeforeTest

	public void mySetup() {

		MySetup();

	}

	@Test(priority = 1, enabled = false)
	public void UniRegister() throws InterruptedException {

		UniRegister();// Test the Register as Universit

		Thread.sleep(2000);

		LogInWithTheSameRandData();// After Register Login with the same Random Mail

		AssertionForLoginWithInactiveAccount();// Assertion if we try to login with Inactive account

	}

	@Test(priority = 2, enabled = false)
	public void ComRegister() throws InterruptedException, IOException {

		CompanyReg(); // Test The Register As Company

		ScreenShot(); // take a screenshot for data before click on submit

		driver.findElement(By.xpath("//button[contains(text(),'تسجيل جديد')]")).click();// after the screenshot click on
																						// register btn

		Thread.sleep(2000);

		LogInWithTheSameRandData(); // After Register Login With The Same Random Mail

		AssertionForLoginWithInactiveAccount(); // Assertion If We Try To Login With Inactive Account

	}

	@Test(priority = 2, enabled = false)
	public void InstitutesReg2() throws InterruptedException, IOException {

		InstitutesReg(); // Test The Register As Company

		ScreenShot(); // take a screenshot for data before click on submit

		driver.findElement(By.xpath("//button[contains(text(),'تسجيل جديد')]")).click();// after the screenshot click on
		// register btn

		LogInWithTheSameRandData();

	}

	@Test(priority = 3, enabled = false)
	public void LogInAsSuperAdmin() throws InterruptedException {

		SuperAdminLogin();// login as superadmin

		VerifyUniSectionAppears();// VerifyUniSectionAppears and click on it
	}

	@Test(priority = 4, enabled = false)
	public void LogInAsUni() throws InterruptedException {

		UniLogin();// login as uni

	}

	@Test(priority = 5, enabled = false)
	public void AddCollage() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		AddCollegs();// add collage and assertion

	}

	@Test(priority = 6, enabled = false)
	public void TestEditCollage() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		CheckEditForCollages();// test the edit without changes

	}

	@Test(priority = 7, enabled = false)
	public void TestCancellationDeleteClassification() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		CheckCancellationDeleteForClassification();// check the delete and cancel

	}

	@Test(priority = 8, enabled = false)
	public void TestDelclassification() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		CheckDeleteForClassification();
		;// check the delete and confirm

	}

	@Test(priority = 8, enabled = false)
	public void TestDelCollage() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		CheckDeleteForCollage();
		;// check the delete and confirm

	}

	@Test(priority = 9, enabled = false)
	public void AddClassifications() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		AddClassification();

	}

	@Test(priority = 10, enabled = false)
	public void TestAddLevel() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		AddLevel();// add a level and assertion using page source
	}

	@Test(priority = 11, enabled = false)
	public void TestInValedddMaterials() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		AddMaterialWithMissingData();// try to add material without choose specification
	}

	@Test(priority = 12, enabled = false)
	public void TestValidAddMaterials() throws InterruptedException {

		UniLogin();// login as uni

		ClickOnCollegs();// click on collages section

		AddMaterialWithCompleteData();// add material with all required fields and assertion
	}

	@Test(priority = 13, enabled = false)
	public void TestEditMaterials() throws InterruptedException {

		UniLogin();

		ClickOnCollegs();

		EditMaterial();
	}

	@Test(priority = 14, enabled = false)
	public void TestDeleteMaterials() throws InterruptedException {

		UniLogin();

		ClickOnCollegs();

		DeleteMaterial();
	}

	@Test(priority = 15, enabled = false)
	public void TestAddStudentWithMarks() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		AddStudentWithMarks();

	}

	@Test(priority = 16, enabled = false)
	public void TestAddStudentWithoutMarks() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		AddStudentWithoutMarks();

	}

	@Test(priority = 17, enabled = false)
	public void TestEditStudent() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		EditStudentGender();

	}

	@Test(priority = 18, enabled = false)
	public void TestDeleteStudent() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		DelStudent();

	}

	@Test(priority = 19, enabled = false)
	public void TestStudentFilters() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		RateFilter();

	}

	@Test(priority = 20, enabled = false)
	public void TestAddCV() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		AddCv();

		ClickonCv();

	}

	@Test(priority = 21, enabled = false)
	public void TestDelCV() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		DeleteCv();

	}

	@Test(priority = 22, enabled = false)
	public void TestDownloadStusents() throws InterruptedException {

		UniLogin();

		ClickOnStudents();

		VerifyFileDownloaded();// there is issue in assertion need to be solved later

	}

	@Test(priority = 23, enabled = true)
	public void TestLogout() throws InterruptedException {

		UniLogin();

		CheckLogout();

	}

	@AfterTest
	public void CloseBrowser() {

		driver.quit();

	}
}
