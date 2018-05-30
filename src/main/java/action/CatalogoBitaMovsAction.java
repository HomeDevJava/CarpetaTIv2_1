package action;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
import javax.sql.rowset.serial.SerialBlob;
import model.*;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.*;

/**
 * 
 * @author Nakura-gui <Jisashi.Nakamura at Nakcom.org>
 * @param <T>
 */ 

@Namespace("/")
@ResultPath("/")
public class CatalogoBitaMovsAction<T> extends ActionSupport {
    
    private List<TblBitaMov> listadeBitaMovs=TblBitaMov.selectAll();
    private List<TblCedis> listadeCedis=TblCedis.selectAll();
    private List<TblEmpleados> listadeEmpleados=TblEmpleados.selectAll();
    private List<TblModelos> listadeModelos=TblModelos.selectAll();
    private TblBitaMov tblbitamov= new TblBitaMov();
    private Integer Id;
    private InputStream inputstream;
    private File archivo;
       
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
    public InputStream getInputstream() { return inputstream; }
    public void setInputstream(InputStream inputstream) { this.inputstream = inputstream; }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    @Action(value = "CatalogoBitaMovs", results = {@Result(name =SUCCESS, type = "dispatcher", location = "/CatalogoBitaMov.jsp")})
    @Override
    public String execute(){
        return SUCCESS;        
    }
    
    @Action(value = "UpdateBitaMov", results = {@Result(name = SUCCESS, type = "redirect", location = "/CatalogoBitaMovs.action")})    
    public String UpdateBitaMov() throws Exception{
       /*  
       ActionContext a= ActionContext.getContext();
       ValueStack stack=ActionContext.getContext().getValueStack();       
       stack.getContext();       
       HttpParameters p=a.getParameters();
       
       p.values().forEach((parameter) -> {
           System.out.println("\nname::"+parameter.getName()+"   valor::"+parameter.getValue());
        });*/ 
 
        tblbitamov=(TblBitaMov) new Utileria().getRegistro(TblBitaMov.class, ActionContext.getContext().getParameters().values());
        tblbitamov.insert();
        return SUCCESS;        
    }
    
    @Action(value = "InsertBitaMov", results = {@Result(name = SUCCESS, type = "redirectAction", location = "CatalogoBitaMovs.action")})
    public String InsertBitaMov(){
        try {
            tblbitamov= (TblBitaMov) new Utileria().getRegistro(TblBitaMov.class, ActionContext.getContext().getParameters().values());            
            tblbitamov.insert();
            return SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(CatalogoBitaMovsAction.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR;
        }
    }
    
    @Action(value = "FrmEditBitaMov", results = {@Result(name=SUCCESS, type = "dispatcher", location = "/FrmEditBitaMov.jsp")})
    public String FrmEditBitaMov(){
        listadeBitaMovs.stream().filter(b->(Objects.equals(b.getBitmovaFolio(), Id))).forEachOrdered(t -> setTblbitamov(t));
        
        //ValueStack stack=ActionContext.getContext().getValueStack();
        //stack.push(registro);
        //System.out.println("registro::"+registro.getBitmovaFolio());
        return SUCCESS;
    }
    
    @Action(value = "FrmViewBitaMov", results = {@Result(name=SUCCESS, type = "dispatcher", location = "/FrmViewBitaMov.jsp")})
    public String FrmViewBitaMov(){
        listadeBitaMovs.stream().filter(b->(Objects.equals(b.getBitmovaFolio(), Id))).forEachOrdered(b-> setTblbitamov(b)); 
        ValueStack stack=ActionContext.getContext().getValueStack();
        stack.push(tblbitamov);
        return SUCCESS;
    }
    
    
    @Action(value = "FrmInsertBitaMov", results = {@Result(name=SUCCESS, type = "dispatcher", location = "/FrmInsertBitaMov.jsp")})
    public String FrmInsertBitaMov(){        
        return SUCCESS;
    }
    
    @Action(value = "FrmViewPDFBitaMov",results = {@Result( name = SUCCESS, type = "stream",
            params = {
                "contentType", "application/pdf", 
                "inputName", "inputstream",
                //"contentLength", "2048"
            })
    })
    public String FrmViewPdfBitaMov() throws SQLException, IOException{
       
        tblbitamov=TblBitaMov.buscarxClave(Id);
        inputstream= tblbitamov.getBitamovaEvidencia().getBinaryStream();
        /*
         HttpServletResponse response=ServletActionContext.getResponse();
        byte[] data=tblbitamov.getBitamovaEvidencia().getBytes(1,(int)tblbitamov.getBitamovaEvidencia().length() );
        OutputStream out= response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
        */
        //BufferedInputStream bf= new BufferedInputStream(tblbitamov.getBitamovaEvidencia().getBinaryStream());
        //setInputstream(tblbitamov.getBitamovaEvidencia().getBinaryStream());
        return SUCCESS;
    }
    @Action(value = "FrmAddPDFBitaMov", results = {@Result(name = SUCCESS, type = "dispatcher", location = "/FrmAddPDFBitaMov.jsp")})
    public String FrmAddPDFBitaMov(){
        listadeBitaMovs.stream().filter(b->(Objects.equals(b.getBitmovaFolio(), Id))).forEachOrdered(b-> setTblbitamov(b)); 
        ValueStack stack=ActionContext.getContext().getValueStack();
        stack.push(tblbitamov);
        
        return SUCCESS;
    }
    
    @Action(value = "UploadPDFBitaMov", results = {@Result(name = SUCCESS, type = "redirectAction", location = "CatalogoBitaMovs.action")})
    public String UploadPDFBitaMov() throws FileNotFoundException, IOException, SQLException{
        //inputstream=new FileInputStream(archivo);
        tblbitamov= TblBitaMov.buscarxClave(Id);
        
        byte[] array= IOUtils.toByteArray(new FileInputStream(archivo));        
        //Blob b= new SerialBlob(array);
        tblbitamov.setBitamovaEvidencia(new SerialBlob(array));
        tblbitamov.insert();
        return SUCCESS;
    }

        
}
