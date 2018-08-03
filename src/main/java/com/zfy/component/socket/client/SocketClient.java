/**   
 *
 * @author HYL   
 * @date 2018��8��2�� ����3:50:47
 * @version 1.2.0
 * @since 1.2.0
 */
package com.zfy.component.socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**   
 * 
 * @author HYL
 * @date 2018��8��2�� ����3:50:47
 * @version 1.2.0
 * @since 1.2.0
 */
public class SocketClient {
	
	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		client.send();
	}
	
	public void send(){
		try {
			Socket socket = new Socket("localhost", 7777);
			OutputStream out = socket.getOutputStream();
			PrintWriter outWriter = new PrintWriter(out);
			BufferedWriter bw = new BufferedWriter(outWriter);
			bw.write("���ֶܷ���");
			bw.flush();
			socket.shutdownOutput();
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader bufferReader = new BufferedReader(inputReader);
			String ret = "";
			StringBuffer readerMsg = new StringBuffer();
			while( (ret = bufferReader.readLine())!= null){
				readerMsg.append(ret);
			}
			System.out.println("�ͻ��˽��յ��������ķ���["+readerMsg.toString()+"]");
			bufferReader.close();
			inputStream.close();
			outWriter.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
