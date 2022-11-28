import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Verein {
    private String vereinsname;
    private ArrayList<Mitglied> mitglieder;
    private final int stellplaetze;


    public Verein(String vereinsname, int stellplaetze) {
        this.vereinsname = vereinsname;
        this.mitglieder = new ArrayList<>();
        this.stellplaetze = stellplaetze;

    }

    public void addMitglied(Mitglied newMitglied) {
        if (newMitglied != null) {
            mitglieder.add(newMitglied);
        }
    }

    public void addMitglied(String vorname, String nachname, char sex, boolean carowner) {
        mitglieder.add(new Mitglied(vorname, nachname, sex, carowner));
    }

    public int countMitglieder() {
        int count = 0;
        for (Mitglied mitglied : mitglieder) {
            count++;
        }
        System.out.println("Der Verein hat " + count + " Mitglieder");
        return count;
    }

    public void deleteMitglied(int index) {
        if(index >= 0 && index < mitglieder.size()) {
            mitglieder.remove(index);
        }
    }

    public void deleteAllMitglieder() {
        Iterator<Mitglied> it = mitglieder.iterator();
        while (it.hasNext()) {
            Mitglied mitglied = it.next();
            it.remove();
        }
    }

    public void clearMitglieder() {
        mitglieder.clear();
    }

    public void printAll() {
        System.out.println(this.vereinsname);
        countMitglieder();
        System.out.println("Folgende Mitglieder im Verein: ");
        for(Mitglied mitglied : mitglieder) {
            mitglied.printAll();
            System.out.println("");
        }
        System.out.println("-----");
    }

    public ArrayList<Mitglied> searchNachnameStartsWith(String searchString) {
        ArrayList<Mitglied> mitgliederMitNachname = new ArrayList<>();
        for (Mitglied mitglied : mitglieder) {
            if (mitglied.getNachname().toLowerCase().startsWith(searchString.toLowerCase())) {
                mitgliederMitNachname.add(mitglied);
            }
        }
        return mitgliederMitNachname;
    }

    public void deleteInvalidMitglieder() {
        Iterator<Mitglied> it = mitglieder.iterator();
        while(it.hasNext()) {
            Mitglied mitglied = it.next();
            if (mitglied.getMitgliedskennung().contains("UNGÜLTIG")) {
                it.remove();
            }
        }
    }

    public void removeMitgliedBeginningWithSearchstring(String searchString) {
        mitglieder.removeAll(searchNachnameStartsWith(searchString));
    }

    public void verlosen() {
        int anzahlMitgliederMitFarzeug = 0;
        ArrayList<Mitglied> mitgliederMitFahrzeug = new ArrayList<>();
        ArrayList<Mitglied> habenGewonnen = new ArrayList<>();


        // Get Mitglieder with isFahrzeug true and add to mitglierderMitFahrzeugen + increase counter of anzahlMitgliederMitFahrzeug
        for (Mitglied mitglied : mitglieder) {
            if (mitglied.isFahrzeugBesitzer()){
                mitgliederMitFahrzeug.add(mitglied);
                anzahlMitgliederMitFarzeug++;
            }
        }

        // Print out all mitglieder with fahrzeug
        System.out.println("Mitglieder mit Fahrzeugen: ");
        for(Mitglied mitAuto : mitgliederMitFahrzeug) {
            mitAuto.printAll();
        }
        System.out.println("\n");

        // get a random number and put the index of mitgliedermitFahrzeug to the winner array
        // only add if the winner (address of the object) is not already in the winner array
        int bereitsVergeben = 0;
        int counter = 0;
        while (bereitsVergeben < stellplaetze && counter < mitgliederMitFahrzeug.size()) {
            Random random = new Random();
            int lotterie = random.nextInt(mitgliederMitFahrzeug.size());
            Mitglied gewinner = mitgliederMitFahrzeug.get(lotterie);
            if(!habenGewonnen.contains(gewinner)){
                habenGewonnen.add(gewinner);
                counter++;
                bereitsVergeben++;
            }
        }

        //
        System.out.println("======= PARKPLATZVERLOSUNG =======");
        System.out.println("Anzahl der verfügbaren Parkplätze: " + stellplaetze);
        System.out.println("Mitglieder mit Fahrzeugen " + anzahlMitgliederMitFarzeug);
        for (Mitglied gewinner : habenGewonnen) {
            gewinner.printAll();
        }
        System.out.println("\n");

    }

}
