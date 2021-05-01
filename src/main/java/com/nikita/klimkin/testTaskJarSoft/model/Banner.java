package com.nikita.klimkin.testTaskJarSoft.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banners")
public class Banner extends AbstractPersistable<Integer> {

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    @NotNull
    private Category category;

    @Column(name = "content")
    @NotBlank
    private String content;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted = false;

}
