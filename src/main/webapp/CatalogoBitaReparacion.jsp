<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net/el" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:genericpage>
    <script>
        (function () {                
                'use strict';
                window.addEventListener('load', function () {
                    // Fetch all the forms we want to apply custom Bootstrap validation styles to
                    var forms = document.getElementsByClassName('needs-validation');
                    // Loop over them and prevent submission
                    var validation = Array.prototype.filter.call(forms, function (form) {
                        form.addEventListener('submit', function (event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();
    </script>    

    <script>
        $(document).ready(function () {
            $('.btn-outline-info').click(function () {
                var myurl = $(this).val();

                $.ajax({
                    type: 'GET',
                    url: myurl,
                    success: function (data) {
                        $('#detail').html(data);
                    }
                });
            });
                         
            $('#btninsertar').click(function () {
                var myurl = $(this).val();

                $.ajax({
                    type: 'GET',
                    url: myurl,
                    success: function (data) {
                        $('#detail').html(data);
                    }
                });
            });
           
        });
    </script>
    <main role="main">
        <div class="container-fluid">

            <div class="jumbotron shadow-sm">
                <div class="container-fluid">                       
                    <h1 class="text-info"> Reparaciones HH & PRN </h1>                        
                    <p>Catalogo de Reparaciones</p>   
                </div>
            </div>

            
            <div>
                <div class="form-inline my-2">
                    <div class="col-3">
                        <s:url action="FrmInsertBitaReparacion.action" var="insertar"/>
                        <button id="btninsertar" class=" btn btn-md btn-success my-2 fa fa-plus-circle" data-toggle="modal" data-target="#myModalDetalles" value="${insertar}" > Nuevo Registro</button> 
                        <!--<a id="insert" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" value="jjj" > Insertar Registro</a> -->  
                    </div>
                     
                    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">                        
                        <form class="form-group form-inline my-auto my-lg-0" action="CatalogoBitaReparacion.action">
                            <label class="h5" for="IdSerie" >Serie </label>
                            <s:textfield name="IdSerie" class="form-control form-control-sm mx-sm-2"/>
                            <label class="h5" for="IdStatus" >Status </label>
                            <s:select class=" form-control  form-control-sm mx-sm-2" name="IdStatus" 
                                      list="listadeStatus" listKey="idStatus" listValue="descripcion"
                                      headerKey="0" headerValue="Seleccionar" value="0"/>
                            <label class="h5" for="IdModelo" >Modelo </label>
                            <s:select class=" form-control  form-control-sm mx-sm-2" name="IdModelo" 
                                      list="listadeModelos" listKey="modId" listValue="modNombre"
                                      headerKey="0" headerValue="Seleccionar"/>
                            <label class="h5" for="cedis" >Cedis</label>
                            <s:select class=" form-control  form-control-sm mx-sm-2" name="IdCedis" 
                                      list="listadeCedis" listKey="cedId" listValue="cedNombre"
                                      headerKey="0" headerValue="Seleccionar" value="0"/>
                            <!--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
                            <button class="btn btn-sm btn-outline-success my-2 my-sm-0" type="submit"><span class="fa fa-search"></span>Buscar</button>
                        </form>
                    </div>
                </div>
                
                 <display:table class="table table-striped table-hover table-sm"  name="listadeBitaReparacion"  id="listadeBitaReparacion" 
                     pagesize="25" export="true" requestURI="/CatalogoBitaReparacion.action" >                     
                     <display:column property="idFolio" title="ID" headerClass="bg-primary" />
                     <display:column property="serie" title="Serie" headerClass="bg-primary"/>        
                     <display:column property="tblModelos.modNombre" title="Modelo" headerClass="bg-primary" />
                     <display:column property="tblCedis.cedNombre" title="Cedis" headerClass="bg-primary"/>  
                     <display:column property="fecInitramite"  title="Tramite" headerClass="bg-primary"/>
                     <display:column property="fecEnvio"  title="Enviado" headerClass="bg-primary"/>
                     <display:column property="fecRetorno"  title="Retorno" headerClass="bg-primary"/>
                     <display:column property="tblStatusByIdStatus.descripcion"  title="Status" headerClass="bg-primary"/>
                     <display:column property="observaciones"  title="Observacion" headerClass="bg-primary"/>
                     <display:column property="ro"  title="#RO" headerClass="bg-primary"/>
                     <display:column title="Accion" headerClass="bg-primary ">                          
                        <c:url value="DeleteBitaReparacion.action?Id=${listadeBitaReparacion.idFolio}" var="delBitaRepara"/>
                        <c:url value="FrmEditBitaReparacion.action?Id=${listadeBitaReparacion.idFolio}" var="editBitaRepara"/>
                        <button value="${editBitaRepara}" class="btn btn-sm btn-outline-info" data-toggle="modal" data-target="#myModalDetalles"><span class="fa fa-edit"></span></a></button>                       
                        <a href="${delBitaRepara}" class="btn btn-sm btn-outline-danger"><span class="fa fa-minus-circle"></span></a>                       
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
    <!--Modal para mostrar detalles del folio
    *******************************************************************************************************-->
    <div class="modal fade" id="myModalDetalles" >
        <div class="modal-dialog modal-md">
            <div id="detail" class="modal-content">
               
            </div>
        </div>
    </div>
</t:genericpage>