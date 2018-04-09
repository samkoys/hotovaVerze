package com.github.koys.adventura.logika;
import java.util.*;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Samuel Koyš
 *@version    18.05.2017
 */
public class HerniPlan extends Observable{
    
    private Prostor aktualniProstor;
    private Kufor kufor;
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        kufor = new Kufor(this);
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Barneyho apartmán.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        
        
        Prostor marshaluvPokoj = new Prostor("Marshallov_apartmán","Vstoupil jsi do obývaku Marshallovho apartmánu. Tady bydlí Marshall a jeho manželka Lily",0,0);
        Prostor tedovPokoj = new Prostor("Tedov_apartmán", "Útulná garzónka, kde Ted žije se svými 16 kočkami.",0,0);
        Prostor barneyhoPokoj = new Prostor("Barneyho_apartmán","Nacházíš se ve svém apartmánu.",0,0);
        Prostor nevestinec = new Prostor("Nevestinec","Vstoupil jsi do Lusty Leopard. Na recepci dnes pracuje Quinn. Jak se rozlížiš kolem, spatříš jednu ženu, která se podobá na Lily!",0,0);
        Prostor mcLarens = new Prostor("McLarens","Tvá oblíbená hospoda, kde trávíš většinu času se svými parťákmi a parťáčkami. \n Dnes na pultu obsluhuje Carl (mohutný dvojmětrový adónis). Pokus o krádež se trestá!",0,0);
        Prostor laserTag = new Prostor("Laser-tag", "Největší laser tag aréna v New Yorku s rozlohou 400 m2.",0,0);
        Prostor dumLylinyKamosky = new Prostor("Dum_kamošky","Přišel jsi na návštevu k Shelly.\n Můžeš jsi jako host vzít džús a sušenky.",0,0);
        Prostor metroA = new Prostor("MetroA","Právě cestuješ metrem po trase A . Oproti tobě sedí bezdomovec a na druhém konci vagónu postarší pani, která neslyší.",0,0);
        Prostor lylinPokoj = new Prostor("Lilyn_pokoj", "Musíš být velice potiše. Lily právě spí a i nejmenší rachot jí může vzbudit.",0,0);
        lylinPokoj.setJeZavreny(true);
        Prostor metroB = new Prostor("MetroB","Právě cestuješ metrem po trase B.",0,0);
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        marshaluvPokoj.setVychod(lylinPokoj);
        lylinPokoj.setVychod(marshaluvPokoj);
        marshaluvPokoj.setVychod(metroA);
        marshaluvPokoj.setVychod(mcLarens);
        mcLarens.setVychod(marshaluvPokoj);
        metroA.setVychod(marshaluvPokoj);
        metroA.setVychod(barneyhoPokoj);
        barneyhoPokoj.setVychod(metroA);
        metroA.setVychod(mcLarens);
        mcLarens.setVychod(metroA);
        metroB.setVychod(laserTag);
        laserTag.setVychod(metroB);
        metroA.setVychod(metroB);
        metroB.setVychod(metroA);
         metroB.setVychod(nevestinec);
        nevestinec.setVychod(metroB);
         metroB.setVychod(tedovPokoj);
        tedovPokoj.setVychod(metroB);
         metroB.setVychod(dumLylinyKamosky);
        dumLylinyKamosky.setVychod(metroB);
        
        
        //Vlozime veci do prostoru
        Vec gammon = new Vec("marsh-gammon", true , "Je kombinací těch nejskvělejších rysů všech nejlepších her: Cukrová země, Na pravdu, Obrazárna.\n" 
        + "Jenom ne Backgammon. Jediná část z Backgammona, která byla použitá je ten gammon a celý zbytek byl nechaný v odpadcích, kam taky patří.","marsh-gammon.jpg");
        Vec kravata = new Vec("kravata", true, "Kravata s motívem malých kachniček.","kravata.jpg");
        Vec banner = new Vec("banner", true, "Banner s napísem Intervencia.","banner.jpg");
        Vec klavir = new Vec("klavir", false, "Marshallov klavír značky Bosendorfer.","klavir.jpg");
        marshaluvPokoj.vlozVec(gammon);
        marshaluvPokoj.vlozVec(kravata);
        marshaluvPokoj.vlozVec(banner);
        marshaluvPokoj.vlozVec(klavir);
        
        
        
