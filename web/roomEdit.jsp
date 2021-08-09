<%@page import="Logica.Room"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="./assets/css/styles.css">
    <title>Modificar Habitación</title>
</head>
<body class="container">   
    
    <%
        HttpSession mySession = request.getSession();
        
        String userLogin = (String) mySession.getAttribute("jspUser");
        
        if (userLogin == null){
            response.sendRedirect("login.jsp");
        } else { 
            
        Room room = (Room) request.getSession().getAttribute("roomFound");
        request.getSession().setAttribute("roomId", room.getIdRoom());
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
              <h3 class="mb-3">Habitaciones</h3>
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
              <a class="nav-link" href="reservationCheckDate.jsp">Reservas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="rooms.jsp">Habitaciones</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="employee.jsp">Empleados</a>
            </li>
            
            <li>
                <a class="nav-link" href="guestList.jsp">Lista de Huéspedes </a>
            </li>
          </ul>
        </div>
    </nav> 
        
    <p><%= room.getIdRoom()%></p>
    <main>
        <div class="mx-auto">
            <form action="SvUpdateRoom" method="POST" class="g-3">
                <div class="row mb-3">
                    <div class="col">
                        <label for="roomName" class="form-label">Nombre Habitación:</label>
                        <input type="text" name="roomName" class="form-control" value="<%= room.getRoomName() %>" required="true">
                    </div>
                    <div class="col">
                        <label for="roomNumber" class="form-label">Número de Habitación:</label>
                        <input type="number" name="roomNumber" class="form-control" value="<%=room.getRoomNumber()%>" required="true">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <label for="hotelFloor" class="form-label">Número de Piso:</label>
                        
                        <select name="hotelFloor" class="form-select" required="true">
                            
                            <option value="<%=room.getHotelFloor()%>" selected> <%=room.getHotelFloor()%>  </option>
                            <option value="1">1° Piso</option>
                            <option value="2">2° Piso</option>
                            <option value="3">3° Piso</option>
                            <option value="4">4° Piso</option>
                            <option value="5">5° Piso</option>
                            <option value="6">6° Piso</option>
                            <option value="7">7° Piso</option>
                            <option value="8">8° Piso</option>
                            <option value="9">9° Piso</option>
                            <option value="10">10° Piso</option>
                        </select>
                    </div>

                    <div class="col">
                        <label for="roomType" class="form-label">Tipo de Habitación:</label>
                        <select name="roomType" class="form-select" required="true">
                            <option value="<%=room.getRoomType()%>" selected > <%=room.getRoomType()%> </option>
                            <option value="single">Single</option>
                            <option value="doble">Doble</option>
                            <option value="triple">Triple</option>
                            <option value="max">Max (6 personas)</option>
                        </select>
                    </div>

                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="roomPrice" class="form-label">Precio:</label>
                        <input type="number" name="roomPrice" class="form-control" required="true" value="<%=room.getRoomPrice()%>">
                    </div>
                </div>

                
                <input type="submit" value="Enviar" class="btn-primary px-4">
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


