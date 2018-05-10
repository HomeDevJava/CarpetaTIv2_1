<%-- 
    Document   : FrmInsertEmpleado
    Created on : 23-ene-2018, 11:35:02
    Author     : Nakura-gui <Jisashi.Nakamura at Nakcom.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Registro Marca</title>
    </head>
    <body>   
        <form name="form" method="get" action="InsertModelo.action" >

            <div class="modal-body">                            
                <div class="form-group">
                    <label class="h5 font-weight-bold text-dark" for="modNombre">#Nombre del Modelo:</label>
                    <input name="modNombre" type="text" class="form-control " placeholder="Introduce el nombre del modelo">
                    <small class="form-text text-muted" >Ejemplo:MC55A</small>
                </div>
                <div class="form-group">
                    <label class="h5 font-weight-bold text-dark" for="tblMarcas">#Marca:</label>
                    <s:select id="marcaId" name="marcaId" cssClass="form-control mr-sm-2" 
                              list="listadeMarcas" listKey="marcaId" listValue="marcaNombre" 
                              headerKey="0" headerValue="Seleccionar" value="0" />                    
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
                    <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoModelos.action'">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
                    </button>
                </div>
            </div> 
        </form>
    </body>
</html>