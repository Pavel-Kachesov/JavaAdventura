package cz.vse.java.adventura.logika;
import java.util.Map;

public class PrikazPouzit implements IPrikaz{


    private static final String NAZEV ="pouzit";
    private Map<String, Vec> veci;
    private HerniPlan herniPlan;
    private Batoh batoh;
    private Hra hra;


    public PrikazPouzit(HerniPlan herniPlan, Batoh batoh, Hra hra) {
        this.herniPlan = herniPlan;
        this.batoh = batoh;
        this.hra = hra;
        veci = batoh.getBatoh();

    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím co chcete použit";
        }
        if (parametry.length > 1) {
            return "Příliš hodně slov, napiště název věci jako jedno slovo";
        }
        Vec vec = batoh.getVec(parametry[0]);
        if (vec == null) {
            return "Taková věc není v batohu";
        }


        if (parametry[0].equals("Nekronomicon")) {
            if (herniPlan.getAktualniProstor().getNazev().equals("Chram_Rlyeh")) {
                batoh.vyhod(vec);
                if (batoh.masVec("Kompas")){
                hra.setKonecHry(true);
                return "Gratuluji, použili jste knižní kouzlo proti Ktulhu. Teď Ktulhu usnul na " +
                        "100 let. Jste zahranil tento svět.";
                }
                else {
                   return "Potrebujete artefakt pro ukončení ritualu. (Musí mít ručíčky v sobě o " +
                           "tom jste přečetl v Necronomikonu.";
                }
            }
            return "Nemůžete použit Nekronomicon v aktuálním prostoru";
        }
        return "Nemůžete použit Nekronomicon teď";
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}
