package kodlama.io.devs.business.responses.language;

import java.util.List;

import kodlama.io.devs.business.responses.technology.ProgrammingLangugageTechnologyListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageListResponses {
	private int id;
	private String languageName;

	 List<ProgrammingLangugageTechnologyListResponse> technologyListResponses;

}
