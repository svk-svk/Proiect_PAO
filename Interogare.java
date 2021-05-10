package Etapa_1;

import Etapa_1.Licitatie.*;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Interogare {

    static ArrayList<User> users = new ArrayList();
    static ArrayList<Licitatie> licitaties = new ArrayList<>();
    static ArrayList<Obiect> obiects = new ArrayList();
    static ArrayList<Bid> bids = new ArrayList();
    static Licitatie activLicitatie;
    static User activUser;

    static int pozitieUser=0;

    static AuditService audit = AuditService.getInstance();




    public static void MeniuConectare(){


        boolean activ=true;
        while (activ)
        {
            System.out.println("Salut"+activUser.userName);
        System.out.println("Aveti Urmatoarele Optiuni:");
        System.out.println("1 Adauga Credit");
        System.out.println("2 Schimbare Parola");
        System.out.println("3 Vizualizeaza Licitatiile");
        System.out.println("4 Plaseaza Bid");
        System.out.println("5 Vizualizeaza detalii cont");

        System.out.println("0 Deconectare");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserati un nr: ");
        int alegereLicitator = scanner.nextInt();

          if(alegereLicitator==1){Adauga_Credit();}
        else if(alegereLicitator==2){SchimbareParola();}
        else if(alegereLicitator==3){}
        else if(alegereLicitator==4){}
        else if(alegereLicitator==5){Detalii_Cont();}
        else if(alegereLicitator==0){Deconectare();activ=false;}}



    }


    public static void Deconectare()
    {
        users.set( pozitieUser, activUser );
        System.out.println("Deconectare..");
        audit.Write("Deconectare "+activUser.userName);
        activUser=null;
        pozitieUser=-1;

    }
    
    
    public static void SchimbareParola(){

        Scanner scanner = new Scanner(System.in);
        String parolaNoua = null;
        boolean validPassword=false;
        while (!validPassword){

            System.out.println("Parola:");
            parolaNoua= scanner.nextLine();
            System.out.println("Confirmarea Parolei:");
            String confirmarepasswordLicitator= scanner.nextLine();

            if(parolaNoua.equals(confirmarepasswordLicitator)) {System.out.println("Parola valida");validPassword=true;}
            else System.out.println("Parolele nu sunt identice \nIncercati din nou");
        }

        activUser.setPassword(parolaNoua);
        audit.Write("Schimbare parola "+activUser.userName);
        
    }




    public static void Conecteare(){

        Scanner scanner = new Scanner(System.in);
        String nameLicitator = null;
        String passwordLicitator = null;
        User temporalUser = null;

        System.out.println("Conecteaza-te");

        boolean validUser=false;
        while (!validUser)
        {
            System.out.println("Username:");
            nameLicitator = scanner.nextLine();


            if(ExistaUser(nameLicitator)==true){
                System.out.println("Username valid"); validUser=true;
                temporalUser=GetUser(nameLicitator);}
            else { System.out.println("Username-ul nu este in baza de date \nIncercati din nou");}

        }

        boolean validPassword=false;
        while (!validPassword){

            System.out.println("Parola:");
            passwordLicitator= scanner.nextLine();


            if(passwordLicitator.equals(temporalUser.password)) {

                System.out.println("Parola valida");
                validPassword=true;
                activUser=temporalUser;
            }

            else System.out.println("Parolele nu sunt identice \nIncercati din nou");
        }

        audit.Write("Conectare "+activUser.userName);
        MeniuConectare();

    }

    public  static void AfisareUsers(){

        System.out.println("In baza de date sunt inregistrati "+users.size()+" users");

        for(User el:users)
            System.out.println(el.userName);

    }


    public static User GetUser(String name){
        int aux=0;
        for(User el:users){
            aux++;
            if(el.userName.equals(name)) {pozitieUser = aux-1; return el;}
            audit.Write("Cautare User");
        }
        return null;

    }



    public static boolean ExistaUser(String name)
    {
        for(User el:users){

          if(el.userName.equals(name)) return true;

        }
        return false;
    }


    public static void CreeazaCont()
    {
        System.out.println("Creeaza Cont Licitator");
        Scanner scanner = new Scanner(System.in);

        String nameLicitator = null;
        String passwordLicitator = null;

        boolean validUser=false;
        while (!validUser)
        {
            System.out.println("Adauga username:");
            nameLicitator = scanner.nextLine();

            //verificare_exista user ; true daca exista in baza de date altfel false
            boolean verificare_exista=ExistaUser(nameLicitator);
            if(verificare_exista==false){  System.out.println("Username valid"); validUser=true;}
            else { System.out.println("Username-ul este deja utilizat \nIncercati din nou"); }

        }

        boolean validPassword=false;
        while (!validPassword){

            System.out.println("Parola:");
            passwordLicitator= scanner.nextLine();
            System.out.println("Confirmarea Parolei:");
            String confirmarepasswordLicitator= scanner.nextLine();

            if(passwordLicitator.equals(confirmarepasswordLicitator)) {System.out.println("Parola valida");validPassword=true;}
            else System.out.println("Parolele nu sunt identice \nIncercati din nou");
        }

        User user= new User(nameLicitator,passwordLicitator,0);
        pozitieUser= users.size();
        users.add(user);
        activUser=user;
        System.out.println("Felicitari "+nameLicitator+" contul dumneavoastra a fost creeat");
        audit.Write("Creare Cont "+activUser.userName);
        MeniuConectare();

    }





    public static void Adauga_Credit(){

        System.out.println("Adauga credit");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Suma pe care doriti sa o adaugati in cont");
        int aux= scanner.nextInt();
        activUser.sumaCont=activUser.sumaCont+aux;
        audit.Write("Adauga Credit "+activUser.userName);


    }

    public static void Detalii_Cont()
    {
        System.out.println("Detalii cont ");
        System.out.println("Name" + activUser.userName);
        System.out.println("Sold" + activUser.sumaCont);

    }

    public static void Adauga_Licitatie()
    {
        System.out.println("Adauga o noua licitatie ");
        System.out.println("Ce tip obiect vrei sa adaugi la licitatie ");
        System.out.println("1. Casa");
        System.out.println("2. Terenuri");
        System.out.println("3. Masini");
        System.out.println("4. Marfuri");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        int aux= scanner.nextInt();

        if(aux==1){
            System.out.println("Licitatie Casa");
            System.out.println();
            System.out.println("Detalii Casa");
            System.out.println("Valoare");
            int valoare= scanner.nextInt();
            System.out.println("Suprafata Totala");
            int suprafataTotala=scanner.nextInt();
            System.out.println("Suprafata Utila");
            int suptafataUtila=scanner.nextInt();
            System.out.println("Nr etaje");
            int nrEtaje=scanner.nextInt();

            System.out.println("Descriere");
            String descriere=scanner.next();
            descriere += scanner.nextLine();


            System.out.println("Locatie");
            String locatie=scanner.next();
            locatie += scanner.nextLine();


            Case casa=new Case(valoare,suprafataTotala,suptafataUtila,nrEtaje,descriere,locatie);
            obiects.add(casa);


            System.out.println();
            System.out.println("Detalii Licitatie");

            System.out.println("Pret de pornire:");
            int pretPornire=scanner.nextInt();
            System.out.println("Timp de asteptare:");
            int timpAsteptare=scanner.nextInt();

            licitaties.add(new Licitatie(casa,pretPornire,timpAsteptare));

        }
        else if(aux==2){
            System.out.println("Licitatie Teren");
            System.out.println();
            System.out.println("Detalii Teren");
            System.out.println("Valoare");
            int valoare= scanner.nextInt();
            System.out.println("Suprafata teren");
            int suprafataMp=scanner.nextInt();

            System.out.println("Descriere");
            String descriere=scanner.next();
            descriere += scanner.nextLine();


            System.out.println("Locatie");
            String locatie=scanner.next();
            locatie += scanner.nextLine();


            Terenuri teren= new Terenuri(valoare,suprafataMp,descriere,locatie);
            obiects.add(teren);

            System.out.println();
            System.out.println("Detalii Licitatie");

            System.out.println("Pret de pornire:");
            int pretPornire=scanner.nextInt();
            System.out.println("Timp de asteptare:");
            int timpAsteptare=scanner.nextInt();

            licitaties.add(new Licitatie(teren,pretPornire,timpAsteptare));

        }else if(aux==3){


            System.out.println("Licitatie Masina");
            System.out.println();
            System.out.println("Detalii Masina");
            System.out.println("Valoare");
            int valoare= scanner.nextInt();
            System.out.println("Capacitate Cilindrica");
            int capacitateCilindrica=scanner.nextInt();
            System.out.println("An de fabricatie");
            int anFabricatie=scanner.nextInt();
            System.out.println("Km Parcursi");
            int kmParcursi=scanner.nextInt();

            System.out.println("Descriere");
            String descriere=scanner.next();
            descriere += scanner.nextLine();


            System.out.println("Locatie");
            String locatie=scanner.next();
            locatie += scanner.nextLine();

            Masini masina=new Masini(valoare, capacitateCilindrica, anFabricatie, kmParcursi, descriere,locatie);
            obiects.add(masina);

            System.out.println();
            System.out.println("Detalii Licitatie");

            System.out.println("Pret de pornire:");
            int pretPornire=scanner.nextInt();
            System.out.println("Timp de asteptare:");
            int timpAsteptare=scanner.nextInt();

            licitaties.add(new Licitatie(masina,pretPornire,timpAsteptare));

        }else if(aux==4){

            System.out.println("Licitatie Marfuri");
            System.out.println();
            System.out.println("Detalii Marfa");
            System.out.println("Valoare ");
            int valoare= scanner.nextInt();
            System.out.println("Greutate ");
            int greutate=scanner.nextInt();
            System.out.println("Volum");
            int volum=scanner.nextInt();
            System.out.println("Data fabricarii");
            Date dataProductiei=null;

            System.out.println("Descriere");
            String descriere=scanner.next();
            descriere += scanner.nextLine();


            System.out.println("Locatie");
            String locatie=scanner.next();
            locatie += scanner.nextLine();


            Marfiri marfa=new Marfiri(valoare,greutate, volum, dataProductiei, descriere, locatie);
            obiects.add(marfa);


            System.out.println();
            System.out.println("Detalii Licitatie");

            System.out.println("Pret de pornire:");
            int pretPornire=scanner.nextInt();
            System.out.println("Timp de asteptare:");
            int timpAsteptare=scanner.nextInt();

            licitaties.add(new Licitatie(marfa,pretPornire,timpAsteptare));

        }else  System.out.println("Exit");

        audit.Write("Adauga Licitatie ");

    }


    public  static void AfisareLicitati(){

        System.out.println("In baza de date sunt inregistrate "+licitaties.size()+" licitatii");

        for(Licitatie el:licitaties)
        {
        el.obiect.AfisareDate();}

    }


    public static void OprireProgram(){


        System.out.println("Program oprit");
        audit.Close();
    }


}
