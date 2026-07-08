package online.shop.binary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		Test user = new Test();

        user.setName("Ali");

        System.out.println(user.getName());

		SpringApplication.run(Application.class, args);
	}

}

