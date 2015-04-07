Feature: Neue Bar hinzufügen
  Nutzer fügt der Datenbank eine neue Bar hinzu
  
  Scenario: Nutzer gibt Daten korrekt ein
    Given: Nutzer ist in der Bar-hinzufügen-Ebene
    When: Nutzer gibt "Name" ein
    And: Nutzer gibt "Adresse" ein
    And: Nutzer gibt "Ort" ein
    And: Nutzer gibt "PLZ" ein
    And: Nutzer gibt "Musikstil" ein
    And: Nutzer gibt "Website" ein
    And: Nutzer lädt "Bild" hoch
    And: Nutzer gibt "Öffnunszeiten" ein
    And: drückt Button "Bar eintragen"
    Then: Bar wird an Datenbank übermittelt
    And: Nacricht "Bar wurde erfolgreich eingetragen" angezeigt
    And: Weiterleitung zur Startseite
  
  Scenario: Name vergessen
    Given: Nutzer ist in der Bar-hinzufügen-Ebene
    When: Nutzer gibt keinen "Name" ein
    And: Nutzer gibt "Adresse" ein
    And: Nutzer gibt "Ort" ein
    And: Nutzer gibt "PLZ" ein
    And: Nutzer gibt "Musikstil" ein
    And: Nutzer gibt "Website" ein
    And: Nutzer lädt "Bild" hoch
    And: Nutzer gibt "Öffnunszeiten" ein
    And: drückt Button "Bar eintragen"
    Then: Error "Bitte Name eintragen"
    
  Scenario: Adresse nicht eingetragen
    Given: Nutzer ist in der Bar-hinzufügen-Ebene
    When: Nutzer gibt "Name" ein
    And: Nutzer gibt keine "Adresse" ein
    And: Nutzer gibt keine "Ort" ein
    And: Nutzer gibt keine "PLZ" ein
    And: Nutzer gibt "Musikstil" ein
    And: Nutzer gibt "Website" ein
    And: Nutzer lädt "Bild" hoch
    And: Nutzer gibt "Öffnunszeiten" ein
    And: drückt Button "Bar eintragen"
    Then: Error "Gib eine volständige Adresse ein"
