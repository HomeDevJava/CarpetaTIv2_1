package model;
// Generated 09-mar-2018 12:34:10 by Hibernate Tools 4.3.1

import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.Session;

@Entity
@Table(name = "tbl_Marcas")
public class TblMarcas implements java.io.Serializable, Crud {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Marca_Id", unique = true, nullable = false)
    private Integer marcaId;

    @Column(name = "Marca_Nombre", nullable = false)
    private String marcaNombre;

//    @OneToMany(targetEntity = TblModelos.class, fetch = FetchType.LAZY, mappedBy = "tblMarcas")
//    private Set tblModeloses = new HashSet(0);

    public TblMarcas() {
    }

    public TblMarcas(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }

//    public TblMarcas(String marcaNombre, Set tblModeloses) {
//        this.marcaNombre = marcaNombre;
//        //this.tblModeloses = tblModeloses;
//    }

    public Integer getMarcaId() {
        return this.marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }
  
    public String getMarcaNombre() {
        return this.marcaNombre;
    }
    
    public void setMarcaNombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }

//    public Set getTblModeloses() {
//        return this.tblModeloses;
//    }
//
//    public void setTblModeloses(Set tblModeloses) {
//        this.tblModeloses = tblModeloses;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.marcaId);
        hash = 31 * hash + Objects.hashCode(this.marcaNombre);
        //hash = 31 * hash + Objects.hashCode(this.tblModeloses);
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
        final TblMarcas other = (TblMarcas) obj;
        if (!Objects.equals(this.marcaNombre, other.marcaNombre)) {
            return false;
        }
        if (!Objects.equals(this.marcaId, other.marcaId)) {
            return false;
        }
        //if (!Objects.equals(this.tblModeloses, other.tblModeloses)) {
        //return false;
        //        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "{" +  marcaId + ","+ marcaNombre + '}';
//    }
    
    public static List<TblMarcas> selectAll() {        
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        List<TblMarcas> lista = sesion.createQuery("from TblMarcas").list();
        sesion.getTransaction().commit();
        return lista;
    }

    public static List<TblMarcas> selectAllP(Integer offset, Integer noOfRecords) {
        List<TblMarcas> lista;
        try (Session sesion = HibernateHelper.getSessionFactory().openSession()) {
            sesion.getTransaction().begin();
            lista = sesion.createCriteria(TblMarcas.class).setFirstResult(offset).setMaxResults(noOfRecords).list();
            sesion.getTransaction().commit();
        }
        return lista;
    }
    
    public static TblMarcas buscarxClave(Integer Id){
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        TblMarcas m=sesion.get(TblMarcas.class, Id);
        sesion.getTransaction().commit();
        return m;
    }

    @Override
    public void insert() {
        Session sesion= HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.saveOrUpdate(this);
        sesion.getTransaction().commit();
    }

    @Override
    public void delete() {
        Session sesion= HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.delete(this);
        sesion.getTransaction().commit();
    }

}