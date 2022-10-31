import axios from "axios";

const BASE_API_URL = "http://localhost:8088"; // que es en donde esta levantado spring (tomcat)

class actualizarDatosService {
    actualizarDatos(nacimiento, ciudad, localidad, foto) {
        return axios.put(BASE_API_URL + "/" + localStorage.getItem('token') + "/actualizardatos", {
            "fechaNacimiento" : nacimiento,
            "ciudad" : ciudad,
            "localidad" : localidad,
            "foto" : foto
        })
    }
}

export default new actualizarDatosService();