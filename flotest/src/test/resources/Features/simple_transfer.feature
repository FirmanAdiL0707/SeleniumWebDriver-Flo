
Feature: Simple Transfer

  Scenario: FLO-935	Create ST single source to column and row
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR  
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
    And I click "simple transfer" and select "1" as source and "2" destination
    And I select "A01" well on simple transfer "source"
    Then selected source location highlighted
    Then destination labware enabled is "true"
    Then destination list enabled is "true"
    And I click destination labware
    Then summary view visible is "true" and copy mapping visible is "true"
    Then "Unmapped source: 1 well(s)" displayed on destination in "#rgba(5, 0, 255, 1)"
    And I multipleclick "A01" to "H01" well on simple transfer "destination"
    And I multipleclick "B02" to "B12" well on simple transfer "destination"
    Then selected destination location highlighted
    Then "Unmapped source: 0 well(s)" displayed on destination in "#rgba(146,203,153, 0.8)"
    Then setup dispense volume and pipetting parameters tab enabled is "true"
    Then discard button enabled "true"
    Then finish button enabled "false"
    And I apply "15" with unit "μL" on dispense volume
    And I finish simple transfer
    Then navigated to protocol editor
    Then simple transfer added into left panel with aspirate from is "Eppendorf Microplate 96/U" dispense into is "Covid19 Deepwell 96" volume is "15 μL"
    And I run protocol
    Then validate buttons while ready to run
    And click Go button
    Then validate running protocol
    Then "The protocol has been successfully executed!" displayed on status text
    And I close the page after run

  Scenario: FLO-1393	Create ST group of 96
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR  
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
    And I click "simple transfer" and select "1" as source and "2" destination
    And I select "all" well on simple transfer "source"
    Then selected source location highlighted
    Then destination labware enabled is "true"
    Then destination list enabled is "true"
    And I click destination labware
    Then summary view visible is "true" and copy mapping visible is "true"
    Then "Unmapped source: 1 group(s)" displayed on destination in "blue"
    And I select "all" well on simple transfer "destination"
    Then selected destination location highlighted
    Then "Unmapped source: 0 group(s)" displayed on destination in "#92CB99"
    Then setup dispense volume and pipetting parameters tab enabled is "true"
    Then discard button enabled "true"
    Then finish button enabled "false"
    And I apply "15" with unit "μL" on dispense volume
    And I finish simple transfer
    Then navigated to protocol editor
    Then simple transfer added into left panel with aspirate from is "Eppendorf Microplate 96/U" dispense into is "Covid19 Deepwell 96" volume is "15 μL"
    And I run protocol
    Then validate buttons while ready to run
    And click Go button
    Then validate running protocol
    Then "The protocol has been successfully executed!" displayed on status text
    And I close the page after run
@runst
  Scenario: FLO-940	Create multiple source-single destination (pooling)
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR  
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
    And I click "simple transfer" and select "1" as source and "2" destination
    And I multipleclick "A01" to "H01" well on simple transfer "source"
    Then destination labware enabled is "true"
    Then destination list enabled is "true"
    And I click destination labware
    Then summary view visible is "true" and copy mapping visible is "true"
    Then "Unmapped source: 8 well(s)" displayed on destination in "blue"
    And I select "A01" well on simple transfer "destination"
    Then selected destination location highlighted
    Then finish button enabled "false"
    And I apply "20" with unit "μL" on dispense volume
    Then pooling destination is indicated as pie chart
    And I finish simple transfer
    Then simple transfer added into left panel with aspirate from is "Eppendorf Microplate 96/U" dispense into is "Covid19 Deepwell 96" volume is "20 μL"
    And I run protocol
    Then validate buttons while ready to run
    And click Go button
    Then validate running protocol
    Then "The protocol has been successfully executed!" displayed on status text
    And I close the page after run

  Scenario: FLO-989	Copy mapping group of column (96 to 384 plate)
    Given I navigated to FLO
    And I login as "ulfa"
    And I navigated to PROTOCOL EDITOR  
    And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
    And I Drag "Eppendorf Microplate 384/V" and drop to "AREA2"
    And I Drag "Brand Assay 384 120ul" and drop to "AREA3"
    And I click "simple transfer" and select source and two destinations
    And I click coloumn no "3" on 96 plate on simple transfer source
    And I click coloumn no "7" on 96 plate on simple transfer source
    And I click destination labware
    Then "Unmapped source: 2 group(s)" displayed on destination in "blue"
    And I select pattern "3"
    And I click coloumn no "3" on 384 plate on simple transfer destination
    And I click coloumn no "7" on 384 plate on simple transfer destination
    And I apply "25" with unit "μL" on dispense volume
    And I copy mapping
    And I select row "2" on destination list
    And I paste mapping
    Then list of transfer row "1" display "Column 3" with "25 μL"
    Then list of transfer row "2" display "Column 7" with "25 μL"
    And I finish simple transfer
    
# @RunDummy
#   Scenario: Dummy dum dum
#     Given I navigated to FLO
#     And I login as "ulfa"
#     And I open "96 deepwell and 96 940" protocol
#     And I click "simple transfer" and select "1" as source and "2" destination
#     And I swipe from A1 to A6