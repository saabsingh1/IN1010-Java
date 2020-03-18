
public class Spesialist extends Lege implements Godkjenningsfritak{

    // instansvariabel ID fra parameteren for kontrollID'en
    int kontrollID;

    public Spesialist(String navn, int kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
    }

    @Override // metode som overskrives fra grensesnittet som returner kontrollID'en
    public int hentKontrollID(){
        return kontrollID;
    }

    @Override // metode som overskriver toString()-metoden og returner relevant info
    public String toString() {
        return ("Spesialistnavn: " + navn +
                "\nKontrollID: " + kontrollID);
    }


    // (D3) Overriding av de 4 skriv-metodene med tilgang til narkotiske legemidler

    @Override // metode for aa  skrive ut (lage > legge til liste > returne) resept av typen "HvitResept"
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {

        // lager resept med info fra parameter + "this" - denne klassen
        HvitResept hvit = new HvitResept(legemiddel, this, pasient, reit);

        // legger til resept i lenkelisten til legen og returner
        utskrevedeResepter.leggTil(hvit);
        return hvit;
    }

    @Override // metode for aa  skrive ut (lage > legge til liste > returne) resept av typen "MillitaerResept"
    public MillitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {

        // lager, legger til og returner
        MillitaerResept millitaer = new MillitaerResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(millitaer);
        return millitaer;
    }

    @Override // metode for aa  skrive ut (lage > legge til liste > returne) resept av typen "PResept"
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {

        // lager, legger til og returner
        PResept PResept = new PResept(legemiddel, this, pasient);
        utskrevedeResepter.leggTil(PResept);
        return PResept;
    }

    @Override // metode for aa  skrive ut (lage > legge til liste > returne) resept av typen "BlaaResept"
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {

        // lager, legger til og returner
        BlaaResept Blaa = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(Blaa);
        return Blaa;
    }

}
