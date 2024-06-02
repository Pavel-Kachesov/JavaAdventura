package cz.vse.java.adventura.logika;

import java.util.Map;

public class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private final HerniPlan plan;
    private Hra hra;
    private Map<String, Vec> veci;
    private Batoh batoh;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazJdi(HerniPlan plan, Hra hra, Batoh batoh) {
        this.plan = plan;
        this.hra = hra;
        this.batoh = batoh;
        veci = batoh.getBatoh();

    }

    /**
     * Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     * existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     * (východ) není, vypíše se chybové hlášení.
     *
     * @param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                  do kterého se má jít.
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        } else {
            plan.setAktualniProstor(sousedniProstor);

            if (plan.getAktualniProstor().getNazev().equals("Bažiny") && !batoh.masVec("Mapy_bažin_New_Orlean")){

                    return  "  ____    _    __  __ _____    _____     _______ ____  \n" +
                            " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                            "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                            "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                            " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\"+
                            "\n"+
                            "Jste se utopil.Příště vemte s sebou mapy bažin." +
                            "Avšak máte jedenu šanci odpevěz na otázku a můžeš se vzkřísit :" +
                            "Dale odpověz na otázku(napíš \"odpovi a\" nebo \"odpovi b\" podle vašeho rozhodnuti. \n"+
                            "\n Mysliš že si Ježiš Kristus řekl \"Ach joo jsem mrtvej a pohřbenej, už nikdy nebudu žít jako předtím, to je konec ?\" \n" +
                            "Odpovedí: \" odpovi a \" = ne, \" odpovi b \" = ano";
                }

            return sousedniProstor.dlouhyPopis();
        }

    }
@Override
public String getNazev() {
    return NAZEV;
}

}

