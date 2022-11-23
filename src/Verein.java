import java.util.ArrayList;
import java.util.Iterator;


public class Verein {
    private String vereinsname;
    private ArrayList<Mitglied> mitglieder;
    private final int stellplaetze = 3;


    public Verein(String vereinsname) {
        this.vereinsname = vereinsname;
        this.mitglieder = new ArrayList<>();

    }

    public void addMitglied(Mitglied newMitglied) {
        if (newMitglied != null) {
            mitglieder.add(newMitglied);
        }
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

    public ArrayList<Mitglied> searchNachname(String searchString) {
        ArrayList<Mitglied> mitgliederMitNachname = new ArrayList<>();
        for (Mitglied mitglied : mitglieder) {
            if (mitglied.getNachname().toLowerCase().contains(searchString.toLowerCase())) {
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

    public void removeMitgliedBeginningWithSearchstring(String serachString) {
        mitglieder.removeAll(searchNachname(serachString));
    }





}
