package com.example.wallpaper;

import com.example.wallpaper.common.log.Log;
import com.example.wallpaper.core.service.contract.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WallpaperApplication {

    public static void main(String[] args) {
        SpringApplication.run(WallpaperApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserService service) {
//        return args -> {
//            try {
//                service.getUser("pavel.shoplik@yandex.ru", "xyzw");
//            } catch (IllegalArgumentException exception) {
//                Log.e(exception);
//            }
//        };
//    }
}
