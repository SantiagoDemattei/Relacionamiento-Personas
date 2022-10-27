<template>
  <h1>Registro</h1>
  <form class="registro" @submit.prevent="handleSubmit">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" v-model="nombre"><br>

    <label for="apellido">Apellido</label>
    <input type="text" name="apellido" id="apellido" v-model="apellido"><br>

    <label for="dni">Dni</label>
    <input type="text" name="dni" id="dni" v-model="dni"><br>

    <label for="email">Email</label>
    <input type="email" name="email" id="email" v-model="email"><br>

    <label for="password">Contraseña</label>
    <input type="password" name="password" id="password" v-model="password"><br>

    <label for="password2">Repetir contraseña</label>
    <input type="password" name="password2" id="password2" v-model="password2"><br>

    <input class="registerbtn" type="submit" value="Registrarse">

  </form>
</template>

<style>
body {
  background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}

h1 {
  text-align: center;
  transition: 1.05s;
}

.registro {
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

/* boton "Registrarse" */
.registerbtn {
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

.registerbtn:hover {
  opacity:1;
}

/* Para el color gris de los formularios */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>

<script>
export default{

  data() {
    return {
      nombre: '',
      apellido: '',
      dni: '',
      email: '',
      password: '',
      password2: ''
    }
  },
  methods: {

    handleSubmit() {
      //ACA AGREGAS TODAS LAS VALIDACIONES QUE QUIERAS:
      this.passwordError = this.password.length > 6 ?
          '' : 'La contraseña debe tener al menos 6 caracteres';

      this.equalPasswordError = this.password === this.password2 ?
          '' : window.alert('Las contraseñas no coinciden');

      if(!this.passwordError && !this.equalPasswordError) {
        console.log(this.nombre);
        console.log(this.apellido);
        console.log(this.dni);
        console.log(this.email);
        console.log(this.password);
        console.log(this.password2);
        // VALIDAR PRIMERO QUE LA PERSONA ESTE DENTRO DEL personas.json
        window.alert('Registro exitoso, redireccionando a Inicio de Sesión');
        this.$router.push('/login');
        window.location.href = 'http://localhost:8080/InicioDeSesion';


      }
    }
  }

}
</script>