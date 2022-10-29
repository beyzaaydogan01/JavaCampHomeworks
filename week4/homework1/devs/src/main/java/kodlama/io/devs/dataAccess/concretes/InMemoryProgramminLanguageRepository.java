package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgramminLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository  //Bu sınıf bir data access nesnesidir
public class InMemoryProgramminLanguageRepository implements ProgramminLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages;
	
	
	public InMemoryProgramminLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(3,"C++"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Python"));
		programmingLanguages.add(new ProgrammingLanguage(5,"Javascript"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.remove(programmingLanguage);
	}
	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage progLanguage : programmingLanguages) {
			if (progLanguage.getId() == programmingLanguage.getId()) {
				programmingLanguages.set(progLanguage.getId(), programmingLanguage);
			}
		}
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id);
	}

}
