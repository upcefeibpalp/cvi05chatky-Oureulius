package cz.fei.upce.cv05.evidence.chatek;

import java.util.Scanner;

public class EvidenceChatekApp {

    private static final int POCET_CHATEK = 10;
    private static final int KAPACITA_CHATEK = 4;
    private static int[] chatky = new int[POCET_CHATEK];
    private static Scanner vstup = new Scanner(System.in);
    
    public static void main(String[] args) {
        int moznost;
            do {                
                System.out.println("Evidence obsazení chatek");
                System.out.println("------------------------");
                System.out.println("Vyber možnost zadáním příslušného čísla:");
                System.out.println("1. Obsazenost chatek\n" + 
                                   "2. Přidat lidi do chatky\n" +
                                   "3. Odebrat lidi z chatky\n" +
                                   "4. Celkový počet lidí v chatkách\n" +
                                   "5. Vypsání prázdných chtake\n" +
                                   "6. Konce programu");
                moznost = vstup.nextInt();
                
                switch (moznost) {
                    case 1:
                    vypsatObsazenost();
                    break;    
                    case 2:
                    pridatLidiChatky();
                    break;
                    case 3:
                    odebratLidiChatky();
                    break;
                    case 4:
                    vypsatCelkovyPocetLidi();
                    break;
                    case 5:
                    vypsatPrazdneChatky();
                    break;
                    case 6:
                        System.out.println("Konec programu");
                        System.exit(0);
                    break;
                    default:
                        System.out.println("Neplatná volba, zkus to znova!");
                }                
            } while (moznost != 0);
    }
    
    private static void vypsatObsazenost(){
        System.out.println("Obsazenost chatek:");
        for (int i = 0; i < POCET_CHATEK; i++) {
            System.out.println("Chatka " + (i+1) + ": " + chatky[i] + " lidí");
        }
    }
    private static void pridatLidiChatky(){
        System.out.print("Zadej číslo chatky: ");
        int cisloChatky = vstup.nextInt() - 1;
        System.out.print("Zadej kolik lidí chceš přidat: ");
        int pocetLidi = vstup.nextInt();
        
        if (cisloChatky >= 0 && cisloChatky < POCET_CHATEK) {
            if (chatky[cisloChatky] + pocetLidi <= KAPACITA_CHATEK) {
                chatky[cisloChatky] += pocetLidi;
                System.out.println(pocetLidi + " lidí bylo přidáno do chatky " + cisloChatky);
            }else{
                System.out.println("Překročená kapacita chatky!");
            }
        }else{
            System.out.println("Neplatné číslo chatky!");
        }
    }
    private static void odebratLidiChatky(){
        System.out.print("Zadej číslo chatky: ");
        int cisloChatky = vstup.nextInt() - 1;
        System.out.print("Zadej kolik lidí chceš odebrat: ");
        int pocetLidi = vstup.nextInt();
        
        if (cisloChatky >= 0 && cisloChatky < POCET_CHATEK) {
            if (chatky[cisloChatky] - pocetLidi >= 0) {
                chatky[cisloChatky] -= pocetLidi;
                System.out.println(pocetLidi + "lidí bylo odebráno z chatky " + cisloChatky);
            }else{
                System.out.println("Překročená kapacita odebrání v chatce!");
            }
        }else{
            System.out.println("Neplatné číslo chatky!");
        }
    }
    private static void vypsatCelkovyPocetLidi(){
        int celkovyPocet = 0;
        for (int pocet : chatky) {
            celkovyPocet += pocet;
        }
        System.out.println("Celkový počet lidí je: " + celkovyPocet);
    }
    private static void vypsatPrazdneChatky(){
        System.out.println("Prázdné chatky: ");
        for (int i = 0; i < POCET_CHATEK; i++) {
            if (chatky[i] == 0) {
                System.out.println("Chatka " + (i+1));
            }
        }
    }
}
