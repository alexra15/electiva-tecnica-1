package sv.edu.ucad.api.atencionclientes.data;

import org.hibernate.Session;


public class TestPg {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		sesion.close();
	}

}
