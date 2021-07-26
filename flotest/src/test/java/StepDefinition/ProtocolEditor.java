package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.Dimension;

import PageObject.CanvaSourceMap;
import PageObject.ExperimentDesignerPage;
import PageObject.ProtocolEditorPage;
import PageObject.ProtocolExplorerPage;
import PageObject.SimpleTransferPage;
import PageObject.SerialDilution.SerialDilutionPage;
import PageObject.StockDefinition.StockDefinitionPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProtocolEditor {

  //WebDriver driver;
  //WebDriverWait wait;
  private ProtocolExplorerPage pex;
  private ProtocolEditorPage ped;
  private SimpleTransferPage st;
  private ExperimentDesignerPage ed;
  private SerialDilutionPage _serialDilutionPage;
  private CanvaSourceMap _canvaSourceMap;
  private StockDefinitionPage _stockDefinitionPage;

  String TaskType = "";

  public ProtocolEditor() {
    this.pex = new ProtocolExplorerPage();
    this.ped = new ProtocolEditorPage();
    this.st = new SimpleTransferPage();
    this.ed = new ExperimentDesignerPage();
    this._serialDilutionPage = new SerialDilutionPage();
    this._canvaSourceMap = new CanvaSourceMap();
    this._stockDefinitionPage = new StockDefinitionPage();
  } 

  @And("Validate {string} exist")
  public void ValidateProtocolExistOrNot(String nameOfProtocol) throws InterruptedException{
      ped.ValidateProtocolExistOrNot(nameOfProtocol);
      pex.WaitingLoadingProcess();
  }

  @And("I Duplicate a Protocol {string}")
  public void DuplicateProtocol(String protocolName) throws InterruptedException{
      ped.DuplicateProtocol(protocolName);
      Thread.sleep(5000);
  }

  @And("Open Protocol {string}")
  public void OpenProtocol(String protocolName) throws InterruptedException{
      Thread.sleep(1000);
      ped.OpenProtocol(protocolName);
  }

  @Given("I navigated to FLO")
  public void i_navigated_to_flo() {
    
  }

  @Given("I login as {string}")
  public void i_login_as(String username) {
    pex.WaitingLoadingProcess();
    pex.Login("service", "Formulatrix2019");
    pex.RestoreSessionNo();
  }

  @Given("I open {string} protocol")
  public void i_open_protocol(String protocol) {
    pex.SearchProtocol(protocol);
    pex.OpenProtocol();
  }

  @Given("I click {string} and select {string} as source and {string} destination")
  public void i_click_simple_transfer_and_select_as_source_and_destination(String taskType, String source, String destination) {
    TaskType = taskType;
    ped.ClickSimpleTransfer();
    ped.SelectLabware(source, taskType);
    ped.ClickNext();
    ped.SelectLabware(destination,taskType);
    ped.ClickNext();
  }

  @And("I select {string} well on simple transfer {string}")
  public void i_select_well_on_simple_transfer_source(String well, String mapSource) throws InterruptedException {
    Thread.sleep(1500);
    st.ClickSingleWellVolumeFor96WellVolumeOnSource(well,mapSource);
  }

  @Then("selected source location highlighted")
  public void selected_source_location_highlighted() {

  }

  @Then("destination labware enabled is {string}")
  public void destination_labware_enabled_is(String enable) {
    Boolean en = Boolean.parseBoolean(enable);
    assertEquals(en, st.IsEnabledDestinationLabware());
  }

  @Then("destination list enabled is {string}")
  public void destination_list_enabled_is(String enable) {
    Boolean en = Boolean.parseBoolean(enable);
    assertEquals(en, st.IsEnabledDestinationList());
  }

  @Then("I click destination labware")
  public void i_click_destination_labware() throws InterruptedException {
    st.ClickDestinationLabwware();
    Thread.sleep(2000);
  }

  @Then("summary view visible is {string} and copy mapping visible is {string}")
  public void summary_view_visible_is_and_copy_mapping_visible_is(String summary, String copy) {
    Boolean bolsummary = Boolean.parseBoolean(summary);
    Boolean bolcopy = Boolean.parseBoolean(copy);
    assertEquals(bolsummary, st.IsEnabledSummaryView());
    assertEquals(bolcopy, st.IsVisibleCopyMapping());
  }

  @Then("setup dispense volume and pipetting parameters tab enabled is {string}")
  public void setup_dispense_volume_and_pipetting_parameters_tab_enabled_is(String tab) {
    Boolean boltab = Boolean.parseBoolean(tab);
    assertEquals(boltab, st.IsEnabledDispenseVolumeTab());
  }

  @Then("apply dispense volume button enabled is {string}")
  public void apply_dispense_volume_button_enabled_is(String applybutton) {
    Boolean bolapply = Boolean.parseBoolean(applybutton);
    assertEquals(bolapply, st.IsEnabledApplyDispenseVolume());
  }

  @Then("{string} displayed on destination in {string}")
  public void displayed_on_destination_in(String message, String color) throws InterruptedException {
    assertEquals(message, st.GetDestinationMessage());
    Thread.sleep(1500);
    //assertEquals(color, st.GetDestinationMessageColor());
  }

  @And("I multipleclick {string} to {string} well on simple transfer {string}")
  public void i_select_well_on_simple_transfer_destination(String source, String destination, String sourceMap){
    if(sourceMap.equalsIgnoreCase("destination")){
      _canvaSourceMap.MultipleClickWellVolumeFor96PlateDestination(source, destination);
    }else if(sourceMap.equalsIgnoreCase("source")){
      _canvaSourceMap.MultipleClickWellVolumeFor96PlateSource(source, destination);
    }
  }

  @Then("selected destination location highlighted")
  public void selected_destination_location_highlighted() {

  }

  @Then("source labware enabled is {string}")
  public void source_labware_enabled_is(String source) {
    Boolean bolsource = Boolean.parseBoolean(source);
    assertEquals(bolsource, st.IsEnabledSourceLabware());
  }

  @Then("discard button enabled {string}")
  public void discard_button_enabled(String string) {

  }

  @Then("finish button enabled {string}")
  public void finish_button_enabled(String string) {

  }

  @And("I apply {string} with unit {string} on dispense volume")
  public void i_apply_with_unit_on_dispense_volume(String volume, String string2) {
    st.EnterDispenseVolume(volume);
    st.ApplyDispenseVolume();
  }

  @Then("I finish simple transfer")
  public void i_finish_simple_transfer() throws InterruptedException {
    st.FinsihSimpleTransfer();
    pex.WaitingLoadingProcess();
  }

  @Then("navigated to protocol editor")
  public void navigated_to_protocol_editor() {

  }

  @And("I navigated to PROTOCOL EDITOR")
  public void navigated_to_protocol_editor_1(){
    pex.OpenProtocolEditor();
  }

  @Then("simple transfer added into left panel with aspirate from is {string} dispense into is {string} volume is {string}")
  public void simple_transfer_added_into_left_panel_with_aspirate_from_is_dispense_into_is_volume_is(String aspirate,
      String dispense, String volume) {
    ped.ClickCardList();
    assertEquals(aspirate, ped.GetAspirateCardList());
    assertEquals(dispense, ped.GetDispenseCardList());
    assertEquals(volume, ped.GetVolumeCardList());
        
  }

  @Then("pooling destination is indicated as pie chart")
  public void pooling_destination_is_indicated_as_pie_chart() {

  }

  @Given("I click {string} and select source and two destinations")
  public void i_click_simple_transfer_and_select_source_and_two_destinations(String taskType) {
    TaskType = taskType;
    ped.ClickSimpleTransfer();
    ped.SelectLabware("1", taskType);
    ped.ClickNext();
    ped.SelectLabware("2", taskType);
    ped.SelectLabware("3", taskType);
    ped.ClickNext();
  }

  @Then("I select pattern {string}")
  public void i_select_pattern(String pattern) {
    st.SelectPattern("3");
  }

  @Given("I select {string} well on {int} plate on simple transfer source")
  public void i_select_well_on_plate_on_simple_transfer_source(String well, Integer int1) {
    System.out.println("well : " + well);
    String row = well.substring(1, 3);
    String column = well.substring(0, 1);
    System.out.println("Row : " + row + ", Column : " + column);

    HashMap<String, Integer> x = new HashMap<String, Integer>();
    x.put("01", -256);

    HashMap<String, Integer> y = new HashMap<String, Integer>();
    y.put("X", -190);
    y.put("A", -130);


    if (well.equals("all")) {
      st.SelectSourceMap(-300, -170);
    } else {
      if (column.equals("Z")) {
        for (int i = -190; i < 170; i = i + 40) {
          System.out.println(i);
          st.SelectSourceMap(x.get(row), i);
        }
      } else if (row.equals("ZZ")) {
        for (int i = -238; i < 280; i = i + 42) {
          System.out.println(i);
          st.SelectSourceMap(i, y.get(column));
        }
      } else {
        System.out.println("Coordinate : " + x.get(row) + "," + y.get(column));
        st.SelectSourceMap(x.get(row), y.get(column));
      }
    }
  }

  @And("I click coloumn no {string} on 384 plate on simple transfer destination")
  public void i_select_well_on_plate_on_simple_transfer_destination(String numbOfColoumn) {
      _canvaSourceMap.ClickColoumnFor384WellVolumeOnDestinationST(numbOfColoumn);
  }

  @And("I click coloumn no {string} on 96 plate on simple transfer source")
  public void i_select_Coloum_on_96plate_on_simple_transfer_source(String numbOfColoumn) {
      _canvaSourceMap.ClickColoumnFor96WellVolumeOnSourceST(numbOfColoumn);
  }

  @Then("I copy mapping")
  public void i_copy_mapping() {
    st.CopyMapping();
  }

  @Then("I select row {string} on destination list")
  public void i_select_row_on_destination_list(String row) {
    st.SelectDestinationList(row);
  }

  @Then("I paste mapping")
  public void i_paste_mapping() {
    st.PasteMapping();
  }

  @Then("list of transfer row {string} display {string} with {string}")
  public void list_of_transfer_row_display_with(String string, String string2, String string3) {

  }
  
  @Given("I click experiment designer and select {string} as destination")
  public void i_click_experiment_designer_and_select_as_destination(String labware) {
    ped.ClickExperimentDesigner();
    ped.SelectExperimentDesignLabware(labware);
    ped.ClickNext();
  }

  @Given("I select {string} well on experiment designer using plate {int}")
  public void i_select_well_on_experiment_designer(String well, int plate) throws InterruptedException {
    System.out.println("well : " + well);
    String row = well.substring(1, 3);
    String column = well.substring(0, 1);
    System.out.println("Row : " + row + ", Column : " + column);
    System.out.println("Using plate : " + plate);

    HashMap<String, Integer> x = new HashMap<String, Integer>();
    HashMap<String, Integer> y = new HashMap<String, Integer>();

    if (plate == 96) {
      
      x.put("01", -185);
      x.put("02", -145);
      x.put("03", -105);
      x.put("04", -68);
      x.put("05", -31);

      
      y.put("A", -132);
    }
    
    if (plate == 384) {
      x.put("01", -230);
      x.put("11", -30);
      x.put("12", -10);

      y.put("A", -170);
      y.put("E", -90);
      y.put("F", -70);
    }

    System.out.println("Coordinate : " + x.get(row) + "," + y.get(column));
    ed.SelectDestinationMap(x.get(row), y.get(column));
    Thread.sleep(1000);
  }

  @Given("I apply {string} with unit {string} on experiment designer dispense volume and {string} displayed")
  public void i_apply_with_unit_on_experiment_designer_dispense_volume_and_displayed(String volume, String unit,
      String message) throws InterruptedException {
    ed.EnterDispenseVolume(volume,unit);
    Thread.sleep(2000);
    System.out.println(ed.GetDispenseVolumeMessage().replace("\n", " "));
    assertEquals(message, ed.GetDispenseVolumeMessage().replace("\n", " "));
    ed.ApplyDispenseVolume();
  }

  @Given("I unselect stock {string}")
  public void i_unselect_stock(String stock) {
    ed.UnselectStock(stock);
  }

  @And("I finish experiment designer")
  public void i_finish_experiment_designer() throws InterruptedException {
    ed.FinishExperimentDesigner();
    pex.WaitingLoadingProcess();
  }

  @Then("Create New Stock Combinations displayed with {string} and {string} volume")
  public void create_new_stock_combinations_displayed_with_and_volume(String volume1, String volume2) {
    assertEquals(volume1, ed.GetStockCombinationsVolume1());
    assertEquals(volume2, ed.GetStockCombinationsVolume2());
  }

  @Then("stock {int} Stock {int} and Combination of {int} Ingredients listed on the source list")
  public void stock_stock_and_combination_of_ingredients_listed_on_the_source_list(Integer int1, Integer int2,
      Integer int3) {
    
  }

  @Then("the volume is written inside the stock mapped")
  public void the_volume_is_written_inside_the_stock_mapped() {
   
  }

  @And("I select stock {string}")
  public void i_select_stock(String stock) {
    System.out.println("Stock : " + stock);
    ed.SelectStock(stock);
  }

  @Then("I apply {string} with unit {string} on simple transfer dispense volume and {string} displayed")
  public void i_apply_with_unit_on_simple_transfer_dispense_volume_and_displayed(String volume, String unit,
      String message) {
    st.EnterDispenseVolume(volume);
    assertEquals(message, st.GetDispenseVolumeMessage());
    st.ApplyDispenseVolume();    
  }

  @And("I run protocol")
  public void i_run_protocol() throws InterruptedException {
    ped.RunProtocol();
    pex.WaitingLoadingProcess();   
  }

  @Then("I click stock info")
  public void i_click_stock_info() throws InterruptedException {
    ped.SourceInfo();
    Thread.sleep(4000);  
  }

  @Then("{string} well displayed volume {string} and {string}")
  public void well_displayed_volume_and(String row, String volume1, String volume2) {
    ped.InitialStockExpand(row);
    assertEquals(volume1, ped.GetStockVolume1(row));
    assertEquals(volume2, ped.GetStockVolume2(row));
  }

  @Then("I back to protocol editor page")
  public void i_back_to_protocol_editor_page() throws InterruptedException {
    Thread.sleep(3000);
    ped.CloseInitialStock();
    ped.ClickBackOnPreparing();
  }

  @Then("{string} warning displayed on initial stock")
  public void warning_displayed_on_initial_stock(String message) {
    System.out.println(ped.GetInitialStockWarning());
    assertEquals(message, ped.GetInitialStockWarning());
  }

  @And("I Drag {string} and drop to {string}")
  public void i_drag_and_drop_to_labware(String plateName, String labwareArea) throws InterruptedException{
    ped.DragPlateToDropArea(plateName, labwareArea);
    Thread.sleep(350);
  }

  @And("I click set stock definition")
  public void ClickSetStockDefinitionMenu(){
    ped.ClickStockDefinition();
  }

 

  @And("I click {string} with Stock and source {string} as dilution")
  public void i_click_serialdilution_withstock(String taskType, String dilutionSource) throws InterruptedException{
    TaskType = taskType;
    Thread.sleep(1100);
    ped.SerialDilutionWithStock(dilutionSource, taskType);
    Thread.sleep(1500);
  }

  @And("I select serial dilution without stock")
  public void i_click_serialdilution_without_stock(){    
    ped.SerialDilutionWithoutStock();
  }

  @And("I add diluent with stock number {string} as dilution")
  public void AddDiluent(String stockNumber) throws InterruptedException{
    ped.AddDiluentWithStock(stockNumber);
  }
  @And("I add sample with stock group number {string} as sample")
  public void AddDiluentWithStockGroup(String stockNumber) throws InterruptedException{
    ped.AddSampleWithStockGroup(stockNumber);
  }

  @And("I add sample with stock number {string} as sample")
  public void AddSample(String stockNumber) throws InterruptedException{
    ped.AddSample(stockNumber);
  }

  @And("I click well {string}")
  public void ClickWellOnSerialDilutionPlate(String wellVolume) throws InterruptedException{
    Thread.sleep(1000);
    int x0 = -218;
    int x;
    int column = Integer.parseInt(wellVolume.substring(1, 3));
    String row = wellVolume.substring(0, 1);
    int x1 = (column-1) * 40;
    
    HashMap<String, Integer> y = new HashMap<String, Integer>();
    y.put("A", -136);
    y.put("B", -97);
    y.put("C", -58);
    y.put("D", -19);
    y.put("E", 20);
    y.put("F", 59);
    y.put("G", 98);
    y.put("H", 134);
    
    x = (x0 + x1);
    //System.out.println(x+ " ULFAAAAA "+ y.get(row));
    ped.ClickWellVolume96OnSerialDilutionPlate(x, y.get(row));
    Thread.sleep(500);
  }
  
  @And("I set {string} point along the {string} with {string} dilution direction and {string} ratio on setup dilution")
  public void SetSetupDilution(String point,String alongSide,String direction,String ratio){
    ped.InputSetupDilution(point, alongSide, direction, ratio);
  }

  @Then("point value is {string} along {string} with {string} dilution direction and {string} as ratio with stock is {string}")
  public void ValidationOnSetupDilution(String point, String alongSide, String direction, String ratio, String validation){
      assertEquals(point, _serialDilutionPage.ValidatePointOnSerialDilution(validation));
      assertEquals(alongSide, _serialDilutionPage.ValidateAlongSide(validation));
      assertEquals(direction, _serialDilutionPage.ValidateDirection(validation));
      assertEquals(ratio, _serialDilutionPage.ValidateRatio(validation));
  }

  @And("I set {string} μl on setup volume")
  public void SetSetupVolume(String sampleVolume){
    ped.InputSetupVolume(sampleVolume);
  }

  @Then("sample volume set as {string} with {string} text appears with stock is {string}")
  public void ValidateSampleVolume(String volumeSet, String textAppears, String validation){
      assertEquals(volumeSet, _serialDilutionPage.ValidateDiluentVolume(validation));
      assertEquals(textAppears, _serialDilutionPage.ValidateDiluentText(validation));
  }

  @And("I click apply sample volume")
  public void ClickApplySampleVolume(){
    ped.ClickApplySampleVolume();
  }

  @And("I click apply sample volume without stock")
  public void ClickApplySampleVolumeWithoutStock(){
    _serialDilutionPage.ClickApplySampleVolumeWithoutStock();
  }

  @And("I click finish on serial dilution")
  public void ClickFinishSerialDilution(){
    ped.FinishSerialDilution();
    pex.WaitingLoadingProcess();
  }

  @Then("I navigated to stock combination and i create stock")
  public void NavigatedToStockCombination(){
    ped.ClickCreateStockOnCombinationStock();
    pex.WaitingLoadingProcess();
  }

  @And("I multipleclick from {string} to {string} on plate 96")
  public void SwipeWellVolumeOn96SerialDilutionPlate(String source, String destination) throws InterruptedException{
    Thread.sleep(1000);
    ped.SwipeWellVolume96WellPlateOnSerialDilution(source,destination);
  }

  @And("I click create group button")
  public void ClickCreateGroupButton(){
    ped.ClickCreateStockGroupButton();
  }

  @And("I click create group stock button")
  public void ClickCreateGroupStockButton(){
    ped.ClickCreateStockGroupButton();
  }

  @And("I click finish button")
  public void ClickFinisAfterCreateStock() throws InterruptedException{
    ped.ClickFinish();
    pex.WaitingLoadingProcess();
  }

  @And("I select labware on {string} number {string}")
  public void SelectLabwareByPosition(String TaskType, String labwareSource){
    ped.SelectLabware(labwareSource, TaskType);
    ped.ClickNext();
  }

  @And("I click diluent plate and fill well on {string}")
  public void SelectDiluentPlateAndFillWellVolume(String wellVolume){
    //_serialDilutionPage.ClickDiluentPlate();
    _serialDilutionPage.ClickSingleWellVolumeFor96WellVolumeOnSample(wellVolume);
  }
  
  @And("I click diluent plate and click column group on {string}")
  public void SelectDiluentPlateAndClickColumnGroup(String wellVolume){
    _serialDilutionPage.ClickColumnGroupByColumnOn96WellPlate(wellVolume);
  }

  @And("I click the well {string} on 384 plate")
  public void ClickWellOn384Plate(String wellVolume) throws InterruptedException{
    Thread.sleep(1000);
    _serialDilutionPage.ClickSingleWellVolumeFor384WellVolumeForSerialDilution(wellVolume);
  }
  @And("I click sample plate and fill well on {string}")
  public void SelectSamplePlateAndFillWellVolume(String wellVolume){
    _serialDilutionPage.ClickSamplePlate();
    _serialDilutionPage.ClickSingleWellVolumeFor96WellVolumeOnSample(wellVolume);
  }

  @And("I click sample plate and click column group on {string}")
  public void SelectSamplePlateAndClickColumnGroup(String wellVolume){
    _serialDilutionPage.ClickSamplePlate();
    _serialDilutionPage.ClickColumnGroupByColumnOn96WellPlate(wellVolume);
  }

  @And("I click arrow button to change focus of plate")
  public void ClickArrowButtontoChangeFocusOfPlate(){
    _serialDilutionPage.ClickChangePlateButton();
  }

  @And("I click well {string} on 384 plate")
  public void ClickWellVolumeOn384Plate(String wellVolume){
    _serialDilutionPage.ClickSingleWellVolumeFor384WellVolumeForSerialDilution(wellVolume);
  }

  @And("I set {string} point along the {string} with {string} dilution direction and {string} ratio on setup dilution without stock")
  public void SetSetupDilutionWithoutStock(String point,String alongSide,String direction,String ratio){
    _serialDilutionPage.InputSetupDilutionWihtoutStock(point, alongSide, direction, ratio);
  }

  @And("I set {string} μl on setup volume without stock")
  public void SetSetupVolumeWithoutStock(String sampleVolume){
    _serialDilutionPage.InputSetupVolumeWihtoutStock(sampleVolume);
  }

  @And("I select dispense pattern number {string}")
  public void SelectDispensePattern(String numberOfPattern){
    _serialDilutionPage.SelectPatternByNumber(numberOfPattern);
  }

  @And("I click Yes button on update dispense pattern")
  public void ClickYesButtonOnUpdateDispensePattern(){
    _serialDilutionPage.ClickYesButtonOnUpdateDispenseMessage();
  }

  @Then("serial dilution popup displayed")
  public void IsSerialDilutionPopUpAppears(){
    assertEquals(1, _serialDilutionPage.ValidateSerialDilutionPopup());
    assertEquals("Serial Dilution", _serialDilutionPage.GetTitle());
  }

  @Then("Diluent button change become {string}")
  public void ValidateDiluentButton(String textButton) throws InterruptedException{
    Thread.sleep(750);
    assertEquals(textButton, _serialDilutionPage.ValidateDiluentButton());
  }

  @Then("Sample button change become {string}")
  public void ValidateSampleButton(String textButton) throws InterruptedException{
    Thread.sleep(750);
    assertEquals(textButton, _serialDilutionPage.ValidateSampleButton());
  }

  @And("I click arrow button card")
  public void ClickArrowButtonCard(){
    ped.ClickArrowCardList();
  }

  @Then("Diluent volume should be {string} on stock list number {string}")
  public void ValidateVolumeonCardList(String volume, String cardList){
      assertEquals(volume, ped.ValidateCardListVolume(cardList));
  }

  @Then("Validate that Diluent selected")
  public void ValidateThatDiluentSelected(){
      assertEquals(1, _serialDilutionPage.ValidateDiluentSelected());
      assertEquals(1, _serialDilutionPage.ValidateTrashButtonOnDiluent());
  }

  @Then("Validate that Sample selected")
  public void ValidateThatSampleSelected(){
      assertEquals(1, _serialDilutionPage.ValidateSampleSelected());
      assertEquals(1, _serialDilutionPage.ValidateTrashButtonOnSample());
  }

  @Then("Update dispense pattern popup displayed")
  public void ValidateUpdateDispensePatternPageAppears(){
    assertEquals(1, _serialDilutionPage.ValidateUpdateDispensePattern());
  }
}
