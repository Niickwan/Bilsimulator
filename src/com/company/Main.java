package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        System.out.println("Opret din bil: ");
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Drivkraft: ");
        String drivkraft = scanner.nextLine();
        System.out.print("Antal døre: ");
        int dore = scanner.nextInt();
        System.out.print("Antal hjul: ");
        int hjul = scanner.nextInt();

        Bil bil = new Bil(type, model, drivkraft, dore, hjul);

        System.out.println("\nBilobjektet er oprettet.\n");
        System.out.println(bil + "\n");
        while (run) {
            System.out.println("Venter på kommando (fx start, stop, accelerer, brems, drej, status (Skriv q for at afslutte))");
            String doWhat = scanner.next();

            switch (doWhat) {
                case "start" -> {
                    bil.startMotor();
                }
                case "stop" -> {
                    bil.slukMotor();
                }
                case "accelerer" -> {
                    System.out.print("Hvor mange % vil du trykke på speederen? (0-100): ");
                    double speeder = scanner.nextInt();
                    bil.accelererBil(speeder);
                }
                case "brems" -> {
                    System.out.print("hvilken hastighed ønsker du at bremse ned til? (km/t): ");
                    double bremsKmT = scanner.nextInt();
                    bil.brems(bremsKmT);
                }
                case "drej" -> {
                    System.out.print("Hvilken vej ønsker du at dreje? (Venstre/Højre):");
                    String drejVej = scanner.next();
                    System.out.print("Hvor meget ønsker du at dreje (i %): ");
                    int drejProcent = scanner.nextInt();
                    bil.drej(drejVej, drejProcent);
                }
                case "status" -> {
                    bil.status();
                }
                case "q" -> {
                    run = false;
                }
            }
        }
    }
}
