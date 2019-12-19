# Compare Pathfinders - Polkualgoritmien vertailusovellus

[![CircleCI](https://circleci.com/gh/jsalojuuri/compare-pathfinders.svg?style=svg)](https://circleci.com/gh/jsalojuuri/compare-pathfinders)
[![codecov](https://codecov.io/gh/jsalojuuri/compare-pathfinders/branch/master/graph/badge.svg)](https://codecov.io/gh/jsalojuuri/compare-pathfinders)


Compare Pathfinders sovelluksella voi vertailla neljää *Javalla* toteutettua polkualgoritmia kaksiulotteisella ASCII-kartalla. Lue tarkemmin vertailtavista algoritmeista [määrittelydokumentista](./documentation/definition.md).

## Viikkoraportit

* [Viikko 1](./documentation/reports/weeklyreport1.md)
* [Viikko 2](./documentation/reports/weeklyreport2.md)
* [Viikko 3](./documentation/reports/weeklyreport3.md)
* [Viikko 4](./documentation/reports/weeklyreport4.md)
* [Viikko 5](./documentation/reports/weeklyreport5.md)
* [Viikko 6](./documentation/reports/weeklyreport6.md)
* [Viikko 7 ja yhteenveto projektin ajankäytöstä](./documentation/reports/weeklyreport7.md)

## Dokumentaatio

* [Määrittelydokumentti](./documentation/definition.md)
* [Asennusohje](./documentation/installation.md)
* [Käyttöohje](./documentation/manual.md)
* [Toteutusdokumentti](./documentation/implementation.md)
* [Testausdokumentti](./documentation/testing.md)
* [Javadoc](./documentation/javadoc/)

## Julkaisut

* [Julkaisu v1.0](https://github.com/jsalojuuri/compare-pathfinders/releases/tag/v1.0)

## Komentorivitoiminnot

### Ohjelman käynnistys

``./gradlew run``

Ohjelma ajaa käynnistyksen yhteydessä Checkstyle-raportit, jotka löydät build-kansion alta.

### Junit-testien ajo

``./gradlew test``

### Jacoco-testikattavuus raportin ajo

``./gradlew test jacocoTestReport``

### Javadocin generointi

``./gradlew javadoc``

### Jarin generointi

``./gradlew jar``