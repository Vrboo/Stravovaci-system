# Stravovací systém
### Desktopová aplikácie s pokročilejším GUI (grafickým rozhraním) napojená na MySQL databázu

<sub>&nbsp;&nbsp;&nbsp;&nbsp;Pozn.: Spustiteľný súbor aplikácie - run-app.bat</sub>

## Úvod  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Aplikácia podobná bežnému stravovaciemu systému na objednávanie jedál využívana v školstve, zdravotníctve a pod. 
Pre používateľa sú k dispozícií nástroje ako objednávanie jedál, burza, elektronické dobíjanie účtu a mnoho ďalších. Viac o tejto aplikácii vám poskytnú nižšie 
uvedené informácie.
 

## Technológie:
- Programovací jazyk: Java
- Databáza: MySQL (portable)
- Framework, ORM tool: Hibernate
- VCS: Git
- GUI toolkit: Java Swing 
- GUI designer: JFromDesigner (IDE plugin) 
- Externá knižnica: KControls - https://github.com/k33ptoo/KControls


## Sprievodca aplikáciou

### Prihlásenie
- Po spustení aplikácie je nutné sa prihlásiť do svojho účtu prostredníctvom prihlasovacieho mena a hesla. 

### Registrácia
- V prípade, že používateľ ešte nemá vytvorený účet môže sa zaregistrovať.
- Pri registrácii je potrebná uviesť:
  - Používateľské meno
  - Celé meno
  - **Heslo** - musí obsahovať minimálne 6 znakov, 1 veľké písmeno a 1 číslicu
  - Potvrdenie hesla opätovným zadaním
  
 ### Prihlásený používateľ aplikácie
- Prihlásený používateľ sa môže nachádzať v akýchsi dvoch módoch: 
    1. **Bežný používateľ aplikácie**
    2. **Administrátor aplikácie**
