package PageObject;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Init.Base.BaseClass;

public class ExperimentDesignerPage extends BaseClass {
  protected WebDriver driver;

  private By DESTINATIONED = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div:nth-child(1) > div.ExperimentDesignerModal-labware-controller.main-content > div.ExperimentDesignerModal-content-sources > div > div > canvas:nth-child(2)");
  private By DISPENSEVOLUME = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div.ExperimentDesignerModal-main.setup-controller > div > div.TabPanelContent-container > div > div.EDSetupDispenseVolume-setup.column > div > input");
  private By DISPENSEMESSAGE = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div.ExperimentDesignerModal-main.setup-controller > div > div.TabPanelContent-container > div > div.EDSetupDispenseVolume-setup.column > div > div > div > div.message-container-text");
  private By UNITDISPENSEVOLUME = By.cssSelector(
    "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div.ExperimentDesignerModal-main.setup-controller > div > div.TabPanelContent-container > div > div.EDSetupDispenseVolume-setup.column > div > select");
  private By APPLYDISPENSEVOLUME = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div.ExperimentDesignerModal-main.setup-controller > div > div.TabPanelContent-container > div > div:nth-child(2) > div.action-button > button");
  private By ADDSTOCK = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div:nth-child(1) > div.SourcesHeader-container > div.SourcesHeader-action > button.cmon-button.btn-source.add.btn.btn-lg.btn-default");
  private By STOCK1 = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child(1) > div");
  private By STOCK2 = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div > div > div");
  private By STOCKCOMB = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child(1) > div > div");
  private By CHECKSTOCK2 = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div:nth-child(1) > div.SourcesContainerList-container.column > div > div.com-SourceStockContainer.isSelected > div > div.com-SourceStockContainer-checkbox-wraper > div > div > label > span");
  private By FINISH = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-header > div > button.btn.btn-success");
  private By STOCKCONFIRMATION = By.cssSelector("#show > div.stock-confirmation");
  private By RENAME = By.cssSelector("#show > div.stock-confirmation > div.stock-confirmation-button > button.btn-primary.btn.btn-primary");

  private By VOLUME1 = By.cssSelector(
      "#uncontrolled-tab-example-pane-list > table > tbody > tr > td:nth-child(3) > div:nth-child(1) > span");
  private By VOLUME2 = By.cssSelector(
      "#uncontrolled-tab-example-pane-list > table > tbody > tr > td:nth-child(3) > div:nth-child(2) > span");
  private By CREATESTOCK = By.cssSelector(
      "body > div:nth-child(9) > div.fade.stock-creation.in.modal > div > div > div.modal-footer > button");
  private By SETUPDISPENSEVOLUME = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div.ExperimentDesignerModal-main.setup-controller > div > div.comp-TabPanelHeader > div:nth-child(2) > span");
  private By SUMMARYVIEW = By.cssSelector(
      "body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div:nth-child(1) > div.ExperimentDesignerModal-labware-controller.main-content > div.MainLabwareHeader-container > div.MainLabwareHeader-action > div.cmon-SwitchSlider > div > label > span");
  private By SINGLELISTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div.com-SourceStockContainer > div > div");
  private By SINGLELISTMULTISTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div > div.com-SourceStockContainer > div > div");

  public ExperimentDesignerPage() {
    PageFactory.initElements(driver, this);
  }

  public void SelectStock(String stock) {
    if (stock.equals("1")) {
      action.Click(STOCK1);
    }
    if (stock.equals("2")) {
      action.Click(STOCK2);
    }
    if (stock.equals("Combination of 2 Ingredients")) {
      action.Click(STOCKCOMB);
    }
  }

  public void SelectDestinationMap(Integer x, Integer y) {
    System.out.println(driver.findElement(DESTINATIONED).getSize());
    new Actions(driver).moveToElement(driver.findElement(DESTINATIONED), x, y).click().perform();
  }

  public void EnterDispenseVolume(String volume, String unit) {
    action.EnterText(DISPENSEVOLUME, volume);
    action.SelectOption(UNITDISPENSEVOLUME, unit);
  }

  public String ValidateDispenseVolume(){
    return action.GetValue(DISPENSEVOLUME);
  }

  public String ValidateUnitDispenseVolume(){
    return action.GetValue(UNITDISPENSEVOLUME);
  }

  public String GetDispenseVolumeMessage() {
    return action.GetText(DISPENSEMESSAGE);
  }

