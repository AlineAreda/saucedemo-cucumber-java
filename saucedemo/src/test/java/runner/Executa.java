package runner;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import drivers.Drivers;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features",
		glue = "steps",
		tags = "@login",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target/report-cucumber.html" },
		snippets = SnippetType.CAMELCASE)

public class Executa extends Drivers {

	public static void abrirNavegador() {
		boolean headless = false;
		String site = "https://www.saucedemo.com/";
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		if (headless) {
			chromeOptions.addArguments("--headless");
		}

		driver = new ChromeDriver(chromeOptions);
		driver.get(site);
	}

	public static void fecharNavegador() {
		driver.quit();
	}

	public static void evidencia(String testeEvidencia) {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias" + testeEvidencia + ".png");

		try {
			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
