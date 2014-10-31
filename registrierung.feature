Feature: Nutzer registriert sich
	Neue Nutzer müssen sich registrieren um die Anwendung zu nutzen
	
	Scenario: Nutzer gibt richtige Anmeldeinformationen ein und diese existieren noch nicht im System
		Given Nutzer möchte sich registrieren
		When Nutzer gibt "Nutzername" ein
		And Nutzer gibt "E-Mail" ein
		And Nutzer gibt "Passwort" ein
		And Nutzer gibt "Passwortwiederholung" ein
		Then Eine Nachricht erscheint "Registrierung erfolgreich"
		And Nutzer wird zur Login-Seite weitergeleitet

	Scenario: Nutzername existiert bereits
		Given Nutzer möchte sich registrieren
		When Nutzer gibt "Nutzername" ein
		And Nutzer gibt "E-Mail" ein
		And Nutzer gibt "Passwort" ein
		And Nutzer gibt "Passwortwiederholung" ein
		And Nutzer drückt den "Registrieren Button"
		Then Eine Nachricht erscheint "Nutzername ist bereits vergeben"
		And Nutzer wird gebeten die Daten neu einzugeben
		
	Scenario: E-Mail ist bereits registriert
		Given Nutzer möchte sich registrieren
		When Nutzer gibt "Nutzername" ein
		And Nutzer gibt "E-Mail" ein
		And Nutzer gibt "Passwort" ein
		And Nutzer gibt "Passwortwiederholung" ein
		And Nutzer drückt den "Registrieren Button"
		Then Eine Nachricht erscheint "E-Mail Adresse wird bereits verwendet"
		And Nutzer wird gefragt ob er sich anmelden möchte oder die Registrierung erneut versuchen möchte
	
	Scenario: Passwortwiederholung falsch
		Given Nutzer möchte sich registrieren
		When Nutzer gibt "Nutzername" ein
		And Nutzer gibt "E-Mail" ein
		And Nutzer gibt "Passwort" ein
		And Nutzer gibt "Passwortwiederholung" ein
		And Nutzer drückt den "Registrieren Button"
		Then Eine Nachricht erscheint "Passwortwiederholung falsch"
		And Nutzer wird gebeten die Daten erneut einzugeben
		
	Scenario: Passwort enspricht nicht den Kriterien
		Given Nutzer möchte sich registrieren
		When Nutzer gibt "Nutzername" ein
		And Nutzer gibt "E-Mail" ein
		And Nutzer gibt "Passwort" ein
		And Nutzer gibt "Passwortwiederholung" ein
		And Nutzer drückt den "Registrieren Button"
		Then Eine Nachricht erscheint "Passwort entspricht nicht den Kriterien. Passwort muss zwischen 6 und 20 Zeichen lang sein und mindestens jeweils einen Klein-/Großbuchstaben und eine Zahl enthalten"
		And Nutzer wird gebeten die Daten erneut einzugeben
		
