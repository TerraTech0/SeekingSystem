package com.example.seekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be empty!")
    @Size(min = 4, message = "length must be more than 4 characters!")
    @Pattern(regexp = "[a-zA-Z]+", message = "name must contain only on characters!")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;

    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "password can't be empty!")
    @Column(columnDefinition = "varchar(255) not null")
    private String password;

    @NotNull(message = "age can't be null!")
    @Min(value = 21, message = "the age must be more than 21!")
    @Column(columnDefinition = "int not null check (age>=21)")
    private Integer age;

    @NotEmpty(message = "role can't be empty!")
    @Pattern(regexp = "^(job_seeker|employer)$", message = "role must be either 'job_seeker' or 'employer'!")
    @Column(columnDefinition = "varchar(15) not null check(role = 'job_seeker' or role = 'employer')")
    private String role;
}
