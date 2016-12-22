package view.manager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StaffModel {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty hotelName;
    
    public StaffModel(String id,String name,String hotelName){
    	this.id=new SimpleStringProperty(id);
    	this.name=new SimpleStringProperty(name);
    	this.hotelName=new SimpleStringProperty(hotelName);
    }
    
    public String getId(){
    	return this.id.get();
    }
    
    public String getName(){
    	return this.name.get();
    }
    
    public String getHotelName(){
    	return this.hotelName.get();
    }
    
    public void setId(String id){
    	this.id.set(id);
    }
    
    public void setName(String name){
    	this.name.set(name);
    }
    
    public void setHotelName(String hotelName){
    	this.hotelName.set(hotelName);
    }
}
