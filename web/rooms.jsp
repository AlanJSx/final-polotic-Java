<%-- 
    Document   : habitaciones
    Created on : 03-ago-2021, 13:25:25
    Author     : alanl
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carga de habitacion</h1>
<main>
        <div class="mx-auto">
            <form action="SvNewRoom" method="POST" class="g-3">
                <div class="row mb-3">
                    <div class="col">
                        <label for="roomName" class="form-label">Nombre Habitación</label>
                        <input type="text" name="roomName" class="form-control">
                    </div>
                    <div class="col">
                        <label for="roomNumber" class="form-label">Número de Habitación</label>
                        <input type="number" name="roomNumber" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <label for="hotelFloor" class="form-label">Número de Piso</label>
                        <select name="hotelFloor" class="form-select">
                            <option value="0" selected> - </option>
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
                        <label for="roomType" class="form-label">Tipo de Habitación</label>
                        <select name="roomType" class="form-select">
                            <option value="0" selected> - </option>
                            <option value="single">Single</option>
                            <option value="doble">Doble</option>
                            <option value="triple">Triple</option>
                            <option value="max">Max (6 personas)</option>
                        </select>
                    </div>

                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="roomPrice" class="form-label">Precio</label>
                        <input type="number" name="roomPrice" class="form-control">
                    </div>
                </div>

                
                <input type="submit" value="Enviar" class="btn-primary px-4">
            </form>
        </div>
    </main>        
        
    </body>
</html>
