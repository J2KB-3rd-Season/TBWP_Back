package org.j2kb.tbwp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TbwpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TbwpApplication.class, args);
    }

}
