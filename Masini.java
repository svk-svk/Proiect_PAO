package Etapa_1;

public class Masini extends Obiect {

    protected int capacitateCilindrica;


    public Masini(int valoare, int capacitate) {
        super(valoare);
        this.capacitateCilindrica = capacitate;

    }

    public void setCapacitateCilindrica(int capacitate) {
        this.capacitateCilindrica = capacitate;
    }

    public int getCapacitateCilindrica() {
    return capacitateCilindrica;
    }

}
