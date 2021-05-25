package Etapa_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){




        System.out.println("Sistem de licitatii");
        boolean start = true;




        while(start){

            System.out.println("Meniul principal");
            System.out.println("Alegeti-va optiunile, Conectati-va ca:");
            System.out.println("1.Admin");
            System.out.println("2.Licitator");
            System.out.println("3.Guest");
            System.out.println("0.Exit");


            Scanner myScanner = new Scanner(System.in);
            System.out.println("Inserati un nr: ");
            int alegere = myScanner.nextInt();
            if(alegere==1)
            {
                System.out.println("Meniu Admin");
                boolean startAdmin = false;
                boolean parolaAdmin = false;
                while (!parolaAdmin){
                    System.out.println("Apasati pe 0 pentru a va intoarce in meniul principal");
                    System.out.println("Scrieti parola:");

                    Scanner scannerParolaAdmin = new Scanner(System.in);
                    String passAdmin = scannerParolaAdmin.nextLine();

                    if(passAdmin.equals("1234"))  {

                        startAdmin=true;
                        parolaAdmin = true;
                        System.out.println("Parola Corecta:");}


                    else if(passAdmin.equals("0"))
                        parolaAdmin = true;

                    else {
                        System.out.println("Parola Gresita! \nIncearca din nou");

                    }

                }

                while (startAdmin){

                    System.out.println("Alegeti-va optiunile:");
                    System.out.println("1.Adaugare Licitate");
                    System.out.println("2.Vizualiare Licitatii");
                    System.out.println("3.Stergere Licitatie");
                    System.out.println("4.Modificare Licitatie");
                    System.out.println("5.Vizualizare Bids");
                    System.out.println("6.Vizualizare Bids pentru o Licitatie");
                    System.out.println("7.Vizualizare Users");
                    System.out.println("0.Exit");


                    Scanner scanerAdmin = new Scanner(System.in);
                    System.out.println("Inserati un nr: ");
                    int alegereAdmin = scanerAdmin.nextInt();

                    if(alegereAdmin==1){// functie din interogare
                        Interogare.Adauga_Licitatie();
                    }else if(alegereAdmin==2){
                        Interogare.AfisareLicitati();
                    }
                    else if(alegereAdmin==3){}
                    else if(alegereAdmin==4){}
                    else if(alegereAdmin==5){}
                    else if(alegereAdmin==6){}
                    else if(alegereAdmin==7){Interogare.AfisareUsers();}
                    else if(alegereAdmin==0){

                        startAdmin=false;

                    }
                }
            }

            else if(alegere==2)
            {
                boolean contnou=false;
                boolean startLicitator=true;
                String nameLicitator = null;
                String passwordLicitator=null;

                while (startLicitator)
                {

                    System.out.println("Meniu Licitator");
                    System.out.println("Alegeti-va potiunile:");
                    System.out.println("1 Creeaza Cont");
                    System.out.println("2 Conecteaza-te");
                    System.out.println("0 Exit");

                    Scanner scanerLicitator = new Scanner(System.in);
                    System.out.println("Inserati un nr: ");
                    int alegereLicitator = scanerLicitator.nextInt();

                    Scanner scannerLicitatorUser = new Scanner(System.in);

                    if(alegereLicitator==1){

                        Interogare.CreeazaCont();

                    }
                    if(alegereLicitator==2){

                        Interogare.Conecteare();

                    }
                    else if(alegereLicitator==0){
                        startLicitator=false;
                    }

                }

            }
            else if(alegere==3)
            {
                System.out.println("Meniu Guest");
                boolean startGuest=true;
                while (startGuest){

                    System.out.println("Alegeti-va potiunile:");
                    System.out.println("1 Vizualizeaza Licitatiile");
                    System.out.println("0 Exit");
                    Scanner scannerGuest = new Scanner(System.in);
                    System.out.println("Inserati un nr: ");
                    int alegereGuest = scannerGuest.nextInt();

                    if(alegereGuest==1){
                        Interogare.AfisareLicitati();
                    }
                    else if(alegereGuest==0){startGuest=false;}

                }

            }
            else {

                start = false;
                Interogare.OprireProgram();


            }


        }


        Interogare.QuitProgram();
    }






}