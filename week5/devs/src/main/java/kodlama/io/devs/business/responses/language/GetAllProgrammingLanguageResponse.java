package kodlama.io.devs.business.responses.language;

import java.util.List;

import kodlama.io.devs.business.responses.technology.ProgrammingLangugageTechnologyListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageResponse {
	private String languageName;
	List<ProgrammingLangugageTechnologyListResponse> langugageTechnologyListResponses;
}


