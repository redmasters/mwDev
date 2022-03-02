package io.red.naturassp.controller;

import io.red.naturassp.model.Usuario;
import io.red.naturassp.security.JWTToken;
import io.red.naturassp.security.JWTTokenUtil;
import io.red.naturassp.service.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("")
public class UsuarioController {
    private final IUsuarioService service;

    public UsuarioController(IUsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTToken> fazerLogin(@RequestBody Usuario dadosLogin) {
        Usuario usuario = service.recuperarUsuario(dadosLogin);
        if (usuario != null) {
            if (usuario.getSenha().equals(dadosLogin.getSenha())) {
                JWTToken jwtToken = new JWTToken();
                jwtToken.setToken(JWTTokenUtil.generateToken(usuario));
                return ResponseEntity.ok(jwtToken);
            }
            return ResponseEntity.status(403).build();

        }
        return ResponseEntity.notFound().build();

    }
}
