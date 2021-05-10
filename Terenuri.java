package Etapa_1;

public class Terenuri extends Obiect{

    protected int idTeren;
    protected int suprafataMp;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;


    public Terenuri(int valoare,int suprafataMp, String descriere, String locatie) {

        super(valoare,"Teren");
        this.suprafataMp=suprafataMp;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idTeren = counter;

    }

    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Teren="+this.idTeren);
        System.out.print(" Suprafata Teren="+this.suprafataMp+" metri patrati");
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();

    }


}
