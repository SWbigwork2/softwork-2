package view.manager;

import Usersblimpl.ManagerVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ManagerInformationController {
    @FXML private  PasswordField managerPasswordField;
    @FXML private  Label managerIdField;
    @FXML private  Label managerNameField; 
	private boolean isRevamp;
    
    private ManagerVO manager;
    
    private Main main;
	@FXML
	private void cancel(){
		
		main.initmainPane();
		
	}
	
	@FXML
	private void confirm(){
	    main.initmainPane();	
	}
	
	@FXML
	public void initialize(){
	    	
	}
	
	@FXML
	private void revampPassword(){
	    main.showRevamoPassword(manager);
	}
	
	public ManagerInformationController(){
		managerIdField=new Label();
		managerNameField=new Label();
		managerPasswordField=new PasswordField();
		main=main.getMain();
		isRevamp=false;
	}
	
	
	public void setManagerVO(ManagerVO managerVO){
		this.manager=managerVO;
		
		System.out.println(managerVO.getPassword());
		managerPasswordField.setText(manager.getPassword());
		managerIdField.setText(manager.getUserId());
		managerNameField.setText(manager.getName());
		
		managerPasswordField.setEditable(false);
	}
}
