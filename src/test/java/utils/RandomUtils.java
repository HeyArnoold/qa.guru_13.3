package utils;

import java.util.Random;

public class RandomUtils {
    private Random random = new Random();
    private final String ncr = "NCR", uttar = "Uttar Pradesh", haryana = "Haryana", rajasthan = "Rajasthan";

    public String setRandomGender() {
        int randomNum = random.nextInt(3);

        if (randomNum == 0) {
            return "Male";
        } else if (randomNum == 1) {
            return "Female";
        } else {
            return "Other";
        }
    }

    public String setRandomSubject() {
        return "";
    }

    public String setRandomState() {
        int randomNum = random.nextInt(4);

        if (randomNum == 0) {
            return ncr;
        } else if (randomNum == 1) {
            return uttar;
        } else if (randomNum == 2) {
            return haryana;
        } else {
            return rajasthan;
        }
    }

    public String setRandomCity(String currentState) {
        int randomNumFor3 = random.nextInt(3);
        int randomNumFor2 = random.nextInt(2);

        switch (currentState) {
            case (ncr):
                if (randomNumFor3 == 0) {
                    return "Delhi";
                } else if (randomNumFor3 == 1) {
                    return "Gurgaon";
                }else {
                    return "Noida";
                }

            case (uttar):
                if (randomNumFor3 == 0) {
                    return "Agra";
                } else if (randomNumFor3 == 1) {
                    return "Lucknow";
                }else {
                    return "Merrut";
                }

            case (haryana):
                return randomNumFor2 == 0 ? "Karnal" : "Panipat";

            default:
                return randomNumFor2 == 0 ? "Jaipur" : "Jaiselmer";
        }
    }
}
