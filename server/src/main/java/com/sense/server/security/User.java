/*******************************************************************************
 * @preserve Copyright (c) 2014 Sense Inc. as an unpublished
 * work. Neither this material nor any portion hereof may be copied or
 * distributed without the express written consent of Sense Inc.
 *
 * This material also contains proprietary and confidential information
 * of Sense Inc. and its suppliers, and may not be used by or
 * disclosed to any person, in whole or in part, without the prior written
 * consent of Sense Inc.
 ******************************************************************************/
package com.sense.server.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

    @NotEmpty
    @JsonProperty
    @Setter @Getter private String username;

    @JsonProperty
    @Setter @Getter private String token;

    @NotEmpty
    @JsonProperty
    @Setter @Getter private String password;

    @JsonProperty
    @Setter @Getter private String displayName;

    @JsonProperty
    @Setter @Getter private String displayRole;

    public User(String username, String password, String token, String displayName, String displayRole) {

        this.username = username;
        this.token = token;
        this.displayName = displayName;
        this.displayRole = displayRole;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User that = (User) o;

        if (!username.equals(that.getUsername())) return false;
        if (!password.equals(that.getPassword())) return false;
        if (!displayName.equals(that.getDisplayName())) return false;
        if (!displayRole.equals(that.getDisplayRole())) return false;

        return true;
    }
}