package neito.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
	private final IntegerProperty score;
	private final StringProperty name;
	private final String editor;
	
	public Game(String name, int score)
	{
		this.name = new SimpleStringProperty(name);
		this.score = new SimpleIntegerProperty(score);
		this.editor = "Default";
	}
	
	public int getScore() {				
	  return score.get();
	}
	public void setScore(int value) {		
	  this.score.set(value);
	}
	public IntegerProperty ScoreProperty() {
        return score;
    }	
	public StringProperty NameProperty() {
        return name;
    }	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
}