# EP2 Aufgabenblatt 1

Kernthemen: Objekt- vs. Klassen-Methode, Abstrakter Datentyp, Datenkapselung

## Organisatorisches

Abgabe Deadline: 10.3.2026, 13:00h<br>
Art der Abgabe: `git commit` & `git push`<br>
Die Abgabe von AB1.1 ist optional, aber dringend empfohlen.

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Importieren Sie keine zusätzlichen Pakete und Klassen. Ausnahme ist der Import vom Paket `CodeDraw`, 
  wenn Sie es nutzen wollen.
* Achten Sie darauf, dass Sie ein `git commit` immer nur dann ausführen, wenn Ihr Projekt 
  in einem kompilierbaren Zustand ist.

## Information zur Domäne

### Zweidimensionale Vektoren

In der gegebenen Anwendung [ApplicationVector2D.java](../src/ApplicationVector2D.java) werden zweidimensionale Vektoren 
als `double[2]`-Arrays repräsentiert. Dieses Vorgehen ist zwar funktional, hat aber den Nachteil, dass Koordinaten und 
darauf ausgeführte Operationen nicht gekapselt sind.

Ziel dieser Aufgabe ist es, die Vektorlogik in eine eigene Klasse `Vector2D` überzuführen. Dabei sollen die Koordinaten
(intern) gekapselt und alle Operationen als Objektmethoden implementiert werden.

### Bewegte Objekte im Raum

Aufbauend auf der Vektorimplementierung soll ein einfaches Bewegungsmodell entworfen werden. Ein Vogel (`Bird`)
besitzt eine Position im zweidimensionalen Raum sowie einen Geschwindigkeitsvektor. Vögel können ihre Flugrichtung und
Geschwindigkeit selbst steuern und sollen nahen Objekten ausweichen, um einen Mindestabstand einzuhalten.

---

## Aufgabenstellung

Für diese Aufgabe ist eine Anwendung zu entwickeln, die zunächst zweidimensionale Vektoren als Klasse nutzt und darauf 
aufbauend eine einfache Simulation mehrerer bewegter Objekte (Vögel) demonstriert.

Dazu ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie den Kommentaren im Quellcode anzupassen und
gegebenenfalls zu vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit `@TODO` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [Vector2D.java](../src/Vector2D.java)
* [Bird.java](../src/Bird.java)
* [ApplicationVector2D.java](../src/ApplicationVector2D.java)
* [ApplicationBird.java](../src/ApplicationBird.java)

Die letzten beiden angeführten Klassen sind ausführbar, also Einstiegspunkte in die Anwendungslogik. 

Die Klasse [ApplicationVector2D.java](../src/ApplicationVector2D.java) ist für die Teilaufgabe 1 und 2 relevant. 
In der Methode `ApplicationVector2D.main` sind alle notwendigen Objekte zu erzeugen und aufzurufen, um die Funktionsweise 
der Klasse `Vector2D` zu demonstrieren.

Die Klasse [ApplicationBird.java](../src/ApplicationBird.java) ist für die Teilaufgabe 3 und 4 relevant.

---

### Teilaufgabe 1 – Klasse `Vector2D`

Implementieren Sie die Klasse [Vector2D](../src/Vector2D.java), die zweidimensionale Vektoren kapselt.

#### Anforderungen

* Speichern Sie die Koordinaten als **Objektvariablen**.
* Implementieren Sie alle Vektoroperationen als **Objektmethoden** (keine `static`-Methoden).
  Operationen auf Vektoren werden ausschließlich durch Aufruf der Objektmethoden durchgeführt.
  Beispiel: 
  ```
     Vector2D p1 = new Vector2D();
     p1.newCoordinates(100, 200);
     p1.normalize();
     ...
     Vector2D sum = p1.add(p2);
  ```
* Die Objektmethoden `newCoordinates`, `scale` und `normalize` sollen `void`-Methoden sein und 
  das aktuelle Objekt modifizieren.
* Die anderen Objektmethoden haben eine Rückgabe und lassen das aktuelle Objekt unverändert.
* Die Klasse soll mindestens folgende Funktionalitäten bereitstellen:
    * Addition zweier Vektoren
    * Distanzberechnung: Berechnung des Euklidschen Abstands zwischen zwei (Orts)vektoren
    * Skalierung: Multiplikation mit (skalarem) Faktor
    * Normierung: den Vektor auf die Länge 1 skalieren
    * Nullvektor-Test
    * Den Vektor als Koordinaten-Array der Form double[] liefern (Objektmethode `toArray`)

---

### Teilaufgabe 2 – Umbau von `ApplicationVector2D`

Passen Sie die Klasse [ApplicationVector2D](../src/Application.java) so an, dass:

* keine `double[]`-Arrays mehr verwendet werden und ausschließlich `Vector2D`-Objekte genutzt werden (Ausnahme:
  Implementieren und Test von `toArray`)
* anstelle der statischen Methoden (mit Ausnahme von `main`) nur noch Objektmethoden aufgerufen werden
* das Programm weiterhin dieselben Rechenoperationen wie zuvor demonstriert

Sie dürfen in [ApplicationVector2D](../src/ApplicationVector2D.java) zusätzliche Testfälle und Ausgaben ergänzen.

---

### Teilaufgabe 3 – Klasse `Bird`

