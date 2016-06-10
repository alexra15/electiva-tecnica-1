package sv.edu.ucad.api.atencionclientes.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// en esta clase crear una instancia para relacionar entre las tablas(instancia facultad
@Entity
@Table(name="carrera")
@Access(value=AccessType.PROPERTY)
public class Carreras {
	private int codcar;
	private String nomcar;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codcar", updatable=false)
	public int getCodcar(){
		return codcar;
	}
    public void setCodcar(int codcar){
    	this.codcar = codcar;
    }
    @Column(name="nomcar", nullable=false)
    public String getNomcar(){
    	return nomcar;
    }
    public void setNomcar(String nomcar){
    	this.nomcar = nomcar;
    }
    
}
