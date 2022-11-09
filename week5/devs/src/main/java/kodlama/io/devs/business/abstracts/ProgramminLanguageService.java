package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.language.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageListResponses;
import kodlama.io.devs.business.responses.language.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgramminLanguageService {
	
	CreateProgrammingLanguageRequest add (CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	GetAllProgrammingLanguageResponse update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	//void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest)throws Exception;
	List<GetAllProgrammingLanguageListResponses> getAll();
	GetAllProgrammingLanguageResponse getById(int id) throws Exception;
	
	ProgrammingLanguage getLanguageById(int id);
	
	String delete(int id) throws Exception;
	
	
	//List<GetAllProgrammingLanguageResponse> getById(int id);
	
}
 