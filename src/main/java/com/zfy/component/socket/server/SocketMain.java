/**   
 *
 * @author HYL   
 * @date 2018年8月2日 下午3:09:32
 * @version 1.2.0
 * @since 1.2.0
 */
package com.zfy.component.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * 
 * @author HYL
 * @date 2018年8月2日 下午3:09:32
 * @version 1.2.0
 * @since 1.2.0
 */
public class SocketMain {
	
	private static SocketMain socketMain;
	
	private ExecutorService mThreadPool;
	
	private boolean isStrart;
	
	public static SocketMain getInstance(){
		if( socketMain == null ){
			synchronized (SocketMain.class) {
				if( socketMain == null ){
					socketMain = new SocketMain();
				}
			}
		}
		return socketMain;
	}
	
	private SocketMain(){
		initThread();
	} 
	
	private void initThread(){
		mThreadPool = Executors.newCachedThreadPool();
	}

	/**
	 * 启动Socket服务，接收到的消息会通过WebServiceReceptionMsgEvent 抛出  requestIp 记录请求者的IP
	 * @param prot 服务端口
	 * @author HYL   
	 * @date 2018年8月2日 下午5:02:57
	 */
	public void start(int prot){
		if( this.isStrart == false ){
			this.isStrart = true;
		}
		
		ServerSocket serverSocket;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(prot);
			while( isStrart ){
				socket = serverSocket.accept();
				mThreadPool.execute(new SocketAcceptThread(socket));
			}
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		this.isStrart = false;
	}
	
}
