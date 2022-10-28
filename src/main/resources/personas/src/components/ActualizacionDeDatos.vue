import BootstrapVue from 'bootstrap-vue/dist/bootstrap-vue.esm';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import 'bootstrap/dist/css/bootstrap.css';


<template>
<body class="bg-light">
<div class="container">
  <main>
    <nav class="nav">
      <div class="container">
        <h1 class="logo"><a href="#">RELACIONAMIENTO DE PERSONAS</a></h1>
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

    <div class="py-5 text-center">
      <h2>Actualización de datos</h2>
      <p class="lead">Actualice los datos que desee y presione el boton "Actualizar"</p>
    </div>


    <div class="contenedor">
      <div class="row g-4">
        <div class="col-md-7 col-lg-auto">
          <h4 class="mb-3">Información personal</h4>
          <form class="needs-validation" novalidate>
            <div class="row g-3">

              <div class="col-12">
                <label for="address" class="form-label">Fecha de Nacimiento</label>
                <input type="date" class="form-control" id="address" placeholder="" required>
              </div>

              <div class="col-md-6 my-2">
                <label for="country" class="form-label">Ciudad</label>
                <input type="text" class="form-control" id="country" required>
              </div>

              <div class="col-md-6 my-2">
                <label for="state" class="form-label">Localidad</label>
                <input type="text" class="form-control" id="state" required>
              </div>

              <div class="col-12">
                <label for="formFile" class="form-label">Foto</label>
                <input class="form-control-file" type="file" id="formFile">
              </div>
            </div>
            <br>
            <button class="w-100 btn btn-primary btn-lg" type="submit">Actualizar</button>
          </form>
        </div>
      </div>
    </div>
  </main>
</div>
</body>
</template>

<style>
.container {
  max-width: 960px;
}
.row{
  justify-content: center;
  transition: 1.05s;
}


.contenedor {
  width: 80%;
  margin: 0 auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  transition: 1.05s;
}

.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.b-example-divider {
  height: 3rem;
  background-color: rgba(0, 0, 0, .1);
  border: solid rgba(0, 0, 0, .15);
  border-width: 1px 0;
  box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
  flex-shrink: 0;
  width: 1.5rem;
  height: 100vh;
}

.bi {
  vertical-align: -.125em;
  fill: currentColor;
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}

body {
  background: linear-gradient(to right, rgb(223, 17, 134), rgb(31, 200, 175));
  align-items: center;
}

.nav {
  background-color: #222222;
  left: 0;
  position: fixed;
  right: 0;
  top: 0;
  justify-content: justify;
  transition: all 0.3s ease-in-out;
}

.logo{
  align-items: center;
  margin-bottom: 25px;
  justify-content: justify;
  text-align: center;
  color: white;
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
  background-color: #b3fff9;
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

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  align-items: center;
}

.container {
  margin:  auto;
  max-width: 1100px;
  align-items: center;
}
</style>

<script>

</script>