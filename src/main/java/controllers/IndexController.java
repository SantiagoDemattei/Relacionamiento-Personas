package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    String landingpage(){
        return "index";
    }

    @RequestMapping("/registro")
    String registro(){
        return "registro";
    }

}