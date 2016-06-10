package sv.edu.ucad.api.atencionclientes.data;

import java.util.Date;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Alumnos;
import sv.edu.ucad.api.atencionclientes.entities.Carrera;
import sv.edu.ucad.api.atencionclientes.entities.Prestamos;

public class UnoaMuchosBidire {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try{
			org.hibernate.Transaction transaccion = sesion.beginTransaction();
			
			Prestamos pre = createNuevaPres();
			Carrera car = createNuevaCar();
			car.getAlumnos().add(createNuevaAlunu());
			car.getAlumnos().add(createNuevaAluant());
				
			sesion.save(car);
			
			transaccion.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sesion.close();
			HibernateUtil.getSessionFactory().close();
		}
	}//fin del metodo main
	
	private static Prestamos createNuevaPres() {
		Prestamos pre = new Prestamos();
		pre.setFepre(new Date());
		pre.setFedev(new Date());
		pre.setFemaxpre(new Date());
		return pre;
	}

	private static Carrera createNuevaCar(){
		Carrera car = new Carrera();
		car.setNomcar("ingles");
		return car;
	}//fin de createNuevaCar
	
	private static Alumnos createNuevaAlunu(){
		Alumnos alunu = new Alumnos();
		alunu.setNomalu("pepe");
		alunu.setApealu("Escobar");
		alunu.setCarnetalu("EH12016");
		alunu.setCicloalu("I");
		alunu.setCuealu("LuiH");
		alunu.setClavealu("perro");
		return alunu;
	}//fin de createNuevaAlunu
	
	private static Alumnos createNuevaAluant(){
		Alumnos aluant = new Alumnos();
		aluant.setNomalu("Franklin");
		aluant.setApealu("reyes");
		aluant.setCarnetalu("ra12001");
		aluant.setCicloalu("IX");
		aluant.setCuealu("cfre");
		aluant.setClavealu("ucrad00");
		return aluant;
	}//fin de createNuevaAluant

}
