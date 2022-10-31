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
      <h3 class="subtituloReporte">REPORTE PERSONAS</h3><br>

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
          <tr v-for="per in personas" v-bind:key = "per.id">
            <td>{{per.dni}}</td>
            <td>{{per.nombre}}</td>
            <td>{{per.apellido}}</td>
            <td>{{per.localidad}}</td>
            <td>{{per.ciudad}}</td>
            <td>{{per.fechaNacimiento}}</td>
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
      </div><br>


      <h3 class="subtituloReporte">REPORTE DELEGACIONES</h3><br>

      <div class="tablaReporte">
        <table>
          <tr>
            <th>DELEGACIÓN</th>
            <th>DELEGADO</th>
            <th>PERMITIDO</th>
            <th>ESTADO</th>
          </tr>
          <tr v-for="del in delegaciones" v-bind:key = "del.id">
            <td>{{ del.id }}</td>
            <td>{{ del.delegado.nombre + " " + del.delegado.apellido + " " + del.delegado.dni}}</td>
            <td>{{ del.delegador.nombre + " " + del.delegador.apellido + " " + del.delegador.dni}}</td>
            <td>{{ del.estado }}</td>
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
subtituloReporte{
  font-size: 30px;
  font-weight: bold;
  color: #000000;
  text-align: center;
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
import cerrarSesionService from '../services/cerrarSesionService';
import reportesService from "../services/reportesService";

export default {
  name: 'Reporte',
  data() {
    return {
      personas: [],
      delegaciones: [],
    }
  },
  methods: {
    refreshPersonas(){
      reportesService.obtenerPersonas().then((response) => {
        console.log("PERSONAS OBTENIDAS: ")
        console.log(response.data);
        this.personas = response.data;
      });
    },
    refreshDelegaciones(){
      reportesService.obtenerDelegaciones().then((response) => {
        console.log("DELEGACIONES OBTENIDAS: ")
        console.log(response.data);
        this.delegaciones = response.data;
      });
    },
    cerrarSesion: function () {
      cerrarSesionService.cerrarSesion(localStorage.getItem('token'))
      localStorage.removeItem('token');
      window.alert('Sesión cerrada');
      this.$router.push('/')
    }
  },
  mounted: function mounted() {
    this.refreshPersonas();
    this.refreshDelegaciones();
  }
}
</script>