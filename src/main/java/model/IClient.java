package model;

public interface IClient {

	/**
	 * target ip address (server)
	 * @return String (format '127.0.0.1')
	 */
	public String getTargetIp();
	/**
	 * target port (server)
	 * @return int
	 */
	public int getTargetPort();
	/**
	 * send message to target ip:port (server)
	 * @param IMessage message
	 * @return true upon success, false upon failure
	 */
	public boolean sendMessage(IMessage message);
}
