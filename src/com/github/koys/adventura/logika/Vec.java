/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;



/*******************************************************************************
 * Instance třídy Vec představují předměty, které může postava sebrat, zahodit, 
 * prozkoumat, nabidnout jíne postavě.
 *
 * @author    Samuel Koyš
 * @version   19.05.2017
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private boolean prenositelnost;
    private String popis;
    private String url;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy Vec.
     */
    public Vec(String nazev, boolean prenositelnost, String popis,String url)
    {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
        this.popis = popis;
        this.url = url;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    public String getNazev()
    {
        return nazev;
    }

    public String getUrl() {
        return url;
    }
    
    
    
    /**
     * Metoda jePrenositelna
     *
     * @return true jestli je věc přenositelná
     */
    public boolean jePrenositelna()
    {
        return prenositelnost;
    }
    
    public String getPopis(){
    return popis;
    }
 
    //== Soukromé metody (instancí i třídy) ========================================

}
