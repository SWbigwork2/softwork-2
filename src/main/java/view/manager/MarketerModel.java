package view.manager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MarketerModel {
    
	private final StringProperty id;
	private final StringProperty name;
	
	public MarketerModel(String id,String name) {
        this.id=new SimpleStringProperty(id);
        this.name=new SimpleStringProperty(name);
	}
	
	public String getId(){
		return this.id.get();
	}
	
	public String getName(){
		return this.name.get();
	}
	
	public void setId(String id){
		this.id.set(id);
	}
	
	public void setName(String name){
		this.name.set(name);
	}
	
	public StringProperty idProperty() {
        return id;
    }
	
	public StringProperty nameProperty(){
		return name;
	}
} 
