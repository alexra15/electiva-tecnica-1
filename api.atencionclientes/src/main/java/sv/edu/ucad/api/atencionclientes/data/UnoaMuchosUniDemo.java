package sv.edu.ucad.api.atencionclientes.data;

import java.util.Date;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Libro;
import sv.edu.ucad.api.atencionclientes.entities.Prestamos;

public class UnoaMuchosUniDemo {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try{
			org.hibernate.Transaction transaccion = sesion.beginTransaction();
			// tabla sala es administradora y la sucursal es la administrada
		Libro Libro = createNuevaLibro();
		Libro.getPrestamos().add(createNuevaPrestamosImax());
		Libro.getPrestamos().add(createNuevaPrestamosStandard());
			sesion.save(Libro);
			
			transaccion.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sesion.close();
			HibernateUtil.getSessionFactory().close();
		}
	}//fin del metodo main

	private static Libro createNuevaLibro(){
		Libro Libro = new Libro();
		//Libro.setCodlib((long) 4);
		Libro.setTitlib("Multiplaza");
		Libro.setSubtitlib("Merliot, La Libertad");
		Libro.setNumjemlib(7);
		Libro.setNumpaglib(8);
		Libro.setResulib("MerliT");
		return Libro;
	}//fin de createNuevaSucursal
	
	private static Prestamos createNuevaPrestamosImax(){
		Prestamos cnPrestamosImax = new Prestamos();
		
		cnPrestamosImax.setFentrepre((new Date()));
		cnPrestamosImax.setFdevpre((new Date()));
		cnPrestamosImax.setFmaxpre((new Date()));
//		cnPrestamosImax.setPrest(alum);
		//cnPrestamosImax.setCodlib((long) 4);
		//cnPrestamosImax.setCodutil((long)5);
			//modificado por la OneToOne Uninidireccional
	//	cnPrestamosImax.setCodpre((long) 1);	
			return cnPrestamosImax;
	}//fin de createNuevaSalasImax
	
	private static Prestamos createNuevaPrestamosStandard(){
		Prestamos cnPrestamosStd = new Prestamos();
		cnPrestamosStd.setFentrepre((new Date()));
		cnPrestamosStd.setFdevpre((new Date()));
		cnPrestamosStd.setFmaxpre((new Date()));
//		cnPrestamosImax.setPrest(alum);
		//cnPrestamosStd.setCodlib((long) 4);
		//cnPrestamosStd.setCodutil((long)4);
			//modificado por la OneToOne Uninidireccional
		//cnPrestamosStd.setCodpre((long) 2);	
			return cnPrestamosStd;
	}//fin de createNuevaSalasImax	
	
}//fin de clase ppal
