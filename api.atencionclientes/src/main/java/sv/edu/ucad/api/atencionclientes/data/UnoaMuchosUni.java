package sv.edu.ucad.api.atencionclientes.data;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Carreras;
import sv.edu.ucad.api.atencionclientes.entities.Facultad;

public class UnoaMuchosUni {
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			org.hibernate.Transaction transaccion = session.beginTransaction();
			
			Facultad facultad = createNuevaFacultad();
			facultad.getCarreras().add(createNuevaCarrera());
			session.save(facultad);
			
			transaccion.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}//fin del metodo main

	private static Facultad createNuevaFacultad(){
		Facultad facultad = new Facultad();
		facultad.setNomfac("Facultad jurisprudencia");
		return facultad;
	}//fin de createNuevaFacultad
	   
	private static Carreras createNuevaCarrera(){
		Carreras carr = new Carreras();
		carr.setNomcar("juris");
		return carr;
	}
	
}//fin de clase ppal
