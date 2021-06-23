package io.artcreativity.emarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaAuditing
//@EntityScan(basePackageClasses = {
//		EmarketApplication.class,
//		Jsr310JpaConverters.class
//})
public class EmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmarketApplication.class, args);
	}

}
