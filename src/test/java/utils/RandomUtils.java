package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private final String ncr = "NCR", uttar = "Uttar Pradesh", haryana = "Haryana", rajasthan = "Rajasthan";

    public String setRandomGender() {
        int randomNum = getRandomInt(1, 3);

        if (randomNum == 1) {
            return "Male";
        } else if (randomNum == 2) {
            return "Female";
        } else {
            return "Other";
        }
    }

    public String[] setRandomSubjects() {
        String[] allSubjects = {"Computer Science", "English", "Chemistry", "Commerce", "Economics", "Social Studies",
                "Arts", "Maths", "History", "Accounting", "Physics", "Biology", "Hindi", "Civics"};

        List<String> subjects = new ArrayList<>(List.of(allSubjects));
        Collections.shuffle(subjects);
        int randomLength = getRandomInt(1, subjects.size());

        String[] randomSubjects = new String[randomLength];
        for (int i = 0; i < randomSubjects.length; i++) {
            randomSubjects[i] = subjects.get(i);
        }

        return randomSubjects;
    }

    public String setRandomState() {
        int randomNum = getRandomInt(1, 4);

        if (randomNum == 1) {
            return ncr;
        } else if (randomNum == 2) {
            return uttar;
        } else if (randomNum == 3) {
            return haryana;
        } else {
            return rajasthan;
        }
    }

    public String setRandomCity(String currentState) {
        int randomNumFor3 = getRandomInt(1, 3);
        int randomNumFor2 = getRandomInt(1, 2);

        switch (currentState) {
            case (ncr):
                if (randomNumFor3 == 1) {
                    return "Delhi";
                } else if (randomNumFor3 == 2) {
                    return "Gurgaon";
                } else {
                    return "Noida";
                }

            case (uttar):
                if (randomNumFor3 == 1) {
                    return "Agra";
                } else if (randomNumFor3 == 2) {
                    return "Lucknow";
                } else {
                    return "Merrut";
                }

            case (haryana):
                return randomNumFor2 == 1 ? "Karnal" : "Panipat";

            default:
                return randomNumFor2 == 1 ? "Jaipur" : "Jaiselmer";
        }
    }

    private int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }
}
