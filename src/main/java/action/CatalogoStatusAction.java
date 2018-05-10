package action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import model.TblStatus;
import org.apache.struts2.convention.annotation.*;

/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org>*/
public class CatalogoStatusAction extends ActionSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idStatus;
    @Valid
    private String descripcion;

    private List<TblStatus> listadeStatus;
    private TblStatus status;

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<TblStatus> getListadeStatus() {
        return listadeStatus;
    }

    public void setListadeStatus(List<TblStatus> listadeStatus) {
        this.listadeStatus = listadeStatus;
    }

    
    public TblStatus getStatus() {
        return status;
    }

    public void setStatus(TblStatus status) {
        this.status = status;
    }

    @Action(value = "CatalogoStatus", results = {@Result(name = "success", location = "/CatalogoStatus.jsp")})
    @Override
    public String execute() {
        listadeStatus = TblStatus.selectAll();
        return "success";
    }

    @Action(value = "FrmEditStatus", results = {
        @Result(name = "success", location = "/FrmEditStatus.jsp", type = "dispatcher"),
    })
    public String FrmEditStatus() {
        status = TblStatus.buscarxClave(getIdStatus());
        return "success";
    }

    @Action(value = "DeleteStatus", results = {@Result(name = "DeleteStatus", location = "/CatalogoStatus.action", type = "redirect")})
    public String DeleteStatus() {
        status = TblStatus.buscarxClave(getIdStatus());
        status.delete();
        return "DeleteStatus";
    }

    @Action(value = "InsertStatus", results = {
        @Result(name = "InsertStatus", location = "/CatalogoStatus.action", type = "redirect")})
    public String InsertStatus() {
        status = new TblStatus(getDescripcion());
        status.insert();
        return "InsertStatus";
    }

    @Action(value = "UpdateStatus", results = {
        @Result(name = "success", location = "/CatalogoStatus.action", type = "redirect")})
    public String UpdateStatus() {       
            status = TblStatus.buscarxClave(getIdStatus());
            status.setDescripcion(getDescripcion());
            status.insert();
            return "success";        
    }
}