        Vec destnik = new Vec("destnik", true, "Deštník žlté barvy.","destnik.jpg");
        Vec ananas = new Vec("ananas", true, "Lahodný ananás, který se po jedné noci objevil na Tedovém stůlku.","ananas.jpg");
        Vec modryRoh = new Vec("modry_roh", true, "Na stene je zavesený roh modrej farby.","modry_roh.jpg");
        tedovPokoj.vlozVec(destnik);
        tedovPokoj.vlozVec(ananas);
        tedovPokoj.vlozVec(modryRoh);
        
        Vec obleky = new Vec("obleky", true, "Sada desítek obleků.","oblek.jpg");
        Vec stormtrooper  = new Vec("stormtrooper", false, "Oblek fiktického vojaka. ","stormtrooper.jpg");
        Vec katana  = new Vec("katana", true, "Druh japonského meče. ","katana.jpg");
        barneyhoPokoj.vlozVec(obleky);
        barneyhoPokoj.vlozVec(stormtrooper);
        barneyhoPokoj.vlozVec(katana);
        
        
        Vec flasaSkotskej  = new Vec("flasa_skotskej", true, "50-roční sladká skotská, značky Glen McKenna v hodnote 2500 €. ","flasa_skotskej.jpg");
        Vec jukebox  = new Vec("jukebox", false, "Stroj na prohrávaní hudby. Teď z ní hraje hit od Proclaimersu, píseň 500 miles.","jukebox.jpg");  
        Vec chickennuggets = new Vec("chicken_nuggets", true, "11 hluboko pražených kuřecích nugetek. Jeden postarší pán je tady nechal, prý jsou moc pikantní.","chicken_nuggets.jpg");
        mcLarens.vlozVec(chickennuggets);
        mcLarens.vlozVec(flasaSkotskej);
        mcLarens.vlozVec(jukebox);
        
        Vec bavlneneSaty = new Vec("bavlnene_saty", true, "Hebké modré šaty vyrobené z bavlny. ","bavlnene_saty.jpg");
        Vec laserPistol  = new Vec("laser_pistol", true, "Laserová pistole s velikosti zásobniku 50 náboju. ","laser-pistol.jpg");
        Vec vesta  = new Vec("vesta", true, "Černá 3 kilová vesta pro hru Lasertag","vesta.jpg"); 
        laserTag.vlozVec(bavlneneSaty);
        laserTag.vlozVec(laserPistol);
        laserTag.vlozVec(vesta);
        
        Vec leopardieSaty  = new Vec("leopardie_saty", true, "Na stole ležia šaty z leoparďej kůži.","leopardie_saty.jpg");
        Vec gauc   = new Vec("gauc", false, "Červenej koženej gauč.","gauc.jpg");
        Vec portret   = new Vec("portret", true, "Na stene visí portrét aktu Marshalla s ruží.","portret.jpg"); 
        nevestinec.vlozVec(leopardieSaty);
        nevestinec.vlozVec(gauc);
        nevestinec.vlozVec(portret);
        
        
         
        Vec dzus  = new Vec("dzus", true, "Pomarančový džús značky Tropicana.","dzus.jpg");
        Vec susenky   = new Vec("susenky", true, "Chrumkavé čokoládové sušenky.","susenky.jpg");
        
        dumLylinyKamosky.vlozVec(dzus);
        dumLylinyKamosky.vlozVec(susenky);
        
        Vec playbook = new Vec("playbook", true, "Kniha s názvem The Playbook.","playbook.jpg");
        lylinPokoj.vlozVec(playbook);
        
        Vec cerveneBoty = new Vec("cervene_boty", true, "Kovbojské červené boty. Dizajnově schváleno „pagdetmi“(párikem gayu bez deti).","cowboyshoes.jpg");
        Vec klic = new Vec("klic", true, "Klíč k Lilynmu pokoju","klic.jpg");
        lylinPokoj.setKey(klic);
        
