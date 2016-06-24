/**   
 * @Title: TimeClient.java 
 * @Package com.jdw.netty.client.bio 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author jiadawei jiadawei@zehin.com.cn   
 * @date 2016年6月23日 下午5:58:08 
 * @version V1.0   
 */
package com.jdw.netty.client.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** 
 * @ClassName: TimeClient 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author jiadawei jiadawei@zehin.com.cn 
 * @date 2016年6月23日 下午5:58:08 
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
		
		Socket socket=null;
		
		BufferedReader in=null;
		
		PrintWriter out=null;
		
		try {
			socket=new Socket("127.0.0.1",port);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out=new PrintWriter(socket.getOutputStream(),true);
			out.println("QUERY TIME ORDER");
			System.out.println("send order 2 server succeed.");
			String resp=in.readLine();
			System.out.println("Now is : "+resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (out != null) {
				out.close();
				out = null;
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				socket = null;
			}
		}
		
	}
}
