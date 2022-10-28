import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class RegistroService {
  registrar(nombre, apellido, dni, email, password)
    {
        console.log(nombre + apellido + dni + email + password)
        return axios.post(BASE_API_URL + "/registrousuario", {
                "nombre": nombre,
                "apellido": apellido,
                "dni": dni,
                "usuario": {
                    "nombre": email,
                    "password": password
                }
        });
    }
}

export default new RegistroService();