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
 
## Spustenie aplikácie
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vzhľadom k tomu, že aplikácia využíva MySQL databázu, je pomerne zložité túto aplikáciu spustiť na inom zariadení. Aby však nebola potrebná inštalácia MySQL serveru na vašom zariadení, aplikácia využíva **portable (prenosnú) MySQL databázu**. Ide o .zip súbor, ktorý stačí jednoducho rozbaliť a nie je potrebná žiadna inštálacia. Napriek tomu je však potrebné databázu nakonfigurovať a pred spustením aplikácie vždy zapnút MySQL server, čo môže byť pomerné zložitý proces, no v nasledujúcich riadkoch sa pokusím zrozumiteľne vysvetliť, ako na to. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vzhľadom k tomu, že pri konfigúrácii a spúšťaní databázy bude potrebné uvádzať často absolútne cesty k niektorým súborom, odporúčam si uložiť tento projekt do **C:\Stravovaci-system-Vrboo**, aby ste absolútne cesty mohli iba jednoducho skopírovať z tohto návodu. 

<sub>Pozn.: Nakoľko je .zip súbor MySQL databázy väčší ako 100MB, musel byť rozdelený do dvoch súborov **mysql.part01** a **mysql.part02**.</sub>

**Návod:**
- Stiahnite si tento projekt (uložený v **C:\Stravovaci-system-Vrboo**)
- Označte obidva súbory **mysql.part01** a **mysql.part02**, kliknite pravým tlačidlom myši a zvoľte **Rozbaliť sem/Extrahovať sem**
  - Následne môžete tieto dva súbory **mysql.part01** a **mysql.part02** odstrániť
  - Po správnom rozbalení týchto súborov sa vám vytvorí nový priečinok s názvom **mysql**
- Vstúpte do priečinku **mysql** a otvorte súbor **config.ini**
- V súbore **config.ini** nastavte týmto trom atribútom hodnoty: (konfigurácia databázy)
  - basedir = "C:\\Stravovaci-system-Vrboo\\mysql\\mysql-8.0.25-winx64" (Absolútna cesta priečinku **mysql-8.0.25-winx64**, ktorý sa nachádza v priečinku **mysql*)
  - datadir = "C:\\Stravovaci-system-Vrboo\\mysql\\mydb" (Absolútna cesta priečinku **mydb**, ktorý sa nachádza v priečinku **mysql**)
  - log-error = "C:\\Stravovaci-system-Vrboo\\mysql\\logs\\error_log.err" (Absolútna cesta súboru **logs\\error_log.err**, ktorý sa nachádza v priečinku **mysql**)
- Uložený súbor **config.ini** bude vyzerať takto:
```
[mysqld]
innodb_buffer_pool_size = 128M
log_bin
join_buffer_size = 128M
sort_buffer_size = 2M
read_rnd_buffer_size = 2M 
sql_mode = NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
basedir = "C:\\Stravovaci-system-Vrboo\\mysql\\mysql-8.0.25-winx64"
datadir = "C:\\Stravovaci-system-Vrboo\\mysql\\mydb"
port = "55555"
log-error = "C:\\Stravovaci-system-Vrboo\\mysql\\logs\\error_log.err"

[mysqladmin]
user = "root"
port = "55555"
```

- Následne otvorte Príkazový riadok a zadajte tento príkaz: (inicializácia databázy)
   - `"C:\Stravovaci-system-Vrboo\mysql\mysql-8.0.25-winx64\bin\mysqld.exe" --defaults-file="C:\\Stravovaci-system-Vrboo\\mysql\\config.ini" --initialize-insecure --console`
- Databáza je teraz nakonfigurovaná aj inicializovaná, už stačí iba zapnúť MySQL server, aby sme mohli spustiť aplikáciu
- Do Príkazového riadku zadajte tento príkaz: (zapnutie MySQL serveru)
  - `start "" "C:\Stravovaci-system-Vrboo\mysql\mysql-8.0.25-winx64\bin\mysqld.exe" --defaults-file="C:\\Stravovaci-system-Vrboo\\mysql\\config.ini"`
  - Ak bol server úspešne zapnutý, otvorí sa nové okno Príkazového riadku, čo značí, že server je zapnutý
  - Server vypnete zatvorením Príkazového riadku 
- Následne môžete spustiť aplikáciu otvorením súboru out/artifacts/Stravovaci-system_jar/**run-app.bat**
  - Spúšťanie aplikácie môže chvíľu trvať 
- Odteraz stačí pred spustením aplikácie zapnúť MySQL server 

<br>

- Podrobnejší návod: https://stackoverflow.com/a/42088890
- V prípade otázok ma prosím kontaktujte na e-mail: dominikvrbo@gmail.com



## Technológie
- Programovací jazyk: **Java**
- Databáza: **MySQL (portable)**
- Framework, ORM tool: **Hibernate**
- VCS: **Git**
- GUI toolkit: **Java Swing**
- GUI designer: **JFromDesigner** (IDE plugin) 
- Externá knižnica: **KControls** - https://github.com/k33ptoo/KControls


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
- Burza jedál umožňuje ponúknuť objednané jedlo iným používateľom 
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


