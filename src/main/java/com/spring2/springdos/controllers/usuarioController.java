package com.spring2.springdos.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring2.springdos.model.usuario;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {

    @SuppressWarnings("FieldMayBeFinal")
    private List<usuario> usuarios = new ArrayList<>(Arrays.asList(
        new usuario(1, "Juan", "juan@example.com", "password123", "1234567890"),
        new usuario(2, "Maria", "maria@example.com", "password456", "0987654321"),
        new usuario(3, "Pedro", "pedro@example.com", "password789", "1122334455"),
        new usuario(4, "Ana", "ana@example.com", "password012", "2233445566"),
        new usuario(5, "Luis", "luis@example.com", "password345", "3344556677")
    ));

    @GetMapping
    public List<usuario> getUsuarios() {
        return usuarios;
    }

    @GetMapping("/{id}")
    public usuario getUsuario(@PathVariable String id) {
        return usuarios.stream()
                .filter(u -> u.getId() == Integer.parseInt(id))
                .findFirst()
                .orElse(null);
    }
    
    @PostMapping
    public usuario postUsuario(@RequestBody usuario user) {
        usuarios.add(user);
        return user;
    }

    @PutMapping("/{id}")
    public usuario putUsuario(@PathVariable String id, @RequestBody usuario user) {
        usuario existingUser = getUsuario(id);
        if (existingUser != null) {
            existingUser.setNombre(user.getNombre());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setNumeroTelefono(user.getNumeroTelefono());
        }
        return existingUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarios.removeIf(u -> u.getId() == Integer.parseInt(id));
    }

    @PatchMapping("/{id}")
    public usuario patchUsuario(@PathVariable String id, @RequestBody usuario user) {
        usuario existingUser = getUsuario(id);
        if (existingUser != null) {
            if (user.getNombre() != null) {
                existingUser.setNombre(user.getNombre());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            if (user.getNumeroTelefono() != null) {
                existingUser.setNumeroTelefono(user.getNumeroTelefono());
            }
        }
        return existingUser;
    }

    public void setUsuarios(List<usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
