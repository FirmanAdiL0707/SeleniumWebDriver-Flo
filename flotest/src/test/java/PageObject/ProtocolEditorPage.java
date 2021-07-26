package PageObject;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinition.Init.Base.BaseClass;
import io.netty.util.internal.SystemPropertyUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.Console;

public class ProtocolEditorPage extends BaseClass {
  // protected WebDriver driver;
  // JavascriptExecutor executor;
  // protected WebDriverWait wait;

  //MAIN MENU
  private By SIMPLETRANSFER = By.cssSelector(
      "#container > div.cmon-header > div > div.comp-PageHeader-content.center-align > div > div:nth-child(2)");
  private By SERIALDILUTION = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.center-align > div > div:nth-child(4)");
  private By STOCKDEFINITION = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.center-align > div > div:nth-child(10)");
  private By EXPERIMENTDESIGNER = By.cssSelector(
      "#container > div.cmon-header > div > div.comp-PageHeader-content.center-align > div > div:nth-child(3)");
  private By NEXT = By.cssSelector(
      "#content > div.navbar-wrapper > div.navbar-Form.righ-side > button.button-nav.button-next.isDefaultNextBtn.btn.btn-default");
  private By RUN = By
      .cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > button");
  private By OPENLABWARE = By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div[2]/button");
  private By ALLTABMENU = By.cssSelector("#labware-drop-area > div.labware-def-container.noselect.slide-show > div > div > div.tab-list > div.left > div:nth-child(7)");
  private By FINISH = By.cssSelector("#popup-panel > div > div > div.modal-body > div > div.panel-menu > div > div.toolbar-menu-col.right-action.col-lg-4.col-md-4.col-xs-4 > div > button");
  private By LOADING = By.className("fmlx-loading-view");
  private By NOTIFICATION = By.className("FmlxNotification");
  private By CREATESTOCKCONTENT = By.cssSelector("body > div:nth-child(9) > div.fade.stock-creation.in.modal > div > div");
  private By MOOREBUTTON = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > div:nth-child(3) > div:nth-child(4) > div.cmon-menu-icon > div");
  private By REMOVE = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > div:nth-child(3) > div:nth-child(4) > div.cmon-menu-dropdown-list.show > ul > li:nth-child(4)");
  private By DUPLICATE = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > div:nth-child(3) > div:nth-child(4) > div.cmon-menu-dropdown-list.show > ul > li:nth-child(1)");
  private By OPEN = By
      .cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > button");
  private By SEARCHPROTOCOL = By.cssSelector(
        "#container > div.cmon-header > div > div.comp-PageHeader-content.center-align.autowidth > span > form > input.comn-header-search");
  private By PROTOCOLRESULT = By.cssSelector(
      "#content > div.explorer-page-content > div > div > div > div > div > div.com-ExplorerViewWraper-content.expanded > div > div");
  private By PROTOCOLRESULTTWO = By.cssSelector("#content > div.explorer-page-content > div > div > div.com-ExplorerView-layout > div > div > div.com-ExplorerViewWraper-content.expanded > div > div");
  private By SOURCEINFOBUTTON = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > button.cmon-button.open.btn.btn-lg.btn-default");
  private By GO = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.right-align > button.cmon-button.btn.btn-lg.btn-success");
  private By PAUSE = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.contentwidth > button.cmon-button.btn.btn-lg.btn-primary");
  private By ABORT = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.contentwidth > button.cmon-button.btn.btn-lg.btn-danger");
  private By PROGRESSBAR = By.cssSelector("#container > div.cmon-header > div > div.comp-PageHeader-content.center-align > div > div > div");
  private By ABORTMESSAGE = By.cssSelector("body > div:nth-child(8) > div.fade.in.modal > div > div");
  private By STATUSTEXT = By.cssSelector("#runtime-dialog > div.information-text.SuccessFeedback");
  private By BUTTONARROWONCARDLIST = By.cssSelector("#nav > div > div > div:nth-child(2) > div > div.card-content.show > button.down-arrow.show.btn.btn-default");
  // STOCK DEFINITION
  private By CANVASOURCEMAP = By.cssSelector("#popup-panel > div > div > div.modal-body > div > div.panel-content > div.panel-right > div.LabwareArea-content > div > div > canvas:nth-child(2)");
  //RUN
  private By SOURCEINFO = By.cssSelector("#menu-options > button.cmon-button.btn.btn-lg.btn-default");
  private By EXPAND = By.cssSelector(
      "#popup-panel > div > div > div.modal-body > div > div.panel-content > div.panel-left.show-source > div.initial-stock.show > div > div > button");
  private By CLOSEINITIALSTOCK = By.cssSelector(
      "#popup-panel > div > div > div.modal-body > div > div.panel-menu > div > div.toolbar-menu-col.right-action.col-lg-6.col-md-6.col-xs-6 > button");
  private By PREPARINGBACK = By
      .cssSelector("#container > div.cmon-header > div > div:nth-child(1) > div > div.button-bar");
  private By CREATEGROUPSTOCKBUTTON = By.cssSelector("#max > div:nth-child(1) > div > div.group-header-stock-item > div.group-btn > button.cmon-button.flat.button-text.btn.btn-lg.btn-success");      
  private By CREATEGROUP = By.xpath("//button[contains(text(),'CREATE')]");
  private By ADDMULTIPLESTOCK = By.cssSelector("#max > div.stock-dialog > div.action > button:nth-child(3)");

