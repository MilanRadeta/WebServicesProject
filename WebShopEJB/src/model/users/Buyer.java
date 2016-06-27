package model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value=Role.Values.BUYER)
public class Buyer extends User {
	private static final long serialVersionUID = 1539437921876611128L;
	
	public Buyer() {
		setRole(Role.BUYER);
	}

}
