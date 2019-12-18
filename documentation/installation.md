# Asennusohje

1. Kloonaa repositorio koneellesi komennolla ``git clone git@github.com:jsalojuuri/compare-pathfinders.git`` tai lataa [.zip-tiedosto](https://github.com/jsalojuuri/compare-pathfinders/archive/master.zip)
2. Sovellus on toteutettu Javan versiolla 11.0.4. Voit tarvittaessa ladata Javan [täältä](https://www.java.com/en/download/).

## Ohjelman käynnistäminen komentoriviltä

3. Sovelluksen build-ohjelmistona on käytetty Gradlen versiota 5.6. Lue Gradlen käyttöönotosta tarkemmin [täältä](https://gradle.org/install/).
4. Ohjelmaa ei tarvitse erikseen kääntää, vaan sen voi käynnistää suoraan komentoriviltä komennolla ``./gradlew run``. Gradle ensin kääntää lähdekoodin binäärimuotoon, jonka jälkeen näet ruudulla ohjelman käyttöliittymän.