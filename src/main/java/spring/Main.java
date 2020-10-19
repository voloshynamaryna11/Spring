package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.model.User;
import spring.service.UserService;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Harry");
        user1.setEmail("zdfkgji123");
        user1.setPassword("alohomora");
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.add(user1);
        System.out.println(userService.listUsers());
    }
}
