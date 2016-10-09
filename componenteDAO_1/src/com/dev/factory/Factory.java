package com.dev.factory;

public class Factory {

	private static Factory fac;
	
	private Factory()
	{}
	
	public static Factory getInstance()
	{
		if(fac==null)
			fac = new Factory();
		return fac;
	}
}
