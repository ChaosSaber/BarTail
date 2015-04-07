Feature: Bar-Bewertung
  Nutzer gibt eine Bewertung  für eine Bar ein.
  
  Scenario: Nutzer gibt Kriterien an
    Given: Nutzer ist in der Bewertungs-Ebene
    And: Nutzer bewertet "Preis"
    And: Nutzer bewertet "Einrichtung"
    And: Nutzer bewertet "Service"
    And: Nutzer bewertet "Gesamt"
    And: Nutzer schreibt "Kommentar"
    When: Benutzer klickt "Abschicken"
    Then: Daten werden der Datenbank übermittelt
    And: Freigelassene Werden nicht übertragen
    And: Wird angezeigt "Bewertung erfolgreich"
