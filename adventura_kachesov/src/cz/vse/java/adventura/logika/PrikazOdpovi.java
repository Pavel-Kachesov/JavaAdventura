package cz.vse.java.adventura.logika;

public class PrikazOdpovi implements IPrikaz{
    private static final String NAZEV = "odpovi";
    Hra hra;
    HerniPlan herniPlan;



    public PrikazOdpovi(Hra hra, HerniPlan herniPlan) {
        this.hra = hra;
        this.herniPlan = herniPlan;

    }


    @Override
    public String provedPrikaz(String... parametry) {
        String odpoved = parametry[0];
        if (odpoved == null) {
            return "Můžete odpovědět a nebo b";
        }
        if (herniPlan.getAktualniProstor().getNazev().equals("Knihovna")){
        if (odpoved.equals("b")) {
            return  "Nekronomicon je v batohu.Ukradl jste knihu, tentokrát si toho nikdo nevšiml, ale příště buď " +
                    "opatrnější. ";
        }
        if (odpoved.equals("a")) {
            hra.setKonecHry(true);
            return "Knihovnice zavolala policii, protože tato kniha slouží jako návnada k chytání bláznů. Protože je k" +
                    " sobe přitahuje. Teď strávíte zbytek života v psychiatrické léčebně.";
        }
        return "Zadal jste nevhodné písmeno. Můžete napsat nebo a, nebo b";
        }
        if (herniPlan.getAktualniProstor().getNazev().equals("Bažiny")){
            if (odpoved.equals("b")) {
                return "Leda h***o, dal 3 dny spink,pak k***a vstal a šel něco dělat." +
                        "\n "+ "\n Nyní máte i vy druhou šanci, byli jste vzkříšeni a začali hru znovu." + hra.vratUvitani();
            }
            if (odpoved.equals("a")) {
                hra.setKonecHry(true);
                return "Špatná odpověď" +
                        "\n" +
                        "  ____    _    __  __ _____    _____     _______ ____  \n" +
                        " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                        "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                        "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                        " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\"+
                        "\n";
            }
            return "Zadal jste nevhodnou odpověď. Můžete napsat nebo a, nebo b";
        }
        return "Nemate na co odpovídat.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

