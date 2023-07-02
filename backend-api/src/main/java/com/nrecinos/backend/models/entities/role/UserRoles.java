package com.nrecinos.backend.models.entities.role;

public enum UserRoles {
	ADMIN("Admin"),
	USER("User");

	private final String displayName;

    UserRoles(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
