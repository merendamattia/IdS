# Indice
```table-of-contents
```
---

## Design Pattern
I design patterns (pattern di progettazione) nel contesto del software sono soluzioni generali e riutilizzabili per problemi comuni che si verificano frequentemente nel design del software.

1.  **Definizione:**
    
    -   Un design pattern non è un design completo trasformabile direttamente in codice sorgente.
    -   È una descrizione o un modello su come risolvere un problema, utilizzabile in diverse situazioni.
2.  **Ruolo:**
    
    -   I design patterns rappresentano le migliori pratiche formalizzate che il progettista può utilizzare per risolvere problemi comuni durante la progettazione di un sistema.
3.  **Natura delle Soluzioni:**
    
    -   I pattern di progettazione forniscono soluzioni generiche e adattabili, piuttosto che progettazioni finite direttamente implementabili.
4.  **Principale Caratteristica:**
    
    -   Sono best practice formalizzate, e il loro utilizzo consente di affrontare in modo efficiente problemi comuni senza dover riprogettare da zero ogni volta.
5.  **Orientamento agli Oggetti:**
    
    -   I design patterns orientati agli oggetti mostrano tipicamente le relazioni e le interazioni tra classi e oggetti, senza specificare le classi o gli oggetti finali che saranno coinvolti nell'applicazione.

Gli sviluppatori possono utilizzare i design patterns come strumenti concettuali per risolvere problemi ricorrenti durante la progettazione e lo sviluppo del software, facilitando la creazione di soluzioni robuste e manutenibili.

---

### GoF
I design patterns hanno guadagnato popolarità nell'ingegneria del software dopo la pubblicazione del libro "Design Patterns: Elements of Reusable Object-Oriented Software" nel 1994, scritto dal cosiddetto Gang of Four (GoF), composto da E. Gamma, R. Helm, R. Johnson, J. Vlissides. Ecco una dettagliata spiegazione:

1.  **Origine e Popolarità:**
    
    -   I design patterns sono diventati popolari nel campo dell'ingegneria del software con la pubblicazione del libro del GoF nel 1994.
    -   Il libro, intitolato "Design Patterns: Elements of Reusable Object-Oriented Software", è stato scritto dai quattro autori noti come Gang of Four.
2.  **Categorie dei Design Patterns:**
    
    -   Il libro GoF discute vari design patterns suddividendoli nelle seguenti classi:
        -   <u>**Creational Patterns</u> (Pattern Creazionali):** Intenti a creare oggetti, evitando che il programmatore istanzi direttamente gli oggetti.
        -   <u>**Structural Patterns</u> (Pattern Strutturali):** Utilizzano l'ereditarietà per comporre interfacce e definiscono modi per comporre oggetti per ottenere nuove funzionalità.
        -   <u>**Behavioral Patterns</u> (Pattern Comportamentali):** Sono specificamente concentrati sui protocolli di comunicazione tra gli oggetti.

Questi design patterns forniscono un approccio strutturato per affrontare tipi specifici di problemi di progettazione, offrendo soluzioni che sono state validate e riconosciute come buone pratiche dalla comunità di sviluppatori.

