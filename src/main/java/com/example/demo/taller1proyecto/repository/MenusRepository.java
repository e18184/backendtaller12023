// package com.example.demo.taller1proyecto.repository;

// import com.example.demo.taller1proyecto.modelo3.Menus;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

// public interface MenusRepository extends JpaRepository<Menus, Long> {

// // @Query ("SELECT DISTINCT m FROM Menus m JOIN m.roles r JOIN r.usuarios u"
// +
// // "WHERE u.login = ?1 AND u.password = ?2")
// @Query("SELECT DISTINCT m FROM Menus m JOIN m.roles r JOIN r.usuarios u WHERE
// u.login = ?1 AND u.password = ?2 AND r.codr = ?3")
// List<Menus> findByLoginAndPassword(String login, String password, Long
// idrol);

// }
