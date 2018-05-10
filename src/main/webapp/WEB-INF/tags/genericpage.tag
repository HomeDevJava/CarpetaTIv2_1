<%@tag description="Overall Page Template" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>    
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/fontawesome-all.css">
        <script src="js/jquery-3.2.1.min.js"></script> 
        <script src="js/popper.min.js"></script>        
        <script src="js/bootstrap.min.js"></script> 
        
    </head>
    <body>
        <div id="pageheader">           
            <nav class="navbar navbar-expand-md navbar-dark bg-dark ">
                <a class="navbar-brand" href="#"><img src="fonts/pepsi.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    <img src="fonts/pepsi.png">
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Bitacoras
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CatalogoBitaMovs.action"><span class="fa fa-exchange-alt"></span> Mov. de Activos Fijos</a>
                                <a class="dropdown-item" href="CatalogoBitaReparacion.action"><span class="fa fa-table"></span> Reparaciones</a>

                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Catalogos
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CatalogoCedis.action"><span class="fa fa-building"></span> Cedis</a>
                                <a class="dropdown-item" href="CatalogoEmpleados.action"><span class="fa fa-id-card"></span> Empleados</a>
                                <a class="dropdown-item" href="CatalogoPuestos.action"><span class="fab fa-joomla"></span> Puestos</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="CatalogoModelos.action"><span class="fa fa-at"></span> Modelos</a>
                                <a class="dropdown-item" href="CatalogoMarcas.action"><span class="fa fa-globe"></span> Marcas</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="CatalogoStatus.action"><span class="fa fa-th-list"></span> Status</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Reportes
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="RptCedis.action"><span class="fa fa-building"></span> Cedis</a>
                                <a class="dropdown-item" href="RptEmpleados.action"><span class="fa fa-id-card"></span> Empleados</a>
                                <a class="dropdown-item" href="RptPuestos.action"><span class="fab fa-joomla"></span> Puestos</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="RptModelos.action"><span class="fa fa-at"></span> Modelos</a>
                            </div>
                        </li>
                    </ul>        
                </div>
            </nav>
        </div>
        <div id="body">            
            <jsp:doBody></jsp:doBody>            
        </div>

        <footer class="container-fluid bg-dark">  
            <div class=" text-center center-block">
                <p class="text-white "><span class="fa fa-copyright"></span> Powered by Gepp 2017-2018 ${message}</p>
            </div>
        </footer>
    </body>
</html>