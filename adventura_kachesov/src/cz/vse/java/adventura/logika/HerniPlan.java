package cz.vse.java.adventura.logika;


public class HerniPlan {
    
    private Prostor aktualniProstor;
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor dum = new Prostor("Gammellův_dům","Starobylý dům v New Orleansu, kde Váš stryc - Gammell žil a zemřel.");
        Prostor knihovna = new Prostor("Knihovna", "Místo, kde můžete najít informace o R'lyehu a Ktulhu.");
        Prostor bar = new Prostor("Docela","Bar v New Orleansu, kde se setkáte s podivnými postavami.");
        Prostor lecebna = new Prostor("Psychiatrická_léčebna","Léčebna kam popadají všichni umělci a spisovatelé, kterých dosáhl vliv stršidla Ktulhu.");
        Prostor baziny = new Prostor("Bažiny","Rozlehlé bažiny na okraji New Orleansu, kde se nachází starobylý chrám R'lyeh.");
        Prostor chram = new Prostor("Chram_Rlyeh", "Podmořský chrám, kde Ktulu spí a čeká na probuzení.");
        // přiřazují se průchody mezi prostory (sousedící prostory)
        dum.setVychod(bar);
        dum.setVychod(baziny);
        dum.setVychod(lecebna);
        baziny.setVychod(chram);
        baziny.setVychod(dum);
        bar.setVychod(knihovna);
        knihovna.setVychod(baziny);
        knihovna.setVychod(lecebna);
        lecebna.setVychod(dum);
        bar.setVychod(dum);
        knihovna.setVychod(bar);


        Vec kompas = new Vec("Kompas", "toto je kompas, který starý Grammell držel v ruce až do smrti.\n", "");
        Vec dennik = new Vec("Deník","toto je deník vašeho stryce, který on psal až nezemřel.\n",
                "S hrůzou v očích jste dočetl strýčkův deník. \n" +
                "Spisovatelé a malíři v psychiatrické léčebně umírají jeden po druhém, oběti \n" +
                "zlověstného prokletí Ktulhu. Jeho slova buráci ve vaše hlavě: Jedině ty to můžeš zastavit!\n" +
                        "Podle deníku klíč k záchraně leží v nějakem artefaktu s ručičkama a Nekronomikonu ukrytém v chrámu u bažin.\n" +
                        "Ale stryc varoval, že přečtení Nekronomikonu před dosažením chrámu povede k katastrofě.");
        Vec Nekronomicon = new Vec("Nekronomicon", "kniha se všem nadpřírozeným od zblaznivšeho araba Alchazreda. \n", "Nesrozumitelné pisměna.");
        Vec mapa = new Vec ("Mapy_bažin_New_Orlean", "Tohle je sbírka map Bažin v blízkosti New Orleanu.\n", "Tady jste dozvěděl cestu přes bažiny do chramu, nevzhayuj y batohu, abyste se neztratil v bažinách");
        Vec kniha_lecebny = new Vec("Kniha_o_psychiatrické_lečebně_v_New_Orleanu", "Sbirka métod,lečív a tajemství psychiatrické lečebny v New Orleane.\n", "V knize " +
                "o psychiatrické léčebně jste se skutečně dočetl \n" +
                "o tom, že nesmíte komunikovat s žadným člověkěm v léčebně, jinák stanete tam pacientem navždy.");
        Vec kniha_HPL = new Vec("Volání_Ktulhu", "Author Howard Phillips Lavecraft\n", "Přečetl jste zabavné příběhy o vymyšléných postavaách, jako Ktulhu atd.");
        Vec pohadky = new Vec("Pohadky_Nového_Orleanu", "Kniha s pohadkama o Novém Orleanu\n", "Přečetl jste zabavné příběhy o historii Nového Orleanu.");




        // přiřazují se věci v prostorach
        dum.setVec(dennik);
        dum.setVec(kompas);
        knihovna.setVec(Nekronomicon);
        knihovna.setVec(mapa);
        knihovna.setVec(kniha_HPL);
        knihovna.setVec(kniha_lecebny);
        knihovna.setVec(pohadky);

        Postava barman = new Postava("Barman_Jim", "Od barmana Jima jste zjistil, že tvůj strýc strávil hodně času v " +
                "bibilitce a možná tam najdeš odpovědi na své otázky.");
        Postava bezdomovec = new Postava("Billi_bezdomovec", "Bezdomovec vám doporučil navštívit psychiatrickou " +
                "léčebnu, protože tam jsou chytří lékaři, kteří vám pomohou odhalit všechny vaše konspirační teorie.");
        bar.setPostavy(barman);
        bar.setPostavy(bezdomovec);
        Postava lekar = new Postava("Lekar_Tomas", "Od Tomasa se dozvíte, že váš strýc byl také považován" +
                " za blázna a že jeho žena se kvůli němu zbláznila. ");
        Postava recepcni = new Postava("Recepcni_Ida", "Recepční na vás byla hrubá a nic jste z ní nedostali. ");
        lecebna.setPostavy(lekar);
        lecebna.setPostavy(recepcni);


        aktualniProstor = dum;  // hra začíná v domečku
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }



}
