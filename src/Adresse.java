public class Adresse {
    private String ort;
    private String plz;
    private String strasse;
    private String hausnummer;

    public Adresse(String ort, String plz, String strasse, String hausnummer) {
        this.ort = ort;
        this.plz = plz;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
    }

    public String getOrt() {
        return ort;
    }

    public String getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String toString() {
        return getPlz() + " " + getOrt() + " " + getStrasse() + " " + getHausnummer();
    }

}


