package MyTests;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.Length;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Parameters {

	private static final String EmailReader = null;

	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

	String MyWebsiteurl = "https://kawader.amyalsmart.com/";
	String[] ArUniNames = { "جامعة اليرموك ", "جامعة الامام", "جامعة مؤته", "جامعة الحسين" };
	String[] EngUniNames = { "yarmouk uni ", "alemam uni", "mota uni", "hussain uni" };
	String[] Emails = { "yarmoukuni@gmail.com ", "alemamuni@gmail.com", "motauni@gmail.com", "hussainuni@gmail.com" };
	String Name = "Mrs Neveen";
	String[] Phones = { "561234567", "571234567", "581234567", "591234567" };
	String[] Phones2 = { "561234565", "571234565", "581234565", "591234565" };
	String Pass = "MrsNeveen";
	String OTP = "1234";
	String SuperAdminMail = "admin@gmail.com";
	String SuperAdminPass = "123456789";
	int RandomIndexForUni = rand.nextInt(ArUniNames.length);

	String[] StudentsNames = { "شهد الداوود ", "اثير القرون", "ريناد الحماد", "ايمان العرجان " };
	String[] StudentsPhones = { "521234567", "531234568", "541234569", "551234562" };
	String[] StudentsEmails = { "21@gmail.com ", "29@gmail.com", "23@gmail.com", "28@gmail.com" };

	int RandomIndexForStudents = rand.nextInt(StudentsNames.length);

	String[] ArCoNames = { "شركة رؤيا الذكية ", "شركة رؤيا القابضة ", "شركة لمعة الابداع " };
	String[] EngCoNames = { "RoayaSmart ", "RoayaHolding", "lumaa al-ebdaa" };
	String[] CoEmails = { "yarmoukuni28@gmail.com ", "alemamuni28@gmail.com", "info28@roayasmart.com" };
	String[] CoPhones = { "561234568", "571234568", "0591442288" };
	String[] CommercialRegisterVal = { "1234567898 ", "9724663468", "9724663448" };
	int RandomIndexForCom = rand.nextInt(ArCoNames.length);

	String GlobalEmail = "";
	String GlobalComName = "";
	String GlobalUniName = "";
	String[] InEmails = { "yarmoukuni33@gmail.com ", "alemamuni33@gmail.com", "motauni33@gmail.com",
			"hussainuni33@gmail.com" };

	public void MySetup() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(MyWebsiteurl);

	}

	// *************************university dashboard
	// tests**********************************//

	public void UniversityReg() throws InterruptedException {

		WebElement RegisterBtn = driver.findElement(By.cssSelector(
				"button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth h-12 mb-4 muirtl-l9jmqx']"));

		RegisterBtn.click();

		String UserName = ArUniNames[RandomIndexForUni];

		WebElement UserNameAr = driver.findElement(By.xpath("//input[@name='name_ar']\r\n"));
		UserNameAr.sendKeys(UserName);

		GlobalUniName = UserName;

		WebElement UserNameEn = driver.findElement(By.xpath("//input[@name='name_en']\r\n"));
		UserNameEn.sendKeys(EngUniNames[RandomIndexForUni]);

		File myFile = new File("./Images/Logo.png");
		driver.findElement(By.xpath("//input[contains(@name,'logo')]")).sendKeys(myFile.getAbsolutePath());

		WebElement Name1 = driver.findElement(By.xpath("//input[@name='name']\r\n"));
		Name1.sendKeys(Name);

		String EmailForLogin = Emails[RandomIndexForUni];

		WebElement EmailInp = driver.findElement(By.xpath("//input[@name='email']\r\n"));
		EmailInp.sendKeys(EmailForLogin);

		GlobalEmail = EmailForLogin;

		WebElement PhoneInp = driver.findElement(By.xpath("//input[@name='phone']\r\n"));
		PhoneInp.sendKeys(Phones[RandomIndexForUni]);

		WebElement Pass2 = driver.findElement(By.xpath("//input[@name='password']\r\n"));
		Pass2.sendKeys(Pass);

		WebElement ConfirmPass = driver.findElement(By.xpath("//input[@name='password_confirmation']\r\n"));
		ConfirmPass.sendKeys(Pass);

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(1000);

	}

	public void LogInWithTheSameRandData() throws InterruptedException {

		driver.navigate().to("https://kawader.amyalsmart.com/");

		WebElement EmailField = driver.findElement(By.id("email"));

		WebElement PassField = driver.findElement(By.id("password"));

		EmailField.sendKeys(GlobalEmail);
		PassField.sendKeys(Pass);

		Thread.sleep(2000);

		WebElement OTPBtn = driver
				.findElement(By.xpath("//*[@id=\"job-details-container\"]/main/form/div[3]/div/button"));
		OTPBtn.click();

	}

	public void AssertionForLoginWithInactiveAccount() throws InterruptedException {

		Thread.sleep(5000);

		WebElement UnsucessMessageLocator = driver.findElement(By.id("notistack-snackbar"));

		boolean ActualResult = UnsucessMessageLocator.isDisplayed();

		boolean ExpectedResult = true;

		AssertJUnit.assertEquals(ActualResult, ExpectedResult);
	}

	public void UniResetPass() {

		WebElement ResetBtn = driver.findElement(By.cssSelector(
				"span[class='text-sm text-[#878787] hover:text-[#484848] duration-300 ease-in-out cursor-pointer']"));

		ResetBtn.click();

		WebElement EmailInput = driver.findElement(By.xpath("//input[@placeholder='ادخل بريدك الإلكتروني']"));

		EmailInput.sendKeys("n.jwaied@amyalsmart.com");

		WebElement OTPbtn = driver.findElement(By.xpath("//button[contains(text(),'إرسال رمز التحقق')]"));

		OTPbtn.click();

		WebElement OTPInput = driver
				.findElement(By.xpath("//input[@placeholder='ادخل الرمز المرسل إلى بريدك الإلكتروني']"));

		// missssing how we get the otp

		WebElement OTPConfirmation = driver.findElement(By.xpath("//button[contains(text(),'تحقق من الرمز')]"));

		OTPConfirmation.click();

	}

	public void UniLogin() throws InterruptedException {

		driver.get(MyWebsiteurl);

		WebElement EmailField = driver.findElement(By.id("email"));

		WebElement PassField = driver.findElement(By.id("password"));

		EmailField.sendKeys("n.jwaied@amyalsmart.com");
		PassField.sendKeys("12345678");

		driver.findElement(By.xpath("//button[contains(text(),'طلب رمز التحقق')]")).click();
		Thread.sleep(1000);
		WebElement OTPInput = driver.findElement(By.id("otp"));

		OTPInput.sendKeys(OTP);

		WebElement LoginBtn = driver.findElement(By.xpath("//button[contains(text(),'تسجيل دخول')]"));

		LoginBtn.click();

	}

	public void ClickOnCollegs() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

		WebElement CollagesSection = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'الكليات')]")));

		CollagesSection.click();

	}

	public void ClickOnStudents() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

		WebElement StudentsSection = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'الطلاب')]")));

		StudentsSection.click();

	}

	public void AddCollegs() throws InterruptedException {
		WebElement AddBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة كلية')]"));
		AddBtn.click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input[placeholder='اسم الكلية بالعربي']")).sendKeys("كلية الهندسة ");
		driver.findElement(By.cssSelector("input[placeholder='اسم الكلية بالإنجليزي']")).sendKeys("Test");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='كلية الهندسة']")));

		// Verify that the element is displayed
		Assert.assertTrue(element.isDisplayed(), "The text is not displayed on the page.");

	}

	public void CheckEditForCollages() throws InterruptedException {

		WebElement MainEdit = driver.findElement(By.cssSelector(
				"body div div div div div div div div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(2) svg"));

		Actions actions = new Actions(driver);

		actions.click(MainEdit).perform();

		Thread.sleep(1000);

		WebElement SubEdit = driver.findElement(By.xpath(
				"		//div[contains(@class,'MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered muirtl-c4sutr')]//div[2]//div[1]//button[1]\r\n"
						+ ""));

		SubEdit.click();

		WebElement dropdownList = driver.findElement(By.xpath("//ul[contains(@role,'menu')]"));

		dropdownList.findElement(By.xpath("//div[@role='presentation']//li[1]")).click();

		WebElement EditIcon = driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]"));
		Assert.assertTrue(EditIcon.isDisplayed(), " edit  Section is not visible");

		EditIcon.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement NameAr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(4) > li:nth-child(1) > div:nth-child(1)")));

		WebElement SaveChangesBtn = driver.findElement(By.xpath("//img[contains(@alt,'save-icon')]"));

		SaveChangesBtn.click();

		Thread.sleep(1000);

		String ActualsuccessMessage = driver.findElement(By.id("notistack-snackbar")).getText();

		String ExpectedsuccessMessage = "تم تحديث الكلية بنجاح";

		AssertJUnit.assertEquals(ActualsuccessMessage, ExpectedsuccessMessage);

		String UpdatedField = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(4) > li:nth-child(4) > span:nth-child(1)"))
				.getText();

		AssertJUnit.assertEquals(UpdatedField, "neveen", "The name was not updated correctly");

	}

	public void CheckDeleteForClassification() throws InterruptedException {

		WebElement MainIcon = driver.findElement(By.cssSelector(
				"body div div div div div div div div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(2) svg"));

		Actions actions = new Actions(driver);

		actions.click(MainIcon).perform();

		Thread.sleep(2000);

		WebElement DeleteIcon = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,600)");

		DeleteIcon.click();

		WebElement AlertMessageCon = driver.findElement(By.xpath("//button[contains(text(),'حذف')]"));

		AlertMessageCon.click();

	}

	public void CheckCancellationDeleteForClassification() throws InterruptedException {

		WebElement MainIcon = driver.findElement(By.cssSelector(
				"body div div div div div div div div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(2) svg"));

		Actions actions = new Actions(driver);

		actions.click(MainIcon).perform();

		Thread.sleep(1000);

		WebElement DeleteIcon = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[2]"));

		DeleteIcon.click();

		WebElement AlertMessageCancel = driver.findElement(By.xpath(
				"//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium !bg-gray-200 muirtl-1yxmbwk']"));

		AlertMessageCancel.click();

	}

	public void CheckDeleteForCollage() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,600)");

		WebElement DeleteIcon = driver
				.findElement(By.xpath("//body/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/button[1]"));

		DeleteIcon.click();

		WebElement AlertMessageCon = driver.findElement(By.xpath("//button[contains(text(),'حذف')]"));

		AlertMessageCon.click();

	}

	public void AddClassification() throws InterruptedException {

		WebElement MainIcon = driver.findElement(By.cssSelector(
				"body div div div div div div div div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(2) svg"));

		Actions actions = new Actions(driver);

		actions.click(MainIcon).perform();

		Thread.sleep(1000);

		WebElement SubEdit = driver.findElement(By.xpath(
				"		//div[contains(@class,'MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered muirtl-c4sutr')]//div[2]//div[1]//button[1]\r\n"
						+ ""));

		SubEdit.click();

		WebElement dropdownList = driver.findElement(By.xpath("//ul[contains(@role,'menu')]"));

		dropdownList.findElement(By.xpath("//div[@role='presentation']//li[1]")).click();

		WebElement AddClassBtn = driver.findElement(By.xpath("//li[1]//div[2]//button[1]"));

		AddClassBtn.click();

		Thread.sleep(1000);

		WebElement ClassArName = driver.findElement(By.xpath("//input[@placeholder='إسم التخصص بالعربية']"));

		WebElement ClassEnName = driver.findElement(By.xpath("//input[@placeholder='اسم التخصص بالإنجليزية']"));

		WebElement ClassHours = driver.findElement(By.xpath("//input[@placeholder='عدد الساعات']"));

		WebElement GradHours = driver.findElement(By.xpath("//input[@placeholder='ساعات التخرج']"));

		ClassArName.sendKeys("علوم اسلامية ");

		ClassEnName.sendKeys("Islamic sciences");

		ClassHours.sendKeys("136");

		GradHours.sendKeys("90");

		WebElement ConfirmationBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة التخصص')]"));

		ConfirmationBtn.click();

	}

	public void AddLevel() {

		WebElement AddCollageBtn = driver.findElement(By.cssSelector(
				"button[class='flex items-center gap-2 px-4 py-2 text-white bg-[#038AB3] rounded-lg shadow-shadowBlack ']"));

		AddCollageBtn.click();

		WebElement AddClassBtn = driver.findElement(By.xpath("//li[1]//div[2]//button[1]"));

		AddClassBtn.click();

		WebElement AddPlanBtn = driver
				.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[4]/div[2]/button[1]"));

		AddPlanBtn.click();

		WebElement NameArField = driver.findElement(By.xpath("//input[@name='name_ar']"));

		WebElement NameEnField = driver.findElement(By.xpath("//input[@name='name_en']"));

		NameArField.sendKeys("المستوى التاسع ");

		NameEnField.sendKeys("9th level");

		WebElement AddLevelBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة المستوى')]"));

		AddLevelBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement SecondPage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Go to page 2']")));

		SecondPage.click();

		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("المستوى التاسع"), "Level not Added,not found on the page");

	}

	public void AddMaterialWithCompleteData() throws InterruptedException {

		WebElement AddCollageBtn = driver.findElement(By.cssSelector(
				"button[class='flex items-center gap-2 px-4 py-2 text-white bg-[#038AB3] rounded-lg shadow-shadowBlack ']"));

		AddCollageBtn.click();

		WebElement AddClassBtn = driver.findElement(By.xpath("//li[1]//div[2]//button[1]"));

		AddClassBtn.click();

		Thread.sleep(1000);

		WebElement AddPlanBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddPlanBtn.click();

		WebElement AddMaterialBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddMaterialBtn.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,200)");

		WebElement MaterialCode = driver.findElement(By.xpath("//input[@placeholder='رمز المادة']"));

		MaterialCode.sendKeys("001");

		WebElement MaterialArName = driver.findElement(By.xpath("//input[@placeholder=' اسم المادة عربي']"));

		MaterialArName.sendKeys("علوم اسلامية");

		WebElement MaterialEnName = driver.findElement(By.xpath("//input[@placeholder=' اسم المادة إنجليزي']"));

		MaterialEnName.sendKeys("islamic");

		WebElement TotalHours = driver.findElement(By.xpath("//input[@placeholder='عدد الساعات']"));

		TotalHours.sendKeys("3");

		WebElement ClassList = driver.findElement(By.cssSelector(
				".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.muirtl-qiwgdb[tabindex='0']"));

		ClassList.click();

		WebElement Class = driver.findElement(By.xpath("//li[contains(text(),'اسلامية')]"));

		Actions actions = new Actions(driver);

		actions.click(Class).perform();

		WebElement AddMaterialBtn2 = driver.findElement(By.xpath("//button[contains(text(),'إضافة المادة')]"));

		AddMaterialBtn2.click();

		String pageSource = driver.getPageSource();

		Assert.assertTrue(pageSource.contains("علوم اسلامية"), "Material not Added,not found on the page");
	}

	public void AddMaterialWithMissingData() throws InterruptedException {

		WebElement AddCollageBtn = driver.findElement(By.cssSelector(
				"button[class='flex items-center gap-2 px-4 py-2 text-white bg-[#038AB3] rounded-lg shadow-shadowBlack ']"));

		AddCollageBtn.click();

		WebElement AddClassBtn = driver.findElement(By.xpath("//li[1]//div[2]//button[1]"));

		AddClassBtn.click();

		Thread.sleep(1000);

		WebElement AddPlanBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddPlanBtn.click();

		WebElement AddMaterialBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddMaterialBtn.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,200)");

		WebElement MaterialCode = driver.findElement(By.xpath("//input[@placeholder='رمز المادة']"));

		MaterialCode.sendKeys("001");

		WebElement MaterialArName = driver.findElement(By.xpath("//input[@placeholder=' اسم المادة عربي']"));

		MaterialArName.sendKeys("فقه اسلامي");

		WebElement MaterialEnName = driver.findElement(By.xpath("//input[@placeholder=' اسم المادة إنجليزي']"));

		MaterialEnName.sendKeys("islamic");

		WebElement TotalHours = driver.findElement(By.xpath("//input[@placeholder='عدد الساعات']"));

		TotalHours.sendKeys("3");

		WebElement ClassList = driver.findElement(By.cssSelector(
				".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.muirtl-qiwgdb[tabindex='0']"));

		ClassList.click();

		WebElement ClassInput = driver.findElement(By.xpath("//input[contains(@placeholder,'اضافة تصنيف')]"));

		ClassInput.sendKeys("فنون");

		WebElement SubAddClassBtn = driver.findElement(By.xpath("//span[contains(text(),'اضافة تصنيف')]"));

		Actions actions = new Actions(driver);

		actions.click(SubAddClassBtn).perform();

		Thread.sleep(1000);

		WebElement neutralElement = driver.findElement(By.xpath("//*[@id=\"menu-\"]/div[1]"));
		neutralElement.click();

		WebElement AddMaterialBtn2 = driver.findElement(By.xpath("//button[contains(text(),'إضافة المادة')]"));

		AddMaterialBtn2.click();

		String ActualsuccessMessage = driver.findElement(By.id("notistack-snackbar")).getText();

		String ExpectedsuccessMessage = "The classification materials id field is required.";

		AssertJUnit.assertEquals(ActualsuccessMessage, ExpectedsuccessMessage);
	}

	public void EditMaterial() throws InterruptedException {

		WebElement AddCollageBtn = driver.findElement(By.cssSelector(
				"button[class='flex items-center gap-2 px-4 py-2 text-white bg-[#038AB3] rounded-lg shadow-shadowBlack ']"));

		AddCollageBtn.click();

		WebElement AddClassBtn = driver.findElement(By.xpath("//li[1]//div[2]//button[1]"));

		AddClassBtn.click();

		Thread.sleep(1000);

		WebElement AddPlanBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddPlanBtn.click();

		WebElement AddMaterialBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddMaterialBtn.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,200)");

		WebElement EditIcon = driver
				.findElement(By.xpath("//div[@class='grid gap-4 lg:grid-cols-4 subject-list']//button[1]"));

		EditIcon.click();

		WebElement EnglishNameField = driver
				.findElement(By.xpath("//input[contains(@placeholder,'اسم المادة إنجليزي')]"));

		EnglishNameField.clear();

		EnglishNameField.sendKeys("islamic science");

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'تحديث المادة')]"));

		SaveBtn.click();

	}

	public void DeleteMaterial() throws InterruptedException {

		WebElement AddCollageBtn = driver.findElement(By.cssSelector(
				"button[class='flex items-center gap-2 px-4 py-2 text-white bg-[#038AB3] rounded-lg shadow-shadowBlack ']"));

		AddCollageBtn.click();

		WebElement AddClassBtn = driver.findElement(By.xpath("//li[1]//div[2]//button[1]"));

		AddClassBtn.click();

		Thread.sleep(1000);

		WebElement AddPlanBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddPlanBtn.click();

		WebElement AddMaterialBtn = driver.findElement(By.xpath("//li[3]//div[2]//button[1]"));

		AddMaterialBtn.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,200)");

		WebElement DeleteIcon = driver.findElement(
				By.xpath("//div[2]//div[1]//div[4]//div[2]//div[1]//div[2]//div[1]//div[1]//div[3]//button[2]"));

		DeleteIcon.click();

		WebElement Confirmation = driver.findElement(By.xpath("//button[contains(text(),'حذف')]"));

		Confirmation.click();

	}

	public void AddStudentWithMarks() throws InterruptedException {

		WebElement AddBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة طالب')]"));

		AddBtn.click();

		WebElement Name = driver.findElement(By.xpath("//input[@placeholder='اسم الطالب']"));

		String RandomStudentName = StudentsNames[RandomIndexForStudents];

		Name.sendKeys(RandomStudentName);

		Thread.sleep(1000);

		WebElement Gender = driver.findElement(By.xpath("//label[1]//div[1]"));

		Gender.click();

		WebElement ID = driver.findElement(By.xpath("//input[@placeholder='الرقم المدني']"));

		ID.sendKeys("2536021344");

		WebElement Collage = driver.findElement(By.xpath("//select[@name='college_id']"));

		Select select1 = new Select(Collage);

		select1.selectByValue("5");

		WebElement Classification = driver.findElement(By.xpath("//select[@name='department_id']"));

		Select select2 = new Select(Classification);

		select2.selectByValue("13");

		WebElement UniID = driver.findElement(By.xpath("//input[@placeholder='الرقم الجامعي']"));

		UniID.sendKeys("20159020202");

		WebElement PhoneNumber = driver.findElement(By.xpath("//input[@placeholder='رقم الجوال']"));

		String RandomPhone = StudentsPhones[RandomIndexForStudents];

		PhoneNumber.sendKeys(RandomPhone);

		WebElement Email = driver.findElement(By.xpath("//input[@placeholder='البريد الالكتروني']"));

		String RandomEmail = StudentsEmails[RandomIndexForStudents];

		Email.sendKeys(RandomEmail);

		WebElement LevelBtn = driver.findElement(By.xpath("//div[contains(@class,'mb-6 relative')]//button[1]"));

		LevelBtn.click();

		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/input[1]"))
				.sendKeys("88");

		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/input[1]"))
				.sendKeys("89");

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));

		SaveBtn.click();

	}

	public void AddStudentWithoutMarks() throws InterruptedException {

		WebElement AddBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة طالب')]"));

		AddBtn.click();

		WebElement Name = driver.findElement(By.xpath("//input[@placeholder='اسم الطالب']"));

		String RandomStudentName = StudentsNames[RandomIndexForStudents];

		Name.sendKeys(RandomStudentName);

		Thread.sleep(1000);

		WebElement Gender = driver.findElement(By.xpath("//label[1]//div[1]"));

		Gender.click();

		WebElement ID = driver.findElement(By.xpath("//input[@placeholder='الرقم المدني']"));

		ID.sendKeys("2536021344");

		WebElement Collage = driver.findElement(By.xpath("//select[@name='college_id']"));

		Select select1 = new Select(Collage);

		select1.selectByValue("5");

		WebElement Classification = driver.findElement(By.xpath("//select[@name='department_id']"));

		Select select2 = new Select(Classification);

		select2.selectByValue("13");

		WebElement UniID = driver.findElement(By.xpath("//input[@placeholder='الرقم الجامعي']"));

		UniID.sendKeys("20159020202");

		WebElement PhoneNumber = driver.findElement(By.xpath("//input[@placeholder='رقم الجوال']"));

		String RandomPhone = StudentsPhones[RandomIndexForStudents];

		PhoneNumber.sendKeys(RandomPhone);

		WebElement Email = driver.findElement(By.xpath("//input[@placeholder='البريد الالكتروني']"));

		String RandomEmail = StudentsEmails[RandomIndexForStudents];

		Email.sendKeys(RandomEmail);

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));

		SaveBtn.click();

	}

	public void EditStudentGender() throws InterruptedException {

		WebElement EditBtn = driver.findElement(By.xpath("//tbody/tr[5]/td[14]/button[1]"));

		EditBtn.click();

		WebElement Female = driver
				.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/label[2]"));

		Female.click();

		File myFile2 = new File("./Images/Roayaholding.png");

		driver.findElement(By.xpath("//input[contains(@name,'logo')]")).sendKeys(myFile2.getAbsolutePath());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,630)");

		Thread.sleep(1000);

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));

		SaveBtn.click();
	}

	public void DelStudent() throws InterruptedException {

		WebElement DelBtn = driver.findElement(By.xpath("//tbody/tr[10]/td[15]/button[1]"));

		DelBtn.click();

		WebElement ConfirmBtn = driver.findElement(By.xpath("//button[contains(text(),'حذف')]"));

		ConfirmBtn.click();

		boolean Actual = driver.findElement(By.id("notistack-snackbar")).isDisplayed();

		boolean Expected = true;

		Assert.assertEquals(Actual, Expected, "No sucess Messages Apperas ");

	}

	public void RateFilter() throws InterruptedException {

		WebElement FilterBtn = driver.findElement(By.xpath("//img[@alt='filter-icon']"));

		FilterBtn.click();

		Actions actions = new Actions(driver);

		WebElement Slider = driver.findElement(By.xpath("//input[@value='0']"));

		actions.clickAndHold(Slider).moveByOffset(-150, 0).release().perform();

		WebElement SearchBtn = driver.findElement(By.xpath("//img[contains(@alt,'search-icon')]"));

		SearchBtn.click();

		// to click anywhere

		WebElement Body = driver.findElement(By.tagName("body"));
		Body.click();

		List<WebElement> gpaCells = driver
				.findElements(By.xpath("//table[contains(@class,'MuiTable-root relative muirtl-16qsq1p')]//tr/td[7]"));

		System.out.println(gpaCells.size());

		for (int i = 0; i < gpaCells.size(); i++) {

			String SGPA1 = gpaCells.get(i).getText();

			SGPA1 = SGPA1.replace("%", "").trim();

			System.out.println(SGPA1);

			int IGPA = Integer.parseInt(SGPA1);

			System.out.println(IGPA);

			if (IGPA < 99) {

				System.out.println("error in filteration");

			}

		}
	}

	public void AddCv() {

		WebElement RandStudent = driver.findElement(By.xpath("//td[normalize-space()='2536021345']"));

		RandStudent.click();

		WebElement Name = driver.findElement(By.id("name"));

		Name.sendKeys("Automation Test");

		WebElement Number = driver.findElement(By.id("priority"));

		Number.sendKeys("02");

		WebElement Type = driver.findElement(By.id("type"));

		Select select1 = new Select(Type);

		select1.selectByValue("certificate");

		File myFile1 = new File("./Documents/TestFile.pdf");

		driver.findElement(By.id("pdfFile")).sendKeys(myFile1.getAbsolutePath());

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة مرفق')]"));

		SaveBtn.click();

		Boolean Actual = driver.findElement(By.id("notistack-snackbar")).isDisplayed();

		Assert.assertTrue(Actual, " cv not added successfully");

	}

	public void ClickonCv() {

		WebElement RandStudent = driver.findElement(By.xpath("//td[normalize-space()='2536021345']"));

		RandStudent.click();

		String CurrentURL1 = driver.getCurrentUrl();

		WebElement StudentCV = driver.findElement(By.linkText("Automation Test"));

		StudentCV.click();

		String CurrentURL2 = driver.getCurrentUrl();

		if (CurrentURL1 == CurrentURL2) {

			System.out.println("element not interact");

		} else {

			System.out.println("click successfully");

		}

	}

	public void DeleteCv() {

		WebElement RandStudent = driver.findElement(By.xpath("//td[normalize-space()='2536021345']"));

		RandStudent.click();

		WebElement CVDelBtn = driver.findElement(By.xpath("//img[@alt='Automation Test-delete-icon']"));

		CVDelBtn.click();

		WebElement CVDelConfirmation = driver.findElement(By.xpath("//button[contains(text(),'حذف')]"));

		CVDelConfirmation.click();

		Boolean Actual = driver.findElement(By.id("notistack-snackbar")).isDisplayed();

		Assert.assertTrue(Actual, " cv not deleted successfully");

	}

	public void VerifyFileDownloaded() throws InterruptedException {

		String downloadDir = System.getProperty("user.dir") + "\\downloads";

		ChromeOptions options = new ChromeOptions();

		options.addArguments("download.default_directory=" + downloadDir);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement DownloadBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='flex gap-2 actions w-full justify-end']//div[@class='grid w-10 h-10 bg-white rounded-lg cursor-pointer place-items-center']")));

		DownloadBtn.click();

		File downloadFolder = new File(downloadDir);

		if (downloadFolder.exists() && downloadFolder.isDirectory()) {
			// حذف جميع الملفات داخل المجلد
			for (File file : downloadFolder.listFiles()) {
				file.delete();
			}
		}

		File[] filesBefore = downloadFolder.listFiles();

		int timeout = 10;

		File downloadedFile = null;

		for (int i = 0; i < timeout; i++) {
			File[] filesAfter = downloadFolder.listFiles();
			if (filesAfter.length > filesBefore.length) {
				// Find the new file
				downloadedFile = Arrays.stream(filesAfter).filter(file -> file.getName().endsWith(".xlsx"))
						.max(Comparator.comparingLong(File::lastModified)).orElse(null);
				break;
			}
			Thread.sleep(1000);

			File[] files = downloadFolder.listFiles();

			Assert.assertTrue(files != null && files.length > 0, "لم يتم تنزيل أي ملف!");
		}

	}

	// *************************end of university dashboard
	// tests**********************************//

