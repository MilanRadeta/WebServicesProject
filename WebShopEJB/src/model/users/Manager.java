package model.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value=Role.Values.MANAGER)
public class Manager extends User {
	private static final long serialVersionUID = -4011588151020648456L;

	public Manager() {
		super();
		setRole(Role.MANAGER);
	}
}
