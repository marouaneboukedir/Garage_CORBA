package comV2.guichetLocation;


/**
* comV2/guichetLocation/GuichetLocationHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from garage.idl
* dimanche 23 d�cembre 2018 17 h 49 WET
*/

abstract public class GuichetLocationHelper
{
  private static String  _id = "IDL:comV2/guichetLocation/GuichetLocation:1.0";

  public static void insert (org.omg.CORBA.Any a, comV2.guichetLocation.GuichetLocation that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static comV2.guichetLocation.GuichetLocation extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (comV2.guichetLocation.GuichetLocationHelper.id (), "GuichetLocation");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static comV2.guichetLocation.GuichetLocation read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GuichetLocationStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, comV2.guichetLocation.GuichetLocation value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static comV2.guichetLocation.GuichetLocation narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof comV2.guichetLocation.GuichetLocation)
      return (comV2.guichetLocation.GuichetLocation)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      comV2.guichetLocation._GuichetLocationStub stub = new comV2.guichetLocation._GuichetLocationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static comV2.guichetLocation.GuichetLocation unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof comV2.guichetLocation.GuichetLocation)
      return (comV2.guichetLocation.GuichetLocation)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      comV2.guichetLocation._GuichetLocationStub stub = new comV2.guichetLocation._GuichetLocationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
