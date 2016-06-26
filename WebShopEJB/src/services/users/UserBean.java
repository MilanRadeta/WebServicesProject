package services.users;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import model.users.Role;
import model.users.User;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;

import dao.users.UserDaoLocal;

@Stateless
@LocalBean
@Path("/users")
public class UserBean implements UserBeanRemote {

	@EJB
	private UserDaoLocal userDao;
	
	private static RsaJsonWebKey senderJwk = null;
	
	@Override
	public Response login(String token, User user) {
		if (validateJWTToken(token) != null) {
			return Response.status(200).entity(token).build();
		}
		if (user.getUsername() != null && user.getUsername().length() > 0
				&& user.getPassword() != null
				&& user.getPassword().length() > 0) {
			User dbUser = userDao.findByUsername(user.getUsername());
			if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
				if (senderJwk == null) {
					try {
						senderJwk = RsaJwkGenerator.generateJwk(2048);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				JwtClaims claims = new JwtClaims();
				claims.setIssuer("webshop");
				claims.setGeneratedJwtId();
				claims.setIssuedAtToNow();
				claims.setNotBeforeMinutesInThePast(2);
				claims.setSubject(user.getUsername());
				claims.setClaim("role", dbUser.getRole());
				claims.setClaim("firstName", dbUser.getFirstName());
				claims.setClaim("lastName", dbUser.getLastName());

				JsonWebSignature jws = new JsonWebSignature();
				jws.setPayload(claims.toJson());
				jws.setKeyIdHeaderValue(senderJwk.getKeyId());
				jws.setKey(senderJwk.getPrivateKey());
				jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

				String jwt = null;
				try {
					jwt = jws.getCompactSerialization();
				} catch (Exception e) {
					e.printStackTrace();
				}

				return Response.status(200).entity(jwt).build();

			}
		}
		return Response.status(401).build();
	}

	@Override
	public void logout() {
	}
	
	public User validateJWTToken(String token) {
		if (senderJwk == null) {
			try {
				senderJwk = RsaJwkGenerator.generateJwk(2048);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (token != null) {

			JwtClaims claims = new JwtClaims();

			JsonWebSignature jws = new JsonWebSignature();
			jws.setPayload(claims.toJson());
			jws.setKeyIdHeaderValue(senderJwk.getKeyId());
			jws.setKey(senderJwk.getPrivateKey());

			jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
			
			JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				.setRequireIssuedAt()
				.setRequireJwtId()
				.setRequireNotBefore()
				.setRequireSubject()
				.setExpectedIssuer("webshop")
				.setVerificationKey(senderJwk.getKey())
				.build();
			try {
		      //  Validate the JWT and process it to the Claims
		      JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
		      String username = jwtClaims.getSubject();
	    	  Role role = Role.valueOf((String) jwtClaims.getClaimValue("role"));
	    	  User user = userDao.findByUsername(username);
	    	  if (user != null && user.getRole() == role) {
	    		  return user;
	    	  }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		return null;
	}

}
