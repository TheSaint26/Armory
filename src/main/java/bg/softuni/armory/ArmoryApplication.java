package bg.softuni.armory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArmoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmoryApplication.class, args);
	}

}
