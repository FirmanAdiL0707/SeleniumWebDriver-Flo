@runSerialDilution
Feature: Serial Dilution With Stock

  Scenario: FLO-1408:Create Serial Dilution using a single sample
  #Given I navigated to FLO
  And I login as "Firman"
  And I navigated to PROTOCOL EDITOR
  And I Drag "Eppendorf Microplate 96/U" and drop to "AREA2"
  And I Drag "Covid19 Deepwell 96" and drop to "AREA1"
  And I click set stock definition
  Then stock setup popup displayed
  And I click stock definition number 1
  And I multipleclick from "A01" to "A02" on plate 96
  And I click finish button
  And I click "serial dilution" with Stock and source "2" as dilution
  Then serial dilution popup displayed
  And I add diluent with stock number "1" as dilution
  Then Diluent button change become "CHANGE DILUENT"
  And I add sample with stock number "2" as sample
  Then Sample button change become "CHANGE SAMPLE"
  And I click well "A01"
  And I set "5" point along the "Row" with "Right" dilution direction and "10" ratio on setup dilution
  Then point value is "5" along "Row" with "Right" dilution direction and "10" as ratio with stock is "true"
  And I set "5" μl on setup volume
  Then sample volume set as "5" with "Diluent Volume: 45 μL" text appears with stock is "true"
  And I click apply sample volume
  And I click finish on serial dilution
  Then I navigated to stock combination and i create stock

  Scenario: FLO-1407:Create Serial Dilution without stock defined
  #Given I navigated to FLO
  And I login as "Firman"
  And I navigated to PROTOCOL EDITOR
  And I Drag "Covid19 Deepwell 96" and drop to "AREA1"
  And I Drag "Eppendorf Microplate 384/V" and drop to "AREA2"
  And I click "serial dilution" with Stock and source "2" as dilution
  Then stock setup popup displayed
  And I click stock number 1 and click new group
  And I multipleclick from "A01" to "H01" on plate 96
  And I click create group button
  And I multipleclick from "A02" to "B02" on plate 96
  And I click finish button
  And I select labware on "serial dilution" number "2"

  Scenario: FLO-1438:Create Serial Dilution using group of sample (column)
  #Given I navigated to FLO
  And I login as "Firman"
  And I navigated to PROTOCOL EDITOR  
  And I Drag "Eppendorf Microplate 96/U" and drop to "AREA2"
  And I Drag "Covid19 Deepwell 96" and drop to "AREA3"
  And I Drag "ClickBio VBLOK200" and drop to "AREA1"
  And I click set stock definition
  Then stock setup popup displayed
  And I set stock on Stock Definition number 1 and fill "A03"
  And I click set stock definition
  And I click stock number 2 and click new group
  And I multipleclick from "A01" to "H01" on plate 96
  And I click create group stock button
  And I click finish button
  And I click "serial dilution" with Stock and source "3" as dilution
  Then serial dilution popup displayed
  And I add diluent with stock number "1" as dilution
  Then Diluent button change become "CHANGE DILUENT"
  And I add sample with stock group number "1" as sample
  Then Sample button change become "CHANGE SAMPLE"
  And I click well "A01"
  And I set "5" point along the "Row" with "Right" dilution direction and "10" ratio on setup dilution
  Then point value is "5" along "Row" with "Right" dilution direction and "10" as ratio with stock is "true"
  And I set "5" μl on setup volume
  Then sample volume set as "5" with "Diluent Volume: 45 μL" text appears with stock is "true"
  And I click apply sample volume
  And I click finish on serial dilution
  Then I navigated to stock combination and i create stock
 
  Scenario: FLO-1355:Create Instant Serial Dilution using non-group sample (1 well)
  #Given I navigated to FLO
  And I login as "Firman"
  And I navigated to PROTOCOL EDITOR
  And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
  And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
  And I Drag "Eppendorf Microplate 384/V" and drop to "AREA3"
  And I select serial dilution without stock
  And I select labware on "serial dilution" number "1"
  And I select labware on "serial dilution" number "2"
  And I select labware on "serial dilution" number "3"
  Then serial dilution popup displayed
  And I click diluent plate and fill well on "A01"
  Then Validate that Diluent selected
  And I click sample plate and fill well on "A01"
  Then Validate that Sample selected
  And I click arrow button to change focus of plate
  And I click the well "A01" on 384 plate
  And I set "4" point along the "Row" with "Right" dilution direction and "10" ratio on setup dilution without stock
  Then point value is "4" along "Row" with "Right" dilution direction and "10" as ratio with stock is "false"
  And I set "5" μl on setup volume without stock
  Then sample volume set as "5" with "Diluent Volume: 45 μL" text appears with stock is "false"
  And I click apply sample volume without stock
  And I click finish on serial dilution
  
  Scenario: FLO-1345:Create Instant Serial Dilution using group of sample (column)
  #Given I navigated to FLO
  And I login as "Firman"
  And I navigated to PROTOCOL EDITOR
  And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
  And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
  And I Drag "Eppendorf Microplate 384/V" and drop to "AREA3"
  And I select serial dilution without stock
  And I select labware on "serial dilution" number "1"
  And I select labware on "serial dilution" number "2"
  And I select labware on "serial dilution" number "3"
  Then serial dilution popup displayed
  And I click diluent plate and click column group on "A01"
  Then Validate that Diluent selected
  And I click sample plate and click column group on "A01"
  Then Validate that Sample selected
  And I click arrow button to change focus of plate
  And I click the well "A01" on 384 plate
  And I set "4" point along the "Row" with "Right" dilution direction and "10" ratio on setup dilution without stock
  Then point value is "4" along "Row" with "Right" dilution direction and "10" as ratio with stock is "false"
  And I set "5" μl on setup volume without stock
  Then sample volume set as "5" with "Diluent Volume: 45 μL" text appears with stock is "false"
  And I click apply sample volume without stock
  And I click finish on serial dilution

  Scenario: FLO-1350:Change the dispense pattern that already mapped
  #Given I navigated to FLO
  And I login as "Firman"
  And I navigated to PROTOCOL EDITOR
  And I Drag "Eppendorf Microplate 96/U" and drop to "AREA1"
  And I Drag "Covid19 Deepwell 96" and drop to "AREA2"
  And I Drag "Brand Assay 384 120ul" and drop to "AREA3"
  And I select serial dilution without stock
  And I select labware on "serial dilution" number "1"
  And I select labware on "serial dilution" number "2"
  And I select labware on "serial dilution" number "3"
  Then serial dilution popup displayed
  And I click diluent plate and fill well on "A01"
  And I click sample plate and click column group on "A01"
  And I click arrow button to change focus of plate
  And I click the well "A01" on 384 plate
  And I select dispense pattern number "3"
  And I set "4" point along the "Quadrant" with "Clockwise" dilution direction and "10" ratio on setup dilution without stock
  Then point value is "4" along "Quadrant" with "Clockwise" dilution direction and "10" as ratio with stock is "false"
  And I set "5" μl on setup volume without stock
  Then sample volume set as "5" with "Diluent Volume: 45 μL" text appears with stock is "false"
  And I click apply sample volume without stock
  And I select dispense pattern number "2"
  Then Update dispense pattern popup displayed
  And I click Yes button on update dispense pattern
  And I click finish on serial dilution