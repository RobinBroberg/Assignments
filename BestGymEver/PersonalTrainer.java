package BestGymEver;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonalTrainer {

    public void PTcustomerFile(Member member) {
        try {
            String fileName = "PT-Customers";
            LocalDateTime time = LocalDateTime.now();
            LocalDateTime day = LocalDateTime.now();
            String ID = "ID: " + member.getID() + "\n";
            String name = "Name: " + member.getName() + "\n";
            String lastVisit = "Last visit: " + day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd "))
                    + time.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n\n";
            fileName = "src/BestGymEver/" + fileName + ".txt";
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ID + name + lastVisit);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
