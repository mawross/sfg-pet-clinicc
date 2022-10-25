package guru.springframework.sfgpetclinic.controllers;/* 24/10/2022" "17:54" "Julian */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }
}
