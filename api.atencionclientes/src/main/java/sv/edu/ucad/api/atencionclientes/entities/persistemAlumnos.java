package sv.edu.ucad.api.atencionclientes.entities;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;

public class persistemAlumnos {
	public static void main(String[] arg){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Alumnos alumnos = createNuevaAlumnos();//estado transient

		System.out.println(session.contains(alumnos));

		try{
		org.hibernate.Transaction Transaccion = session.beginTransaction();
		session.save(alumnos);

		System.out.println(session.contains(alumnos));

		Transaccion.commit();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		session.close();
		HibernateUtil.getSessionFactory().close();
		}
	}//fin de try, catch, finally

	private static Alumnos createNuevaAlumnos() {
		// TODO Auto-generated method stub
		Alumnos alum = new Alumnos();
		alum.setNomalu("Franklin");
		alum.setApealu("reyes");
		alum.setCarnetalu("RA12001");
		alum.setCicloalu("X");
		alum.setClavealu("hd3");
		alum.setCuealu("sdf");
		alum.setCodalu(1);
		
		return alum;
	}

	

}
