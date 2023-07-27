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
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 Vacanza vacanza = null;
        while(vacanza == null){
            System.out.println("Destinazione della tua vacanza: ");
            String destinazione = scan.nextLine();
            System.out.println("Data di inizio(AAAA-MM-GG): ");
            LocalDate dataInizio = null;
            try{
                dataInizio = LocalDate.parse(scan.nextLine());
            } catch (RuntimeException e){
                System.out.println("Data non valida");
                System.out.println(e.getMessage());
            }
System.out.println("Inserisci la data in cui rientrerai: ");
            LocalDate dataFine = null;
            try{
                dataFine = LocalDate.parse(scan.nextLine());
            } catch(RuntimeException e){
                System.out.println("Data non valida");
                System.out.println(e.getMessage());
            }
              try {
                  vacanza = new Vacanza(destinazione, dataInizio,dataFine);
              } catch (RuntimeException e){
                  System.out.print("Errore nell'inserimento dei dati, perfavore riprova.");
                          System.out.print(e.getMessage());
              }
        }

        System.out.print(vacanza);

    }
}
