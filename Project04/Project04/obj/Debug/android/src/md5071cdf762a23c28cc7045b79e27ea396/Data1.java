package md5071cdf762a23c28cc7045b79e27ea396;


public class Data1
	extends android.app.Activity
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("Project04.Data1, Project04, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", Data1.class, __md_methods);
	}


	public Data1 () throws java.lang.Throwable
	{
		super ();
		if (getClass () == Data1.class)
			mono.android.TypeManager.Activate ("Project04.Data1, Project04, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new java.lang.Object[] {  });
	}

	private java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
