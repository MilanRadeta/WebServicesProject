package model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value=Role.Values.SELLER)
public class Seller extends User {
	private static final long serialVersionUID = -3496174614221921374L;

	public Seller() {
		super();
		setRole(Role.SELLER);
	}
}
