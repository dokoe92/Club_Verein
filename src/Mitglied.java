import java.util.Random;

public class Mitglied {
    private String vorname;
    private String nachname;
    private Character geschlecht;
    private String mitgliedskennung;


    public Mitglied(String vorname, String nachname, Character geschlecht, String mitgliedskennung) {
        this.vorname = vorname;
        this.nachname = nachname;
        checkGeschlechtInput(geschlecht);
        checkMitgliedserkennung(mitgliedskennung);
    }

    public Mitglied(String vorname, String nachname, Character geschlecht) {
        this.vorname = vorname;
        this.nachname = nachname;
        checkGeschlechtInput(geschlecht);
        zufallsKennzahl();
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

    public void printAll() {
        System.out.println("Vorname: " + this.vorname);
        System.out.println("Nachname: " + this.nachname);
        System.out.println("Geschlecht: " + this.geschlecht);
        System.out.println("Mitgliedskennung " + this.mitgliedskennung);
    }

    public void zufallsKennzahl() {
         this.mitgliedskennung = "MG-" + getRandomNumber(1000, 10000);
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max-min) + min;
        return randomNumber;
    }








}
