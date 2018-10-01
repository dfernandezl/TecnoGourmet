package cat.tecnocampus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cat.tecnocampus.dao.NoteLabDAO;

@SpringBootApplication
public class JdbcexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcexerciseApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(NoteLabDAO noteLabDAO) {
		return (args)->{
			
		};
	}
}
