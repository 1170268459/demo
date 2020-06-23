package com.xg.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/single")
    public String SinglePage(){
        return "single";
    }
    @GetMapping("gaode")
    public String gaode(){
        return "gaode";
    }
    @GetMapping("/gohotel")
    public String GoHotel(){
        return "Hotel/Hotel";
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
