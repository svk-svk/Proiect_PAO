package Etapa_1;

public class Case extends Obiect{

    protected int idCasa;
    protected int suprafataTotala;
    protected int suptafataUtila;
    protected int nrEtaje;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;



    public Case(int valoare,int suprafataTotala, int suptafataUtila, int nrEtaje, String descriere, String locatie) {

        super(valoare,"Casa");

        this.suprafataTotala=suprafataTotala;
        this.suptafataUtila=suptafataUtila;
        this.nrEtaje=nrEtaje;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idCasa = counter;

    }


    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Casa="+this.idCasa);
        System.out.print(" Suprafata Totala="+this.suprafataTotala+"metri patrati");
        System.out.print(" Suprafata Utila="+this.suptafataUtila+"metri patrati");
        System.out.print(" Nr de etaje="+this.nrEtaje);
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();


    }



}
