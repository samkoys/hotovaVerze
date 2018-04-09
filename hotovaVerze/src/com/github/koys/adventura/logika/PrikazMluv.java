/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Pomocí příkazu mluv nadvážeme komunikaci s postavou v určité místnosti. 
 *
 * @author    Samuel Koyš
 * @version   18.05.2017
 */
public class PrikazMluv implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    private Hra hra;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy PrikazMluv
     */
    public PrikazMluv(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.hra = hra;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
  
    /**
     * Metoda mluv kontroluje, jestli je možní provést operaci při určitých zadaných parametrech.
     * Operaci je možné provést jestli byli všechny údaje správně zadané nebo bude vypsána chyby.
     *
     * @param parametry jméno oslovené osoby
     * @return odpověď postavy
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "S kym musim mluvit?";
        }

        String  jmenoPostavy = parametry[0];
        Prostor aktualni = plan.getAktualniProstor();
        Postava postava = aktualni.najdiPostavu(jmenoPostavy);

        if(postava == null)
        {
            return jmenoPostavy + " neni tu";
        }
        else
        {
            if(postava.getJmeno().equals("Lily")){
                hra.setKonecHry(true);
                return "Hra končí. Lily byla vzbudena. Snad budeš příště obezřetnější.";
            }
            if (postava.getVymena()){
            return "Uz nic nechci, dik.";
            }
            else {
      
           return postava.getRec();
        }}
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
