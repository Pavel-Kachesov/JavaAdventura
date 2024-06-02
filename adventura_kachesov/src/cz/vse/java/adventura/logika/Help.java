package cz.vse.java.adventura.logika;


class Help implements IPrikaz {
    
    private static final String NAZEV = "help";
    private final SeznamPrikazu platnePrikazy;
    

    public Help(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je zjistit co se děje ve městě a proč zemřel tvůj stryc.\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
    }
    

    @Override
      public String getNazev() {
        return NAZEV;
     }

}
