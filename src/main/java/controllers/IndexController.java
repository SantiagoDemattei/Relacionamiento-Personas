package controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping("/")
    public String landingPage(){
        return "landingPage";
    }
}
    /*
    @GetMapping(value = "/mascotas", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
    public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {

    

        //validar accion en capa modelo según roles o usuario asociados al idSesion
        Template template = handlebars.compile("/templates/index");
        List<Mascota> mascotas = repoMascotas.obtenerTodas();

        Map<String, Object> model = new HashMap<>();
        model.put("listamascotas", mascotas);

        String html = template.apply(model);
    }
    */
