# Määrittelydokumentti

Tässä projektissa vertaillaan Breath First Search (BFS)-, Uniform Cost Search (UCS) - ja AStar (A*)-algoritmien tehokkuutta kaksiulotteisella kartalla ja toteutetaan kyseiset algoritmit Javalla korvaten Javan tarjoamat valmiit pino-, jono- tmv. tietorakenteet omilla toteutuksilla. 

Ohjelma saa syötteekseen [ASCII-pohjaisia karttatiedostoja](https://movingai.com/benchmarks/grids.html), johon on merkitty reitin aloitus- ja lopetuspisteet. Algoritmien tehtävänä on löytyy mahdollisimman lyhyt reitti pisteiden välillä mahdollisimman vähäisellä laskennalle. Algoritmien tehokkuutta arvioidaan vertailemalla niiden tuottamien reittien pituutta ja laskentaan käytettyjä aikoja keskenään.  

Lyhyesti vertailuun valituista algoritmeista:

* **BFS-algoritmi:** Yksinkertainen polkualgoritmi, joka etenee aaltomaisesti aloitussolmusta eteenpäin solmukerros kerrallaan kunnes löydetään maalisolmu. [BFS-algoritmin aikavaativuus](https://en.wikipedia.org/wiki/Breadth-first_search) on O(n + m), missä n on verkon solmujen, toisin sanoen kartan ruutujen lukumäärä ja m kaarten, eli solmujen välisten siirtymien lukumäärä. BFS-algoritmi ei hyödynnä tietoa solmujen välisten siirtymien kustannuksista tai esim. matkan tekoon jo käytettyä kokonaissiirtymämäärää. 

* **UCS-algoritmi:** BFS:stä Edsger Dijkstran vuonna 1959 jatkokehittämä algoritmi, joka ottaa huomioon solmujen välisiin siirtymisiin kuluvan kustannuksen [Uniform Cost Search -algoritmin aikavaativuus](https://algorithmicthoughts.wordpress.com/2012/12/15/artificial-intelligence-uniform-cost-searchucs/).

* **A\*:** UCS:stä edelleen kehitetty algoritmi, jossa solmujen välisten siirtymäkustannusten lisäksi hyödynnetään heuristiikkatietoa, joka tässä yhteydessä tarkoittaa sitä kuinka lähellä kohdesolu sijaitsee "linnuntietä" nykyisestä sijainnista. Läpikäytäviä solmuja voidaan siirtymä- ja heuristiikkakustannusten perusteella asettaa prioriteettijonoon siten, että jonon alkupäästä löytyy aina lyhyimmän kustannuksen omaava solmu. [A*-algoritmin aikavaativuus](https://en.wikipedia.org/wiki/A*_search_algorithm) riippuu toteutettavasta heuristiikasta. A*-algoritmin tilavaatimus on vertailtavia algoritmeja suurempi, sillä käsiteltävistä solmuista tallennetaan muistiin enemmän tietoa. 

## Lähteet

* [Breadth-first Search](https://en.wikipedia.org/wiki/Breadth-first_search) 
* [Uniform Cost Search](https://algorithmicthoughts.wordpress.com/2012/12/15/artificial-intelligence-uniform-cost-searchucs/)
* [A* Search](https://en.wikipedia.org/wiki/A*_search_algorithm)
* [Ascii-kartat](https://movingai.com/benchmarks/grids.html)

