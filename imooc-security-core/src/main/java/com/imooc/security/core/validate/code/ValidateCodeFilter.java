package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-06 9:21
 * @Description: 校验码过滤器
 * @Copyright(©) 2018 by peter.
 */
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean{

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private SecurityProperties securityProperties;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    private Set<String> urls = new HashSet<>();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(),",");


        if (configUrls !=null){
            for(String configUrl : configUrls){
                urls.add(configUrl);
            }
        }
        urls.add("/authentication/form");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;
        for (String url:urls){
            if (antPathMatcher.match(url,httpServletRequest.getRequestURI())){
                action = true;
            }
        }
        if(action){
            System.out.println("========22222222222========");
            try {
                validate(new ServletWebRequest(httpServletRequest));
            }catch (ValidateCodeException e){
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {

        ImageCode seesionCode  = (ImageCode) sessionStrategy.getAttribute(servletWebRequest,ValidateCodeCotroller.SESSION_KEY);

        String requestCode = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),"imageCode");

        if(StringUtils.isBlank(requestCode)){
            throw new ValidateCodeException("验证码不能为空");
        }

        if (seesionCode == null){
            throw new ValidateCodeException("验证码不存在");
        }

        if(seesionCode.isExpried()){
            sessionStrategy.removeAttribute(servletWebRequest,ValidateCodeCotroller.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equalsIgnoreCase(requestCode,seesionCode.getCode())){
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,ValidateCodeCotroller.SESSION_KEY);
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
