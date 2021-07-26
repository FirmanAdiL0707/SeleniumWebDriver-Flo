package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinition.Init.Base.BaseClass;
import StepDefinition.Init.Infrastructure.Driver.Action;

public class SimpleTransferPage extends BaseClass {
    JavascriptExecutor executor;
    protected WebDriverWait wait;

    private By SOURCE = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.source.unselected > div.labware-wrapper-container");
    private By SOURCEMAP = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.source.selected > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By DESTINATION = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.unselected > div.labware-destination-container > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By DESTINATIONMAP = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-destination-container > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By DESTINATIONMESSAGE = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-header > div.header-left > span");
    private By DISPENESEVOLUME = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.bottom-component.row > div.col-md-7 > div > div > div.content > div > div > div.upper-content > div > div > div > div > div > input");
    private By DISPENESEVOLUMEMESSAGE = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.bottom-component.row > div.col-md-7 > div > div > div.content > div > div > div.upper-content > div > div > div > div > div > div > div > div.message-container-text");
    private By DISPENESEVOLUMETAB = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.bottom-component.row > div.col-md-7 > div");
    private By DESTINATIONLIST = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.scroll-labware > div > div.sliders.selected");
    private By APPLYDISPENSEVOLUME = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.bottom-component.row > div.col-md-7 > div > div > div.content > div > div > div.bottom-content > button > span");
    private By FINISH = By
            .cssSelector("#modal-aspirate-dispense > div > div > div.modal-header > div > button.btn.btn-success");
    private By SUMMARYVIEW = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-header > div.button-header > div > div.summary-view > label > div");
    private By COPYMAPPING = By.cssSelector(
            "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-header > div.button-header > div > div.copy-paste-buttons > button");
    private By PASTEMAPPING = By.cssSelector("#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-header > div.button-header > div > div.copy-paste-buttons > button.btn.btn-warning");

    public SimpleTransferPage() {
        PageFactory.initElements(driver, this);
    }

    public void SelectSourceMap(int x, int y) {
        new Actions(driver).moveToElement(driver.findElement(SOURCEMAP), x, y).click().perform();
        System.out.println(driver.findElement(SOURCEMAP).getSize());

    }

    public void ClickDestinationLabwware() {
        action.Click(DESTINATION);
    }

    public void SelectDestinationMap(int x, int y) {
        new Actions(driver).moveToElement(driver.findElement(DESTINATIONMAP), x, y).click().perform();
        System.out.println(driver.findElement(DESTINATIONMAP).getSize());
    }

    public void SwippingDestinationMap(int x1, int y1, int x2, int y2) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(DESTINATIONMAP), -240, -150).clickAndHold().moveByOffset(-240, -150)
                .release().perform();
    }

    public void EnterDispenseVolume(String volume) {
        action.EnterText(DISPENESEVOLUME, volume);
    }

    public void FinsihSimpleTransfer() {
        action.Click(FINISH);
    }

    public Boolean IsEnabledDestinationLabware() {
        return action.isEnabled(DESTINATION);
    }

    public Boolean IsEnabledDestinationList() {
        return action.isEnabled(DESTINATIONLIST);
    }

    public Boolean IsEnabledSummaryView() {
        return action.isEnabled(SUMMARYVIEW);
    }

    public Boolean IsVisibleCopyMapping() {
        return action.isVisible(COPYMAPPING);
    }

    public Boolean IsEnabledDispenseVolumeTab() {
        WebDriverWait myWaitVar = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            myWaitVar.until(ExpectedConditions.elementToBeClickable(DISPENESEVOLUMETAB));
            return true;
        } catch (TimeoutException tException) {
            return false;
        }
    }

    public Boolean IsEnabledApplyDispenseVolume() {
        WebDriverWait myWaitVar = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            myWaitVar.until(ExpectedConditions.elementToBeClickable(APPLYDISPENSEVOLUME));
            return true;
        } catch (TimeoutException tException) {
            return false;
        }
    }

    public String GetDestinationMessage() {    
        System.out.println(action.GetText(DESTINATIONMESSAGE));    
        return action.GetText(DESTINATIONMESSAGE);        
    }

    public String GetDestinationMessageColor() {
        return action.GetColor(DESTINATIONMESSAGE);
    }

    public Boolean IsEnabledSourceLabware() {
        return action.isEnabled(SOURCE);
    }

    public void SelectPattern(String pattern) {
        String address = "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-destination-container > div.labware-dispense-pattern-container.show > div > div > div.dispense-patern-content > div:nth-child("
                + pattern + ") > button > svg > g > rect:nth-child(1)";
        driver.findElement(By.cssSelector(address)).click();
    }

    public void CopyMapping() {
        action.Click(COPYMAPPING);
    }

    public void SelectDestinationList(String row) {
        String address = "#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.scroll-labware > div > div:nth-child(3) > div > div";
        driver.findElement(By.cssSelector(address)).click();
    }

    public void PasteMapping() {
        action.Click(PASTEMAPPING);
    }

    public void ApplyDispenseVolume() {
        action.Click(APPLYDISPENSEVOLUME);
    }

    public String GetDispenseVolumeMessage() {
        return action.GetText(DISPENESEVOLUMEMESSAGE);
    }

    public void ClickSingleWellVolumeFor96WellVolumeOnSource(String source, String sourceMap){
        By _sourceMap = null;
        int widthOfCanva = 0;
        int heightOfCanva = 0;
        if(sourceMap.equals("source")) {
            _sourceMap = SOURCEMAP;
            widthOfCanva = (action.GetWidth(_sourceMap)/2) - 56;
            heightOfCanva = (action.GetHeight(_sourceMap)/2) - 57;
        }
        else if(sourceMap.equals("destination")) {
            _sourceMap = DESTINATIONMAP;
            widthOfCanva = (action.GetWidth(_sourceMap)/2) - 34;
            heightOfCanva = (action.GetHeight(_sourceMap)/2) - 31;
        }

        int diffSize = 32;
        if(source.equals("all") || source.equals("All")){
            widthOfCanva = (action.GetWidth(_sourceMap)/2) - 5;//121
            heightOfCanva = (action.GetHeight(_sourceMap)/2) - 6;//121
            System.out.println(-widthOfCanva+","+-heightOfCanva);
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(_sourceMap), -widthOfCanva, -heightOfCanva)
            .click().build().perform();
            
        }else{
            char rowSource = source.substring(0,1).charAt(0);
            String colSource = source.substring(1, 3);
            int numberOfRow = (int)rowSource -65;
            
            int diffSizeOperationX = Integer.parseInt(colSource) -1;    
            
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(_sourceMap), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva+numberOfRow*diffSize)
            .click().build().perform();
        }
    }

}
