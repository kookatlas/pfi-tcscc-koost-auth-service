package in.koost.pfi_tcscc_koost_auth_service.controller;

import in.koost.pfi_tcscc_koost_auth_service.model.UserLogin;
import in.koost.pfi_tcscc_koost_auth_service.repository.UserRepository;
import in.koost.pfi_tcscc_koost_auth_service.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public Mono<String> register(@RequestBody UserLogin user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).map(saved -> "User registered!");
    }

    @PostMapping("/login")
    public Mono<String> login(@RequestBody UserLogin loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
                .map(user -> jwtUtil.generateToken(user.getUsername()))
                .switchIfEmpty(Mono.just("Invalid credentials"));
    }

}
