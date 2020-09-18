package com.xg.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("gaode")
    public String gaode(){
        return "gaode";
    }

    @GetMapping("index")
    public String Index(){
        return "index";
    }

    @GetMapping("/gologin")
    public String goLogin(){
        return "login";
    }
}
