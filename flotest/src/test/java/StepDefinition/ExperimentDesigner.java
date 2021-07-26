package StepDefinition;

import static org.junit.Assert.assertEquals;

import PageObject.CanvaSourceMap;
import PageObject.ExperimentDesignerPage;
import PageObject.ProtocolExplorerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ExperimentDesigner {
    private ExperimentDesignerPage _experimentDesigner;
    private ProtocolExplorerPage _protocolExplorer;
    private CanvaSourceMap _canvaSourceMap;

    public ExperimentDesigner(){
        _experimentDesigner = new ExperimentDesignerPage();
        _protocolExplorer = new ProtocolExplorerPage();
        _canvaSourceMap = new CanvaSourceMap();
    }
    
    @And("I click stock {string} on stock list on experiment designer")
    public void ClickStockOnListStockDefinition(String numberStock) throws InterruptedException{
        _experimentDesigner.ClickSingleStockByNumber(numberStock);
        Thread.sleep(500);
    }

    @And("I select pattern {string} on experiment designer")
    public void SelectPatternByNumber(String numberOfPattern){
        _experimentDesigner.ClickPatternByNumber(numberOfPattern);
    }

    @And("I select pattern {string} on experiment designer for group stock")
    public void SelectPatternByNumberForGroupStock(String numberOfPattern){
        _experimentDesigner.ClickPatternByNumberForGroupStock(numberOfPattern);
    }

    @And("I apply {string} with unit {string} on dispense volume on experiment designer")
    public void ApplyVolumeAndClickApplyVolumeButton(String volume, String unit){
        _experimentDesigner.EnterDispenseVolume(volume,unit);
        _experimentDesigner.ApplyDispenseVolume();
    }

    @Then("Validate dispense volume on exp designer {string} dispense volume and {string} unit")
    public void ValidateSetupDispenseVolume(String dispenseVolume, String unitDispense){
        assertEquals(dispenseVolume, _experimentDesigner.ValidateDispenseVolume());
        assertEquals(unitDispense, _experimentDesigner.ValidateUnitDispenseVolume());
    }

    @And("I set all stock become single {string} on column {string} row {string}")
    public void SetAllStockBecomeSingleStock(String nameStock, String coloumn, String listOfRow) throws InterruptedException{
        _experimentDesigner.GroupingStock(nameStock,coloumn,listOfRow);
    }

    @And("I set 96 plate all stock become single {string} on column {string} row {string}")
    public void SetAllStockBecomeSingleStockOn96Plate(String nameStock, String coloumn, String listOfRow) throws InterruptedException{
        Thread.sleep(200);
        _experimentDesigner.GroupingStockFor96Plate(nameStock,coloumn,listOfRow);
    }

    @And("I activate setup dispense volume on experiment designer")
    public void ClickSetupDispenseVolumeTabMenu(){
        _experimentDesigner.ActivateSetupDispenseVolume();
    }

    @And("I create Stock")
    public void i_create_stock() {
        _experimentDesigner.CreateStock();
        _protocolExplorer.WaitingLoadingProcess();
    }

    @And("I click {string} well volume on destination experiment designer")
    public void ClickSingleWellVolumeonDestinationPlateED(String wellVolume) throws InterruptedException{
        _experimentDesigner.ClickSingleWellVolumeOn96WellPlateWithArrow(wellVolume);
    }

    @And("I click {string} 384 plate well volume on destination experiment designer")
    public void ClickSingleWellVolumeOn384PlateEDWithoutArrow(String wellVolume){
        _canvaSourceMap.ClickSingleWellVolumeOn384WellPlateOnExpDesigner(wellVolume);
    }

    @And("I add stock on experiment designer")
    public void i_add_stock_on_experiment_designer() {
        _experimentDesigner.AddStock();
    }

    @And("I turn off summary view on experiment designer")
    public void TurnOffSummaryViewCheckbox(){
        _experimentDesigner.TurnOffSummaryView();
    }

    @And("I turn on summary view on experiment designer")
    public void TurnOnSummaryViewCheckbox(){
        _experimentDesigner.TurnOnSummaryView();
    }

    @Then("System only displayed single stock")
    public void ValidateSingleStock(){
        assertEquals(1, _experimentDesigner.ValidateSingleListStock());
    }

    
    @Then("System only displayed single group stock")
    public void ValidateSingleGroupStock(){
        assertEquals(1, _experimentDesigner.ValidateSingleGroupListStock());
    }

    @Then("System display group stock with number {string} and {string}")
    public void ValidateGroupStockByListNumber(String listNumber1, String listNumber2) throws InterruptedException{
        assertEquals(1, _experimentDesigner.ValidateGroupStockByPosition(listNumber1));
        Thread.sleep(400);
        assertEquals(1, _experimentDesigner.ValidateGroupStockByPosition(listNumber2));
    }

    @Then("System display single stock with number {string} and {string}")
    public void ValidateSingleStockByListNumber(String listNumber1, String listNumber2) throws InterruptedException{
        assertEquals(1, _experimentDesigner.ValidateListStockByPosition(listNumber1));
        Thread.sleep(400);
        assertEquals(1, _experimentDesigner.ValidateListStockByPosition(listNumber2));
    }
    
}
