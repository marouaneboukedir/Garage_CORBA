package comV2.guichetLocation;

/**
* comV2/guichetLocation/GuichetLocationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from garage.idl
* dimanche 23 d�cembre 2018 17 h 49 WET
*/

public final class GuichetLocationHolder implements org.omg.CORBA.portable.Streamable
{
  public comV2.guichetLocation.GuichetLocation value = null;

  public GuichetLocationHolder ()
  {
  }

  public GuichetLocationHolder (comV2.guichetLocation.GuichetLocation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = comV2.guichetLocation.GuichetLocationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    comV2.guichetLocation.GuichetLocationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return comV2.guichetLocation.GuichetLocationHelper.type ();
  }

}
