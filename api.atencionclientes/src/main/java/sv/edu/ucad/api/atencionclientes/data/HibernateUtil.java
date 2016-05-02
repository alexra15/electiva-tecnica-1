package sv.edu.ucad.api.atencionclientes.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			//Configuration configuration = new Configuration();
			//return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata mdata = new MetadataSources(ssr).getMetadataBuilder().build();
			return mdata.getSessionFactoryBuilder().build();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Ocurrio un error en la construcction de la Sesion Factory");
		}
	}//fin de buildSessionfactory
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}//fin de HibernateUitl