//********************************************************************************************************************************************************************************************************//

	// ************************* Companies dashboard
	// tests**********************************//

	public void CompanyReg() throws InterruptedException {

		WebElement RegisterBtn = driver.findElement(By.cssSelector(
				"button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth h-12 mb-4 muirtl-l9jmqx']"));

		RegisterBtn.click();

		WebElement ComRegisterBtn = driver.findElement(
				By.cssSelector("button[class='MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary muirtl-hwfk4']"));

		Actions actions = new Actions(driver);

		actions.click(ComRegisterBtn).perform();

		String Name = ArCoNames[RandomIndexForCom];

		WebElement NameAr = driver.findElement(By.xpath("//input[@name='name_ar']\r\n"));
		NameAr.sendKeys(Name);

		GlobalComName = Name;

		WebElement UserNameEn = driver.findElement(By.xpath("//input[@name='name_en']\r\n"));
		UserNameEn.sendKeys(EngCoNames[RandomIndexForCom]);

		WebElement CommercialRegister = driver.findElement(By.id("commercial_register"));
		CommercialRegister.sendKeys(CommercialRegisterVal[RandomIndexForCom]);

		String EmailForLogin = CoEmails[RandomIndexForCom];

		WebElement EmailInp = driver.findElement(By.xpath("//input[@name='email']\r\n"));
		EmailInp.sendKeys(EmailForLogin);

		GlobalEmail = EmailForLogin;

		WebElement PhoneInp = driver.findElement(By.xpath("//input[@name='phone']\r\n"));
		PhoneInp.sendKeys(CoPhones[RandomIndexForCom]);

		WebElement Pass2 = driver.findElement(By.xpath("//input[@name='password']\r\n"));
		Pass2.sendKeys(Pass);

		WebElement ConfirmPass = driver.findElement(By.xpath("//input[@name='password_confirmation']\r\n"));
		ConfirmPass.sendKeys(Pass);

		File myFile1 = new File("./Documents/TestFile.pdf");
		File myFile2 = new File("./Images/Roayaholding.png");
		driver.findElement(By.xpath("//input[contains(@name,'pdfile')]")).sendKeys(myFile1.getAbsolutePath());
		driver.findElement(By.xpath("//input[contains(@name,'logo')]")).sendKeys(myFile2.getAbsolutePath());

		WebElement EmailOtp = driver.findElement(By.id("otpMail"));
		EmailOtp.sendKeys(OTP);

		WebElement PhoneOtp = driver.findElement(By.id("verificationCodePhone"));
		PhoneOtp.sendKeys(OTP);

		WebElement SubmitBtn = driver.findElement(By.xpath("//button[contains(text(),'تسجيل جديد')]"));
		SubmitBtn.click();

		Thread.sleep(1000);

	}

	public void ComLogin() throws InterruptedException {

		driver.get(MyWebsiteurl);

		WebElement EmailField = driver.findElement(By.id("email"));

		WebElement PassField = driver.findElement(By.id("password"));

		EmailField.sendKeys("roayaholding@gmail.com");
		PassField.sendKeys("12345678");

		driver.findElement(By.xpath("//button[contains(text(),'طلب رمز التحقق')]")).click();
		Thread.sleep(1000);
		WebElement OTPInput = driver.findElement(By.id("otp"));

		OTPInput.sendKeys(OTP);

		WebElement LoginBtn = driver.findElement(By.xpath("//button[contains(text(),'تسجيل دخول')]"));

		LoginBtn.click();

	}

	public void AddJobWithoutDelegacy() throws InterruptedException {

		WebElement AddJobBtn = driver.findElement(By.xpath("//span[contains(text(),'إضافة وظيفة')]"));

		AddJobBtn.click();

		WebElement DateField = driver.findElement(By.xpath("//input[@placeholder='تاريخ انتهاء الإعلان']"));

		DateField.click();

		DateField.sendKeys(Keys.ENTER);

		WebElement PositionField = driver.findElement(By.xpath("//input[@placeholder='المسمى الوظيفي']"));

		PositionField.sendKeys("مبرمج فرونت اند");

		WebElement CountField = driver.findElement(By.xpath("//input[@placeholder='العدد']"));

		CountField.sendKeys("3");

		WebElement GenderField = driver.findElement(By.xpath("//img[contains(@alt,'female')]"));

		GenderField.click();

		WebElement ConTypeField = driver
				.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/select[1]"));

		Select selector1 = new Select(ConTypeField);

		selector1.selectByValue("4");

		WebElement DurationField = driver.findElement(By.xpath("//input[@placeholder='مدة التعاقد']"));

		DurationField.sendKeys("1");

		WebElement PlaceField = driver.findElement(By.xpath("//div[13]//select[1]"));

		Select selector2 = new Select(PlaceField);

		selector2.selectByValue("3");

		WebElement SalaryField = driver.findElement(By.xpath("//input[contains(@placeholder,'الراتب')]"));

		SalaryField.sendKeys("5000");

		WebElement OverTimeField = driver.findElement(By.xpath("//input[contains(@placeholder,'المكافأة')]"));

		OverTimeField.sendKeys("500");

		WebElement UniField = driver.findElement(By.xpath(
				"//div[contains(@class,'MuiAutocomplete-root MuiAutocomplete-fullWidth MuiAutocomplete-hasPopupIcon bg-white rounded-2xl muirtl-5xgjxw')]"));

		UniField.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='أميال للتسويق';", UniField);

		String enteredValue1 = UniField.getAttribute("value");

		System.out.println("Entered Value in Uni: " + enteredValue1);

		WebElement CollagesField = driver.findElement(By.xpath("//input[@placeholder='اختيار الكلية']"));

		js.executeScript("arguments[0].value='تقنية معلومات';", CollagesField);

		String enteredValue2 = CollagesField.getAttribute("value");

		System.out.println("Entered Value in Collages: " + enteredValue2);

		WebElement ClassField = driver.findElement(By.xpath("//input[@placeholder='اختيار التخصص']"));

		js.executeScript("arguments[0].value='نظم معلومات حاسوبية';", ClassField);

		String enteredValue3 = ClassField.getAttribute("value");

		System.out.println("Entered Value in Collages: " + enteredValue3);

		WebElement TasksField = driver
				.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input muirtl-mnn31')]"));

		TasksField.sendKeys("إنشاء واجهات ويب");

		WebElement AddMoreTasksBtn = driver.findElement(By.xpath("//button[contains(text(),'إضافة مهمة رئيسية')]"));

		AddMoreTasksBtn.click();

		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[24]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(" تصميم واجهة المستخدم");

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'حفظ وإرسال')]"));

		SaveBtn.click();

		Thread.sleep(1000);

		assertTrue(driver.findElement(By.id("notistack-snackbar")).isDisplayed(), "JOB NOT ADDED");
		
		Thread.sleep(1000);

	}

	public void AddJobWithFilter() throws InterruptedException, IOException {

		WebElement AddJobBtn = driver.findElement(By.xpath("//span[contains(text(),'إضافة وظيفة')]"));

		AddJobBtn.click();

		WebElement DateField = driver.findElement(By.xpath("//input[@placeholder='تاريخ انتهاء الإعلان']"));

		DateField.click();

		DateField.sendKeys(Keys.ENTER);

		WebElement PositionField = driver.findElement(By.xpath("//input[@placeholder='المسمى الوظيفي']"));

		PositionField.sendKeys("محاسب");

		WebElement CountField = driver.findElement(By.xpath("//input[@placeholder='العدد']"));

		CountField.sendKeys("1");

		WebElement GenderField = driver.findElement(By.xpath("//img[@alt='male']"));

		GenderField.click();

		WebElement ConTypeField = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > form:nth-child(2) > div:nth-child(9) > select:nth-child(2)"));

		Select selector1 = new Select(ConTypeField);

		selector1.selectByValue("4");

		WebElement DurationField = driver.findElement(By.xpath("//input[@placeholder='مدة التعاقد']"));

		DurationField.sendKeys("2");

		WebElement PlaceField = driver.findElement(By.xpath("//div[11]//select[1]"));

		Select selector2 = new Select(PlaceField);

		selector2.selectByValue("4");

		WebElement SalaryField = driver.findElement(By.xpath("//input[contains(@placeholder,'الراتب')]"));

		SalaryField.sendKeys("2000");

		WebElement OverTimeField = driver.findElement(By.xpath("//input[contains(@placeholder,'المكافأة')]"));

		OverTimeField.sendKeys("100");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1400)");

		WebElement GPAFilter = driver.findElement(By.xpath("//label[contains(text(),'اظهار فلتر المعدل التراكمي')]"));

		GPAFilter.click();

		Actions actions = new Actions(driver);

		WebElement Slider = driver.findElement(By.xpath("//input[@value='0']"));

		actions.clickAndHold(Slider).moveByOffset(-50, 0).release().perform();

		WebElement TasksField = driver
				.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input muirtl-mnn31')]"));

		TasksField.sendKeys("إنشاء واجهات ويب");

		driver.findElement(By.xpath("//button[contains(text(),'إضافة مهمة فرعية')]")).click();

		WebElement SubTasksField = driver
				.findElement(By.xpath("//div//div//div//div//div[2]//div[1]//div[1]//div[1]//input[1]"));

		SubTasksField.sendKeys("تطوير التصاميم وتحسينها");

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'حفظ وإرسال')]"));

		SaveBtn.click();

		Thread.sleep(3000);

		String CurrentURL = driver.getCurrentUrl();

		String ExpectedURL = "https://kawader.amyalsmart.com/board/companies/1/companiesManagement";

		if (CurrentURL.equals(ExpectedURL)) {

			System.out.println("the job added sucessfully");

		} else {

			System.out.println("there is issue in adding jobs ");

			ScreenShot();

		}

	}

	public void AddJobWithDelegacy() throws InterruptedException, IOException {

		WebElement AddJobBtn = driver.findElement(By.xpath("//span[contains(text(),'إضافة وظيفة')]"));

		AddJobBtn.click();

		WebElement DelBtn1 = driver.findElement(By.xpath(
				"//label[contains(@class,'text-xs font-bold cursor-pointer 2xl:text-sm')][contains(text(),'تفويض جهة أخرى')]"));

		DelBtn1.click();

		WebElement DelInput2 = driver.findElement(By.id("company_list"));

		DelInput2.click();

		Thread.sleep(1000);

		DelInput2.sendKeys(Keys.ARROW_DOWN);

		Thread.sleep(1000);

		DelInput2.sendKeys(Keys.ENTER);

		WebElement ConType = driver.findElement(By.xpath("//label[contains(text(),'مبلغ ثابت ( 2000 ) ريال')]"));

		ConType.click();

		WebElement DateField = driver.findElement(By.xpath("//input[@placeholder='تاريخ انتهاء الإعلان']"));

		DateField.click();

		Thread.sleep(1000);

		DateField.sendKeys(Keys.ENTER);

		WebElement PositionField = driver.findElement(By.xpath("//input[@placeholder='المسمى الوظيفي']"));

		PositionField.sendKeys("مبرمج فرونت اند");

		WebElement CountField = driver.findElement(By.xpath("//input[@placeholder='العدد']"));

		CountField.sendKeys("1");

		WebElement GenderField = driver.findElement(By.xpath("//img[contains(@alt,'male')]"));

		GenderField.click();

		WebElement ConTypeField = driver
				.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/select[1]"));

		Select selector1 = new Select(ConTypeField);

		selector1.selectByValue("4");

		WebElement DurationField = driver.findElement(By.xpath("//input[@placeholder='مدة التعاقد']"));

		DurationField.sendKeys("1");

		WebElement PlaceField = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(11) > select:nth-child(2)"));

		Select selector2 = new Select(PlaceField);

		selector2.selectByValue("3");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement SalaryField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'الراتب')]")));

		SalaryField.sendKeys("4000");

		WebElement OverTimeField = driver.findElement(By.xpath("//input[contains(@placeholder,'المكافأة')]"));

		OverTimeField.sendKeys("200");

		WebElement TasksField = driver
				.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input muirtl-mnn31')]"));

		TasksField.sendKeys("إنشاء واجهات ويب");

		WebElement AddSubTasksBtn = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(23) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)"));

		AddSubTasksBtn.click();

		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(23) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"))
				.sendKeys(" تصميم واجهة المستخدم");

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'حفظ وإرسال')]"));

		SaveBtn.click();

		Thread.sleep(3000);

		String CurrentURL = driver.getCurrentUrl();

		String ExpectedURL = "https://kawader.amyalsmart.com/board/companies/1/companiesManagement";

		if (CurrentURL.equals(ExpectedURL)) {

			System.out.println("the job added sucessfully");

		} else {

			System.out.println("there is issue in adding jobs ");

			ScreenShot();

		}

	}

	public void SaveDraftBtn() throws InterruptedException, IOException {

		WebElement AddJobBtn = driver.findElement(By.xpath("//span[contains(text(),'إضافة وظيفة')]"));

		AddJobBtn.click();

		WebElement PositionField = driver.findElement(By.xpath("//input[@placeholder='المسمى الوظيفي']"));

		PositionField.sendKeys("مبرمج فرونت اند");

		WebElement SaveDraftBtn = driver.findElement(By.cssSelector("button[aria-label='حفظ كنموذج']"));

		SaveDraftBtn.click();

		driver.navigate().back();

		WebElement AddJobBtn2 = driver.findElement(By.xpath("//span[contains(text(),'إضافة وظيفة')]"));

		AddJobBtn2.click();

		Thread.sleep(1000);

		WebElement PositionField2 = driver.findElement(By.xpath("//input[@placeholder='المسمى الوظيفي']"));

		String CurrentText = PositionField2.getAttribute("value");

		System.out.println(CurrentText);

		Thread.sleep(2000);

		if (CurrentText.equals("مبرمج فرونت اند")) {

			System.out.println("Every Thing Is Ok,And The Value Saved ");

		} else {

			System.out.println("Btn Not Working");

		}

	}

	public void AddJobManyUnis() throws InterruptedException {

		WebElement AddJobBtn = driver.findElement(By.xpath("//span[contains(text(),'إضافة وظيفة')]"));

		AddJobBtn.click();

		WebElement DateField = driver.findElement(By.xpath("//input[@placeholder='تاريخ انتهاء الإعلان']"));

		DateField.click();

		DateField.sendKeys(Keys.ENTER);

		WebElement PositionField = driver.findElement(By.xpath("//input[@placeholder='المسمى الوظيفي']"));

		PositionField.sendKeys("محاسب");

		WebElement CountField = driver.findElement(By.xpath("//input[@placeholder='العدد']"));

		CountField.sendKeys("1");

		WebElement GenderField = driver.findElement(By.xpath("//img[contains(@alt,'both')]"));

		GenderField.click();

		WebElement ConTypeField = driver
				.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/select[1]"));

		Select selector1 = new Select(ConTypeField);

		selector1.selectByValue("4");

		WebElement DurationField = driver.findElement(By.xpath("//input[@placeholder='مدة التعاقد']"));

		DurationField.sendKeys("1");

		WebElement PlaceField = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(11) > select:nth-child(2)"));

		Select selector2 = new Select(PlaceField);

		selector2.selectByValue("3");

		WebElement SalaryField = driver.findElement(By.xpath("//input[contains(@placeholder,'الراتب')]"));

		SalaryField.sendKeys("3000");

		WebElement OverTimeField = driver.findElement(By.xpath("//input[contains(@placeholder,'المكافأة')]"));

		OverTimeField.sendKeys("500");

		WebElement UniField = driver.findElement(By.xpath(
				"//div[contains(@class,'MuiAutocomplete-root MuiAutocomplete-fullWidth MuiAutocomplete-hasPopupIcon bg-white rounded-2xl muirtl-5xgjxw')]"));

		UniField.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='أميال للتسويق';", UniField);

		String enteredValue1 = UniField.getAttribute("value");

		System.out.println("Entered Value in Uni: " + enteredValue1);

		WebElement AddUniField = driver.findElement(By.xpath("//button[contains(text(),'اضافة جامعة اخرى')]"));

		AddUniField.click();

		WebElement ScndUniField = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(19) > div:nth-child(2) > div:nth-child(1)"));

		ScndUniField.click();

		js.executeScript("arguments[0].value='اميال اللوجستية';", ScndUniField);

		String enteredValue2 = ScndUniField.getAttribute("value");

		System.out.println("Entered Value in Uni: " + enteredValue2);

		WebElement SaveBtn = driver.findElement(By.xpath("//button[contains(text(),'حفظ وإرسال')]"));

		SaveBtn.click();

		Thread.sleep(1000);

		assertTrue(driver.findElement(By.id("notistack-snackbar")).isDisplayed(), "JOB NOT ADDED");

	}

	public void SentFor() throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(text(),'مبرمج فلاتر')]")).click();

		String SentForTotal1 = driver.findElement(By.cssSelector(
				"div[class='p-4 flex flex-col justify-between bg-white rounded-xl border max-h-[120px] border-[#E2E2E2]'] h3[class='text-2xl font-bold']"))
				.getText();

		int TotalStudents1 = Integer.parseInt(SentForTotal1);

		WebElement SentForBtn = driver.findElement(By.linkText("المرسل لهم"));

		SentForBtn.click();

		String SentForTotal2 = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"))
				.getText();

		int TotalStudents2 = Integer.parseInt(SentForTotal2);

		assertEquals(TotalStudents1, TotalStudents2, "Sent For Total Is Wrong");

		if (TotalStudents1 == TotalStudents2) {

			System.out.println("Sent For Total Is Correct");
			System.out.println("The Total In Job Details is:" + TotalStudents1);
			System.out.println("The Total In Job Sent For is:" + TotalStudents2);

		} else {

			System.out.println("Sent For Total Is Wrong");
			System.out.println("The Total In Job Details is:" + TotalStudents1);
			System.out.println("The Total In Job Sent For is:" + TotalStudents2);

		}

	}

	public void CompareMaleAndFemale() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement SentForBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المرسل لهم")));

		SentForBtn.click();

		String SentForTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")))
				.getText();

		int TotalStudents = Integer.parseInt(SentForTotal);

		String SentForFemaleTotal = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1)"))
				.getText();

		int TotalFemale = Integer.parseInt(SentForFemaleTotal);

		String SentFormaleTotal = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1)"))
				.getText();

		int Totalmale = Integer.parseInt(SentFormaleTotal);

		int TotalBoth = TotalFemale + Totalmale;

		assertEquals(TotalStudents, TotalBoth, "Sent For Total Is wrong,and male and female total wrong");

		if (TotalBoth == TotalStudents) {

			System.out.println("Sent For Total Is Correct,and male and female total correct");
			System.out.println("The Total In  Sent For is:" + TotalStudents);
			System.out.println("The Female Total  is:" + TotalFemale);
			System.out.println("The male Total  is:" + Totalmale);

		} else {

			System.out.println("Sent For Total Is wrong,and male and female total wrong");
			System.out.println("The Total In Sent For is:" + TotalStudents);
			System.out.println("The Female Total  is:" + TotalFemale);
			System.out.println("The male Total  is:" + Totalmale);

		}

	}

	public void CancelJob() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement SentForBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المرسل لهم")));

		SentForBtn.click();

		WebElement CancelJobBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2) > button:nth-child(1)")));

		CancelJobBtn.click();

		WebElement Conf = driver.findElement(By.cssSelector(
				".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-colorPrimary.MuiButton-fullWidth.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-colorPrimary.MuiButton-fullWidth.gap-2.muirtl-lso46a"));

		Conf.click();

	}

	public void JobDetails() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement SentForBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المرسل لهم")));

		SentForBtn.click();

		String SentForTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")))
				.getText();

		int TotalStudents = Integer.parseInt(SentForTotal);

		System.out.println(TotalStudents);

		WebElement JobDetailsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")));

		JobDetailsBtn.click();

		WebElement Table = driver.findElement(By.cssSelector(".MuiTableBody-root.muirtl-1xnox0e"));

		List<WebElement> Rows = Table.findElements(By.tagName("tr"));

		int TotalRows = Rows.size();

		System.out.println("Total number of rows in the table: " + TotalRows);

		if (TotalStudents == TotalRows) {

			System.out.println(
					"The Total Before Click On Details Equals The Students Total in the Table ,EveryThing Is OK");

		} else {

			System.out.println(
					"The Total Before Click On Details Dont Equals The Students Total in the Table ,There IS Error ");

		}

	}

	public void DetermineInterview() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement AppliedBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المتقدمين")));

		AppliedBtn.click();

		WebElement JobDetailsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")));

		JobDetailsBtn.click();

		WebElement StudentMoh = driver.findElement(By.cssSelector(
				"tr[class='MuiTableRow-root cursor-pointer hover:bg-[#d1d1d1] muirtl-t25elq'] td:nth-child(1)"));

		StudentMoh.click();

		WebElement InterviewDate = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));

		InterviewDate.click();

		driver.findElement(By.xpath("//abbr[contains(@aria-label,'27 ديسمبر 2024')]")).click();

		WebElement InterviewTime = driver.findElement(By.cssSelector(
				"div[class='MuiButtonBase-root MuiAccordionSummary-root MuiAccordionSummary-gutters !bg-white rounded-t-xl muirtl-1oqimao']"));

		InterviewTime.click();

		WebElement StartTime = driver.findElement(By.xpath("//input[@type='number' and @min='0' and @max='59']"));

		StartTime.sendKeys("40");

		String InterviewDuration = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"))
				.getText();

		System.out.println(InterviewDuration);

		WebElement InterviewLocation = driver.findElement(By.cssSelector("input[name='1st']"));

		InterviewLocation.click();

		WebElement Confirmation1 = driver.findElement(By.cssSelector(
				"button[class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth gap-2 !py-3 muirtl-gfnoik']"));

		Confirmation1.click();

		WebElement Interviewer = driver.findElement(By.cssSelector("input[value='87']"));

		Interviewer.click();

		WebElement Confirmation2 = driver.findElement(By.cssSelector("button[type='submit']"));

		Confirmation2.click();

		Thread.sleep(1000);

		WebElement RequiredForInterviewBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المطلوبين للمقابلة")));

		RequiredForInterviewBtn.click();

		WebElement JobDetailsBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")));

		JobDetailsBtn2.click();

		boolean StudentActual = driver.findElement(By.xpath("//*[contains(text(), 'محمد ايسر')]")).isDisplayed();

		assertTrue(StudentActual, "Can't find the student in the required for interview section");

	}

	public void StartInterview() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement RequiredForInterviewBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المطلوبين للمقابلة")));

		RequiredForInterviewBtn.click();

		WebElement JobDetailsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div:nth-child(3) div:nth-child(2) div:nth-child(2) button:nth-child(1)")));

		JobDetailsBtn.click();

		WebElement StudentMoh = driver.findElement(By.cssSelector(
				"tr[class='MuiTableRow-root cursor-pointer hover:bg-[#d1d1d1] muirtl-1jec563'] td:nth-child(1)"));

		StudentMoh.click();

