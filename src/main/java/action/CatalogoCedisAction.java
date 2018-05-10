package action;

import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.TblCedis;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org> */
@Namespace("/")
@ResultPath("/")
@Action(value = "CatalogoCedis", results = {@Result(name=SUCCESS, type="dispatcher", location="/CatalogoCedis.jsp")})
public class CatalogoCedisAction extends ActionSupport implements Serializable, ServletRequestAware{

    private static final long serialVersionUID = 1L;
    
    private Integer cedId;
    private String cedNombre;
    private Integer cedUop;
    private String cedDomicilio;
    private TblCedis cedis;
    private List<TblCedis> listadeCedis;
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) { this.request=request; }

    public Integer getCedId() { return cedId; }

    public void setCedId(Integer cedId) { this.cedId = cedId; }

    public String getCedNombre() { return cedNombre; }

    public void setCedNombre(String cedNombre) { this.cedNombre = cedNombre; }

    public Integer getCedUop() { return cedUop; }

    public void setCedUop(Integer cedUop) { this.cedUop = cedUop; }

    public String getCedDomicilio() { return cedDomicilio; }

    public void setCedDomicilio(String cedDomicilio) { this.cedDomicilio = cedDomicilio; }

    public TblCedis getCedis() { return cedis; }

    public void setCedis(TblCedis cedis) { this.cedis = cedis; }

    public List<TblCedis> getListadeCedis() { return listadeCedis; }

    public void setListadeCedis(List<TblCedis> listadeCedis) { this.listadeCedis = listadeCedis; }

    @Override
    public String execute(){
        listadeCedis=TblCedis.selectAll();
        return SUCCESS;
    }
    
    @Action(value="FrmEditCedis", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmEditCedis.jsp")})
    public String FrmEditCedis(){
        cedis= TblCedis.buscarxClave(getCedId());
        return SUCCESS;
    }
    
    @Action(value="UpdateCedis", results={@Result(name = SUCCESS, type="redirect", location = "/CatalogoCedis.action")})
    public String UpdateCedis(){
        cedis= new TblCedis(getCedNombre(), getCedUop(), getCedDomicilio(), null, null); 
        cedis.setCedId(getCedId());
        cedis.insert();
        return SUCCESS;
    }
    
    @Action(value="InsertCedis", results={@Result(name = SUCCESS, type="redirect", location = "/CatalogoCedis.action")})
    public String InsertCedis(){
        cedis= new TblCedis(getCedNombre(), getCedUop(), getCedDomicilio(), null, null);        
        cedis.insert();
        return SUCCESS;
    }
    
    @Action(value="DeleteCedis", results={@Result(name = SUCCESS, type="redirect", location = "/CatalogoCedis.action")})
    public String DeleteCedis(){
        cedis= TblCedis.buscarxClave(getCedId());        
        cedis.delete();
        return SUCCESS;
    }
}