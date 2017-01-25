package com.devops.porto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(method = RequestMethod.GET, path = "alive")
    public String alive() {
        return "Yes I am!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "hi/{param}")
    public String hi(@PathVariable String param) {
        return "Hi " + param;
    }
}
