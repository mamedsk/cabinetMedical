package ma.cabinet;

import ma.cabinet.entities.Dentist;
import ma.cabinet.entities.Patient;
import ma.cabinet.entities.Role;
import ma.cabinet.entities.User;
import ma.cabinet.repository.IDentistRepository;
import ma.cabinet.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class CabinetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CabinetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



	}
}
