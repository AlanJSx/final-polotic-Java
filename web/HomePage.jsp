
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Reservation"%>
<%@page import="Logica.Controller"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="./assets/css/styles.css">
    <title>Habitaciones</title>
</head>
<body class="container">   
    
    <%
        HttpSession mySession = request.getSession();
        
        String userLogin = (String) mySession.getAttribute("jspUser");
        
        if (userLogin == null){
            response.sendRedirect("login.jsp");
        } else { 
        
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
              <h3 class="mb-3">HomePage</h3>
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
              <a class="nav-link" href="HomePage.jsp">Inicio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="reservationCheckDate.jsp">Reservas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="rooms.jsp">Habitaciones</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="employee.jsp">Empleados</a>
            </li>
            
            <li>
                <a class="nav-link" href="guests.jsp">Lista de Huéspedes </a>
            </li>
            <li>
                <a class="nav-link" href="reservations.jsp">Lista de Reservas </a>
            </li>
            <li>
                <a class="nav-link" href="DatosPrueba.jsp"> | Carga datos Prueba |</a>
            </li>

          </ul>
        </div>
    </nav>
    

    
    <main class="bodycard">
        <div class="row row-cols-1 row-cols-md-2 g-4 ">
          <div class="col">
              
            <div class="card">
                <img src="./assets/images/imagenReservas.jpg" class="card-img-top " alt="reservas">
              <div class="card-body">
                <h5 class="card-title text-center">Reservas</h5>
               
                    
                    <ul>
                        <li>
                            <a href="reservations.jsp" class="text-reset">  Consultas sobre reservas </a>
                        </li>
                        <li>
                            <a href="reservationCheckDate.jsp" class="text-reset">  Nueva Reserva </a>
                        </li>
                    </ul>
                
              </div>
            </div>
              
          </div>
          <div class="col">
            <div class="card">
                <img src="./assets/images/imagenHabitaciones.jpg" class="card-img-top" alt="habitaciones">
              <div class="card-body">
                <h5 class="card-title">Habitaciones</h5>
                <ul>
                    <li>
                       <a href="newRoom.jsp" class="text-reset">  Nueva Habitación </a>   
                   </li>
                   <li>
                       <a href="rooms.jsp" class="text-reset">  Lista de Habitaciones </a>
                       
                   </li>
               </ul>
              </div>
            </div>
             
          </div>
          <div class="col">
              <a href="guests.jsp" class="text-decoration-none text-reset">  
            <div class="card">
                <img src="./assets/images/imagenHuesped.jpg" class="card-img-top" alt="huesped">
              <div class="card-body">
                <h5 class="card-title">Huesped</h5>
                <ul>
                   <li>
                       <a href="guests.jsp" class="text-reset">  Lista de Huéspedes </a>
                   </li>
               </ul>
                
              </div>
            </div>
                
          </div>
          <div class="col">            
            <div class="card">
                 <img src="./assets/images/imagenEmpleados.jpg"  class="card-img-top" alt="Empleados" >
              <div class="card-body">
                <h5 class="card-title">Empleados</h5>
                <ul>
                    <li>
                        <a href="newEmployee.jsp" class="text-reset">  Nuevo Empleado </a>   
                   </li>
                   <li>
                       <a href="employee.jsp" class="text-reset"> Lista y edición de Empleados </a>
                       
                   </li>
               </ul>
              </div>
               
            </div>
                
          </div>
        </div>
        
        
        
        
        
        
        
        
    </main>


    <footer class="text-center text-white mt-3" style="background-color: #21081a;">
        <!-- Grid container -->
        <div class="container p-4"></div>
        <!-- Grid container -->
      
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
          © 2021 Copyright:
          <a class="text-white" href="#">Hotel - TpFinal</a>
        </div>
        <!-- Copyright -->
      </footer>

    <% } %>
</body>
</html>

