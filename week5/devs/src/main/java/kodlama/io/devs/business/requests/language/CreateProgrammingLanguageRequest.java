package kodlama.io.devs.business.requests.language;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//son kullanıcı data verirken

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingLanguageRequest {
	private String programmingLanguage;
	private List<Integer> technologyId;
}
