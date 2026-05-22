package br.com.seuespacounb.turing.config;

public record JWTUserData(
        Long userId,
        String email,
        String role
) {
}