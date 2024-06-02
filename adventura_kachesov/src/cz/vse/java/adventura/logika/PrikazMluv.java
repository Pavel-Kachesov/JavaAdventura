package cz.vse.java.adventura.logika;
import java.util.Map;

public class PrikazMluv implements IPrikaz {

    private static final String NAZEV = "mluv";
    private Map<String, Postava> postavy;
    private HerniPlan herniPlan;
    private Hra hra;


    public PrikazMluv(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;

    }


    @Override
    public String provedPrikaz(String... parametry) {
        postavy = herniPlan.getAktualniProstor().getPostavy();

        if (parametry == null) {
            return "S kym byste chtěli mluvit? Zadejte jmeno.";
        }
        if (postavy.size() == 0) {
            return "Nemáte s kym mluvit :(";

        }
        String jmeno = parametry[0];
        Postava postava = postavy.get(jmeno);
        if (postava.getJmeno().equals("Lekar_Tomas")){
            hra.setKonecHry(true);
            return postava.getInf() +"\n" +
                    "  ____    _    __  __ _____    _____     _______ ____  \n" +
                    " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                    "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                    "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                    " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\"+
                    "\n" +
                    "\nTeď jste pacientem Psychiatrické léčebny v New Orlean navždy.";
        }
        return postava.getInf();
    }



        @Override
    public String getNazev() {
        return NAZEV;
    }
}
