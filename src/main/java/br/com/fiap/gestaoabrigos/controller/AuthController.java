package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.dto.LoginDTO;
import br.com.fiap.gestaoabrigos.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        // Exemplo didático: usuário/senha hardcoded.
        // Em projeto real, consulte o banco de dados!
        if ("admin".equals(loginDTO.getUsername()) && "admin".equals(loginDTO.getPassword())) {
            String token = jwtUtil.generateToken(loginDTO.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos!");
    }
}