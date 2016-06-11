package sv.edu.ucad.api.atencionclientes.entities;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;

public class persistemCarreras2 {
	public static void main(String[] arg){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Carreras carreras = createNuevaCarreras();//estado transient

		System.out.println(session.contains(carreras));

		try{
		org.hibernate.Transaction Transaccion = session.beginTransaction();
		session.save(carreras);

		System.out.println(session.contains(carreras));

		Transaccion.commit();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		session.close();
		HibernateUtil.getSessionFactory().close();
		}
	}//fin de try, catch, finally

	private static Carreras createNuevaCarreras() {
		// TODO Auto-generated method stub
		Carreras car = new Carreras();
		car.setCodcar(1);
		car.setNomcar("ing en computo");
		return car;
	}

}
