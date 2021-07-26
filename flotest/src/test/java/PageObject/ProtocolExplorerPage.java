package PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinition.Init.Base.BaseClass;
import StepDefinition.Init.Infrastructure.Driver.Action;

public class ProtocolExplorerPage extends BaseClass{

  // LOGIN
  private By USERNAME = By.cssSelector(
      "#content > div.login-box-container > div > div.login-box-body > div:nth-child(3) > div:nth-child(1) > input");
  private By PASSWORD = By.cssSelector(
      "#content > div.login-box-container > div > div.login-box-body > div:nth-child(3) > div:nth-child(2) > input");
  private By SIGNIN = By.cssSelector(
      "#content > div.login-box-container > div > div.login-box-body > div:nth-child(3) > div.row > div > button");
  private By NORESTORE = By.cssSelector(
      "#content > div.login-box-container > div > div.login-box-body > div.restore > div.row > div:nth-child(2) > button");
  private By LOADING = By.className("fmlx-loading-view");

  //MAIN MENU
  private By SEARCHPROTOCOL = By.cssSelector(
      "#container > div.cmon-header > div > div.comp-PageHeader-content.center-align.autowidth > span > form > input.comn-header-search");
  private By PROTOCOLRESULT = By.cssSelector(
      "#content > div.explorer-page-content > div > div > div > div > div > div.com-ExplorerViewWraper-content.expanded > div > div");
  private By OPEN = By
      .cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > button");
  //Three Line Button
  private By BURGER_BUTTON = By
      .cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.left-align > div > div.button-bar > span");

  //Tab Menu From BURGER BUTTON
  private By PROTOCOL_EDITOR = By.cssSelector("#menu-content > div:nth-child(6)");

  public ProtocolExplorerPage() {
    PageFactory.initElements(driver, this);
  }
  
  public void Login(String username, String password) {
    action.EnterText(USERNAME, username);
    action.EnterText(PASSWORD, password);
    action.Click(SIGNIN);
    //System.out.println(action.IsElementExists(LOADING));
  }

  public void RestoreSessionNo() {
    //System.out.println(action.IsElementExists(LOADING));
    if(wait.WaitLoading(LOADING)){
      if(action.IsElementExists(NORESTORE) == 1){
        action.Click(NORESTORE);
      }
    }
  }

  public void WaitingLoadingProcess(){
    if(wait.WaitLoading(LOADING)){
      
    }
  }

  public void SearchProtocol(String protocol) {
    action.EnterText(SEARCHPROTOCOL, protocol);
    action.Click(PROTOCOLRESULT);
  }

  public void OpenProtocol() {
    if(action.IsElementExists(LOADING) == 0){
      action.Click(OPEN);
    }else if(wait.WaitLoading(LOADING) == true){
      action.Click(OPEN);
    }
  }

  public void OpenProtocolEditor(){
    action.Click(BURGER_BUTTON);
    //this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    action.Click(PROTOCOL_EDITOR);
  }
}
