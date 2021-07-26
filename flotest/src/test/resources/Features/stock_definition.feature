
Feature: Stock definition
@delete3 

  Scenario: FLO-1848	Combination using destination well in instant transfer
    Given I navigated to FLO
    And I login as "ulfa"
    And I open "384 only" protocol
    And I click "simple transfer" and select "1" as source and "1" destination
    And I select "A01" well on 384 plate on simple transfer source
    And I click destination labware
    And I select "A05" well on 384 plate on simple transfer destination
    And I apply "100" with unit "μL" on dispense volume
    And I finish simple transfer
    And I click experiment designer and select "1" as destination
    And I select stock "1"
    And I select "A05" well on experiment designer
    And I apply "20" with unit "μL" on experiment designer dispense volume and "Overflow warning. Volume exceeds the well capacity (120/40 μL)." displayed
    And I add stock on experiment designer
    And I select stock "2"
    And I select "A05" well on experiment designer
    And I apply " " with unit "μL" on experiment designer dispense volume and "Overflow warning. Volume exceeds the well capacity (140/40 μL)." displayed
    And I unselect stock "2"
    And I finish experiment designer
    Then Create New Stock Combinations displayed with "20 μL" and "20 μL" volume
    And I create Stock
    And I click experiment designer and select "1" as destination
    Then stock 1 Stock 2 and Combination of 2 Ingredients listed on the source list
    And I select stock "Combination of 2 Ingredients"
    And I select "A07" well on experiment designer
    And I apply "100" with unit "μL" on experiment designer dispense volume and "Overflow warning. Volume exceeds the well capacity (100/40 μL). Insufficient source volume, available volume is (40 μL)." displayed
    Then the volume is written inside the stock mapped
    And I finish experiment designer
@delete2 @runsd
  Scenario: FLO-1851	Instant transfer using combination well as source
    Given I navigated to FLO
    And I login as "ulfa"
    And I open "384 only" protocol
    And I click experiment designer and select "1" as destination
    And I select stock "1"
    And I select "A01" well on experiment designer
    And I apply "100" with unit "μL" on experiment designer dispense volume and "Overflow warning. Volume exceeds the well capacity (100/40 μL)." displayed
    And I add stock on experiment designer
    And I select stock "2"
    And I select "A01" well on experiment designer
    And I apply " " with unit "μL" on experiment designer dispense volume and "Overflow warning. Volume exceeds the well capacity (200/40 μL)." displayed
    And I finish experiment designer
    Then Create New Stock Combinations displayed with "100 μL" and "100 μL" volume
    And I create Stock
    And I click "simple transfer" and select "1" as source and "1" destination
    And I select "A01" well on 384 plate on simple transfer source
    And I click destination labware
    And I select "A05" well on 384 plate on simple transfer destination
    And I apply "300" with unit "μL" on simple transfer dispense volume and "Overflow warning. Volume exceeds the well capacity (300/40 μL)." displayed
    And I finish simple transfer
    And I run protocol
    And I click stock info
    Then "B1" well displayed volume "105 μL" and "100 μL"
    Then "The required source is exceeds the well capacity." warning displayed on initial stock
    Then "B2" well displayed volume "105 μL" and "100 μL"
    Then "The required source is exceeds the well capacity." warning displayed on initial stock
    And I back to protocol editor page