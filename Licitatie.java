package Etapa_1;

import java.util.ArrayList;

public class Licitatie {


    protected int id;
    protected int id_obiect;
    protected int pretPornire;

    protected int pretVanzare;
    protected int idCastigator;
    protected ArrayList<Integer> bids= new ArrayList<Integer>();

    private static int counter = 0;

    public Licitatie(int id_obiect, int pretPornire){

        this.id_obiect=id_obiect;
        this.pretPornire=pretPornire;

        counter++;
        this.id = counter;

    }

    public Licitatie(){

        this.id = -100;

    }




    public void setPretPornire(int pretPornire) {
        this.pretPornire=pretPornire;

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
