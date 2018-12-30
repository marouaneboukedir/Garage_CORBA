package comV2.guichetRestitution;

import comV2.Voiture;
import comV2.guichetLocation.GuichetLocation;
import comV2.guichetLocation.GuichetLocationHelper;
import comV2.serveurCentral.LocRestHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;


public class RestitutionImpl extends GuichetRestitutionPOA{
	private int r;
	private int n;
	private static List<Voiture> voituresRest = new ArrayList<Voiture>();
	
	static {
        Voiture voiture1=new Voiture("p1","Polo" ),
                voiture2=new Voiture("bm1","BMW"),
                voiture3=new Voiture("D1","DACIA"),
                voiture4=new Voiture("F1","FIAT"),
                voiture5=new Voiture("M1","MERCEDES"),
                voiture6=new Voiture("A1","AUDI"),
                voiture7=new Voiture("Maz1","Mazda"),
                voiture8=new Voiture("T1","Toyota"),
                voiture9=new Voiture("a2","Alpha"),
                voiture10=new Voiture("V12","Volvo");
        voituresRest.add(voiture1);
        voituresRest.add(voiture2);
        voituresRest.add(voiture3);
        voituresRest.add(voiture4);
        voituresRest.add(voiture5);
        voituresRest.add(voiture6);
        voituresRest.add(voiture7);
        voituresRest.add(voiture8);
        voituresRest.add(voiture9);
        voituresRest.add(voiture10);
    }

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return r;
	}
	
	public RestitutionImpl(int n) {
		this.n=n;
	}

	@Override
	public void r(int newR) {
		// TODO Auto-generated method stub
		r = newR;
	}

	@Override
	public int nbMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void restituer() {
		int l=0;
		try {
			l=LocRestHelper.getGuichetLocation().l();
			if(n > r-l){
				r++;
				System.out.println("Voiture restitue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Voiture[] voituresRest() {
		// TODO Auto-generated method stub
		Voiture[] voitures = new Voiture[voituresRest.size()];
		int i=0;
		for(Voiture voiture : voituresRest)
			voitures[i++] = voiture;
		return voitures;
	}

	@Override
	public void voituresRest(Voiture[] newVoituresRest) {
		// TODO Auto-generated method stub
		voituresRest = Arrays.asList(newVoituresRest);
	}

}
