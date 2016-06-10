package sv.edu.ucad.api.atencionclientes.data;
import java.util.Date;
import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Utiles;
import sv.edu.ucad.api.atencionclientes.entities.Prestamos;

public class UnoaUnoUni {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
			try{
				org.hibernate.Transaction transaccion = sesion.beginTransaction();
			
				Utiles util = createNewUtiles();
				Prestamos pre = createNewPrestamos(util);

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


		private static Prestamos createNewPrestamos(Utiles util) {
			Prestamos pre = new Prestamos();
			pre.setFepre(new Date());
			pre.setFedev(new Date());
			pre.setFemaxpre(new Date());
			pre.setUtil(util);
		
		
			return pre;
		}
	
		private static Utiles createNewUtiles() {
			Utiles util = new Utiles();
			util.setNomutil("Regla");
			return util;
		}
	}