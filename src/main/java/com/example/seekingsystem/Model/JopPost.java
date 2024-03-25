package com.example.seekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JopPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title can't be empty!")
    @Size(min = 4, message = "length of title must be more than 4 characters!")
    @Column(columnDefinition = "varchar(50) not null") //later make sure that the check here is correct!  check(title >= 4)
    private String title;

    @NotEmpty(message = "description can't be empty!")
    @Column(columnDefinition = "varchar(255) not null")
    private String description;

    @NotEmpty(message = "location can't be empty!")
    @Column(columnDefinition = "varchar(255) not null")
    private String location;

    @NotNull(message = "salary can't be null!")
    @Positive
    @Column(columnDefinition = "double not null") //later make sure the check here is correct !  check(salary >= 0) doesn't work!
    private Double salary;

    private Date postingDate;
}
