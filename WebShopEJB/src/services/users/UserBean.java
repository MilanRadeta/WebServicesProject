package services.users;

import java.util.Arrays;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import model.users.User;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;

@Stateless
@LocalBean
@Path("/users")
public class UserBean implements UserBeanRemote {
	
	@Override
	public Response login(User user) {
		if (user.getUsername() != null && user.getUsername().length() > 0
				&& user.getPassword() != null
				&& user.getPassword().length() > 0) {
			if (user.getUsername().equals("test") && user.getPassword().equals("test")) {
				RsaJsonWebKey senderJwk = null;
				try {
					senderJwk = RsaJwkGenerator.generateJwk(2048);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JwtClaims claims = new JwtClaims();
				claims.setIssuer("webshop");
				claims.setExpirationTimeMinutesInTheFuture(10);
				claims.setGeneratedJwtId();
				claims.setIssuedAtToNow();
				claims.setNotBeforeMinutesInThePast(2);
				claims.setSubject(user.getUsername());
				claims.setStringListClaim("roles", Arrays.asList("BUYER", "SELLER", "MANAGER"));
				
				JsonWebSignature jws = new JsonWebSignature();
				jws.setPayload(claims.toJson());
				jws.setKeyIdHeaderValue(senderJwk.getKeyId());
				jws.setKey(senderJwk.getPrivateKey());
				
				jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
				
				String jwt = null;
				try {
					jwt = jws.getCompactSerialization();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				return Response.status(200).entity(jwt).build();
				
			}
		}
		return Response.status(401).build();
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

}
