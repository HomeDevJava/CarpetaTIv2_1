<%-- 
    Document   : FrmInsertEmpleado
    Created on : 23-ene-2018, 11:35:02
    Author     : Nakura-gui <Jisashi.Nakamura at Nakcom.org>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Registro Marca</title>
    </head>
    <body>            

        <form name="form" method="get" action="UpdatePuesto.action" class="border border-secondary rounded bg-light py-2 my-5">                        
            <div class="modal-body"> 
                <div class="form-group">
                    <label class="h5 font-weight-bold text-dark" for="puestoId">Puesto Id:</label>                    
                    <s:textfield cssClass="form-control" name="puestoId" value="%{puesto.puestoId}" />
                    
                </div>

                <div class="form-group">
                    <label class="h5 font-weight-bold text-dark" for="puestoNombre">Nombre:</label>
                    <s:textfield cssClass="form-control" name="puestoNombre" value="%{puesto.puestoNombre}" />
                </div>  
            </div>

            <div class="modal-footer">
                <div class="form-group my-5">                    
                    <button id="envio" type="submit" name="envio" class="btn btn-success btn-lg">
                        <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> Aceptar
                    </button> 
                    <button id="envio" type="reset" name="envio" class="btn btn-warning btn-lg ">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Restablecer
                    </button>                     
                    <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoPuestos.action'">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
                    </button>
                </div>
            </div>

        </form>

    </body>
</html>
