# Einführung agiler Methoden im Bereich des Projektmanagements

* Respository for: WIB Auswahl und Anpassung von IT-Diensten
* Team: Anna-Maria Schade, Amadeus Wiemann, Maximillian Bülow, Daniel Clausen, Felix Zdrenka

Diese Readme dient der Erläuterung der Funktionsweise und der technischen Umsetzung unseres BPMN-Prozesses.
Dieser dient der (Teil-)Automatisierung des Erstellen von Nutzer-Accounts in Atlassian Jira.

# der Anfang

Zu erst haben wir versucht die Camunder Engine auf einen Laptop zu installieren und unseren Prozess zu implementieren.
Dies gestalltete sich als äußerst schwierig, da wir massive technsiche Probleme mein Starten des Models über die Tasklist hatten.
Nach einer konsultation, welche uns nicht helfen konnte, haben wir versucht die Engine auf den Laptop eines andern Kollegen zu installieren.
Dies funktionierte komischerweise, leider hatten wir zu diesem zeitpunkt bereits die meiste Zeit mit dem Beheben des Fehlers verschwendet.
Dadruch waren wir unter Zeitdruck gezwungen schnellstmöglich unseren Prozess zu implementieren.

# Der Prozess

* Zu erst geht die Anfrage eines, möglicherweise, neuen Mitarbeiters ein.
* Darauf hin wird der zuständige Personaler, die Anfrageannehmen.
* Danach wird ein Profil, anhand der übermittelten Infos aus der Anfrage, erstellt.
* Nach der Profil-Erstellung, werden die Anforderungen mit den Angaben des Nutzers überprüft.
* Daraufhin wird das erstellte Profil von Projektleiter überprüft und ggf. genehmigt.
* Nach Abschluss der genehmigung, wird eine entsprechende Rolle vergeben.
* Schlussendlich wird der User über seine Rechte informiert und intregriert.

# Die Implementierung

Zu Beginn der Implementierung des Prozesses in der Camunda Engine stand  der Entwurf eines Prozesses und einer DMN-Table.

Zunächst versuchten wir, die Implementierung mithilfe des Maven archetype camunda-archetype-servlet-war umzusetzen.
Die 3 Eingabewerte konnten hierbei im zweiten Usertask mithilfe einer händisch geschriebenen HTML-Form eingegeben werden.
Dieser erste Versuch scheiterte jedoch an der Übergabe der Variablen an den Business Rule Task, hierbei warf Camunda den Fehler 
"FEEL-01017: Unable to evaluate expression". Wir haben ca. 5 Stunden lang versucht diesen Fehler zu beheben, jedoch ohne Erfolg.
Daraufhin haben wir den ersten Versuch verworfen und nochmal von vorn angefangen.

Um schneller voranzukommen und Zeit zu sparen, entschieden wir uns diesmal dafür, die Implementierung hauptsächlich über den Camunda Modeler vorzunehmen, anstatt in Eclipse über das war-servlet. Zudem verzichteten wir auf die händisch geschriebenen HTML-Forms, das Einfügen von Forms über den Camunda Modeler erwies sich als leichter und weniger fehleranfällig.

Der zweite Versuch verlief zunächst erfolgreicher, die Übergabe von Inputs an den Business Rule Task lief erfolgreich, denn wir erhielten zum ersten Mal einen Output aus unserer DMN-Table.
Statt mit Java Delegate und Maven weiter zu verzweifeln, haben wir zwei Klassen und einen Worker erstellt, welche dazu verwendet werden den Wert der Send-Message-Task abzufangen und auszugeben.
Dann wollten wir einen E-Mail-Client der die Nachricht an den Projektleiter empfängt und die Rückmeldung versendet implementieren.

Als die Zeit weiter knapp wurde, haben wir gemerkt wie unintuitiv die Engine ist, da wir wiederholt mit Problemen konfrontiert wurden.
Die Dokumentation wird kurz erwähnt, dass die Impelemntierung mittels JavaScript / NodeJS unterstützt wird, dennoch wird schnell klar, dass kaum Informationen dazu zu finden sind.
Daher mussten wir komplett auf Java umsteigen.
Bei der Implementierung des User Task wurde klar wir müssen hier irgendwelche Forms erstellen, doch wie ?
Warum müssen wir sowas handisch Erstellen und irgendwo in einem Verzeichnis ablegen? Es funktionierte, aber warum so umständlich?
Dann haben wir erfahren es geht auch einfach über das Property Panel im Camunda Modeler, dennoch wird der umständliche Weg in der Doku erwähnt, im gegensatz zum einfachen.
So lief es die ganze Zeit. Fehler über Fehler und umständliche Handhabung. Leider haben wir es nicht geschaft in dem Durcheinander eine ordentliche Implementierung durchzuführen.
