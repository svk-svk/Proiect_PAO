package Etapa_1;

public class Masini extends Obiect {
    protected int idMasina;
    protected int capacitateCilindrica;
    protected int anFabricatie;
    protected int kmParcursi;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;



    public Masini(int valoare, int capacitateCilindrica, int anFabricatie, int kmParcursi, String descriere, String locatie) {
        super(valoare,"Masina");
        this.capacitateCilindrica = capacitateCilindrica;
        this.anFabricatie=anFabricatie;
        this.kmParcursi=kmParcursi;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idMasina = counter;
    }




    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Masina= "+this.idMasina);
        System.out.print(" Capacitate Cilindrica="+this.capacitateCilindrica);
        System.out.print(" An de fabricatie="+this.anFabricatie);
        System.out.print(" Km Parcursi="+this.kmParcursi);
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();


    }


}
