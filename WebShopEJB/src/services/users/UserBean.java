package services.users;

import javax.ejb.EJB;
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

import dao.users.UserDaoLocal;

@Stateless
@LocalBean
@Path("/users")
public class UserBean implements UserBeanRemote {

	@EJB
	private UserDaoLocal userDao;
	
	private static RsaJsonWebKey senderJwk = null;

	// TODO: create validate JWT token method
	// TODO: call it in other beans and check user's role
	
	
	@Override
	public Response login(User user) {
		if (user.getUsername() != null && user.getUsername().length() > 0
				&& user.getPassword() != null
				&& user.getPassword().length() > 0) {
			// TODO: change to query by username
			User dbUser = userDao.findById(user.getUsername());
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
				claims.setExpirationTimeMinutesInTheFuture(10);
				claims.setGeneratedJwtId();
				claims.setIssuedAtToNow();
				claims.setNotBeforeMinutesInThePast(2);
				claims.setSubject(user.getUsername());
				claims.setClaim("role", dbUser.getRole().toString());

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
		// TODO Auto-generated method stub

	}

}
