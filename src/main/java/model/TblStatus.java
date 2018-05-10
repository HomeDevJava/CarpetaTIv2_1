package model;
// Generated 09-mar-2018 12:34:10 by Hibernate Tools 4.3.1

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "tbl_Status")
public class TblStatus implements java.io.Serializable,Crud {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Id_Status", unique = true, nullable = false)
    private Integer idStatus;
    @Column(name = "Descripcion", length = 50)
 
    private String descripcion;
//    @OneToMany(targetEntity = BitaReparacion.class, fetch = FetchType.LAZY, mappedBy = "tblStatusByIdStatus")
//    private Set bitaReparacionsForIdStatus = new HashSet(0);
//    @OneToMany(targetEntity = BitaReparacion.class, fetch = FetchType.LAZY, mappedBy = "tblStatusByIdStatusActa")
//    private Set bitaReparacionsForIdStatusActa = new HashSet(0);
//    @OneToMany(targetEntity = BitaReparacion.class, fetch = FetchType.LAZY, mappedBy = "tblStatusByIdStatusDescuento")
//    private Set bitaReparacionsForIdStatusDescuento = new HashSet(0);

    public TblStatus() {
    }

    public TblStatus(String descripcion) {
        this.descripcion = descripcion;
//        this.bitaReparacionsForIdStatus = bitaReparacionsForIdStatus;
//        this.bitaReparacionsForIdStatusActa = bitaReparacionsForIdStatusActa;
//        this.bitaReparacionsForIdStatusDescuento = bitaReparacionsForIdStatusDescuento;
    }

    public Integer getIdStatus() {
        return this.idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idStatus);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TblStatus other = (TblStatus) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.idStatus, other.idStatus)) {
            return false;
        }
        return true;
    }

    public static List<TblStatus> selectAll(){
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        List<TblStatus> lista=sesion.createQuery("from TblStatus").list();
        sesion.getTransaction().commit();        
        return lista;
    }
    
    public static TblStatus buscarxClave(Integer Id){
        Session sesion= HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        TblStatus status=sesion.get(TblStatus.class, Id);
        sesion.getTransaction().commit();
        return status;
    }

    @Override
    public void insert() {
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.saveOrUpdate(this);
        sesion.getTransaction().commit();
    }

    @Override
    public void delete() {
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.delete(this);
        sesion.getTransaction().commit();
    }
    
}