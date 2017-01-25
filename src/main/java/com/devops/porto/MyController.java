package com.devops.porto;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    private MyRunner runner;

    @RequestMapping(method = RequestMethod.GET, path = "alive")
    public String alive() {
        return "Yes I am!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "hi/{param}")
    public String hi(@PathVariable String param) {
        return "Hi " + param;
    }

    @Retryable(value = RuntimeException.class, maxAttempts = 5)
    @RequestMapping(method = RequestMethod.GET, path = "run")
    public boolean run() {
        return runner.run();
    }

    @Recover
    public boolean recover(RuntimeException e) {
        return false;
    }
}
