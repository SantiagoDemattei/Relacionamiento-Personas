<template>

  <header class="headMenu">
    <nav class="navMenu">
      <div class="containerMenu">
        <div class="logoMenu"><a href="#">RELACIONAMIENTO DE PERSONAS</a></div>
        <ul class="ulMenu">
          <li> <RouterLink to="/MenuPrincipal">Home</RouterLink> </li>
          <li> <RouterLink to="/Reporte">Reportes</RouterLink> </li>
          <li> <RouterLink to="/ActualizacionDeDatos">Actualizar datos</RouterLink></li>
          <li> <RouterLink to="/MyAutorizaciones">Autorizaciones</RouterLink> </li>
          <li> <RouterLink to="/Notificaciones">Notificaciones</RouterLink> </li>
          <li> <RouterLink to="/" @click="cerrarSesion">Cerrar sesión</RouterLink> </li>
        </ul>
      </div>
    </nav>
  </header>

  <body class="bodyReporte">

  <section class="mainReporte">
    <div class="contenedor-baseReporte">
      <h3 class="subtituloReporte">REPORTE PERSONAS</h3><br>

      <div class="tablaReporte">
        <table>
          <tr>
            <th>DNI</th>
            <th>NOMBRE</th>
            <th>APELLIDO</th>
            <th>LOCALIDAD</th>
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