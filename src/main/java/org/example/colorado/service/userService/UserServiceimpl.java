package org.example.colorado.service.userService;

import lombok.RequiredArgsConstructor;
import org.example.colorado.entity.Users;
import org.example.colorado.repository.UsersRepository;
import org.example.colorado.service.JWTUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Users user = usersRepository.findByName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

            return jwtUtils.generateToken(user);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("Invalid username/password supplied") {
            };
        }
    }
}
