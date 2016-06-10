package sv.edu.ucad.api.atencionclientes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facultad")
@Access(value=AccessType.PROPERTY)
public class Facultad {
    private int codfac;
	private String nomfac;

//DEFINIR GETTERS Y SETTERS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codfac", updatable=false)
	public int getCodfac (){
		return codfac;
	}
	public void setCodfac(int codfac) {
		this.codfac = codfac;
	}

	List<Carreras> carreras = new ArrayList<Carreras>();
	@OneToMany(cascade=CascadeType.ALL, mappedBy="")
    @JoinColumn(name="codfac") 
	public List<Carreras> getCarreras(){
		return carreras;
	}
	
	public void setCarreras(List<Carreras> carreras){
		this.carreras = carreras;
	}
	
	@Column(name="nomfac", nullable=false)
	public String getNomfac (){
		return nomfac ;
	}
	public void setNomfac (String nomfac){
		this.nomfac = nomfac;
	}
}