In dieser Aufgabe ist es nicht notwendig, eine vollständige Implementierung zu erreichen. Es geht darum, sich zu 
überlegen, wie ein geeigneter Klassenentwurf aussehen könnte. Es gibt viele mögliche Entwürfe, die die folgenden
groben Rahmenbedingungen erfüllen. Sie können die Simulation aber natürlich auch vollständig nach Ihrer 
Spezifikation implementieren.

#### Anforderungen
Spezifizieren Sie die Klasse [Bird](../src/Bird.java).

Ein Vogel besitzt:

* eine zweidimensionale Position (`Vector2D`)
* einen Geschwindigkeitsvektor (`Vector2D`)
* je nach Entwurf eventuell weitere Objektvariablen

Ein Vogel soll mindestens:

1. seine Position entsprechend seines internen Geschwindigkeitsvektors aktualisieren können,
2. seine Flugrichtung ändern können,
3. auf die Nähe eines anderen Vogels reagieren können.

Wie genau das Verhalten umgesetzt wird, ist von Ihnen zu entscheiden. Es gibt mehrere sinnvolle Modellierungsansätze,
die jeweils unterschiedliche Entwurfsentscheidungen widerspiegeln.
Überlegen Sie sich, welche öffentlichen Methoden die Klasse [Bird](../src/Bird.java) haben sollte.
Schreiben Sie eine Spezifikation der Methoden, die ausreicht, um die Klasse Bird richtig anwenden zu können. Die 
angebotenen Methoden sollen logisch zusammenpassen. Von außen soll nicht direkt auf interne Daten zugegriffen werden.

#### Datenabstraktion

Überlegen Sie sich eine geeignete Datenabstraktion:

- Welche Operationen sollen von außen aufrufbar sein?
- Was muss man von außen betrachtet über diese Operationen wissen?
- Welche Details sollen verborgen bleiben?
- Was gehört zum internen Zustand des Vogels? Welche Objektvariablen benötigt ein Vogel?

#### Hinweise zur Ausgestaltung

Es ist nicht erforderlich, physikalisch korrekte Bewegungen zu modellieren.

Beispiele:

- Bei zu geringem Abstand wird die Richtung um 90° im Uhrzeigersinn gedreht.
- Bei zu geringem Abstand wird ein Ausweichvektor berechnet.
- Die Richtung wird zufällig verändert.
- Ein Vogel kann nicht nur die Richtung, sondern auch seine Geschwindigkeit ändern.
- Die Geschwindigkeit bleibt betragsmäßig konstant, nur die Richtung ändert sich.

Die Klasse `Bird` soll so beschrieben sein, dass ihre Verwendung ohne Kenntnis der internen Implementierung möglich ist.

---

### Teilaufgabe 4 – Simulation in `ApplicationBird`

Erstellen Sie am Ende der Implementierung von `main` in der Klasse
[ApplicationBird](../src/ApplicationBird.java) eine kleine Simulation, z. B. mit zwei oder mehr Vögeln. In diesem 
Programm sollen Sie demonstrieren, wie die Methoden von [Bird](../src/Bird.java) richtig benutzt werden. Falls Sie in 
[Bird](../src/Bird.java) die Methodendeklarationen inklusive der Spezifikation vervollständigt haben, sollte sich das Programm 
übersetzen lassen und zwar unabhängig davon, ob die Implementierung fehlt oder vollständig ist. 
Falls sich das Programm nicht übersetzen lässt, schreiben Sie die Simulation als auskommentierten Codeblock.

Beispiel:

```
Bird b1 = new Bird();
Bird b2 = new Bird();

Vector2D p1 = new Vector2D();
p1.newCoordinates(100, 200);

Vector2D vStart1 = new Vector2D();
vStart1.newCoordinates(2, 1);

Vector2D p2 = new Vector2D();
p2.newCoordinates(400, 150);

Vector2D vStart2 = new Vector2D();
vStart2.newCoordinates(-2, 2.2);

b1.startFlying(p1, vStart1, 40.0);
b2.startFlying(p2, vStart2, 40.0);

CodeDraw cd = new CodeDraw(600, 400);

for (int i = 0; i < 100; i++) {

    // perceive and avoid too close neighbors
    b1.avoid(b2);
    b2.avoid(b1);

    // move one tick (one second)
    b1.update();
    b2.update();

    // clear background
    cd.clear();

    // draw birds
    cd.setColor(Color.BLUE);
    b1.draw(cd);

    cd.setColor(Color.RED);
    b2.draw(cd);

    cd.show(20);
}
```

Falls Sie das Programm vollständig implementieren möchten, folgt noch ein Hinweis zur Verwendung von `CodeDraw`.
Sie müssen `CodeDraw` aber nicht nutzen, Sie können auch nur mit Ausgaben in der Konsole arbeiten.

Für die grafische Darstellung können Sie in der Klasse `Bird`
beispielsweise eine Methode

```java
public void draw(CodeDraw cd) {
    double[] p = position.toArray();
    cd.fillCircle(p[0], p[1], 5);
}
```

implementieren, die den Vogel als Kreis darstellt.
Die aktuelle Position des Vogels kann dabei aus dem gespeicherten
`Vector2D`-Objekt entnommen werden.

Die Bewegungsrichtung kann zusätzlich durch eine kurze Linie angedeutet werden.
Die konkrete Darstellung bleibt Ihnen überlassen.
