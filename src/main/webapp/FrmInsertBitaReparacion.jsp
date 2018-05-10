<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<div class="modal-header bg-primary">
    <h4 class="text-white">Registro Nuevo</h4>
    <button type="button" class="close" data-dismiss="modal">&times;</button>       
</div>
<div class="modal-body bg-muted" id="detail">
    <s:form action="InsertBitaReparacion" class="modal-body">
       
            <s:textfield name="idFolio" type="hidden" />

            <s:label for="serie" class="h5 font-weight-bold text-dark" value="Serie"/>
            <s:textfield name="serie"  cssClass="form-control"  required="true"/>                        

            <s:label for="tblModelos"  class="h5 font-weight-bold text-dark" value="Modelos"/>
            <s:select name="tblModelos" cssClass="form-control mr-sm-2" 
                      list="listadeModelos" listKey="ModId" listValue="ModNombre"  />

            <s:label for="tblCedis"  class="h5 font-weight-bold text-dark" value="Cedis"/>
            <s:select name="tblCedis" cssClass="form-control mr-sm-2"  
                      list="listadeCedis" listKey="cedId" listValue="cedNombre"/>

            <s:label for="tblEmpleados"  class="h5 font-weight-bold text-dark" value="Empleado"/>
            <s:select name="tblEmpleados" cssClass="form-control mr-sm-2" 
                      list="listadeEmpleados" listKey="empleadoId" listValue="empleadoNombre + ' ' + empleadoApellidos"
                      value="bitaReparacion.getTblEmpleados().getEmpleadoId()" headerValue="bitaReparacion.getTblEmpleados().getEmpleadoNombre() +' '+ bitaReparacion.getTblEmpleados().getEmpleadoApellidos()"/>  

            <s:label for="tblStatusByIdStatus"  class="h5 font-weight-bold text-dark" value="Status"/>
            <s:select name="tblStatusByIdStatus" cssClass="form-control mr-sm-2" 
                      list="listadeStatus" listKey="idStatus" listValue="descripcion"
                      value="bitaReparacion.getTblStatusByIdStatus().getIdStatus()" headerValue="bitaReparacion.getTblStatusByIdStatus().getDescripcion()"/>             

            <s:label for="ro"  class="h5 font-weight-bold text-dark" value="RO"/>
            <s:textfield name="ro" cssClass="form-control"  />            

            <s:label for="idTipoProblema"  class="h5 font-weight-bold text-dark" value="Tipo problema"/>
            <s:select name="idTipoProblema" cssClass="form-control mr-sm-2" 
                      list="listadeStatus" listKey="idStatus" listValue="descripcion"
                      value="bitaReparacion.getIdTipoProblema().getIdStatus()" headerValue="bitaReparacion.getIdTipoProblema().getDescripcion()"/>                                                  

            <s:label for="tblStatusByIdStatusActa"  class="h5 font-weight-bold text-dark" value="Acta Admva"/>
            <s:select name="tblStatusByIdStatusActa" cssClass="form-control mr-sm-2" 
                      list="listadeStatus" listKey="idStatus" listValue="descripcion"
                      value="bitaReparacion.getTblStatusByIdStatusActa().getIdStatus()" headerValue="bitaReparacion.getTblStatusByIdStatusActa().getDescripcion()"/>                                                    

            <s:label for="tblStatusByIdStatusDescuento"  class="h5 font-weight-bold text-dark" value="Descuento"/>
            <s:select name="tblStatusByIdStatusDescuento" cssClass="form-control mr-sm-2" 
                      list="listadeStatus" listKey="idStatus" listValue="descripcion"
                      value="bitaReparacion.getTblStatusByIdStatusDescuento().getIdStatus()" headerValue="bitaReparacion.getTblStatusByIdStatusDescuento().getDescripcion()"/>                                                     

            <s:label for="fecInitramite"  class="h5 font-weight-bold text-dark" value="Fecha de tramite"/>
            <s:textfield name="fecInitramite" class="form-control col-lg-12" type="date"  format="yyyy-MM-dd" value="%{t}" required="true"/>

            <s:label for="fecEnvio"  class="h5 font-weight-bold text-dark" value="Fecha de Envio"/> 
            <s:textfield name="fecEnvio" class="form-control col-lg-12" type="date"  format="yyyy-MM-dd" value="%{t}"/>

            <s:label for="fecRetorno"  class="h5 font-weight-bold text-dark" value="Fecha de Retorno"/>            
            <s:textfield id="fecRetorno" name="fecRetorno" class="form-control col-lg-12" format="yyyy-MM-dd" type="date" value="2000-01-01" />

            <s:label for="observaciones"  class="h5 font-weight-bold text-dark" value="Observaciones"/>
            <s:textarea name="observaciones" cssClass="form-control col-lg-12"  />            

            <s:label for="fallaDetalle"  class="h5 font-weight-bold text-dark" value="Falla"/>
            <s:textarea name="fallaDetalle" cssClass="form-control" cols="45" required="true" />             

            <br>
            <s:submit id="envio" type="submit" name="envio" class="btn btn-success btn-md my-4 clearfix float-right" />
       
    </s:form>
</div>