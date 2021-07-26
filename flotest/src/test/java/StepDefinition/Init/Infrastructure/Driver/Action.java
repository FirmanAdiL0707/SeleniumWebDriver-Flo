package StepDefinition.Init.Infrastructure.Driver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Action {
  private WebDriver driver;
  private JavascriptExecutor executor;
  private WebDriverWait wait;
  private Actions act;

  public Action(WebDriver driver) {
    this.driver = driver;
    this.executor = (JavascriptExecutor)driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    this.act = new Actions(driver);
  }

  public void SetText(By ELEMENT, String text){
    //Actions act = new Actions(driver);
    //WebElement webElement = driver.findElement(ELEMENT);
    act.click(driver.findElement(ELEMENT)).sendKeys(text).release().build().perform();
    act.sendKeys(Keys.ENTER).release().build().perform();
  }

  public void EnterText(By textbox, String input) {
    // WebElement element = driver.findElement(textbox);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textbox));
    //driver.findElement(textbox).clear();
    element.sendKeys(Keys.CONTROL, "a");
    element.sendKeys(Keys.BACK_SPACE);
    element.sendKeys(input);
  }

  public void SelectOption(By combobox, String option) {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(combobox));
    Select select = new Select(element);
    select.selectByVisibleText(option);
  }

  public void DragAndDrop(By source, By destination){
    WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(source));
    WebElement sourceDestination = driver.findElement(destination);

    //HTML 5 
    final String java_script =
            "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
            "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
            "ction(format,data){this.items[format]=data;this.types.append(for" +
            "mat);},getData:function(format){return this.items[format];},clea" +
            "rData:function(format){}};var emit=function(event,target){var ev" +
            "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
            "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
            "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
            "'drop',tgt);emit('dragend',src);";
    executor.executeScript(java_script, sourceElement, sourceDestination);
  }
  
  public String GetText(By element) {
    //return driver.findElement(element).getText();
    return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
  }

  public String GetValue(By element) {
    return driver.findElement(element).getAttribute("value");
  }

  public void Click(By ELEMENT) {
    // driver.findElement(ELEMENT).click();
    wait.until(ExpectedConditions.elementToBeClickable(ELEMENT)).click();
    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
  }

  public boolean isEnabled(By ELEMENT) {
    return driver.findElement(ELEMENT).isEnabled();
  }

  public boolean isVisible(By ELEMENT) {
    return driver.findElement(ELEMENT).isDisplayed();
  }

  public int IsElementExists(By ELEMENT){
    List<WebElement> dynamicElement = driver.findElements(ELEMENT);
    return dynamicElement.size();
  }

  public String GetColor(By ELEMENT) {
    return driver.findElement(ELEMENT).getCssValue("color");
  }

  public void ClearText(By ELEMENT) {
    driver.findElement(ELEMENT).clear();
  }

 

  public int GetHeight(By ELEMENT){
    return driver.findElement(ELEMENT).getSize().getHeight();
  }

  public int GetWidth(By ELEMENT){
    return driver.findElement(ELEMENT).getSize().getWidth();
  }

  //Multiple Click on Well Volume for Plate 96
  public void MultipleClickWellVolumeFor96Plate(By ELEMENT,String source, String destination){
    int diffSize = 42;
    int widthOfCanva = (GetWidth(ELEMENT)/2) - 61;
    int heightOfCanva = (GetHeight(ELEMENT)/2) - 54;
    System.out.println(driver.findElement(ELEMENT).getSize());
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

  // Multiple Click on Well Volume for Plate 384
  public void MultipleClickWellVolumeFor384Plate(By ELEMENT, String source, String destination) {
    int diffSize = 20;
    int widthOfCanva = (GetWidth(ELEMENT)/2) - 30;
    int heightOfCanva = (GetHeight(ELEMENT)/2) - 30;
    
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
        int sizeOperation = col + diffSizeOperation;
        System.out.println("X : " + -widthOfCanva + sizeOperation * diffSize + ", Y : " + -heightOfCanva
            + row * diffSize);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(ELEMENT), -widthOfCanva+sizeOperation*diffSize, -heightOfCanva+row*diffSize)
        .click()
        .build()
        .perform();
      }
    }
  }

  public void SwitchContent(By ELEMENT){
    driver.switchTo().frame(driver.findElement(ELEMENT));
  }

  public void SwitchToDefaultContent(){
    driver.switchTo().defaultContent();
  }

  //Experiment Designer
  public void ClickSingleWellVolumeOn96WellPlateWithArrowExpDesigner(By ELEMENT, String wellVolume){
    int diffSize = 40;
    int widthOfCanva = (GetWidth(ELEMENT)/2) - 67;
    int heightOfCanva = (GetHeight(ELEMENT)/2) - 68;
    char rowSource = wellVolume.substring(0,1).charAt(0);
    String colSource = wellVolume.substring(1, 3);
    int numberOfRow = (int)rowSource -65;
    int diffSizeOperationX = Integer.parseInt(colSource)-1;  

    act.moveToElement(driver.findElement(ELEMENT), -widthOfCanva+diffSizeOperationX*diffSize, -heightOfCanva+numberOfRow*diffSize)
    .click().build().perform();
  }
}
