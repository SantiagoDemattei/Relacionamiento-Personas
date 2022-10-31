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

  <body>

  <section class="mainNoti">

    <div class="contenedor-baseNoti">

      <div class="notificacionesNoti">
        <table class = "notiTable" >

          <thead> <!-- Encabezado de la tabla -->
          <tr>
              <th>ID delegacion</th>
              <th>Delegado</th>
              <th>Delegador</th>
              <th>Aceptar o Rechazar</th>
            </tr>
          </thead>

          <tbody>
          <tr v-for="noti in notificaciones" v-bind:key = "noti.delegacionId">
            <td>{{noti.delegacion_id}}</td>
            <td>{{noti.delegado.nombre + " " + noti.delegado.apellido + " " + noti.delegado.dni}}</td>
            <td>{{noti.delegador.nombre + " " + noti.delegador.apellido + " " + noti.delegador.dni}}</td>
            <td>
              <div class="botonesNoti">
                <button class="botonAceptarNoti" type="button" @click="aceptarDelegacion(noti.delegacion_id)">Aceptar</button>
                <button class="botonRechazarNoti" type="button" @click="rechazarDelegacion(noti.delegacion_id)">Rechazar</button>
              </div>
            </td> <!-- Botones para aceptar o rechazar -->
          </tr>
          </tbody>
        </table>
      <!--
        <div class="notif-delegacion-recibidaNoti">
          <div class="texto-simpleNoti">
            <p>Delegación recibida por parte de Persona X</p>
            <p>DNI: 00000000</p>
          </div>
          <br>
          <div class="botonesNoti">
            <button class="botonAceptarNoti" type="button">Aceptar</button>
            <button class="botonRechazarNoti" type="button">Rechazar</button>
          </div>
        </div>
        <br>
        <div class="delegacion-rechazadaNoti">
          <div class="texto-simpleNoti">
            <p>Delagación rechazada por parte de Persona X</p>
            <p>DNI: 00000000</p>
          </div>
        </div>
        <br>
        <div class="notif-delegacion-recibidaNoti">
          <div class="texto-simpleNoti">
            <p>Delegación recibida por parte de Persona X</p>
            <p>DNI: 00000000</p>
          </div>
          <br>
          <div class="botonesNoti">
            <button class="botonAceptarNoti" type="button">Aceptar</button>
            <button class="botonRechazar texto-boton2Noti" type="button">Rechazar</button>
          </div>
        </div>
      -->
      </div>

    </div>

  </section>

  </body>

</template>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  align-items: center;
}

.notificacionesNoti {
  margin-top: 8rem;
  font-size: 20px;
  /*center text*/
  text-align: center;
}

.botonesNoti {
  display: flex;
  justify-content: center;
  align-items: center;
  /*separar los items del flex*/
  gap: 2rem;
}

.botonAceptarNoti {
  background-color: green;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
  opacity: 0.9;
  font-size: 20px;
}

.botonRechazarNoti{
  background-color: red;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
  opacity: 0.9;
  font-size: 20px;
}
</style>

<script>
import notificacionesService from '../services/notificacionesService';
import cerrarSesionService from "@/services/cerrarSesionService";

export default {
  name: 'Notificaciones',
  data() {
    return {
      notificaciones: [],
    };
  },
  methods: {
    refreshNotificaciones() {
        notificacionesService.obtenerNotificaciones().then(response => {
          this.notificaciones = response.data;
        });
     },
     cerrarSesion: function () {
        cerrarSesionService.cerrarSesion(localStorage.getItem('token'))
        localStorage.removeItem('token');
        window.alert('Sesión cerrada');
        this.$router.push('/')
    },
    aceptarDelegacion: function aceptarDelegacion(idDelegacion) {
      notificacionesService.aceptar(idDelegacion).then(response => {
        if(response.status == 200) {
          this.refreshNotificaciones();
        } else{
          window.alert('Error al aceptar la delegación');
          this.refreshNotificaciones();
        }
      });
    },
    rechazarDelegacion: function rechazarDelegacion(idDelegacion) {
      notificacionesService.rechazar(idDelegacion).then(response => {
        if(response.status == 200) {
          this.refreshNotificaciones();
        } else{
          window.alert('Error al rechazar la delegación');
          this.refreshNotificaciones();
        }
      });
    }
  },
  mounted: function mounted() { // para que se ejecute cuando se carga la pagina de notificaciones
    this.refreshNotificaciones();
  }
}

</script>