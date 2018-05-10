package model;
// Generated 09-mar-2018 12:34:10 by Hibernate Tools 4.3.1

import java.util.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.*;

/**
 * TblCedis generated by hbm2java
 */
@Entity
@Table(name = "tbl_Cedis")
public class TblCedis implements java.io.Serializable, Crud {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Ced_Id", unique = true, nullable = false)
    private Integer cedId;
    @Column(name = "Ced_Nombre")
    private String cedNombre;
    @Column(name = "Ced_UOP")
    private Integer cedUop;
    @Column(name = "Ced_Domicilio")
    private String cedDomicilio;
//    @OneToMany(targetEntity = BitaReparacion.class, fetch = FetchType.LAZY, mappedBy = "tblCedis")
//    private Set bitaReparacions = new HashSet(0);
//    @OneToMany(targetEntity = TblBitaMov.class, fetch = FetchType.LAZY, mappedBy = "tblCedis")
//    private Set tblBitaMovs = new HashSet(0);

    public TblCedis() {
    }

    public TblCedis(String cedNombre, Integer cedUop, String cedDomicilio, Set bitaReparacions, Set tblBitaMovs) {
        this.cedNombre = cedNombre;
        this.cedUop = cedUop;
        this.cedDomicilio = cedDomicilio;
//        this.bitaReparacions = bitaReparacions;
//        this.tblBitaMovs = tblBitaMovs;
    }

    public Integer getCedId() {
        return this.cedId;
    }

    public void setCedId(Integer cedId) {
        this.cedId = cedId;
    }

    public String getCedNombre() {
        return this.cedNombre;
    }

    public void setCedNombre(String cedNombre) {
        this.cedNombre = cedNombre;
    }

    public Integer getCedUop() {
        return this.cedUop;
    }

    public void setCedUop(Integer cedUop) {
        this.cedUop = cedUop;
    }

    public String getCedDomicilio() {
        return this.cedDomicilio;
    }

    public void setCedDomicilio(String cedDomicilio) {
        this.cedDomicilio = cedDomicilio;
    }

//    public Set getBitaReparacions() {
//        return this.bitaReparacions;
//    }
//
//    public void setBitaReparacions(Set bitaReparacions) {
//        this.bitaReparacions = bitaReparacions;
//    }
//
//    public Set getTblBitaMovs() {
//        return this.tblBitaMovs;
//    }
//
//    public void setTblBitaMovs(Set tblBitaMovs) {
//        this.tblBitaMovs = tblBitaMovs;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.cedId);
        hash = 29 * hash + Objects.hashCode(this.cedNombre);
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
        final TblCedis other = (TblCedis) obj;
        if (!Objects.equals(this.cedNombre, other.cedNombre)) {
            return false;
        }
        if (!Objects.equals(this.cedId, other.cedId)) {
            return false;
        }
        return true;
    }

    public static List<TblCedis> selectAll() {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        List<TblCedis> lista = sesion.createQuery("from TblCedis").list();
        sesion.getTransaction().commit();
        return lista;
    }

    public static List<TblCedis> selectAllPag(Integer offset, Integer noOfRecords) {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        //Criteria criteria = sesion.createCriteria(TblCedis.class).setFirstResult(offset).setMaxResults(noOfRecords);
        //Query query = sesion.createQuery("from TblCedis"); query.setFirstResult(offset);query.setMaxResults(noOfRecords);            
        List<TblCedis> lista = sesion.createCriteria(TblCedis.class).setFirstResult(offset).setMaxResults(noOfRecords).list();
        sesion.getTransaction().commit();

        return lista;
    }

    public static TblCedis buscarxClave(Integer Id) {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        TblCedis c = sesion.get(TblCedis.class, Id);
        sesion.getTransaction().commit();
        return c;
    }

    @Override
    public void insert() {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.saveOrUpdate(this);
        sesion.getTransaction().commit();
    }

    @Override
    public void delete() {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.delete(this);
        sesion.getTransaction().commit();
    }

}