package br.com.condominium.config;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    //Singning key for HS512 algorithm
    //You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
    public static final String JWT_SECRET = "WmYq3t6w9z$C&F)J@NcRfUjXn2r4u7x!A%D*G-KaPdSgVkYp3s6v8y/B?E(H+MbQ";

    //JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER= "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
}
