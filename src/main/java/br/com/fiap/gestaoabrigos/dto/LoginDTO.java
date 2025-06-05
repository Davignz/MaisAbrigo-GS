package br.com.fiap.gestaoabrigos.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "Usuário não pode ser vazio")
    private String username;

    @NotBlank(message = "Senha não pode ser vazia")
    private String password;


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}