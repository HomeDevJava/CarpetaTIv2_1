<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name="form" method="get" action="UpdateCedis.action" >    
    <div class="form-group">
        <label class="h5 font-weight-bold text-dark" for="cedId">Nombre:</label>
        <input name="cedId" type="text" value="${cedis.getCedId()}" class="form-control">
    </div>
    
    <div class="form-group">
        <label class="h5 font-weight-bold text-dark" for="cedNombre">Nombre:</label>
        <input name="cedNombre" type="text" value="${cedis.getCedNombre()}" class="form-control" placeholder="Introduce el nombre del cedis">
    </div>
    
    <div class="form-group">
        <label class="h5 font-weight-bold text-dark" for="cedUop">UOP:</label>
        <input name="cedUop" type="text" value="${cedis.getCedUop()}" class="form-control " placeholder="Introduce el numero de la Unidad operativa">
        <small class="form-text text-muted" >Ejemplo:360</small>
    </div>

    <div class="form-group">
        <label class="h5 font-weight-bold text-dark" for="cedDomicilio">Domicilio:</label>
        <input name="cedDomicilio" type="text" value="${cedis.getCedDomicilio()}" class="form-control " placeholder="Introduce la dirección">

    </div>

    <div class="modal-footer">
        <div class="form-group my-5">                    
            <button id="envio" type="submit" name="envio" class="btn btn-success btn-lg">
                <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> Aceptar
            </button> 
            <button id="envio" type="reset" name="envio" class="btn btn-warning btn-lg ">
                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Restablecer
            </button>                     
            <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoCedis.action'">
                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
            </button>
        </div>
    </div> 
</form>