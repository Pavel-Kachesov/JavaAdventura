package cz.vse.java.adventura.logika;
import java.util.Map;


public class PrikazPrecti implements IPrikaz{


    private static final String NAZEV = "precti";
    private  Map<String, Vec> veci;
    private Batoh batoh;
    private Hra hra;
    private HerniPlan herniPlan;




    public PrikazPrecti(Batoh batoh, Hra hra, HerniPlan herniPlan) {
        this.batoh = batoh;
        this.hra = hra;
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        veci = batoh.getBatoh();
        if(veci.size() == 0) {
        return "Nejsou knihy ke čtení";
        }
        if (parametry == null) {
            return "Co byste chtěli přečíst? Napište název knihy";
        }

        String nazevVeci = parametry[0];
        Vec vec = veci.get(nazevVeci);
        if (veci.get(nazevVeci) == null) {
            return "Žadná kniha neobsahuje tento název";
        }

        if (nazevVeci.equals("Kompas")) {
            return  "\nNemůžete přečíst kompas.";
        }
        if (nazevVeci.equals("Nekronomicon") && !herniPlan.getAktualniProstor().getNazev().equals("Chram_Rlyeh")){
            hra.setKonecHry(true);
            return "Po přečtení této knihy jste se zbláznil a navždy jste byl zavřen do psychiatrické léčebně.\n" +
                    "\n"+
                    "  ____    _    __  __ _____    _____     _______ ____  \n" +
                    " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                    "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                    "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                    " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\"+
                    "\n";
        }

        return  vec.getObsah();
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}
