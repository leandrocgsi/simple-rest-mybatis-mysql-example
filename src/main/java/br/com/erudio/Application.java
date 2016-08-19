package br.com.erudio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("br.com.erudio.mappers")
public class Application {
    
    public static void main(String[] args) {
           new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}