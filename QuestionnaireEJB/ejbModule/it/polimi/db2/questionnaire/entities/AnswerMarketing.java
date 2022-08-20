package it.polimi.db2.questionnaire.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "answermarketing", schema = "db_questionnaire")


public class AnswerMarketing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idansmark;

	private String answer;

	@ManyToOne(fetch = FetchType.EAGER) //not needed to be specified since it's the default policy in @ToOne, I did it to highlight the fact that I get the user navigating the answer in the inspection page
	@JoinColumn(name = "user")
	private User user;
	

	@ManyToOne
	@JoinColumn(name = "questionnaire")
	private Questionnaire questionnaire;
	
	
	@ManyToOne
	@JoinColumn(name = "question")
	private QuestionMarketing question;

	public AnswerMarketing() {}
	
	
	public AnswerMarketing(String answer, User user, Questionnaire questionnaire, QuestionMarketing questionmarketing) {
		this.answer = answer;
		this.user = user;
		this.questionnaire = questionnaire;
		this.question = questionmarketing;
	}
	

	public void setUser(User user) {
		this.user = user;
	}

	public void setQuestion(QuestionMarketing ques) {
		this.question = ques;
	}
	
	
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	
	public User getUser() {
		return this.user;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	

}

	

	
	