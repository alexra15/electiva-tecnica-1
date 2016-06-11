package sv.edu.ucad.api.atencionclientes.entities;

import java.util.Date;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;

public class persistemPrestamos {
	public static void main(String[] arg){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Prestamos prestamos = createNuevaPrestamos();//estado transient

		System.out.println(session.contains(prestamos));

		try{
		org.hibernate.Transaction Transaccion = session.beginTransaction();
		session.save(prestamos);

		System.out.println(session.contains(prestamos));

		Transaccion.commit();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		session.close();
		HibernateUtil.getSessionFactory().close();
		}
	}//fin de try, catch, finally

	private static Prestamos createNuevaPrestamos() {
		// TODO Auto-generated method stub
		Prestamos pre = new Prestamos();
		pre.setCodpre(1);
		pre.setFedev(new Date());
		pre.setFemaxpre(new Date());
		pre.setFepre(new Date());
		return pre;
	}

}
