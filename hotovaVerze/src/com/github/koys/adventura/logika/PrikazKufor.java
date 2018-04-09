/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí příkazu kufor se nám vypíše seznam věcí uložených v kufru.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PrikazKufor implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAME = "kufor";
    private HerniPlan herniPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazKufor
     *  
     *   @param herniPlan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazKufor(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     *  Provádí příkaz "inventory". Vypíše všechny věci, které jsou v kufru.
     *
     *  @return     zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (herniPlan.getKufor().getVeci().isEmpty()) {
            // pokud je kufor prázdný
            return "Kufor je prazdny";
        }
        else {
            // pokud je v kufru jedna a více věcí.
            return "Seznam veci v kufru:" + herniPlan.getKufor().getVeci() + ".";
        }
    }

    /**
     *  Metoda vrací název příkazu
     *  
     *  @ return název příkazu
     */
    @Override
    public String getNazev() {
        return NAME;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}