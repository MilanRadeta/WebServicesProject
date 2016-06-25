package services.utils;

import javax.ejb.Remote;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Remote
public interface InitBeanRemote {

	@GET
	@Path("/createDatabase")
	public void createDatabase();

}
