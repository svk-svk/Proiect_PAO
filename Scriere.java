package Etapa_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Scriere {


        private static Scriere scriereInstance = null;

        private Scriere(){}

        public static Scriere getInstance(){
            if (scriereInstance == null){
                scriereInstance = new Scriere();
            }
            return scriereInstance;
        }




        public void scrieUsers(ArrayList<User> userss){
            try {File file =new File("users.csv");

                FileWriter out = new FileWriter(file);
                for (User aux : userss){
                    out.write( aux.getNumeUser() + "," + aux.getPassword() + "," + aux.getSumaContUser() + "\n");
                    out.flush();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    public void scrieBids(ArrayList<Bid> bids){
        try {File file =new File("bids.csv");

            FileWriter out = new FileWriter(file);
            for (Bid aux : bids){
                out.write( aux.idUser + "," + aux.idProdus + "," + aux.valoare + "\n");
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void scrieLicitatii(ArrayList<Licitatie> licits){
        try {File file =new File("licitatii.csv");

            FileWriter out = new FileWriter(file);
            for (Licitatie aux : licits){
                out.write( aux.id_obiect + ","  + aux.pretPornire + "\n");
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    public void scrieObiect(ArrayList<Obiect> obiects){
        try {

            FileWriter out = new FileWriter("obiect.csv");
            for (Obiect aux : obiects){

                    aux.Scriere_Fisier(out);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }





}
