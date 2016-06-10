package sv.edu.ucad.api.atencionclientes.data;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Carreras;

public class DemoEstado {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();

		Carreras carreras = createNewCarreras(); //estado Transient

		System.out.println(sesion.contains(carreras));

		try {
		      org.hibernate.Transaction transaccion = sesion.beginTransaction();
		      sesion.save(carreras);

		      System.out.println(sesion.contains(carreras));

		      transaccion.commit();

		}catch(Exception e) {
			e.printStackTrace();
		 }finally{
			sesion.close();
			HibernateUtil.getSessionFactory().close();
		}//fin de try , catch, finally
	}//fin del metodo main

	private static Carreras createNewCarreras() {
		Carreras carre = new Carreras();
		carre.setNomcar("Contaduria Publica");
		// TODO Auto-generated method stub
		return carre;//return null;
	}

	
}


	