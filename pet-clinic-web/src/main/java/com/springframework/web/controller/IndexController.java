package com.springframework.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/oups")
    public String findOwner() {
        return "notImplemented";
    }

    @RequestMapping({"","/","index","index.html"})
    public String index(){
        return "index";
    }
}
