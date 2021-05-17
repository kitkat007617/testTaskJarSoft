package com.nikita.klimkin.testTaskJarSoft.controller;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.model.Request;
import com.nikita.klimkin.testTaskJarSoft.service.RequestService;
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
@RequestMapping(value = RequestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class RequestController {

    public static final String REST_URL = "api/requests";

    private RequestService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Request> create(@Valid @RequestBody Request request) {
        log.info("create request {}", request);
        Request newRequest = service.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uri).body(newRequest);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public void update (@Valid @RequestBody Request banner, @PathVariable int id) {
        log.info("update request {} with id = {}", banner, id);
        service.update(banner);
    }

    @GetMapping(value = "/{id}")
    public Request get(@PathVariable int id) {
        log.info("get request with id={}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Request> getAll() {
        log.info("get all requests");
        return service.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        log.info("delete request with id={}", id);
        service.delete(id);
    }
}