  //PROTOCOL
  private By DRAGSTEP1 = By.cssSelector(
      "#nav > div > div > div:nth-child(2) > div:nth-child(1) > div.card.unselected > div.card-container > div.drag-handle > span");
  private By DELETESTEP1 = By.cssSelector(
      "#nav > div > div > div:nth-child(2) > div > div.card.selected > div.card-container > div.card-header > div.card-button.show > div:nth-child(1) > button:nth-child(2)");
  private By DELETESTEP1MULTI = By.cssSelector(
      "#nav > div > div > div:nth-child(2) > div > div.card.unselected > div.card-container > div.card-header > div.card-button.show > div:nth-child(1) > button:nth-child(2)");
  private By DELETESTEP2 = By.cssSelector(
      "#nav > div > div > div:nth-child(2) > div:nth-child(2) > div.card.unselected > div.card-container > div.card-header > div.card-button.show > div:nth-child(1) > button:nth-child(2)");
  private By DELETESTEP3 = By.cssSelector(
      "#nav > div > div > div:nth-child(2) > div:nth-child(3) > div.card.unselected > div.card-container > div.card-header > div.card-button.show > div:nth-child(1) > button:nth-child(2)");
  private By REMOVEYES = By.cssSelector(
      "body > div:nth-child(5) > div.fade.in.modal > div > div > div.modal-footer > button.modal-btn-primary.btn.btn-default");
  private By REMOVEYESFIRSTTIME = By.cssSelector("body > div:nth-child(4) > div.fade.in.modal > div > div > div.modal-footer > button.modal-btn-primary.btn.btn-default");
  private By YESABORT = By.cssSelector("body > div:nth-child(8) > div.fade.in.modal > div > div > div.modal-footer > button.modal-btn-primary.btn.btn-default");

  //Labware Drop Area
  private By AREA1 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(1) > div:nth-child(1) > div > div > div");
  private By AREA2 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(1) > div:nth-child(2) > div > div > div");
  private By AREA3 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(1) > div:nth-child(3) > div > div > div");
  private By AREA4 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(2) > div:nth-child(1) > div > div > div");
  private By AREA5 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(2) > div:nth-child(2) > div > div > div");
  private By AREA6 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(2) > div:nth-child(3) > div > div > div");
  private By AREA7 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(3) > div:nth-child(1) > div > div > div");
  private By AREA8 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(3) > div:nth-child(2) > div > div > div");
  private By AREA9 = By.cssSelector("#labware-drop-area > div.deck-view.no-scroll > div:nth-child(3) > div:nth-child(3) > div > div > div");

