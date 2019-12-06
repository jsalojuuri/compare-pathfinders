# Testausdokumentti

Ohjelmalle on toteutettu automaattisia JUnit yksikkötestejä ja algoritmien suorituskykyä on vertailtu.

## Yksikkötestien kattavuus

![Jacocon testikattavuus-raportti](./reports/jacoco/jacoco.png)

Pää- ja käyttöliittymäluokkia ei testata.

## Algoritmien yksikkötestit

![Jacocon testikattavuus-raportti, copa.algorithm](./reports/jacoco/jacoco_algorithm.png)

Tästä paketista löytyy vertailtavien algoritmien luokat ja kolmen algortimin osalta myös Comparator-luokat. Rivikattavuus yli 90%. Kaikissa metodeissa on testausta, mutta joitakin haaroja on käymättä läpi.

## Kartta- ja solmu-luokkien yksikkötestit

![Jacocon testikattavuus-raportti, copa.mapgraph](./reports/jacoco/jacoco_mapgraph.png)

Tästä paketista löytyy MapGraph-luokka, jolla ASCII-tiedosto muokataan verkoksi ja printataan näytölle sekä Node-luokka, joka vastaa karttaruutua eli verkon solmua. Käytännössä kaikki metodit paitsi kartan printtaus on testattu. En ole ehtinyt perehtymään miten saisin testattua tulostuksen toimivuuden.

## Algoritmien suorituskykyvertailu

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