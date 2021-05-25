package Etapa_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Citire {


    private static Citire citireInstance = null;

    private Citire(){}

    public static Citire getInstance(){
        if (citireInstance == null){
            citireInstance = new Citire();
        }
        return citireInstance;

    }


    public ArrayList<User>  citireUsers(){
        ArrayList<User> users = new ArrayList<>();

        try{
            File file =new File("users.csv");

            RandomAccessFile in = new RandomAccessFile(file,"r");
            String currentLine;
            while ((currentLine = in.readLine()) != null){

                String[] getAttributes = currentLine.split(",");
                User user = new User(getAttributes[0], getAttributes[1],  Integer.parseInt(getAttributes[2]));
                users.add(user);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return users;
    }


    public ArrayList<Bid>  citireBid(){
        ArrayList<Bid> bids = new ArrayList<>();

        try{
            File file =new File("bids.csv");
            RandomAccessFile in = new RandomAccessFile(file, "r");
            String currentLine;
            while ((currentLine = in.readLine()) != null){

                String[] getAttributes = currentLine.split(",");
                Bid bid = new Bid(Integer.parseInt(getAttributes[0]), Integer.parseInt(getAttributes[1]),  Integer.parseInt(getAttributes[2]));
                bids.add(bid);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return bids;
    }




    public ArrayList<Licitatie>  citireLicitatii(){
        ArrayList<Licitatie> licits = new ArrayList<>();

        try{
            File file =new File("licitatii.csv");
            RandomAccessFile in = new RandomAccessFile(file, "r");
            String currentLine;
            while ((currentLine = in.readLine()) != null){

                String[] getAttributes = currentLine.split(",");
                Licitatie licitatie = new Licitatie(Integer.parseInt(getAttributes[0]), Integer.parseInt(getAttributes[1]));
                licits.add(licitatie);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return licits;
    }


    public ArrayList<Obiect>  citireObjects(){
        ArrayList<Obiect> obiects = new ArrayList<>();

        try{
            File file =new File("obiect.csv");
            RandomAccessFile in = new RandomAccessFile(file, "r");
            String currentLine;
            while ((currentLine = in.readLine()) != null){

                String[] getAttributes = currentLine.split(",");
                if(getAttributes[0].equals("Masina")){
                    Masini masini= new Masini(Integer.parseInt(getAttributes[1]),Integer.parseInt(getAttributes[2]),Integer.parseInt(getAttributes[3]),Integer.parseInt(getAttributes[4]), getAttributes[5],getAttributes[6]);
                    obiects.add(masini);
            }else
                if(getAttributes[0].equals("Marfuri")){
                    Marfuri marfuri= new Marfuri(Integer.parseInt(getAttributes[1]),Integer.parseInt(getAttributes[2]),Integer.parseInt(getAttributes[3]), getAttributes[4],getAttributes[5]);
                    obiects.add(marfuri);
                }
                else      if(getAttributes[0].equals("Teren")){
                   Terenuri terenuri= new Terenuri(Integer.parseInt(getAttributes[1]),Integer.parseInt(getAttributes[2]), getAttributes[3],getAttributes[4]);
                    obiects.add(terenuri);
                }
                else      if(getAttributes[0].equals("Casa")){
                    Case casa= new Case(Integer.parseInt(getAttributes[1]),Integer.parseInt(getAttributes[2]),Integer.parseInt(getAttributes[3]),Integer.parseInt(getAttributes[4]), getAttributes[5],getAttributes[6]);
                    obiects.add(casa);
                }

        }}catch (IOException e){
            System.out.println(e.getMessage());
        }

        return obiects;
    }








}
