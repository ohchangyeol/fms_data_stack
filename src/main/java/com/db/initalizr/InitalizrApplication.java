package com.db.initalizr;

import com.db.initalizr.Generate.ManualGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InitalizrApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InitalizrApplication.class, args);

		ManualGenerator manual = context.getBean(ManualGenerator.class);
		manual.runManual();

		SpringApplication.exit(context); // 서버 종료

	}

}
