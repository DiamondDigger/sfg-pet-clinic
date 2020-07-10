package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StubController {

    @RequestMapping("/oups")
    public String oupsMapping(){
        return "notImplemented";
    }

}
