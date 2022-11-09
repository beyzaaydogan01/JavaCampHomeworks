package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgramminLanguageService;
import kodlama.io.devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.devs.business.requests.language.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageListResponses;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.technology.ProgrammingLangugageTechnologyListResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

@Service  //Bu sınıf bir business nesnesidir
public class ProgrammingLanguageManager implements ProgramminLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingLanguageTechnologyService programmingLanguageTechnologyService;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
			ProgrammingLanguageTechnologyService programmingLanguageTechnologyService) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingLanguageTechnologyService = programmingLanguageTechnologyService;
	}


	@Override
	public List<GetAllProgrammingLanguageListResponses> getAll() {
		 List<ProgrammingLanguage> languageList = this.programmingLanguageRepository.findAll();
		    List<GetAllProgrammingLanguageListResponses> languageListResponses = new ArrayList<>();
		    List<ProgrammingLangugageTechnologyListResponse> technologyListResponses = new ArrayList<>();
		    for (ProgrammingLanguage programmingLanguage : languageList) {
		      GetAllProgrammingLanguageListResponses languageListResponse = new GetAllProgrammingLanguageListResponses();
		      languageListResponse.setId(programmingLanguage.getId());
		      languageListResponse.setLanguageName(programmingLanguage.getLanguageName());
		      languageListResponses.add(languageListResponse);

		      for (ProgrammingLanguageTechnology technology : programmingLanguage.getProgrammingLanguageTechnologies()) {
		        ProgrammingLangugageTechnologyListResponse technologyListResponse = new ProgrammingLangugageTechnologyListResponse();
		        technologyListResponse.setId(this.programmingLanguageTechnologyService.getTechnologyById(technology.getId()).getId());
		        technologyListResponse.setName(this.programmingLanguageTechnologyService.getTechnologyById(technology.getId()).getLanguageTechnologyName());
		        technologyListResponses.add(technologyListResponse);
		      }
		      languageListResponse.setTechnologyListResponses(technologyListResponses);
		    }
		    return languageListResponses;
	}

	@Override
	public CreateProgrammingLanguageRequest add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		checkNameDuplication(createProgrammingLanguageRequest.getProgrammingLanguage());
		checkNameEmptyControl(createProgrammingLanguageRequest.getProgrammingLanguage());
		ArrayList<ProgrammingLanguageTechnology> languageTechnologies = new ArrayList<>();
		
		
		for (Integer id : createProgrammingLanguageRequest.getTechnologyId()) {
		     ProgrammingLanguageTechnology technologyById = programmingLanguageTechnologyService.getTechnologyById(id);
		     languageTechnologies.add(technologyById);
		  }
		
		 
		 
		 ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		 programmingLanguage.setId((int) Math.random());
		 programmingLanguage.setLanguageName(createProgrammingLanguageRequest.getProgrammingLanguage());
		 programmingLanguage.setProgrammingLanguageTechnologies(languageTechnologies);
		 this.programmingLanguageRepository.save(programmingLanguage);
		 return createProgrammingLanguageRequest;
	
	}
	
	 private void checkNameDuplication(String name) throws Exception {
		    List<ProgrammingLanguage> languageList = this.programmingLanguageRepository.findAll();
		    for (ProgrammingLanguage languageForeach : languageList) {
		      if (languageForeach.getLanguageName().equalsIgnoreCase(name)) {
		        throw new Exception("Bu isim zaten mevcut");
		      }
		  }
	}
	 
	 private void checkNameEmptyControl(String name) throws Exception {
		    if (name == null || name == "") {
		      throw new Exception("İsim boş geçilemez");
		    }
		  }
	 
	 
	 private void checkIfIdValid(int id) throws Exception {
		    if (id <= 0) {
		      throw new Exception("Geçerli bir id giriniz");
		    }
		  }

	 private void checkIfIdDoesNotExist(int id) throws Exception {
		    List<ProgrammingLanguage> languageList = this.programmingLanguageRepository.findAll();

		    for (ProgrammingLanguage languageForeach : languageList) {
		      if (languageForeach.getId() != id) {
		        throw new Exception("Bu id'ye sahip bir dil yok: " + id);
		      }
		    }
		  }

	@Override
	public String delete(int id) throws Exception{
		checkIfIdDoesNotExist(id);
	    checkIfIdValid(id);
	    this.programmingLanguageRepository.deleteById(id);
	    return "Silme işlemi tamamlandı";
	} 
	  
	@Override
	public GetAllProgrammingLanguageResponse update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception{ 
		checkIfIdDoesNotExist(id);
	    checkNameDuplication(updateProgrammingLanguageRequest.getProgrammingLanguage());
	    checkNameEmptyControl(updateProgrammingLanguageRequest.getProgrammingLanguage());
	    checkIfIdValid(id);
	    
	    Optional<ProgrammingLanguage> programmingLanguage = this.programmingLanguageRepository.findById(id);
	    GetAllProgrammingLanguageResponse languageResponse = new GetAllProgrammingLanguageResponse();
	    languageResponse.setLanguageName(updateProgrammingLanguageRequest.getProgrammingLanguage());
	    programmingLanguage.get().setLanguageName(updateProgrammingLanguageRequest.getProgrammingLanguage());
	    this.programmingLanguageRepository.save(programmingLanguage.get());
	    return languageResponse;
	}

	@Override
	public GetAllProgrammingLanguageResponse getById(int id) throws Exception {
		checkIfIdDoesNotExist(id);
	    checkIfIdValid(id);
	    Optional<ProgrammingLanguage> language = this.programmingLanguageRepository.findById(id);
	    GetAllProgrammingLanguageResponse languageResponse = new GetAllProgrammingLanguageResponse();
	    languageResponse.setLanguageName(language.get().getLanguageName());
	    return languageResponse;
	}

	@Override
	public ProgrammingLanguage getLanguageById(int id) {
		 Optional<ProgrammingLanguage> programmingLanguage = this.programmingLanguageRepository.findById(id);
		    return programmingLanguage.get();
	}
	 





}
