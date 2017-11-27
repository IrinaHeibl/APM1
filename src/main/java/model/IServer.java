package model;

public interface IServer {

	/**
	 * ip adress of server
	 * @return string
	 */
	public String getIp();
	
	/**
	 * port server is using
	 * @return int
	 */
	public int getPort();
	/**
	 * send message to target ip using server port
	 * @param String targetIp
	 * @param IMessage message
	 * @return
	 */
	/**
	 * accept incoming connection listening to server port
	 * @return true upon success, false upon failure
	 */
	public boolean acceptIncomingConnection();
	/**
	 * handle incoming connection
	 * @return true upon success, false upon failure
	 */
	public boolean handleIncomingConnection();
	/**
	 * send notification of received message to sender
	 * @return true upon success, false upon failure
	 */
	public boolean sendNotification();
}
