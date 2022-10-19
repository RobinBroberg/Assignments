package BestGymEver;

import javax.swing.*;

public class Panel {
    public Panel() {

        GymData data = new GymData("src/BestGymEver/GymMembers.txt");
        PersonalTrainer pt = new PersonalTrainer();
        boolean run = true;
        try {
            while (run) {
                String input = JOptionPane.showInputDialog("Please enter the customer name or ID");
                if (input == null) {
                    run = false;
                } else if (data.searchMember(input) != null) {
                    Member member = data.searchMember(input);
                    JOptionPane.showMessageDialog(null, member.getInfo());
                    if (member.getActiveSub().equalsIgnoreCase("active")) {
                        pt.PTcustomerFile(member);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not registered in the system");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}