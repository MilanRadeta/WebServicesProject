package model.users;

public enum Role {
	BUYER(Values.BUYER),
	MANAGER(Values.MANAGER),
	SELLER(Values.SELLER);
	
	private Role (String val) {
		if (!this.name().equals(val)) {
			throw new IllegalArgumentException("Incorect use of Role");
		}
	}
	
	public static class Values {
		public static final String BUYER = "BUYER";
		public static final String MANAGER = "MANAGER";
		public static final String SELLER = "SELLER";
	}
}
