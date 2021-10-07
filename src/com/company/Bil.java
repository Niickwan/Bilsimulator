package com.company;
import java.util.Random;

public class Bil {
    private String biltype;
    private String model;
    private String drivkraft;
    private int stelnummer;
    private int antalDore;
    private String softwareversion;
    private String gpsKoordinater;
    private double hastighed;
    private double omdrejninger;
    private int hjul;
    private int rat;
    private int brems;
    private int speeder;
    private int retning;
    private boolean motor;

    public Bil () {

    }

    public Bil (String biltype, String model, String drivkraft, int antalDore, int hjul) {
        Random random = new Random();
        this.biltype = biltype;
        this.model = model;
        this.drivkraft = drivkraft;
        this.antalDore = antalDore;
        this.hjul = hjul;
        this.stelnummer = random.nextInt(99999999);
        this.softwareversion = random.nextInt(9) + "." + random.nextInt(9) + "." + random.nextInt(9);
        this.gpsKoordinater = random.nextInt(999) + "." + random.nextInt(999999) + ", " + random.nextInt(999) + "." + random.nextInt(999999);
        this.hastighed = 0;
        this.omdrejninger = 0;
        this.rat = 0;
        this.brems = 0;
        this.speeder = 0;
        this.retning = 0;
        this.motor = false;
    }

    public void startMotor() {
        this.motor = true;
        System.out.println("Motoren er nu tændt.\n");
    }

    public void slukMotor() {
        this.motor = false;
        System.out.println("Motoren er nu slukket.\n");
    }

    public void accelererBil(double speeder) {
        System.out.println("Du trykker nu på speeder med: " + speeder + "%");
        this.omdrejninger = 8000 * (speeder / 100);
        this.hastighed = this.omdrejninger / 26.66;
        System.out.printf("Du køer med: %4.0f omdrejninger i minuttet!\n", this.omdrejninger);
        System.out.printf("Og bilen kører med: %3.0f km/t\n\n", this.hastighed);
    }

    public void brems(double bremsKmT) {
        this.hastighed = bremsKmT;
        this.omdrejninger = hastighed * 26.66;
        System.out.printf("Bilen kører nu med: %3.0f km/t\n", this.hastighed);
        System.out.printf("og du køer med: %4.0f omdrejninger i minuttet!\n\n", this.omdrejninger);
    }

    public void drej(String drejVej, int drejProcent) {
        System.out.println("Du drejer nu " + drejProcent + " % mod " + drejVej);
        if (drejVej.equalsIgnoreCase("venstre")) {
            this.retning = this.retning - drejProcent;
        } else if (drejVej.equalsIgnoreCase("højre")) {
            this.retning = this.retning + drejProcent;
        }
        if (this.retning > 0) {
            System.out.println("Din retning er nu: " + this.retning + " % mod højre\n");
        } else if (this.retning < 0){
            System.out.println("Din retning er nu: " + this.retning + " % mod venstre\n");
        } else {
            System.out.println("Du kører nu lige ud!\n");
        }
    }

    public void status () {
        System.out.print("Din " + this.biltype + " " + this.model + " køre med: " + this.hastighed + " km/t og retningen er ");
        if (this.retning > 0) {
            System.out.println(this.retning + " % mod højre\n");
        } else if (this.retning < 0){
            System.out.println(this.retning + " % mod venstre\n");
        } else {
            System.out.println("lige ud!\n");
        }
    }

    public String toString() {
        return  "Biltype: " + biltype + "\n" +
                "Model: " + model + "\n" +
                "Stelnummer: " + stelnummer + "\n" +
                "Antal døre: " + antalDore + "\n" +
                "Softwareversion: " + softwareversion + "\n" +
                "GPS koordinater: " + gpsKoordinater + "\n" +
                "Hastighed: " + hastighed + " km/t";
    }
}