package cz.vse.java.adventura.logika;


public class PrikazVyhodit implements IPrikaz{
    private static final String NAZEV = "vyhodit";
    private Batoh batoh;
    private HerniPlan herniPlan;

    public PrikazVyhodit(Batoh batoh, HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }


    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co chcete vyhodit? Napište název věci.";
        }

        String nazevVeci = parametry[0];


        Vec vec = batoh.getVec(nazevVeci);
        if (vec == null) {
            return "Nemáte takovou věc :(";
        }

        herniPlan.getAktualniProstor().setVec(vec);
        batoh.vyhod(vec);
        return "Jste vyhodili věc " + nazevVeci + " z batohu.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
