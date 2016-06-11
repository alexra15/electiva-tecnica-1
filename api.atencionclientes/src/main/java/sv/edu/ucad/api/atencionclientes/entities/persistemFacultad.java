package sv.edu.ucad.api.atencionclientes.entities;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;

public class persistemFacultad {
	public static void main(String[] arg){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Facultad facultad = createNuevaFacultad();//estado transient

		System.out.println(session.contains(facultad));

		try{
		org.hibernate.Transaction Transaccion = session.beginTransaction();
		session.save(facultad);

		System.out.println(session.contains(facultad));

		Transaccion.commit();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		session.close();
		HibernateUtil.getSessionFactory().close();
		}
	}//fin de try, catch, finally

	private static Facultad createNuevaFacultad() {
		// TODO Auto-generated method stub
		Facultad fac = new Facultad();
		fac.setCodfac(2);
		fac.setNomfac("Facultad DE la mejor Ingereria");
		return fac;
	}

}
