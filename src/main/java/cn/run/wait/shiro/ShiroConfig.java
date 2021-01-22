package cn.run.wait.shiro;

import org.apache.shiro.mgt.AuthenticatingSecurityManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Created by SXB on 2018/7/30.
 */
@Configuration
public class ShiroConfig {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);
    @Bean
    public ShiroFilterFactoryBean factoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        factoryBean.setUnauthorizedUrl("/unauth");

        factoryBean.setSecurityManager(securityManager);

        LinkedHashMap<String,String> map = new LinkedHashMap();
        map.put("/logout", "logout");
        map.put("/js/**", "anon");
        map.put("/images/**", "anons");
        map.put("/css/**", "anons");
        map.put("/layui/**", "anongggg");
        map.put("/treegrid/**", "anon");
        map.put("/user/login", "anon");
        map.put("/user/sendMessage", "anon");
        map.put("/**", "authc");

        factoryBean.setFilterChainDefinitionMap(map);
        log.info("shiro factory is build..........");
        return factoryBean;
    }

    @Bean
    public SecurityManager manager(Realm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    @Bean
    public Realm realm(){
        ShiroRealm realm = new ShiroRealm();
        return realm;
    }
}
