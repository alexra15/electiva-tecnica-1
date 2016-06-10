package sv.edu.ucad.api.atencionclientes.data;
import java.util.Date;
import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Utiles;
import sv.edu.ucad.api.atencionclientes.entities.Prestamos;
import sv.edu.ucad.api.atencionclientes.entities.Alumnos;

public class UnoaUnoUniLucy {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
			try{
				org.hibernate.Transaction transaccion = sesion.beginTransaction();
			
				Utiles util = createNewUtiles();
				Alumnos alumnos = createNewAlumnos();
				Prestamos pre = createNewPrestamos(util, alumnos );

				sesion.save(pre);
				transaccion.commit();	
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				sesion.close();
				HibernateUtil.getSessionFactory().close();
			}	
		}
	

		private static Alumnos createNewAlumnos() {
			Alumnos alumnos = new Alumnos();
			alumnos.setNomalu("sandra");
			alumnos.setApealu("amos");
			alumnos.setCicloalu("iv");
			alumnos.setCarnetalu("ra12007");
			alumnos.setCuealu("80");
			alumnos.setClavealu("ar212");
			
		return alumnos;
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
	
		private static Utiles createNewUtiles() {
			Utiles util = new Utiles();
			util.setNomutil("Regla");
			return util;
		}
	}