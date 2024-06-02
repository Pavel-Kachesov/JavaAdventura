package cz.vse.java.adventura.logika;


public class Vec {
    private final String nazev;
    private String popis;
    private String obsah;

    public Vec(String nazev, String popis, String obsah) {
        this.nazev = nazev;
        this.popis = popis;
        this.obsah = obsah;

    }

    public String getNazev() {
        return nazev;
    }


    public String getPopis() {
        return popis;
    }

    public String getObsah(){return obsah; }

}
