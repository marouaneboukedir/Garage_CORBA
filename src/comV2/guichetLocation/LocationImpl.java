package comV2.guichetLocation;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import comV2.Voiture;
import comV2.serveurCentral.LocRestHelper;


public class LocationImpl extends GuichetLocationPOA {

	private int l;
	private List<Voiture> voituresLoc = new ArrayList<Voiture>();

	@Override
	public int l() {
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public void l(int newL) {
		// TODO Auto-generated method stub
		l = newL;
	}

	@Override
	public void louer() {
		int r = 0;
		try {
			r = LocRestHelper.getGuichetRestitution().r();
			if (r==0 || r - l > 0) {
				l++;
				System.out.println("Voiture louee");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Voiture[] voituresLoc() {
		// TODO Auto-generated method stub
		Voiture[] voitures = new Voiture[voituresLoc.size()];
		int i=0;
		for(Voiture voiture : voituresLoc)
			voitures[i++] = voiture;
		return voitures;
	}

	@Override
	public void voituresLoc(Voiture[] newVoituresLoc) {
		// TODO Auto-generated method stub
		voituresLoc = Arrays.asList(newVoituresLoc);
	}

	

}
