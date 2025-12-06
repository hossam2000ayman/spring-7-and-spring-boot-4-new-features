package org.example.springboot4.config;

import org.example.springboot4.service.DemoService;
import org.example.springboot4.service.auth.FacebookAuthenticationProvider;
import org.example.springboot4.service.auth.GoogleAuthenticationProvider;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

//1 Dynamic Bean Registration
@Configuration
@Import(value = {
        DynamicBeanRegisterConfig.DemoServiceBean.class,
        DynamicBeanRegisterConfig.AuthenticationProviderBean.class
})
public class DynamicBeanRegisterConfig {

    static class DemoServiceBean implements BeanRegistrar {
        @Override
        public void register(BeanRegistry registry, Environment env) {
            //first way (but it throws error on constructor that it's not identify by intellij IDE)
//            registry.registerBean(DemoService.class);
            //second way
            registry.registerBean(
                    "myCustomService",
                    DemoService.class,
                    options -> options.lazyInit()
                            .primary()
                            .prototype()
            );

        }
    }

    static class AuthenticationProviderBean implements BeanRegistrar {

        @Override
        public void register(BeanRegistry registry, Environment env) {
            String authenticationProvider = env.getProperty("app.authentication.provider");
            switch (authenticationProvider) {
//                case "google":
//                    registry.registerBean(GoogleAuthenticationProvider.class);
//                    break;
//                case "facebook":
//                    registry.registerBean(FacebookAuthenticationProvider.class);
//                    break;
                case "google":
                    registry.registerBean(
                            "googleAuthenticationProvider",
                            GoogleAuthenticationProvider.class,
                            BeanRegistry.Spec::primary
                    );
                case "facebook":
                    registry.registerBean(
                            "facebookAuthenticationProvider",
                            FacebookAuthenticationProvider.class
                    );
            }
        }
    }

}
