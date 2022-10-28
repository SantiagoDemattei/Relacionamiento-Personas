import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class LoginService {
    logear(mail, password) // todavia no funca ==> la request la bloquea el servidor por las politicas CORS
    {
        return axios.post(BASE_API_URL + "/logeousuario", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization: 'Bearer ' + localStorage.getItem('token')
            },
            json: {
                "usuario": {
                    "nombre": mail, //cambiar "nombre" a email
                    password: password
                }
            },
            url: BASE_API_URL + "/logeousuario"
        });
    }
}

export default new LoginService();