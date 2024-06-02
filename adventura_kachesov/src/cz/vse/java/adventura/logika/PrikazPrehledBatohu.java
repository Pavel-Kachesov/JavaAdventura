package cz.vse.java.adventura.logika;

import java.util.Map;


public class PrikazPrehledBatohu implements IPrikaz {
    private static final String NAZEV = "prehledBatohu";
    private Batoh batoh;
    private Map<String, Vec> veci;

    public PrikazPrehledBatohu(Batoh batoh) {
        this.batoh = batoh;
        veci = batoh.getBatoh();
    }


    @Override
    public String provedPrikaz(String... parametry) {
        if(batoh.prehled() == "") {
            return "Batoh je prazdný.";
        }
        String popisVeci = "";
        for (Vec vec : veci.values()) {
            popisVeci += vec.getNazev() + " - " + vec.getPopis() + "\n";
        }
        return popisVeci;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
