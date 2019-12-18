# Toteutusdokumentti

## Ohjelman yleisrakenne

* Ohjelmasta löytyy viisi pakettia:
    * **copa.main** pääohjelma
    * **copa.algorithm** sisältää luokat kaikille algoritmeille ja Comparato-luokat niitä tarvitseville algoritmeille
    * **copa.mapgraph** sisältää luokan MapGraph, jossa mm. metodit ASCII-kartan muuntamiseksi verkoksi ja kartan piirtämiseksi näytölle. Lisäksi luokka Node kartan solmuja varten.
    * **copa.ui** Käyttöliittymän vaatimat luokat. Jo luodun yksinkertaisen tekstikäyttöliittymän lisäksi ei ole aikomusta luoda muunlaisia käyttöliittymiä.
    * **copa.util** sisältää Javan java.util paketin toteutuksia korvaavia luokkia, kuten PriorityQueue ja ArrayList.

## Saavutetut aika- ja tilavaativuudet

(tulossa myöhemmin)

## Algoritmien suorituskykyvertailu ja O-analyysivertailu

Algoritmeja vertaillaan kahdella metriikalla:
* **Polun kustannus**: Algoritmin löytämän polun kokonaiskustannus. Tavallisesta ruudusta kertyy yksi kustannuspiste, puun sisältävästä ruudusta 5 pistettä.
* **Solmua tutkittu**: Solmujen määrä, joissa algoritmi vierailee.

Polun kustannus | BFS | UCS | GBF | A*
----------|----------|----------|----------|----------
Testi #1 | 474 | 183 | 651 | 183
Testi #2 | 114 | 114 | 390 | 114



Solmua tutkittu | BFS | UCS | GBF | A*
----------|----------|----------|----------|----------
Testi #1 | 22582 | 21889 | 255 | 3233
Testi #2 | 5419  | 5008  | 114 | 441


Jo näistä testeistä näkee, että A*- ja UCS-algoritmit tuottavat edullisimman, eli lyhyimmän polun. GBF-algoritmi taas tuottaa lähes poikkeuksetta kalleimman polun.

GBF tutkii ylivoimaisesti vähiten solmuja, toisin sanoen sen suoritusaika on algoritmeista nopein. BFS tutkii poikkeuksetta eniten solmuja, hieman enemmän kuin UCS. A* sen sijaan sijoittuu ääripäiden välimaastoon, kuitenkin selvästi lähemmäksi GBF-algoritmia kuin ensiksi mainittuja.

Kasvatan vertailua myöhemmin, mutta jo nyt näkee, että A* tuottaa optimaalisimman kokonaisuuden. Se tuottaa UCS-algoritmin tavoin kustannuksiltaan edullisimman polun, mutta sen suoritusnopeus on huomattavasti parempi kuin UCS:n. Vaikka se häviää suoritusnopeudessa GBF:lle, tuottaa se kuitenkin tätä huomattavasti edullisemman polun.

## Työn mahdolliset puutteet ja parannusehdotukset

(tulossa myöhemmin)

## Lähteet
