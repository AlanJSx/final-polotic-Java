
<%@page import="Logica.Employee"%>
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
    <title>Reservas</title>
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
                <a class="nav-link" href="guests.jsp">Lista de Hu?spedes </a>
            </li>
          </ul>
        </div>
    </nav> 
        <div class="mx-auto">
            <form action="SvGetReservation" method="GET" class="g-3">            
                <div class="row mb-3">
                    <div class="col">
                        <label for="from" class="form-label">Desde</label>
                        <input type="date" name="from" class="form-control">
                    </div>
                    <div class="col">
                        <label for="to" class="form-label">Hasta</label>
                        <input type="date" name="to" class="form-control">
                    </div>

                         
                </div>
                <div class="row">
                    <input type="submit" value="Confirmar" class="btn-primary px-2">
                </div>
                 
            </form>
        </div>
    
        <div class="">
            <form action="SvReservationByEmployee" method="GET" class="g-3">            
                <div class="row mb-3">
                    <div class="col">
                        <label for="selectedEmployee" class="form-label">Empleados</label>
                        <select name="selectedEmployee" class="form-select">
                            <option value="-" selected> - </option>
                            
                            <!-- insertar java para obtener habitaciones -->
                          <%  
                                
                                List<Employee> employeeList = (List) request.getSession().getAttribute("employeeList");
                                
                                for(Employee employee : employeeList){
                                     String employeName = employee.getName() + " " + employee.getLastName();
                                     int employeeId = employee.getEmployeeId();
                                     
                    
                            %> 
                
                                <option value="<%= employeeId %> "> <%= employeName %> </option>
                        
                             <% } %>

                        </select>
                    </div>
                   
                </div>
                <div class="row">
                    <input type="submit" value="Confirmar" class="btn-primary px-2">
                </div>
                 
            </form>
        </div>
                             
                             
        <div class="">
            <form action="SvReservationByDateGuest" method="GET" class="g-3">            
                <div class="row mb-3">
                    <div class="col">
                        <label for="from" class="form-label">Desde</label>
                        <input type="date" name="from" class="form-control">
                    </div>
                    <div class="col">
                        <label for="to" class="form-label">Hasta</label>
                        <input type="date" name="to" class="form-control">
                    </div>

                         
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="guestDni" class="form-label">Dni del Huesped</label>
                        <input type="number" name="guestDni" class="form-control">
                    </div>
                <div class="row">
                    <input type="submit" value="Confirmar" class="btn-primary px-2">
                </div>
                <input type = "button" value = "Atras" onclick = "history.back ()" class="btn-secondary px-4"> 
            </form>
        </div>
    
    <main>

    </main>


    <footer class="text-center text-white mt-3" style="background-color: #21081a;">
        <!-- Grid container -->
        <div class="container p-4"></div>
        <!-- Grid container -->
      
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
          ? 2021 Copyright:
          <a class="text-white" href="#">Hotel - TpFinal</a>
        </div>
        <!-- Copyright -->
      </footer>

    <% } %>
</body>
</html>

