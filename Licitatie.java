package Etapa_1;

import java.util.ArrayList;

public class Licitatie {


    protected int id;
    protected Obiect obiect;
    protected int pretPornire;
    protected int timpAsteptare;
    protected int pretVanzare;
    protected int idCastigator;
    protected ArrayList<Bid> bids;

    private static int counter = 0;

    public Licitatie(Obiect obiect, int pretPornire, int timpAsteptare){

        this.obiect=obiect;
        this.pretPornire=pretPornire;
        this.timpAsteptare=timpAsteptare;
        counter++;
        this.id = counter;

    }

    public void setObiect(Obiect obiect) {
        this.obiect=obiect;

    }

    public void setPretPornire(int pretPornire) {
        this.pretPornire=pretPornire;

    }

    public void setTimpAsteptare(int timpAsteptare) {
        this.timpAsteptare=timpAsteptare;

    }

    public void setIdCastigator(int idCastigator){
        this.idCastigator=idCastigator;

    }

    public void setPretVanzare(int pretVanzare){
        this.pretVanzare=pretVanzare;
    }

    public void AfisareLicitatie(){


        System.out.println("Obiect");


    }





}
