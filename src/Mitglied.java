import java.util.HashMap;
import java.util.Random;

public class Mitglied {
    private String vorname;
    private String nachname;
    private Character geschlecht;
    private String mitgliedskennung;
    private boolean fahrzeugBesitzer;

    private HashMap<String, Adresse> adressen;

    private static int laufendeNr = 0;


    public Mitglied(String vorname, String nachname, Character geschlecht, String mitgliedskennung, boolean fahrzeugBesitzer) {
        this.vorname = vorname;
        this.nachname = nachname;
        checkGeschlechtInput(geschlecht);
        checkMitgliedserkennung(mitgliedskennung);
        this.fahrzeugBesitzer = fahrzeugBesitzer;
    }

    public Mitglied(String vorname, String nachname, Character geschlecht, boolean fahrzeugBesitzer) {
        this.vorname = vorname;
        this.nachname = nachname;
        checkGeschlechtInput(geschlecht);
        zufallsKennzahl();
        this.fahrzeugBesitzer = fahrzeugBesitzer;
    }

    public void checkMitgliedserkennung(String kennung) {
        if (kennung.length() < 6 || kennung.length() >= 10) {
            this.mitgliedskennung = "UNGÜLTIG";
        }
        else {
            this.mitgliedskennung = kennung;
        }
    }

    public void checkGeschlechtInput (Character geschlecht) {
        if (geschlecht.equals('w') || geschlecht.equals('m') ||geschlecht.equals('d')) {
            this.geschlecht = geschlecht;
        } else {
            this.geschlecht = '-';
        }
    }

    public String getVorname() {
        System.out.println("Der Vorname ist: " + this.vorname);
        return this.vorname;
    }

    public void setVorname(String changedVorname) {
        this.vorname = changedVorname;
        System.out.println("Vorname auf " + this.vorname + " geändert!");
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String changedNachname) {
        this.nachname = changedNachname;
        System.out.println("Nachname auf " + this.nachname + " geändert!");
    }

    public void getGeschlecht() {
        System.out.println("Das Geschlecht ist + " + this.geschlecht);
    }

    public Character setGeschlecht(Character changedGeschlecht) {
        this.geschlecht = changedGeschlecht;
        System.out.println("Geschlecht auf: " + this.geschlecht + " geändert!");
        return this.geschlecht;
    }

    public String getMitgliedskennung() {
        return this.mitgliedskennung;
    }

    public boolean isFahrzeugBesitzer() {
        return this.fahrzeugBesitzer;
    }

    public void printAll() {
        System.out.println("Vorname: " + this.vorname + ", Nachname: " + this.nachname + ", Kennung: " + this.mitgliedskennung + ", Geschlecht: " + this.geschlecht);
    }

    public void zufallsKennzahl() {
         this.mitgliedskennung = "MG-" + String.format("%03d", laufendeNr) + "-" + getRandomNumber(1000, 10000);
         laufendeNr++;
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max-min) + min;
    }

    public void changeAddress(String type, Adresse address) {
        this.adressen = new HashMap<>();
        if (type.equals("Billing")) {
            this.adressen.put(type, address);
        } else if (type.equals("Post")) {
            this.adressen.put(type, address);
        } else {
            System.out.println("Keine gültige Adresse");
        }

    }

    public Adresse getBillingAddress() {
        return adressen.get("Billing");
    }

    public Adresse getPostAddress() {
        return adressen.get("Post");
    }












}
