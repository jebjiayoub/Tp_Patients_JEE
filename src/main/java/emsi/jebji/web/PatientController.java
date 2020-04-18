package emsi.jebji.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import emsi.jebji.dao.PatientRepository;
import emsi.jebji.entities.Patient;

@Controller
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}

	@GetMapping(path = "/patients")
	public String patients(Model model,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "motCle", defaultValue = "") String motCle) {
		Page<Patient> patients = patientRepository.findByNameContains(motCle, PageRequest.of(page, size));
		model.addAttribute("patients", patients.getContent());
		model.addAttribute("pages", new int [patients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("motCle",motCle);
		return "patients";
	}

	@GetMapping(path = "/deletePatient")
	public String deletePatient(Long id, int page, int size, String motCle) {
		patientRepository.deleteById(id);
		return "redirect:/patients?page="+page+"&motCle="+motCle+"&size="+size;
	}

}

