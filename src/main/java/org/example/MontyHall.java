package org.example;



import java.util.HashMap;
import java.util.Random;


public class MontyHall {
    private static final int TOTAL_RUNS = 1000;
    private HashMap<Integer, Boolean> results = new HashMap<>();
    private Random random = new Random();

    public void runSimulation() {
        int wins = 0;
        for (int i = 0; i < TOTAL_RUNS; i++) {
            boolean win = simulateGame();
            results.put(i + 1, win);
            if (win) {
                wins++;
            }
        }
        System.out.println("Total Wins: " + wins);
        System.out.println("Total Losses: " + (TOTAL_RUNS - wins));
    }

    private boolean simulateGame() {
        int winningDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);
        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == winningDoor || revealedDoor == chosenDoor);

        int switchedDoor;
        do {
            switchedDoor = random.nextInt(3);
        } while (switchedDoor == chosenDoor || switchedDoor == revealedDoor);

        return switchedDoor == winningDoor;
    }

    public static void main(String[] args) {
        MontyHall montyHall = new MontyHall();
        montyHall.runSimulation();
    }
}
