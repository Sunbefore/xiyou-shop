package com.xiyou.pindao.config;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasConfig extends CasClientConfigurerAdapter{

    @Override
    public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter) {
        super.configureAuthenticationFilter(authenticationFilter);
        authenticationFilter.getInitParameters().
                put("authenticationRedirectStrategyClass","com.patterncat.CustomAuthRedirectStrategy");

    }

}
