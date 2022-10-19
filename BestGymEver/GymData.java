package BestGymEver;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class GymData {

    String fileName;
    List<Member> memberList;


    public GymData(String fileName) {
        this.fileName = fileName;
        this.memberList = ReadFile();
    }

    private List<Member> ReadFile() {

        String infoString;
        List<Member> members = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            Member addMember;
            while ((infoString = br.readLine()) != null) {
                int indexOfComma = infoString.indexOf(",");
                String ID = (infoString.substring(0, indexOfComma));

                String name = infoString.substring(indexOfComma + 2);
                infoString = br.readLine();

                int indexOfFirstDash = infoString.indexOf("-");
                int indexOfLastDash = infoString.lastIndexOf("-");
                int year = Integer.parseInt(infoString.substring(0, indexOfFirstDash));
                int month = Integer.parseInt(infoString.substring(indexOfFirstDash + 1, indexOfLastDash));
                int day = Integer.parseInt(infoString.substring(indexOfLastDash + 1));

                LocalDate lastPayment = LocalDate.of(year, month, day);
                addMember = new Member(name, ID, lastPayment);
                members.add(addMember);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return members;
    }

    public Member searchMember(String search) {
        for (Member member : memberList) {
            if (search.trim().equalsIgnoreCase(member.getID()) || search.trim().equalsIgnoreCase(member.getName())) {
                return member;
            }
        }
        return null;
    }
}
