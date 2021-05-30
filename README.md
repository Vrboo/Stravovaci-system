# Stravovací systém
### Desktopová aplikácia s pokročilejším GUI (grafickým rozhraním) napojená na MySQL databázu

<sub>&nbsp;&nbsp;&nbsp;&nbsp;Pozn.: Spustiteľný súbor aplikácie - run-app.bat</sub> <br>
<sub>&nbsp;&nbsp;&nbsp;&nbsp;Pozn.: Prístupové heslo pre administrátora: 12345678</sub> <br>
<sub>&nbsp;&nbsp;&nbsp;&nbsp;Pozn.: Vzhľadom k tomu, že táto aplikácia nemá reálny charakter využiteľnosti a nie je denne aktualizovaná a nové jedálne lístky, je 
naprogramovaná iba pre jednorázové objednávanie. V skratke používateľ si môže objednať jedlo z jedálného lístka, no nie je určený dátum jeho výdaja.
Jedálny lístok a objednávky sú aktuálne pokiaľ administrátor aplikácie nevytvorí nový jedálny lístok.</sub>

## Úvod  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Aplikácia podobná bežnému stravovaciemu systému, ktorý sa využíva v školstve, zdravotníctve, firmách a pod. 
Pre používateľa sú k dispozícií nástroje ako objednávanie jedál, burza, elektronické dobíjanie účtu a mnoho ďalších. 
Viac o tejto aplikácií vám poskytnú nižšie uvedené informácie.
 

## Technológie
- Programovací jazyk: Java
- Databáza: MySQL (portable)
- Framework, ORM tool: Hibernate
- VCS: Git
- GUI toolkit: Java Swing 
- GUI designer: JFromDesigner (IDE plugin) 
- Externá knižnica: KControls - https://github.com/k33ptoo/KControls


## Sprievodca aplikáciou

### Prihlásenie a registrácia
- Po spustení aplikácie je nutné sa prihlásiť do svojho účtu prostredníctvom používateľského mena a hesla
- V prípade, že používateľ ešte nemá vytvorený účet, musí sa zaregistrovať
- Pri registrácii je potrebná uviesť:
  - Používateľské meno
  - Celé meno
  - **Heslo** - musí obsahovať minimálne 6 znakov, 1 veľké písmeno a 1 číslicu
  - Potvrdenie hesla opätovným zadaním
- Prihlásený používateľ sa môže nachádzať v akýchsi dvoch módoch: 
  - **Bežný používateľ aplikácie**
  - **Administrátor aplikácie**

<br>

### Bežný používateľ aplikácie
- Bežný používateľ aplikácie má k dispozícii štandardné funkcie: 

#### Objednať
  - Používateľ si môže objednať maximálne jedny **raňajky** a jeden **obed**
  - Každé jedlo má stanovenú kapacitu (maximálny počet objednávok/porcií daného jedla), a preto je pri každom jedle uvedený stĺpec s názvom "Voľné", ktorý informuje 
  o počte ešte voľných porcíí daného jedla
  - Ak si používateľ objednal obed alebo raňajky, tak túto objednávku už nemožno stornovať
  - V prípade, že používateľ už nemá v úmysle svoju objednávku využiť, môže ju vložiť na burzu jedál a ponúknuť ju iným používateľovom aplikácie
  
#### Moje objednávky
  - Použivateľovi sa zobrazia jeho aktuálne objednávky
  - V prípade, že použivateľ chce svoju objednávku pridať alebo odobrať z burzy, môže to urobiť práve tu

#### Burza
- Burza jedál umožňuje ponúknuť objednané jedlo inému používateľovi
- Pokiaľ si niekto toto jedlo z burzy objedná, používateľovi sa vrátia peniaze za danú objednávku

#### Účet
   - Používateľ si môže **dobiť účet** sumou minimálne 1€
   - Používateľ si môže **vybrať z účtu peniaze**, no pred vykonaním tejto transakcie je potrebné zadať heslo, aby sa predišlo odcudzeniu peňazí
   - Používateľ môže prehliadať svoju **históriu vykonaných transakcií**
       - Hístóriu je možné zoradiť od najstarších alebo od najnovších
       - Históriu je možné filtrovať podľa typu transakcií (vklady, výbery)

#### Zmeniť heslo
- Používateľ si môže zmeniť heslo 

#### Odhlásiť sa
- Odhlásenie používateľa 

<br>

### Administrátor aplikácie
- Aby sa používateľ mohol prihlásiť ako administrátor, je potrebné zadať prístupové heslo: 12345678
- Administrátor aplikácie má k dispozícií funkcie:

#### Nový jedálny lístok
- Administrátor môže vytvoriť nový jedálny lístok
- Vytvorením nového jedálneho lístku sa vymažú všetky objednávky, ktoré boli dovtedy vytvorené

#### Počet objednávok
- Administrátorovi sú poskytnuté informácie o počte objednávok jednotlivých jedál

#### Transakcie
- Administrátorovi sú poskytnuté informácie o všetkých vykonaných transakciách v rámci stravovacieho systému
  - Transakcie je možné zoradiť od najstarších alebo od najnovších
  - Transakcie je možné vyhľadať na základe celého mena používateľa, ktorý transakciu vykonal
  - Transakcie je možné filtrovať na základe typu (vklady, výbery)


