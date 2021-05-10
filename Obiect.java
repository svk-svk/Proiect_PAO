package Etapa_1;

public class Obiect {

    protected int id;
    protected int valoare;
    protected String tipObiect;


    private static int counter= 0;

    public Obiect(int valoare, String tipObiect){

        this.valoare =  valoare;
        counter++;
        this.id = counter;
        this.tipObiect=tipObiect;
    }

    public void AfisareDate(){}



    public void setValoareObiect(int valoare) {
        this.valoare =  valoare;
    }

    public int getIdObiect() {
        return id;
    }

    public String getTipObiect(){
        return this.tipObiect;
    }

    public int getValoareObiect() {
        return valoare;
    }
}
