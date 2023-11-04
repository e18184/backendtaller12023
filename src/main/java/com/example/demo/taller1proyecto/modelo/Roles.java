// package com.example.demo.taller1proyecto.modelo;

// import java.io.Serializable;

// import java.util.List;

// import org.hibernate.annotations.Comment;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.Table;
// import jakarta.persistence.ManyToMany;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Entity
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "troles")
// @Comment("Roles que tiene un usuario")
// public class Roles implements Serializable {
// @Id
// @Column(name = "codr")
// @GeneratedValue(generator = "ROLESCODR")
// Integer codr;
// @Column(name = "nombre", length = 30)
// String nombre;

// Integer estado;

// @ManyToMany(fetch = FetchType.EAGER)
// @JsonIgnore
// @JoinTable(name = "rolesmenu", joinColumns = @JoinColumn(name = "rolesid"),
// inverseJoinColumns = @JoinColumn(name = "menusid"))
// // Set<Menus> menus = new HashSet<Menus>();
// List<Menus> menus;
// @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
// @JsonIgnore
// List<Usuarios> usuarios;

// }
