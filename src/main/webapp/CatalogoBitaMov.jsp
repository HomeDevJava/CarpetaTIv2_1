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
        })
                ();
    </script>   

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
            $('.btn-outline-success').click(function () {
                var myurl = $(this).val();

                $.ajax({
                    type: 'GET',
                    url: myurl,
                    success: function (data) {
                        $('#detail').html(data);
                    }
                });
            });

            $('.btn-outline-primary').click(function () {
                var myurl = $(this).val();

                $.ajax({
                    type: 'GET',
                    url: myurl,
                    success: function (data) {
                        $('#evidencia').html(data);
                    }
                });
            });

            /*            
             $("#Fec_Initramite").datepicker();
             $("#Fec_Initramite").datepicker("option", "dateFormat", "yy-mm-dd");
             */
        });
    </script>
    <main role="main">
        <div class="container-fluid">

            <div class="jumbotron ">
                <div class="container-fluid">                       
                    <h1 class="text-info"> Movimientos de Activos</h1>                        
                    <p>Catalogo de Movimientos de Activos Fijos HH & PRN, CPU</p>   
                </div>
            </div>

            <div>
                <div class="form-inline my-2">
                    <div class="col-3">
                        <button id="insertar" class=" btn btn-sm btn-success my-2" data-toggle="modal" data-target="#myModalInsert" ><span class="fa fa-plus-circle"></span> Nuevo Registros</button> 
                        <!--<a id="insert" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" value="jjj" > Insertar Registro</a> -->  
                    </div>
                    <div class="col-3">
                        <form class="form-group form-inline my-auto my-lg-0" action="FiltrarBitaMovSerie.do">
                            <label class="h5" for="serie" >Serie </label>
                            <input name="s_serie" type="text" class="form-control form-control-sm mx-sm-2">
                            <!--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
                            <button class="btn btn-sm btn-outline-success my-2 my-sm-0" type="submit"><span class="fa fa-search"></span>Buscar</button>
                        </form>
                    </div>
                    <div class="col-3">
                        <form class="form-group form-inline my-auto my-lg-0" action="FiltrarBitaMovCedis.do">
                            <label class="h5" for="cedis" >Cedis</label>
                            <s:select class=" form-control  form-control-sm mx-sm-2" name="listadeCedis" list="listadeCedis"
                                      listKey="cedId" listValue="cedNombre"/>
                            <!--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
                            <button class="btn btn-sm btn-outline-success my-2 my-sm-0" type="submit"><span class="fa fa-search"></span>Buscar</button>
                        </form>
                    </div>
                </div>


                <display:table class="table table-striped table-hover table-sm"  name="listadeBitaMovs"  id="listadeBitaMovs" 
                               pagesize="25" export="true" requestURI="/CatalogoBitaMovs.action" >                     
                    <display:column property="bitmovaFolio" title="ID" />
                    <display:column property="bitmovaFecha" title="Fecha" />  
                    <display:column property="bitmovaOrigenId.cedNombre" title="Origen" />  
                    <display:column property="tblCedis.cedNombre" title="Destino" />  
                    <display:column property="tblEmpleados.empleadoNombre" title="Destinatario"/>
                    <display:column property="tblModelos.modNombre" title="Modelo" />
                    <display:column property="bitmovaSerie" title="Serie"/>        
                    <display:column title="Accion" headerClass="col-1">                          
                        <c:url value="DeleteBitaMovs.action?Id=${listadeBitaMovs.bitmovaFolio}" var="delBitaRepara"/>
                        <c:url value="FrmEditBitaMovs.action?Id=${listadeBitaMovs.bitmovaFolio}" var="editBitaRepara"/>
                        <button value="${editBitaRepara}" class="btn btn-sm btn-outline-info" data-toggle="modal" data-target="#myModalDetalles"><span class="fa fa-edit"></span></a></button>                       
                        <a href="${delBitaRepara}" class="btn btn-sm btn-outline-danger"><span class="fa fa-minus-circle"></span></a>                       
                        <button id="Detalles" name="Detalles" class="btn btn-sm btn-outline-success" data-toggle="modal" data-target="#myModalDetalles" value="FrmViewBitaMov.do?IdFolio=${elem.getBitmova_Folio()}"><span class="fa fa-lg fa-eye"></span></button>
                        <button id="Anexar" name="anexar" class="btn btn-sm btn-outline-primary" data-toggle="modal" data-target="#myModalEvidencia" value="FrmAddFileBitaMov.do?IdFolio=${elem.getBitmova_Folio()}"><span class="fa fa-lg fa-paperclip"></span></button>
                        <button id="pdf" name="pdf" class="btn btn-sm btn-warning" onclick="window.location.href = 'RptBitaMovFolio.do?IdFolio=${elem.getBitmova_Folio()}'"><span class="fa fa-lg fa-file-pdf"></span></button>
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
    <!-- Modal para Adjuntar Evidencia
   ***********************************************************************************************************-->
    <div class="modal fade" id="myModalEvidencia" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4>Anexar Archivo</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>       
                </div>
                <div class="modal-body" id="evidencia">

                </div>
            </div>
        </div>
    </div>
    <!-- Modal para Editar registros
    ***********************************************************************************************************-->
    <div class="modal fade" id="myModal" >
        <div class="modal-dialog modal-lg">
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
    <!--Modal para mostrar detalles del folio
    *******************************************************************************************************-->
    <div class="modal fade" id="myModalDetalles" >
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4>Detalles del Registro</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>       
                </div>
                <div class="modal-body" id="detail">

                </div>
            </div>
        </div>
    </div>


</t:genericpage>