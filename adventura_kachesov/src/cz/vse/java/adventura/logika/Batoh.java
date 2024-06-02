package cz.vse.java.adventura.logika;

import java.util.HashMap;
import java.util.Map;


public class Batoh {

    private Map<String, Vec> batoh = new HashMap<>();
    public int pocetVeci = 0;


    public boolean vloz(Vec vec) {
        if(batoh.size() < 4){
            batoh.put(vec.getNazev(), vec);
            pocetVeci++;
            return true;}
        else {
            return false;
        }
    }


    public boolean vyhod(Vec vec) {
        if (batoh.size() > 0) {
            batoh.remove(vec.getNazev());
            return true;
        }
        return false;
    }


    public String prehled() {
        String prehled = "";
        for (String vec : batoh.keySet()) {
            prehled += vec + " ; ";
        }
        return prehled;
    }


    public Map<String, Vec> getBatoh() {
        return batoh;
    }

    public Vec getVec(String nazev) {
        return batoh.get(nazev);
    }

    public boolean masVec(String nazev){
        Vec vec = batoh.get(nazev);
        if (vec == null) {
            return false;
        }
        return true;

    }


}
