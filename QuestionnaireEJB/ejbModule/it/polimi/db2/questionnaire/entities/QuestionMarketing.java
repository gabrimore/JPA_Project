package it.polimi.db2.questionnaire.entities;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


@Entity
@Table(name = "questionmarketing", schema = "db_questionnaire")
@NamedQueries({
@NamedQuery(name = "QuestionMarketing.getMarketingQuestions", query = "SELECT q  FROM QuestionMarketing q WHERE q.questionnaire.idquestionnaire = ?1")
})

public class QuestionMarketing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idquestion;
	
	private String question;
	

	@ManyToOne
	@JoinColumn(name = "questionnaire")
	private Questionnaire questionnaire;

	//EAGER could make sense because it is utilized in the inspection page, but I assumed that such page is used less frequently than the page in which we compile the questionnaire in which the answers aren't useful at all
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AnswerMarketing> answersmarketing;
	
	
	public QuestionMarketing() {}
	
	public QuestionMarketing(String question) {
		this.question=question;
	}

	
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public void addAnswerMarketing(AnswerMarketing ans){
		this.answersmarketing.add(ans);
		ans.setQuestion(this);
	}
	public int getQuestionMarketingID() {
		return this.idquestion;
	}

	public String getQuestion() {
		return this.question;
	}
	
	public List<AnswerMarketing> getListOfAnswersMarketing() {
		return this.answersmarketing;
	}
	
	
}
