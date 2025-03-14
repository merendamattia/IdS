# Indice
```table-of-contents
```
 ---

## Sistemi concorrenti
Un software si dice concorrente se la sua computazione è ottenuta dalla composizione di sotto-programmi eseguiti in modo sequenziale indipendenti l'uno dagli altri, i quali possono essere eseguiti in parallelo sotto regole specifiche che impongono una sequenzializzazione delle parti che li compongono.
La computazione di un sistema concorrente è strutturato nei termini di un insieme di flussi eseguiti indipendentemente.
> Ogni flusso di esecuzione effettua una computazione sequenziale.

La descrizione statica di un software concorrente è descritta nei termini di un insieme di programmi concorrenti:
- Ogni programma concorrente descrive alcuni dei flussi di esecuzione del sistema concorrente.
- Ogni programma concorrente descrive alcuni dei vincoli di sequenzializzazione dovuti durante i flussi di esecuzione.

La descrizione delle computazioni sequenziali associate con i flussi di esecuzione sono presenti in un programma che usa un linguaggio di programmazione.
Se il linguaggio di programmazione adottato permette la descrizione esplicita oltre ai vincoli di sequenzializzazione dovuti, allora questo linguaggio è un linguaggio di programmazione concorrente.

[_Torna all'indice_](#indice)

---

## Sistemi concorrenti in Java
Java è un linguaggio di programmazione concorrente. Offre costrutti del linguaggio per esprimere i vincoli di sequenzializzazione basici.
Pattern complessi di sequenzializzazione possono essere espressi come la combinazione di diversi costrutti.

### Processi 
Un processo (concorrente) è un programma (concorrente) in esecuzione:
- Un programma è un documento statico che descrive il comportamento in fase di esecuzione di un processo.
- Un processo è una entità dinamica che esegue un programma usando un insieme particolare di dati e risorse.
- Due o più processi possono eseguire lo stesso programma, ognuno dei quali usando le proprie risorse e i propri dati.

Un processo comprende sempre i seguenti componenti:
1. Un programma da essere eseguito.
2. I dati grazie ai quali il programma verra' eseguito.
3. Le risorse richieste da un processo a tempo di esecuzione.
4. Lo stato di un processo in esecuzione.

Un processo (in Java) viene eseguito in un ambiente astratto che gestisce i dati condivisi e isolati e le risorse attraverso la "community" dei processi. La Java Virtual Machine (JVM) offre questo ambiente astratto per i processi.
> Una JVM per ogni processo.
 
![[33.png]]

[_Torna all'indice_](#indice)

### Threads
Un thread è il flusso di esecuzione di un processo:
- Ogni thread è associato con un singolo processo.
- Molti thread possono essere associati ad un singolo processo.
- Un thread esegue parti di un programma associati con il suo processo e condivise dati e risorse  con quest'ultimo.
- Un thread alloca dinamicamente parti delle risorse di un processo per il suo fabbisogno computazionale.
- Ogni thread ha la sua area privata per salvare dati e strati.

Un processo sequenziale ha un singolo thread.
Una memoria condivisa è visibile a tutti i threads di un processo.
> Condividono tutto tranne alcuni dati privati (es. PID).

I thread sono spesso chiamati processi leggeri perché il carico di lavoro associato alla loro computazione e' ridotto rispetto a quello dei processi.

![[34.png]]

I thread hanno le seguenti proprietà:
1. Un thread inizia la sua esecuzione in uno specifico punto del programma.
2. Un thread esegue una sequenza di istruzioni ordinata e predefinita.
3. Un thread viene eseguito indipendentemente rispetto agli altri thread.
4. I thread sono nati per essere eseguiti in parallelo (se la macchina che li esegue lo permette).

![[35.png]]

[_Torna all'indice_](#indice)

---

## Parallelismo e concorrenza
I sistemi paralleli sono deployati su un insieme di CPU per eseguire in parallelo processi e thread nello stesso momento.
I sistemi concorrenti sono deployati su una singola CPU, ma sono strutturati come se fossero in un sistema parallelo.

![[36.png]]

[_Torna all'indice_](#indice)

---

## Thread in Java
Ci sono due modi per descrivere i thread in Java:
1. Estendendo la classe `java.lang.Thread` usando top-level classes o (anonime) inner class.
```java
public class ThreadA extends Thread {
	@Override
	public void run() {
		// Corpo del thread
	}
}
```
2. Implementando l'interfaccia `java.lang.Runnable` usando top-level classes, (anonime) inner class, lambda expression.
```java
public class ThreadB implements Runnable {
	@Override
	public void run() {
		// Corpo del thread
	}
}
```

In entrambi i casi, il metodo `run()` contiene la sezione del programma che il thread deve eseguire.
Il metodo `start()` è usato per "startare" un thread e avviare l'esecuzione del metodo `run()`.

```java
// Estendendo la classe Thread
Thread a = new ThreadA();
a.start();

// Implementando l'interfaccia Runnable
Thread b = new Thread(new ThreadB());
b.start();
```

Un thread termina quando il suo metodo `run()` termina: non puo' essere terminato "con la forza".

[_Torna all'indice_](#indice)

---

### Stati di un thread
Gli stati del ciclo di vita di un thread sono strutturati in tre livelli:

![[37.png]]

Gli stati di un thread possono essere alterati:
- `sleep(millis)`: forza il thread ad andare nello stato blocked per un numero specifico di millisecondi.
- `interrupt()`: forza il thread ad andare nello stato running.
- `interrupted()`: verifica se il thread è stato precedentemente bloccato.
- `yield()`: mantiene il thread nello stato running, ma avvisa il thread scheduler di dare il permesso agli altri thread per essere eseguiti.
- `join()`: forza il thread ad andare nello stato blocked e aspetta gli altri thread sul quale e' stato invocato di terminare.

In una singola CPU, i thread vengono eseguiti uno alla volta dando l'illusione di essere in parallelo.
La JVM implementa un algoritmo di scheduling veramente semplice per i thread chiamato _fixed priority scheduling_.

[_Torna all'indice_](#indice)

---

## Java Memory Model
I thread di un programma Java:
- Hanno uno stack privato che usano come supporto per le invocazioni dei metodi.
- Hanno un provato thread-local storage.
- Condividono l'oggetto heap.

La Java Memory Model descrive come i thread accedono ai loro tre tipi di memoria, e descrive come il contenuto delle memorie è effettivamente salvato nella gerarchia di memoria del sistema.

> JVM decide come eseguire i thread sui vari core.
> Tutti gli oggetti risiedono nell'heap. Solo i tipi primitivi stanno nello stack.
 
![[38.png]]

La JVM è un "sistema operativo".
I thread in Java non sono necessariamente eseguiti sulla stessa CPU, questo perchè la JVM normalmente è distribuita su più CPU. 

![[39.png]]

L'esecuzione di thread su multiple CPU può causare problemi di coerenza di memoria.
Un esempio è la variabile `done` che abbiamo visto nell'esercizio 1: viene copiata nelle cache dei vari core e può assumere valori diversi in base ai vari thread. Questo provoca inconsistenza.

Questi problemi vengono risolti se l'accesso ai dati condivisi è controllato.
> Un controllo dell'accesso alla memoria condivisa può causare un uso inefficiente del parallelismo e delle risorse stesse.

> La memoria in Java è di 64MB. Quando si sfora questa cifra entra in azione il garbage collector.
 
![[40.png]]

[_Torna all'indice_](#indice)

---

### Mutua esclusione in Java
Il problema della mutua esclusione è uno dei piu' classici problemi della programmazione concorrente.
Un programma concorrente incontra un problema di mutua esclusione quando si deve assicurare che se, dato un insieme $M$ di sezioni mutualmente esclusive di un programma, 
- solo un thread alla volta può eseguire una delle sezioni del programma in $M$;
- i thread che non possono eseguire le sezioni mutualmente esclusive in $M$ sono bloccati e verranno ripresi il prima possibile.

> L'assegnamento degli oggetti in Java non esiste: viene copiata la reference.
> L'assegnamento avviene solo per i tipi primitivi.

La mutua esclusione in Java è risolta utilizzando le sezioni critiche.
Una sezione critica è una sezione di un programma associata ad un oggetto usato come un mutex (Mutual Exclusion device) per controllare l'accesso nella sezione critica.
- Un mutex puo' essere acquisito e rilasciato dai thread: è posseduto da un thread dopo la sua acquisizione e prima del rilascio.
- Se un thread acquisisce un mutex, nessuno degli altri thread puo' acquisire quel mutex finche' non viene esplicitamente rilasciato.
- I thread sono forzati ad andare nello stato blocked quando non possono acquisire un mutex, e successivamente sono forzati a passare allo stato running quando possono finalmente acquisirlo.
- Un thread esegue la sua sezione critica solo quando possiede il mutex usato come guardia per quella sezione.
- Un mutex è un oggetto qualsiasi dell'heap.
- Posso avere sezioni critiche diverse concorrenti che usano mutex diversi.

> L'acquisizione e il rilascio del mutex devono essere vicini per evitare molti bug.

L'acquisizione e il rilascio sono:
- Operazioni rientranti perché un mutex può essere acquisito e rilasciato più volte in cicli annidati senza bloccare il thread che possiede il mutex.
- Operazioni sincrone all'interno del processo perché i loro effetti sono condivisi in modo sincrono tra tutti i thread del processo, possibilmente tra più CPU.

> Java garantisce la mutua esclusione anche su CPU diverse.

![[41.png]]

Una sezione critica e' identificata da: 
- Il modificatore `synchronized` dei metodi, per affermare che il corpo del metodo è la sezione critica e che questa fa riferimento all'oggetto da utilizzare come mutex. In questo modo il mutex e' l'oggetto `this`.
``` java
public synchronized void myMethod() {
	// the critial section
}
```
- Il blocco `synchronized`, per affermare che il corpo del blocco è la sezione critica e che l'oggetto a cui si fa riferimento nella testa del blocco viene utilizzato come mutex. Con questo metodo identifico la guardia / mutex con l'oggetto `o`.
``` java
public void myMethod(Object o) {
	synchronized(o) {
		// the critial section
	}
}
```

La disponibilità delle sezioni critiche in Java provvedono una effettiva soluzione per diversi problemi, tra cui:
- Interferenza tra thread: questo problema accade quando due operazioni, che vengono eseguite su diversi thread, agiscono sullo stesso dato causando una race condition.
- Coerenza della memoria: questo problema accade quando thread diversi hanno inconsistenti accessi a copie dello stesso dato attraverso diverse CPU (cache non "allineate").

[_Torna all'indice_](#indice)

---

### Happens-Before
Java definisce la relazione happens-before sulle operazioni in memoria come la lettura e la scrittura delle variabili condivise.
Il risultato di una scrittura di un thread è garantita dall'essere visibile per una lettura di un altro thread se e solo se l'operazione di scrittura happen-before l'operazione di lettura.

Ogni azione in un thread avviene-prima di ogni altra azione di un altro thread che viene dopo in un programma.
Lo sblocco di un mutex avviene prima di ogni successivo blocco dello stesso mutex (vincolo multiprocessore).
> La relazione happens-before e' transitiva.

Una scrittura su un campo `volatile` avviene prima di ogni lettura successiva dello stesso campo.
> Si noti che il modificatore `volatile` non comporta la mutua esclusione.

Una chiamata a `start()` su un thread avviene prima di qualsiasi azione nel thread avviato.
Tutte le azioni in un thread si verificano prima che qualsiasi altro thread ritorni con successo da un `join()` su quel thread.

La keyword `synchronized` può essere usata effettivamente per risolvere i problemi di coerenza della memoria. L'utilizzo di `synchronized` su un oggetto `obj` assicura che tutte le modifiche dello stato di `obj` verranno propagate a tutti i thread interessati prima di un qualsiasi successivo accesso sincronizzatoi a `obj`.

> I campi `final`, che non possono essere modificati dopo che l'oggetto e' stato costruito, possono essere letti tranquillamente e in modo sicuro una volta che l'oggetto e' stato costruito.

Le operazioni atomiche in Java sono quelle operazioni di lettura e scrittura che non possono essere interrotte per sospendere l'attuale thread e attivarne un altro.

[_Torna all'indice_](#indice)

---

## Attesa e notifica di eventi
Il problema dell'attesa e della notifica degli eventi è un altro dei classici problemi della programmazione concorrente.

Un thread affronta il problema dell'attesa degli eventi se ha bisogno di attendere gli eventi senza verificare attivamente il verificarsi degli eventi (busy waiting).
Un thread affronta il problema di notificare eventi se ha bisogno di comunicare il verificarsi di eventi a un altro thread, che probabilmente è in attesa di notifiche.

Java abbina il problema dell'attesa e della notifica degli eventi alle sezioni critiche perché le sezioni critiche forniscono già un mezzo per bloccare i thread (senza busy waiting).

Un thread che deve notificare eventi invoca il metodo `notifyAll()` su un oggetto `obj` per notificare a tutti gli oggetti che stavano aspettando su `obj` che un evento si è verificato.

Un thread che deve aspettare eventi invoca il metodo `wait()` su `obj` per bloccarsi e aspettare gli eventi.

> Questi metodi vanno chiamati sugli oggetti guardia altrimenti si verifica una eccezione.

Nota che:
-  Il metodo `notifyAll()` notifica tutti i thread in attesa, che vengono tutti forzati allo stato di esecuzione anche se solo uno di loro entrerà nella sezione critica.
- Il metodo `notify()` notifica solo uno dei thread in attesa, ovvero il thread che eventualmente procederebbe nella sezione critica.
- L’uso del metodo `notify()` è intrinsecamente più efficiente, ma è anche soggetto a errori.
- Il metodo `wait(millis)` può essere usato per aspettare non più di `millis` millisecondi (attesa massima).

[_Torna all'indice_](#indice)

---

## Problemi di liveness
L'utilizzo superficiale o errato del supporto per la programmazione concorrente fornito da Java può comportare gravi problemi di liveness.
Alcuni di questi problemi lo sono:
- Deadlock, che è una situazione in cui due o più thread sono bloccati per sempre, in attesa l'uno dell'altro.
- Livelock, che è una situazione in cui due thread reagiscono continuamente agli eventi che ciascuno notifica all'altro.
- Starvation, ovvero una situazione in cui un thread non è in grado di ottenere un accesso regolare a una risorsa condivisa e, quindi, non è in grado di realizzare i progressi attesi.

---

## Astrazione ad alto livello per la concorrenza
Java offre meccanismi basici per la gestione della concorrenza e dei relativi problemi.
L'astrazione ad alto livello per la gestione dei problemi relativi alla concorrenza è necessaria per:
- Migliorare la manutentibilità dei sistemi concorrenti.
- Migliorare la riusabilità delle soluzioni dei problemi concorrenti.
- Migliorare il livello di comprensione delle caratteristiche non funzionali delle soluzioni (es: livello di parallelismo, tipi di controllo, problemi di liveness).

[_Torna all'indice_](#indice)

---

### Blocking Queues
Una queue (coda) è una sequenza di elementi che cambiano dinamicamente e seguono una politica FIFO (First In First Out). Le azioni basiche delle code sono: creazione, distruzione, is empty test, is full test, enqueue (add item), dequeue (remove item).

Una blocking queue (coda bloccante) è una coda utilizzata per l'uso concorrente.
Le operazioni vengono bloccate se non possono essere eseguite immediatamente:
- Enqueue puo' bloccare se la coda è piena.
- Dequeue puo' bloccare se la coda è vuota.

Le code bloccanti sono un'astrazione che possono essere usate per coordinare le attivita' senza un sistema concorrente.

> Nota bene: 
> 1. Tutte le code bloccanti possono possono bloccarsi sulla dequeue se sono vuote.
> 2. Solo le code bloccanti con capacita' limitata possono bloccarsi sulla enqueue se sono piene.

[_Torna all'indice_](#indice)

---

### Locks and Conditions
Un lock (esplicito) è un'astrazione che può essere usata per assicurare la mutua esclusione.
> Svincoliamo l'idea della sezione critica.

Caratteristiche dei lock:
- Può essere esplicitamente locked (acquisito) o unlocked (rilasciato).
- Solo un thread alla volta puo' possedere il lock.
- Un thread può bloccarsi nel tentativo di acquisire un lock se e' già posseduto da un altro thread.
- Un thread bloccato nel tentativo di acquisire un lock verrà risvegliato quando il lock potrà essere di nuovo riacquisito.

> Corrispondono ai lock della PTHREAD Library.

Una condizione è una astrazione che può essere usata per attendere e segnalare eventi:
- Un thread può segnalare che una condizione è diventata vera.
- Un thread si può bloccare e aspettare che una condizione venga segnalata.
- Un lock è sempre necessario come guardia di una condizione.

Un lock è normalmente associato con importanti condizioni:
- L'attesa e la segnalazione di condizioni è possibile solo per i thread che possiedono i lock delle condizioni.
- Quando un thread aspetta che una condizione venga segnalata, rilascia il lock della condizione.
- Quando un thread segnala una condizione, deve esplicitamente rilasciare il lock della condizione.

Le condizioni forniscono un significato ad un thread per la sospensione dell'esecuzione (`wait`) finché non viene notificato da un altro thread che la condizione è diventata vera. Dato che l'accesso a questo stato condiviso avviene all'interno di thread differenti deve essere protetto, per questo motivo un lock di qualunque forma è associato ad una condizione. La proprietà chiave che l'attesa per una condizione fornisce è che il rilascio del lock associato e l'attesa del thread avvengono in modo atomico.
[Java docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Condition.html)


> Lock rientrante: consente di acquisire più volte lo stesso lock $\to$ è consentito acquisirlo di nuovo senza che si verifichi un deadlock.
> Un esempio di lock rientrante:
``` java
public class ReentrantLockExample {
    private Lock lock = new ReentrantLock();
    private int lockCount = 0;

    public void performTask() {
        lock.lock(); // Acquisizione del lock
        ++lockCount;

        try {
            // Blocco critico - codice che richiede accesso sincronizzato
            System.out.println("Task in corso...");

            // Chiamata ricorsiva
            performSubTask();
        } finally {
            --lockCount;
            if (lockCount == 0) {
                lock.unlock(); 
                // Rilascio del lock solo se è stato acquisito una sola volta
            }
        }
    }

    public void performSubTask() {
        lock.lock(); 
        // Acquisizione del lock anche se è già stato acquisito nel chiamante
        
        ++lockCount;

        try {
            // Blocco critico della sotto-operazione
            System.out.println("Sotto-task in corso...");
        } finally {
            --lockCount;
            if (lockCount == 0) {
                lock.unlock(); 
                // Rilascio del lock solo se è stato acquisito una sola volta
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.performTask();
    }
}

```

---

### Atomic references
Un riferimento atomico incapsula un riferimento a un oggetto e lo gestisce in mutua esclusione.

Esempio:
```java
UnaryOperator<Integer> operator = new UnaryOperator<Integer>() {
	@Override
	public Integer apply(Integer value) {
		return value + 1;
	}
};
```

Viene creato un oggetto `UnaryOperator<Integer>` utilizzando una classe anonima. `UnaryOperator` è una funzione che accetta un argomento dello stesso tipo e restituisce un risultato dello stesso tipo.
L'oggetto `operator` è una funzione che, quando applicata a un numero intero, restituisce il numero successivo incrementato di 1. <u>Questo è un esempio di programmazione funzionale</u> in Java, in cui le funzioni sono trattate come oggetti e possono essere passate come argomenti o assegnate a variabili.

[_Torna all'indice_](#indice)

---

### Pools di Risorse
I problemi di concorrenza sono spesso causati dalle risorse condivise.
- La corretta gestione degli accessi alle risorse condivise e' uno dei piu' classici problemi di concorrenza.

Un gruppo di risorse identiche è chiamato pool (piscina) di risorse.
- Quando una pool è creata/distrutta, tutte le risorse sono anche acquisite/rilasciate.
- Le risorse vengono assegnate per l'utilizzo su richiesta al pool.
- L'accesso controllato delle risorse è garantito dalla pool.

Le pools di risorse sono normalmente usate per controllare l'ammontare delle risorse usate da un sistema concorrente:
- Per assicurare che un numero sufficiente di risorse sia disponibile.
- Per assicurare che le risorse siano usate in modo efficiente.

#### Thread Pools
I thread sono virtualmente le risorse più rilevanti in un sistema concorrente.
La costruzione, distruzione, e l'accesso ai thread sono spesso controllati usando i thread pools.

Quando viene creata, una thread pool crea e attiva tutti i thread nella pool. Questo per assicurarsi che i thread siano immediatamente disponibili quando si avrà la necessita di usarli e per assicurarsi che il livello della concorrenza sia controllato.

[_Torna all'indice_](#indice)

---

### Executors
Un (semplice) executor è un'astrazione che può essere usato per gestire tasks concorrenti:
- E' associato con una thread pool usata per eseguire tasks.
- Accoda le tasks che non possono essere avviate immediatamente.
- Fornisce modi per restituire i risultati delle tasks (se presenti).
- Fornisce modi per restituire le eccezioni che hanno causato l'errore della cessazione delle tasks (se presenti).
- Permette di interrompere le tasks e di terminare tutti i thread nella pool.
- (A volte) Fornisce una serie di politiche di scheduling.

Un executor offre tre possibili opzioni per eseguire le tasks:
1. _One way execution_: per il quale l'esecutore non fornisce un mezzo per sapere se l'attività è stata effettivamente eseguita e per leggere il risultato dell'attività (se presente).
2. _Execution with callback_: per il quale l'esecutore consente a un'attività di callback di utilizzare il risultato dell'attività (se presente), spesso nel thread che ha eseguito l'attività richiesta.
3. _Execution with future_: per il quale l'esecutore fornisce un futuro (una promessa) che gestisce il risultato dell'attività richiesta (se presente) quando diventa disponibile.

> Gli esecutori prevedono attività asincrone.

#### Callbacks
Una callback task è una task che viene eseguita quando un executor conclude una task richiesta.
- La callback task riceve il risultato dell'attività richiesta (se presente).
- La callback task riceve l'eccezione che ha causato la terminazione dell'attività richiesta (se presente).
- (A volte) la callback task viene eseguita nello stesso thread che ha eseguito l'attività richiesta.

Le callback task vengono implementate come oggetti associati a una richiesta di esecuzione di una task.

#### Futures
Un future (o promessa) è un mezzo per gestire:
- Il risultato di un'attività asincrona (se presente).
- L'eccezione che ha causato la conclusione dell'attività asincrona (se presente).

I futures sono implementati come oggetti associati a una richiesta di esecuzione di un'attività:
- Sono associati dinamicamente al risultato dell'attività richiesta (se presente) quando diventa disponibile.
- Sono associati dinamicamente all'eccezione che ha causato la terminazione dell'attività richiesta (se presente) quando diventa disponibile.

Un future blocca il thread che tenta di accedere al suo valore incorporato (un risultato o un'eccezione) se il valore non è ancora disponibile:
- Il thread viene ripreso quando il risultato diventa disponibile (se presente) e il risultato viene restituito.
- Il thread viene ripreso quando diventa disponibile un'eccezione (se presente) e l'eccezione viene generata.

> Nota bene: un future non si blocca se il suo valore è già disponibile al momento della richiesta.

[_Torna all'indice_](#indice)

