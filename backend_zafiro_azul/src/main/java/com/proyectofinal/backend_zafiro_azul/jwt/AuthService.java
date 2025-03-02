package com.proyectofinal.backend_zafiro_azul.jwt;

import com.proyectofinal.backend_zafiro_azul.model.Role;
import com.proyectofinal.backend_zafiro_azul.model.Usuario;
import com.proyectofinal.backend_zafiro_azul.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getCorreo(),
                            loginRequest.getPassword()
                    )
            );

            UserDetails user = usuarioRepository.findByCorreoUsuario(loginRequest.getCorreo())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

            String token = jwtService.getToken(user);
            return new AuthResponse(token, "Login Exitoso");

        } catch (Exception e) {
            throw new RuntimeException("Login fallido: " + e.getMessage());
        }
    }


    public AuthResponse register(RegisterRequest registerRequest) {
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        Usuario usuario = new Usuario(registerRequest.getNombreUsuario(),
                registerRequest.getCorreoUsuario(),
                registerRequest.getTelefonoUsuario(),
                encodedPassword,
                Role.USUARIO);

        usuarioRepository.save(usuario);
        return new AuthResponse(jwtService.getToken(usuario), "Registro exitoso");
    }
}

