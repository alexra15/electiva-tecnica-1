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
@Table(name="Libros")
@Access(value=AccessType.PROPERTY)


public class Libro {
	
	private long codlib;
	private String titlib;
	private String subtitlib;
	private int numjemlib;
	private int numpaglib;
	private String resulib;
	//private long codbiblio;
	//private long codcategolib;
	
	
	//definir metodos getters y setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codlib", updatable=false)
	public long getCodlib() {
		return codlib;
		}
		
	public void setCodlib(long codlib) {
		this.codlib = codlib;
	}
	
	List<Prestamos> prestamos = new ArrayList<Prestamos>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="codlib", nullable=false)	
	public List<Prestamos> getPrestamos() {
		return prestamos;
	}
	public void setSalas(List<Prestamos> prestamos) {
		this.prestamos = prestamos;
	}
	
	@Column(name="titlib", nullable=false)
	public String getTitlib() {
		return titlib;
	}
	public void setTitlib(String titlib) {
		this.titlib = titlib;
	}
	@Column(name="subtitlib", nullable=false)
	public String getSubtitlib() {
		return subtitlib;
	}
	public void setSubtitlib(String subtitlib) {
		this.subtitlib = subtitlib;
	}
	@Column(name="numejemlib", nullable=false)
	public int getNumjemlib() {
		return numjemlib;
	}
	public void setNumjemlib(int numjemlib) {
		this.numjemlib = numjemlib;
	}
	@Column(name="numpaglib", nullable=false)
	public int getNumpaglib() {
		return numpaglib;
	}
	public void setNumpaglib(int numpaglib) {
		this.numpaglib = numpaglib;
	}
	@Column(name="resulib", nullable=false)
	public String getResulib() {
		return resulib;
	}
	public void setResulib(String resulib) {
		this.resulib = resulib;
	}
/*	@Column(name="codbiblio", nullable=false)
	public long getCodbiblio() {
		return codbiblio;
	}
	public void setCodbiblio(long codbiblio) {
		this.codbiblio = codbiblio;
	}
	@Column(name="codcategolib", nullable=false)
	public long getCodcategolib() {
		return codcategolib;
	}
	public void setCodcategolib(long codcategolib) {
		this.codcategolib = codcategolib;
	}
	
	
*/
}
