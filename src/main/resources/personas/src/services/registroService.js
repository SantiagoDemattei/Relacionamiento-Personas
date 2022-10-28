import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class RegistroService {
  registrar(nombre, apellido, dni, email, password) // todavia no funca ==> la request la bloquea el servidor por las politicas CORS
    {
        return axios.post(BASE_API_URL + "/registrousuario", {
            method: 'POST',
            json: {
                "persona": {
                    nombre: nombre,
                    apellido: apellido,
                    dni: dni,
                    "usuario": {
                        "nombre": email, //cambiar "nombre" a email
                        password: password
                    }
                }
            },
            url: BASE_API_URL + "/registrousuario"
        });
    }
}

export default new RegistroService();