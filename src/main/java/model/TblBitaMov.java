package model;
// Generated 09-mar-2018 12:34:10 by Hibernate Tools 4.3.1

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.Session;

/** * TblBitaMov generated by hbm2java */
@Entity
@Table(name = "tbl_BitaMov")
public class TblBitaMov implements java.io.Serializable, Crud {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Bitmova_Folio", unique = true, nullable = false)
    private Integer bitmovaFolio;
    
    @ManyToOne(targetEntity =TblCedis.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "Bitmova_DestinoId")
    private TblCedis tblCedis;
    
    @ManyToOne(targetEntity =TblEmpleados.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "Bitmova_EnvioIdEmpleado")
    private TblEmpleados tblEmpleados;
    
    @ManyToOne(targetEntity =TblModelos.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "Bitmova_ModeloId")
    private TblModelos tblModelos;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Bitmova_Fecha", length = 19)
    private Date bitmovaFecha;
    
    @ManyToOne(targetEntity = TblCedis.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "Bitmova_OrigenId")
    private TblCedis bitmovaOrigenId;
    
    @Column(name = "Bitmova_Activo")
    private String bitmovaActivo;
    @Column(name = "Bitmova_Serie")
    private String bitmovaSerie;
    @Column(name = "Bitmova_Motivo")
    private String bitmovaMotivo;
    @Column(name = "Bitmova_Caracteristica")
    private String bitmovaCaracteristica;
    @Column(name = "Bitmova_Observaciones")
    private String bitmovaObservaciones;
    @Column(name = "Bitamova_Evidencia")
    private Blob bitamovaEvidencia;

    public TblBitaMov() {
    }

    public TblBitaMov(TblCedis tblCedis, TblEmpleados tblEmpleados, TblModelos tblModelos, Date bitmovaFecha, TblCedis bitmovaOrigenId, String bitmovaActivo, String bitmovaSerie, String bitmovaMotivo, String bitmovaCaracteristica, String bitmovaObservaciones, Blob bitamovaEvidencia) {
        this.tblCedis = tblCedis;
        this.tblEmpleados = tblEmpleados;
        this.tblModelos = tblModelos;
        this.bitmovaFecha = bitmovaFecha;
        this.bitmovaOrigenId = bitmovaOrigenId;
        this.bitmovaActivo = bitmovaActivo;
        this.bitmovaSerie = bitmovaSerie;
        this.bitmovaMotivo = bitmovaMotivo;
        this.bitmovaCaracteristica = bitmovaCaracteristica;
        this.bitmovaObservaciones = bitmovaObservaciones;
        this.bitamovaEvidencia = bitamovaEvidencia;
    }

    public Integer getBitmovaFolio() { return this.bitmovaFolio; }
    public void setBitmovaFolio(Integer bitmovaFolio) {this.bitmovaFolio = bitmovaFolio;}
    public TblCedis getTblCedis() { return this.tblCedis; }
    public void setTblCedis(TblCedis tblCedis) { this.tblCedis = tblCedis; }
    public TblEmpleados getTblEmpleados() { return this.tblEmpleados; }
    public void setTblEmpleados(TblEmpleados tblEmpleados) { this.tblEmpleados = tblEmpleados; }
    public TblModelos getTblModelos() { return this.tblModelos; }
    public void setTblModelos(TblModelos tblModelos) { this.tblModelos = tblModelos; }
    public Date getBitmovaFecha() {  return this.bitmovaFecha; }
    public void setBitmovaFecha(Date bitmovaFecha) { this.bitmovaFecha = bitmovaFecha; }
    public TblCedis getBitmovaOrigenId() { return this.bitmovaOrigenId; }
    public void setBitmovaOrigenId(Integer bitmovaOrigenId) { this.bitmovaOrigenId = TblCedis.buscarxClave(bitmovaOrigenId); }
    public void setBitmovaOrigenId(TblCedis bitmovaOrigenId) { this.bitmovaOrigenId = bitmovaOrigenId; }
    public String getBitmovaActivo() { return this.bitmovaActivo; }
    public void setBitmovaActivo(String bitmovaActivo) { this.bitmovaActivo = bitmovaActivo; }
    public String getBitmovaSerie() { return this.bitmovaSerie; }
    public void setBitmovaSerie(String bitmovaSerie) { this.bitmovaSerie = bitmovaSerie; }
    public String getBitmovaMotivo() { return this.bitmovaMotivo; }
    public void setBitmovaMotivo(String bitmovaMotivo) { this.bitmovaMotivo = bitmovaMotivo; }
    public String getBitmovaCaracteristica() { return this.bitmovaCaracteristica; }
    public void setBitmovaCaracteristica(String bitmovaCaracteristica) { this.bitmovaCaracteristica = bitmovaCaracteristica; }
    public String getBitmovaObservaciones() { return this.bitmovaObservaciones; }
    public void setBitmovaObservaciones(String bitmovaObservaciones) { this.bitmovaObservaciones = bitmovaObservaciones; }
    public Blob getBitamovaEvidencia() {  return this.bitamovaEvidencia; }
    public void setBitamovaEvidencia(Blob bitamovaEvidencia) {  this.bitamovaEvidencia = bitamovaEvidencia; }
    
    public static List<TblBitaMov> selectAll(){
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        List<TblBitaMov> l=sesion.createQuery("from TblBitaMov t").getResultList();
        sesion.getTransaction().commit();
        return l;
    }
    
    public static TblBitaMov buscarxClave(Integer Id){
        Session sesion=HibernateHelper.getSessionFactory().openSession();
        sesion.beginTransaction();
        TblBitaMov l=sesion.get(TblBitaMov.class, Id);
        sesion.getTransaction().commit();
        return l;
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