[_Torna all'indice_](#indice)

---

## Creational Patterns
I Creational Patterns, o Pattern Creazionali, sono una categoria di design patterns che si concentrano sulla creazione degli oggetti:

1.  **Abstract Factory (Factory Astratta):**
    
    -   Raggruppa le fabbriche di oggetti che hanno un tema comune.
    -   Fornisce un'interfaccia per creare famiglie di oggetti o sistemi di oggetti correlati senza specificare le classi concrete degli oggetti.
2.  **Builder (Costruttore):**
    
    -   Costruisce oggetti complessi separando la costruzione dalla rappresentazione.
    -   Consente di creare un oggetto passo dopo passo, consentendo configurazioni flessibili.
3.  **Factory Method (Metodo di Fabbrica):**
    
    -   Crea oggetti senza specificare la classe esatta da creare.
    -   Definisce un'interfaccia per la creazione di un oggetto, ma lascia alle sottoclassi la scelta della classe da istanziare.
4.  **Prototype (Prototipo):**
    
    -   Crea oggetti clonando un oggetto esistente (prototipo).
    -   Permette di creare nuovi oggetti duplicando quelli esistenti, evitando la necessità di creare nuove classi.
5.  **Singleton:**
    
    -   Limita la creazione di oggetti per una classe a una sola istanza.
    -   Assicura che una classe abbia una sola istanza globale e fornisce un punto di accesso globale a tale istanza.

Questi Creational Patterns forniscono approcci diversi alla creazione di oggetti, consentendo una maggiore flessibilità, riusabilità del codice e gestione efficiente delle istanze degli oggetti.

[_Torna all'indice_](#indice)

---

### Abstract Factory

> Conosciuto anche come Kit.

![[47.png]]

L'Abstract Factory è uno dei principali pattern <u>creazionali</u> il cui scopo è quello di fornire un'interfaccia per creare famiglie di oggetti interconnessi fra loro, in modo che non ci sia necessità di specificare i nomi delle classi concrete all'interno del proprio codice. In questo modo si facilita la creazione di un sistema indipendente dall'implementazione degli oggetti concreti, infatti, l'utilizzatore (Client) conosce solo l'interfaccia per creare le famiglie di prodotti ma non la sua implementazione concreta.

L'Abstract Factory è costituito da 5 elementi:
1. **AbstractFactory**: interfaccia che definisce i metodi mediante i quali sarà possibile ottenere gli AbstractProduct.

2. **ConcreteFactory**: nel sistema possono essere create _n_ ConcreteFactory, ciascuna delle quali dovrà implementare l'interfaccia AbstractFactory e quindi implementare i metodi mediante i quali sarà possibile ottenere i ConcreteProduct. Per garantire che nel sistema esiste un'unica istanza di ciascuna ConcreteFactory, è buona norma definire ciascuna di esse come Singleton.

3. **AbstractProduct**: interfaccia che definisce la struttura base dei prodotti che la factory può instanziare.

4. **ConcreteProduct**: nel sistema possono essere creati _n_ ConcreteProduct ciascuno dei quali dovrà implementare l'interfaccia AbstractProduct.

5. **Client**: classe che utilizza l'AbstractFactory per generare i prodotti concreti all'interno del sistema.

Naturalmente il Pattern offre dei vantaggi ma anche degli svantaggi.

I vantaggi principali sono i seguenti:
-   Il pattern permette di isolare i punti di creazione degli oggetti di una classe. La Factory incapsula tutti i meccanismi di creazione. Le classi concrete si trovano specificate soltanto all'interno della factory, il resto si affida alla definizione delle interfacce. Il client può ottenere l'istanza di un prodotto concreto esclusivamente mediante l'interfaccia AbstractFactory.
-   Il client può cambiare la famiglia di prodotti utilizzata semplicemente cambiando la linea di codice che riguarda la creazione della factory.
-   Promuove la consistenza tra i prodotti che sono organizzati in famiglie. I prodotti di una famiglia sono coordinati per lavorare insieme.

Lo svantaggio principlamente è uno: aggiungere un nuovo prodotto richiede la modifica dell'interfaccia AbstractFactory ma la modifica si ripercuote a cascata nelle factory concrete e in tutte le sottoclassi, rendendo laboriosa l'operazione.

Il pattern AbstractFactory può essere utilizzato in un gran numero di situazioni reali. 
Per cercare di acquisire una certa dimestichezza con questo pattern e capirne meglio il funzionamento illustriamo un esempio di utilizzo in un contesto reale. Il nostro esempio simula la renderizzazione di una figura geometrica. Per semplicità implementiamo un'unica ConcreteFactory e soltanto due prodotti che non fanno altro che stampare una stringa a video.

#### Esempio - Abstract Factory
Analizziamo ora in dettaglio le singole interfacce/classi necessarie per implementare il pattern. Partiamo da **FiguraFactory** che rappresenta la nostra AbstractFactory. Definisce i metodi che ciascuna ConcreteFactory deve implementare: `createRettangolo()` e `createCerchio()`. Entrambi i metodi restituiscono un'istanza della classe Figura.

**FiguraFactory:**
```java
public abstract class FiguraFactory {  
	 public abstract Figura createRettangolo();  
	 public abstract Figura createCerchio();  
}
```

**MiaFiguraFactory** rappresenta la nostra unica ConcreteFactory. Tale classe deve estendere la classe astratta FiguraFactory e quindi, implementare i due metodi definiti: `createRettangolo()` e `createCerchio()` che restituiscono rispettivamente, un'istanza della classe MioRettangolo e un'istanza della classe MioCerchio.

**MiaFiguraFactory:**
```java
public class MiaFiguraFactory extends FiguraFactory {  
	public Figura createCerchio() {  
		return new MioCerchio();  
	}  
	public Figura createRettangolo() {  
		return new MioRettangolo();  
	}  
}
```

**Figura** rappresenta il nostro AbstractProduct che definisce la struttura base di un generico prodotto della famiglia. Per semplicità definiamo esclusivamente il metodo `disegna()`.

**Classe Figura:**
```java
public abstract class Figura {  
	 public abstract void disegna();  
}
```

MioCerchio e MioRettangolo sono i nostri ConcreteProduct che estendono la classe astratta Figura. Per semplicità i due metodi stampano soltanto una stringa a video.

**ConcreteProduct: MioCerchio e MioRettangolo**
```java
public class MioCerchio extends Figura {  
	public void disegna() {  
		System.out.println("Io sono il cerchio");  
	}  
}

public class MioRettangolo extends Figura {  
	public void disegna() {  
		System.out.println("Io sono il rettangolo");  
	}  
}
```

Test rappresenta il nostro Client, cioè la classe che utilizza l'AbstractFactory per ottenere un'istanza dei nostri prodotti concreti. È possibile vedere come il Client non deve sapere nulla delle classi concrete che deve utilizzare.

**Client: Classe Test**
```java
public class Test {  
	public static void main(String[] args) {  
		FiguraFactory factory = new MiaFiguraFactory();  
		Figura c = factory.createCerchio();  
		Figura r = factory.createRettangolo();  
		c.disegna();  
		r.disegna();  
	}  
}
```

[_Torna all'indice_](#indice)

---

### Builder
Il Build Pattern e' un pattern <u>creazionale</u> che in molte situazioni può rappresentare una valida alternativa alla costruzione di oggetti mediante costruttori.

La necessità di introdurre meccanismi alternativi a quelli forniti da Java per la creazione di oggetti nasce dal fatto che talvolta le strutture sono molto complesse e non sempre è banale impostare un costruttore ben formato. Pensiamo ai casi in cui il numero di attributi sia molto alto oppure ai casi in cui ci sono attributi che possono anche non essere valorizzati. La probabilità di fare un errore scrivendo il costruttore a mano è molto alta.

L'obiettivo finale è quello di separare la creazione dell'oggetto dalla sua rappresentazione. In tale maniera l'algoritmo per la creazione dell'oggetto è indipendente dalle varie parti che costituiscono l’oggetto e da come vengono assemblate.

La creazione delle istanze e la loro gestione vengono quindi separate in modo da rendere il programma più semplice.

Un aspetto molto interessante è che questi meccanismi permettono di creare un oggetto passo passo, verificandone l'idoneità ad ogni passaggio (pensiamo a quando vogliamo costruire un oggetto con dati provenienti dai risultati di un parser) e soprattutto ci permette di nascondere la logica di controllo che sarebbe magari stata presente nell'eventuale costruttore.

> Il Builder Pattern è usato per creare istanze di oggetti molto complessi con costruttori telescopici nella maniera più semplice.

![[58.png]]

Analizziamo in dettaglio i vari componenti:

-   **Product:** definisce il tipo di oggetto complesso che sarà generato dal **Builder Pattern**.
-   **Builder:** questa **classe astratta** va a definire i vari passaggi per creare correttamente gli oggetti. Ogni metodo è generalmente astratto e le implementazioni sono fornite dalle sottoclassi concrete. Il metodo `getProduct()` è utilizzato per restituire il prodotto finale. Talvolta il Builder viene sostituito da un'interfaccia.
-   **ConcreteBuilder:** possono esserci diverse sottoclassi concrete `ConcreteBuilder`. Queste sottoclassi forniscono i meccanismi per la creazione di oggetti complessi.
-   **Director:** la classe Director controlla l'algoritmo per la creazione dei vari oggetti. Quando viene istanziata, il suo costruttore viene invocato. Contiene un parametro che indica quale `ConcreteBuilder` utilizzare per la creazione degli oggetti. Durante il processo di creazione, i vari metodi del `ConcreteBuilder` vengono richiamati e alla fine delle operazioni, il metodo `getProduct()` viene utilizzato per ottenere il prodotto finale.

#### Esempio - Builder
> Esempio presente in Effective Java di Joshua Bloch.

```java
public class Animal {
	private final String id;
	private String name;
	private String pedigreeName;
	private String owner;
	private String race;
	private String residence;
	private Boolean isVaccinated;
	private Boolean isChampion;
	private List sons;
	private Sex sex;
	private Double weight;
	private Double height;
	
	public Animal(String name, String pedigreeName, String id, String owner, String race, String residence, Boolean isVaccinated, Boolean isChampion, List sons, Sex sex, Double weight, Double height) {
		this.name = name;
		this.pedigreeName = pedigreeName;
		this.id = id;
		this.owner = owner;
		this.race = race;
		this.residence = residence;
		this.isVaccinated = isVaccinated;
		this.isChampion = isChampion;
		this.sons = sons;
		this.sex = sex;
		this.weight = weight;
		this.height = height;
	}
	
	public enum Sex {
		MALE,
		FEMALE
	}
} // ! Animal
```

Applichiamo ora il pattern:

```java
public final class AnimalBuilder {
	private String id;
	private String name;
	private String pedigreeName;
	private String owner;
	private String race;
	private String residence;
	private Boolean isVaccinated;
	private Boolean isChampion;
	private List<String> sons;
	private Animal.Sex sex;
	private Double weight;
	private Double height;
	
	private AnimalBuilder(String id) {
		this.id = id;
	}
	
	public static AnimalBuilder newBuilder(String id) {
		return new AnimalBuilder(id);
	}
	
	public AnimalBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public AnimalBuilder pedigreeName(String pedigreeName) {
		this.pedigreeName = pedigreeName;
		return this;
	}
	
	public AnimalBuilder owner(String owner) {
		this.owner = owner;
		return this;
	}
	
	public AnimalBuilder race(String race) {
		this.race = race;
		return this;
	}
	
	public AnimalBuilder residence(String residence) {
		this.residence = residence;
		return this;
	}
	
	public AnimalBuilder isVaccinated(Boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
		return this;
	}
	
	public AnimalBuilder isChampion(Boolean isChampion) {
		this.isChampion = isChampion;
		return this;
	}
	
	public AnimalBuilder sons(List<String> sons) {
		this.sons = sons;
		return this;
	}
	
	public AnimalBuilder sex(Animal.Sex sex) {
		this.sex = sex;
		return this;
	}
	
	public AnimalBuilder weight(Double weight) {
		this.weight = weight;
		return this;
	}
	
	public AnimalBuilder height(Double height) {
		this.height = height;
		return this;
	}
	
	public Animal build() {
		return new Animal(name, pedigreeName, id, owner, race, residence, isVaccinated, isChampion, sons, sex, weight, height);
	}
} // ! AnimalBuilder
```

Un oggetto potrà ora essere istanziato come:

```java
Animal pluto = AnimalBuilder.newBuilder("0000001")
	.name("0000001")
	.pedigreeName("PlutoSecondo")
	.owner("Marco Rossi")
	.race("labrador")
	.residence("Via x")
	.isVaccinated(true)
	.isChampion(false)
	.sons(null)
	.sex(Animal.Sex.MALE)
	.weight(40.5)
	.height(30.0)
	.build();
```

> Premettiamo che in questo particolare caso, la classe astratta Builder non è strettamente indispensabile. Può essere aggiunta senza modificare radicalmente la struttura presentata qui sotto.

Troviamo diversi vantaggi nell'utilizzo di questo pattern creazionale, infatti possiamo creare oggetti cloni, o comunque molto simili, minimizzando il codice da scrivere. Il metodo utilizzato è simile al seguente, facendo riferimento al builder istanziato sopra:

```java
Animal animal3A = animalBuilder.build();
Animal animal3AClone = animalBuilder.build();
Animal animal3B = animalBuilder.sex(Animal.Sex.FEMALE).build();
```

Qui si creano due oggetti uguali e un oggetto simile ai due precedenti, ma con sesso opposto. Un vantaggio molto importante è quello di concentrare la validazione della classe in un unico metodo e di ottenere quindi oggetti pressochè immutabili.

Va precisato che la versione presentata è leggermente diversa da quella presentata nel modello originale. L'unico svantaggio dell'utilizzo del pattern è il fatto che vada necessariamente definita una classe builder per ogni oggetto, aumentando nettamente il tempo di sviluppo.

[_Torna all'indice_](#indice)

---

### Factory Method

> Conosciuto anche come Virtual Constructor.

Si tratta di un pattern <u>creazionale</u> basato su classi e viene utilizzato per creare degli oggetti senza conoscerne i dettagli ma delegando un Creator che, in base alle informazioni ricevute, saprà quale oggetto restituire. Questo pattern consente di separare il Client dal Framework  permettendo di modificare i dettagli implementativi senza dovere modificare il Client.

Questo pattern è composto dai seguenti partecipanti:
- Creator: dichiara la `Factory` che avrà il compito di ritornare l’oggetto appropriato.
- ConcreteCreator: effettua l’overwrite del metodo della `Factory` al fine di ritornare l’implementazione dell’oggetto.
- Product: definisce l’interfaccia dell’oggetto che deve essere creato dalla `Factory`.
- ConcreteProduct: implementa l’oggetto in base ai metodi definiti dall’interfaccia `Product`.

![[59.png]]

Tale pattern presenta i seguenti vantaggi/svantaggi:

1.  Rappresenta un gancio alle sottoclassi: tramite il `Creator` è possibile scegliere quale classe concreta utilizzare e decidere di cambiarla senza avere nessun impatto verso il `Client`.
2. Consente di collegare gerarchie di classi in modo parallelo: i `ConcreteCreator` possono collegarsi con i `ConcreteProduct` e generare un collegamento parallelo tra gerarchie diverse.

#### Esempio - Factory Method
Come esempio  pensiamo al caso in cui ci rechiamo in un centro commerciale  per acquistare un paio di scarpe sportive, in particolare da ginnastica, quindi chiediamo al commesso di turno che ci rimanda al commesso specializzato nel settore di nostro interesse che ci consegnerà le scarpe di ginnastica che cercavamo.

Vediamo come si presenta il pattern in UML in base all’esempio:

![[60.png]]

Vediamo come si presenta la classe Cliente:

```java
public class Cliente {
    public static void main(String[] args) {
        Commesso commesso = new Commesso();
        
        Scarpe scarpe = commesso.getScarpe("ginnastica");
        
        System.out.println(scarpe.getClass());
    }
} // ! Cliente
```

Vediamo la definizione del prodotto nella sua definizione e nelle sue implementazioni che nel nostro caso sono vuote per semplicità:

```java
public interface Scarpe { }
 
public class ScarpeGinnastica implements Scarpe { }
 
public class ScarpeTennis implements Scarpe { }
```

Di seguito abbiamo l’implementazioni della Factory:

```java
public class Commesso {
    public Scarpe getScarpe(String tipo) {
        
        Scarpe scarpe = null;
        
        if(tipo.equals("ginnastica"))
            scarpe = CommessoGinnastica.getScarpe();
        else if(tipo.equals("tennis"))
            scarpe = CommessoTennis.getScarpe();
        
        return scarpe;
    }
} // ! Commesso
 
public class CommessoGinnastica extends Commesso {
    public static Scarpe getScarpe(){
        return new ScarpeGinnastica();
    }
} // ! CommessoGinnastica

public class CommessoTennis extends Commesso {
    public static Scarpe getScarpe(){
        return new ScarpeTennis();
    }
} // ! CommessoTennis
```

[_Torna all'indice_](#indice)

---

### Prototype
Si tratta di un pattern <u>creazionale</u> basato su oggetti e viene utilizzato per creare un nuovo oggetto clonando un oggetto già esistente detto prototipo. Questo pattern risulta utile affinchè il Client possa creare nuovi oggetti senza conoscerne i dettagli implementativi ma avvalendosi della clonazione. 

>La creazione del clone avviene a RunTime e non a CompileTime, pertanto il clone viene creato in sede di esecuzione.

Durante la creazione del clone dell’oggetto occorre prestare molta attenzione alla creazione degli oggetti annidati. Una classe può contenere al suo interno dei riferimenti ad altre classi, pertanto la clonazione dell’oggetto principale deve effettuare la clonazione anche di tutti gli altri oggetti al suo interno. 

La clonazione dell’intero albero degli oggetti genera un clone detto ***deep-clone*** in quanto copia tutti gli oggetti presenti. Se la clonazione si limita solo all’oggetto principale “contenitore” allora nel clone verranno mantenuti gli stessi riferimenti agli oggetti secondari: in questo caso si parla di ***shallow-clone***.

![[61.png]]

Tale pattern presenta i seguenti vantaggi/svantaggi:
1. <u>Aggiungere / rimuovere prodotti a RunTime:</u> è possibile decidere a Runtime se aggiungere nuovi oggetti.
2. <u>Specificare nuovi oggetti cambiando il loro valore:</u> invece di creare nuove classi per definire nuovi comportamenti, possiamo cambiare il valore di un oggetto per definire un nuovo comportamento. In questo modo vengono ridotti i numeri delle classi.

#### Esempio - Prototype
Come esempio pensiamo al caso in cui vogliamo creare dei template di tabelle di Hash da poter essere facilmente clonate all’occorrenza. In Java una tabella di hash può essere realizzata utilizzando per esempio le classi HashMap, IdentityHashMap, LinkedHashMap ognuna con caratteristiche diverse. Realizziamo una classe astratta Hash e specializziamo le classi di hash di nostro interesse.

Vediamo come si presenta in UML in base all’esempio:

![[62.png]]

La classe astratta Hash implementa l’interfaccia Clonable per dichiarare la propria volontà di clonazione. 

La classe astratta Hash, ereditando di default dalla classe Object, eredita il metodo `protected native Object clone() throws CloneNotSupportedException;` che implementa di default la clonazione. Nel nostro caso richiameremo semplicemente il metodo nativo `super.clone()`:

```java
public abstract class Hash implements Cloneable {
 
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
 
    public abstract void addItem(Object key, Object value);
 
    public abstract int getSize();
 
}
```

Le classi seguenti MyLinkedHashMap, MyHashMap e MyIdentityHashMap ereditano dalla classe Hash ed effettuano l’overriding del metodo `clone()` *SENZA* deep-copy *MA* shadow-copy ossia non duplicano gli oggetti contenuti in esse.

```java
public class MyLinkedHashMap extends Hash {
    private LinkedHashMap hash = new LinkedHashMap();
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return (MyLinkedHashMap) super.clone();
    }
    
    @Override
    public void addItem(Object key, Object value) {
        hash.put(key, value);
    }
    
    @Override
    public int getSize() {
        return hash.size();
    }
}
```

> Le classi MyHashMap e MyIdentityHashMap non vengono implementate nell'esempio perche' sono praticamente uguali a MyLinkedHashMap.

La classe Client ha il compito di invocare il template di interesse e richiedere la clonazione.
Nel nostro esempio viene creato un template della classe MyLinkedHashMap per poi essere popolato con una chiave ed a questo punto viene clonato l’oggetto. Abbiamo fatto una shallow-copy, ossia una clonazione superficiale.

L’oggetto MyLinkedHashMap è stato duplicato e ce ne accorgiamo dal fatto che l’hashcode è diverso.
L’oggetto annidato LinkedHashMap non è stato clonato e ce ne accorgiamo dal fatto che se proviamo ad aggiungere una nuova chiave al template questa viene “ritrovata” anche nell’oggetto clonato.

```java
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
     
        Hash hash = new MyLinkedHashMap();
        hash.addItem("key1", "value1");
        
        System.out.println("Prototype");
        System.out.println("ClassName: " + hash.getClass().getCanonicalName());
        System.out.println("ClassHashCode:" + hash.hashCode());
        
        Hash hashCloned = (MyLinkedHashMap) hash.clone();
        System.out.println("Clone:");
        System.out.println("ClassName: " + hashCloned.getClass().getCanonicalName());
        System.out.println("ClassHashCode:" + hashCloned.hashCode());
        
        System.out.println("Prototype Hashtable size: " + hash.getSize());
        System.out.println("Cloned Hashtable size: " + hashCloned.getSize());
        
        System.out.println("Adding new key");
        hash.addItem("key2", "value2");
        
        System.out.println("Prototype Hashtable size: " + hash.getSize());
        System.out.println("Cloned Hashtable size: " + hashCloned.getSize());
    
    } // ! main()
} // ! Client
```

Output:
```bash
$JAVA_HOME/bin/java patterns.prototype.Client
Prototype
ClassName: patterns.prototype.A
ClassHashCode:16130931
Clone:
ClassName: patterns.prototype.A
ClassHashCode:26315233
Prototype Hashtable size: 1
Cloned Hashtable size: 1
Adding new key
Prototype Hashtable size: 2
Cloned Hashtable size: 2
```

Guardando l’Object Diagram abbiamo questa situazione di condivisione dell’oggetto hash:

![[63.png]]

Per evitare questo problema occorre prevedere la deep-copy definiendo nell’overriding del metodo `clone()` la clonazione anche dell’oggetto annidato. Pertanto in tutte le classi che ereditano direttamente dalla classe astratta Hash modifichiamo il metodo `clone()` in questo modo:

```java
@Override
public Object clone() throws CloneNotSupportedException{
    MyLinkedHashMap myLinkedHashMap = (MyLinkedHashMap) super.clone();
    myLinkedHashMap.hash = (LinkedHashMap) myLinkedHashMap.hash.clone();
    return myLinkedHashMap;
}
```

In questo modo quando eseguiamo la classe Client vediamo che l’inserimento di una nuova chiave nella nostra tabella di hash di template non determina alcuna modifica nella tabella di hash clonata.

Output:
```bash
$JAVA_HOME/bin/java patterns.prototype.Client
Prototype
ClassName: patterns.prototype.MyLinkedHashMap
ClassHashCode:16130931
Clone:
ClassName: patterns.prototype.MyLinkedHashMap
ClassHashCode:23660326
Prototype Hashtable size: 1
Cloned Hashtable size: 1
Adding new key
Prototype Hashtable size: 2
Cloned Hashtable size: 1
```

Guardando l’Object Diagram abbiamo questa situazione di <u>NON</u> condivisione dell’oggetto hash:

![[64.png]]

A seconda della complessità dell’oggetto template ed a seconda dell’alberatura annidata degli oggetti presenti nella classe template, occorrerà ricordarsi di clonare tutti gli oggetti presenti nel template.

[_Torna all'indice_](#indice)

---

### Singleton

![[57.jpg]]

Il singleton è un pattern <u>creazionale</u> che viene utilizzato per mantenere una singola istanza di una classe e fornire un accesso globale a questa. 
L'utilizzo del pattern si presenta quando:
- Deve esistere esattamente una singola istanza di una classe, e deve essere accessibile dal cliente da un punto d'accesso ben preciso.
- Quando soltanto l'istanza della classe deve essere estesa mediante una sottoclasse, che il cliente deve essere in grado di utilizzare senza modificare il codice.

Il singleton è composto da un solo elemento:
- Singleton, che è responsabile della creazione dell'oggetto e definisce un'operazione `getInstance` che permette al cliente di accedere all'istanza univoca della classe.

> Il cliente accede all'istanza univoca mediante l'operazione `getInstance`.

I vantaggi principali sono:
- Accesso controllato ad una singola istanza: questo questo pattern si occupa di encapsulare l'istanza, avendo il controllo completo su di essa e gestendo come/quando i vari clienti possono accederci.
- Riduzione del namespace: il pattern è un miglioramento rispetto alle variabili globali, racchiudendo le variabili all'interno dell'istanza.

#### Tipo reference pre-inizializzato
```java
public class Singleton {
	private static Singleton instance_ = new Singleton();
	
	public static Singleton getInstance(){
		return instance_;
	}
}
```

> Questo caso va bene se il singleton viene usato in un sistema non concorrente (single thread e un unico core).

#### Inizializzazione concorrente
```java
public class Singleton {
	private static Singleton instance_ = null;
	
	public static Singleton getInstace() {
		if(instance_ == null) {
			syncronized(Singleton.class) {
				if(instance_ == null)
					instance_ = new Singleton();
			}
		}
		
		return instance_;
	}
	
	private Singleton() { }
}
```

[_Torna all'indice_](#indice)

---

## Structural Patterns
  
Gli structural design pattern sono un insieme di pattern che si concentrano sulla composizione di classi e oggetti per formare strutture più complesse. Questi pattern sono progettati per gestire la composizione di classi e oggetti in modo flessibile, consentendo la creazione di sistemi più estensibili e riutilizzabili. Ecco una breve panoramica di alcuni degli structural design pattern principali:

1.  **Adapter Pattern (Pattern Adattatore):**
    
    -   **Scopo:** Converte l'interfaccia di una classe in un'altra interfaccia che un cliente si aspetta.
    -   **Utilizzo comune:** Quando si desidera utilizzare una classe esistente che non ha l'interfaccia desiderata.
2.  **Bridge Pattern (Pattern Ponte):**
    
    -   **Scopo:** Separa un'astrazione dalla sua implementazione, consentendo loro di evolvere indipendentemente.
    -   **Utilizzo comune:** Quando si desidera evitare una connessione fissa tra un'astrazione e la sua implementazione.
3.  **Composite Pattern (Pattern Composito):**
    
    -   **Scopo:** Consente di trattare oggetti singoli e composizioni di oggetti in modo uniforme.
    -   **Utilizzo comune:** Per creare strutture ad albero e rappresentare parti-tutto.
4.  **Decorator Pattern (Pattern Decoratore):**
    
    -   **Scopo:** Aggiunge responsabilità a un oggetto dinamicamente.
    -   **Utilizzo comune:** Per estendere le funzionalità di un oggetto in modo flessibile e senza modificare il suo codice.
7.  **Proxy Pattern (Pattern Proxy):**
    
    -   **Scopo:** Fornisce un surrogato o un segnaposto per controllare l'accesso a un oggetto.
    -   **Utilizzo comune:** Per implementare il controllo dell'accesso, il caricamento pigro o la registrazione.

[_Torna all'indice_](#indice)

---

### Adapter
> Conosciuto anche come Wrapper.

Si tratta di un pattern <u>strutturale basato su classi o su oggetti</u> in quanto è possibile ottenere entrambe le rappresentazioni. Viene utilizzato quando si intende utilizzare un componente software ma occorre adattare la sua interfaccia per motivi di integrazione con l’applicazione esistente.

Questo comporta la definizione di una nuova interfaccia che deve essere compatibile con quella esistente in modo tale da consentire la comunicazione con l’interfaccia da “adattare”. In tale contesto possono essere anche effettuate delle trasformazioni di dati per cui l’Adapter si occuperà di interfacciarsi con il nuovo sistema e fornisce anche le regole di mapping dei dati.
Come abbiamo accennato, tale pattern può essere basato sia su classi che su oggetti pertanto l’instanza della classe da adattare può derivare da ereditarietà oppure da associazione.


Questo pattern è composto dai seguenti partecipanti:
- Client: colui che effettua l’invocazione all’operazione di interesse.
- Target: definisce l’interfaccia specifica del dominio applicativo utilizzata dal Client.
- Adaptee: definisce l’interfaccia di un diverso dominio applicativo da dover adattare per l’invocazione da parte del Client.
- Adapter: definisce l’interfaccia compatibile con il Target che maschera l’invocazione dell’Adaptee.

Abbiamo visto precedentemente che il pattern può essere basato su Classi o su Oggetti, in base a questo possiamo schematizzare in UML la relazione esistente tra l’adattatore e l’adattato (Adapter e Adaptee):
1. Sotto forma di ereditarietà come nel caso seguente:
	![[65.png]]
2. Sotto forma di associazione come nel caso seguente:
	![[66.png]]

Tale pattern presenta i seguenti vantaggi/svantaggi:
1. <u>Class Adapter</u>: prevede un rapporto di ereditarietà tra Adapter e Adaptee, in cui Adapter specializza Adaptee, pertanto non è possibile creare un Adapter che specializzi più Adaptee. Se esiste una gerarchia di Adaptee occorre creare una gereachia di Adapter.
2. <u>Object Adapter</u>: prevede un rapporto di associazione tra Adapter e Adaptee, in cui Adapter instanzia Adaptee, pertanto è possible avere un Adapter associato con più Adaptee.

#### Esempio - Adapter
Come esempio pensiamo al caso in cui dobbiamo gestire l’elenco dei dipendenti di una società. I loro dati vengono memorizzati in un java bean dal nome Impiegati che contiene tutte le informazioni personali (nel nostro caso per semplicità indichiamo solo il cognome).

Per effetto di una fusione societaria con una società straniera, il numero dei dipendenti aumenta ed occorre integrare il loro java bean dal nome Employer con quello esistente dal nome Impiegati. Semanticamente è uguale ma sintatticamente è diverso, pertanto creiamo la classe AdattatoreEmployer per adattare la classe Employer.

Sappiamo che possiamo utilizzare sia l’Object Adapter che il Class Adapter: la differenza principale dipende dal fatto che nel secondo caso è richiesta l’ereditarietà multipla e in java non è possibile, o meglio, non è possibile ereditare più classi ma è possibile implementare più interfacce. Questo significa che qualora disponiamo di una interfaccia Target ed un’interfaccia Adaptee possiamo utilizzare anche il Class Adapter.

##### Object Adapter
Per cominciare iniziamo ad implementare Object Adapter per eseguire l’esempio precedente.
Vediamo come si presenta il pattern in UML in base all’esempio nel caso di Object Adapter:

![[67.png]]

A questo punto passiamo a creare la classe Impiegato e la classe Employer:

```java
public class Impiegato {
    private String cognome = null;
    
    public String getCognome() {
        return cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
} // ! Impiegato
```

```java
public class Employer {
    private String lastName = null;
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
} // ! Employer
```

Creiamo la classe Adapter AdattatoreEmployer che eredita la classe Impiegato ed è associata con la classe Employer:

```java
public class AdattatoreEmployer extends Impiegato {
    Employer employer = null;
 
    public AdattatoreEmployer(Employer employer) {
        this.employer = employer;
    }
 
    @Override
    public String getCognome() {
        return employer.getLastName();
    }
 
    @Override
    public void setCognome(String cognome) {
        employer.setLastName(cognome);
    }
} // ! AdattatoreEmployer
```

L’invocazione avviene ad opera della classe Client che passa per l’Adapter per invocare la classe Employer utilizzando gli stessi metodi utilizzati per invocare la classe Impiegato:

```java
public class Client {
    public static void main(String[] args) {
        Impiegato impiegato = new Impiegato();
        impiegato.setCognome("Rossi");
        System.out.println("Impiegato: " + impiegato.getCognome());
        
        AdattatoreEmployer adattatoreEmployer = 
							        new AdattatoreEmployer(new Employer());
        
        adattatoreEmployer.setCognome("Verdi");
        System.out.println("AdattatoreEmployer: " + adattatoreEmployer.getCognome());
    } // ! main()
} // ! Client
```

L’output del Client è mostrato di seguito:
```java
$JAVA_HOME/bin/java patterns.adapter.object.Client
Impiegato: Rossi
AdattatoreEmployer: Verdi
```

##### Class Adapter
Sicuramente più complesso è il caso del Class Adapter.
Vediamo di seguito il Class Diagram che ci mostra che l’Adapter eredita sia da Target che da Adaptee. Nel caso precedente Target ed Adaptee erano due classi, pertanto non era possibile l’ereditarietà multipla in Java, quindi abbiamo previsto due interfacce:
1. Una del Target dal nome InterfacciaImpiegato.
2. Una di Adaptee dal nome InterfacciaEmployer.

![[68.png]]

Le due interfacce definiscono i metodi presenti nelle due organizzazioni:

```java
public interface InterfaceImpiegato {
    public String getCognome();
    public void setCognome(String cognome);
}
```
 
```java
public interface InterfaceEmployer {
    public String getLastName();
    public void setLastName(String lastName);
}
```

Le classi Impiegato ed Employer ereditano dalle due interfacce nel modo seguente:

```java
public class Impiegato implements InterfaceImpiegato {
    private String cognome = null;
    
    @Override
    public String getCognome() {
        return cognome;
    }
    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
```

```java
public class Employer implements InterfaceEmployer {
    private String lastName = null;
    
    @Override
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
```

L’Adapter dal nome AdattatoreEmployer può ereditare dalle due interfacce ed espone i metodi previsti da Target ed Adaptee.

```java
public class AdattatoreEmployer extends Employer 
								implements InterfaceEmployer, InterfaceImpiegato {
								
    @Override
    public String getCognome() {
        return getLastName();
    }
    
    @Override
    public void setCognome(String cognome) {
        setLastName(cognome);
    }
}
```

L’invocazione da parte del Client consente di invocare Employer passando per la classe Adapter AdattatoreEmployer, come nel caso precedente Object Adapter.

```java
public class Client {
    public static void main(String[] args) {
        Impiegato impiegato = new Impiegato();
        impiegato.setCognome("Rossi");
        System.out.println("Impiegato: " + impiegato.getCognome());
        
        AdattatoreEmployer adattatoreEmployer = new AdattatoreEmployer();
        adattatoreEmployer.setCognome("Verdi");
        System.out.println("AdattatoreEmployer: " + adattatoreEmployer.getCognome());
    } // ! main()
} // ! Client
```

L’output della classe Client è il seguente:
```java
$JAVA_HOME/bin/java patterns.adapter.classes.Client
Impiegato: Rossi
AdattatoreEmployer: Verdi
```

[_Torna all'indice_](#indice)

---

### Bridge
Si tratta di un pattern <u>strutturale basato su oggetti</u> che viene utilizzato per disaccoppiare dei componeti software. In questo modo è possibile effettuare uno switch a Run-Time, garantire il disaccoppiamento, nascondere l’implementazione, estendere la specializzazione delle classi.

Per esempio: si vuole cambiare l’interfaccia grafica della nostra applicazione da Motif a XWindow preservando la funzionalità di tutti i componenti grafici: in poche parole si vuole cambiare il LookAndFeel di tutti i tasti ma fare in modo che continuino a fare sempre la stessa cosa.

1. La prima idea, <u>ma errata</u>, sarebbe quella di creare 2 classi per ogni tasto, esempio ButtonXWindow e ButtonMotif; RadioXWindow e RadioMotif e via dicendo.  In questo modo ci sarebbe un proliferare di classi da gestire. Ovviamente se viene introdotto un nuovo LookAndFeel occorrerà inserire tutte le classi di gestione dei tasti nuovi.
	In UML sarebbe così rappresentabile:
	
	![[52.png]]
 Occorre separare la funzionalità e l’estetica, come?

2. Un’altra idea, <u>più corretta</u>, è quella di creare 2 gerachie: una per la funzionalità ed una per l’estetica. 
	La funzionalità è composta dal tasto: Button, Radio.  L’estetica è data dal LookAndFell: XWindow, Motif.
	Per disaccoppiare le gerachie definiamo 2 interfacce: la funzionalità nell’interfaccia Tasti e l’estetica nell’interfaccia LookAndFeel, successivamente possiamo implementare le 2 gerachie creando le classi concrete.
	In UML sarebbe così rappresentabile:
	
	![[53.png]]

**Partecipanti e Struttura**
Questo pattern è composto dai seguenti partecipanti:

1.  **Client**: colui che effettua l’invocazione all’operazione di interesse.
2.  **Abstraction**: definisce l’interfaccia del dominio applicativo utilizzata dal Client.
3.  **RefinedAbstraction**: definisce l’implementazione dell’interfaccia utilizzata.
4.  **Implementor**: definisce l’interfaccia da usare come Bridge e riferibile agli oggetti concreti da utilizzare.
5.  **ConcreteImplementor**: implementa l’interfaccia Implementor usata come Bridge per il transito degli oggetti.

Possiamo schematizzare in UML:

![[54.png]]

**Conseguenze**
Tale pattern presenta i seguenti vantaggi/svantaggi:

1. <u>Disaccoppia l’interfaccia dall’implementazione</u>: disaccoppiando Abstraction e Implementor è possibile gestire i cambiamenti delle classi concrete senza cablare nel codice dei riferiementi diretti.
2. <u>Migliora l’estendibilità</u>: è possibile estendere la gerarchia di Abstraction e Implementor senza problemi.
3. <u>Nasconde l’implementazione al client</u>: il Client non si deve porre il problema di conoscere l’implementazione delle classi concrete.

#### Esempio - Bridge
Facciamo un altro esempio: pensiamo al caso in cui ci rechiamo in un ristorante-pizzeria e facciamo un’ordinazione. Il cameriere addetto alla pizzeria prenderà la nostra ordinazione indipendentemente dal tipo di pizza che scegliamo.

Rappresentiamo questa situazione in questo Class Diagram UML:

![[55.png]]

L’interfaccia Cameriere definisce il metodo ordinazione che prende come parametro il Pasto: nel nostro caso sceglieremo una pizza.

```java
public interface Cameriere {
    Pasto ordinazione(Pasto pasto);
}
```

La classe CamerierePizzeria implementa l’interfaccia Cameriere e ritorna
il tipo di pasto che abbiamo scelto.

```java
public class CamerierePizzeria implements Cameriere {
    public Pasto ordinazione(Pasto pasto) {
        return pasto;
    }
}
```

L’interfaccia Pasto definisce il tipo di piatto, pertanto qualunque pietanza ipotizzabile in un ristorante-pizzeria:

```java
public interface Pasto {
    Pasto getPiatto();
}
```

La classe PizzaCapricciosa implementa come viene fatta la pizza Capricciosa.

```java
public class PizzaCapricciosa implements Pasto {
    public Pasto getPiatto() {
        return this;
    }
}
```

Mentre la classe PizzaMargherita implementa come viene fatta la pizza Margherita.

```java
public class PizzaMargherita implements Pasto {
    public Pasto getPiatto() {
        return this;
    }
}
```

Siamo arrivati alla classe Cliente che effettua l’ordinazione. Il nostro cliente ordina una pizza Margherita al cameriere addetto alle pizze.

```java
public class Cliente {
    public static void main(String[] args) {
        Cameriere cameriere = new CamerierePizzeria();
        Pasto ordinazione = cameriere.ordinazione(new PizzaMargherita());
        System.out.println(ordinazione);
    }
}
```

L’ordine della pizza Margherita è stato eseguito.
Possiamo aggiungere qualunque tipo di pizza implementando l’interfaccia Pasto disaccoppiandola con la classe CamerierePizzeria. Nascondiamo l’implementazione della pizza al cameriere che non è tenuto a sapere come viene fatta.

**Estensione**
Visto e considerato che abbiamo parlato di un ristorante-pizzeria, immaginiamo di avere un angolo ristorante servito da un cameriere diverso da quello della pizzeria. Ovviamente abbiamo anche un menù ristorante che presenta altri piatti oltre alle pizze.
Il cameriere addetto al ristorante implementa il metodo ordinazione dall’interfaccia Cameriere e si chiamerà CameriereRistorante. I pasti del ristorante implementano l’interfaccia Pasto.

Rappresentiamo questa situazione in questo Class Diagram UML:

![[56.png]]

Vediamo come si presenta la classe CameriereRistorante che si occupa di servire i clienti del ristorante.

```java
public class CameriereRistorante implements Cameriere {
    public Pasto ordinazione(Pasto pasto) {
        return pasto;
    }
}
```

Queste invece sono le classi che si occupano di implementare l’interfaccia Pasto per gestire altre pietanze: PastaFagioli e PastaPomodoro .

```java
public class PastaFagioli implements Pasto {
    public Pasto getPiatto() {
        return this;
    }
}
```

```java
public class PastaPomodoro implements Pasto {
    public Pasto getPiatto() {
        return this;
    }
}
```

Eseguiamo la classe Cliente che effettua 2 ordinazioni: PizzaMargherita ed un piatto di PastaPomodoro.

```java
public class Cliente {
    public static void main(String[] args) {
        Cameriere[] cameriere  = new Cameriere[2];
 
        cameriere[0] = new CamerierePizzeria();
        Pasto pasto = cameriere[0].ordinazione(new PizzaMargherita());
        System.out.println(pasto);
 
        cameriere[1] = new CameriereRistorante();
        pasto = cameriere[1].ordinazione(new PastaPomodoro());
        System.out.println(pasto);
    }
}
```

[_Torna all'indice_](#indice)

---

### Composite
Si tratta di un pattern <u>strutturale basato su oggetti</u> che viene utilizzato quando si ha la necessità di realizzare una gerarchia di oggetti in cui l’oggetto contenitore può detenere oggetti elementari e/o oggetti contenitori. L’obiettivo è di permettere al Client che deve navigare la gerarchia, di comportarsi sempre nello stesso modo sia verso gli oggetti elementari e sia verso gli oggetti contenitori.

**Partecipanti e Struttura**
Questo pattern è composto dai seguenti partecipanti:
- Client: colui che effettua l’invocazione all’operazione di interesse.
- Component: definisce l’interfaccia degli oggetti della composizione.
- Leaf: rappresenta l’oggetto foglia della composizione. Non ha figli. Definisce il comportamento “primitivo” dell’oggetto della composizione.
- Composite: definisce il comportamento degli oggetti usati come contenitori ed detiene il riferimento ai componenti “figli”.

In UML, usando il Class Diagram, possiamo schematizzare le relazioni in questo modo:

![[69.png]]

Tale pattern presenta i seguenti vantaggi/svantaggi:
1. <u>Definisce la gerarchia:</u> Gli oggetti della gerarchia possono essere composti da oggetti semplici e/o da oggetti contenitori che a loro volta sono composti ricorsivamente da altri oggetti semplici e/o da oggetti contenitori.
2. <u>Semplifica il client:</u> il Client tratta gli oggetti semplici e gli oggetti contenitori nello stesso modo. Questo semplifica il suo lavoro il quale astrae dalla specifica implementazione.
3. <u>Semplifica la modifica dell’albero gerarchico:</u> l’alberatura è facilmente modificabile aggiungendo/rimuovendo foglie e contenitori.

#### Esempio - Composite
Come esempio pensiamo al FileSystem che presenta una struttura ad albero e che può essere composto da elementi semplici (i files) e da contenitori (le cartelle). L’obiettivo del nostro esercizio è quello di permettere al Client di accedere e navigare il File System senza conoscere la natura degli elementi che lo compongono in modo da consentire al Client di trattare tutti gli elementi nello stesso modo.

Per fare questo il Client userà la stessa interfaccia per l’accesso mentre l’implementazione nasconderà la gestione degli oggetti a seconda della loro reale natura.

Per fare questo schematizziamo la struttura delle classi usando il Class Diagram seguente:

![[70.png]]

Creiamo l’interfaccia di interrogazione per l’accesso a files e cartelle.
Creiamo i metodi add/remove per aggiungere/rimuovere files/cartelle ed il metodo print per visualizzare il suo nome.

```java
public interface MyFileSystem {
    public void add(MyFileSystem myFileSystem);
    public void remove(MyFileSystem myFileSystem);
    public void print();
}
```

Implementiamo la classe che gestisce i Files. In questo caso i metodo `add` e `remove` non sono implementabili.

```java
public class MyFile implements MyFileSystem {
 
    private String myFileName = null;
 
    public MyFile(String myFileName) {
        this.myFileName = myFileName;
    }
 
    @Override
    public void print() {
        System.out.println(myFileName);
    }
 
    @Override
    public void add(MyFileSystem myFileNameSystem) {
        System.out.println("Impossible to add!");
    }
 
    @Override
    public void remove(MyFileSystem myFileNameSystem) {
        System.out.println("Impossible to remove!");
    }
} // ! MyFile
```

Implementiamo la classe che gestisce le Cartelle. In questo caso i metodo add/remove aggiungono/rimuovono nuovi files/cartelle alla cartella corrente.

```java
public class MyFolder implements MyFileSystem {
 
    private String myFolderName;
    private ArrayList<MyFileSystem> folder;
 
    public MyFolder(String myFolderName) {
        this.myFolderName = myFolderName;
        folder = new ArrayList<MyFileSystem>();
    }
 
    @Override
    public void print() {
        System.out.println(myFolderName);
        for (int i = 0; i < folder.size(); i++) {
            folder.get(i).print();
        }
    }
 
    @Override
    public void add(MyFileSystem myFileSystem) {
        folder.add(myFileSystem);
    }
 
    @Override
    public void remove(MyFileSystem myFileSystem) {
        folder.remove(myFileSystem);
    }
} // ! MyFolder
```

Il metodo print viene invocato su tutti gli oggetti dell’albero, siano essi files o cartelle. Il comportamento sarà diverso nei 2 casi. Nella classe MyFile si limita a stampare il nome del file. Nella classe MyFolder, oltre a stampare il nome della cartella, presenta un loop utilizzato per invocare files/cartelle per consentire la ricorsione su tutta l’alberatura del Files System.

```java
folder.get(i).print();
```

La classe Client crea l’alberatura del File System e poi visualizza il suo contenuto.

```java
public class Client {
    public static void main(String[] args) {
        MyFileSystem f2 = new MyFile("F2");
        MyFileSystem f3 = new MyFile("F3");
        MyFileSystem c2 = new MyFolder("C2");
        c2.add(f2);
        c2.add(f3);
 
        MyFileSystem f1 = new MyFile("F1");
        MyFileSystem c1 = new MyFolder("C1");
        c1.add(f1);
        c1.add(c2);
 
        c1.print();
    }
}
```

L’output del Client è il seguente:

```java
$JAVA_HOME/bin/java patterns.composite.Client
C1
F1
C2
F2
F3
```

Graficamente l’albero del File System può essere rappresentato in questo modo:

![[71.png]]

[_Torna all'indice_](#indice)

---

### Decorator
Si tratta di un pattern <u>strutturale basato su oggetti</u> che viene utilizzato per aggiungere a RunTime delle funzionalità ad un oggetto.
In Java, e più in generale nella programmazione ad oggetti, per aggiungere delle funzionalità ad una classe viene utilizzata l’ereditarietà che prevede la creazione di classi figlie che specializzano il comportamento della classe padre ma tutto ciò avviene a CompileTime.

Pertanto se in sede di definizione della struttura delle classi non vengono previste delle specifiche funzionalità, queste non saranno disponibili a RunTime. Al fine di superare questo limite, attraverso la decorazione è possibile aggiungere nuove funzionalità senza dover alterare la struttura delle classi ed i rapporti di parentela in quanto è possibile agire a RunTime per modificare il comportamento di un oggetto.

Per esempio: si vuole conoscere il tempo di esecuzione di un metodo ma tale funzionalità non è prevista nel metodo di nostro interesse. Come fare? Creiamo una classe “Decorator” da invocare al posto della classe originaria e che si occuperà di monitorare il tempo trascorso nell’invocazione del metodo originario. Come? Mantenendo una associazione alla classe originaria e calcolando il tempo di esecuzione del metodo. Vediamo l’esempio in seguito, in sede di implementazione.

**Partecipanti e Struttura**
Questo pattern è composto dai seguenti partecipanti:
- Client: colui che effettua l’invocazione alla funzionalità di interesse.
- Component: definisce l’interfaccia degli oggetti per i quali verranno aggiunte nuove funzionalità.
- ConcreteComponent: definisce un oggetto al quale verrà aggiunta una nuova funzionalità.
- Decorator: definisce l’interfaccia conforme all’interfaccia del Component e mantiene l’associazione con l’oggetto Component.
- ConcreteDecorator: implementa l’interfaccia Decorator al fine di aggiungere nuove funzionalità all’oggetto.

Possiamo schematizzare in UML con il Class Diagram:

![[72.png]]

Tale pattern presenta i seguenti vantaggi/svantaggi:
1. <u>Maggiore flessibilità rispetto alla eredità:</u> permette di aggiungere funzionalità in modo molto più semplice rispetto all’ereditarietà
2. <u>Funzionalità solo se richieste:</u> consente di aggiungere delle funzionalità solo se occorrono realmente senza ereditare una struttura di classi che prevede un insieme di funzionalità di cui se ne utilizzeranno solo una parte. Nel caso in cui tali funzionalità sono anche a pagamento, consente di scegliere solo quelle strettamente necessarie da acquistare, coprendo esigenze di budget.
3. <u>Aumento di micro-funzionalità:</u> la presenza di molte classi Decorator di cui ognuna di esse aggiunge una micro funzionalità, può creare problemi in fase di comprensione o di debug del codice.

#### Esempio - Decorator
Un esempio noto del pattern Decorator lo troviamo nelle librerie java ed esattamente nelle classi di java.io.InputStream in cui i partecipanti sono cosi suddivisi:

- Component: la classe astratta InputStream.
- ConcreteComponent: le classi ByteArrayInputStream, FileInputStream, ObjectInputStream, PipedInputStream, SequenceInputStream e StringBufferInputStream.
- Decorator: la classe FilterInputStream.
- ConcreteDecorator: le classi BufferedInputStream, DataInputStream, LineNumberInputStream e PushbackInputStream.

L’utilizzo di questo pattern consente di poter scegliere la funzionalità di nostro interesse quando occorre leggere uno stream di dati, per esempio utilizzando BufferedInputStream è possibile bufferizzare lo stream.

![[73.png]]

Per esempio, possiamo wrappare la classe concreta FileInputStream di tipo ConcreteComponent con la classe concreta BufferedInputStream di tipo ConcreteDecorator, come nell’esempio seguente:

```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
 
public class FileDecorator {
 
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new BufferedInputStream(
								        new FileInputStream("myFile"));
    }
 
} // ! FileDecorator
```

Riprendiamo ed estendiamo l’esempio iniziale: pensiamo al caso in cui abbiamo l’esigenza di monitorare l’invocazione di un metodo ma non abbiamo la possibilità di modificare il codice. Utilizziamo il pattern Decorator per esigenze di debug pertanto “wrappiamo” un metodo con delle semplici istruzioni print-screen.

Rappresentiamo questa situazione nel Class Diagram:

![[74.png]]

Creiamo l’interfaccia Component che dichiara il metodo interessanto.

```java
public interface MyComponent {
    public void operation();
}
```

Implementiamo il metodo dichiarato nell’interfaccia MyComponent creando la classe ConcreteComponent.

```java
public class ConcreteComponent implements MyComponent {
    public void operation() {
        System.out.println("Hello World");
    }
}
```

Definiamo l’interfaccia MyDecorator che si occupa di ereditare il metodo interessato da MyComponent e di interporsi con le classi di decorazione concrete.

```java
interface MyDecorator extends MyComponent {
}
```

Creiamo la classe LoggingDecorator che implementa l’interfaccia MyDecorator ed aggiunge le informazioni di debug prima e dopo l’esecuzione del metodo interessato.

```java
public class LoggingDecorator implements MyDecorator {
 
    MyComponent myComponent = null;
 
    public LoggingDecorator(MyComponent myComponent){
        this.myComponent = myComponent;
    }

	@Override
    public void operation() {
        System.out.println("First Logging");
        myComponent.operation();
        System.out.println("Last Logging");
    }
} // ! LoggingDecorator
```

La classe Client invoca la classe concreta LoggingDecorator passando al costruttore il componente concreto, successivamente invoca il metodo operation().

```java
class Client {
    public static void main(String[] args) {
        MyComponent myComponent = new LoggingDecorator(new ConcreteComponent());
        myComponent.operation();
    }
}
```
L’output è il seguente:

```java
$JAVA_HOME/bin/java patterns.decorator.Cliente
First Logging
Hello World
Last Logging
```

Partendo dall’esempio, possiamo creare una moltitudine di classi concrete Decorator che aggiungono nuove funzionalità. Per esempio possiamo creare una classe WaitingDecorator che preveda una pausa durante l’esecuzione. Vediamo come diventa il Class Diagram a seguito dell’inseriemento di questa nuova classe.

![[75.png]]

```java
public class WaitingDecorator implements MyDecorator {
 
    MyComponent myComponent = null;
 
    public WaitingDecorator(MyComponent myComponent) {
        this.myComponent = myComponent;
    }
	
	@Override
    public void operation() {
        try {
            System.out.println("Waiting...");
            Thread.sleep(1000);
        }
        catch (Exception e) {}
 
        myComponent.operation();
    }
 
} // ! WaitingDecorator
```

Il Client invoca in modo annidato i Decorator tramite il loro costruttore, come segue:

```java
public class Client {
    public static void main(String[] args) {
        MyComponent myComponent = new LoggingDecorator(
								        new WaitingDecorator(
									        new ConcreteComponent()));
        myComponent.operation();
    }
}
```

L’output è il seguente:

```java
$JAVA_HOME/bin/java patterns.decorator.Cliente
First Logging
Waiting...
Hello World
Last Logging
```

[_Torna all'indice_](#indice)

---

### Proxy
Si tratta di un pattern <u>strutturale basato su oggetti</u> che viene utilizzato per accedere ad un un oggetto complesso tramite un oggetto semplice.

Questo pattern può risultare utile se l’oggetto complesso:
- richiede molte risorse computazionali;
- richiede molto tempo per caricarsi;
- è locato su una macchina remota e il traffico di rete determina latenze ed overhead;
- non definisce delle policy di sicurezze e consente un accesso indiscriminato;
- non viene mantenuto in cache ma viene rigenerato ad ogni richiesta;

In tutti questi casi è possibile disposte delle politiche di gestione e/o di ottimizzazione.

A seconda del contesto, viene aggiunto un prefisso per descrivere il caso di riferimento, esempio:
- Virtual Proxy Pattern: ritarda la creazione e l’inizializzazione dell’oggetto poiché richiede grosse risorse (es: caricamento immagini).
- Remote Proxy Pattern: fornisce una rappresentazione locale dell’oggetto remoto (es: accesso ad oggetto remoto tramite RMI).
- Protection Proxy Pattern: fornisce un controllo sull’accesso dell’oggetto remoto (es: richiesta username/password per l’accesso).
- Smart Proxy Pattern: fornisce una ottimizzazione dell’oggetto (es: caricamento in memoria dell’oggetto).

Il proxy espone gli stessi metodi dell’oggetto complesso che maschera e questo permette di adattare facilmente l’oggetto senza richiedere modifiche.

**Partecipanti e Struttura**
Questo pattern è composto dai seguenti partecipanti:
- Client: colui che effettua l’invocazione all’operazione di interesse.
- SubjectInterface: definisce l’interfaccia utilizzata dal Client che viene implementata dal Proxy e dal RealSubject.
- RealSubject: definisce l’oggetto reale di cui il Proxy avrà il compito di surrogare.
- Proxy: definisce la classe che avrà il compito di surrogare l’oggetto reale mantenendo una Reference a tale oggetto, creando e distruggendo l’oggetto ed esponendo gli stessi metodi pubblici dell’oggetto reale definiti dall’interfaccia.

Possiamo schematizzare in UML:

![[76.png]]

#### Esempio - Proxy
Molti esempi sono presenti nel seguente capitolo [[04-aop]].

[_Torna all'indice_](#indice)

---

## Behavioral Patterns

I design pattern comportamentali, definiti dal Gang of Four (GoF), forniscono soluzioni per organizzare il comportamento delle classi e degli oggetti. Ecco una breve spiegazione di alcuni dei design pattern comportamentali principali:

1.  **Command (Comando):** Il pattern Command incapsula una richiesta come un oggetto, consentendo di parametrizzare client con richieste diverse, accodare richieste, o supportare operazioni annullabili. Consiste di tre componenti principali: il Client (chi emette la richiesta), il Command (l'oggetto che incapsula la richiesta), e il Receiver (l'oggetto che effettua l'azione).
    
2.  **Interpreter (Interprete):** Il pattern Interpreter fornisce un modo per interpretare il linguaggio di un sistema. Definisce una grammatica per il linguaggio e un interprete che utilizza questa grammatica per interpretare frasi del linguaggio. È utile quando c'è la necessità di eseguire operazioni su alberi di sintassi astratta.
    
3.  **Iterator (Iteratore):** L'Iterator pattern fornisce un modo per accedere sequenzialmente agli elementi di una collezione senza esporre i dettagli interni della collezione. Un oggetto iteratore è utilizzato per attraversare gli elementi di una collezione in modo standard, indipendentemente dalla rappresentazione interna della collezione.
    
4.  **Observer (Osservatore):** Il pattern Observer definisce una dipendenza uno a molti tra oggetti in modo che quando uno oggetto cambia stato, tutti i suoi osservatori vengano notificati e aggiornati automaticamente. Gli osservatori si registrano per ricevere notifiche e vengono informati quando avviene un cambiamento nell'oggetto osservato.

1.  **Visitor (Visitatore):** Il pattern Visitor rappresenta un'operazione da eseguire su elementi di una struttura di oggetti senza modificare le classi degli elementi. Definisce un'interfaccia Visitor con un metodo per ogni tipo di elemento che può essere visitato. Le classi concrete implementano questa interfaccia per definire il comportamento specifico quando un elemento viene visitato.

[_Torna all'indice_](#indice)

---

### Command
Si tratta di un pattern <u>comportamentale basato su oggetti</u> e viene utilizzato quando si ha la necessità di disaccoppiare l’invocazione di un comando dai suoi dettagli implementativi, separando colui che invoca il comando da colui che esegue l’operazione.

Tale operazione viene realizzata attraverso questa catena: $Client \to Invocatore \to Ricevitore$
- Il <u>Client</u> non è tenuto a conoscere i dettagli del comando ma il suo compito è solo quello di chiamare il metodo dell’ Invocatore che si occuperà di intermediare l’operazione.
- L’<u>Invocatore</u> ha l’obiettivo di incapsulare, nascondere i dettagli della chiamata come nome del metodo e parametri.
- Il <u>Ricevitore</u> utilizza i parametri ricevuti per eseguire l’operazione

Ma tra l’Invocatore ed il Ricevitore viene posto il Command ossia il comando da eseguire. Il Command è una semplice interfaccia che viene implementata da una o più classi concrete che invocano il Receiver.

**Partecipanti e Struttura**
Questo pattern è composto dai seguenti partecipanti:
- Client: colui che richiede il comando ed imposta il Receiver.
- Invoker: colui che effettua l’invocazione del comando.
- Command: interfaccia generica per l’esecuzione del comando.
- ConcreteCommand: implementazione del comando che consente di collegare l’Invoker con il Receiver.
- Receiver: colui che riceve il comando e sa come eseguirlo.

![[77.png]]

**Tale pattern presenta i seguenti vantaggi/svantaggi:**
1. <u>Riduce l’accoppiamento</u>: il Command disaccoppia l’Invoker dal Receiver, ossia colui che invoca da colui che esegue facendo in modo che i dettagli implementativi siano a conoscenza solo del Receiver.
2. <u>Facile estendibilità</u>: è possibile aggiungere facilmente nuovi comandi implementando l’interfaccia Command

#### Esempio - Command

![[78.png]]

Creiamo un’interfaccia Ordine che funge da comando, dopo di chè creiamo una classe magazzino che funge da richiesta. Inoltre creiamo le classi concrete Compra e Vendi che implementano l’interfaccia Ordine, la quale eseguirà la vera elaborazione dei comandi.

Infine, creiamo la classe command che funge da invoker, la classe può prendere ed effettuare ordini. La classe identifica l’oggetto  che eseguirà il comando in funzione del tipo.

Step 1: Creiamo l’interfaccia Ordine

```java
public interface Ordine {
    void esegui();
}
```

Step 2: Creiamo la classe Magazzino, che funge da richiesta

```java
public class Magazzino {

    private String nome = "Prodotto_x";
    private int quantità = 25;

    public void compra(){
        System.out.println("[MAGAZZINO]: [ NOME: " + nome + ", QUANTITA': " + quantità + " ] COMPRATO");
    }
    public void vendi(){
        System.out.println("[MAGAZZINO]: [ NOME: " + nome + ", QUANTITA': " + quantità + " ] VENDUTO");
    }
    
} // ! Magazzino
```

Step 3: Creiamo le classi concrete che estendono l’interfaccia

```java
public class Compra implements Ordine {
    private Magazzino magazzino;

    public Compra(Magazzino magazzino){
        this.magazzino = magazzino;
    }

	@Override
    public void esegui() {
        magazzino.compra();
    }
}
```

```java
public class Vendi implements Ordine {
    private Magazzino magazzino;

    public Vendi(Magazzino magazzino){
        this.magazzino = magazzino;
    }

	@Override
    public void esegui() {
        magazzino.vendi();
    }
}
```

Step 4: Creiamo la classe Command

```java
import java.util.ArrayList;
import java.util.List;

public class Command {
    private List ordineList = new ArrayList();
    
    public void prendiOrdine(Ordine order){
        ordineList.add(order);
        System.out.println("[COMMAND]: prendiOrdine()::Ordine aggiunto alla lista!");
    }
    
    public void piazzaOrdine(){
        for (Ordine ordine : ordineList) {
            ordine.esegui();
        }
        System.out.println("[COMMAND]: piazzaOrdine()::Ordini eseguiti!");
        ordineList.clear();
    }
} // ! Command
```

Step 5: Creiamo il Client

```java
public class Client {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino();

        Ordine compraOrdine = new Compra(magazzino);
        Ordine vendiOrdine = new Vendi(magazzino);

        Command broker = new Command();
        broker.prendiOrdine(compraOrdine);
        broker.prendiOrdine(vendiOrdine);

        broker.piazzaOrdine();
    }
}
```

Output

```java
[COMMAND]: prendiOrdine()::Ordine aggiunto alla lista!
[COMMAND]: prendiOrdine()::Ordine aggiunto alla lista!
[MAGAZZINO]: [ NOME: Prodotto_x, QUANTITA': 25 ] COMPRATO
[MAGAZZINO]: [ NOME: Prodotto_x, QUANTITA': 25 ] VENDUTO
[COMMAND]: piazzaOrdine()::Ordini eseguiti!
```

[_Torna all'indice_](#indice)

---

### Interpreter
Si tratta di un pattern <u>comportamentale basato su classi</u> e viene utilizzato quando si vuole definire una grammatica e il relativo interprete. La grammatica è costituita da tutte le espressioni che possono essere utilizzate mentre l’interprete permette di valutare il risultato complessivo.

Pensiamo ad una lingua straniera, per esempio lo spagnolo, che è costituita da una serie di vocabili e da regole grammaticali che disciplinano il loro ordine ed uso. Un interprete conoscendo i vocabili e le regole grammaticali riuscirà a capire il significato di una frase. Anche la matematica può essere usata come metafora, in cui i numeri rappresentano i dati e le operazioni rappresentano le funzioni, entrambi devono essere disposti secondo un preciso ordine quindi dovranno rispettare delle regole sintattiche. Un matematico è colui che conoscendo queste regole sarà in grado di capire il risultato di una operazione.
Pensiamo per esempio ad una semplice addizione: 3 + 4. In questo caso la grammatica è costituita da 2 espressioni: dai numeri “3” e “4” e dall’operatore  “+”,  l’interprete analizza le espressioni per ottenere il risultato, ossia “7”.

Il termine “espressione” è utilizzato per definire un simbolo ed il suo comportamento.
- *Nel caso di un numero*: il simbolo è costituito da un carattere rappresentato dauno o più di questi valori  “0123456789” mentre il comportamento è costituito dal valore del simbolo quindi il carattere “1” ha il valore del numero 1 ( in Java `Integer.parseInt(“1”)`).
- *Nel caso di operazioni aritmentiche*: l’addizione utilizza il simbolo “+” ed il suo comportamento è costituito dall’operazione di  somma.

Le espressioni possono essere semplici o composte a seconda che aggregano o meno altre espressioni e vengono definite:
- Terminali: quando definiscono in modo autonomo il comportamento, come nel caso di un numero che definisce il suo simbolo ed il suo comportamento
- Non terminali: quando dipendono da altre espressioni, come nel caso dell’addizione che definisce il suo simbolo ma il suo comportamento è associato ai numeri utilizzati per effettuare la somma.

Quindi possiamo creare una nostra calcolatrice elementare, per fare questo dobbiamo definire una grammatica costituita da numeri ed operazioni aritmetiche, pertanto abbiamo bisogno di 5 espressioni: numeri, addizioni, sottrazioni, moltiplicazioni e divisioni. Tali espressioni vengono valutare da un interprete che elabora il risultato.

Di seguito vediamo un esempio che utilizza questo pattern per realizzare una semplice calcolatrice.

**Partecipanti e Struttura**
Questo pattern è composto dai seguenti partecipanti:
- Client: colui che costruisce un albero sintattico costituito da TerminalExpression e NonTerminalExpression che dovrà essere elaborato dall’interprete.
- Context: contiene le informazioni che l’interprete dovrà utilizzare.
- AbstractExpression: definisce un comportamento astratto che le espressioni devono implementare.
- TerminalExpression: implementa il comportamento dell’espressione semplice.
- NonterminalExpression: implementa il comportamento dell’espressione composta richiamando il comportamento delle espressioni semplici.

![[79.png]]

**Tale pattern presenta i seguenti vantaggi/svantaggi:**
1. <u>Facilità nel cambiare la grammatica</u>: attraveso l’estensione delle classi è possibile inserire e modificare la grammatica.
2. <u>Difficoltà nel gestire una grammatica complessa</u>: quando la grammatica contiene molte regole risulta molto complicato riuscire a gestirla e comprendere il flusso dell’albero sintattico.

#### Esempio - Interpreter
Realizziamo una calcolatrice che utilizza tutte e quattro le operazioni aritmentiche elementari. In questo caso inseriamo gli elementi in un modo più intuitivo utilizzando il classico metodo “infisso” cioè numero, operatore, numero, operatore ecc, così come facciamo quando utilizziamo la calcolatrice.
In questo modo possiamo sia usare sempre lo stesso operatore ($5 + 7 + 9$) che usare diversi operatori ( $3 + 4 - 2 * 6$ ). Ovviamente dobbiamo creare delle classi che gestiscono tutte e quattro le operazioni aritmetiche e lasciare al client l’ordine in cui tali operazioni vengono svolte ($3-4+6$ oppure $3+4-6$).

> Solitamente ai fini computazionali il metodo “infisso” è poco usato e si preferisce usare il metodo “prefisso” o “postfisso” per motivi prestazionali, in quanto questi metodi utilizzano meglio la memoria e consentono una migliore gestione delle priorità degli operatori.

Vediamo come si presenta il pattern in UML in base all’esempio della calcolatrice:

![[80.png]]

L’interfaccia Espressione definisce il metodo “interpreta” che le classi concrete dovranno implementare.

```java
public interface Espressione {
    public int interpreta(Contesto operazione);
}
```

La classe Contesto prevede la gestione dell’operazione corretta in base all’operatore.  Il metodo revOperazione è utilizzato per invertire l’ordine dello Stack e processare i numeri e gli operatori nell’ordine di inserimento.

```java
public class Contesto {
 
    private Stack numeri = null;
    private Stack operatori = null;
 
    public Contesto(String operazione) {
        this.numeri = new Stack();
        this.operatori = new Stack();
 
        for (String token : revOperazione(operazione)) {
            if (token.equals("+")) {
                operatori.add(new Addizione());
            } else if (token.equals("-")) {
                operatori.add(new Sottrazione());
            } else if (token.equals("/")) {
                operatori.add(new Divisione());
            } else if (token.equals("*")) {
                operatori.add(new Moltiplicazione());
            } else {
                numeri.add(new Numero(token));
            }
        }
    }
 
    public Espressione getNumero() {
        return numeri.pop();
    }
 
    public void setNumero(Espressione exp) {
        numeri.push(exp);
    }
 
    public Espressione getOperatore() {
        return operatori.pop();
    }
 
    private String[] revOperazione(String operazione) {
        List listOperation = Arrays.asList(operazione.split(" "));
        Collections.reverse(listOperation);
        return (String[]) listOperation.toArray();
    }
} // ! Contesto
```

La classe Numero è il primo esempio di una classe concreta e terminale che identifica il simbolo del numero e memorizza il suo valore.
```java
public class Numero implements Espressione {
    private int numero;
    
    public Numero(String numero){
        this.numero = Integer.parseInt(numero);
    }
 
    @Override
    public int interpreta(Contesto contesto) {
        return numero;
    }
}
```

La classe Addizione:
```java
public class Addizione implements Espressione {
 
    @Override
    public int interpreta(Contesto contesto) {
        int risultato = contesto.getNumero().interpreta(contesto) + 
				        contesto.getNumero().interpreta(contesto);
        contesto.setNumero(new Numero(risultato + ""));
        return risultato;
    }
}
```

La stessa cosa viene effettuata anche per la classe Sottrazione:

```java
public class Sottrazione implements Espressione {
 
    @Override
    public int interpreta(Contesto contesto) {
        int risultato = contesto.getNumero().interpreta(contesto) - 
				        contesto.getNumero().interpreta(contesto);
        contesto.setNumero(new Numero(risultato + ""));
        return risultato;
    }
 
}
```
La classe Moltiplicazione:

```java
public class Moltiplicazione implements Espressione {
 
    @Override
    public int interpreta(Contesto contesto) {
        int risultato = contesto.getNumero().interpreta(contesto) * 
				        contesto.getNumero().interpreta(contesto);
        contesto.setNumero(new Numero(risultato + ""));
        return risultato;
    }
 
}
```

La classe Divisione:

```java
public class Divisione implements Espressione {
 
    @Override
    public int interpreta(Contesto contesto) {
        int risultato = contesto.getNumero().interpreta(contesto) / 
				        contesto.getNumero().interpreta(contesto);
        contesto.setNumero(new Numero(risultato + ""));
        return risultato;
    }
 
}
```

La classe Client definisce l’operazione da effettuare e la inserisce nel Contesto, poi esegue le operazioni presenti: addizione, sottrazione, divisione, moltiplicazione attraverso il riconoscimento (interpretazione) dell’operazione

```java
public class Client {
 
    public static void main(String[] args) {
        //Contesto delle variabili ed operatori
        String operazione = "45 + 38 - 13 / 21 * 16";
        Contesto contesto = new Contesto(operazione);
 
        //Risultato
        int risultato = 0;
        while (true) {
            try {
                Espressione operatore = contesto.getOperatore();
                risultato = operatore.interpreta(contesto);
            } catch (java.util.EmptyStackException ese) {
                break;
            }
        }
        System.out.println(operazione + " = " + risultato );
    }
} // ! Client
```

Il risultato è lo svolgimento dell’operazione.
```java
$JAVA_HOME/bin/java patterns.interpreter.calcolatrice.Client
45 + 38 - 13 / 21 * 16 = 48
```

> Altro esempio: esercizio 8 visto a lezione.

[_Torna all'indice_](#indice)

---

### Iterator
Si tratta di un pattern <u>comportamentale basato su oggetti</u> e viene utilizzato quando, dato un aggregato di oggetti, si vuole accedere ai suoi elementi senza dover esporre la sua struttura. L’obiettivo di questo pattern è quello di disaccoppiare l’utilizzatore e l’implementatore dell’aggregazione di dati, tramite un oggetto intermedio che esponga sempre gli stessi metodi indipendentemente dall’aggregato di dati.

E’ costituito da 3 soggetti: l’_Utilizzatore_ dei dati, l’_Iteratore_ che intermedia i dati e l’_Aggregatore_ che detiene i dati secondo una propria logica.

**Partecipanti e Struttura**  
Questo pattern è composto dai seguenti partecipanti:
-   **Iterator**: colui che espone i metodi di accesso alla struttura dati.
-   **ConcreteIterator**: implementa l’Iteratore e tiene il puntatore alla struttura dati.
-   **Aggregator**: definisce l’interfaccia per creare un oggetto di tipo Iteratore.
-   **ConcreteAggregator**: implementa l’interfaccia di creazione di un oggetto Iteratore.

![[81.png]]

**Tale pattern presenta i seguenti vantaggi/svantaggi:**
- Unica interfaccia di accesso: l’accesso ai dati avviene tramite l’Iterator che espone un’unica interfaccia e nasconde le diverse implementazioni degli Aggregator.
- Diversi iteratori di accesso: l’Aggregator può essere attraversato tramite diversi Iterator in cui ogni Iterator nasconde un algoritmo diverso.

#### Esempio - Iterator
Creeremo un’interfaccia Iterator che narra il metodo di navigazione e un’interfaccia Container che ritrasforma l’iteratore. Dopo di chè creeremo le classi concrete che implementano le due interfacce.

Step 1: Creiamo le due interfacce
```java
public interface Container {
    public Iterator getIterator();
}
```
```java
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
```

Step 2: Creiamo la classe Repository che implementa l’interfaccia Container

Attenzione! La classe possiede all’interno un’altra classe il cui scopo è quello di implementare Iterator.

```java
public class NameRepository implements Container {
   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

   @Override
   public Iterator getIterator() {
      return new InnerNameIterator();
   }

   private class InnerNameIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
         if(index < names.length)
            return true;
    
         return false;
      }

      @Override
      public Object next() {
         if(this.hasNext())
            return names[index++];
        
         return null;
      }
      
   } // ! InnerNameIterator
} // ! NameRepository
```

Step 3: Creiamo il main

```java
public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();

        System.out.println("[MAIN]: Recupero nomi in Repository");
        
        for(Iterator iterator = repository.getIterator(); iterator.hasNext();){
            String name = (String) iterator.next();
            System.out.println("[MAIN]: Nome -> " + name);
        }
    }
}
```

Output:

```java
[MAIN]: Recupero nomi in Repository
[MAIN]: Nome -> Roberto
[MAIN]: Nome -> Giovanni
[MAIN]: Nome -> Giulia
[MAIN]: Nome -> Andrea
```

[_Torna all'indice_](#indice)

---

### Observer
Si tratta di un pattern <u>comportamentale basato su oggetti</u> che viene utilizzato quando si vuole realizzare una dipendenza uno-a-molti in cui il cambiamento di stato di un soggetto venga notificato a tutti i soggetti che si sono mostrati interessati.  
Un esempio molto semplice è rappresentato dalle newsletters in cui gli utenti interessati a degli argomenti inseriscono il loro indirizzo email ed a fronte di novità inerenti gli argomenti, riceveranno una email di notifica. In questo modo viene applicata una gestione ad eventi, cioè al verificarsi di una notizia i soggetti interessati verranno informati tramite email. In questo modo l’interessato evita di fare polling, cioè evita di fare continue richieste al soggetto osservato per sapere se è avvenuto o meno un cambiamento ma al contrario verrà notificato in push dal soggetto osservato nel caso in cui dovesse interviene una modifica.

Questo pattern viene impegato in molte librerie, nei toolkit delle GUI e nel pattern architetturale MVC.

Nel pattern MVC abbiamo la presenza di 3 soggetti: il Model, la View ed il Controller. Questi soggetti svolgono compiti diversi e tra di loro è presente una separazione di responsabilità c.d. “separation of concern”. Ma c’è da dire che tra di loro esiste un forte legame in merito al cambiamento di stato. In particolare il Controller è interessato ai cambiamenti di stato della View, mentre la View è interessata ai cambiamenti di stato del Model. Questo comporta che nel caso in cui dovessero avvenire dei cambiamenti il Model notifica alla View mentre la View notifica al Controller. Quindi il pattern Observer trova applicazione 2 volte nell’MVC su coppie di soggetti diversi (Model-View e View-Controller). La View svolge un ruolo doppio poichè si trova ad essere _osservata_ dal Controller e nello stesso tempo ad essere _osservatore_ nei confronti del Model. A differenza del Model e del Controller che invece giocano un ruolo singolo , infatti il Model è _osservato_ dalla View mentre il Controller è un _osservatore_ della View.

![[82.png]]

Il ruolo di osservatore è il ruolo svolto da colui che si mostra interessato ai cambiamenti di stato, c.d. Observer. Il ruolo di osservato è il ruolo svolto da colui che viene monitorato, c.d. Subject o Observable.

**Partecipanti e Struttura**  
Questo pattern è composto dai seguenti partecipanti:
1.  **Subject**: espone l’interfaccia che consente agli osservatori di iscriversi e cancellarsi; mantiene una reference a tutti gli osservatori iscritti
2.  **Observer**: espone l’interfaccia che consente di aggiornare gli osservatori in caso di cambio di stato del soggetto osservato.
3.  **ConcreteSubject**: mantiene lo stato del soggetto osservato e notifica gli osservatori in caso di un cambio di stato.
4.  **ConcreteObserver**: implementa l’interfaccia dell’Observer definendo il comportamento in caso di cambio di stato del soggetto osservato

**Tale pattern presenta i seguenti vantaggi/svantaggi:**
-   <u>Astratto accoppiamento tra Subject e Observer</u>: il Subject sa che una lista di Observer sono interessati al suo stato ma non conosce le classi concrete degli Observer, pertanto non vi è un accoppiamento forte tra di loro.
-   <u>Notifica diffusa</u>: il Subject deve notificare a tutti gli Observer il proprio cambio di stato, gli Observer sono responsabili di aggiungersi e rimuoversi dalla lista.

  
Vediamo come si presenta il Pattern Observer utilizzando il Class Diagram in UML:

![[83.png]]

#### Esempio - Observer
Nnelle librerie Java il _Subject_ e l’_Observer_ sono già presenti con le classi _java.util.Observable e java.util.Observer_.

![[84.png]]

Pertanto, per non reinventare la ruota ogni volta, possiamo utilizzare queste classi per il nostro esempio. 

Vediamo come si presenta il nostro Class Diagram in UML:

![[85.png]]

Creiamo la classe ConcreteObserver implementando l’interfaccia Observer che definisce il metodo `update()` con 2 parametri: il soggetto osservato Observable ed un Object utile a passare degli argomenti.

```java
import java.util.Observable;
import java.util.Observer;
 
public class ConcreteObserver implements Observer {
 
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Sono " + this + ": il Subject e stato modificato!");
    }
	// In questo caso o == this
}
```

Modifichiamo la classe ConcreteSubject in modo che estenda la classe Observable. Nel metodo `setState()` occorre invocare anche il metodo `setChanged()` che esprime la volontà di notificare gli osservatori. Infatti se commentiamo questo metodo, gli osservatori non saranno notificati nonostante l’invocazione del metodo `notifyObservers().` Ciò avviene in quanto nel metodo `notifyObservers()` è presente una semplice condizione `if (!changed)` che forza l’uscita dal metodo qualora il cambio non venga confermato.

```java
import java.util.Observable;
 
public class ConcreteSubject extends Observable {
 
    private boolean state;

	@Override
    public void setState(boolean state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }

	@Override
    public boolean getState() {
        return this.state;
    }
 
} // ! ConcreteSubject
```

Adesso vediamo il codice del metodo `notifyObservers()` della classe `java.util.Observable`:

```java
public void notifyObservers(Object arg) {
    Object[] arrLocal;
    
    synchronized (this) {
        if (!changed)
            return;
        
        arrLocal = obs.toArray();
        clearChanged();
    }
    
    for (int i = arrLocal.length - 1; i >= 0; i--)
        ((Observer) arrLocal[i]).update(this, arg);
}
```

Creiamo il codice del Client importando `java.util.Observer` e rinominando il metodo `deleteObserver()` invece di `removeObserver()` dell’esempio precedente:

```java
import java.util.Observer;
 
public class Client {
 
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
 
        //aggiungo 2 observer che saranno notificati
        subject.addObserver(observer1);
        subject.addObserver(observer2);
 
        //modifico lo stato
        subject.setState(true);
 
        //rimuovo il primo observer che non sarà + notificato
        subject.deleteObserver(observer1);
 
        //modifico lo stato
        subject.setState(false);
 
    }
} // ! Client
```

Output:
```java
$JAVA_HOME/bin/java patterns.Client
Sono patterns.observer.ConcreteObserver@f62373: il Subject e' stato modificato!
Sono patterns.observer.ConcreteObserver@19189e1: il Subject e' stato modificato!
Sono patterns.observer.ConcreteObserver@f62373: il Subject e' stato modificato!
```

[_Torna all'indice_](#indice)

---

### Visitator
Si tratta di un pattern <u>comportamentale basato su oggetti</u> e viene utilizzato per eseguire delle operazioni sugli elementi di una struttura. L’utilizzo di questo pattern consente di definire le operazioni di un elemento senza doverlo modificare.

**Ma com’è possibile?**
Solitamente ogni classe definisce le proprie proprietà e le proprie operazioni nel rispetto del principio della singola responsabilità (SRP) ed usando il concetto di ereditarietà può condividere le operazioni alle classi figlie.  

**Ma cosa succede se ci accorgiamo a posteriori che dobbiamo introdurre una nuova operazione?**
- Se le operazioni sono state definite a *livello di classe*, l’introduzione di un nuovo metodo comporterà la modifica della classe interessata, violando il principio open-closed (OCP).
- Se le operazioni sono state definite a *livello di interfaccia*, l’introduzione di un nuovo metodo comporterà la modifica di tutte le classi figlie.

<u>Ovviamente se questa situazione si presenta frequentemente, la manutenzione del codice non sarà agevole.</u>

**Per evitare questo problema** sarà possibile seguire un’altra strada, ossia disaccoppiare gli oggetti che definiscono lo stato dagli oggetti che definiscono il comportamento ed in questo modo sarà più semplice inserire nuovi metodi.  
Il pattern Visitor ci consente di implementare questa separazione tra stato e comportamento e realizzare il legame tra questi oggetti tramite la definizione di 2 metodi presenti nelle due strutture.

1.  Nella _prima struttura_, che definisce lo stato, è presente il metodo `accept()` che invoca il metodo `visit()`.
2.  Nella _seconda struttura_, che definisce il comportamento, è presente il metodo `visit()`.

In questo modo sarà possibile aggiungere nuove operazioni semplicemente definendo nuove classi nella seconda struttura che si occuperà poi di elaborare lo stato della prima.

Vediamo la rappresentanzione UML usando il Class Diagram:

![[48.png]]

Pertanto, parlando in termini del pattern Visitor:  
In base alla competenza:
1.  la _prima struttura_ definisce gli _Element_ che detengono lo <u>stato</u>.
2.  la _seconda struttura_ definisce i _Visitor_ che detengono i <u>comportamenti</u>.

In base all’ordine di invocazione:
1.  Il Client invoca il metodo `accept()` presente nell’_Element_ passandogli in ingresso un oggetto _Visitor_.
2.  L’_Element_ invoca il metodo `visit()` del Visitor passandogli se stesso (oggetto `this`) come parametro.
3.  Il _Visitor_, disponendo della referenza all’_Element_ (tramite l’oggetto `this`) accede alle proprietà dell’Element ed eseguire le operazioni.

Vediamo la rappresentanzione UML usando il Sequence Diagram:

![[49.png]]

Questo pattern utilizza la tecnica del [Double Dispatch](https://dellabate.wordpress.com/2012/11/28/simple-double-e-multi-dispatch/) al fine di consentire questo scambio di messaggi tra l’Element ed il Visitor, pertanto risulta un po’ complesso considerando che utilizza polimorfismo, overriding ed overloading.

**Partecipanti e Struttura**  
Questo pattern è composto dai seguenti partecipanti:
-   _Element_: definisce il metodo `accept()` che prende un Visitor come argomento.
-   _ConcreteElement_: implementa un oggetto Element che prende un Visitor come argomento.
-   _ObjectStructure_: contiene una collezione di Element che può essere visitata dagli oggetti Visitor.
-   _Visitor_: dichiara un metodo `visit()` per ogni Element; il nome del metodo ed il parametro identificano la classe Element che ha effettuato l’invocazione.
-   _ConcreteVisitor_: implementa il metodo `visit()` e definisce l’algoritmo da applicare per l’Element passato come parametro.

Vediamo come si presenta il Pattern Visitor utilizzando il Class Diagram in UML:

![[50.png]]

**Conseguenze**  
Tale pattern presenta i seguenti vantaggi/svantaggi:

-  <u>Facilità nell’aggiungere nuovi Visitor</u>: definendo un nuovo Visitor sarà possibile aggiungere una nuova operazione ad un Element.

-  <u>Difficoltà nell’aggiungere nuovi Element</u>: definire un nuovo Element comporterà la modifica dell’interfaccia Visitor e di tutte le implementazioni.

-  <u>Separazione tra stato ed algoritmi</u>: gli algoritmi di elaborazioni sono nascosti nelle classi Visitor e non vengono esposti nelle classi Element.

-  <u>Iterazione su struttura eterogenea</u>: la classe Visitor è in grado di accedere a tipi diversi, senza la necessità che tra di essi ci sia un vincolo di parentela. In poche parole, il metodo `visit()` può definire come parametro un tipo $X$ oppure un tipo $Y$ senza che tra di essi ci sia alcuna relazione di parentela, diretta o indiretta.

-  <u>Accumulazione dello stato</u>: un Visitor può accumulare delle informazioni di stato a seguito dell’attraversamento degli Element.

-  <u>Violazione dell’incapsulamento</u>: i Visitor devono poter accedere allo stato degli Element e questo può comportare la violazione dell’incapsulamento.

#### Esempio - Visitor
Calcoliamo l'area e il perimetro di un rettangolo utilizzando il design pattern Visitor.

![[51.png]]

Definiamo l'interfaccia Visitor:
```java
public interface Visitor {
	public void visitRettangoloArea(ElementRettangolo element);
	public void visitRettangoloPerimetro(ElementRettangolo elemento);
}
```

Implementiamo la classe VisitorRettangoloArea. Ovviamente il metodo relativo al calcolo del perimetro non dovrà essere implementato:

```java
public class VisitorRettangoloArea implements Visitor {
    @Override
    public void visitRettangoloArea(ElementRettangolo element) {
        int area = element.getAltezza() * element.getLarghezza();
        System.out.println("L'area del rettangolo e': " + area);
    }
    @Override
    public void visitRettangoloPerimetro(ElementRettangolo element) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
```

Adesso definiamo l’altro Visitor, VisitorRettangoloPerimetro, che si occupa di calcolare il perimentro del rettangolo:

```java
public class VisitorRettangoloPerimetro implements Visitor {
    @Override
    public void visitRettangoloArea(ElementRettangolo element) {
        throw new UnsupportedOperationException("Not supported.");
    }
    @Override
    public void visitRettangoloPerimetro(ElementRettangolo element) {
        int per = element.getAltezza() + elemento.getLarghezza();
        per = per * 2;
	    System.out.println("Il perimetro del rettangolo e': " + per);
    }
}
```

Adesso nella classe Element, ElementRettangolo, definiamo un comportamento diverso a seconda dell’oggetto passato come paramentro al metodo `accept()`:
```java
public class ElementRettangolo {
    private int altezza;
    private int larghezza;
 
    public int getAltezza() {
        return this.altezza;
    }
 
    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
 
    public int getLarghezza() {
        return this.larghezza;
    }
 
    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }
 
    public void accept(Visitor visitor) {
        if (visitor instanceof VisitorRettangoloArea)
            visitor.visitRettangoloArea(this);
        else if (visitor instanceof VisitorRettangoloPerimetro)
            visitor.visitRettangoloPerimetro(this);
    }
}
```

Infine nella classe Client possiamo invocare il nostro Client che si occupa di creare il rettangolo e successivamente di invocare le operazioni relative al calcolo dell’aria e del perimetro in base al tipo di Visitor che viene passato: 

```java
public class Client {
    public void test() {
        ElementRettangolo element = new ElementRettangolo();
        
        element.setAltezza(10);
        element.setLarghezza(20);
        
        element.accept( new VisitorRettangoloPerimetro() ); // 60
        element.accept( new VisitorRettangoloArea() ); // 200
    }
}
```

[_Torna all'indice_](#indice)