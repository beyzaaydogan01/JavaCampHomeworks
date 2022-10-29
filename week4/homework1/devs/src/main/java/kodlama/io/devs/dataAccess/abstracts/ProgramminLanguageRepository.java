package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgramminLanguageRepository {
	List<ProgrammingLanguage> getAll();
	void add(ProgrammingLanguage programmingLanguage);
	void delete(ProgrammingLanguage programmingLanguage);
	void update(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage getById(int id);
}
