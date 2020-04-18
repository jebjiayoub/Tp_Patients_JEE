package emsi.jebji;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import emsi.jebji.dao.PatientRepository;
import emsi.jebji.entities.Patient;

@SpringBootApplication
public class TpPatientsApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TpPatientsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Anass",new Date(), false));
		patientRepository.save(new Patient(null,"Ayoub",new Date(), false));
		patientRepository.save(new Patient(null,"Samira",new Date(), false));
	}
}

