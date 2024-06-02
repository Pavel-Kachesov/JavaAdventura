package cz.vse.java.adventura.logika;



public class PrikazSeber implements IPrikaz {

    private static final String NAZEV = "seber";
    private final HerniPlan herniPlan;
    private Batoh batoh;


    public PrikazSeber(HerniPlan herniPlan, Batoh batoh) {
        this.herniPlan = herniPlan;
        this.batoh = batoh;

    }


    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím co chcete sebrat.";
        }


        String nazevVeci = parametry[0];


        Vec vec = herniPlan.getAktualniProstor().vratVec(nazevVeci);

        if (vec == null) {
            return "Taková věc není v aktualním prostoru";
        }

        if (batoh.pocetVeci<4){
            if (vec.getNazev().equals("Nekronomicon")){
                batoh.vloz(vec);
                herniPlan.getAktualniProstor().odstranitVec(nazevVeci);
                return "Dale odpověz na otazku(napíš \"odpovi a\" nebo \"odpovi b\" podle vašeho rozhodnuti. \n"+
                        "Otazka: Chcete půjčit knihu? a = ano (půjčit), b = ne (ukrast)";
            }
            batoh.vloz(vec);
            herniPlan.getAktualniProstor().odstranitVec(nazevVeci);
            return "Vec " + nazevVeci + " byla sebrana";
        }
        else {
            return "Nemáš dost místa v batohu, vyhod něco.";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
