package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import StepDefinition.Init.Base.BaseClass;

public class CanvaSourceMap extends BaseClass {

    private By SIMPLETRANSFERMAPSOURCE = By.cssSelector("#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.source.selected > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By SIMPLETRANSFERMAPDEST = By.cssSelector("#modal-aspirate-dispense > div > div > div.modal-body > div > div.upper-component > div.labware-content > div.ST-content-main.destination.selected > div.labware-destination-container > div.labware-wrapper-container > div > div > div > div > canvas:nth-child(2)");
    private By EXPDESIGNDESTINATION = By.cssSelector("body > div:nth-child(9) > div.fade.in.modal > div > div > div.modal-body > div > div.ExperimentDesignerModal-content.main-controller > div:nth-child(1) > div.ExperimentDesignerModal-labware-controller.main-content > div.ExperimentDesignerModal-content-sources > div > div > canvas:nth-child(2)");

    public CanvaSourceMap(){
        PageFactory.initElements(driver, this);
    }
    
    //Multiple Click on Well Volume for Plate 96 Destination Plate on Simple Transfer
    public void MultipleClickWellVolumeFor96PlateDestination(String source, String destination){
        int diffSize = 30;
        int widthOfCanva = (driver.findElement(SIMPLETRANSFERMAPDEST).getSize().getWidth()/2) - 32;
        int heightOfCanva = (driver.findElement(SIMPLETRANSFERMAPDEST).getSize().getHeight()/2) - 31;
        
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
                a.moveToElement(driver.findElement(SIMPLETRANSFERMAPDEST), -widthOfCanva+sizeOperation*diffSize, -heightOfCanva+row*diffSize)
                .click()
                .build()
                .perform();
            }
        }
    }

    //Multiple Click on Well Volume for Plate 96 Source Plate on Simple Transfer
    public void MultipleClickWellVolumeFor96PlateSource(String source, String destination){
        int diffSize = 31;
        int widthOfCanva = (driver.findElement(SIMPLETRANSFERMAPSOURCE).getSize().getWidth()/2) - 56;
        int heightOfCanva = (driver.findElement(SIMPLETRANSFERMAPSOURCE).getSize().getHeight()/2) - 57;
        
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
                a.moveToElement(driver.findElement(SIMPLETRANSFERMAPSOURCE), -widthOfCanva+sizeOperation*diffSize, -heightOfCanva+row*diffSize)
                .click()
                .build()
                .perform();
            }
        }
    }

    //Multiple Click Coloumn for 384 Plate Destination on Simple Transfer
    public void ClickColoumnFor384WellVolumeOnDestinationST(String numbOfColoumn){
        int diffSize = 15;
        int widthOfCanva = (action.GetWidth(SIMPLETRANSFERMAPDEST)/2) - 51;
        int heightOfCanva = (action.GetHeight(SIMPLETRANSFERMAPDEST)/2) - 8;
        int diffSizeOperationX = Integer.parseInt(numbOfColoumn) -1;    
            
        Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(SIMPLETRANSFERMAPDEST), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva)
            .click().build().perform();
    }

    //Multiple Click Coloumn for 96 Plate Source on Simple Transfer
    public void ClickColoumnFor96WellVolumeOnSourceST(String numbOfColoumn){
        System.out.println(driver.findElement(SIMPLETRANSFERMAPSOURCE).getSize());
        System.out.println("Masuk Function boos "+numbOfColoumn);
        int diffSize = 31;
        int widthOfCanva = (action.GetWidth(SIMPLETRANSFERMAPSOURCE)/2) - 56;
        int heightOfCanva = (action.GetHeight(SIMPLETRANSFERMAPSOURCE)/2) - 8;

        int diffSizeOperationX = Integer.parseInt(numbOfColoumn) -1;    
        System.out.println(-widthOfCanva+diffSizeOperationX*diffSize+" "+-heightOfCanva);
        Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(SIMPLETRANSFERMAPSOURCE), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva)
            .click().build().perform();
        
    }

    //Experiment Designer Without Arrow
    public void ClickSingleWellVolumeOn384WellPlateOnExpDesigner(String wellVolume){
        int diffSize = 19;
        int widthOfCanva = (action.GetWidth(EXPDESIGNDESTINATION)/2) - 28;
        int heightOfCanva = (action.GetHeight(EXPDESIGNDESTINATION)/2) - 32;
        char rowSource = wellVolume.substring(0,1).charAt(0);
        String colSource = wellVolume.substring(1, 3);
        int numberOfRow = (int)rowSource -65;
        int diffSizeOperationX = Integer.parseInt(colSource)-1;  

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(EXPDESIGNDESTINATION), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva+numberOfRow*diffSize)
        .click().build().perform();
    }
    

}
