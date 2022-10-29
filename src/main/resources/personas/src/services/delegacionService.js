import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class delegacionService {
    autorizar(nombrePersona, dniPersona) {
        return axios.post(BASE_API_URL + "/" + localStorage.getItem('token') + "/autorizacion", {
            "dniDelegado": dniPersona
        })
    }
}

export default new delegacionService();