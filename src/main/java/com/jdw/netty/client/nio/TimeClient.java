/**   
 * @Title: TimeClient.java 
 * @Package com.jdw.netty.client.nio 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiadawei jiadawei@zehin.com.cn   
 * @date 2016年7月20日 下午3:51:22 
 * @version V1.0   
 */
package com.jdw.netty.client.nio;

/** 
 * @ClassName: TimeClient 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiadawei jiadawei@zehin.com.cn 
 * @date 2016年7月20日 下午3:51:22 
 */
public class TimeClient {
	public static void main(String[] args) {
		int port=8080;

		if (args != null && args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {

			}
		}
		
		new Thread(new TimeClientHandle("127.0.0.1", port),"TimeClient-001").start();
	}
}
