package co.edu.unbosque.Datos;

import java.util.Objects;

public class DatosUsuario {
    private String username;
    private String password;
    private String role;

    public DatosUsuario(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username = " + username + ", password = " + password + ", role =" + role + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosUsuario usuario = (DatosUsuario) o;
        return Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password) && Objects.equals(role, usuario.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


