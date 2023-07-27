//Esercizio di oggi Java Travel Agency con repo java-travel-agency  :aeroplano::spiaggia_con_ombrellone:
//Consegna Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
//- destinazione
//- data inizio
//- data fine
//Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
//- destinazione, data inizio e data fine non possono essere null
//- la data inizio non può essere già passata
//- la data fine non può essere prima della data inizio
//Se fallisce la validazione vanno sollevate opportune eccezioni
//La classe Vacanza espone un metodo per calcolare la durata in giorni della vacanza.
//Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore se vuole inserire una nuova vacanza o uscire.
//Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza e il giorno, mese anno di ritorno.
//Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo: “Hai prenotato una vacanza di [numero di giorni] giorni a [destinazione] dal [data inizio formattata] al [data fine formattata]“.
//Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con dei messaggi di errore che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.

package org.java.lessons;

import java.time.LocalDate;
import java.time.Period;

public class Vacanza {
    private String destinazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine){
         if(destinazione == null || destinazione.isEmpty()){
             throw new RuntimeException("Non hai inserito alcuna destinazione");
         }

         if (dataInizio == null || dataFine == null){
            throw new RuntimeException("Non hai inserito alcuna data");
         }

         if(dataInizio.isBefore(LocalDate.now()) || dataFine.isBefore(dataInizio)){
             throw new RuntimeException("Formato non supportato");
        }
         this.destinazione = destinazione;
         this.dataInizio = dataInizio;
         this.dataFine = dataFine;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        if (destinazione == null || destinazione.isEmpty()) {
            throw new RuntimeException("Non hai inserito alcuna destinazione");}
            this.destinazione = destinazione;

    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        if(dataInizio == null || dataInizio.isBefore(LocalDate.now())){
            throw new RuntimeException("Data di inizio non valida");
        }
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        if(dataFine == null || dataFine.isBefore(dataInizio)){
            throw new RuntimeException("La data di fine vacanza non è valida");
        }
        this.dataFine = dataFine;
    }

public int CalcoloGiorniVacanza(){
        Period intervallo = Period.between(dataInizio, dataFine);
return intervallo.getDays();

}


    @Override
    public String toString() {
        return "Hai prenotato una vacanza di " + CalcoloGiorniVacanza() + " giorni a "
                + getDestinazione() + " da " + getDataInizio() + " al " + getDataFine();
    }
}

