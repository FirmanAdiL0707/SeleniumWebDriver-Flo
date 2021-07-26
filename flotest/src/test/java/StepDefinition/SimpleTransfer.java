package StepDefinition;

import static org.junit.Assert.assertEquals;

import PageObject.ProtocolEditorPage;
import PageObject.ProtocolExplorerPage;
import StepDefinition.Init.Infrastructure.Driver.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SimpleTransfer {

    ProtocolEditorPage _protocolEditorPage;
    ProtocolExplorerPage _protocolExplorer;
  
    public SimpleTransfer() {
      this._protocolEditorPage = new ProtocolEditorPage();
      this._protocolExplorer = new ProtocolExplorerPage();
    } 

    @And("click Go button")
    public void ClickGoButton(){
      _protocolEditorPage.ClickGoButton();
    }

    @Then("validate buttons while ready to run")
    public void ValidateButtonsWhileReadytoRun(){
      _protocolEditorPage.WaitGoButtonAppears();
        assertEquals("GO", _protocolEditorPage.ValidateGetTextRunButton());
        assertEquals(1, _protocolEditorPage.ValidateGoButton());
        assertEquals(1, _protocolEditorPage.ValidateSourceInfoButton());        
    }

    @Then("validate running protocol")
    public void ValidateRunningProtocol(){
        assertEquals(1, _protocolEditorPage.ValidatePauseButton());
        assertEquals(1, _protocolEditorPage.ValidateAbortButton());
        assertEquals("PAUSE", _protocolEditorPage.ValidateGetTextonPauseButton());
        _protocolEditorPage.WaitRunningProtocolFinished();
    }

    @Then("{string} displayed on status text")
    public void ValidateTextonRunningProtocol(String text){
      assertEquals(text, _protocolEditorPage.ValidateGetTextRunningProtocol());
    }

    @And("I close the page after run")
    public void CloseThePageAfterRun(){
      _protocolEditorPage.ClickCloseButton();
      if(_protocolEditorPage.ValidateAbortMessage() == 1){
        _protocolEditorPage.ClickYesAbortButton();
        _protocolExplorer.WaitingLoadingProcess();
      }
        _protocolExplorer.WaitingLoadingProcess();
    }
  
    
}
