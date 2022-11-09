package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgramminLanguageService;
import kodlama.io.devs.business.requests.language.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageListResponses;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageResponse;

@RestController  //annotation
@RequestMapping("/api/programmingLanguages")
public class ProgramminLanguageController {
	private ProgramminLanguageService languageService;

	@Autowired
	public ProgramminLanguageController(ProgramminLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	List<GetAllProgrammingLanguageListResponses> getAll(){
		return this.languageService.getAll();
	}
	
	@PostMapping("/add")
	CreateProgrammingLanguageRequest add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		return this.languageService.add(createProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	String delete(@RequestParam int id) throws Exception {
		    return this.languageService.delete(id);
	}
	
	@PutMapping("/update")
	GetAllProgrammingLanguageResponse update(@RequestParam int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception{
		return this.languageService.update(id, updateProgrammingLanguageRequest);	
	}
	
	@GetMapping("/getById")
	GetAllProgrammingLanguageResponse getById(@RequestParam int id) throws Exception {
	    return this.languageService.getById(id);
	  }
}








