package action;

import model.TblModelos;
import model.TblMarcas;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.List;
import org.apache.struts2.convention.annotation.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org>*/
@Namespace("/")
@ResultPath("/")
@Action(value = "CatalogoModelos", results = {
    @Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoModelos.jsp")})
public class CatalogoModelosAction extends ActionSupport implements Serializable,ServletRequestAware {

    private static final long serialVersionUID = 1L;
    
    private Integer modId;
    private String modNombre;
    private TblMarcas tblMarcas;
    private List<TblModelos> listadeModelos;
    private List<TblMarcas> listadeMarcas;
    private HttpServletRequest request;    
    private Integer marcaId;
    private TblModelos modelo;

    public Integer getMarcaId() {return marcaId;}

    public void setMarcaId(Integer marcaId) {this.marcaId = marcaId;}
    
    public Integer getModId() {return modId;}

    public void setModId(Integer modId) {this.modId = modId;}

    public String getModNombre() {return modNombre;}

    public void setModNombre(String modNombre) {this.modNombre = modNombre;}

    public TblMarcas getTblMarcas() { return tblMarcas; }

    public void setTblMarcas(TblMarcas tblMarcas) { this.tblMarcas = tblMarcas; }

    public List<TblModelos> getListadeModelos() { return listadeModelos; }

    public void setListadeModelos(List<TblModelos> listadeModelos) { this.listadeModelos = listadeModelos; }

    public List<TblMarcas> getListadeMarcas() { return listadeMarcas; }

    public void setListadeMarcas(List<TblMarcas> listadeMarcas) {this.listadeMarcas = listadeMarcas;}

    public TblModelos getModelo() { return modelo; }

    public void setModelo(TblModelos modelo) { this.modelo = modelo; }

    @Override
    public void setServletRequest(HttpServletRequest request) { this.request = request; }

    @Action(value = "FiltrarModelos", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoModelos.jsp")})
    public String FiltrarModelos() {
        //HttpServletRequest request=ServletActionContext.getRequest();
        //ServletContext context=ServletActionContext.getServletContext();//        
        Integer r_marcas =getMarcaId();// Integer.parseInt(request.getParameter("marcas"));
        
        if (r_marcas != 0) {
            listadeModelos = TblModelos.buscarxMarcas(r_marcas);
            listadeMarcas = TblMarcas.selectAll();
            return "success";
        } else {
            listadeModelos = TblModelos.selectAll();
            listadeMarcas = TblMarcas.selectAll();
            return "success";
        }
    }

    @Action(value = "FrmInsertModelo", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmInsertModelo.jsp")})
    public String FrmInsertModelo(){        
        listadeMarcas=TblMarcas.selectAll();        
        return "success";
    }
    
    @Action(value = "FrmEditModelo", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmEditModelo.jsp")})
    public String FrmEditModelo(){
        modelo=TblModelos.buscarxClave(getModId());
        listadeMarcas=TblMarcas.selectAll();        
        return "success";
    }
    
    @Action(value = "InsertModelo", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoModelos.action")})
    public String InsertModelo(){         
        TblMarcas marca= new TblMarcas();
        marca.setMarcaId(getMarcaId());        
        modelo= new TblModelos(marca, getModNombre(), null, null);
        modelo.insert();
        return "success";
    }
    
    @Action(value = "DeleteModelo", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoModelos.action")})
    public String DeleteModelo(){
        modelo= TblModelos.buscarxClave(getModId());
        modelo.delete();
        return "success";
    }
        
    @Action(value = "UpdateModelo", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoModelos.action")})
    public String UpdateModelo(){
        TblMarcas marca= TblMarcas.buscarxClave(getMarcaId());
        modelo= new TblModelos(marca, getModNombre(), null, null);
        modelo.setModId(getModId());
        modelo.insert();
        return "success";        
    }
    
    @Override
    public String execute() {
        listadeModelos = TblModelos.selectAll();
        listadeMarcas = TblMarcas.selectAll();
        return "success";
    }

}