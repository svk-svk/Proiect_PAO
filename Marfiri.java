package Etapa_1;
import java.util.Date;
public class Marfiri extends Obiect {

    protected int idMarfa;
    protected int greutate;
    protected int volum;
    protected Date dataProductiei;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;


    public Marfiri(int valoare, int greutate, int volum, Date dataProductiei, String descriere, String locatie) {

        super(valoare,"Marfuri");

        this.greutate=greutate;
        this.volum=volum;
        this.dataProductiei=dataProductiei;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idMarfa = counter;
    }


    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Marfa="+this.idMarfa);
        System.out.print(" Greutate="+this.greutate+"kg");
        System.out.print(" Volum="+this.volum+"metri cubi");
        System.out.print(" Data fabricarii="+this.dataProductiei);
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();

    }

}
