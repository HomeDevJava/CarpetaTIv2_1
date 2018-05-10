package action;

import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.BitaReparacion;
import model.TblCedis;
import model.TblEmpleados;
import model.TblModelos;
import model.TblStatus;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 * @author Nakura-gui <Jisashi.Nakamura at Nakcom.org>
 */
@Namespace("/")
@ResultPath("/")
public class CatalogoBitaReparacionAction extends ActionSupport implements ServletRequestAware {

    private List<BitaReparacion> listadeBitaReparacion;
    private List<TblModelos> listadeModelos = TblModelos.selectAll();
    private List<TblEmpleados> listadeEmpleados = TblEmpleados.selectAll();
    private List<TblStatus> listadeStatus = TblStatus.selectAll();
    private List<TblCedis> listadeCedis = TblCedis.selectAll();
    private BitaReparacion bitaReparacion = new BitaReparacion();
    private Integer Id;
    private HttpServletRequest request;
    private String t=java.sql.Date.valueOf(LocalDate.now()).toString();

    //GETTER Y SETTERS DE LAS PROPIEDADES
    public List<BitaReparacion> getListadeBitaReparacion() { return listadeBitaReparacion; }
    public void setListadeBitaReparacion(List<BitaReparacion> listadeBitaReparacion) {this.listadeBitaReparacion = listadeBitaReparacion;}
    public List<TblModelos> getListadeModelos() {return listadeModelos;}
    public void setListadeModelos(List<TblModelos> listadeModelos) {this.listadeModelos = listadeModelos; }
    public List<TblEmpleados> getListadeEmpleados() { return listadeEmpleados; }
    public void setListadeEmpleados(List<TblEmpleados> listadeEmpleados) {this.listadeEmpleados = listadeEmpleados;}
    public List<TblStatus> getListadeStatus() {return listadeStatus; }
    public void setListadeStatus(List<TblStatus> listadeStatus) {this.listadeStatus = listadeStatus; }
    public BitaReparacion getBitaReparacion() { return bitaReparacion; }
    public void setBitaReparacion(BitaReparacion bitaReparacion) { this.bitaReparacion = bitaReparacion; }
    public List<TblCedis> getListadeCedis() { return listadeCedis; }
    public void setListadeCedis(List<TblCedis> listadeCedis) { this.listadeCedis = listadeCedis;  }
    public Integer getId() { return Id; }
    public void setId(Integer Id) { this.Id = Id; }
    public String getT() { return t; }
    public void setT(String t) { this.t = t; }
    
    @Override
    @Action(value = "CatalogoBitaReparacion", results = {
        @Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoBitaReparacion.jsp")})
    public String execute() {
        listadeBitaReparacion = BitaReparacion.selectAll();
        return SUCCESS;
    }

    @Action(value = "FrmEditBitaReparacion", results = {
        @Result(name = SUCCESS, type = "dispatcher", location = "/FrmEditBitaReparacion.jsp")})
    public String FrmEditBitaReparacion() {
        setBitaReparacion(BitaReparacion.buscarxClave(getId()));
        return SUCCESS;
    }

    @Action(value = "UpdateBitaReparacion", results = {
        @Result(name = SUCCESS, type = "redirect", location = "/CatalogoBitaReparacion.action")})
    public String UpdateBitaReparacion() {
        BitaReparacion r = getRegistro();
        Integer folio = Integer.parseInt(request.getParameter("idFolio"));
        r.setIdFolio(folio);
        r.insert();
        return SUCCESS;
    }

    @Action(value = "FrmInsertBitaReparacion", results = {
        @Result(name = SUCCESS, type = "dispatcher", location = "/FrmInsertBitaReparacion.jsp")})
    public String FrmInsertBitaReparacion() {
        return SUCCESS;
    }

    @Action(value = "InsertBitaReparacion", results = {
        @Result(name = SUCCESS, type = "redirect", location = "/CatalogoBitaReparacion.action")})
    public String InsertBitaReparacion() {
        BitaReparacion registro = getRegistro();
        registro.insert();
        return SUCCESS;
    }
    
    @Action(value = "DeleteBitaReparacion", results = {
        @Result(name = SUCCESS, type = "redirect", location = "/CatalogoBitaReparacion.action")})
    public String DeleteBitaReparacion() {
        BitaReparacion registro = BitaReparacion.buscarxClave(getId());
        registro.delete();
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    private BitaReparacion getRegistro() {
        Integer ced = Integer.parseInt(request.getParameter("tblCedis"));
        Integer empl = Integer.parseInt(request.getParameter("tblEmpleados"));
        Integer mod = Integer.parseInt(request.getParameter("tblModelos"));
        Integer IdStatus = Integer.parseInt(request.getParameter("tblStatusByIdStatus"));
        Integer IdActa = Integer.parseInt(request.getParameter("tblStatusByIdStatusActa"));
        Integer IdDesc = Integer.parseInt(request.getParameter("tblStatusByIdStatusDescuento"));
        String sserie = request.getParameter("serie");
        String falla = request.getParameter("fallaDetalle");
        Integer Idtipo = Integer.parseInt(request.getParameter("idTipoProblema"));
        String fenvio = request.getParameter("fecEnvio");
        String fretorno = request.getParameter("fecRetorno");
        String finit = request.getParameter("fecInitramite");
        String obs = request.getParameter("observaciones");
        String ro = request.getParameter("ro");
        BitaReparacion reg = new BitaReparacion(ced, empl, mod, IdStatus, IdActa, IdDesc,
                sserie, falla, Idtipo, fenvio, fretorno, obs, finit, ro);
        return reg;
    }

}