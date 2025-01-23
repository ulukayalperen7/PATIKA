package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FixtureCreator {
    public static void main(String[] args) {

        List<String> listOfTeams = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("number of teams : ");
        int numberOfTeams = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfTeams; i++) {
            System.out.print((i + 1) + ". team: ");
            String name = scanner.nextLine();
            listOfTeams.add(name);
        }

        if (numberOfTeams % 2 != 0) {
            listOfTeams.add("Bay");
        }

        int totalTeams = listOfTeams.size();
        int match = totalTeams / 2;
        int numberOfRound = totalTeams - 1;

        Collections.shuffle(listOfTeams);

        for (int i = 0; i < numberOfRound; i++) {
            System.out.println("     Round " + (i + 1));
            for (int j = 0; j < match; j++) {
                int home = (i + j) % (totalTeams - 1);
                int away = (totalTeams - 1 - j + i) % (totalTeams - 1);

                if (j == 0) {
                    away = totalTeams - 1;
                }

                System.out.println(listOfTeams.get(home) + " vs " + listOfTeams.get(away));
            }
        }
        for (int i = 0; i < numberOfRound; i++) {
            System.out.println("  Round " + (numberOfRound + i + 1));
            for (int j = 0; j < match; j++) {
                int home = (i + j) % (totalTeams - 1);
                int away = (totalTeams - 1 - j + i) % (totalTeams - 1);

                if (j == 0) {
                    away = totalTeams - 1;
                }

                System.out.println(listOfTeams.get(away) + " vs " + listOfTeams.get(home));
            }
        }
    }
}
