package com.nikita.klimkin.testTaskJarSoft.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "requests")
public class Request extends AbstractPersistable<Integer> {

    @OneToOne
    @JoinColumn(name = "banner_id")
    @NotNull
    private Banner banner;

    @Column(name = "user_agent")
    @NotBlank
    private String userAgent;

    @Column(name = "ip_address")
    @NotBlank
    private String ipAddress;

    @Column(name = "date_time")
    @NotNull
    private LocalDateTime dateTime = LocalDateTime.now();

}
