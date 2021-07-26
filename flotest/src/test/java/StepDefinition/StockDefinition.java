package StepDefinition;

import static org.junit.Assert.assertEquals;

import PageObject.ProtocolEditorPage;
import PageObject.ProtocolExplorerPage;
import PageObject.StockDefinition.StockDefinitionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StockDefinition {

    private StockDefinitionPage _stockDefinitionPage;
    private ProtocolEditorPage _protocolEditorPage;
    private ProtocolExplorerPage _protocolExplorerPage;
  
    public StockDefinition() {
        _stockDefinitionPage = new StockDefinitionPage();
        _protocolEditorPage = new ProtocolEditorPage();
        _protocolExplorerPage = new ProtocolExplorerPage();
    } 

    @Then("stock setup popup displayed")
    public void VerifyStockPageIsAppears(){
        assertEquals(1,_stockDefinitionPage.IsStockDefinitionPageAppears());
        assertEquals("Stock Setup", _stockDefinitionPage.GetTitle());
    }

    @And("I click stock definition number {int}")
    public void ClickStockDefinitionNumber(int stockNumber){
        _stockDefinitionPage.ClickStockNumber(stockNumber);
    }

    @And("I set stock on Stock Definition number {int} and fill {string}")
    public void i_set_stock_on_StockDefinition_and_fill(int stockNumber, String wellVolume) throws InterruptedException {
        Thread.sleep(2000);
        _stockDefinitionPage.ClickStockNumber(stockNumber);
        _stockDefinitionPage.ClickSingleWellVolumeFor96WellVolume(wellVolume);
        _protocolEditorPage.ClickFinish();
        _protocolExplorerPage.WaitingLoadingProcess();
    }

    @And("I multipleclick 384 plate on StockDefinition from {string} to {string}")
    public void MultipleClick384PlateOnStockDefinition(String source, String destination) throws InterruptedException{
        Thread.sleep(400);
        _stockDefinitionPage.MultipleClickWellVolumeFor384Plate(source, destination);
    }

    @And("I click stock number {int} and click new group")
    public void ClickStockSourceAndCreateNewGroup(int stockNumber){
        _stockDefinitionPage.ClickStockNumber(stockNumber);
        _stockDefinitionPage.ClickNewGroupButton();
    }

    @And("I click New Group button")
    public void ClickNewGroupButton(){
        _stockDefinitionPage.ClickNewGroupButton();
    }

    @And("I click create button on stock group")
    public void ClickCreateButtonOnStockGroup(){
        _stockDefinitionPage.ClickCreateButtonOnStockDef();
    }
    
}