  //Button on SERIAL DILUTION
  private By WITH_STOCK = By.cssSelector("#content > div.navbar-wrapper > div.navbar-Form.righ-side > button.button-nav.button-back.isDefaultNextBtn.btn.btn-default");
  private By WITHOUT_STOCK = By.cssSelector("#content > div.navbar-wrapper > div.navbar-Form.righ-side > button.button-nav.button-next.btn.btn-default");
  private By CANCEL = By.cssSelector("#content > div.navbar-wrapper > div.navbar-Form.righ-side > button.button-nav.button-cancel.btn.btn-default");
  private By ADDDILUENT = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div:nth-child(1) > div.SourcesHeader-container > div.SourcesHeader-action > button:nth-child(1)");
  private By ADDSAMPLE = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div:nth-child(1) > div.SourcesHeader-container > div.SourcesHeader-action > button:nth-child(2)");
  private By STOCKVALIDATION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div > div > div");
  private By STOCKGROUPVALIDATION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div > div.com-SourceStockContainer > div > div");
  private By SERIALDILUTIONPLATE = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div:nth-child(1) > div.SDWithStock-labware-controller.main-content > div.SDWithStock-content-sources > div > div > canvas:nth-child(2)");
  private By SETUPDILUTIONTABMENU = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]");
  private By POINTSETUPDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div.SDSetupDilution-content-row.set-step > input");
  private By ALONGSIDEPOINT = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div.SDSetupDilution-content-row.set-step > select");
  private By DIRECTIONSETUPDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div.SDSetupDilution-setup-column.direction > div > select");
  private By RATIOSETUPDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div:nth-child(2) > input");
  private By SETUPVOLUMETABMENU = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]");
  private By SAMPLETEXTSETUPVOLUME = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div > div:nth-child(2) > input");
  private By APPLYSAMPLEVOLUME = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div > div.SDSetupVolume-setup-row.bottom > div.SDSetupVolume-action-button > button");
  private By FINISHSERIALDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-header > div > button.btn.btn-success");
  private By CREATESTOCKSBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.stock-creation.in.modal > div > div > div.modal-footer > button");

    public ProtocolEditorPage () {
      PageFactory.initElements(driver, this);
	  }

    public void ValidateProtocolExistOrNot(String nameOfProtocols){

      action.EnterText(SEARCHPROTOCOL, nameOfProtocols);
      if(action.IsElementExists(PROTOCOLRESULT) == 0 && action.IsElementExists(PROTOCOLRESULTTWO) == 0){
        action.ClearText(SEARCHPROTOCOL);
      }else if(action.IsElementExists(PROTOCOLRESULT) == 1){
          action.Click(PROTOCOLRESULT);
          action.Click(MOOREBUTTON);
          action.Click(REMOVE);
          action.Click(REMOVEYESFIRSTTIME);
        } else {
          action.Click(PROTOCOLRESULTTWO);
          action.Click(MOOREBUTTON);
          action.Click(REMOVE);
          action.Click(REMOVEYESFIRSTTIME);
        }
    }

    public void DuplicateProtocol(String protocolName) throws InterruptedException{
      if(wait.WaitLoading(LOADING)){
          action.EnterText(SEARCHPROTOCOL, protocolName);
          if(action.IsElementExists(PROTOCOLRESULT) == 1){
            System.out.println("asadasd");
            Thread.sleep(1200);
            action.Click(PROTOCOLRESULT);
            action.Click(MOOREBUTTON);
            action.Click(DUPLICATE);
          } else {
            Thread.sleep(1200);
            action.Click(PROTOCOLRESULTTWO);
            action.Click(MOOREBUTTON);
            action.Click(DUPLICATE);
          }

        }
    }

    public void OpenProtocol(String protocolName) throws InterruptedException{
      if(wait.WaitLoading(LOADING)){
          action.EnterText(SEARCHPROTOCOL, protocolName);
          if(action.IsElementExists(PROTOCOLRESULT) == 1){
            Thread.sleep(1000);
            action.Click(PROTOCOLRESULT);
            action.Click(OPEN);
          } else {
            Thread.sleep(1000);
            action.Click(PROTOCOLRESULTTWO);
            action.Click(OPEN);
          }
      }
    }

    public void ClickSimpleTransfer() {
      action.Click(SIMPLETRANSFER);
    }

    public void SelectLabware(String source, String taskType) {
      String simpleTrasnferAddress = "#labware-drop-area > div.deck-view.no-scroll.with-header > div:nth-child(1) > div:nth-child("
          + source + ") > div > div > div > div > div > div:nth-child(1) > div > div > canvas";
      String serialDilutionAddress = "#labware-drop-area > div.deck-view.no-scroll > div:nth-child(1) > div:nth-child("
      + source + ") > div > div > div > div > div > div:nth-child(1) > div > div > canvas";
      if(taskType.equals("simple transfer")){
        driver.findElement(By.cssSelector(simpleTrasnferAddress)).click();
      }
      if (taskType.equals("serial dilution")){
        driver.findElement(By.cssSelector(serialDilutionAddress)).click();
      }
      
    }

    public void ClickNext() {
      action.Click(NEXT);
    }

    public void ClickCardList() {
      String selector = "#nav > div > div > div:nth-child(2) > div > div.card-content.show > button.down-arrow.show.btn.btn-default";
      driver.findElement(By.cssSelector(selector)).click();
    }

    public String GetAspirateCardList() {
      String selector = "#nav > div > div > div:nth-child(2) > div > div.card.selected > div.card-content.show > div > div:nth-child(1) > div > span > p.label-text.labware";
      return driver.findElement(By.cssSelector(selector)).getText();
    }

    public String GetDispenseCardList() {
      String selector = "#nav > div > div > div:nth-child(2) > div > div.card.selected > div.card-content.show > div > div:nth-child(2) > div > span:nth-child(1) > p.label-text.labware";
      return driver.findElement(By.cssSelector(selector)).getText();
    }

    public String GetVolumeCardList() {
      String selector = "#nav > div > div > div:nth-child(2) > div > div.card.selected > div.card-content.show > div > div:nth-child(2) > div > span:nth-child(2) > p.label-text.volume";
      return driver.findElement(By.cssSelector(selector)).getText();
    }

    public void ClickExperimentDesigner() {
      action.Click(EXPERIMENTDESIGNER);
    }

    public void ClickStockDefinition(){
      if(action.IsElementExists(LOADING) == 0){
        action.Click(STOCKDEFINITION);
      }else if(wait.WaitLoading(LOADING) == true){
        action.Click(STOCKDEFINITION);
      }
    }

    public void SelectExperimentDesignLabware(String labware) {
      String address = "#labware-drop-area > div.deck-view.no-scroll > div:nth-child(1) > div:nth-child(" + labware + ") > div > div > div > div > div > div:nth-child(1) > div > div > canvas";
      driver.findElement(By.cssSelector(address)).click();
    }

    public void RunProtocol() {
      action.Click(RUN);
    }

    public void SourceInfo() {
      action.Click(SOURCEINFO);
      action.Click(EXPAND);
    }

    public void InitialStockExpand(String row) {
      String address = "#" + row + "_301 > div > div > div:nth-child(5)";
      driver.findElement(By.cssSelector(address)).click();
    }

    public String GetStockVolume1(String row) {
      String address = "#" + row +  "_301 > div.single-well.selected > div > div:nth-child(4) > div.StockItemContentText";
      return driver.findElement(By.cssSelector(address)).getText();
    }

    public String GetStockVolume2(String row) {
      String address = "#" + row
          + "_301 > div.single-well-footer.card-list > div > div:nth-child(2)";
      return driver.findElement(By.cssSelector(address)).getText();
    }

    public void DeleteStep1() {
      System.out.println("Delete 1");
      action.Click(DELETESTEP1);
      action.Click(REMOVEYES);
    }

    public void CloseInitialStock() {
      action.Click(CLOSEINITIALSTOCK);
    }

    public void ClickBackOnPreparing() {
      action.Click(PREPARINGBACK);
    }

    public void SelectStep1() {
      action.Click(DRAGSTEP1);
      System.out.println("Select step 1");
    }

    public void DeleteStep3() {
      System.out.println("Delete 3");
      action.Click(DELETESTEP3);
      action.Click(REMOVEYES);
    }

    public void DeleteStep2() {
      System.out.println("Delete 2");
      action.Click(DELETESTEP2);
      action.Click(REMOVEYES);
    }

    public void DeleteStep1Selected() {
      System.out.println("Delete 1 multi");
      action.Click(DELETESTEP1MULTI);
      action.Click(REMOVEYES);
    }

    public String GetInitialStockWarning() {
      By WARNING = By.xpath("//div[contains(text(),'The required source is exceeds the well capacity.')]");
      return action.GetText(WARNING);
    }

    public void DragPlateToDropArea(String plate, String labwareArea) throws InterruptedException{ 
      if(action.GetText(OPENLABWARE).contains("OPEN LABWARE LIST")){        
        action.Click(OPENLABWARE);
        action.Click(ALLTABMENU);
      }else{
        action.Click(ALLTABMENU);
      }
      By source = By.cssSelector("[title*='"+plate+"']");
      
      if(labwareArea.equals("AREA1"))
        action.DragAndDrop(source, AREA1);
      if(labwareArea.equals("AREA2"))
        action.DragAndDrop(source, AREA2);
      if(labwareArea.equals("AREA3"))
        action.DragAndDrop(source, AREA3);
      if(labwareArea.equals("AREA4"))
        action.DragAndDrop(source, AREA4);
      if(labwareArea.equals("AREA5"))
        action.DragAndDrop(source, AREA5);
      if(labwareArea.equals("AREA6"))
        action.DragAndDrop(source, AREA6);
      if(labwareArea.equals("AREA7"))
        action.DragAndDrop(source, AREA7);
      if(labwareArea.equals("AREA8"))
        action.DragAndDrop(source, AREA8);
      if(labwareArea.equals("AREA9"))
        action.DragAndDrop(source, AREA9);
      Thread.sleep(700);
    }

    public void ClickFinish(){
      action.Click(FINISH);
    }

    public void SerialDilutionWithStock(String sourceLabware, String taskType){
      action.Click(SERIALDILUTION);
      action.Click(WITH_STOCK);
      SelectLabware(sourceLabware,taskType);
      action.Click(NEXT);
    }

    public void SerialDilutionWithoutStock(){
      action.Click(SERIALDILUTION);
      action.Click(WITHOUT_STOCK);
    }

    public void AddDiluentWithStock(String stocknumber) throws InterruptedException{
      By STOCKNUMBER = By.cssSelector
      ("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child("+stocknumber+") > div > div");
      action.Click(ADDDILUENT);
      Thread.sleep(1400);
      if(action.IsElementExists(STOCKVALIDATION) != 0){
        action.Click(STOCKVALIDATION);
      }
      else{
        Thread.sleep(1400);
        action.Click(STOCKNUMBER);
      }        
    }

	public void AddSampleWithStockGroup(String stocknumber) throws InterruptedException{
      By STOCKNUMBER = By.cssSelector
      ("body > div:nth-child(5) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child("+stocknumber+") > div.com-SourceStockContainer > div > div");
      action.Click(ADDSAMPLE);
      Thread.sleep(1400);
      
      if(action.IsElementExists(STOCKGROUPVALIDATION) != 0){
        
        action.Click(STOCKGROUPVALIDATION);
      }
      else{
        Thread.sleep(1400);
        action.Click(STOCKNUMBER);
      }        
    }
    public void AddSample(String stocknumber) throws InterruptedException{
      By STOCKNUMBER = By.cssSelector
      ("body > div:nth-child(5) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child("+stocknumber+") > div > div");
      action.Click(ADDSAMPLE);
      if(action.IsElementExists(STOCKVALIDATION) != 0){
        Thread.sleep(1400);
        action.Click(STOCKVALIDATION);
      }
      else{
        Thread.sleep(1400);
        action.Click(STOCKNUMBER);
      }        
    }

    public void ClickWellVolume96OnSerialDilutionPlate(int x, int y) throws InterruptedException{
      System.out.println(driver.findElement(SERIALDILUTIONPLATE).getSize());    
      new Actions(driver).moveToElement(driver.findElement(SERIALDILUTIONPLATE), x, y).click().perform();
    }

    public void InputSetupDilution(String point, String alongSide, String direction, String ratio){
      action.Click(SETUPDILUTIONTABMENU);
      System.out.println("Setup Dilution Tab nya = "+action.isEnabled(SETUPDILUTIONTABMENU));
      action.EnterText(POINTSETUPDILUTION, point);
      action.SelectOption(ALONGSIDEPOINT, alongSide);
      action.SelectOption(DIRECTIONSETUPDILUTION, direction);
      action.EnterText(RATIOSETUPDILUTION, ratio);
    }

    public void InputSetupVolume(String sampleVolume){
      action.Click(SETUPVOLUMETABMENU);
      action.EnterText(SAMPLETEXTSETUPVOLUME, sampleVolume);
    }

    public void ClickApplySampleVolume(){
      action.Click(APPLYSAMPLEVOLUME);
    }

    public void FinishSerialDilution(){
      action.Click(FINISHSERIALDILUTION);
    }

    public void ClickCreateStockOnCombinationStock(){
      if(wait.WaitComponent(CREATESTOCKCONTENT))
        action.Click(CREATESTOCKSBUTTON);
    }

    public void StockSetupMultipleSelectPlate96(String start, String end) {
      action.MultipleClickWellVolumeFor96Plate(CANVASOURCEMAP, start, end);
    }

    public void CreateNewGroupStockSetup() {
      action.Click(CREATEGROUP);
    }

    public void SwipeWellVolume96WellPlateOnStockDefinition(Integer sourcex, Integer sourcey, 
        Integer destinationx, Integer destinationy) throws AWTException {
      // Robot r = new Robot();
      //new Actions(driver).moveByOffset(796, 225).clickAndHold().build().perform();
      //new Actions(driver).moveByOffset(804, 193).click().build().perform();
      //new Actions(driver).moveByOffset(804, 213).click().build().perform();
      //new Actions(driver).moveByOffset(784, 200).click().build().perform();
      // r.mouseMove(1223, 600);
      // r.delay(1800);
      // r.mouseMove(1224, 601);
      // r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

      Robot r = new Robot();
      new Actions(driver).moveByOffset(sourcex, sourcey).clickAndHold().build().perform();
      r.mouseMove(destinationx, destinationy);
      r.delay(1000);
      r.mouseMove(destinationx+1, destinationy+1);
      r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void AddMultipleStock() {
      action.Click(ADDMULTIPLESTOCK);
    }

    public void StockSetupMultipleSelectPlate384(String start, String end) {
      action.MultipleClickWellVolumeFor384Plate(CANVASOURCEMAP, start, end);
    }
    
    public void SwipeWellVolume96WellPlateOnSerialDilution(String source, String destination) {
      action.MultipleClickWellVolumeFor96Plate(CANVASOURCEMAP, source, destination);
    }
    
     public void ClickCreateStockGroupButton(){
      action.Click(CREATEGROUPSTOCKBUTTON);
    }

    public int ValidateSourceInfoButton(){
      return action.IsElementExists(SOURCEINFOBUTTON);
    }

    public int ValidateGoButton(){
      return action.IsElementExists(GO);
    }

    public String ValidateGetTextRunButton(){
      return action.GetText(GO);
    }

    public int ValidateAbortButton(){
      return action.IsElementExists(ABORT);
    }

    public int ValidatePauseButton(){
      return action.IsElementExists(PAUSE);
    }

    public String ValidateGetTextonPauseButton(){
      return action.GetText(PAUSE);
    }

    public int ValidateProgressBarAppears(){
      return action.IsElementExists(PROGRESSBAR);
    }

    public void WaitRunningProtocolFinished(){
      if(wait.WaitProgressBarIsDone(STATUSTEXT)){

      }
    }

    public String ValidateGetTextRunningProtocol(){
      return action.GetText(STATUSTEXT);
    }

    public int isValidateStatusTextAppears(){
      return action.IsElementExists(STATUSTEXT);
    }
    
    public void WaitGoButtonAppears(){
      if(wait.WaitComponent(GO)){
      }
    }

    public void ClickGoButton(){
      action.Click(GO);
    }

    public String GetAbortTextButton(){
      return action.GetText(ABORT);
    }
    
    public void ClickYesAbortButton(){
        action.Click(YESABORT); 
    }

    public int ValidateAbortMessage(){
        return action.IsElementExists(ABORTMESSAGE);
    }

    public void ClickCloseButton(){
        action.Click(ABORT);
    }

    public void ClickArrowCardList(){
        action.Click(BUTTONARROWONCARDLIST);
    }
    
    public String ValidateCardListVolume(String cardList){
      By Cardlist = By.cssSelector("#nav > div > div > div:nth-child(2) > div > div.card.selected > div.card-content.show > div > div:nth-child("+cardList+") > div > div.detail.regular.content-wraper.right > p.vol");
      return action.GetText(Cardlist);
    }
}
