<%-- 
    Document   : empleados
    Created on : 03-ago-2021, 16:30:30
    Author     : alanl
--%>

<%@page import="Logica.Employee"%>
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
            
        Employee employee = (Employee) request.getSession().getAttribute("employeeFound");
        request.getSession().setAttribute("employeeId", employee.getEmployeeId());
        String birthDate = (String) request.getSession().getAttribute("birthDateEmployee");

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
              <h3 class="mb-3">Empleados</h4>
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
            <form action="SvUpdateEmployee" method="POST" class="g-3">
                <div class="row mb-3">
                    <div class="col">
                        <label for="employeeName" class="form-label">Nombre</label>
                        <input type="text" name="employeeName" class="form-control" value="<%=employee.getName()%>" required="true">
                    </div>
                    <div class="col">
                        <label for="employeeLastName" class="form-label">Apellido</label>
                        <input type="text" name="employeeLastName" class="form-control" value="<%=employee.getLastName()%>" required="true">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="employeeDni" class="form-label">Nro. Documento</label>
                        <input type="text" name="employeeDni" class="form-control" value="<%=employee.getDni()%>" required="true">
                    </div>
                    <div class="col">
                        <label for="birthDate" class="form-label">Fecha Nacimiento</label>
                        <input type="date" name="birthDate" class="form-control" value="<%=birthDate%>">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="adress" class="form-label">Domicilio</label>
                        <input type="text" name="adress" class="form-control" value="<%=employee.getAdress()%>" required="true">
                    </div>
                    <div class="col">
                        <label for="workPosition" class="form-label">Cargo</label>
                        <select name="workPosition" class="form-select" required="true">
                            <option value="<%=employee.getWorkPosition()%>" required="true" selected> <%= employee.getWorkPosition()%> </option>
                            <option value="1">Recepcionista</option>
                            <option value="2">Gerente</option>

                        </select>
                    </div>

                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="username" class="form-label">Usuario</label>
                        <input type="text" name="username" class="form-control" value="<%=employee.getUser().getUserName() %>" required="true">
                    </div>
                    <div class="col">
                        <label for="password" class="form-label">Contraseña Nueva</label>
                        <input type="text" name="password" class="form-control" required="true">
                    </div>
                </div>



                <input type = "button" value = "Atras" onclick = "history.back ()" class="btn-secondary px-4">
                <input id="btnConfirmar" type="submit" value="Guardar Cambios" class="btn-primary px-4">
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