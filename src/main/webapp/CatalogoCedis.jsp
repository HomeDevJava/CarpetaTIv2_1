<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net/el" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
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
                    <h1 class="text-info"> Cedis </h1>                        
                    <p>Catalogo de Cedis</p>   
                </div>
            </div>
            <div>
                <div class="form-inline my-2">
                    <div class="col-3">
                        <button id="insertar" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" > Insertar Registro</button> 
                        <!--<a id="insert" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" value="jjj" > Insertar Registro</a> -->  
                    </div>
                    <div class="col-5">
                    </div>
                </div>                
                <display:table class="table table-striped table-hover table-sm"  name="listadeCedis"  id="lista"
                               pagesize="5" export="true" requestURI="/CatalogoCedis.action" >
                    <display:column property="cedId" title="Cedis ID" headerClass="col-1" scope="col"/>
                    <display:column property="cedNombre" title="Nombre" headerClass="col-1"/>
                    <display:column property="cedUop" title="UOP" headerClass="col-1"/>
                    <display:column property="cedDomicilio" title="Domicilio" headerClass="col-7"/>
                    <display:column title="Accion" headerClass="col-2">                          
                        <c:url value="DeleteCedis.action?cedId=${lista.getCedId()}" var="delCedis"/>
                        <c:url value="FrmEditCedis.action?cedId=${lista.getCedId()}" var="editCedis"/>
                        <button value="${editCedis}" class="btn btn-sm btn-outline-info" data-toggle="modal" data-target="#myModal"><span class="fa fa-edit"></span></a></button>                       
                        <a href="${delCedis}" class="btn btn-sm btn-outline-danger"><span class="fa fa-minus-circle"></span></a>                       
                    </display:column>
                    <display:setProperty  name="paging.banner.page.separator" value=" | "/>
                    <display:setProperty  name="paging.banner.some_items_found">
                        <span class="pagebanner">{0} {1} encontrado, show <span class="h5">{2} to {3}.</span></span>
                    </display:setProperty>
                    <display:setProperty  name="paging.banner.full">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="{1}">First</a></li>
                            <li class="page-item"><a class="page-link" href="{2}">Prev</a></li>
                            <li class="page-item page-link">{0}</li>
                            <li class="page-item"><a class="page-link" href="{3}">Next</a></li>
                            <li class="page-item"><a class="page-link" href="{4}">Last</a></li>
                        </ul>                       
                    </display:setProperty>
                    <display:setProperty  name="paging.banner.placement" value="bottom"/>
                    <display:setProperty  name="paging.banner.first">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="{3}">Next</a></li>
                            <li class="page-item page-link">{0}</li>
                            <li class="page-item"><a class="page-link" href="{4}">Last</a></li>
                        </ul>
                    </display:setProperty>
                    <display:setProperty  name="paging.banner.last" >
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="{1}">First</a></li>
                            <li class="page-item page-link">{0}</li>
                            <li class="page-item"><a class="page-link" href="{2}">Prev</a></li>
                        </ul>                        
                    </display:setProperty>
                </display:table>
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
                <form name="form" method="get" action="InsertCedis.action" >
                    <div class="modal-header">
                        <h4>Nuevo Registro</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>                             
                    </div>
                    <div class="modal-body">                            
                        <div class="form-group">
                            <label class="h5 font-weight-bold text-dark" for="Ced_Nombre">Nombre:</label>
                            <input id="cart" name="cedNombre" type="text" class="form-control " placeholder="Introduce el nombre del cedis">

                        </div>
                    </div>
                    <div class="modal-body">                            
                        <div class="form-group">
                            <label class="h5 font-weight-bold text-dark" for="Ced_UOP">UOP:</label>
                            <input id="cart" name="cedUop" type="text" class="form-control " placeholder="Introduce el numero de la Unidad operativa">
                            <small id="CartHelp" class="form-text text-muted" >Ejemplo:360</small>
                        </div>
                    </div>
                    <div class="modal-body">                            
                        <div class="form-group">
                            <label class="h5 font-weight-bold text-dark" for="Ced_Domicilio">Domicilio:</label>
                            <input id="cart" name="cedDomicilio" type="text" class="form-control " placeholder="Introduce la dirección">

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
                            <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoCedis.action'">
                                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
                            </button>
                        </div>
                    </div> 
                </form>
            </div>             
        </div>           
    </div>    
</t:genericpage>