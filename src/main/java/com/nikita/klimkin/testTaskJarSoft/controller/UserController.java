package com.nikita.klimkin.testTaskJarSoft.controller;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.model.User;
import com.nikita.klimkin.testTaskJarSoft.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class UserController {

    public static final String REST_URL = "api/users";
    private UserService service;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        log.info("create user {}", user);
        User newUser = service.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public void update (@Valid @RequestBody User user, @PathVariable int id) {
        log.info("update user {} with id = {}", user, id);
        service.update(user);
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable int id) {
        log.info("get user with id={}", id);
        return service.get(id);
    }

    @GetMapping
    public List<User> getAll() {
        log.info("get all users");
        return service.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        log.info("delete user with id={}", id);
        service.delete(id);
    }
}
