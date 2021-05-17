package com.nikita.klimkin.testTaskJarSoft.controller;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.model.Category;
import com.nikita.klimkin.testTaskJarSoft.service.CategoryService;
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
@RequestMapping(value = CategoryController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class CategoryController {

    public static final String REST_URL = "api/categories";

    private CategoryService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
        log.info("create category {}", category);
        Category newCategory = service.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uri).body(newCategory);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public void update(@Valid @RequestBody Category category, @PathVariable int id) {
        log.info("update category {} with id={}", category, id);
        service.update(category);
    }

    @GetMapping(value = "/{id}")
    public Category get(@PathVariable int id) {
        log.info("get category with id={}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Category> getAll() {
        log.info("get all categories");
        return service.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        log.info("delete category with id={}", id);
        service.delete(id);
    }


}
