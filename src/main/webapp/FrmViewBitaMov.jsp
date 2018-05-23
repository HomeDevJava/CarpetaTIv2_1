<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="formInsert" name="form" method="get" class="needs-validation" novalidate >
    <s:push value="registro">
        <div class="modal-body form-inline">

            <div class="form-group col-4 my-2">
                <label class="h5 font-weight-bold text-dark date">Fecha</label>
                <s:date format="yyyy-MM-dd" name="registro.getBitmovaFecha()" var="fenvio" />  
                <s:textfield name="bitmovaFecha" class="form-control col-lg-12 is-valid" type="date" format="yyyy-MM-dd" value="%{fenvio}" readonly="true"/>
                <div class="invalid-tooltip">
                    Es necesario la fecha de envio.
                </div>
            </div>

            <div class="form-group col-4 my-2">
                <s:label class="h5 font-weight-bold text-dark" for="bitmovaOrigenId" value="Cedis Origen"/>
                <s:select name="bitmovaOrigenId" cssClass="form-control mr-sm-2" 
                          list="listadeCedis" listKey="cedId" listValue="cedNombre"
                          value="registro.getBitmovaOrigenId().getCedId()" headerValue="registro.getBitmovaOrigenId().getCedNombre()"
                          readonly="true"/>
            </div>

            <div class="form-group col-4 my-2">
                <s:label class="h5 font-weight-bold text-dark" for="tblCedis" value="Cedis Destino"/>
                <s:select name="bitmovaDestinoId" cssClass="form-control mr-sm-2" 
                          list="listadeCedis" listKey="cedId" listValue="cedNombre"
                          value="registro.getBitmovaDestinoId().getCedId()" headerValue="registro.getBitmovaDestinoId().getCedNombre()"
                          readonly="true"/>
            </div>

            <div class="form-group col-4 my-2">
                <s:label class="h5 font-weight-bold text-dark" for="bitmovaActivo" value="Activo Fijo"/>
                <s:textfield name="bitmovaActivo" class="form-control" readonly="true"/>            
                <div class="invalid-tooltip">
                    Falta el Activo del Equipo.
                </div>
            </div> 

            <div class="form-group col-4 my-2" >
                <s:label class="h5 font-weight-bold text-dark" for="tblModelos" value="Modelo"/>
                <s:select name="tblModelos" cssClass="form-control mr-sm-2" 
                          list="listadeModelos" listKey="modId" listValue="modNombre"
                          value="registro.getTblModelos().getModId()" headerValue="registro.getTblModelos().getModNombre()"
                          readonly="true"/>                                       
            </div>

            <div class="form-group col-4 my-2">
                <s:label class="h5 font-weight-bold text-dark" for="tblEmpleados" value="Enviado a"/>
                <s:select name="bitmovaIdEmpleado" cssClass="form-control mr-sm-2" 
                          list="listadeEmpleados" listKey="empleadoId" listValue="empleadoNombre + ' ' + empleadoApellidos"
                          value="registro.getBitmovaIdEmpleado().getEmpleadoId()" headerValue="registro.getBitmovaIdEmpleado().getEmpleadoNombre()"/>                                        
                </select> 
            </div>


            <div class="form-group col-4 my-2" id="Seriediv">
                <s:label class="h5 font-weight-bold text-dark" for="bitmovaMotivo" value="Motivo"/>
                <s:textfield name="bitmovaMotivo" class="form-control" readonly="true"/>            
                <div class="invalid-tooltip">
                    Por favor escribe la Serie del Equipo.
                </div>
            </div> 

            <div class="form-group col-4">
                <s:label class="h5 font-weight-bold text-dark" for="bitmovaCaracteristica" value="Caracteristicas"/>
                <s:textfield name="bitmovaCaracteristica" class="form-control" readonly="true"/> 
            </div>

            <div class="form-group col-4">
                <s:label class="h5 font-weight-bold text-dark" for="bitmovaObservaciones" value="Observaciones"/>
                <s:textfield name="bitmovaObservaciones" class="form-control" readonly="true"/> 
            </div>

            <div class="form-group col-8 my-2" id="Seriediv">
                <s:label class="h5 font-weight-bold text-dark" for="bitmovaSerie" value="Serie(s)"/>            
                <s:textarea name="bitmovaSerie" class="form-control col-lg-12 is-valid" readonly="true"/>            
                <div class="invalid-tooltip">
                    Por favor escribe la Serie del Equipo.
                </div>
            </div> 

            <div class="modal-footer">
                <div class="form-group my-2">                                   
                    <button type="button" class="btn btn-danger btn-md mx-sm-2" onclick="window.location.href = 'CatalogoBitaMov.Action'">
                        <span class="fa fa-eject" aria-hidden="true"></span> Cancelar
                    </button>
                </div>
            </div> 
        </div>
    </s:push>
</form>