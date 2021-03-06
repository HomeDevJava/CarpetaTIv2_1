<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
    <form name="form" method="get" action="InsertEmpleado.action" class="needs-validation" novalidate> 
    <div class="modal-body">        
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="empleadoNum">#Numero de Empleado:</label>
            <s:textfield cssClass="form-control is-valid" name="empleadoNum" value="%{empleado.empleadoNum}" required="true"/>
            <small class="form-text text-muted" >El numero de nomina, ej:50102030</small>
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="empleadoNombre">Nombre:</label>
            <s:textfield cssClass="form-control" name="empleadoNombre" value="%{empleado.empleadoNombre}" required="true"/>
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="empleadoApellidos">Apellidos:</label>
            <s:textfield cssClass="form-control" name="empleadoApellidos" value="%{empleado.empleadoApellidos}" required="true"/>
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="empleadoEmail">Email:</label>
            <s:textfield cssClass="form-control" name="empleadoEmail" value="%{empleado.empleadoEmail}"/>
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="empleadoTelefono">Telefono:</label>
            <s:textfield cssClass="form-control" name="empleadoTelefono" value="%{empleado.empleadoTelefono}"/>
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="puestoId">Puesto:</label>
             <s:select name="puestoId" cssClass="form-control mr-sm-2"  
                              list="listadePuestos" listKey="PuestoId" listValue="PuestoNombre"/>                   
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="userName">Usuario:</label>
            <s:textfield cssClass="form-control" name="userName" value="%{empleado.userName}"/>
        </div>
        <div class="form-group">
            <label class="h5 font-weight-bold text-dark" for="userPsw">Password:</label>
             <s:textfield cssClass="form-control" name="userPsw" value="%{empleado.userPsw}"/>
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
            <button type="button" class="btn btn-danger btn-lg" onclick="window.location.href = 'CatalogoEmpleados.action'">
                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Cancelar
            </button>
        </div>
    </div>
</form>
</div>
</main>