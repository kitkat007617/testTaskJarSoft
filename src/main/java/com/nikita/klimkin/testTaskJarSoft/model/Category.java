package com.nikita.klimkin.testTaskJarSoft.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends AbstractPersistable<Integer> {

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "req_Name")
    @NotBlank
    private String requestName;

    @OneToMany(mappedBy = "category")
    @NotNull
    private List<Banner> banners;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;
}
