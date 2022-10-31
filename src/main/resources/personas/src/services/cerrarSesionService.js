import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class cerrarSesionService {
    cerrarSesion(token) {
        return axios.post(BASE_API_URL + "/" + token + "/logout", {})
    }
}

export default new cerrarSesionService();