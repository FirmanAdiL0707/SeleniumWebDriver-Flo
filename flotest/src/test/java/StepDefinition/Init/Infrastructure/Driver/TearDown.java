package StepDefinition.Init.Infrastructure.Driver;

import org.openqa.selenium.WebDriver;

import PageObject.ProtocolEditorPage;
import PageObject.ProtocolExplorerPage;
import io.cucumber.java.After;

public class TearDown {

    private WebDriver driver;
    private ProtocolEditorPage _protocolEditorPage;

    public TearDown() {
        this.driver = Setup.driver;
        this._protocolEditorPage = new ProtocolEditorPage();
    }

    // @After
    // public void quitDriver(){
    //     this.driver.quit();
    // }
  
    
  @After("@CloseThePage")
  public void CloseThePage(){
    
      this.driver.quit();
  }

  @After("@delete1")
  public void DeleteStep1() {
    _protocolEditorPage.DeleteStep1();
  }

  @After("@delete2")
  public void DeleteStep2() throws InterruptedException {
    _protocolEditorPage.SelectStep1();
    Thread.sleep(10000);
    _protocolEditorPage.DeleteStep2();
    _protocolEditorPage.DeleteStep1Selected();
  }

  @After("@delete3")
  public void DeleteStep3() throws InterruptedException {
    _protocolEditorPage.SelectStep1();
    _protocolEditorPage.DeleteStep3();
    Thread.sleep(3000);
    _protocolEditorPage.DeleteStep2();
    Thread.sleep(3000);
    _protocolEditorPage.DeleteStep1Selected();
  }

}
