



public class Main {
    public static void main(String[] args) {

        Mitglied mitglied1 = new Mitglied("Dominik", "Köberl", 'm', true);
        Mitglied mitglied2 = new Mitglied("Hans", "Wurst", 'd', false);
        Mitglied mitglied3 = new Mitglied("Julia", "Kötl", 'w', true );
        Mitglied mitglied4 = new Mitglied("Peter", "Wuhan", 'm', true);
        Mitglied mitglied5 = new Mitglied("Hannah", "Ted", 'x', true);

        Verein verein = new Verein("Superduper", 3);

        verein.addMitglied(mitglied1);
        verein.addMitglied(mitglied2);
        verein.addMitglied(mitglied3);
        verein.addMitglied(mitglied4);
        verein.addMitglied(mitglied5);

       /* mitglied5.setGeschlecht('d');
        mitglied5.printAll();

        verein.countMitglieder();
        verein.deleteMitglied(3);
        verein.countMitglieder();

        //verein.deleteAllMitglieder();
        //verein.countMitglieder();*/


        /*System.out.println(verein.searchNachname("Kö"));
        verein.deleteInvalidMitglieder();
        verein.printAll();*/

        /*verein.printAll();
        verein.removeMitgliedBeginningWithSearchstring("Kö");
        verein.printAll();*/



        verein.vote();


    }
}