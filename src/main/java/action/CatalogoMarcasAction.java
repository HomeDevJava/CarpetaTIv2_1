package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.TblMarcas;
import org.apache.struts2.convention.annotation.*;


@Namespace("/")
@ResultPath(value = "/")
@Action(value = "CatalogoMarcas", results = {
        @Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoMarcas.jsp")})
public class CatalogoMarcasAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private Integer marcaId;
    private String marcaNombre;
    private List<TblMarcas> listadeMarcas;
    private TblMarcas marca;

    public List<TblMarcas> getListadeMarcas() {
        return listadeMarcas;
    }

    public void setListadeMarcas(List<TblMarcas> listadeMarcas) {
        this.listadeMarcas = listadeMarcas;
    }

    public TblMarcas getMarca() {
        return marca;
    }

    public void setMarca(TblMarcas Marca) {
        this.marca = Marca;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }
 
    public String getMarcaNombre() {
        return marcaNombre;
    }

    public void setMarcaNombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }

    @Action(value = "FrmEditMarca", results = {
        @Result(name = "FrmEditMarca",type = "dispatcher", location = "/FrmEditMarca.jsp")})
    public String FrmEditMarca() {
        marca = TblMarcas.buscarxClave(getMarcaId());
        return "FrmEditMarca";
    }

    @Action(value = "UpdateMarca", results = {
        @Result(name = SUCCESS, type = "redirect", location = "/CatalogoMarcas.action")})
   
    public String UpdateMarca() {
        marca = new TblMarcas();
        marca.setMarcaId(getMarcaId());
        marca.setMarcaNombre(getMarcaNombre());
        marca.insert();
        return "success";
    }

    @Action(value = "DeleteMarca", results = {
        @Result(name = SUCCESS, type = "redirect", location = "/CatalogoMarcas.action")})
    public String DeleteMarca() {
        marca = TblMarcas.buscarxClave(getMarcaId());
        marca.delete();
        return "success";
    }

    @Action(value = "InsertMarca", results = {
        @Result(name = SUCCESS, type = "redirect", location = "/CatalogoMarcas.action")
    })
    public String InsertMarca() {
        marca = new TblMarcas(getMarcaNombre());
        marca.insert();
        return "success";
    }

    
    @Override
    public String execute() {
        listadeMarcas = TblMarcas.selectAll();
        return "success";
    }
//
//    @Override
//    public void validate(){
//        if(getMarcaNombre().length()!=0 && !getMarcaNombre().equals("")){
//        } else {
//            addFieldError("MarcaNombre", "El valor no puede ser nulo");
//        }
//    }
}
