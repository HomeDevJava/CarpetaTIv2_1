<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<t:genericpage>  
    <script>
        $(document).ready(function () {
            $('.btn-outline-info').click(function () {
                var myurl = $(this).val();

                $.ajax({
                    type: 'GET',
                    url: myurl,
                    success: function (data) {
                        $('#modales').html(data);
                    }
                });
            });
        });
    </script>
    <main role="main">
        <div class="container-fluid">

            <div class="jumbotron ">
                <div class="container-fluid">                       
                    <h1 class="text-info"> Marcas </h1>                        
                    <p>Catalogo de Marcas de Equipos</p>

                </div>

                <div>
                    <div class="form-inline my-2">
                        <div class="col-3">
                            <button id="insertar" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" > <span class="fa fa-plus-circle"></span> Insertar Registro</button> 

                        </div>
                        <div class="col-5">
                        </div>
                    </div>

                    <table class="table table-striped table-hover table-sm" >
                        <thead class="table-info " >
                            <tr class="h5 container-fluid fixed" >
                                <th scope="col">#MarcaId</th>                               
                                <th scope="col">Nombre</th>
                                <th scope="col">Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listadeMarcas">
                                <tr class="h5">
                                    <th scope="row"><s:property value="marcaId"/></th>
                                    <td><s:property value="marcaNombre" /></td>
                                    <td>                                        
                                        <button id="Editar" name="edit" class="btn btn-sm btn-outline-info " data-toggle="modal" data-target="#myModal" value='<s:url action="FrmEditMarca"><s:param name="marcaId" value="marcaId"/></s:url>'><span class="fa fa-edit"></span></button>
                                        <button class="btn btn-sm btn-outline-danger" type="button" onclick="window.location.href = '<s:url action="DeleteMarca"><s:param name="marcaId" value="marcaId"/></s:url>'"><span class="fa fa-minus-circle"></span></button>
                                    </td>                                        
                                </tr>
                            </s:iterator>                           
                        </tbody>
                    </table>
                </div>
            </div>
    </main>

    <div class="modal fade" id="myModal" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4>Editar Registro</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>       
                </div>
                <div class="modal-body" id="modales">

                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="myModalInsert">
        <div class="modal-dialog">           
            <div class="modal-content">
                <form name="form" method="get" action="InsertMarca.action" >
                    <div class="modal-header">
                        <h4>Nuevo Registro</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>                             
                    </div>
                    <div class="modal-body">                            
                        <div class="form-group">
                            <label class="h5 font-weight-bold text-dark" for="MarcaNombre">#Nombre de la Marca:</label>
                            <input name="MarcaNombre" type="text" class="form-control " placeholder="Introduce el nombre de Marca">                            
                            <small id="CartHelp" class="form-text text-muted" >Ejemplo:Lenovo</small>
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
                            <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoMarcas.do'">
                                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
                            </button>
                        </div>
                    </div> 
                </form>

            </div>          
        </div>           
    </div> 
</t:genericpage>  