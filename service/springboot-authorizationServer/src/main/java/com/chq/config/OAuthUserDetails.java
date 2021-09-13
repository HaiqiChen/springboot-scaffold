package com.chq.config;

import cn.hutool.core.collection.CollectionUtil;import com.chq.common.core.constant.GlobalConstants;
import com.chq.entity.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;



@Data
public class OAuthUserDetails implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private Boolean enabled;

    private Integer userBelong;

    private String name;

    private Long appId;

    private Collection<SimpleGrantedAuthority> authorities;

    public OAuthUserDetails(SysUser user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setName(user.getName());
        this.setAppId(user.getAppId());
        authorities = new ArrayList<>();
        if (Objects.equals(user.getIsAdmin(), 1)) {
            authorities.add(new SimpleGrantedAuthority(GlobalConstants.ROOT_ROLE_CODE));
        }
        if (CollectionUtil.isNotEmpty(user.getRoles())) {
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
