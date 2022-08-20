package it.polimi.db2.classes;

import java.util.List;

public class Pair {

	String username;
	int point;
	String answer = null;
	
	String question = null;
	List<Pair> pair= null;
	
	public Pair(String username, int point) {
		this.username= username;
		this.point = point;
	}
	
	public Pair(String username, String answer) {
		this.username= username;
		this.answer = answer;
	}
	
	public Pair(String question, List<Pair> pair) {
		this.question= question;
		this.pair = pair;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public List<Pair> getPair() {
		return pair;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getPoint() {
		return point;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	
}
