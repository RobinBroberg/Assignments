package BestGymEver;

import java.time.LocalDate;

public class Member {
    private final String name;

    private final String ID;

    private final LocalDate lastPayment;

    private final String activeSub;


    public Member(String name, String ID, LocalDate lastPayment) {
        this.name = name;
        this.ID = ID;
        this.lastPayment = lastPayment;
        this.activeSub = currentlySubbed();
    }

    private String currentlySubbed() {
        if (lastPayment.isBefore(LocalDate.now().minusYears(1))) {
            return "Inactive";
        } else {
            return "Active";
        }

    }

    public String getInfo() {
        return "Name: " + name + "\n" + "ID: " + ID + "\n" + "Last payment: " + lastPayment + "\n"
                + "Subscription status: " + activeSub;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getActiveSub() {
        return activeSub;
    }

}
