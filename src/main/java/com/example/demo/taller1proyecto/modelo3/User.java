package com.example.demo.taller1proyecto.modelo3;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@org.hibernate.annotations.Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String status;

}