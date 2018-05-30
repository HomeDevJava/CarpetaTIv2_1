<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<form id="formInsert" name="form" method="post" action="UploadPDFBitaMov.action" enctype="multipart/form-data" class="needs-validation" >

    <div class="modal-header bg-primary text-white">
        <h4>Adjuntar Evidencia</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>       
    </div>
    
    <div class="modal-body ">

        <div class="form-group col my-2">
            <label class="h5 font-weight-bold text-dark" for="Bitmova_Folio" id="inlineFormInputGroup">Folio</label>
            <input id="Id" name="Id" class="form-control" type="text" value="${Id}" readonly>            
        </div>

        <div class="form-group col my-2">
            <label class="h5 font-weight-bold text-dark" for="Bitmova_Activo" id="inlineFormInputGroup">Evidencia</label>
            <input id="archivo" name="archivo" type="file" class="form-control" >
            <div class="invalid-tooltip">
                Falta el Archivo.
            </div>
        </div> 
    </div>

    <div class="modal-footer">
        <div class="form-group my-2">                    
            <button id="envio" type="submit" name="envio" class="btn btn-success btn-md mx-sm-2">
                <span class="fa fa-arrow-right" aria-hidden="true"></span> Aceptar
            </button> 
        </div>
    </div>
</form>