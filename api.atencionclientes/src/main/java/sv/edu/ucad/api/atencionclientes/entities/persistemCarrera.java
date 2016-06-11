package sv.edu.ucad.api.atencionclientes.entities;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;

public class persistemCarrera {
	public static void main(String[] arg){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Carrera carrera = createNuevaCarrera();//estado transient

		System.out.println(session.contains(carrera));

		try{
		org.hibernate.Transaction Transaccion = session.beginTransaction();
		session.save(carrera);

		System.out.println(session.contains(carrera));

		Transaccion.commit();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		session.close();
		HibernateUtil.getSessionFactory().close();
		}
	}//fin de try, catch, finally

	private static Carrera createNuevaCarrera() {
		// TODO Auto-generated method stub
		Carrera car = new Carrera();
		car.setCodcar(8);
		car.setNomcar("Ingeneria en computacion");
		return car;
	}
}
