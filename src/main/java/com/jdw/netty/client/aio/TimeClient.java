/**   
 * @Title: TimeClient.java 
 * @Package com.jdw.netty.client.aio 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiadawei jiadawei@zehin.com.cn   
 * @date 2016年7月27日 下午3:32:03 
 * @version V1.0   
 */
package com.jdw.netty.client.aio;

/** 
 * @ClassName: TimeClient 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiadawei jiadawei@zehin.com.cn 
 * @date 2016年7月27日 下午3:32:03 
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// 采用默认值
			}

		}
		new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-002").start();
	}
}
