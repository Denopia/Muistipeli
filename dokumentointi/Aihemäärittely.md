#Aihemäärittely

####Aihe:
Muistipeli. Pelaaja pelaa tässä versiossa vain tietokonetta vastaan. Pelissä kummallakin pelaajalla on oma hahmo ja hahmolla elämä- ja energiamittarit. Tavoitteena on saada astustaja elämäpisteet nollaan. Oman vuoron aikana pelaaja voi lyödä vastustajaa kerran käyttämällä energiaa. Kun vastustajaa lyö, tämän elämä laskee. Vuoron aikana voi käyttää myös taitoja, jotka vievät energiaa. Taito voi olla esimerkiksi sellainen, että valitset rivin laattoja, ja ne kaikki kääntyvät. Kääntämällä laattaparin saa niistä tietyn efektin. Itse pelissä voi katsella tarkemmat ohjeet.

####Käyttäjät: 
Pelaaja

####Käyttäjän toiminnot:
- Ohjeiden katselu
- Pelin sammuttaminen
- Pelin valmistelu
- Pelin valmistelussa:
  - Oman hahmon vaihtaminen
  - Vastustajan hahmon vaihtaminen
  - Vaikeusasteen valitseminen
  - Valikkoon palaaminen
  - Pelin aloittaminen
- Pelissä:  
  - Laattojen kääntäminen
  - Vastustajan lyöminen
  - Taidon käyttäminen
  - Pelin luovuttaminen

####Rakennekuvaus:
Pelin käynnistyessä pääluokka MuistipeliMain luo uuden UI olion, joka on vähän turha väliolio (luo vain framen ja GameScreenin eikä käytetä myöhemmin). GameScreen luo aluksi päävalikon MainMenu mikä tekee itselleen piirtoalustan, hiirenkuuntelijan, ja korostusten ylläpidon. 
   Kun valikossa painaa ohje-nappia annetaan GameScreenille käsky luoda Instructions olio. Samalla GameScreen poistaa MainMenun piirtoalustan pelin framesta. Instructions oli luo itselleen taas piirtoalustan, hiirenkuuntelijan ja korostuksen ylläpidon ja laittaa piirtoalustan pelin frameen.
   Kun painetaan ohjeruudussa valikkonappia, ohjeiden piirtoalusta poistetaan framesta ja luodaan taas uusi valikko olio kuten pelin käynnistyessä. Kun valikossa nyt painetaan yksinpeli-nappia valikko poistetaan framesta ja luodaan tilalle GamePreparation olio joka taas itselleen luo tarvittavat oliot, piirtoalustan, hiirenkuuntelijan ja korostuskontrollerin.
   Kun pelin valmistelu on kunnossa ja peli aloitetaan tapahtuu sama homma kuin aikaisemminkin. Poistetaan valmistelun piirtoalusta ruudusta ja GameScreenia käsketään luomaan itse peli. Peli tekee itselleen kasan uusia olioita: korostusmuistilistan, hyökkäykskontrollerin, hiirenkuuntelijan, piirtoalustan ja laattojenkäsittelijän. GamePreparation olikin luonut pelaajan ja vastustajan jo valmiiksi ja antanut ne GameScreenin kautta SinglePlayerGamelle parametrina. Pelaajien luonnissa heille myös on tehty pelihahmo-oliot ja vastustaja lisäksi tekee itselleen vuoronsuorittajan ja laattojen kontrollerin, johon lisätään laattoja sitä mukaa kun niitä pelissä käännellään.
  Keskeisessä osassa pelissä on siis GameScreen luokka jonka kautta luodaan pelin frameen aina haluttavaa sisältöä. GameScreen ei itse tunne muuta kuin framen, mutta se antaa itsensä ohje-, valikko-, valmistelu- ja yksinpeliolioille, jotka voivat käskeä sitä muokkaamaan näytettävää framen sisältöä.


####Muuta:
- Peliä ohjataan hiiren klikkauksilla
- Pelistä puuttuu voitto/häviöruutu. Kun toinen pelaaja voittaa peli palaa välittömästi alkuvalikkoon
- Pelin vaikeusasteita ei keretty hioa kunnolla. Toiseksi helpoin taso tuntuu olevan sopivin.
- Vastustajan "tekoäly" jäi muutenkin kovin alkukantaiseksi
- Hiiren liikeen kuuntelu oli vielä tarkoitus muuttaa ottamaan hiiren koordinaatit vain ruudun piirron yhteydessä ja näin tarkastaa mikä nappula piirretään korostettuna
- Peli ei välttämättä sovi värisokeille tässä versiossa, olisi hyvä vaihtaa värit vastaamaan jotain kuvaa, kuten vaikkapa vihreä numero voisi olla sydän jonka sisällä on numero jne.
- Pelin sisältö jäi hyvin pieneksi koska muutamia tarkoitettuja ominaisuuksia ei vain keretty lisätä