//		WebElement Confirmation2 = driver.findElement(By.cssSelector("button[type='submit']"));
//
//		Confirmation2.click();
//
//		boolean StudentActual = driver.findElement(By.xpath("//*[contains(text(), 'محمد ايسر')]")).isDisplayed();
//
//		assertTrue(StudentActual, "Can't find the student in the required for interview section");

	}

	public void AcceptStudent() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement RequiredForInterviewBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المطلوبين للمقابلة")));

		RequiredForInterviewBtn.click();

		WebElement JobDetailsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")));

		JobDetailsBtn.click();

		WebElement StudentMoh = driver.findElement(By.cssSelector(
				"tr[class='MuiTableRow-root cursor-pointer hover:bg-[#d1d1d1] muirtl-1jec563'] td:nth-child(3)"));

		StudentMoh.click();

		WebElement Description = driver.findElement(By.cssSelector("input[placeholder='الوصف الختامي']"));

		Description.sendKeys("All Required Skills Available");
		;

		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > button:nth-child(1)"))
				.click();

		WebElement Feedback = driver.findElement(By.cssSelector("textarea[id=':r2m:']"));

		Feedback.sendKeys("good");

		WebElement DateField = driver.findElement(By.cssSelector("label[id=':r38:-label']"));
		
		DateField.click();

		DateField.sendKeys(Keys.ENTER);
		
		WebElement ConfirmationBtn=driver.findElement(By.cssSelector(""));
		
		ConfirmationBtn.click();
		
		WebElement AcceptedBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("المقبولين")));

		AcceptedBtn.click();

		WebElement JobDetailsBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")));

		JobDetailsBtn2.click();

		Boolean StudentNeveen  = driver.findElement(By.cssSelector(
				"tr[class='MuiTableRow-root cursor-pointer hover:bg-[#d1d1d1] muirtl-1jec563'] td:nth-child(3)")).isDisplayed()
				;
		
		assertTrue(StudentNeveen, "there is something wrong ");

	}

	// ************************* end of companies dashboard
	// tests**********************************//

	public void ScreenShot() throws InterruptedException, IOException {

		Thread.sleep(2000);

		Date myDate = new Date();

		String FileName = myDate.toString().replace(":", "-");

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);

		File destFile = new File("./screenshot/" + FileName + ".png");
		FileUtils.copyFile(SrcFile, destFile);

	}

	public void InstitutesReg() throws InterruptedException {

		WebElement RegisterBtn = driver.findElement(By.xpath("//button[contains(text(),'تسجيل جديد')]"));

		RegisterBtn.click();

		WebElement InsRegisterBtn = driver.findElement(By.xpath("//h6[contains(text(),'معهد')]"));

		Actions actions = new Actions(driver);

		actions.click(InsRegisterBtn).perform();

		String UserName = ArUniNames[RandomIndexForUni];

		WebElement UserNameAr = driver.findElement(By.xpath("//input[@name='name_ar']\r\n"));
		UserNameAr.sendKeys(UserName);

		WebElement UserNameEn = driver.findElement(By.xpath("//input[@name='name_en']\r\n"));
		UserNameEn.sendKeys(EngUniNames[RandomIndexForUni]);

		File myFile = new File("./Images/Roayaholding.png");
		driver.findElement(By.xpath("//input[contains(@name,'logo')]")).sendKeys(myFile.getAbsolutePath());

		WebElement LeaderName = driver.findElement(By.xpath("//input[@placeholder='اسم الموظف']"));

		LeaderName.sendKeys("NeveenSameer");

		WebElement PhoneInp = driver.findElement(By.cssSelector("input[placeholder='رقم الجوال']"));
		PhoneInp.sendKeys(Phones2[RandomIndexForUni]);

		String EmailForLogin = InEmails[RandomIndexForUni];

		WebElement EmailInp = driver.findElement(By.xpath("//input[@placeholder='البريد الإلكتروني']"));
		EmailInp.sendKeys(EmailForLogin);

		GlobalEmail = EmailForLogin;

		WebElement Pass2 = driver.findElement(By.id("password"));
		Pass2.sendKeys(Pass);

		WebElement ConfirmPass = driver.findElement(By.id("password_confirmation"));

		ConfirmPass.sendKeys(Pass);

	}

	public void SuperAdminLogin() throws InterruptedException {

		driver.get(MyWebsiteurl);

		WebElement EmailField = driver.findElement(By.id("email"));

		WebElement PassField = driver.findElement(By.id("password"));

		EmailField.sendKeys(SuperAdminMail);
		PassField.sendKeys(SuperAdminPass);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'طلب رمز التحقق')]")).click();
		Thread.sleep(1000);
		WebElement OTPInput = driver.findElement(By.id("otp"));

		OTPInput.sendKeys(OTP);

		WebElement LoginBtn = driver.findElement(By.xpath("//button[contains(text(),'تسجيل دخول')]"));

		LoginBtn.click();

	}

	public void VerifyUniSectionAppears() throws InterruptedException {

		Thread.sleep(2000);

		WebElement UniSection = driver.findElement(By.xpath("//img[@alt='الجامعات']"));
		Assert.assertTrue(UniSection.isDisplayed(), "Uni Button is not visible");

		UniSection.click();

	}

	public void VerifyComSectionAppears() throws InterruptedException {

		Thread.sleep(2000);

		WebElement ComSection = driver.findElement(By.xpath("//img[@alt='الشركات']"));
		Assert.assertTrue(ComSection.isDisplayed(), "Company  Section is not visible");

		ComSection.click();

	}

	public void VerifyReqSectionAppears() throws InterruptedException {

		Thread.sleep(2000);

		WebElement ReqSection = driver.findElement(By.xpath("//img[@alt='شركات التوظيف']"));
		Assert.assertTrue(ReqSection.isDisplayed(), " Recruitment companies Section is not visible");

		ReqSection.click();

	}

	public void VerifyInstitutesSectionAppears() throws InterruptedException {

		Thread.sleep(2000);

		WebElement InstitutesSection = driver.findElement(By.xpath("//img[@alt='المعاهد']"));
		Assert.assertTrue(InstitutesSection.isDisplayed(), " Recruitment companies Section is not visible");

		InstitutesSection.click();

	}

	public void verifyAllUniCardsPresence() {

		WebElement IconSection = driver.findElement(By.xpath("//h3[contains(text(),'الجامعات')]"));
		WebElement TitleSection = driver.findElement(By.xpath("//img[@alt='university-icon']"));
		WebElement ZoomSection = driver.findElement(By.className("MuiSlider-rail muirtl-3ndvyc"));
		WebElement AddUniSection = driver.findElement(By.xpath("//button[@class='px-4 hover:bg-"));

		List<WebElement> AllUniCards = driver.findElements(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));

		List<WebElement> UniNamesSection = driver
				.findElements(By.cssSelector(".w-full.h-full.bg-[#EFEFEF].grid.place-items-center.p-3"));
		List<WebElement> UniPhotosSection = driver.findElements(By.cssSelector(".w-20.h-20"));
		List<WebElement> EditUnisSection = driver.findElements(By.xpath("//img[@alt='edit-icon']"));
		List<WebElement> DelUnisSection = driver.findElements(By.xpath("//img[@alt='delete-icon']"));
		List<WebElement> ActivationSection = driver.findElements(By.className("toggle-thumb"));

	}

	public void CheckEditFunWithValidData() throws InterruptedException {

		WebElement EditIcon = driver.findElement(By.xpath("//img[@alt='edit-icon']"));
		Assert.assertTrue(EditIcon.isDisplayed(), " edit  Section is not visible");

		EditIcon.click();

		WebElement UserNameAr = driver.findElement(By.xpath("//input[@name='name_ar']\r\n"));

		UserNameAr.clear();

		UserNameAr.sendKeys("neveen");

		WebElement SaveChangesBtn = driver.findElement(By.cssSelector(".MuiTouchRipple-root.muirtl-w0pj6f"));

		SaveChangesBtn.click();

		String ActualsuccessMessage = driver.findElement(By.id("notistack-snackbar")).getText();

		String ExpectedsuccessMessage = "تم تحديث الجامعة بنجاح";

		AssertJUnit.assertEquals(ActualsuccessMessage, ExpectedsuccessMessage);

		String UpdatedField = driver
				.findElement(By.cssSelector(".w-full.h-full.bg-[#EFEFEF].grid.place-items-center.p-3")).getText();

		AssertJUnit.assertEquals(UpdatedField, "neveen", "The name was not updated correctly");

	}

	public void CheckEditFunWithInValidData() throws InterruptedException {

		WebElement EditIcon = driver.findElement(By.xpath("//img[@alt='edit-icon']"));
		Assert.assertTrue(EditIcon.isDisplayed(), " edit  Section is not visible");

		EditIcon.click();

		WebElement PhoneField = driver.findElement(By.xpath("//input[@type='email']"));

		PhoneField.clear();

		PhoneField.sendKeys("56666666");

		WebElement SaveChangesBtn = driver.findElement(By.cssSelector(".MuiTouchRipple-root.muirtl-w0pj6f"));

		SaveChangesBtn.click();

		String ActualMessage = driver.findElement(By.cssSelector(".text-xs.text-red-500.error")).getText();

		String ExpectedMessage = "رقم الهاتف غير صحيح";

		AssertJUnit.assertEquals(ActualMessage, ExpectedMessage, "accept phone less than 9 digits ");

	}

	public void CheckEditFunWithoutAnyChange() throws InterruptedException {

		WebElement EditIcon = driver.findElement(By.xpath("//img[@alt='edit-icon']"));
		Assert.assertTrue(EditIcon.isDisplayed(), " edit  Section is not visible");

		EditIcon.click();

		WebElement SaveChangesBtn = driver.findElement(By.cssSelector(".MuiTouchRipple-root.muirtl-w0pj6f"));

		SaveChangesBtn.click();

		String ActualMessage = driver.findElement(By.id("notistack-snackbar")).getText();

		String ExpectedMessage = "تم تحديث الجامعة بنجاح";

		AssertJUnit.assertEquals(ActualMessage, ExpectedMessage);

	}

	public void CheckAddUniBtn() throws InterruptedException {

		WebElement AddUniBtn = driver.findElement(By.xpath("//button[@class='px-4 hover:bg-"));

		AddUniBtn.click();

		WebElement UserNameAr = driver.findElement(By.xpath("//input[@name='name_ar']\r\n"));
		UserNameAr.sendKeys("جامعة اليرموك ");

		WebElement UserNameEn = driver.findElement(By.xpath("//input[@name='name_en']\r\n"));
		UserNameEn.sendKeys("Yarmouk Uni");

		File myFile = new File("./Images/Logo.png");
		driver.findElement(By.xpath("//input[contains(@name,'logo')]")).sendKeys(myFile.getAbsolutePath());

		WebElement Name1 = driver.findElement(By.xpath("//input[@name='name']\r\n"));
		Name1.sendKeys("Neveen");

		WebElement EmailInp = driver.findElement(By.xpath("//input[@name='email']\r\n"));
		EmailInp.sendKeys("neveen@hotmail.com");

		WebElement PhoneInp = driver.findElement(By.xpath("//input[@name='phone']\r\n"));
		PhoneInp.sendKeys("0593333333");

		WebElement Pass2 = driver.findElement(By.xpath("//input[@name='password']\r\n"));
		Pass2.sendKeys("neveenmohammad");

		WebElement ConfirmPass = driver.findElement(By.xpath("//input[@name='password_confirmation']\r\n"));
		ConfirmPass.sendKeys("neveenmohammad");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(1000);

		String ActualURL = driver.getCurrentUrl();

		String ExpectedURL = "https://kawader.amyalsmart.com/super/universities";

		AssertJUnit.assertEquals(ActualURL, ExpectedURL);

	}

	public void CheckdeleteFun() throws InterruptedException {

		WebElement RandomItem = driver.findElement(By.xpath("//body//div//div[4]"));

		WebElement DeleteIcon = driver.findElement(By.xpath("//img[@alt='delete-icon']"));

		Assert.assertTrue(DeleteIcon.isDisplayed(), " delete  Section is not visible");

		DeleteIcon.click();

		WebElement ConfirmationMsg = driver.findElement(By.xpath("//button[contains(text(),'حذف')]"));

		ConfirmationMsg.click();

		String ActualMessage = driver.findElement(By.id("notistack-snackbar")).getText();

		String ExpectedMessage = "تم حذف الجامعة بنجاح";

		Assert.assertEquals(ActualMessage, ExpectedMessage);

		Assert.assertNull(RandomItem, "The item was not deleted!");

	}

	public void CheckSwitchFun() throws InterruptedException {

		WebElement RandomItem = driver.findElement(By.xpath("//body//div//div[4]"));

		WebElement SwitchIcon = driver.findElement(By.className("toggle-thumb"));

		Assert.assertTrue(SwitchIcon.isDisplayed(), " Switch Section is not visible");

		SwitchIcon.click();

		WebElement ConfirmationMsg = driver.findElement(By.xpath("//button[contains(text(),'نعم')]"));

		ConfirmationMsg.click();

		boolean ActualMessage = driver.findElement(By.id("notistack-snackbar")).isDisplayed();

		boolean ExpectedMessage = true;

	}

	public void CheckLogout() throws InterruptedException {

		driver.findElement(By.xpath(
				"//div[@class='flex items-center justify-center gap-2 my-6 text-sm font-semibold text-gray-500 cursor-pointer signout']"))
				.click();

	}

}
