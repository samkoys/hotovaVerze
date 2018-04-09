/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí tohto příkazu můžeme sebrat přenositelné věci do kufru. 
 *
 * @author    Samuel Koyš
 * @version   19.05.2017
 */
public class PrikazSeber implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Hra hra;
    private Kufor kufor;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazSeber
     */
    public PrikazSeber(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.hra = hra;
        this.kufor = plan.getKufor();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
   /** Metoda představuje zpracování příkazu pro sebrání předmětu. Nejprve zkontroluje, zda byl 
     * zadán právě jeden název jako parametr, ověří, zda v aktuálním prostoru je předmět s tímto
     * názvem, zda je přenositelný, zda je v kufru místo a následně předmět odebere z prostoru 
     * a vloží ho do kufru.
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co mam sebrat?";
        }

        String nazevSbiraneho = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor aktualni = plan.getAktualniProstor();
        Vec sbirana = aktualni.odeberVec(nazevSbiraneho);
        
        if(sbirana == null)
        {
            return nazevSbiraneho + " tu neni";
        }
        else
        {
            if(sbirana.jePrenositelna())
            {
                if (sbirana.getNazev().equals("flasa_skotskej")){
                hra.setKonecHry(true);
                return "Hra končí. Byl jsi přistižen při krádeži! Carl si toho všiml a byl jsi ubyt na zemi.\n Snad budeš příště obezřetnější.)";
                
                }
                //
                return kufor.vlozVec(sbirana);
            }
            else
            {
                aktualni.vlozVec(sbirana);
                return "to neuneses";
            }
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
