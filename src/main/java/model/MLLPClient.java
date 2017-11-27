package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MLLPClient extends ClientBase {
	
	
	public MLLPClient() {
		super("MLLPClient");
	}
	
	@Override
	public boolean sendMessage(IMessage message) {
		try {
			//connect to server using targetIp and targetPort
			Socket socket = new Socket(getTargetIp(), getTargetPort());
			//connected to server, TODO gui indication
			StringBuffer messageToTransmit = new StringBuffer();
			//add text message (string) to buffer
			messageToTransmit.append(message.toString());
			//input stream for notifications
			InputStream inputStream = socket.getInputStream();
			//output stream to send message
			OutputStream outputStream = socket.getOutputStream();
			//send message to server
			outputStream.write(messageToTransmit.toString().getBytes());
			//TODO implement notification handler
			
			//close connection to server
			socket.close();
			return true;
		}catch(IOException e) {
			//TODO indicate connection fail in gui
			return false;
		}
	}
}
