package me.jiangyu.april.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jyk on 2015/4/3.
 */
public class RoleAdminFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(RoleAdminFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.error("custome");
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        AnonymousAuthenticationToken token = new AnonymousAuthenticationToken("1", "role-admin", authorityList);
        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
