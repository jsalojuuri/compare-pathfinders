# Viikkoraportti 2

Ajankäyttö viikon aikana: 6 tuntia

Viikon aikana tehdyt asiat:
* Koodauksen aloitus
* Dokumentaation korjailua
* Tutustuminen [2D Ascii-karttoihin](https://movingai.com/benchmarks/grids.html)

Ohjelman edistyminen:
* Perustettu Gradle-projekti, jossa toistaiseksi hyvin simppeli tekstikäyttöliittymä, jolla saa printattua yhden esivalitun ASCII-kartan testausmielessä. Lisätty myös ensimmäinen jUnit-testi MapGraph luokalle.

Mitä opin viikon aikana:
* Kertaamaan Javan tiedostolukuominaisuuksia
* Säätämään build.gradle tiedostoa, kun alkoi tulemaan omituisia virheilmoituksia, mutta niistäkin selvittiin määrittämällä standarisyötteeksi näppäimistöltä tulevan syötteen 

Epäselvät ja vaikeuksia tuottaneet asiat:
* Gradlen konffaaminen on tuottanut vaikeuksia, tosin siitä on hyötyä että käy samanaikaisesti Ohjelmistotuotannon kurssia, jossa opetellaan tätäkin asiaa
* En saa tuotettua Jacoco-raporttia jostain syystä, lieneekö syynä ed. mainittu gradle.build? Komentorivillä ``gradle test jacocoTestReport`` tuottaa virheen, jota en ymmärrä.