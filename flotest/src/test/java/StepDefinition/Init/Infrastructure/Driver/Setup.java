package StepDefinition.Init.Infrastructure.Driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class Setup {
    public static WebDriver driver;

    @Before
    public void LaunchTiga() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
          "D:/Formulatrix/Automation/Flo Automation/flotest/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1536, 825));
        driver.navigate().to("http://raspberrypi:5005/");
        // pex = new ProtocolExplorerPage(driver);
        // ped = new ProtocolEditorPage(driver);
        // st = new SimpleTransferPage(driver);
        // ed = new ExperimentDesignerPage(driver);
        // _serialDilutionPage = new SerialDilutionPage(driver);
    }
}
