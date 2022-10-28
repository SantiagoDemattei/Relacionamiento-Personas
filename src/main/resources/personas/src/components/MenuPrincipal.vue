<template>
<div class="bodyMenu">
<nav class="navMenu">
  <div class="containerMenu">
    <h1 class="logoMenu"><a href="#">RELACIONAMIENTO DE PERSONAS</a></h1>
    <ul class="ulMenu">
      <li> <RouterLink to="/MenuPrincipal">Home</RouterLink> </li>
      <li> <RouterLink to="/Reporte">Reportes</RouterLink> </li>
      <li> <RouterLink to="/ActualizacionDeDatos">Actualizar datos</RouterLink></li>
      <li> <RouterLink to="/MyAutorizaciones">Autorizaciones</RouterLink> </li>
      <li> <RouterLink to="/Notificaciones">Notificaciones</RouterLink> </li>
      <li> <RouterLink to="/">Cerrar sesión</RouterLink> </li>
    </ul>
  </div>
</nav>

<div class="heroMenu">
  <div class="containerMenu2">
    <h1>B I E N V E N I D O</h1>
  </div>
</div>
</div>
</template>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  align-items: center;
}

.bodyMenu {
  background: linear-gradient(to right, rgb(223, 17, 134), rgb(31, 200, 175));
  color: rgb(0, 0, 0);
  font-family: 'Open Sans', sans-serif;
  padding-bottom: 50px;
  align-items: center;
}

.containerMenu {
  margin:  auto;
  max-width: 1200px;
  align-items: center;
}

.navMenu {
  background-color: #222222;
  left: 0;
  position: fixed;
  right: 0;
  top: 0;
  justify-content: center;
  transition: all 0.3s ease-in-out;
}

.logoMenu{
  align-items: center;
  margin-bottom: 25px;
  justify-content: center;
  text-align: center;
  color:  rgb(31, 200, 175);
}

.navMenu .ulMenu {
  align-items: center;
  display: flex;
  justify-content: space-evenly;
  list-style-type: none;
  font-size: 25px;
  flex-wrap: nowrap;
}

.navMenu a {
  align-items: center;
  color: #ffffff;
  padding: 7px 15px;
  text-decoration: none;
  transition: all 0.4s ease-in-out;
  font-weight: bold;
  font-family: Tahoma;

}

.navMenu.active {
  align-items: center;
  background-color: #b3fff9;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
}

.navMenu.active a {
  align-items: center;
  color: rgb(255, 255, 255);
}

.navMenu.active .containerMenu {
  align-items: center;
  padding: 10px 0;
}

.navMenu a.current,
.navMenu a:hover {
  align-items: center;
  color: #ffffff;
  font-weight: bold;
}

.heroMenu {
  align-items: center;
  background-position: bottom center;
  background-repeat: no-repeat;
  background-size: cover;
  color: rgb(0, 0, 0);
  display: flex;
  height: 80vh;
  margin-bottom: 90px;
  position: relative;
  text-align: center;
  z-index: -2;
  font-weight: bold;
}

.heroMenu::before {
  align-items: center;
  content: '';
  height: 100%;
  left: 0;
  position: absolute;
  top: 0;
  width: 100%;
  z-index: -1;
  background: linear-gradient(to right, rgb(223, 17, 134), rgb(31, 200, 175));
}

.heroMenu h1 {
  align-items: center;
  font-size: 100px;
  margin: -20px 0 20px;
}

.heroMenu p {
  align-items: center;
  font-size: 20px;
  letter-spacing: 1px;
}
</style>

