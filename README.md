# Einführung agiler Methoden im Bereich des Projektmanagements

* Respository for: WIB Auswahl und Anpassung von IT-Diensten
* Team: Anna-Maria Schade, Amadeus Wiemann, Maximillian Bülow, Daniel Clausen, Felix Zdrenka

Diese Readme dient der Erläuterung der Funktionsweise und der technischen Umsetzung unseres BPMN-Prozesses.
Dieser dient der (Teil-)Automatisierung des Erstellen von Nutzer-Accounts in Atlassian Jira.

Im folgenden 

Zu Beginn der Implementierung des Prozesses in der Camunda Engine stand  der Entwurf eines Prozesses und einer DMN-Table.

Zunächst versuchten wir, die Implementierung mithilfe des Maven archetype camunda-archetype-servlet-war umzusetzen.
Die 3 Eingabewerte konnten hierbei im zweiten Usertask mithilfe einer händisch geschriebenen HTML-Form eingegeben werden.
Dieser erste Versuch scheiterte jedoch an der Übergabe der Variablen an den Business Rule Task, hierbei warf Camunda den Fehler 
"FEEL-01017: Unable to evaluate expression". Wir haben ca. 5 Stunden lang versucht diesen Fehler zu beheben, jedoch ohne Erfolg.
Daraufhin haben wir den ersten Versuch verworfen und nochmal von vorn angefangen.

Um schneller voranzukommen und Zeit zu sparen, entschieden wir uns diesmal dafür, die Implementierung hauptsächlich über den Camunda Modeler vorzunehmen, anstatt in Eclipse über das war-servlet. Zudem verzichteten wir auf die händisch geschriebenen HTML-Forms, das Einfügen von Forms über den Camunda Modeler erwies sich als leichter und weniger fehleranfällig.

Der zweite Versuch verlief zunächst erfolgreicher, die Übergabe von Inputs an den Business Rule Task lief erfolgreich, denn wir erhielten zum ersten Mal einen Output aus unserer DMN-Table.
