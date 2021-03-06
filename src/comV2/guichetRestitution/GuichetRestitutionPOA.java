package comV2.guichetRestitution;


/**
* comV2/guichetRestitution/GuichetRestitutionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from garage.idl
* dimanche 23 d�cembre 2018 17 h 49 WET
*/

public abstract class GuichetRestitutionPOA extends org.omg.PortableServer.Servant
 implements comV2.guichetRestitution.GuichetRestitutionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_r", new java.lang.Integer (0));
    _methods.put ("_set_r", new java.lang.Integer (1));
    _methods.put ("_get_nbMax", new java.lang.Integer (2));
    _methods.put ("_get_voituresRest", new java.lang.Integer (3));
    _methods.put ("_set_voituresRest", new java.lang.Integer (4));
    _methods.put ("restituer", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // comV2/guichetRestitution/GuichetRestitution/_get_r
       {
         int $result = (int)0;
         $result = this.r ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // comV2/guichetRestitution/GuichetRestitution/_set_r
       {
         int newR = in.read_long ();
         this.r (newR);
         out = $rh.createReply();
         break;
       }

       case 2:  // comV2/guichetRestitution/GuichetRestitution/_get_nbMax
       {
         int $result = (int)0;
         $result = this.nbMax ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // comV2/guichetRestitution/GuichetRestitution/_get_voituresRest
       {
         comV2.Voiture $result[] = null;
         $result = this.voituresRest ();
         out = $rh.createReply();
         comV2.VoituresListHelper.write (out, $result);
         break;
       }

       case 4:  // comV2/guichetRestitution/GuichetRestitution/_set_voituresRest
       {
         comV2.Voiture newVoituresRest[] = comV2.VoituresListHelper.read (in);
         this.voituresRest (newVoituresRest);
         out = $rh.createReply();
         break;
       }

       case 5:  // comV2/guichetRestitution/GuichetRestitution/restituer
       {
         this.restituer ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:comV2/guichetRestitution/GuichetRestitution:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GuichetRestitution _this() 
  {
    return GuichetRestitutionHelper.narrow(
    super._this_object());
  }

  public GuichetRestitution _this(org.omg.CORBA.ORB orb) 
  {
    return GuichetRestitutionHelper.narrow(
    super._this_object(orb));
  }


} // class GuichetRestitutionPOA
