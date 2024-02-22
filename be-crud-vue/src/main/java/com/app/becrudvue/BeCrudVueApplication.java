package com.app.becrudvue;

import com.app.becrudvue.enity.Patient;
import com.app.becrudvue.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeCrudVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeCrudVueApplication.class, args);
	}

}

@Slf4j
@Component
@RequiredArgsConstructor
class TestData implements CommandLineRunner {

	private final PatientService patientService;

	@Override
	public void run(String... args) throws Exception {

		if (patientService.list().isEmpty()){
			log.info("starting execute data..");
			Patient patient1 = new Patient();
			patient1.setName("muhamad dicka nirwansyah");
			patient1.setGender("Laki-Laki");
			patient1.setEmail("dickanirwansyah@gmail.com");
			patient1.setPNo("081324366585");

			patientService.add(patient1);

			Patient patient2 = new Patient();
			patient2.setName("adam levine");
			patient2.setGender("Laki-Laki");
			patient2.setEmail("adamlevine@gmail.com");
			patient2.setPNo("08928293939839");

			patientService.add(patient2);

			Patient patient3 = new Patient();
			patient3.setName("paula mccartnet");
			patient3.setGender("Perempuan");
			patient3.setEmail("paula@gmail.com");
			patient3.setPNo("08829293939978");

			patientService.add(patient3);

			log.info("finish execute data");
		}
	}
}