package com.carwash.loginRegister.resource;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenGenerator {
	
	public static String getToken(String email, String password, String name) {
		
		
		Instant now = Instant.now();
		byte[] secret = Base64.getDecoder().decode("hju3HkCU7o+v+GQRxd8tdzIW3rWVJYN790zZMbqzzxc=");
		
		return Jwts.builder()
		.setSubject("carWashApplication")
		.claim("email", email)
		.claim("password", password)
		.claim("name", name)
		.setAudience("Everyone")
		.claim("1d20", new Random().nextInt(20) +1)
		.setIssuedAt(Date.from(now))
		.setExpiration(Date.from(now.plus(10, ChronoUnit.MINUTES)))
		.signWith(Keys.hmacShaKeyFor(secret))
		.compact();
	}

}
