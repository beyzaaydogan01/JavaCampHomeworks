package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgramminLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgramminLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service  //Bu sınıf bir business nesnesidir
public class ProgramminLanguageManager implements ProgramminLanguageService{
	
	private ProgramminLanguageRepository programminLanguageRepository;

	@Autowired
	public ProgramminLanguageManager(ProgramminLanguageRepository programminLanguageRepository) {
		this.programminLanguageRepository = programminLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programminLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception{
		
		if(programmingLanguage.getLanguageName().isEmpty()) {
			throw new Exception("İsim boş geçilemez");
		}
		
		for(ProgrammingLanguage language : programminLanguageRepository.getAll()) {
			if(language.getLanguageName().equals(programmingLanguage.getLanguageName())) {
				System.out.println("Bu programlama dili mevcut");
			}
		}programminLanguageRepository.add(programmingLanguage);
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) throws Exception{
		
		for(ProgrammingLanguage language : programminLanguageRepository.getAll()) {
			if(language.getId() != programmingLanguage.getId()) {
				throw new Exception("Böyle bir id bulunmamaktadır");
			}
			programminLanguageRepository.delete(programmingLanguage);
		}
		
	} 

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		if(programmingLanguage.getLanguageName().isEmpty()) {
			throw new Exception("İsim boş geçilemez");
		}
		for(ProgrammingLanguage language : programminLanguageRepository.getAll()) {
			if(language.getLanguageName().equals(programmingLanguage.getLanguageName())){
				throw new Exception("Bu programlama dili mevcut");
			}
		}
		programminLanguageRepository.update(programmingLanguage);
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programminLanguageRepository.getById(id);
	}


}
