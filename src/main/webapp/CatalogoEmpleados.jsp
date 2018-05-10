<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net/el" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
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
            
            $('#insertar').click(function () {
                var myurl = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: myurl,
                    success: function (data) {
                        $('#modales2').html(data);
                    }
                });
            });
        });
    </script>
    <main role="main">
        <div class="container-fluid">

            <div class="jumbotron ">
                <div class="container-fluid">
                    <h1 class="text-info"> Empleados </h1>
                    <p>Catalogo de Empleado</p>   
                </div>
            </div>

            <div>
                <div class="form-inline my-2">
                    <div class="col-3">
                        <button id="insertar" name="insertar" class=" btn btn-md btn-success my-2" data-toggle="modal" data-target="#myModalInsert" value="FrmInsertEmpleado.action" > Insertar Registro</button>  
                    </div>
                    <div class="col-5">

                    </div>
                    <div class="col-4">
                        <form class="form-inline my-auto my-lg-0" action="FiltrarEmpleados2.action">
                            <select name="puestoId" class=" form-control mr-sm-2">
                                <option value="0">seleccionar</option>
                                <c:forEach var="puesto" items="${listadePuestos}">
                                    <option value="${puesto.getPuestoId()}">${puesto.getPuestoNombre()}</option>
                                </c:forEach> 
                            </select>
                            <!--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </div>
                
                <display:table class="table table-striped table-hover table-sm"  name="listadeEmpleados"  id="listaEmpleados" 
                               pagesize="15" export="true" requestURI="/CatalogoEmpleados.action" >
                    <display:column property="empleadoId" title="ID" headerClass="col-1" headerScope="col"/>
                    <display:column property="empleadoNum" title="Nomina" headerClass="col-1"/>
                    <display:column property="empleadoNombre" title="Nombre" headerClass="col-1"/>
                    <display:column property="empleadoApellidos" title="Apellidos" headerClass="col-1"/>
                    <display:column property="empleadoEmail" title="Email" headerClass="col-1"/>
                    <display:column property="empleadoTelefono" title="Telefono" headerClass="col-1"/>
                    <display:column property="tblPuestos.puestoNombre" title="Puesto" sortable="true" headerClass="col-1"/>
                    <display:column property="userName" title="User" headerClass="col-1"/>
                    <display:column title="Accion" headerClass="col-1">                          
                        <c:url value="DeleteEmpleado.action?empleadoId=${listaEmpleados.getEmpleadoId()}" var="delEmpleado"/>
                        <c:url value="FrmEditEmpleado.action?empleadoId=${listaEmpleados.getEmpleadoId()}" var="editEmpleado"/>
                        <button value="${editEmpleado}" class="btn btn-sm btn-outline-info" data-toggle="modal" data-target="#myModal"><span class="fa fa-edit"></span></a></button>                       
                        <a href="${delEmpleado}" class="btn btn-sm btn-outline-danger"><span class="fa fa-minus-circle"></span></a>                       
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

                <!-- ]Modal para Editar Registro-------------------------------------------------------->
                <div class="modal fade" id="myModal" >
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header bg-primary">
                                <h4>Editar Registro</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>       
                            </div>
                            <div class="modal-body" id="modales">

                            </div>
                        </div>
                    </div>
                </div>

                <!-- ]Modal para Insertar Registro-------------------------------------------------------->
                <div class="modal fade" id="myModalInsert" >
                    <div class="modal-dialog">
                        <div class="modal-content">                                                        
                                <div class="modal-header bg-primary">
                                    <h4>Insertar Registro</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>       
                                </div>
                                <div class="modal-body" id="modales2">                              
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</t:genericpage>