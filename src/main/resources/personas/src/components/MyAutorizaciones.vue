<template>
  <body class="bodyAutorizaciones">

  <header>
    <nav class="navAutorizaciones">
      <div class="containerAutorizaciones">
        <h1 class="logo"><a href="#">RELACIONAMIENTO DE PERSONAS</a></h1>
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
  </header>

  <section class="mainAutorizaciones">

    <div class="delegacionAutorizaciones">
      <div class="delegacion-texto">
        <p class="subtituloAutorizaciones">REALIZAR DELEGACIÓN</p>
        <form class="formDelegacion">
          <label for="email">Persona a autorizar</label>
          <input type="email" name="email" id="email"><br>
          <br>
          <label for="dni">DNI</label>
          <input type="text" name="text" id="text"><br>
          <br>
          <input class="autorizarbtn" type="submit" value="Autorizar">

        </form>
      </div>
    </div>
  </section>

  </body>
</template>

<style>
.subtituloAutorizaciones {
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-style: normal;
  font-weight: normal;
  font-size: 70px;
  text-align: right;
  margin-bottom: 40px;
  margin-top: 50px;
}

/* HEADER */

.navAutorizaciones {
  background-color: #222222;
  left: 0;
  position: fixed;
  right: 0;
  top: 0;
  transition: all 0.3s ease-in-out;
}

.logo{
  align-items: center;
  margin-bottom: 25px;
  justify-content: justify;
  text-align: center;
  color: white;
}

.navAutorizaciones ul {
  align-items: center;
  display: flex;
  justify-content: space-between;
  list-style-type: none;
  font-size: 25px;
  flex-wrap: row nowrap;
}

.navAutorizaciones a {
  align-items: center;
  color: #ffffff;
  text-decoration: none;
  transition: all 0.4s ease-in-out;
  font-weight: bold;
  font-family: Tahoma;
}

.navAutorizaciones.active {
  align-items: center;
  background-color: #b3fff9;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
}

.navAutorizaciones.active a {
  align-items: center;
  color: rgb(255, 255, 255);
}

.navAutorizaciones.active .container {
  align-items: center;
  padding: 10px 0;
}

.navAutorizaciones a.current,
.navAutorizaciones a:hover {
  align-items: center;
  color: #ffffff;
  font-weight: bold;
}

.containerAutorizaciones {
  margin:  auto;
  max-width: 1100px;
  align-items: center;
}

.mainAutorizaciones {
  margin-top: 5rem;
  align-items: center;
}

.delegacionAutorizaciones {
  display: flex;
  padding: 50px 50px 50px 50px;
  justify-content: center;
}


.delegacionAutorizaciones .delegacion-texto .contenedor-input-botones .contenedor-input .input{
  margin-top: 10px;
  display: flex;
  float: right;
}

.delegacionAutorizaciones .delegacion-texto .contenedor-input-botones .contenedor-input .input-completo {
  background: #FFFFFF;
  border: 4px solid #AEC4E1;
  box-sizing: border-box;
  border-radius: 12px;
  font-size: 25px;
  margin-left: 10px;
}

.delegacionAutorizaciones .delegacion-texto .contenedor-input-botones .contenedor-input .botones {
  display: flex;
  margin-top: 70px;
  margin-left: 70px;
}

.formDelegacion {
  width: 70%;
  margin: 0 auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  transition: all 1.05s;
}

* {
  box-sizing: border-box;
  font-family: 'Open Sans', sans-serif;
}

/*espacios para completar*/
input[type=text], input[type=password], input[type=email] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus, input[type=email]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* boton "Iniciar Sesión" */
.autorizarbtn {
  background-color: #000000;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
  font-size: 20px;
}

.autorizarbtn:hover {
  opacity:1;
}

/* Para el color gris de los formularios */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}

/* fondo*/
body {
  background: linear-gradient(to right, rgb(223, 17, 134), rgb(31, 200, 175));
  transition: 0.9s;
}
</style>

<script>

</script>