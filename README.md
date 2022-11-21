#### Repo
java-biglietto-treno-oop

#### Package 
-ragionevole-

#### Todo
##### MILESTONE 1
*Consegna*: creare una classe Biglietto con due attributi interi: km e età del passeggero.

Nel costruttore vanno valorizzati entrambi gli attributi, assicurandosi che abbiano valori validi
(creare due metodi *isValidKm* e *isValidEta* che implementano questa logica). In caso anche
solo uno non sia valido, sollevare un’eccezione.

Aggiungere tre costanti:
- il costo chilometrico di 21 centesimi di €/km (BigDecimal)
- lo sconto over 65 del 40 % (BigDecimal)
- lo sconto minorenni del 20% (BigDecimal)

Implementare il metodo public che calcola il prezzo del biglietto comprensivo di eventuale
sconto (*calcolaPrezzo*). Per eseguire il calcolo dello sconto aggiungere un metodo private
calcolaSconto, da chiamare dentro al metodo calcolaPrezzo.

##### MILESTONE 2
Creare una classe Biglietteria, che contiene il metodo main in cui:
- chiedere all’utente di inserire il numero di km e l’età del passeggero
- con quei dati provare a creare un nuovo Biglietto (gestire eventuali eccezioni con try-catch)
- stampare a video il prezzo del biglietto calcolato

##### MILESTONE 3 (BONUS)
Alla classe Biglietto aggiungere i seguenti attributi:
- data: LocalDate
- flessibile: boolean
Entrambi gli attributi vanno valorizzati nel costruttore.

Aggiungere due costanti:
- durata normale: 30 giorni (int)
- durata flessibile: 90 giorni (int)

Aggiungere un metodo (calcolaDataScadenza: *LocalDate*) che calcola la data di scadenza
del biglietto, applicando la durata normale o flessibile in base al parametro
flessibile(boolean).

Nel metodo che calcola il prezzo, se il biglietto è flessibile, maggiorare il prezzo del 10%.

Modificare la classe Biglietteria in modo che, alla creazione del Biglietto, valorizzi la data con
la data odierna e il parametro flessibile in base alla scelta dell’utente.
Dopo aver stampato il prezzo del biglietto, stampare a video anche la data di scadenza.

*NOTA*: per aggiungere dei giorni a un oggetto di tipo LocalDate, si può usare il metodo
*plusDays* (vedi esempio)

##### MILESTONE 4 (BONUS)
Nella classe Biglietteria, quando viene creato un nuovo biglietto, salvare i suoi dati in un file.
Alla fine del programma, mostrare a video l’elenco dei biglietti creati.
