/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.koys.adventura.logika;

/*******************************************************************************
 * Instance třídy Person představují postavy, které se mohou nacházet v herním plánu.
 * 
 * Postavy mohou na stejná příkazy vracet různé odpovědi, čili jsou polymorfní.
 *
 * @author    Samuel Koyš
 * @version   19.05.2017
 */
public class Postava
{
    //== Datové atributy (statické i instancí)======================================
    private String jmeno;
    private String rec;
    private Vec vec;
    private Vec potrebuje;
    private String neChce;
    private String chce;
    private String poVymene;
    private boolean jeMenitelny;
    private boolean vymena;
    public boolean prohra;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třídy Postava
     */
    public Postava(String jmeno, String rec, Vec vec)
    {
        this.jmeno = jmeno;
        this.rec = rec;
        this.vec = vec;
    }

    /**
     * Metoda getRec
     *
     * @return String - rec
     */
    public String getRec(){
        return rec;
    }

    /**
     * Metoda getJeMenitelny
     *
     * @return boolean jeMenitelny
     */
    public boolean getJeMenitelny(){
        return jeMenitelny;
    }

    /**
     * Metoda setJeMenitelny
     *
     * @param jeMenitelny Parametr
     */
    public void setJeMenitelny(boolean jeMenitelny){
        this.jeMenitelny = jeMenitelny;
    }

    /**
     * Metoda getVec
     *
     * @return Návratová hodnota
     */
    public Vec getVec(){
        return vec;
    }

    /**
     * Metoda setVymena
     *
     * @param potrebuje Parametr
     * @param neChce Parametr
     * @param chce Parametr
     * @param poVymene Parametr
     */
    public void setVymena(Vec potrebuje, String neChce, String chce, String poVymene){
        this.potrebuje = potrebuje; 
        this.neChce = neChce;
        this.chce = chce;
        this.poVymene = poVymene;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    //@return isEvil - je person zla nebo dobra

    /** @return jmeno - jmeno osoby  */
    public String getJmeno(){
        return jmeno;
    }

    
    /**
     * Metoda getVymena
     *
     * @return boolean - vymena
     */
    public boolean getVymena(){
        return vymena;
    }

    /**
     * Metoda vymena
     *
     * @param potrebuje Parametr
     * @return true pokud postava věc potřebuje, jinak false
     */
    public String vymena(Vec potrebuje){
        if (this.potrebuje!=null){
            if (this.potrebuje==potrebuje){
                this.vymena = true;
                return poVymene;
            }
            else { return neChce + this.potrebuje.getNazev();}}
        else { return "Ja to nepotrebuji";}
    }

    /**
     * Metoda getChce
     *
     * @return String - this.chce
     */
    public String getChce(){
        return this.chce;
    }

    /**
     * Metoda getPoVymene
     *
     * @return Návratová hodnota
     */
    public String getPoVymene(){
        return poVymene + " ";
    }

    /**
     * Metoda setVymenaStav
     *
     * @param vymena Parametr
     */
    public void setVymenaStav(boolean vymena){
        this.vymena = vymena;
    }
    
    public boolean getProhra (){
        return prohra;
    }



    //== Soukromé metody (instancí i třídy) ========================================
}
