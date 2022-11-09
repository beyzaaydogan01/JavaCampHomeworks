package kodlama.io.devs.webApi.controllers;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgramminLanguageService;
import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.language.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.technology.CreateProgrammingLanguageTechnologyReguest;
import kodlama.io.devs.business.requests.technology.UpdateProgrammingLanguageTechnologyReguest;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.technology.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.devs.business.responses.technology.ProgrammingLangugageTechnologyListResponse;

@RestController  //annotation
@RequestMapping("/api/programmingLanguagestechnology")
public class ProgramminLanguageTechnologyController {
	private ProgrammingLanguageTechnologyService languageTechnologyService;

	@Autowired
	public ProgramminLanguageTechnologyController(ProgrammingLanguageTechnologyService languageTechnologyService) {
		this.languageTechnologyService = languageTechnologyService;
	}
	
	
	@GetMapping("/getAll")
	List<ProgrammingLangugageTechnologyListResponse> getAll(){
		return this.languageTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	CreateProgrammingLanguageTechnologyReguest add(CreateProgrammingLanguageTechnologyReguest createProgrammingLanguageTechnologyReguest) throws Exception {
		return this.languageTechnologyService.add(createProgrammingLanguageTechnologyReguest);
	}
	
	@DeleteMapping("/delete")
	String delete(@RequestParam int id) throws Exception {
		   return this.languageTechnologyService.delete(id);
	}
	
	@PutMapping("/update")
	GetAllProgrammingLanguageTechnologyResponse update(@RequestParam int id, UpdateProgrammingLanguageTechnologyReguest updateProgrammingLanguageTechnologyReguest) throws Exception{
		return this.languageTechnologyService.update(id, updateProgrammingLanguageTechnologyReguest);
	}
	
	@GetMapping("/getById")
	  GetAllProgrammingLanguageTechnologyResponse getById(@RequestParam int id) throws Exception {
	    return this.languageTechnologyService.getById(id);
	  }

}
