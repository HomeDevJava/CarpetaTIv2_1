<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<t:genericpage>
        <script src="js/jquery-3.2.1.min.js"></script>         
        <script>
            $(document).ready(function () {
                $('#insertar').click(function () {
                    var myurl=$(this).val();
                    
                    $.ajax({                          
                        type: 'GET',
                        url: myurl,                        
                        success: function (data) {
                            $('#myInsertBody').html(data);
                        }
                    });
                });
                
                $('.btn-outline-info').click(function () {
                    var myurl=$(this).val();
                    
                    $.ajax({                          
                        type: 'GET',
                        url: myurl,                        
                        success: function (data) {
                            $('#myEditBody').html(data);
                        }
                    });
                });
            });            
            
        </script>
    

            <main role="main">
                <div class="container-fluid">

                    <div class="jumbotron ">
                        <div class="container-fluid">
                            <h1 class="text-info"> Modelos </h1>
                            <p>Catalogo de Modelos</p>   
                        </div>
                    </div>

                    <div>
                        <div class="form-inline my-2">
                            <div class="col-3">
                                <button id="insertar" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" value="FrmInsertModelo.action" ><span class="fa fa-plus-circle"></span> Insertar Registro</button>  
                            </div>
                            <div class="col-5">

                            </div>
                            <div class="col-4">
                                <form class="form-inline my-auto my-lg-0" action="FiltrarModelos.action">
                                    <s:select id="marcaId" name="marcaId" cssClass="form-control mr-sm-2" 
                                              list="listadeMarcas" listKey="marcaId" listValue="marcaNombre" 
                                              headerKey="0" headerValue="Seleccionar" value="0"/>
                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                            </form>
                        </div>

                    </div>

                    <table class="table table-striped table-hover table-sm" >
                        <thead class="table-info " >
                            <tr class="h5 container-fluid fixed" >
                                <th scope="col">#Id Modelo</th>                                
                                <th scope="col">Descripción</th>                                
                                <th scope="col">Marca</th>
                                <th scope="col">Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listadeModelos">
                                <tr class="h5">
                                    <th scope="row"><s:property value="modId"/></th>                                    
                                    <td><s:property value="modNombre" /></td>                                    
                                    <td><s:property value="tblMarcas.getMarcaNombre()"/></td>                                    
                                    <td>
                                        <button id="Editar" name="edit" class="btn btn-sm btn-outline-info" data-toggle="modal" data-target="#myModalEdit" value='<s:url action="FrmEditModelo"><s:param name="modId" value="modId"/></s:url>'><span class="fa fa-edit"></span></button>&nbsp;                                        
                                        <!--<button class="btn btn-sm btn-outline-danger " onclick="window.location.href='<s:url action="DeleteModelo"><s:param name="modId" value="modId"/></s:url>'"><span class="fa fa-minus-circle"></span></button>-->
                                        <s:a action="DeleteModelo" cssClass="btn btn-sm btn-outline-danger" ><span class="fa fa-minus-circle"></span>
                                            <s:param name="modId" value="modId" />
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                                                
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
        
        <div class="modal fade" id="myModalInsert">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                         <h4>Insertar Registro</h4>
                          <button type="button" class="close" data-dismiss="modal">&times;</button>       
                    </div>
                    <div id="myInsertBody">
                        
                    </div>                    
                </div>
            </div>
        </div>
        
        <div class="modal fade" id="myModalEdit">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                         <h4>Editar Registro</h4>
                          <button type="button" class="close" data-dismiss="modal">&times;</button>       
                    </div>
                    <div id="myEditBody">
                        
                    </div>
                </div>
            </div>
        </div>
</t:genericpage>