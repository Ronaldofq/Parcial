	package com.dev.factory;

import com.dev.dao.IAdministrativodao;
import com.dev.dao.IAreadao;
import com.dev.dao.IAsignaciondao;
import com.dev.dao.IHelpDeskdao;
import com.dev.dao.IRequerimientodao;
import com.dev.dao.ISoluciondao;
import com.dev.dao.impl.Administrativodao;
import com.dev.dao.impl.Areadao;
import com.dev.dao.impl.Asignaciondao;
import com.dev.dao.impl.HelpDeskdao;
import com.dev.dao.impl.Requerimientodao;
import com.dev.dao.impl.Soluciondao;

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
	
	public IAdministrativodao getAdministrativosdao()
	{
		return new Administrativodao();
	}
	
	public IAreadao getAreasdao()
	{
		return new Areadao();
	}
	
	public IAsignaciondao getAsignacionesdao()
	{
		return new Asignaciondao();
	}
	
	public IHelpDeskdao getHelpDeskdao()
	{
		return new HelpDeskdao();
	}
	
	public IRequerimientodao getRequerimientosdao()
	{
		return new Requerimientodao();
	}
	
	public ISoluciondao getSolucionesdao()
	{
		return new Soluciondao();
	}
}
