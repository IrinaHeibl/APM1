package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerBase implements IServer {

	/*----------------------------
	 * variables
	 -----------------------------*/
	private JFrame serverAppFrame;
	private JPanel serverMainPane;

	private JPanel configurationPane;
	private JTextField ipTextField;
	private JTextField portTextField;
	private JToggleButton startServerButton;
	private JLabel statusServerTextField;

	private JTextArea messageTextArea;

	/*----------------------------
	 * constructors
	 -----------------------------*/
	
	/**
	 * default constructor, initialises gui
	 */
	public ServerBase() {
		initGUI("");
	}

	/**
	 * constructor, initialising gui
	 * @param string guiName (window name - jframe)
	 */
	public ServerBase(String guiName){
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

	public JToggleButton getStartServerButton() {
		return startServerButton;
	}

	public void setStartServerButton(JToggleButton startServerButton) {
		this.startServerButton = startServerButton;
	}

	public JLabel getStatusServerTextField() {
		return statusServerTextField;
	}

	public void setStatusServerTextField(JLabel statusServerTextField) {
		this.statusServerTextField = statusServerTextField;
	}

	public JTextArea getMessageTextArea() {
		return messageTextArea;
	}

	public void setMessageTextArea(JTextArea messageTextArea) {
		this.messageTextArea = messageTextArea;
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
		startServerButton = new JToggleButton("Start Server");
		//- start server button listener
		startServerButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					indicateServerStartup();
					if(startServer()) indicateServerStarted();
				}
				if(e.getStateChange() == ItemEvent.DESELECTED){
					if(stopServer()) indicateServerStopped();
				}
			}
		});
		configurationPane.add(startServerButton);
		statusServerTextField = new JLabel("server not running");
		statusServerTextField.setBackground(Color.RED);
		statusServerTextField.setOpaque(true);
		statusServerTextField.setEnabled(false);
		configurationPane.add(statusServerTextField);
		serverMainPane.add(configurationPane, BorderLayout.NORTH);
		//init message text area
		messageTextArea = new JTextArea();
		serverMainPane.add(messageTextArea, BorderLayout.CENTER);

		//add main container to frame
		serverAppFrame.add(serverMainPane);

		//size & show gui
		serverAppFrame.pack();
		serverAppFrame.setVisible(true);

		//focus message text area
		messageTextArea.requestFocusInWindow();
	}

	/**
	 * return port from Server.portTextField
	 * @return int
	 */
	public int getPort() {
		return Integer.valueOf(portTextField.getText());
	}

	/**
	 * return ip address from Server.ipTextField
	 * @return string
	 */
	public String getIp() {
		return ipTextField.getText();
	}

	/**
	 * returns content from Server.messageTextArea
	 * @return string
	 */
	public String getMessage() {
		return messageTextArea.getText();
	}

	/**
	 * modifies gui to indicate server has started
	 */
	public void indicateServerStarted() {
		statusServerTextField.setBackground(Color.GREEN);
		statusServerTextField.setText("server running");
		serverAppFrame.repaint();
	}

	/**
	 * modifies gui to indicate server has stopped
	 */
	public void indicateServerStopped() {
		statusServerTextField.setBackground(Color.RED);
		statusServerTextField.setText("server not running");
		serverAppFrame.repaint();
	}

	/**
	 * modifies gui to indicate server is starting up
	 */
	public void indicateServerStartup() {
		statusServerTextField.setBackground(Color.YELLOW);
		statusServerTextField.setText("starting server");
		serverAppFrame.repaint();
	}
	
	/**
	 * start server (empty per default)
	 * @return true on success, false on failure (true per default)
	 */
	public boolean startServer() {
		return true;
	}
	
	/**
	 * stop server (empty per default)
	 * @return true on success, false on failure (true per default)
	 */
	public boolean stopServer() {
		return true;
	}

	public boolean acceptIncomingConnection() {
		// TODO implement
		return false;
	}

	public boolean handleIncomingConnection() {
		// TODO implement
		return false;
	}

	public boolean sendNotification() {
		// TODO implement
		return false;
	}


}
