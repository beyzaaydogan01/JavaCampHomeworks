package kodlama.io.devs.business.requests.language;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageRequest {
	private String programmingLanguage;
	private List<Integer> technologyId;
	
}
