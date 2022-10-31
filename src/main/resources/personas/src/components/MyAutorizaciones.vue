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

  <body class="bodyAutorizaciones">

  <section class="mainAutorizaciones">

    <div class="delegacionAutorizaciones">
      <div class="delegacion-texto">
        <p class="subtituloAutorizaciones">REALIZAR DELEGACIÓN</p>
        <form class="formDelegacion" @submit.capture="handleDelegacion">
          <label for="email">Persona a autorizar</label>
          <input type="email" name="email" id="email" v-model="nombrePersona"><br>
          <br>
          <label for="dni">DNI</label>
          <input type="text" name="text" id="text" v-model="dniPersona"><br>
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
import delegacionService from '../services/delegacionService';
import cerrarSesionService from "@/services/cerrarSesionService";

export default{

  data() {
    return {
      nombrePersona: '',
      dniPersona: '',
    }
  },
  methods: {

    handleDelegacion() {
      delegacionService.autorizar(this.nombrePersona, this.dniPersona)
          .then(response => {
            console.log(response);
            window.alert('Delegación realizada');
          })
          .catch(error => {
            console.log(error);
            window.alert('Error al realizar la delegación');
          });
    },
    cerrarSesion: function () {
      cerrarSesionService.cerrarSesion(localStorage.getItem('token'))
      localStorage.removeItem('token');
      window.alert('Sesión cerrada');
      this.$router.push('/')
    }
  }
}
</script>