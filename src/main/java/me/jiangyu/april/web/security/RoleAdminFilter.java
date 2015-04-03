package me.jiangyu.april.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by jyk on 2015/4/3.
 */
public class RoleAdminFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(RoleAdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.error("custome");
        List<GrantedAuthority> authorityList =  AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        AnonymousAuthenticationToken token = new AnonymousAuthenticationToken("1", "role-admin", authorityList);
        SecurityContextHolder.getContext().setAuthentication(token);
    }

    @Override
    public void destroy() {
    }
}
