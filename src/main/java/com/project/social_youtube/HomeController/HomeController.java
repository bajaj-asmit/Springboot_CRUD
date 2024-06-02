package com.project.social_youtube.HomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home()
    {
        return "<a href='www.google.com' target='_blank' >click me</a>";
    }
    @GetMapping("/home")
    public String home2()
    {
        return "<h2>this is homepage 2</h2>";
    }
}
