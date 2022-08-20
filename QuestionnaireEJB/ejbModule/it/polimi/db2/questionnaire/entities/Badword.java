package it.polimi.db2.questionnaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "badword", schema = "db_questionnaire")
@NamedQuery(name = "Badword.getBadwords", query = "SELECT b.word FROM Badword b")

public class Badword implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbadword;

	private String word;
	
	public Badword() {}
	
	
}
