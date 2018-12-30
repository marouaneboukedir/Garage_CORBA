package comV2;


/**
* comV2/VoituresListHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from garage.idl
* dimanche 23 d�cembre 2018 17 h 49 WET
*/

abstract public class VoituresListHelper
{
  private static String  _id = "IDL:comV2/VoituresList:1.0";

  public static void insert (org.omg.CORBA.Any a, comV2.Voiture[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static comV2.Voiture[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = comV2.VoitureHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (comV2.VoituresListHelper.id (), "VoituresList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static comV2.Voiture[] read (org.omg.CORBA.portable.InputStream istream)
  {
    comV2.Voiture value[] = null;
    int _len0 = istream.read_long ();
    value = new comV2.Voiture[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = comV2.VoitureHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, comV2.Voiture[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      comV2.VoitureHelper.write (ostream, value[_i0]);
  }

}