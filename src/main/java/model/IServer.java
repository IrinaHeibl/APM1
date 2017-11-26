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
	public boolean sendMessage(String targetIp, IMessage message);
}
