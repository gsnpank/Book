package telran.java2022.book.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "isbn")
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 7934730430500833561L;

	@Id
	String isbn;
	String title;
	
	   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   @JoinTable(name = "author_book", joinColumns = 
	   @JoinColumn(name = "book_id"), 
	             inverseJoinColumns = @JoinColumn(name = "author_id"))

	
	Set<Author> authors;
//	@ManyToOne
	@ManyToOne (optional=false, cascade=CascadeType.ALL)
	@JoinColumn (name="book_id")
	Publisher publisher;

}
