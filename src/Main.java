



public class Main {
    public static void main(String[] args) {

        Mitglied mitglied1 = new Mitglied("Dominik", "Köberl", 'm', "1234567");
        Mitglied mitglied2 = new Mitglied("Hans", "Wurst", 'd', "123");
        Mitglied mitglied3 = new Mitglied("Julia", "Kötl", 'w', "12b34");
        Mitglied mitglied4 = new Mitglied("Peter", "Wuhan", 'm', "abcdfeg");
        Mitglied mitglied5 = new Mitglied("Hannah", "Ted", 'x',"abddflkjdfljdfld");

        Verein verein = new Verein("Superduper");

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

        Mitglied mitglied6 = new Mitglied("Karl", "Auto", 'd');
        mitglied6.printAll();


    }
}