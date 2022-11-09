package kodlama.io.devs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "Lazy"})
@Table(name="programmingLanguages")
public class ProgrammingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Id bir bir arttır
	@Column(name="languageId")
	private int id;
	
	@Column(name="languageName")
	private String languageName;
	
	
	//@OneToMany(cascade = CascadeType.ALL)
	//(mappedBy = "programmingLanguage", fetch = FetchType.EAGER)
	//@JoinTable(name = "languageTechnology")	
	
	@OneToMany
	private List<ProgrammingLanguageTechnology> programmingLanguageTechnologies;

}








