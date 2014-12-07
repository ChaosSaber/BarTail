Feature: Barsuche
	Nutzer gibt einige Kriterien ein und die Anwendung durchsucht die Datenbank nach passenden Ergebnissen
	
	Scenario: Nutzer gibt alle Kriterien korrekt ein
		Given Nutzer ist in der Barsuch-Ebene
		When Nutzer gibt "Barname" ein
		And Nutzer gibt "Entfernung" ein
		And Nutzer gibt "Preisspanne" ein
		And Nutzer gibt "Öffnungszeiten" ein
		And Nuter wählt "Musikrichtung"
		Then Daten werden mit Datenbank abgeglichen
		And Nutzer wird zur "Ergebnisseite" weiter geleitet
		
	Scenario: Nutzer gibt bei Preisspanne keine Gültige Zahl ein
		Given Nutzer ist in der Barsuch-Ebene
		When Nutzer gibt "Barname" ein
		And Nutzer gibt "Entfernung" ein
		And Nutzer gibt "Preisspanne" ein
		And Nutzer gibt "Öffnungszeiten" ein
		And Nuter wählt "Musikrichtung"
		Then Eine Nachricht erscheint "Bitte geben sie eine Zahl bei Preisspanne en"
		And Nuzer wird gebeten die Daten neu einzugeben
		
	Scenario: Nutzer gibt keien gültige Uhrzeit ein
		Given Nutzer ist in der Barsuch-Ebene
		When Nutzer gibt "Barname" ein
		And Nutzer gibt "Entfernung" ein
		And Nutzer gibt "Preisspanne" ein
		And Nutzer gibt "Öffnungszeiten" ein
		And Nuter wählt "Musikrichtung"
		Then Eine Nachricht erscheint "Bitte geben sie eine gültige Uhrzeit ein"
		And Nutzer wird gebeten die Daten neu einzugeben
