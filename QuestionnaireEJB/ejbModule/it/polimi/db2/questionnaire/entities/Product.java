package it.polimi.db2.questionnaire.entities;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Base64;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "product", schema = "db_questionnaire")
@NamedQueries({
@NamedQuery(name = "Product.getProduct", query = "SELECT p FROM Product p  WHERE p.date = ?1")
})

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproduct;

	private String title;

	private String description;
	
	// date in which this product will be the product of the day
	private Date date; //YYYY-MM-DD

	@Lob
	private byte[] image;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews;
	
	@OneToOne (fetch = FetchType.LAZY, mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
	private Questionnaire questionnaire;
	
	
	
	public Product() {   }


	public Product(String title, String description, Date date, byte[] image) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.image = image;
		
	}


	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}
	
	public List<Review> getReviews(){
		return this.reviews;
	}
	
	public int getIdproduct() {
		return idproduct;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public byte[] getImage() {
		return image;
	}

	public String getThumbData() {
		return Base64.getMimeEncoder().encodeToString(image);
	}

	public void addReview(Review rev) {
		this.reviews.add(rev);
		rev.setProduct(this);
	}
	
	
	public void setQuestionnaire(Questionnaire ques) {
		this.questionnaire=ques;
		ques.setProduct(this);
	}
	


	public int getIdQuestionnaire() {
		return this.questionnaire.getId();
	}
	


}
