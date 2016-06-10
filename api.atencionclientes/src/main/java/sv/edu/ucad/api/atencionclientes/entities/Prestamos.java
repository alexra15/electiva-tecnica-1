package sv.edu.ucad.api.atencionclientes.entities;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="prestamos")
//accesso atraves de los get
@Access(value=AccessType.PROPERTY)

public class Prestamos {

    private int codpre;
    private Date fepre;
	private Date fedev;
	private Date femaxpre;
	
//Tabla asociada
	public Utiles util;
	public Alumnos alumnos;
	
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="codutil")
	public Utiles getUtil() {
				return util;
			}
			public void setUtil( Utiles util) {
				this.util = util;
			}
			
			//Asociacion UnoaUno Bidireccional
			@OneToOne(cascade=CascadeType.ALL)
			@JoinColumn(name="codalu")
			public Alumnos getAlumnos() {
				return alumnos;
			}
			public void setAlumnos(Alumnos alumnos) {
				this.alumnos = alumnos;
			}
			
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
		
@Column(name="codpre", updatable=false) 
public int getCodpre() {
return codpre;
}
public void setCodpre(int codpre) {
this.codpre = codpre;
}

@Column(name="fepre")
 public Date getFepre() {
 	return fepre;
}
 public void setFepre(Date fepre) {
    this.fepre = fepre;
}

 @Column(name="fedev")
 public Date getFedev() {
 	return fedev;
}
 public void setFedev(Date fedev) {
    this.fedev = fedev;
}
 
 @Column(name="femaxpre")
 public Date getFemaxpre() {
 	return femaxpre;
}
 public void setFemaxpre(Date femaxpre) {
    this.femaxpre = femaxpre;
}
 
}//Fin 
