package model;

import java.io.IOException;
import java.io.InputStream;
//import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MLLPServer extends ServerBase {

	private boolean serverRunning;
	
	public MLLPServer() {
		super("MLLP Server");
	}
	
	@Override
	public boolean acceptIncomingConnection() {
		try {
			//start server listening to port
			ServerSocket serverSocket = new ServerSocket(getPort());
			//server initialised & listening
			serverRunning = true;
			//TODO split methods - initialise server & accept incoming connection
			indicateServerStarted();
			
			int recievedMessage;
			//TODO buffer size fixed for development state
			byte[] recievedMessageBuffer = new byte[200];
			
			while(serverRunning) {
				Socket clientSocket = serverSocket.accept();
				//TODO indicate in gui client connected
				//incoming input & output stream
				InputStream inputStream = clientSocket.getInputStream();
				//OutputStream outputStream = clientSocket.getOutputStream();
				//get incoming message
				recievedMessage = inputStream.read(recievedMessageBuffer);
				//handle incoming message
				IMessage message = new HL7Message(new String(recievedMessageBuffer));
				handleIncomingMessage(message);
				//TODO implement notification
				//close connection
				clientSocket.close();
			}
			
			return true;
		}catch(IOException e) {
			//TODO indicate errors in gui
			return false;
		}
	}
	
	@Override
	public boolean handleIncomingMessage(IMessage message) {
		getMessageTextArea().setText(message.toString());
		return true;
	}
}
