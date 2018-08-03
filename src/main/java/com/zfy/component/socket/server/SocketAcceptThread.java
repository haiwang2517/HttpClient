/**   
 *
 * @author HYL   
 * @date 2018��8��2�� ����4:41:20
 * @version 1.2.0
 * @since 1.2.0
 */
package com.zfy.component.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**   
 * 
 * @author HYL
 * @date 2018��8��2�� ����4:41:20
 * @version 1.2.0
 * @since 1.2.0
 */
public class SocketAcceptThread implements Runnable {

	private Socket socket;
	
	public SocketAcceptThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(inputStream);
			BufferedReader inBufReader = new BufferedReader(inReader);
			String ret = null; 
			StringBuffer readMsg = new StringBuffer();
			while((ret = inBufReader.readLine()) != null){
				readMsg.append(ret);
			}
			
			System.out.println("��ַ["+socket.getInetAddress().getHostAddress()+"]��ȡ��������["+readMsg.toString()+"]");
			
//			MsgResultDto resultDto;
//			WebServiceReceptionMsgEvent msgEvent = new WebServiceReceptionMsgEvent(this, readMsg.toString(), socket.getInetAddress().getHostAddress());
//			publisher.publishEvent(msgEvent);
//			resultDto = msgEvent.getRestultDto();
			
			
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.print("����������");
			writer.flush();
			
			socket.shutdownOutput();
			
			inBufReader.close();
			inputStream.close();
			writer.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
