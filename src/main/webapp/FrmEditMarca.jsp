<%-- 
    Document   : FrmInsertEmpleado
    Created on : 23-ene-2018, 11:35:02
    Author     : Nakura-gui <Jisashi.Nakamura at Nakcom.org>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando Registro Marca</title>
    </head>
    <body>            

        <form name="form" method="get" action="UpdateMarca.action" class="border border-secondary rounded bg-light py-2 my-5">                        
            <div class="form-group">
                <label class="h5 font-weight-bold text-dark" for="Marca_Id">Marca Id:</label>
                <input id="seccion" name="MarcaId" type="text" value="<s:property value="marca.getMarcaId()"/>" class="form-control " placeholder="Introduce el nombre" required>                    
            </div>
            
            <div class="form-group">
                <label class="h5 font-weight-bold text-dark" for="Marca_Nombre">Nombre:</label>
                <s:textfield class="form-control" name="marcaNombre" value="%{marca.getMarcaNombre()}"></s:textfield>
                <!--<input id="seccion" name="Marca_Nombre" type="text" value="${marca.getMarcaNombre()}" class="form-control" placeholder="Introduce el nombre">  -->
            </div>                   
            
            <div class="form-group my-5">                    
                <button id="envio" type="submit" name="envio" class="btn btn-success btn-lg">
                    <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> Aceptar
                </button> 
                <button id="envio" type="reset" name="envio" class="btn btn-warning btn-lg ">
                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Restablecer
                </button>                     
                <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoMarcas.action'">
                    <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
                </button>
            </div>

        </form>
    </body>
</html>