        // Vytvarime osoby
        Postava marshal = new Postava("Marshall", "Ahoj Barney! To mě mrzí slyšet, že ti Lily ukradla tvoji knihu. \n Bohužel ti klíč od jejího pokoje nemužu dát. Kdyby jsi mi ale dokázal sehnat kvalitnú flašu skotskej whiskey možná bych o tom popřemýšlel",  klic);
        marshal.setJeMenitelny(true);
        marshal.setVymena(flasaSkotskej, "To nechci, ja potrebuji ", "Ja potrebuju " +flasaSkotskej.getNazev(), "Dobře, tady máš klíč. Ale kdyby se Lily ptala, tak já jsem ti ten klíč nedal. A o té whiskey taky ani slovo.");
        marshaluvPokoj.vlozPostavu(marshal);
        
        Postava ted = new Postava("Ted", "Barney, já opravdu nevím kde tvoje kniha je. \n Mám ale pro tobě návrh! Robin ukrodla mé červené boty. Nemůžu se jí dovolat a její kámošky taky o ničem neví. Jestli mi pomůžeš tí boty najít,\n mohl bych ti dát jednou kvalitnou flašu whiskey", flasaSkotskej);
        ted.setJeMenitelny(true);
        ted.setVymena(cerveneBoty, "To nechci, ja potrebuji ", "Ja potrebuju " +cerveneBoty.getNazev(), "Dej mi placáka. Že v tých botách vyzerám jako frajer.");
        tedovPokoj.vlozPostavu(ted);
        
        Postava carl = new Postava("Carl", "Zdravím tě, Barney. Ne, bohužel nevím kde je Lily a tvá kniha.", null);
        mcLarens.vlozPostavu(carl);
        
        Postava deti  = new Postava("Deti", "Ne, my si nebudeme s tebou hrát. Neměl bys být v práci?", null);
        laserTag.vlozPostavu(deti);
        
        Postava quinn  = new Postava("Quinn", "Ráda tě tu zase vidím, Barney. Nevím kde tvá kniha je, ale můžu ti zaručit, že tady ji nebudeš potřebovat.", null);
        nevestinec.vlozPostavu(quinn);
        
        Postava tanecnica  = new Postava("Tanečnice_Lily", "Prominte pane, nevím kdo je tá Lily, o které mluvíte.", null);
        nevestinec.vlozPostavu(tanecnica);
        
        Postava shelly = new Postava("Shelly", "Zdravím tě Barney! Jestli jsi tady kvůli Tedovým botám, řekni mu, že mu jí nedám. Robin mi jasně nakazázala, aby jsem je před Tedem ukryla.\n Ledaže bys mi mohl přinést mé šaty, které jsem si včera zapomněla v práci. ", cerveneBoty);
        shelly.setJeMenitelny(true);
        shelly.setVymena(leopardieSaty, "To nechci, ja potrebuji ", "Ja potrebuju mé šaty" , "Dekuji mockrát,Barney. Můžeš si tí boty vzít.");
        dumLylinyKamosky.vlozPostavu(shelly);
        
        Postava bezdomovec = new Postava("Bezdomovec","Milej pane, zlatej pane. Neměl by jste pár drobných? ",null);
        metroA.vlozPostavu(bezdomovec);
        
        Postava lily = new Postava("Lily", "Barney ty vole! Co tady delas!?", null);
        lylinPokoj.vlozPostavu(lily);
     
         
        
        
       
                
        aktualniProstor = barneyhoPokoj;  // hra začíná u Barneyho       
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
    
     /**
      * Getter getKufor
      *
      * @return instancí třídy kufor
      */
     public Kufor getKufor() {
        return kufor;
    }
    
    
    /**
     * Metoda jeVyhra
     *
     * @return Návratová hodnota
     */
    public boolean jeVyhra()
    {
        return kufor.jeVKufru("playbook"); 
    }
    
    @Override
    public void notifyObservers(){
        setChanged();
        super.notifyObservers();
    }

}
