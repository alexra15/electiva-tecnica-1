package sv.edu.ucad.api.atencionclientes.entities;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
@Access(value=AccessType.PROPERTY)

public class Alumnos {
	
	
	private long codalu;
	
	private String nomalu;
	
	private String apealu;
	
	private String carnetalu;
	
	private int cuealu;
	
	private String clavealu;
	
	private long codcar;
	
	//definir metodos getters y setters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codalu", updatable=false)
	public long getCodalu() {
		return codalu;
	}
	public void setCodalu(long codalu) {
		this.codalu = codalu;
	}
	@Column(name="nomalu", nullable=false)
	public String getNomalu() {
		return nomalu;
	}
	public void setNomalu(String nomalu) {
		this.nomalu = nomalu;
	}
	@Column(name="apealu", nullable=false)
	public String getApealu() {
		return apealu;
	}
	public void setApealu(String apealu) {
		this.apealu = apealu;
	}
	@Column(name="carnetalu", nullable=false)
	public String getCarnetalu() {
		return carnetalu;
	}
	public void setCarnetalu(String carnetalu) {
		this.carnetalu = carnetalu;
	}
	@Column(name="cuealu", nullable=false)
	public int getCuealu() {
		return cuealu;
	}
	public void setCuealu(int cuealu) {
		this.cuealu = cuealu;
	}
	@Column(name="clavealu", nullable=false)
	public String getClavealu() {
		return clavealu;
	}
	public void setClavealu(String clavealu) {
		this.clavealu = clavealu;
	}
	@Column(name="codcar", nullable=false)
	public long getCodcar() {
		return codcar;
	}
	public void setCodcar(long codcar) {
		this.codcar = codcar;
	}
	
	
	

}
