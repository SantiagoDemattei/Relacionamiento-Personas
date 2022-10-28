<template>
  <h1>Inicio de Sesión</h1>
  <form class="IniciodeSesión" @submit.prevent="handleLogin">
    <label for="email">Email</label>
    <input type="email" name="email" id="email" v-model="email"><br>
    <br>
    <label for="password">Contraseña</label>
    <input type="password" name="password" id="password" v-model="password"><br>
    <br>
    <input class="loginbtn" type="submit" value="Iniciar Sesión">

  </form>
</template>

<style>

h1 {
  text-align: center;
  transition: 1.05s;
}

.IniciodeSesión {
  width: 50%;
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
  transition: 1.05s;
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
.loginbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
  font-size: 20px;
}

.loginbtn:hover {
  opacity:1;
}

/* Para el color gris de los formularios */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>

<script>
import loginService from '../services/loginService';

export default{

  data() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {

    handleLogin() {
      // TODO: VER SI HAY QUE HACER ALGUNA VALIDACION
        console.log(this.email);
        console.log(this.password);

        loginService.logear(this.email, this.password)
            .then(response => {
              console.log(response);
              window.alert('Inicio de Sesion exitoso, redireccionando al Menu Principal');
              this.$router.push('/MenuPrincipal');
            })
            .catch(error => {
              console.log(error);
            });
      }
    }
}
</script>