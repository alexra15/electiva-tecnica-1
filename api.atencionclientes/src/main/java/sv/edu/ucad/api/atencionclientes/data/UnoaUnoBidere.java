package sv.edu.ucad.api.atencionclientes.data;

import java.util.Date;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Prestamos;
import sv.edu.ucad.api.atencionclientes.entities.Utiles;
import sv.edu.ucad.api.atencionclientes.entities.Alumnos;

public class UnoaUnoBidere {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
			try{
				org.hibernate.Transaction transaccion = sesion.beginTransaction();
			
				Utiles util = createNewUtiles();
				Alumnos alumnos = createNewAlumnos();
				Prestamos prestamos = createNewPrestamos(util, alumnos);
				
				prestamos.setAlumnos(alumnos);
				alumnos.setPrestamos(prestamos);
				
				sesion.save(prestamos);
				transaccion.commit();
				
				Alumnos bdalumnos =(Alumnos)sesion.get(Alumnos.class, prestamos.getAlumnos().getCodalu());
				System.out.println("el codigo es :"+ bdalumnos.getNomalu());
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				sesion.close();
				HibernateUtil.getSessionFactory().close();
			}	
		}


		private static Prestamos createNewPrestamos(Utiles util, Alumnos alumnos) {
			Prestamos pre = new Prestamos();
			pre.setFepre(new Date());
			pre.setFedev(new Date());
			pre.setFemaxpre(new Date());
			pre.setUtil(util);
			pre.setAlumnos(alumnos);
		return pre;
	}


		private static Alumnos createNewAlumnos() {
		Alumnos alumnos = new Alumnos();
		alumnos.setApealu("ramirez");
		alumnos.setCarnetalu("lm452001");
		alumnos.setCicloalu("IV");
		alumnos.setClavealu("er34");
		alumnos.setCuealu("www");
		alumnos.setNomalu("luis");
		return alumnos;
	}

	
		private static Utiles createNewUtiles() {
			Utiles util = new Utiles();
			util.setNomutil("Regla");
			return util;
		}


}
