import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class reportesService {
    obtenerPersonas(){
        const token = localStorage.getItem("token");
        return axios.get(BASE_API_URL + "/" + token + "/reportepersonas");
    }

    obtenerDelegaciones(){
        const token = localStorage.getItem("token");
        return axios.get(BASE_API_URL + "/" + token + "/reportedelegaciones");
    }
}

export default new reportesService();