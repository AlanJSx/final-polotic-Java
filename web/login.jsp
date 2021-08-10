
<%@page import="Logica.Controller"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="./assets/css/styles.css">
    <title>Hotel HomePage</title>
</head>
<body class="container">  
    <%
        Controller control = new Controller();
        // control.adminUser();
        
    %>
    <header>
      <!-- Background image -->
      <div
        class="p-5 text-center bg-image"
        style="
          background-image: url('./assets/images/habitaciones.jpg');
          height: 400px;
        ">
        <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
          <div class="d-flex justify-content-center align-items-center h-100">
            <div class="text-white">
              <h1 class="mb-3">Hotel</h1>
              <h3 class="mb-3">Inicio de Sesi�n</h4>
            </div>
          </div>
        </div>
      </div>
      <!-- Background image -->
    </header>

    <nav class="navbar navbar-expand navbar-light bg-gray mb-3">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="#">Inicio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Reservas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Habitaciones</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Empleados</a>
            </li>
          </ul>
        </div>
    </nav>



    <main>
        <div class="mx-auto">
            <form action="SvLoginPage" method="POST" class="g-3">
                

        </div>
        <div class="mx-5 px-5">

            <div class="mb-2">
                <label for="usuarioJsp" class="form-label">Usuario:</label>
                <input type="text" name="jspUser" class="form-control">
            </div>
            <div class="mb-2">
                <label for="passJsp" class="form-label">Contrase�a:</label>
                <input type="text" name="jspPassword" class="form-control">
            </div>
            <div class="mb-2 text-center">
                 <% 
                     // agregar condici�n para alertar sobre el error
                     String error = (String) request.getSession().getAttribute("alert"); 
  
                         
                 %>
                         <%= error %>
                   
                
            </div>

            
        </div>               
        <div class="text-center">
            <input id="btnConfirmar" type="submit" value="Iniciar Sesi�n" class="btn-primary px-5">    
        </div>      
        
            </form>
        </div
    </main>


    <footer class="text-center text-white mt-3" style="background-color: #21081a;">
        <!-- Grid container -->
        <div class="container p-4"></div>
        <!-- Grid container -->
      
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
          � 2021 Copyright:
          <a class="text-white" href="#">Hotel - TpFinal</a>
        </div>
        <!-- Copyright -->
      </footer>

    
</body>
</html>
