package StepDefinition.Init.Infrastructure.Driver;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.internal.SystemPropertyUtil;

public class Wait {
    private WebDriver driver;
    private JavascriptExecutor executor;
    private WebDriverWait wait;
    private Action action;
    
    public Wait(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.action = new Action(driver);
    }

    public boolean WaitProgressBarIsDone(By ELEMENT){
        int timeout = 240000;
        long currentWaitTime = 0;
        long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
        boolean result = true;
        boolean staleElement = true;
        while(staleElement){
          try {
            if(action.IsElementExists(ELEMENT) != 1){
              staleElement = true;
              System.out.println(action.GetText(ELEMENT));
              currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
              if(currentWaitTime >=timeout )
              {
                result =false;
                System.out.println(ELEMENT.toString()+" Not Found.");
                break;
              }
            }else{
              staleElement = false;
            }
          } catch (Exception e) {
            staleElement = true;
          }
        }
        System.out.println("iki loooo "+action.GetText(ELEMENT));
        return result;
    }

    public boolean WaitComponentByText(By ELEMENT, String expectedText){
        int timeout = 300000;
        long currentWaitTime = 0;
        long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
        boolean result = true;
        while(action.GetText(ELEMENT) == expectedText){
          currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
          if(currentWaitTime >=timeout )
          {
            result =false;
            System.out.println(ELEMENT.toString()+" Not Found.");
            break;
          }
        }
        return result;
    }

       // Need to be Revisit
  public boolean WaitLoading(By ELEMENT){
    int timeout = 45000;
    long currentWaitTime = 0;
    long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
    boolean result = true;
    while(action.isVisible(ELEMENT) == true ){
      currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
      if(currentWaitTime >=timeout )
      {
        result =false;
        System.out.println(ELEMENT.toString()+" Not Found.");
        break;

      }
    }
    return result;
  }

  public boolean WaitComponent(By ELEMENT){
    int timeout = 45000;
    long currentWaitTime = 0;
    long startMs = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
    boolean result = true;
    while(action.isVisible(ELEMENT) == false ){
      currentWaitTime =   ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli() - startMs;
      if(currentWaitTime >=timeout )
      {
        result =false;
        System.out.println(ELEMENT.toString()+" Not Found.");
        break;
      }
    }
    return result;
  }
}
