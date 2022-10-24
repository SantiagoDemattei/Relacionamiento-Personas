package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "landingpage";
    }

    @RequestMapping("/iniciodesesion")
    String iniciodesesion() {
        return "iniciodesesion";
    }

    @RequestMapping("/registro")
     String registro() {
        return "registro";
    }
}