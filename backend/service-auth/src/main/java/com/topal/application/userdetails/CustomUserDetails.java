package com.topal.application.userdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails
{

	private static final long serialVersionUID = -195470560219893520L;

	private final User user;

    private final Collection<? extends GrantedAuthority> roles;

    public CustomUserDetails(User user, Collection<? extends GrantedAuthority> roles)
    {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return roles;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return user.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return user.getAccountNonLocked();
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired()
    {
        return user.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled()
    {
        return user.getActive();
    }

}
