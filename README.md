# Das Bankbeispiel
In meinem Seminar „Java Programmierung für Einsteiger“ verwende ich gerne ein
 durchgängiges Beispiel, an dem ich die Konzepte von Java vorführe. Diese 
 Beispiel ist ein Banksystem, das eine Bank mit Kunden und Konten darstellt.
 
Dieses Repository ist als Begleitung zu diesem Seminar gedacht. Es beinhaltet
 die wesentlichen Schritte aus dem Seminar. Die großen Themengebiete habe ich
 in Form von Branches in diesem Seminar angelegt. Die Branches bauen 
 aufeinander auf. Wenn also ein späterer Branch ausgecheckt wird, erhält man
 auch alle vorhergehenden Änderungen.


## Java Dokumentation
Ich habe in diesem Beispiel alle Klassen `javadoc`-konform dokumentiert. 
Damit diese Dokumentation im Quelltext leichter zu lesen ist, verwende ich 
Markdown anstelle von html als Beschreibungssprache. Damit das funktioniert 
wird das [Markdown Doclet](https://github.com/Abnaxos/markdown-doclet) 
benötigt. Dieses kann entsprechend der Anweisungen heruntergeladen und im 
Wurzelverzeichnis des Projektes abgelegt werden. Danach kann man `javadoc` 
folgendermaßen aufrufen:

```
javadoc -encoding utf8 -docencoding utf8 -charset utf8 \
        -link https://docs.oracle.com/javase/8/docs/api/ \
        -doclet ch.raffael.mddoclet.MarkdownDoclet \
        -docletpath /path/to/markdown-doclet-<version>-all.jar
``` 

Die ersten drei `encoding`-Angaben sind notwendig, damit Dateien korrekt 
eingelesen werden, die UTF8-kodiert sind. (Was hoffentlich alle sind!)

Die generierte Dokumentation befindet sich im doc-Ordner des Repositories.

### Dokumentation auf Deutsch
Ich habe mich zugunsten einer leichteren Lesbarkeit für Deutsch als 
Kommentarsprache entschieden. Den meisten Seminarteilnehmern fällt es 
leichter, sich im Code zu orientieren, wenn wenigstens etwas Deutsch 
enthalten ist.

Besserer Stil wäre es sicherlich, die Kommentare auf Englisch zu schreiben.
