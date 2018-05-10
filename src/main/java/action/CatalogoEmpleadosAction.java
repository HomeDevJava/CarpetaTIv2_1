/**@author Nakura-gui <Jisashi.Nakamura at Nakcom.org> */
package action;
import model.TblEmpleados;
import model.TblPuestos;
import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

@Namespace("/")
@ResultPath("/")
@Action(value = "CatalogoEmpleados", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoEmpleados.jsp")})
public class CatalogoEmpleadosAction extends ActionSupport implements Serializable, ServletRequestAware{

    private static final long serialVersionUID = 1L;    
    private HttpServletRequest request;    
    private Integer empleadoId;    
    private TblPuestos tblPuestos;    
    private String empleadoNum, empleadoNombre, empleadoApellidos, empleadoEmail, empleadoTelefono, userName, userPsw;    
    private List<TblEmpleados> listadeEmpleados;
    private List<TblPuestos> listadePuestos;
    private TblEmpleados empleado;
    private Integer puestoId;
    

    public Integer getEmpleadoId() { return empleadoId; }

    public void setEmpleadoId(Integer empleadoId) { this.empleadoId = empleadoId; }

    public TblPuestos getTblPuestos() { return tblPuestos; }

    public void setTblPuestos(TblPuestos tblPuestos) { this.tblPuestos = tblPuestos; }

    public String getEmpleadoNum() { return empleadoNum; }

    public void setEmpleadoNum(String empleadoNum) { this.empleadoNum = empleadoNum; }

    public String getEmpleadoNombre() { return empleadoNombre; }

    public void setEmpleadoNombre(String empleadoNombre) { this.empleadoNombre = empleadoNombre; }

    public String getEmpleadoApellidos() { return empleadoApellidos; }

    public void setEmpleadoApellidos(String empleadoApellidos) { this.empleadoApellidos = empleadoApellidos; }

    public String getEmpleadoEmail() { return empleadoEmail; }

    public void setEmpleadoEmail(String empleadoEmail) { this.empleadoEmail = empleadoEmail; }

    public String getEmpleadoTelefono() { return empleadoTelefono; }

    public void setEmpleadoTelefono(String empleadoTelefono) { this.empleadoTelefono = empleadoTelefono; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPsw() { return userPsw; }

    public void setUserPsw(String userPsw) { this.userPsw = userPsw; }

    public List<TblEmpleados> getListadeEmpleados() { return listadeEmpleados; }

    public void setListadeEmpleados(List<TblEmpleados> listadeEmpleados) { this.listadeEmpleados = listadeEmpleados; }

    public List<TblPuestos> getListadePuestos() { return listadePuestos; }

    public void setListadePuestos(List<TblPuestos> listadePuestos) { this.listadePuestos = listadePuestos; }

    public Integer getPuestoId() { return puestoId; }

    public void setPuestoId(Integer puestoId) { this.puestoId = puestoId; }

    public TblEmpleados getEmpleado() { return empleado; }

    public void setEmpleado(TblEmpleados empleado) { this.empleado = empleado; }
       
    @Override
    public void setServletRequest(HttpServletRequest request) { this.request=request; }
    
    @Override
    public String execute(){
        setListadeEmpleados(TblEmpleados.selectAll());
        setListadePuestos(TblPuestos.selectAll());
        return SUCCESS;
    }
  
    @Action(value = "FiltrarEmpleados", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoEmpleados.jsp")})
    public String FiltrarEmpleados(){
        Integer r_puestoId=getPuestoId();
        Iterator<TblEmpleados> temp= TblEmpleados.selectAll().iterator();
        listadeEmpleados= new ArrayList<>();
        if(r_puestoId !=0){            
            temp.forEachRemaining(new Consumer<TblEmpleados>() {
                @Override
                public void accept(TblEmpleados t) {
                    if(Objects.equals(t.getTblPuestos().getPuestoId(), r_puestoId)){
                        listadeEmpleados.add(t);
                    }
                }
            });
            setListadePuestos(TblPuestos.selectAll());
            return SUCCESS;
        }else{
            setListadeEmpleados(TblEmpleados.selectAll());
            setListadePuestos(TblPuestos.selectAll());
            return SUCCESS;            
        }        
    }
    
    @Action(value = "FiltrarEmpleados2", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/CatalogoEmpleados.jsp")})
    public String FiltrarEmpleados2(){
        Integer r_puestoId=getPuestoId();        
        if(r_puestoId !=0){            
            setListadeEmpleados(TblEmpleados.selectxPuesto(r_puestoId));
            setListadePuestos(TblPuestos.selectAll());
            return SUCCESS;
        }else{
            setListadeEmpleados(TblEmpleados.selectAll());
            setListadePuestos(TblPuestos.selectAll());
            return SUCCESS;            
        }        
    }
    
    @Action(value = "DeleteEmpleado", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoEmpleados.action")})
    public String DeleteEmpleado(){
        empleado=TblEmpleados.buscarxClave(getEmpleadoId());
        empleado.delete();
        return SUCCESS;
    }
    
    @Action(value = "FrmEditEmpleado", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmEditEmpleado.jsp")})
    public String FrmEditEmpleado(){
        //Integer Id=Integer.parseInt(request.getParameter("empleadoId"));
        empleado=TblEmpleados.buscarxClave(getEmpleadoId());
        listadePuestos=TblPuestos.selectAll();
        return SUCCESS;
    }
    
    @Action(value = "UpdateEmpleado", results = {@Result(name = SUCCESS, type = "redirect", location ="/CatalogoEmpleados.action")})
    public String UpdateEmpleado(){
        tblPuestos=TblPuestos.buscarxClave(getPuestoId());
        empleado= new TblEmpleados(tblPuestos, getEmpleadoNum(), getEmpleadoNombre(), getEmpleadoApellidos(), 
                getEmpleadoEmail(), getEmpleadoTelefono(), getUserName(), getUserPsw(), null, null);
        empleado.setEmpleadoId(getEmpleadoId());
        empleado.insert();
        return SUCCESS;
    }
    
    @Action(value = "FrmInsertEmpleado", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmInsertEmpleado.jsp")})
    public String FrmInsertEmpleado(){
        listadePuestos=TblPuestos.selectAll();
        return SUCCESS;
    }
    
    @Action(value = "InsertEmpleado", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoEmpleados.action")})
    public String InsertEmpleado(){
        tblPuestos=TblPuestos.buscarxClave(getPuestoId());
        empleado= new TblEmpleados(tblPuestos, getEmpleadoNum(), getEmpleadoNombre(), getEmpleadoApellidos(), 
                getEmpleadoEmail(), getEmpleadoTelefono(), getUserName(), getUserPsw(), null, null);        
        empleado.insert();
        return SUCCESS;
    }
}