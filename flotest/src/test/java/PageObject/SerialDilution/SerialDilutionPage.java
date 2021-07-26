package PageObject.SerialDilution;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Init.Base.BaseClass;

public class SerialDilutionPage extends BaseClass {

    private By SERIALDILUTIONPOPUP = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div");
    private By DILUENTBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div:nth-child(1) > div.SourcesHeader-container > div.SourcesHeader-action > button:nth-child(1)");
    private By SAMPLEBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.sources > div:nth-child(1) > div.SourcesHeader-container > div.SourcesHeader-action > button:nth-child(2)");
    private By TITLE = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-header > h4");
    private By UPDATEDISPENSEPATTERNPAGE = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.patterns.show > div > div.ListPattern-container > div.com-dispense-pattern-list > div.TooltipContainer-container.tooltip-changepattern");
    
    //Element on Serial Dilution Without Stock
    private By DILUENTPLATE = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-sourcelist > div > div.SourceListPreview-content > div:nth-child(1) > div");
    private By SAMPLEPLATE = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-sourcelist > div > div.SourceListPreview-content > div:nth-child(2) > div");
    private By CANVAFORSAMPLEANDILUENT = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.sample.right-side.selected > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By CANVAFORSERIALDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.dilution.selected > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By CHANGEPLATEBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.directions > button");
    private By SETUPDILUTIONTABMENUWITHOUTSTOCK = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]");
    private By POINTSETUPDILUTIONWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div.SDSetupDilution-content-row.set-step > input");
    private By ALONGSIDEPOINTWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div.SDSetupDilution-content-row.set-step > select");
    private By DIRECTIONSETUPDILUTIONWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div.SDSetupDilution-setup-column.direction > div > select");
    private By RATIOSETUPDILUTIONWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div:nth-child(2) > input");
    private By SETUPVOLUMETABMENUWITHOUTSTOCK = By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]");
    private By SAMPLETEXTSETUPVOLUMEWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div > div:nth-child(2) > input");
    private By APPLYSAMPLEVOLUMEWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div > div.SDSetupVolume-setup-row.bottom > div.SDSetupVolume-action-button > button");
    private By FINISHSERIALDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-header > div > button.btn.btn-success");
    private By POINTSETUPDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div.SDSetupDilution-content-row.set-step > input");
    private By ALONGSIDEPOINT = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div.SDSetupDilution-content-row.set-step > select");
    private By DIRECTIONSETUPDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div.SDSetupDilution-setup-column.direction > div > select");
    private By RATIOSETUPDILUTION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div.SDSetupDilution-setup-row > div:nth-child(1) > div:nth-child(2) > input");
    private By DILUENTVOLUMETEXT = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div > span");
    private By DILUENTVOLUMEWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.setup-controller > div > div.TabPanelContent-container > div > div > span");
    private By SAMPLEVOLUMEINPUT = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SDWithStock-content.main-controller > div.SDWithStock-main.setup-controller > div > div.TabPanelContent-container > div > div > div:nth-child(2) > input");
    //Update Dispense Pattern
    private By YESBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.patterns.show > div > div.ListPattern-container > div.com-dispense-pattern-list > div.TooltipContainer-container.tooltip-changepattern > div.TooltipContainer-footer > button.tooltip-btn.activated.btn.btn-default");
    private By NOBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.patterns.show > div > div.ListPattern-container > div.com-dispense-pattern-list > div.TooltipContainer-container.tooltip-changepattern > div.TooltipContainer-footer > button:nth-child(2)");
    private By DILUENTSELECTEDWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.sources > div:nth-child(1) > div.CardWrapperStock-content > div > div.StockCardItem-icon-wrapper.contained > span");
    private By SAMPLESELECTEDWITHOUTSTOCK = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.sources > div:nth-child(2) > div.CardWrapperStock-content > div > div.StockCardItem-icon-wrapper.contained > span");
    private By TRASHDILUENTBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.sources > div:nth-child(1) > div.CardWrapperStock-content > div > div.StockCardItem-container.contained.selected > div.StockCardItem-wrapper.section-action > button > span");
    private By TRASHSAMPLEBUTTON = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.SDMainSetupControllerContainer > div.SD-content-main.sources > div:nth-child(2) > div.CardWrapperStock-content > div > div.StockCardItem-container.contained.selected > div.StockCardItem-wrapper.section-action > button > span");
    

    public SerialDilutionPage(){
        PageFactory.initElements(driver, this);
    }

    public void ClickSingleWellVolumeFor96WellVolumeOnSample(String source){
        int diffSize = 32;
        System.out.println(driver.findElement(CANVAFORSAMPLEANDILUENT).getSize());
        int widthOfCanva = (action.GetWidth(CANVAFORSAMPLEANDILUENT)/2) - 62;//121
        int heightOfCanva = (action.GetHeight(CANVAFORSAMPLEANDILUENT)/2) - 62;//121
        char rowSource = source.substring(0,1).charAt(0);
        String colSource = source.substring(1, 3);
        int numberOfRow = (int)rowSource -65;
        
        int diffSizeOperationX = Integer.parseInt(colSource) -1;    
        
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(CANVAFORSAMPLEANDILUENT), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva+numberOfRow*diffSize)
        .click().build().perform();
    }

    public void ClickColumnGroupByColumnOn96WellPlate(String source){
        int diffSize = 32;
        int widthOfCanva = (action.GetWidth(CANVAFORSAMPLEANDILUENT)/2) - 62;//73
        int heightOfCanva = (action.GetHeight(CANVAFORSAMPLEANDILUENT)/2) -5;//5
        System.out.println(driver.findElement(CANVAFORSAMPLEANDILUENT).getSize());
        //char rowSource = source.substring(0,1).charAt(0);
        String colSource = source.substring(1, 3);
        
        int diffSizeOperationX = Integer.parseInt(colSource)-1;    
        System.out.println(diffSizeOperationX);
        System.out.println(-widthOfCanva+diffSizeOperationX*diffSize+","+-heightOfCanva);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(CANVAFORSAMPLEANDILUENT), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva)
        .click()
        .build()
        .perform();
    }

    public void ClickSingleWellVolumeFor384WellVolumeForSerialDilution(String source){
        int diffSize = 16;
        int widthOfCanva = (action.GetWidth(CANVAFORSERIALDILUTION)/2) - 27;
        int heightOfCanva = (action.GetHeight(CANVAFORSERIALDILUTION)/2) - 26;
        char rowSource = source.substring(0,1).charAt(0);
        String colSource = source.substring(1, 3);
        int numberOfRow = (int)rowSource -65;
        int diffSizeOperationX = Integer.parseInt(colSource)-1;    
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(CANVAFORSERIALDILUTION), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva+numberOfRow*diffSize)
        .click().build().perform();
    }


    public void ClickDiluentPlate(){
        action.Click(DILUENTPLATE);
    }

    public void ClickSamplePlate(){
        action.Click(SAMPLEPLATE);
    }

    public void ClickChangePlateButton(){
        action.Click(CHANGEPLATEBUTTON);
    }

    public void ClickApplySampleVolumeWithoutStock(){
        action.Click(APPLYSAMPLEVOLUMEWITHOUTSTOCK);
    }

    public void InputSetupDilutionWihtoutStock(String point, String alongSide, String direction, String ratio){
        action.Click(SETUPDILUTIONTABMENUWITHOUTSTOCK);
        action.EnterText(POINTSETUPDILUTIONWITHOUTSTOCK, point);
        action.SelectOption(ALONGSIDEPOINTWITHOUTSTOCK, alongSide);
        action.SelectOption(DIRECTIONSETUPDILUTIONWITHOUTSTOCK, direction);
        action.EnterText(RATIOSETUPDILUTIONWITHOUTSTOCK, ratio);
    }

    public void InputSetupVolumeWihtoutStock(String sampleVolume){
        action.Click(SETUPVOLUMETABMENUWITHOUTSTOCK);
        action.EnterText(SAMPLETEXTSETUPVOLUMEWITHOUTSTOCK, sampleVolume);
    }

    public void SelectPatternByNumber(String numberOfPattern){
        By patternNumber = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.SD-content > div.SD-content-row.labware-container > div.SD-content-main.patterns.show > div > div.ListPattern-container > div.com-dispense-pattern-list > div:nth-child("+numberOfPattern+")");
        action.Click(patternNumber);
    }

    public void ClickYesButtonOnUpdateDispenseMessage(){
        action.Click(YESBUTTON);
    }

    public void ClickNoButtonOnUpdateDispenseMessage(){
        action.Click(NOBUTTON);
    }

    public int ValidateSerialDilutionPopup(){
        return action.IsElementExists(SERIALDILUTIONPOPUP);
    }

    public String ValidateDiluentButton(){
        return action.GetText(DILUENTBUTTON);
    }

    public String ValidateSampleButton(){
        return action.GetText(SAMPLEBUTTON);
    }

    public String GetTitle(){
        return action.GetText(TITLE);
    }

    public int ValidateUpdateDispensePattern(){
        return action.IsElementExists(UPDATEDISPENSEPATTERNPAGE);
    }

    public String ValidatePointOnSerialDilution(String validation){
        if(validation.equals("true")){
            return action.GetValue(POINTSETUPDILUTION);
        }else{
            return action.GetValue(POINTSETUPDILUTIONWITHOUTSTOCK);
        }
    }

    public String ValidateAlongSide(String validation){
        if(validation.equals("true")){
            return action.GetValue(ALONGSIDEPOINT);
        }else{
            return action.GetValue(ALONGSIDEPOINTWITHOUTSTOCK);
        }
        
    }

    public String ValidateDirection(String validation){
        if(validation.equals("true")){
            return action.GetValue(DIRECTIONSETUPDILUTION);
        }else{
            return action.GetValue(DIRECTIONSETUPDILUTIONWITHOUTSTOCK);
        }
        
    }

    public String ValidateRatio(String validation){
        if(validation.equals("true")){
            return action.GetValue(RATIOSETUPDILUTION);
        }else{
            return action.GetValue(RATIOSETUPDILUTIONWITHOUTSTOCK);
        }
        
    }

    public String ValidateDiluentText(String validation){
        if(validation.equals("true")){
            return action.GetText(DILUENTVOLUMETEXT);
        }else{
            return action.GetText(DILUENTVOLUMEWITHOUTSTOCK);
        }
        
    }

    public String ValidateDiluentVolume(String validation){
        if(validation.equals("true")){
            return action.GetValue(SAMPLEVOLUMEINPUT);
        }else{
            return action.GetValue(SAMPLETEXTSETUPVOLUMEWITHOUTSTOCK);
        }
    }

    public int ValidateDiluentSelected(){
        return action.IsElementExists(DILUENTSELECTEDWITHOUTSTOCK);
    }

    public int ValidateSampleSelected(){
        return action.IsElementExists(SAMPLESELECTEDWITHOUTSTOCK);
    }

    public int ValidateTrashButtonOnDiluent(){
        return action.IsElementExists(TRASHDILUENTBUTTON);
    }

    public int ValidateTrashButtonOnSample(){
        return action.IsElementExists(TRASHSAMPLEBUTTON);
    }
}
