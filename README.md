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

### Checkstyle-raportin generointi

``./gradlew run``

Ohjelma generoi ohjelman käynnistyksen yhteydessä Checkstyle-raportit, jotka löydät kansiosta ./build/reports/checkstyle

### Jacoco testikattavuusraportin generointi

``./gradlew test jacocoTestReport``

Komento generoi Jacocon html-raportin kansioon ./build/reports/jacoco/html

### Javadocin generointi

``./gradlew javadoc``

Komento generoi javadoc-dokumentaation html-version kansioon ./build/docs/javadoc

### Jarin generointi

``./gradlew jar``

Komento generoi tiedoston compare-pathfinders.jar kansioon ./build/libs/ . Kopioi repositorion juuresta kansio static/ jar-tiedoston sijaintikansioon, jotta ohjelma saa haettua sieltä tarvitsemansa karttatiedoston.