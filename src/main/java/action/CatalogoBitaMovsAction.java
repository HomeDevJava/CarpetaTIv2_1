package action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.*;
import org.apache.struts2.convention.annotation.*;

/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org> */
public class CatalogoBitaMovsAction extends ActionSupport{
    
    private List<TblBitaMov> listadeBitaMovs=TblBitaMov.selectAll();
    private List<TblCedis> listadeCedis=TblCedis.selectAll();
    private List<TblEmpleados> listadeEmpleados=TblEmpleados.selectAll();
    private List<TblModelos> listadeModelos=TblModelos.selectAll();
    private Integer Id;

    public List<TblBitaMov> getListadeBitaMovs() { return listadeBitaMovs; }
    public void setListadeBitaMovs(List<TblBitaMov> listadeBitaMovs) { this.listadeBitaMovs = listadeBitaMovs; }
    public List<TblCedis> getListadeCedis() { return listadeCedis;}
    public void setListadeCedis(List<TblCedis> listadeCedis) { this.listadeCedis = listadeCedis; }
    public List<TblEmpleados> getListadeEmpleados() { return listadeEmpleados; }
    public void setListadeEmpleados(List<TblEmpleados> listadeEmpleados) { this.listadeEmpleados = listadeEmpleados; }
    public List<TblModelos> getListadeModelos() { return listadeModelos; }
    public void setListadeModelos(List<TblModelos> listadeModelos) { this.listadeModelos = listadeModelos; }
    public Integer getId() { return Id; }
    public void setId(Integer Id) { this.Id = Id; }
    
    @Action(value = "CatalogoBitaMovs", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoBitaMov.jsp")})
    @Override
    public String execute(){
        return SUCCESS;        
    }
    
}
