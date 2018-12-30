package comV2.serveurCentral;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

import comV2.guichetLocation.GuichetLocation;
import comV2.guichetLocation.GuichetLocationHelper;
import comV2.guichetRestitution.GuichetRestitution;
import comV2.guichetRestitution.GuichetRestitutionHelper;

public abstract class LocRestHelper {

	public static GuichetLocation location = null;
	public static GuichetRestitution restitution = null ;
	/*static {
		try {
			Context ctx=new InitialContext();
			Object ref=ctx.lookup("location");
			location= GuichetLocationHelper.narrow((org.omg.CORBA.Object)ref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Context ctx=new InitialContext();
			Object ref=ctx.lookup("restitution");
			restitution= GuichetRestitutionHelper.narrow((org.omg.CORBA.Object)ref);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public static GuichetLocation getGuichetLocation() 
    { 
		try {
			Context ctx=new InitialContext();
			Object ref=ctx.lookup("location");
			if (location == null) 
				location = GuichetLocationHelper.narrow((org.omg.CORBA.Object)ref)	; 
		} catch (Exception e) {
			e.printStackTrace();
		}
  
        return location; 
    } 
	public static GuichetRestitution getGuichetRestitution() 
    { 
		try {
			Context ctx=new InitialContext();
			Object ref=ctx.lookup("restitution");
			if (restitution == null) 
				restitution = GuichetRestitutionHelper.narrow((org.omg.CORBA.Object)ref)	; 
		} catch (Exception e) {
			e.printStackTrace();
		}
  
        return restitution; 
    } 
	/*
	public static GuichetLocation getGuichetLocation() {
		return location;
	}
	public static GuichetRestitution getGuichetRestitution() {
		return restitution;
	}*/
}
