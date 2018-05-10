package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.TblPuestos;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org> */
@Namespace("/")
@ResultPath("/")
@Action(value = "CatalogoPuestos", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoPuestos.jsp")})
public class CatalogoPuestosAction extends ActionSupport implements Serializable, ServletRequestAware{
    
    private Integer puestoId;
    private String puestoNombre;
    private List<TblPuestos> listadePuestos;
    private TblPuestos puesto;
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) { this.request = request; }

    public Integer getPuestoId() { return puestoId; }

    public void setPuestoId(Integer puestoId) { this.puestoId = puestoId; }

    public String getPuestoNombre() { return puestoNombre; }

    public void setPuestoNombre(String puestoNombre) { this.puestoNombre = puestoNombre; }

    public List<TblPuestos> getListadePuestos() { return listadePuestos; }

    public void setListadePuestos(List<TblPuestos> listadePuestos) { this.listadePuestos = listadePuestos; }

    public TblPuestos getPuesto() { return puesto; }

    public void setPuesto(TblPuestos puesto) { this.puesto = puesto; }
    
    @Override
    public String execute(){
       listadePuestos=TblPuestos.selectAll();
       return SUCCESS;
    }
    
    @Action(value = "FrmEditPuesto", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmEditPuesto.jsp")})
    public String FrmEditPuesto(){       
        puesto=TblPuestos.buscarxClave(getPuestoId());
        return SUCCESS;
    }
    
    @Action(value = "UpdatePuesto", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoPuestos.action")})
    public String UpdatePuesto(){
        puesto=new TblPuestos();
        puesto.setPuestoId(getPuestoId());
        puesto.setPuestoNombre(getPuestoNombre());
        puesto.insert();        
        return "success";
    }
    
    @Action(value ="InsertPuesto", results = {@Result(name = SUCCESS, type = "redirect", location ="/CatalogoPuestos.action")})
    public String InsertPuesto(){
        puesto=new TblPuestos();        
        puesto.setPuestoNombre(getPuestoNombre());
        puesto.insert();        
        return "success";
    }
    
    @Action(value="DeletePuesto", results={@Result(name=SUCCESS, type="redirect", location="/CatalogoPuestos.action")})
    public String DeletePuesto(){
        puesto= TblPuestos.buscarxClave(getPuestoId());
        puesto.delete();
        return "success";
    }
    
}