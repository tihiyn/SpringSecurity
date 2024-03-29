package ru.mts.springsecurity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mts.springsecurity.models.Application;
import ru.mts.springsecurity.models.MyUser;
import ru.mts.springsecurity.services.AppService;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
public class AppController {
    private final AppService appService;


    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to unprotected page";
    }

    @GetMapping("/all-apps")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> applicationList() {
        return appService.allApplications();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application applicationById(@PathVariable int id) {
        return appService.applicationById(id);
    }

    @PostMapping("/new-user")
    public String addUser (@RequestBody MyUser user) {
        appService.addUser(user);
        return "User is saved";
    }
}
