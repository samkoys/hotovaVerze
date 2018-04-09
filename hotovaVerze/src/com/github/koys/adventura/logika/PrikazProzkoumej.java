/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí příkazu prozkoumej se hráč dozví konkrétnejší informace o předmětech obecně. 
 *
 * @author    Samuel Koyš
 * @version   18.05.2017
 */
public class PrikazProzkoumej implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "prozkoumej";
    private HerniPlan plan;
    private Hra hra;
    private Kufor kufor;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy Prikaz Prozkoumej
     */
    public PrikazProzkoumej(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.hra = hra;
        this.kufor = plan.getKufor();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     * 
     * Provádí příkaz "prozkoumej". Pokud nebyl zadán žádný parametr, vrátí kompletní
     * popis aktuálního prostoru. Pokud byl zadán jeden parametr, pokusí se v aktuálním prostoru
     * a následně v kufru najít předmět s daným názvem a vrátit jeho popis.
     * 
     * @param     parametry může jako parametr obsahovat název předmětu, který chce hráč prozkoumat
     * @return    hláška, kterou vypíše hra hráči
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co chces prozkoumat";
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
           aktualni.vlozVec(sbirana);
           return sbirana.getPopis();
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
