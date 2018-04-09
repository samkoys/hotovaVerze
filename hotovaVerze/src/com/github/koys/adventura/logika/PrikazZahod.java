/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí příkazu Zahod vybereme předmět z kufru a bude ponechaný v daném prostoru.
 *
 * @author    Samuel Koyš
 * @version   18.05.2017
 */
public class PrikazZahod implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "zahod";
    private HerniPlan herniPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazZahod
     *  
     *   @param herniPlan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazZahod(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }
    
    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     *  Provádí příkaz "drop". Pokud v kufru věc není vypíše chybovou hlášku.
     *  Jinak věc odhodí do aktuálního prostoru. Lze zahodit jen jednu věc
     *  najednou.
     *
     *  @param  parametry   -jako  parametr se zadává jméno odhazované věci
     *  @return             zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Co chces abych zahodil?";
        }

        String jmenoVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Kufor kufor = herniPlan.getKufor();
        Vec vyhozena = kufor.getVec(jmenoVeci);

        if (vyhozena == null) {
            // pokud mazana věc není v batohu.
            return "Ja nemam " + jmenoVeci + " v Kufru";            
        }
        else {
            // pokud je věc smazána z batohu, přesune se do aktualního prostoru
            vyhozena = kufor.zahod(jmenoVeci);
            aktualniProstor.vlozVec(vyhozena);
            return jmenoVeci + " vyla vyhozena";
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}