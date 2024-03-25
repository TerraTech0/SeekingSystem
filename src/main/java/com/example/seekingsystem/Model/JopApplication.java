package com.example.seekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JopApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "user id can't be null!")
    @Column(columnDefinition = "int not null")
    private Integer user_id;

    @NotNull(message = "job post id can't be null!")
    @Column(columnDefinition = "int not null")
    private Integer jop_post_id;
}
