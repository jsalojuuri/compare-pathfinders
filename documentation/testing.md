# Testausdokumentti

Ohjelmalle on toteutettu automaattisia JUnit yksikkötestejä.

## Testien kattavuus

![Jacocon testikattavuus-raportti](./reports/jacoco/jacoco.png)

Pää- ja käyttöliittymäluokkia ei testata.

## copa.algorithm

![Jacocon testikattavuus-raportti, copa.algorithm](./reports/jacoco/jacoco_algorithm.png)

Rivikattavuus yli 90%. Kaikissa metodeissa on testausta, mutta joitakin haaroja on käymättä läpi.

## copa.mapgraph

![Jacocon testikattavuus-raportti, copa.mapgraph](./reports/jacoco/jacoco_mapgraph.png)

Käytännössä kaikki metodit paitsi kartan printtaus on testattu. En ole ehtinyt perehtymään miten saisin testattua tulostuksen toimivuuden.