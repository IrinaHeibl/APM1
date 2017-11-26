package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientBase implements IClient {

	/*----------------------------
	 * variables
	 -----------------------------*/
	private String targetIp;
	private int targetPort;
	
	private JFrame serverAppFrame;
	private JPanel serverMainPane;

	private JPanel configurationPane;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JButton sendMessageButton;

	private JTextArea messageTextArea;
	
	/*----------------------------
	 * constructors
	 -----------------------------*/
	
	/**
	 * default constructor, initialises gui
	 */
	public ClientBase() {
		initGUI("");
	}

	/**
	 * constructor, initialising gui
	 * @param string guiName (window name - jframe)
	 */
	public ClientBase(String guiName){
		if(guiName != null) initGUI(guiName);
	}
	
	/*----------------------------
	 * getters'n'setters
	 -----------------------------*/

	public JFrame getServerAppFrame() {
		return serverAppFrame;
	}

	public void setServerAppFrame(JFrame serverAppFrame) {
		this.serverAppFrame = serverAppFrame;
	}

	public JPanel getServerMainPane() {
		return serverMainPane;
	}

	public void setServerMainPane(JPanel serverMainPane) {
		this.serverMainPane = serverMainPane;
	}

	public JPanel getConfigurationPane() {
		return configurationPane;
	}

	public void setConfigurationPane(JPanel configurationPane) {
		this.configurationPane = configurationPane;
	}

	public JTextField getIpTextField() {
		return ipTextField;
	}

	public void setIpTextField(JTextField ipTextField) {
		this.ipTextField = ipTextField;
	}

	public JTextField getPortTextField() {
		return portTextField;
	}

	public void setPortTextField(JTextField portTextField) {
		this.portTextField = portTextField;
	}

	public JButton getSendMessageButton() {
		return sendMessageButton;
	}

	public void setSendMessageButton(JButton sendMessageButton) {
		this.sendMessageButton = sendMessageButton;
	}

	public JTextArea getMessageTextArea() {
		return messageTextArea;
	}

	public void setMessageTextArea(JTextArea messageTextArea) {
		this.messageTextArea = messageTextArea;
	}

	public String getTargetIp() {
		return targetIp;
	}


	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}


	public int getTargetPort() {
		return targetPort;
	}


	public void setTargetPort(int targetPort) {
		this.targetPort = targetPort;
	}

	/*----------------------------
	 * methods
	 -----------------------------*/
	
	/**
	 * initialises gui
	 * @param string guiName (window name - jframe)
	 */
	public void initGUI(String guiName) {
		//init application window
		if(guiName != null) {
			serverAppFrame = new JFrame(guiName);
		}else {
			serverAppFrame = new JFrame();
		}
		//-set application window size
		serverAppFrame.setPreferredSize(new Dimension(800,600));
		//-set default close operation - terminate gui
		serverAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//init main container
		serverMainPane = new JPanel();
		serverMainPane.setLayout(new BorderLayout());
		serverMainPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		//init configuration components
		configurationPane = new JPanel();
		configurationPane.setLayout(new FlowLayout());
		ipTextField = new JTextField("127.0.0.1");
		ipTextField.setHorizontalAlignment(JTextField.CENTER);
		configurationPane.add(new JLabel("ip: "));
		configurationPane.add(ipTextField);
		portTextField = new JTextField("8080");
		portTextField.setHorizontalAlignment(JTextField.CENTER);
		configurationPane.add(new JLabel(" : "));
		configurationPane.add(portTextField);
		serverMainPane.add(configurationPane, BorderLayout.NORTH);
		//init message text area
		messageTextArea = new JTextArea();
		serverMainPane.add(messageTextArea, BorderLayout.CENTER);
		//init send button
		sendMessageButton = new JButton("Send");
		sendMessageButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO implement send message
			}
		});
		serverMainPane.add(sendMessageButton, BorderLayout.SOUTH);
		
		//add main container to frame
		serverAppFrame.add(serverMainPane);

		//size & show gui
		serverAppFrame.pack();
		serverAppFrame.setVisible(true);

		//focus message text area
		messageTextArea.requestFocusInWindow();
	}
	
	public boolean sendMessage(IMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

}
