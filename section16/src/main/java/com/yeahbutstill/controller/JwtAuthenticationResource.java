package com.yeahbutstill.controller;

import com.yeahbutstill.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.stream.Collectors;

//@RestController
//@RequestMapping(value = "/api/v1")
public class JwtAuthenticationResource {

    private final JwtEncoder jwtEncoder;

    @Autowired
    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping(path = "/authenticate")
    public JwtResponse authenticate(Authentication authentication) {
        return new JwtResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60L * 30L))
                .subject(authentication.getName())
                .claim("scope", createScope(authentication))
                .build();

        JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);

        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(" "));
    }

}
