package MyTests.src.MyTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCasesForCom extends Parameters {

	@BeforeTest

	public void mySetup() {

		MySetup();

	}

	@Test(priority = 1, enabled = false)
	public void ComRegister() throws InterruptedException {

		CompanyReg();// Test the Register as Company
		

	}
	
	@Test(priority = 2, enabled = false)
	public void RandComLogin() throws InterruptedException {

	

		LogInWithTheSameRandData();// After Register Login with the same Random Mail

		AssertionForLoginWithInactiveAccount();// Assertion if we try to login with Inactive account

	}
	
	@Test(priority = 3, enabled = false)
	public void TestComLogin() throws InterruptedException {

		ComLogin();

	}
	
	
	@Test(priority = 4, enabled = true)
	public void TestAddJob1() throws InterruptedException {

		ComLogin();
		
		AddJobWithoutDelegacy();

	}
	
	
	@Test(priority = 5, enabled = false)
	public void TestAddJob2() throws InterruptedException, IOException {

		ComLogin();
		
		AddJobWithFilter();

	}
	
	
	@Test(priority = 6, enabled = false)
	public void TestAddJob3() throws InterruptedException, IOException {

		ComLogin();
		
		AddJobWithDelegacy();

	}
	
	
	@Test(priority = 7, enabled = false)
	public void TestDraftBtn4() throws InterruptedException, IOException {

		ComLogin();
		
		SaveDraftBtn();

	}
	
	
	
	@Test(priority = 8, enabled = false)
	public void TestMultipleUnis() throws InterruptedException, IOException {

		ComLogin();
		
		AddJobManyUnis();

	}
	
	
	@Test(priority = 9, enabled = false)
	public void TestSendFor() throws InterruptedException, IOException {
		

		ComLogin();
		
		SentFor();

	}
	
	

	@Test(priority = 10, enabled = false)
	public void TestGenderTotal() throws InterruptedException, IOException {
		

		ComLogin();
		
		CompareMaleAndFemale();

	}
	
	
	@Test(priority = 11, enabled = false)
	public void TestCancelJob() throws InterruptedException, IOException {
		

		ComLogin();
		
		CancelJob();

	}
	
	@Test(priority = 12, enabled = false)
	public void TestJobDetails() throws InterruptedException, IOException {
		

		ComLogin();
		
		JobDetails();

	}
	
	@Test(priority = 13, enabled = false)
	public void TestAddInterview() throws InterruptedException, IOException {
		

		ComLogin();
		
		DetermineInterview();

	}
	
	
	@Test(priority = 14, enabled = false)
	public void TestStartInterview() throws InterruptedException, IOException {
		

		ComLogin();
		
		StartInterview();

	}
	
	
	@Test(priority = 15, enabled = false)
	public void TestAccept() throws InterruptedException, IOException {
		

		ComLogin();
		
		AcceptStudent();

	}



//	@AfterTest
//	public void CloseBrowser() {
//
//		driver.quit();
//
//	}
}