  public void ApplyDispenseVolume() {
    action.Click(APPLYDISPENSEVOLUME);
  }

  public void AddStock() {
    action.Click(ADDSTOCK);
  }

  public void UnselectStock(String stock) {
    action.Click(CHECKSTOCK2);
  }

  public void FinishExperimentDesigner() {
    action.Click(FINISH);
  }

  public String GetStockCombinationsVolume1() {
    return action.GetText(VOLUME1);
  }

  public String GetStockCombinationsVolume2() {
    return action.GetText(VOLUME2);
  }

  public void CreateStock() {
    action.Click(CREATESTOCK);
  }

  public void SelectStockUsingName(String stock) {
    By STOCK = By.xpath("//div[contains(text(),'" + stock + "')]");
    action.Click(STOCK);
  }

  public void ActivateSetupDispenseVolume() {
    action.Click(SETUPDISPENSEVOLUME);
  }

  public void TurnOffSummaryView() {
    action.Click(SUMMARYVIEW);
  }

  public void TurnOnSummaryView() {
    action.Click(SUMMARYVIEW);
  }

  public void ClickSingleStockByNumber(String numberStock){
    By OnlyOneStock = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div > div > div");
    By Stock = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child("+numberStock+") > div > div");
    if(action.IsElementExists(OnlyOneStock) == 1){
      action.Click(OnlyOneStock);
    }else{
      action.Click(Stock);
    }

  }

  public void ClickPatternByNumber(String numberOfPattern){    
    By PATTERN = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div:nth-child(1) > div.ExperimentDesignerModal-labware-controller.patterns > div > div.com-dispense-pattern-list > div:nth-child("+numberOfPattern+") > div > svg");
    action.Click(PATTERN);
  }

  public void ClickPatternByNumberForGroupStock(String numberOfPattern){
    By PATTERN = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div:nth-child(1) > div.ExperimentDesignerModal-labware-controller.patterns > div > div.ListPattern-container > div.com-dispense-pattern-list > div:nth-child("+numberOfPattern+") > div");
    action.Click(PATTERN);
  }

  public void GroupingStock(String nameStock, String numberOfColoumn,String listOfRow) throws InterruptedException{
    List<String> list = new ArrayList<String>(Arrays.asList(listOfRow.split(",")));
    for (int i=0; i<list.size(); i++){
        By Column = By.cssSelector("#"+list.get(i)+numberOfColoumn+"_801 > div.single-well.unchecked > div > div.single-well-col.inactive.col-md-4 > div");
        Thread.sleep(200);
        action.SetText(Column, nameStock);
        Thread.sleep(300);
        action.Click(RENAME);
    }
  }

  public void GroupingStockFor96Plate(String nameStock, String numberOfColoumn,String listOfRow) throws InterruptedException{
    //List<String> list = new ArrayList<String>(Arrays.asList(listOfRow.split(",")));
    String[] ary = listOfRow.split(",");
    for (int i=0; i< ary.length; i++){
        By Column = By.cssSelector("#"+ary[i]+numberOfColoumn+"_101 > div.single-well.unchecked > div > div.single-well-col.inactive.col-md-4 > div");
        Thread.sleep(200);
        action.SetText(Column, nameStock);
        Thread.sleep(300);
        if(action.IsElementExists(STOCKCONFIRMATION) == 1){
          action.Click(RENAME);
        }  
    }
  }

  public void ClickSingleWellVolumeOn96WellPlateWithArrow(String wellVolume){
      action.ClickSingleWellVolumeOn96WellPlateWithArrowExpDesigner(DESTINATIONED, wellVolume);
  }

  public int ValidateSingleListStock(){
    return action.IsElementExists(SINGLELISTSTOCK);
  }

  public int ValidateSingleGroupListStock(){
    return action.IsElementExists(SINGLELISTMULTISTOCK);
  }

  public int ValidateListStockByPosition(String position){
    By listPosition = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child("+position+") > div > div");
    return action.IsElementExists(listPosition);
  }

  public int ValidateGroupStockByPosition(String position){
    By listPosition = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.sources > div.SourcesContainer-container.set-expanded > div.SourcesContainerList-container.column > div > div.addstock-list > div:nth-child("+position+") > div.com-SourceStockContainer > div > div");
    return action.IsElementExists(listPosition);
  }
  
}
