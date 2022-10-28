<template>
  <body class="bodyReporte">
  <nav class="navReporte">
    <div class="containerReporte">
      <h1 class="logoReporte"><a href="#">RELACIONAMIENTO DE PERSONAS</a></h1>
      <ul>
        <li><a href="menuprincipal.html" class="current">Home</a></li>
        <li><a href="reporte.html">Reportes</a></li>
        <li><a href="actualizaciondedatos.html" class="actu">Actualizar datos</a></li>
        <li><a href="autorizaciones.html">Autorizaciones</a></li>
        <li><a href="notificaciones.html">Notificaciones</a></li>
        <li><a href="index.html">Cerrar Sesion</a></li>
      </ul>
    </div>
  </nav>

  <section class="mainReporte">
    <div class="contenedor-baseReporte">
      <h3 class="subtituloReporte">REPORTE PERSONAS</h3>

      <div class="tablaReporte">
        <table>
          <tr>
            <th>DNI</th>
            <th>NOMBRE</th>
            <th>APELLIDO</th>
            <th>PROVINCIA</th>
            <th>CIUDAD</th>
            <th>FECHA DE NACIMIENTO</th>
          </tr>
          <tr>
            <td>0000001</td>
            <td>Nombre 1</td>
            <td>Apellido 1</td>
            <td>C.A.B.A.</td>
            <td>Loca1</td>
            <td>mm/dd/aaaa</td>
          </tr>
          <tr>
            <td>0000002</td>
            <td>Persona 3</td>
            <td>Persona 4</td>
            <td>C.A.B.A.</td>
            <td>Loca2</td>
            <td>mm/dd/aaaa</td>
          </tr>
        </table>
      </div>


      <h3 class="subtituloReporte">REPORTE DELEGACIONES</h3>

      <div class="tablaReporte">
        <table>
          <tr>
            <th>DELEGACIÓN</th>
            <th>DELEGADO</th>
            <th>PERMITIDO</th>
            <th>ESTADO</th>
          </tr>
          <tr>
            <td>0000001</td>
            <td>Persona 1</td>
            <td>Persona 2</td>
            <td>Pendiente</td>
          </tr>
          <tr>
            <td>0000002</td>
            <td>Persona 3</td>
            <td>Persona 4</td>
            <td>Pendiente</td>
          </tr>
        </table>
      </div>

    </div>
  </section>

  </body>
</template>

<style>
.nav {
  background-color: #222222;
  left: 0;
  position: fixed;
  right: 0;
  top: 0;
  justify-content: justify;
  transition: all 0.3s ease-in-out;
}

.logo {
  align-items: center;
  margin-bottom: 25px;
  justify-content: justify;
  text-align: center;
  color: rgb(27, 16, 16);
}

.nav ul {
  align-items: center;
  display: flex;
  justify-content: space-between;
  list-style-type: none;
  font-size: 25px;
  flex-wrap: row nowrap;
}

.nav a {
  align-items: center;
  color: #ffffff;
  text-decoration: none;
  transition: all 0.4s ease-in-out;
  font-weight: bold;
  font-family: Tahoma;
}

.nav.active {
  align-items: center;
  background-color: rgb(199, 199, 199);
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
}

.nav.active a {
  align-items: center;
  color: rgb(255, 255, 255);
}

.nav.active .container {
  align-items: center;
  padding: 10px 0;
}

.nav a.current,
.nav a:hover {
  align-items: center;
  color: #ffffff;
  font-weight: bold;
}

.container {
  margin: auto;
  max-width: 1100px;
  align-items: center;
}

table {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  border-collapse: collapse;
  width: 100%;
  font-size: 20px;
}

.main {
  margin-top: 12rem;
}

td,
th {
  border: 3px solid rgb(0, 0, 0);
  text-align: center;
  padding: 3px;
}

body {
  background: linear-gradient(to right, rgb(223, 17, 134), rgb(31, 200, 175));
  font-family: 'Open Sans', sans-serif;
  padding-bottom: 50px;
  align-items: center;
  font-size: 25px;
}
</style>

<script>

</script>