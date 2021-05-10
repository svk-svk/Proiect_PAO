package Etapa_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditService  {

    public static AuditService serviceInstance = null;
    private BufferedWriter bf;

    private AuditService() {
        Open();
    }

    private void Open(){
        try {

            File file =new File("log.csv");
            FileWriter f= new FileWriter(file, true);
            bf = new BufferedWriter(f);

        } catch (IOException err) {
            System.out.println("Eroare la deschidere fisier");
        }
    }

    public static AuditService getInstance() {
        if (serviceInstance == null) {
            serviceInstance = new AuditService();

        }

        return serviceInstance;
    }

    public void Write(String action){
        try {
            LocalDateTime time = LocalDateTime.now();
            bf.write(action + "," + time.getDayOfMonth() + "-" + time.getMonth() + "-" + time.getYear() + " "
                    + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + '\n');

            bf.flush();
        } catch (IOException err) {
            System.out.println("Eroare la scriere in fisier");
        }
    }

    public void Close() {
        try {
            bf.close();
        } catch (IOException err) {
            System.out.println("Eroare la inchidere fisier");
        }
    }
}