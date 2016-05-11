package sv.edu.ucad.api.atencionclientes.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Prestamos")
@Access(value=AccessType.PROPERTY)


public class Prestamos {
	private long codpre;
	private Date fentrepre;
	private Date fdevpre;
	private Date fmaxpre;
	//private long codlib;
	private long codutil;
	
	public Alumnos alum;	

	//asociacion UnoaUno Unidireccional
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="codalu")
		public Alumnos getPrest() {
			return alum;
		}
		public void setPrest( Alumnos alum) {
			this.alum = alum;
		}
	
	//propiedad bandera, que se declara como @Transient
		private boolean estado;
		
		@Transient	
		public boolean isEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
		}
	
	//definir metodos getters y setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codpre", updatable=false)
	public long getCodpre() {
		return codpre;
	}
	public void setCodpre(long codpre) {
		this.codpre = codpre;
	}
	@Column(name="fentrepre")
	public Date getFentrepre() {
		return fentrepre;
	}
	public void setFentrepre(Date fentrepre) {
		this.fentrepre = fentrepre;
	}
	@Column(name="fdevpre")
	public Date getFdevpre() {
		return fdevpre;
	}
	public void setFdevpre(Date fdevpre) {
		this.fdevpre = fdevpre;
	}
	@Column(name="fmaxpre")
	public Date getFmaxpre() {
		return fmaxpre;
	}
	public void setFmaxpre(Date fmaxpre) {
		this.fmaxpre = fmaxpre;
	}
	/*	@Column(name="codlib", nullable=false)
	public long getCodlib() {
		return codlib;
	}
   public void setCodlib(long codlib) {
		this.codlib = codlib;
	}
	*/
	@Column(name="codutil", nullable=false)
	public long getCodutil() {
		return codutil;
	}
	public void setCodutil(long codutil) {
		this.codutil = codutil;
	}
	

}
