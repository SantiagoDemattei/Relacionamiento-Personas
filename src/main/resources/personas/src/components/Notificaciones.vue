<template>
  <header>
    <nav class="navNoti">
      <div class="containerNoti">
        <h1 class="logoNoti"><a href="#">RELACIONAMIENTO DE PERSONAS</a></h1>
        <ul>
          <li> <RouterLink to="/MenuPrincipal">Home</RouterLink> </li>
          <li> <RouterLink to="/Reporte">Reportes</RouterLink> </li>
          <li> <RouterLink to="/ActualizacionDeDatos">Actualizar datos</RouterLink></li>
          <li> <RouterLink to="/MyAutorizaciones">Autorizaciones</RouterLink> </li>
          <li> <RouterLink to="/Notificaciones">Notificaciones</RouterLink> </li>
          <li> <RouterLink to="/">Cerrar sesión</RouterLink> </li>

        </ul>
      </div>
    </nav>
  </header>

  <body>

  <section class="mainNoti">

    <div class="contenedor-baseNoti">

      <div class="notificacionesNoti">

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

bodyNoti {
  background: linear-gradient(to right, rgb(223, 17, 134), rgb(31, 200, 175));
  color: rgb(0, 0, 0);
  font-family: 'Open Sans', sans-serif;
  padding-bottom: 50px;
  align-items: center;
}

.containerNoti {
  margin: auto;
  max-width: 1200px;
  align-items: center;
}

.navNoti {
  background-color: #222222;
  left: 0;
  position: fixed;
  right: 0;
  top: 0;
  justify-content: justify;
  transition: all 0.3s ease-in-out;
}

.logoNoti {
  align-items: center;
  margin-bottom: 25px;
  justify-content: justify;
  text-align: center;
  color: rgb(31, 200, 175);
}

.navNoti ul {
  align-items: center;
  display: flex;
  justify-content: space-evenly;
  list-style-type: none;
  font-size: 25px;
  flex-wrap: row nowrap;
}

.navNoti a {
  align-items: center;
  color: #ffffff;
  padding: 7px 15px;
  text-decoration: none;
  transition: all 0.4s ease-in-out;
  font-weight: bold;
  font-family: Tahoma;

}

.navNoti.active {
  align-items: center;
  background-color: #b3fff9;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
}

.navNoti.active a {
  align-items: center;
  color: rgb(255, 255, 255);
}

.navNoti.active .container {
  align-items: center;
  padding: 10px 0;
}

.navNoti a.current,
.navNoti a:hover {
  align-items: center;
  color: #ffffff;
  font-weight: bold;
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

</script>