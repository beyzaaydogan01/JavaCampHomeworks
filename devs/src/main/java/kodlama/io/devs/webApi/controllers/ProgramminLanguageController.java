package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgramminLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController  //annotation
@RequestMapping("/api/programmingLanguages")
public class ProgramminLanguageController {
	private ProgramminLanguageService languageService;

	@Autowired
	public ProgramminLanguageController(ProgramminLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
}