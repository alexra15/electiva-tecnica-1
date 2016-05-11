package sv.edu.ucad.api.atencionclientes.data;



import java.util.Date;


import org.hibernate.Session;

//import sv.edu.ucad.api.atencionclientes.data.HibernateUtil;
import sv.edu.ucad.api.atencionclientes.entities.Alumnos;
//import sv.edu.ucad.api.atencionclientes.entities.Libro;
import sv.edu.ucad.api.atencionclientes.entities.Prestamos;


public class UnoaunoDemo {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.getTransaction().begin();
		try{
			org.hibernate.Transaction transaccion = sesion.beginTransaction();
		
			Alumnos alum = createNewAlumnos();
			Prestamos prestamos = createNewPrest(alum);

			sesion.save(prestamos);
			transaccion.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sesion.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
		//clases empotradas que crean Prestamos y Alumnos
		//crea un nuevo prestamo
		
		private static Prestamos createNewPrest(Alumnos alum) {
			Prestamos prestamo = new Prestamos();
		    prestamo.setFentrepre((new Date()));
			prestamo.setFdevpre((new Date()));
			prestamo.setFmaxpre((new Date()));
	        prestamo.setPrest(alum);
		//	prestamo.setCodlib((long) 1);
			prestamo.setCodutil((long) 1);
			//modificado por la OneToOne Uninidireccional
			prestamo.setCodpre((long) 1);	
			return prestamo;
		}
		
		//crea un nuevo Alumno
		private static Alumnos createNewAlumnos() {
			Alumnos alum = new Alumnos();
			alum.setNomalu("alexander");
			alum.setApealu("reyes");
			alum.setCarnetalu("RA12001");
			alum.setCuealu(15);
			alum.setClavealu("RA12001");
			return alum;
		}

	}//fin de la clase Principal
		
	

	