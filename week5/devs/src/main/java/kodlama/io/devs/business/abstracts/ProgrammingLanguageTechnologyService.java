package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technology.CreateProgrammingLanguageTechnologyReguest;
import kodlama.io.devs.business.requests.technology.UpdateProgrammingLanguageTechnologyReguest;
import kodlama.io.devs.business.responses.technology.GetAllProgrammingLanguageTechnologyResponse;
import kodlama.io.devs.business.responses.technology.ProgrammingLangugageTechnologyListResponse;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageTechnology;

public interface ProgrammingLanguageTechnologyService {
	List<ProgrammingLangugageTechnologyListResponse> getAll();
	CreateProgrammingLanguageTechnologyReguest add(CreateProgrammingLanguageTechnologyReguest createLanguageTechnologyReguest) throws Exception;
	GetAllProgrammingLanguageTechnologyResponse update(int id, UpdateProgrammingLanguageTechnologyReguest updateLanguageTechnologyReguest) throws Exception;
	String delete(int id) throws Exception;
	GetAllProgrammingLanguageTechnologyResponse getById(int id) throws Exception;
	ProgrammingLanguageTechnology getTechnologyById(int id);

}
