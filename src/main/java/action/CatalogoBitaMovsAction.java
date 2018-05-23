package action;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;


import model.*;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

/**
 *
 * @author Nakura-gui <Jisashi.Nakamura at Nakcom.org>
 * @param <T>
 */

@Namespace("/")
@ResultPath("/")
public class CatalogoBitaMovsAction<T> extends ActionSupport implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private List<TblBitaMov> listadeBitaMovs=TblBitaMov.selectAll();
    private List<TblCedis> listadeCedis=TblCedis.selectAll();
    private List<TblEmpleados> listadeEmpleados=TblEmpleados.selectAll();
    private List<TblModelos> listadeModelos=TblModelos.selectAll();
    private TblBitaMov tblbitamov= new TblBitaMov();
    private Integer Id;
    private Map<String, Object> request;
    
    
    
    public TblBitaMov getTblbitamov() { return tblbitamov; }
    public void setTblbitamov(TblBitaMov tblbitamov) { this.tblbitamov = tblbitamov; }    
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
    
    @Action(value = "CatalogoBitaMovs", results = {@Result(name =SUCCESS, type = "dispatcher", location = "/CatalogoBitaMov.jsp")})
    @Override
    public String execute(){
        return SUCCESS;        
    }
    
    @Action(value = "UpdateBitaMov", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoBitaMovs.action")})    
    public String UpdateBitaMov() throws Exception{
         
       ActionContext a= ActionContext.getContext();
       ValueStack stack=ActionContext.getContext().getValueStack();       
       stack.getContext();       
       HttpParameters p=a.getParameters();
       
       p.values().forEach((parameter) -> {
           System.out.println("\nname::"+parameter.getName()+"   valor::"+parameter.getValue());
        }); //System.out.println("pruebita::"+a.getParameters().get("tblCedis"));
 
        tblbitamov=(TblBitaMov) getRegistro(TblBitaMov.class, ActionContext.getContext().getParameters().values());
        System.out.println("mundo:: "+tblbitamov.getBitmovaObservaciones());
        return SUCCESS;
        
    }
    
    @Action(value = "FrmEditBitaMov", results = {@Result(name=SUCCESS, type = "dispatcher", location = "/FrmEditBitaMov.jsp")})
    public String FrmEditBitaMov(){
        listadeBitaMovs.stream().filter(b->(Objects.equals(b.getBitmovaFolio(), Id))).forEachOrdered(t -> setTblbitamov(t));
        
//        ValueStack stack=ActionContext.getContext().getValueStack();
//        stack.push(registro);
        //System.out.println("registro::"+registro.getBitmovaFolio());
        return SUCCESS;
    }
    
    @Action(value = "FrmViewBitaMov", results = {@Result(name=SUCCESS, type = "dispatcher", location = "/FrmViewBitaMov.jsp")})
    public String FrmViewBitaMov(){
        listadeBitaMovs.stream().filter(b->(Objects.equals(b.getBitmovaFolio(), Id))).forEachOrdered(b-> setTblbitamov(b));       
        return SUCCESS;
    }


    private T getRegistro(Class clase, Collection<Parameter> p) throws Exception{        
        T objeto=(T) Class.forName(clase.getName()).newInstance();
        Method[] metodos=objeto.getClass().getDeclaredMethods();
        for(Parameter parameter:p){
            for(int i=0; i<metodos.length; i++){                
                if(metodos[i].getName().startsWith("set")){
                    Class<?>[] parama = metodos[i].getParameterTypes();
                    String primeraletra=metodos[i].getName().substring(3,4).toLowerCase();
                    String prop= primeraletra+metodos[i].getName().substring(4, metodos[i].getName().length());
                    if(prop.equals(parameter.getName()) && !parama[0].getCanonicalName().startsWith("model")){
                        System.out.println("metodo: "+metodos[i].getName()+" request: "+parameter.getName());
                        System.out.println("tipo del metodo: "+parama[0].getCanonicalName());
                        if(parama[0].getCanonicalName().equals("java.lang.String")){
                            metodos[i].invoke(objeto, parameter.getValue());
                        }else if(parama[0].getCanonicalName().equals("java.lang.Integer")){
                            metodos[i].invoke(objeto, Integer.parseInt(parameter.getValue()));
                        }                        
                    }              
                }
            }
        }
        return  objeto;
    }
        
}


