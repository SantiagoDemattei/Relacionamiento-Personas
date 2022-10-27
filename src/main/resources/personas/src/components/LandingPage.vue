
<template>
  <body>
  <h1 class="titulo-principal">BIENVENIDO</h1>
  <form class="menu">
    <div class="contenedor-base">
      <div class="opciones">
          <RouterLink class="button" type="button" value="registro" to="/Registro">Registro</RouterLink>
        <br>
        <RouterLink class="button" type="button" value="iniciodesesion" to="/InicioDeSesion">Inicio De Sesion</RouterLink>

      </div>
    </div>
  </form>
  </body>
</template>

<style>

body {
  background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}

.menu {
  width: 50%;
  margin: 0 auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  transition: 0.5s;
}

h1{
  text-align: center;
  color: #FFF;
  font-size: 40px;
  text-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  transition: 0.5s;
  padding-top: 250px;
}

.button {
  display: block;
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  border: none;
  border-radius: 5px;
  background-color: #04AA6D;
  color: #FFFFFF;
  font-size: 20px;
  font-family: 'Open Sans', sans-serif;
  cursor: pointer;
  transition: 0.5s;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
  text-align: center;
  text-decoration: none;
}

.button:hover{
  background-color: #fff;
  color: #000;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}
</style>