package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgramminLanguageService;
import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.technology.CreateProgrammingLanguageTechnologyReguest;
import kodlama.io.devs.business.requests.technology.UpdateProgrammingLanguageTechnologyReguest;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.technology.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.devs.business.responses.technology.ProgrammingLangugageTechnologyListResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService{
	
	private ProgrammingLanguageTechnologyRepository programmingTechnologyRepository;
	@Lazy private ProgramminLanguageService languageService;

	@Autowired
	public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository programmingTechnologyRepository,
			@Lazy ProgramminLanguageService languageService) {
		this.programmingTechnologyRepository = programmingTechnologyRepository;
		this.languageService = languageService;
	}


	@Override
	public List<ProgrammingLangugageTechnologyListResponse> getAll() {
		List<ProgrammingLanguageTechnology> technologyList = programmingTechnologyRepository.findAll();
		List<ProgrammingLangugageTechnologyListResponse> technologyListResponses = new ArrayList<ProgrammingLangugageTechnologyListResponse>();
		
		GetAllProgrammingLanguageResponse languageResponse = new GetAllProgrammingLanguageResponse();
		
	    for (ProgrammingLanguageTechnology languageTechnology : technologyList) {
	      ProgrammingLangugageTechnologyListResponse technologyListResponse = new ProgrammingLangugageTechnologyListResponse();
	      technologyListResponse.setId(languageTechnology.getId());
	      technologyListResponse.setName(languageTechnology.getLanguageTechnologyName());
	      technologyListResponses.add(technologyListResponse);
	    }
	    return technologyListResponses;
		
	}
	

	@Override
	public CreateProgrammingLanguageTechnologyReguest add(CreateProgrammingLanguageTechnologyReguest createLanguageTechnologyReguest) throws Exception {
		checkNameDuplication(createLanguageTechnologyReguest.getLanguageTechnologyName());
		checkNameEmptyControl(createLanguageTechnologyReguest.getLanguageTechnologyName());
	
		
		ProgrammingLanguageTechnology programmingLanguageTechnology = new ProgrammingLanguageTechnology();
		programmingLanguageTechnology.setId((int) Math.random());
		programmingLanguageTechnology.setLanguageTechnologyName(createLanguageTechnologyReguest.getLanguageTechnologyName());
		this.programmingTechnologyRepository.save(programmingLanguageTechnology);
		return createLanguageTechnologyReguest;
		
	}
	 private void checkNameDuplication(String name) throws Exception {
		    List<ProgrammingLanguageTechnology> languageTechnologyList = this.programmingTechnologyRepository.findAll();
		    for (ProgrammingLanguageTechnology languageForeach : languageTechnologyList) {
		      if (languageForeach.getLanguageTechnologyName().equalsIgnoreCase(name)) {
		        throw new Exception("Bu isim zaten mevcut");
		      }
		  }
	}
	 
	 private void checkNameEmptyControl(String name) throws Exception {
		    if (name == null || name == "") {
		      throw new Exception("İsim boş geçilemez");
		    }
		  }

	@Override
	public GetAllProgrammingLanguageTechnologyResponse update(int id, UpdateProgrammingLanguageTechnologyReguest updateLanguageTechnologyReguest) throws Exception {
		checkIfIdDoesNotExist(id);
		checkNameDuplication(updateLanguageTechnologyReguest.getLanguageTechnologyName());
	    checkNameEmptyControl(updateLanguageTechnologyReguest.getLanguageTechnologyName());
	    checkIfIdValid(id);
		  Optional<ProgrammingLanguageTechnology> languageTechnology = this.programmingTechnologyRepository.findById(id);
		    GetAllProgrammingLanguageTechnologyResponse technologyResponse = new GetAllProgrammingLanguageTechnologyResponse();
		    technologyResponse.setLanguageTechnologyName(updateLanguageTechnologyReguest.getLanguageTechnologyName());
		    languageTechnology.get().setLanguageTechnologyName(updateLanguageTechnologyReguest.getLanguageTechnologyName());
		    this.programmingTechnologyRepository.save(languageTechnology.get());
		    return technologyResponse;
		
	}


	@Override
	public GetAllProgrammingLanguageTechnologyResponse getById(int id) throws Exception {
		checkIfIdDoesNotExist(id);
	    checkIfIdValid(id);
		Optional<ProgrammingLanguageTechnology> languageTechnology = this.programmingTechnologyRepository.findById(id);
	    GetAllProgrammingLanguageTechnologyResponse technologyResponse = new GetAllProgrammingLanguageTechnologyResponse();
	    technologyResponse.setLanguageTechnologyName(languageTechnology.get().getLanguageTechnologyName());
	    return technologyResponse;
	}


	@Override
	public ProgrammingLanguageTechnology getTechnologyById(int id) {
		 Optional<ProgrammingLanguageTechnology> technology = this.programmingTechnologyRepository.findById(id);
		 return technology.get();
	}

	 private void checkIfIdValid(int id) throws Exception {
		    if (id <= 0) {
		      throw new Exception("Geçerli bir id giriniz");
		    }
		  }

	private void checkIfIdDoesNotExist(int id) throws Exception {
		    List<ProgrammingLanguageTechnology> languageTechnologyList = this.programmingTechnologyRepository.findAll();

		    for (ProgrammingLanguageTechnology languageForeach : languageTechnologyList) {
		      if (languageForeach.getId() != id) {
		        throw new Exception("Bu id'ye sahip bir dil yok: " + id);
		      }
		    }
		  }

	@Override
	public String delete(int id) throws Exception {
		checkIfIdDoesNotExist(id);
	    checkIfIdValid(id);
		this.programmingTechnologyRepository.deleteById(id);
	    return "Teknoloji silinmiştir";
	}
}
