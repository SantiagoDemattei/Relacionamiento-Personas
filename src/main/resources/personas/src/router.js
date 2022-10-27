import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "./components/LandingPage.vue"
import Registro from "./components/Registro.vue"
import InicioDeSesion from "./components/InicioDeSesion.vue"
import Notificaciones from "./components/Notificaciones.vue"
import MenuPrincipal from "./components/MenuPrincipal.vue"
import MyAutorizaciones from "./components/MyAutorizaciones.vue"
import Reporte from "./components/Reporte.vue"
import ActualizacionDeDatos from "./components/ActualizacionDeDatos.vue"

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            name: "LandingPage",
            component: LandingPage
        },
        {
            path: "/Registro",
            name: "Registro",
            component: Registro
        },
        {
            path: "/InicioDeSesion",
            name: "InicioDeSesion",
            component: InicioDeSesion
        },
        {
            path: "/Notificaciones",
            name: "Notificaciones",
            component: Notificaciones
        },
        {
            path: "/MenuPrincipal",
            name: "MenuPrincipal",
            component: MenuPrincipal
        },
        {
            path: "/MyAutorizaciones",
            name: "MyAutorizaciones",
            component: MyAutorizaciones
        },
        {
            path: "/Reporte",
            name: "Reporte",
            component: Reporte
        },
        {
            path: "/ActualizacionDeDatos",
            name: "ActualizacionDeDatos",
            component: ActualizacionDeDatos
        },
    ]
});

export default router;