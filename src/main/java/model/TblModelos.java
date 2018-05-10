package model;
// Generated 09-mar-2018 12:34:10 by Hibernate Tools 4.3.1

import java.util.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.Session;

@Entity
@Table(name = "tbl_Modelos")
public class TblModelos implements java.io.Serializable, Crud {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Mod_Id", unique = true, nullable = false)
    private Integer modId;

    @ManyToOne(targetEntity = TblMarcas.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Marca_id")
    private TblMarcas tblMarcas;

    @Column(name = "Mod_Nombre", columnDefinition = "string")
    private String modNombre;

//    @OneToMany(targetEntity = BitaReparacion.class, fetch = FetchType.LAZY, mappedBy = "tblModelos")
//    private Set bitaReparacions = new HashSet(0);
//
//    @OneToMany(targetEntity = TblBitaMov.class, fetch = FetchType.LAZY, mappedBy = "tblModelos")
//    private Set tblBitaMovs = new HashSet(0);
    public TblModelos() {
    }

    public TblModelos(TblMarcas tblMarcas, String modNombre, Set bitaReparacions, Set tblBitaMovs) {
        this.tblMarcas = tblMarcas;
        this.modNombre = modNombre;
//        this.bitaReparacions = bitaReparacions;
//        this.tblBitaMovs = tblBitaMovs;
    }

    public Integer getModId() {
        return this.modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public TblMarcas getTblMarcas() {
        return this.tblMarcas;
    }

    public void setTblMarcas(TblMarcas tblMarcas) {
        this.tblMarcas = tblMarcas;
    }

    public String getModNombre() {
        return this.modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    @Override
    public String toString() {
        return "TblModelos{" + "modId=" + modId + ", tblMarcas=" + tblMarcas.getMarcaNombre() + ", modNombre=" + modNombre + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.modId);
        hash = 37 * hash + Objects.hashCode(this.tblMarcas);
        hash = 37 * hash + Objects.hashCode(this.modNombre);
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
        final TblModelos other = (TblModelos) obj;
        if (!Objects.equals(this.modNombre, other.modNombre)) {
            return false;
        }
        if (!Objects.equals(this.modId, other.modId)) {
            return false;
        }
        if (!Objects.equals(this.tblMarcas, other.tblMarcas)) {
            return false;
        }
        return true;
    }

    public static List<TblModelos> selectAll() {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        List<TblModelos> lista = sesion.createQuery("from TblModelos m inner join fetch m.tblMarcas").list();
        sesion.getTransaction().commit();
        return lista;
    }
    
    public static TblModelos buscarxClave(Integer Id){
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        TblModelos modelo=sesion.get(TblModelos.class, Id);
        sesion.getTransaction().commit();
        return modelo;
    }
    
   public static List<TblModelos> buscarxMarcas(Integer Id) {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        org.hibernate.Query q=sesion.createQuery("from TblModelos m inner join fetch m.tblMarcas where m.tblMarcas=:categoria");
        q.setInteger("categoria", Id);
        List<TblModelos> lista = q.list();
        //sesion.createQuery("from TblModelos m inner join fetch m.tblMarcas").setParameter(1, Id).list();
        sesion.getTransaction().commit();
        return lista;
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
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();        
        sesion.delete(this);
        sesion.getTransaction().commit();
    }
}
