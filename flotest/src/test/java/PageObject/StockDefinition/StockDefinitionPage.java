package PageObject.StockDefinition;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Init.Base.BaseClass;

public class StockDefinitionPage extends BaseClass{

    private By MODALPOPUP = By.cssSelector("#popup-panel > div");
    private By MODALTITLE = By.cssSelector("#popup-panel > div > div > div.modal-header > h4");
    private By CANVASOURCEMAP = By.cssSelector("#popup-panel > div > div > div.modal-body > div > div.panel-content > div.panel-right > div.LabwareArea-content > div > div > canvas:nth-child(2)");
    private By NEWGROUP = By.cssSelector("#popup-panel > div > div > div.modal-body > div > div.panel-menu > div > div.toolbar-menu-col.left.col-lg-8.col-md-8.col-xs-8 > div:nth-child(1) > button");
    private By CREATEBUTTON = By.xpath("//button[text()[contains(.,'CREATE')]]");
    
    public StockDefinitionPage(){
        PageFactory.initElements(driver, this);
    }

    //Validation
    public int IsStockDefinitionPageAppears(){
        return action.IsElementExists(MODALPOPUP);
    }

    //Validation
    public String GetTitle(){
        return action.GetText(MODALTITLE);
    }

    public void ClickStockNumber(int numberOfStocks){
        By _stockNumber = By.cssSelector("#popup-panel > div > div > div.modal-body > div > div.panel-content > div.panel-left > div.stock-add.show > div:nth-child("+numberOfStocks+") > div > button");
        action.Click(_stockNumber);
    }

    public void ClickNewGroupButton(){
        action.Click(NEWGROUP);
    }

    public void ClickSingleWellVolumeFor96WellVolume(String source){
        int diffSize = 40;
        //System.out.println(driver.findElement(CANVASOURCEMAP).getSize());
        int widthOfCanva = (action.GetWidth(CANVASOURCEMAP)/2) - 45;//121
        int heightOfCanva = (action.GetHeight(CANVASOURCEMAP)/2) - 43;//121
        char rowSource = source.substring(0,1).charAt(0);
        String colSource = source.substring(1, 3);
        int numberOfRow = (int)rowSource -65;
        
        int diffSizeOperationX = Integer.parseInt(colSource) -1;    
        
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(CANVASOURCEMAP), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva+numberOfRow*diffSize)
        .click().build().perform();
    }

    //Multiple Click on Well Volume for 384 Plate
    public void MultipleClickWellVolumeFor384Plate(String source, String destination){
        int diffSize = 21;
        int widthOfCanva = (driver.findElement(CANVASOURCEMAP).getSize().getWidth()/2) - 36;
        int heightOfCanva = (driver.findElement(CANVASOURCEMAP).getSize().getHeight()/2) - 36;
        
        char rowSource = source.substring(0,1).charAt(0);
        String colSource = source.substring(1, 3);
        char rowDest = destination.substring(0,1).charAt(0);

        String colDest = destination.substring(1, 3);
        int numberOfRow = (int)rowDest-(int)rowSource+1;
        int numberOfCol = Integer.parseInt(colDest)-Integer.parseInt(colSource)+1;
        int diffSizeOperation = Integer.parseInt(colSource)-1;
        int y = (int)rowSource -65;
        for( int row = 0; row < numberOfRow; row++ )
        {
            for( int col = 0; col < numberOfCol; col++ )
            {
               
                int sizeOperation = col+diffSizeOperation;
                Actions a = new Actions(driver);
                a.moveToElement(driver.findElement(CANVASOURCEMAP), -widthOfCanva+sizeOperation*diffSize, -heightOfCanva+((row+y)*diffSize))
                .click()
                .build()
                .perform();
            }
        }
    }

    //Multiple Click on Well Volume for Plate 96
    public void MultipleClickWellVolumeFor96Plate(By ELEMENT,String source, String destination){
        int diffSize = 40;
        int widthOfCanva = (driver.findElement(CANVASOURCEMAP).getSize().getWidth()/2) - 45;
        int heightOfCanva = (driver.findElement(CANVASOURCEMAP).getSize().getHeight()/2) - 43;
        
        char rowSource = source.substring(0,1).charAt(0);
        String colSource = source.substring(1, 3);
        char rowDest = destination.substring(0,1).charAt(0);
        String colDest = destination.substring(1, 3);
        int numberOfRow = (int)rowDest-(int)rowSource+1;
        int numberOfCol = Integer.parseInt(colDest)-Integer.parseInt(colSource)+1;
        int diffSizeOperation = Integer.parseInt(colSource)-1;
        for( int row = 0; row < numberOfRow; row++ )
        {
        for( int col = 0; col < numberOfCol; col++ )
        {
            int sizeOperation = col+diffSizeOperation;
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(ELEMENT), -widthOfCanva+sizeOperation*diffSize, -heightOfCanva+row*diffSize)
            .click()
            .build()
            .perform();
        }
        }
    }

    public void ClickCreateButtonOnStockDef(){
        action.Click(CREATEBUTTON);
    }

}
