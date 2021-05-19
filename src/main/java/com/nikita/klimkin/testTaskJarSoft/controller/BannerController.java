package com.nikita.klimkin.testTaskJarSoft.controller;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.service.BannerService;
import com.nikita.klimkin.testTaskJarSoft.util.ValidationUtil;
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

@RestController()
@RequestMapping(value = BannerController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class BannerController {

    public static final String REST_URL = "api/banners";

    private BannerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Banner> create(@Valid @RequestBody Banner banner) {
        log.info("create banner {}", banner);
        Banner newBanner = service.create(banner);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uri).body(newBanner);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public void update (@Valid @RequestBody Banner banner, @PathVariable int id) {
        log.info("update banner {} with id = {}", banner, id);
        ValidationUtil.assureIdConsistent(banner, id);
        service.update(banner);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Banner getById(@PathVariable int id) {
        log.info("get banner with id={}", id);
        return service.getById(id);
    }

    @GetMapping(value = "/bid")
    public Banner get(@RequestParam String category) {
        log.info("get banner with category={}", category);
        return service.getForUser(category);
    }

    @GetMapping(value = "/all")
    public List<Banner> getAll() {
        log.info("get all banners");
        return service.getAll();
    }

    @GetMapping
    public List<Banner> getAllForUI() {
        log.info("get all not deleted banners");
        return service.getAllForUI();
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        log.info("delete banner with id={}", id);
        service.delete(id);
    }
}
