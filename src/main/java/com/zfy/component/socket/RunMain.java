/**   
 *
 * @author HYL   
 * @date 2018年8月2日 下午3:07:04
 * @version 1.2.0
 * @since 1.2.0
 */
package com.zfy.component.socket;

import com.zfy.component.socket.server.SocketMain;

/**   
 * 
 * @author HYL
 * @date 2018年8月2日 下午3:07:04
 * @version 1.2.0
 * @since 1.2.0
 */
public class RunMain {

	/**
	 * @param args
	 * @author HYL   
	 * @date 2018年8月2日 下午3:07:04
	 */
	public static void main(String[] args) {
		SocketMain.getInstance().start(8888);
		System.out.println("结束");
		
	}

}
