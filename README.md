## Music Manager - Fase 1

Un semplice progetto in **Java** per la gestione di utenti, canzoni e playlist, sviluppato come esercizio di apprendimento a fasi.  

## Funzionalità implementate relative alla fase 1
- Creazione e gestione di utenti
- Creazione e gestione di canzoni
- Creazione e gestione di playlist
- Aggiunta e rimozione di canzoni dalle playlist
- Sistema di navigazione da console
- Mock del playSong (riproduzione fittizia da console)

## Tecnologie
- Java 17+
- Eclipse IDE
- Programmazione ad oggetti (OOP)
- MVC semplificato con `service` e `model`

## Media Player – Fase 2

In questa seconda fase del progetto **Media Player** ho completato la realizzazione dell’architettura interattiva dell’applicazione.

L’obiettivo principale è stato quello di costruire un’interfaccia coerente e reattiva, in grado di gestire dinamicamente i vari componenti (navbar, contenuti e footer) e simulare il comportamento di un vero player musicale.

## Funzionalità implementate

### Interfaccia interattiva
- Visualizzazione di **canzoni** e **playlist** all’interno di **tabelle dinamiche**.
- Eventi interattivi come il **doppio click** per caricare automaticamente i dati nel player.
- Gestione modulare tramite un **MainController** che coordina i vari componenti dell’interfaccia.

### Dinamicità dei dati
- Aggiunta la **gestione dinamica del caricamento dei dati** tra playlist e canzoni.  
  Ora, selezionando una playlist, le canzoni vengono aggiornate **in tempo reale** nella `Tabella canzoni`.
- Implementazione di un sistema basato su **`ObservableList`** per sincronizzare i dati del `SongService` con l’interfaccia grafica.

### Simulazione fittizia del player
- Simulazione completa del player musicale:
  - Titolo, autore e durata.
  - Timer e **barra di avanzamento sincronizzata**.
  - Controlli reattivi collegati al `MainController`.

### Gestione playlist
- Finestre **popup** per la creazione, modifica e cancellazione delle playlist.
- Collegamento automatico tra playlist e canzoni.

## Tecnologie aggiunte

- **JavaFX** per l’interfaccia grafica.
- **FXML** per la struttura delle viste.
- **ObservableList** per la gestione dinamica dei dati.
- **OOP & MVC Pattern** per l’architettura modulare.

## ✨ Autore
**Giuseppe Salvatore Celauro**  
Studente / Developer – progetto personale di sviluppo software in JavaFX  
*Fase 2 completata – ottobre 2025*
