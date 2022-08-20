package it.polimi.db2.questionnaire.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "answerstatistical", schema = "db_questionnaire")


public class AnswerStatistical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idansstat;

	private Integer age;
	
	private String sex; // male/female
	
	private String level; // low/medium/high

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "questionnaire")
	private Questionnaire questionnaire;

	public AnswerStatistical() {}

	
	
	public AnswerStatistical(Integer age, String sex, String level, User user, Questionnaire questionnaire) {

		this.age = age;
		this.sex = sex;
		this.level = level;
		this.user = user;
		this.questionnaire = questionnaire;
	}



	public void setUser(User user) {
		this.user = user;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	

	
	
}