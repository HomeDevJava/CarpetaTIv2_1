package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.Session;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.criterion.Order;

@Entity
@Table(name = "BitaReparacion")
@DynamicUpdate
public class BitaReparacion implements Crud, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdFolio", unique = true, nullable = false)
    private Integer idFolio;

    @ManyToOne(targetEntity = TblCedis.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Ced_Id")
    private TblCedis tblCedis;

    @ManyToOne(targetEntity = TblEmpleados.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Empleado_Id")
    private TblEmpleados tblEmpleados;

    @ManyToOne(targetEntity = TblModelos.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Mod_Id")
    private TblModelos tblModelos;

    @ManyToOne(targetEntity = TblStatus.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Status")
    private TblStatus tblStatusByIdStatus;

    @ManyToOne(targetEntity = TblStatus.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Status_Acta")
    private TblStatus tblStatusByIdStatusActa;

    @ManyToOne(targetEntity = TblStatus.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_status_Descuento")
    private TblStatus tblStatusByIdStatusDescuento;

    @Column(name = "Serie", length = 20)
    private String serie;

    @Column(name = "FallaDetalle", columnDefinition = "LongText")
    private String fallaDetalle;

    @ManyToOne(targetEntity = TblStatus.class)
    @JoinColumn(name = "IdTipoProblema")
    private TblStatus idTipoProblema;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fec_Envio", length = 10)
    private Date fecEnvio;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fec_Retorno", length = 10)
    private Date fecRetorno;
    @Column(name = "Observaciones")
    private String observaciones;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fec_Initramite", length = 10)
    private Date fecInitramite;
    @Column(name = "Ro", length = 15)
    private String ro;

    public BitaReparacion() {
    }

    public BitaReparacion(TblCedis tblCedis, TblEmpleados tblEmpleados, TblModelos tblModelos, TblStatus tblStatusByIdStatus, TblStatus tblStatusByIdStatusActa, TblStatus tblStatusByIdStatusDescuento,
            String serie, String fallaDetalle, TblStatus idTipoProblema, String fecEnvio, String fecRetorno, String observaciones, String fecInitramite, String ro) {
        this.tblCedis = tblCedis;
        this.tblEmpleados = tblEmpleados;
        this.tblModelos = tblModelos;
        this.tblStatusByIdStatus = tblStatusByIdStatus;
        this.tblStatusByIdStatusActa = tblStatusByIdStatusActa;
        this.tblStatusByIdStatusDescuento = tblStatusByIdStatusDescuento;
        this.serie = serie;
        this.fallaDetalle = fallaDetalle;
        this.idTipoProblema = idTipoProblema;
        this.fecEnvio = java.sql.Date.valueOf(fecEnvio);
        this.fecRetorno = java.sql.Date.valueOf(fecRetorno);
        this.observaciones = observaciones;
        this.fecInitramite = java.sql.Date.valueOf(fecInitramite);
        this.ro = ro;
    }

    public BitaReparacion(Integer tblCedis, Integer tblEmpleados, Integer tblModelos, Integer tblStatusByIdStatus, Integer tblStatusByIdStatusActa, Integer tblStatusByIdStatusDescuento,
            String serie, String fallaDetalle, Integer idTipoProblema, String fecEnvio, String fecRetorno, String observaciones, String fecInitramite, String ro) {
        this.tblCedis = TblCedis.buscarxClave(tblCedis);
        this.tblEmpleados = TblEmpleados.buscarxClave(tblEmpleados);
        this.tblModelos = TblModelos.buscarxClave(tblModelos);
        this.tblStatusByIdStatus = TblStatus.buscarxClave(tblStatusByIdStatus);
        this.tblStatusByIdStatusActa = TblStatus.buscarxClave(tblStatusByIdStatusActa);
        this.tblStatusByIdStatusDescuento = TblStatus.buscarxClave(tblStatusByIdStatusDescuento);
        this.serie = serie;
        this.fallaDetalle = fallaDetalle;
        this.idTipoProblema = TblStatus.buscarxClave(idTipoProblema);
        this.fecEnvio = java.sql.Date.valueOf(fecEnvio);
        this.fecRetorno = java.sql.Date.valueOf(fecRetorno);
        this.observaciones = observaciones;
        this.fecInitramite = java.sql.Date.valueOf(fecInitramite);
        this.ro = ro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idFolio);
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
        final BitaReparacion other = (BitaReparacion) obj;
        return Objects.equals(this.idFolio, other.idFolio);
    }

    public Integer getIdFolio() { return this.idFolio; }
    public void setIdFolio(Integer idFolio) { this.idFolio = idFolio; }
    public TblCedis getTblCedis() { return this.tblCedis;}
    public void setTblCedis(TblCedis tblCedis) { this.tblCedis = tblCedis; }
    public TblEmpleados getTblEmpleados() { return this.tblEmpleados; }
    public void setTblEmpleados(TblEmpleados tblEmpleados) { this.tblEmpleados = tblEmpleados; }
    public TblModelos getTblModelos() { return this.tblModelos; }
    public void setTblModelos(TblModelos tblModelos) { this.tblModelos = tblModelos; }
    public TblStatus getTblStatusByIdStatus() { return this.tblStatusByIdStatus; }
    public void setTblStatusByIdStatus(TblStatus tblStatusByIdStatus) {this.tblStatusByIdStatus = tblStatusByIdStatus;}
    public TblStatus getTblStatusByIdStatusActa() {return this.tblStatusByIdStatusActa;}
    public void setTblStatusByIdStatusActa(TblStatus tblStatusByIdStatusActa) {this.tblStatusByIdStatusActa = tblStatusByIdStatusActa; }
    public TblStatus getTblStatusByIdStatusDescuento() {return this.tblStatusByIdStatusDescuento; }
    public void setTblStatusByIdStatusDescuento(TblStatus tblStatusByIdStatusDescuento) {this.tblStatusByIdStatusDescuento = tblStatusByIdStatusDescuento;}
    public String getSerie() { return this.serie; }
    public void setSerie(String serie) { this.serie = serie;}
    public String getFallaDetalle() {return this.fallaDetalle;}
    public void setFallaDetalle(String fallaDetalle) {this.fallaDetalle = fallaDetalle;}
    public TblStatus getIdTipoProblema() {return this.idTipoProblema;}
    public void setIdTipoProblema(TblStatus idTipoProblema) {this.idTipoProblema = idTipoProblema;}
    public Date getFecEnvio() {return this.fecEnvio;}
    public void setFecEnvio(String fecEnvio) {this.fecEnvio = java.sql.Date.valueOf(fecEnvio);}
    public Date getFecRetorno() {return this.fecRetorno;}
    public void setFecRetorno(String fecRetorno) {this.fecRetorno = java.sql.Date.valueOf(fecRetorno);}
    public String getObservaciones() {return this.observaciones;}
    public void setObservaciones(String observaciones) {this.observaciones = observaciones;}
    public Date getFecInitramite() { return this.fecInitramite; }
    public void setFecInitramite(String fecInitramite) {this.fecInitramite = java.sql.Date.valueOf(fecInitramite);}
    public String getRo() { return this.ro;}
    public void setRo(String ro) { this.ro = ro; }

    public static List<BitaReparacion> selectAll() {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        List<BitaReparacion> lista = sesion.createCriteria(BitaReparacion.class).addOrder(Order.asc("idFolio")).list();
        sesion.getTransaction().commit();
        return lista;
    }

    public static List<BitaReparacion> selectAllP(Integer offset, Integer noOfRecords) {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        List<BitaReparacion> lista = sesion.createCriteria(BitaReparacion.class).setFirstResult(offset).setMaxResults(noOfRecords).list();
        sesion.getTransaction().commit();
        return lista;
    }

    public static BitaReparacion buscarxClave(Integer Id) {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        BitaReparacion b = sesion.get(BitaReparacion.class, Id);
        sesion.getTransaction().commit();
        return b;
    }

    public static List<BitaReparacion> buscarxStatus(Integer Id) {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        List<BitaReparacion> b = sesion.createQuery("from BitaReparacion b where b.tblStatusByIdStatus.idStatus=:criteria")
                .setParameter("criteria", Id)
                .list();
        sesion.getTransaction().commit();
        return b;
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

    public void update() {
        Session sesion = HibernateHelper.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        sesion.update(this);
        sesion.getTransaction().commit();
    }
}
