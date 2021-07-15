package custom_id_generator;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

public class CustomGenerator extends IdentityGenerator
{	int i = 1000;
	@Override
	public Serializable generate(SessionImplementor s, Object obj) 
	{	
		String name = "ICICI";
		
		name = name+(++i);
		
		System.out.println(name);
		return name;
	}

	

}
