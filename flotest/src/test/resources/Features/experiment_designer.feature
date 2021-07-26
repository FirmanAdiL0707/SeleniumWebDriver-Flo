
Feature: Experiment Designer

  Scenario: FLO-1382:Create combination stock without define stock first
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR
    And I Drag "Eppendorf Microplate 384/V" and drop to "AREA1"
    And I Drag "Brand Assay 384 120ul" and drop to "AREA2"
    And I click experiment designer and select "1" as destination
    Then stock setup popup displayed
    And I click stock definition number 1
    And I multipleclick 384 plate on StockDefinition from "A01" to "H01"
    And I set all stock become single "Stock 1" on column "1" row "B,C,D,E,F,G,H"
    And I click New Group button
    And I multipleclick 384 plate on StockDefinition from "A02" to "H02"
    And I click create button on stock group
    And I click New Group button
    And I multipleclick 384 plate on StockDefinition from "I01" to "P12"
    And I click create button on stock group
    And I click finish button
    And I click experiment designer and select "2" as destination
    Then System only displayed single stock
    Then System display group stock with number "2" and "3"
    And I click stock "1" on stock list on experiment designer
    And I select pattern "5" on experiment designer
    And I apply "10" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "10" dispense volume and "μL" unit
    And I add stock on experiment designer
    And I click stock "2" on stock list on experiment designer
    And I select pattern "1" on experiment designer for group stock
    And I activate setup dispense volume on experiment designer
    And I apply "10" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "10" dispense volume and "μL" unit
    And I finish experiment designer
    And I create Stock

  Scenario: FLO-1212:Consume combination result
    Given I navigated to FLO 
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
    And I click experiment designer and select "1" as destination
    Then stock setup popup displayed
    And I click stock definition number 1
    And I multipleclick from "A01" to "H01" on plate 96
    And I set 96 plate all stock become single "Stock 1" on column "1" row "B"
    And I set 96 plate all stock become single "Stock 2" on column "1" row "C"
    And I set 96 plate all stock become single "Stock 2" on column "1" row "D"
    And I set 96 plate all stock become single "Stock 3" on column "1" row "E"
    And I set 96 plate all stock become single "Stock 3" on column "1" row "F"
    And I set 96 plate all stock become single "Stock 4" on column "1" row "G"
    And I set 96 plate all stock become single "Stock 4" on column "1" row "H"
    And I click finish button
    And I click experiment designer and select "2" as destination
    Then System display single stock with number "1" and "2"
    Then System display single stock with number "3" and "4"
    And I click stock "1" on stock list on experiment designer
    And I click "A01" well volume on destination experiment designer
    And I apply "5" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "5" dispense volume and "μL" unit
    And I add stock on experiment designer
    And I click stock "1" on stock list on experiment designer
    And I click "A01" well volume on destination experiment designer
    And I apply "5" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "5" dispense volume and "μL" unit
    And I add stock on experiment designer
    And I click stock "1" on stock list on experiment designer
    And I click "A01" well volume on destination experiment designer
    And I apply "5" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "5" dispense volume and "μL" unit
    And I add stock on experiment designer
    And I click stock "1" on stock list on experiment designer
    And I click "A01" well volume on destination experiment designer
    And I apply "5" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "5" dispense volume and "μL" unit
    And I finish experiment designer
    And I create Stock

  Scenario: FLO-1384:Create ED group of plate 96 well
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Eppendorf twin.tec PCR Plate 384 skirted 40uL" and drop to "AREA2"
    And I click set stock definition
    Then stock setup popup displayed
    And I click stock definition number 1
    And I click New Group button
    And I multipleclick from "A01" to "H12" on plate 96
    And I click create button on stock group
    And I click finish button
    And I click experiment designer and select "2" as destination
    Then System only displayed single group stock
    And I click stock "1" on stock list on experiment designer
    And I click "A01" 384 plate well volume on destination experiment designer
    And I activate setup dispense volume on experiment designer
    And I apply "10" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "10" dispense volume and "μL" unit
    And I finish experiment designer
    And I create Stock
@RunExperimentDesigner
  Scenario: FLO-1387:Create ED combination group and non-group intersect
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Eppendorf twin.tec PCR Plate 384 skirted 40uL" and drop to "AREA2"
    And I click set stock definition
    Then stock setup popup displayed
    And I click stock definition number 1
    And I multipleclick from "A01" to "C01" on plate 96
    And I click New Group button
    And I multipleclick from "A02" to "H02" on plate 96
    And I click create button on stock group
    And I click finish button
    And I click experiment designer and select "2" as destination
    Then System display single stock with number "2" and "3"
    Then System only displayed single group stock
    And I click stock "4" on stock list on experiment designer
    And I click "E11" 384 plate well volume on destination experiment designer
    And I activate setup dispense volume on experiment designer
    And I apply "10" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "10" dispense volume and "μL" unit
    And I add stock on experiment designer
    And I click stock "1" on stock list on experiment designer
    And I turn off summary view on experiment designer
    And I select pattern "1" on experiment designer
    And I apply "10" with unit "μL" on dispense volume on experiment designer
    Then Validate dispense volume on exp designer "10" dispense volume and "μL" unit
    And I turn on summary view on experiment designer
    And I finish experiment designer
    And I create Stock




    