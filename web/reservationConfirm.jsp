<%@page import="Logica.Room"%>
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
        String dniGuest = (String) mySession.getAttribute("dniGuest");
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
              <h3 class="mb-3">Reservas</h4>
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
          </ul>
        </div>
    </nav>



    <main>
        <div class="mx-auto">
            <form action="" method="GET" class="g-3">
                <div class="row mb-3">
                    <div class="col">
                        <label for="dni" class="form-label">Nro. Documento</label>
                        <input type="text" name="dni" class="form-control" value="<%= dniGuest %>">
                    </div>
                    <div class="col">
                        <label for="birthDate" class="form-label">Fecha Nacimiento</label>
                        <input type="date" name="birthDate" class="form-control">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="name" class="form-label">Nombre</label>
                        <input type="text" name="name" class="form-control">
                    </div>
                    <div class="col">
                        <label for="lastName" class="form-label">Apellido</label>
                        <input type="text" name="lastName" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <label for="adress" class="form-label">Domicilio</label>
                        <input type="text" name="adress" class="form-control">
                    </div>
                    <div class="col">
                        <label for="career" class="form-label">Profesión</label>
                        <input type="text" name="career" class="form-control">
                    </div>
                </div>
                
                <div class="row mb-3">
                    <div class="col">
                        <label for="checkIn" class="form-label">Fecha Check-In</label>
                        <input type="date" name="checkIn" class="form-control">
                    </div>
                    <div class="col">
                        <label for="checkOut" class="form-label">Fecha Check-out</label>
                        <input type="date" name="checkOut" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <label for="numberPeople" class="form-label">Cantidad Personas</label>
                            <select name="numberPeople" class="form-select">
                            <option value="0" selected> - </option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>

                        </select>
                    </div>
                     <!--   <div class="col">
                            <label for="selectedRoom" class="form-label">Habitación (disponibles)</label>
                            <select name="selectedRoom" class="form-select">
                                <option value="-" selected> - </option>
                     -->
                                <!-- insertar java para obtener habitaciones -->
                                <!--
                              <%  
                                   // Controller control = new Controller();
                                   // for(Room room : control.getRoomList()){
                                   //      String roomName = room.getRoomName();
                                   //      int roomId = room.getIdRoom();

                                %> 

                                    <option value="<%= roomId %> "> <%= roomName %> </option>

                                 <% } %>

                            </select>
                        </div> 
                     -->
                </div>
                <input type = "button" value = "Atras" onclick = "history.back ()" class="btn-secondary px-4">
                <input type="submit" value="Confirmar" class="btn-primary px-4">
            </form>
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

