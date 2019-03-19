package test;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import test.storage.StorageProperties;
import test.storage.StorageService;

import java.io.PrintStream;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class,args);

        //通过一系列设置来扩展启动行为。
        SpringApplication bootstrap = new SpringApplication(Application.class);
        bootstrap.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                //打印一个字符画
                System.out.println("-------------像我这样优秀的人~------------------");
            }
        });
        bootstrap.setBannerMode(Banner.Mode.CONSOLE);
        bootstrap.run(args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService){
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
