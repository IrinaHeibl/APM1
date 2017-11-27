package model;

public class HL7Message extends MessageBase implements IMessage {

	private int id;
	private String message;
	
	public HL7Message(){
		
	}
	
	public HL7Message(String message){
		setMessage(message);
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
