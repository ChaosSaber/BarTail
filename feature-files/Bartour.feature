Feature: Bartour
  Nutzer wählt Bars für eine Tour aus und kann diese starten
  
  
  Scenario: Nutzer fügt eine Bar hinzu
    Given: Nutzer ist in der Bartour-Ebene
    When: Nutzer wählt "+Bar hinzufügen" aus
    Then: Nutzer gelangt in die "Barsuche"
    
  Scenario: Nutzer will Tour starten aber hat keine Bar ausgewählt
    Given: Nutzer ist in Bartour-Ebene
    And: Nutzer hat keine Bar hinzugefügt
    When: Nutzer wählt "Bartour" starten
    Then: Error "Bitte Bar hinzufügen"
    
  Scenario: Nutzer will Tour starten und hat mindestens eine Bar ausgewählt
    Given: Nutzer ist in Bartour-Ebene
    And: Nutzer hat mindestens eine Bar hinzugefügt
    When: Nutzer wählt "Bartour" starten
    Then: Navigation startet
