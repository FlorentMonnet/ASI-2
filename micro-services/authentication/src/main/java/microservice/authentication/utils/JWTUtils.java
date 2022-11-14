package microservice.authentication.utils;

import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTUtils {
	private static SecretKey signingKey =  Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	//Sample method to construct a JWT
	public static String createJWT(String subject, Map<String, Object> claims) {
	 
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	    
	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setClaims(claims)
	    								   .setSubject(subject)
	    								   .signWith(signingKey, signatureAlgorithm);
	 
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	

	//Sample method to validate and read the JWT
	public static Claims parseJWT(String jwt) {
	 
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parserBuilder().setSigningKey(signingKey)
	    									.build()         
									        .parseClaimsJws(jwt)
									        .getBody();
	    return claims;
	}

}
