package sv.edu.ucad.api.atencionclientes.entities;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;

public class persistemUtiles {
	public static void main(String[] arg){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Utiles utiles = createNuevaUtiles();//estado transient

		System.out.println(session.contains(utiles));

		try{
		org.hibernate.Transaction Transaccion = session.beginTransaction();
		session.save(utiles);

		System.out.println(session.contains(utiles));

		Transaccion.commit();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		session.close();
		HibernateUtil.getSessionFactory().close();
		}
	}//fin de try, catch, finally

	private static Utiles createNuevaUtiles() {
		// TODO Auto-generated method stub
		Utiles uti = new Utiles();
		uti.setCodutil(1);
		uti.setNomutil("borrador");
		return uti;
	}


}
