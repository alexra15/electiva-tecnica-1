package sv.edu.ucad.api.atencionclientes.data;

import org.hibernate.Session;

import sv.edu.ucad.api.atencionclientes.entities.Alumnos;
import sv.edu.ucad.api.atencionclientes.entities.Carrera;

public class UnoaMuchosUniDemo {
	public static void main(String[] args){
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try{
			org.hibernate.Transaction transaccion = sesion.beginTransaction();
			
			
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
	
	private static Carrera createNuevaCar(){
		Carrera car = new Carrera();
		car.setNomcar("Ing_Computacion");
		return car;
	}//fin de createNuevaCar
	
	private static Alumnos createNuevaAlunu(){
		Alumnos alunu = new Alumnos();
		alunu.setNomalu("Luis");
		alunu.setApealu("Escobar");
		alunu.setCarnetalu("EH12016");
		alunu.setCicloalu("I");
		alunu.setCuealu("LuiH");
		alunu.setClavealu("perro");
		return alunu;
	}//fin de createNuevaAlunu
	
	private static Alumnos createNuevaAluant(){
		Alumnos aluant = new Alumnos();
		aluant.setNomalu("Erica");
		aluant.setApealu("Martinez");
		aluant.setCarnetalu("CM12005");
		aluant.setCicloalu("IX");
		aluant.setCuealu("EriMar");
		aluant.setClavealu("ucad00");
		return aluant;
	}//fin de createNuevaAluant
	
}//fin de clase ppal
