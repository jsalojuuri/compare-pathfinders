# Määrittelydokumentti

Tässä projektissa vertaillaan Breath First Search (BFS)-, Uniform Cost Search (UCS)-, Greedy Best First (GBF)- ja AStar (A*)-algoritmien tehokkuutta kaksiulotteisella kartalla ja toteutetaan kyseiset algoritmit Javalla korvaten Javan tarjoamat valmiit pino-, jono- tmv. tietorakenteet omilla toteutuksilla. 

Ohjelma saa syötteekseen [ASCII-pohjaisia karttatiedostoja](https://movingai.com/benchmarks/grids.html), johon on merkitty reitin aloitus- ja lopetuspisteet. Algoritmien tehtävänä on löytyy mahdollisimman kustannustehokas reitti pisteiden välillä mahdollisimman vähäisellä laskennalla. Algoritmien tehokkuutta arvioidaan vertailemalla niiden tuottamien reittien kustanustehokkuutta ja tutkittujen ruutujen määrää. 
* **Reitin kustannustehokkuuteen vaikuttaa** sekä kuljettujen karttaruutujen määrä että yksittäisen karttaruudun kustannus. Ruutukohtainen kustannus voi olla joko 1 (normaali ruutu) tai 5 (ruutu jossa puita). Tätä metriikkaa pyritään minimoimaan.
* **Tutkittujen ruutujen määrällä** tarkoitetaan ruutuja, jotka algoritmi on käynyt tarkemmin prosessoimassa läpi. Tutkittujen ruutujen määrä nostaa algoritmin prosessointiin käyttämää aikaa, joten tätä metriikkaa pyritään minimoimaan  

Lyhyesti vertailuun valituista algoritmeista:

* **BFS-algoritmi:** Yksinkertainen polkualgoritmi, joka etenee aaltomaisesti aloitussolmusta eteenpäin solmukerros kerrallaan kunnes löydetään maalisolmu. [BFS-algoritmin aikavaativuus](https://en.wikipedia.org/wiki/Breadth-first_search) on O(n + m), missä n on verkon solmujen, toisin sanoen kartan ruutujen lukumäärä ja m kaarten, eli solmujen välisten siirtymien lukumäärä. BFS-algoritmi ei hyödynnä tietoa solmujen välisten siirtymien kustannuksista tai esim. matkan tekoon jo käytettyä kokonaissiirtymämäärää. 

* **UCS-algoritmi:** BFS:stä Edsger Dijkstran vuonna 1959 jatkokehittämä algoritmi, joka ottaa huomioon solmujen välisiin siirtymisiin kuluvan kustannuksen. [Uniform Cost Search -algoritmin aikavaativuus](https://algorithmicthoughts.wordpress.com/2012/12/15/artificial-intelligence-uniform-cost-searchucs/). UCS-algoritmi tuottaa aina varmasti kustannustehokkaimman polun.

* **GBF-algoritmi:** GBF priorisoi karttaruutuja sen perustella kuinka lähellä maaliruutu sijaitsee nykyisestä sijainnista. Koska liikkuminen sallitaan vain pysty- tai vaakaakselin mukaisesti (ei siis vinoruuduittain), etäisyys lasketaan ns. [Manhattan distance](https://xlinux.nist.gov/dads/HTML/manhattanDistance.html) tyylin mukaisesti. Priorisointi ei hyödynnä millään tavoin tietoa karttaruudun kustannuksesta. GBF-algoritmin aikavaatimus on maksimissaan yhtä suuri kuin BFS- ja UCS-algoritmeilla, mutta käytännössä huomattavasti pienempi, koska tutkittavia verkon solmuja ja kaaria on keskimääräisessä kartassa vähemmän johtuen GBF-algoritmin suuntautumisesta jatkuvasti kohden maaliruutua.

* **A\*:** UCS:stä ja GBF:stä edelleen kehitetty algoritmi, jossa hyödynnetään sekä solmujen välisiä siirtymäkustannuksia (vrt. UCS) että heuristiikkatietoa nykyisen karttaruudun etäisyydestä maaliruudusta (vrt. GBF). Läpikäytäviä solmuja voidaan siirtymä- ja heuristiikkakustannusten perusteella asettaa prioriteettijonoon siten, että jonon alkupäästä löytyy aina lyhyimmän kustannuksen omaava solmu. [A*-algoritmin aikavaativuus](https://en.wikipedia.org/wiki/A*_search_algorithm) riippuu toteutettavasta heuristiikasta. A*-algoritmin tilavaatimus on vertailtavia algoritmeja suurempi, sillä käsiteltävistä solmuista tallennetaan muistiin enemmän tietoa. 

## Lähteet

* [Breadth-first Search](https://en.wikipedia.org/wiki/Breadth-first_search) 
* [Uniform Cost Search](https://algorithmicthoughts.wordpress.com/2012/12/15/artificial-intelligence-uniform-cost-searchucs/)
* [Greedy Best First Search](https://en.wikipedia.org/wiki/Best-first_search)
* [A* Search](https://en.wikipedia.org/wiki/A*_search_algorithm)
* [Ascii-kartat](https://movingai.com/benchmarks/grids.html)
* [Manhattan distance](https://xlinux.nist.gov/dads/HTML/manhattanDistance.html)
