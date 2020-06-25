package com.xandone.sharerent.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequestUtil {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    public static String sendGet(String servletUrl) {
    	String result = "";
    	BufferedReader in = null;
    	try {
    		URL realUrl = new URL(servletUrl);
    		// 打开和URL之间的连接
    		URLConnection connection = realUrl.openConnection();
    		// 设置通用的请求属性
    		connection.setRequestProperty("accept", "*/*");
    		connection.setRequestProperty("connection", "Keep-Alive");
    		connection.setRequestProperty("user-agent",
    				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    		// 建立实际的连接
    		connection.connect();
    		// 获取所有响应头字段
    		Map<String, List<String>> map = connection.getHeaderFields();
    		// 遍历所有的响应头字段
    		for (String key : map.keySet()) {
    			System.out.println(key + "--->" + map.get(key));
    		}
    		// 定义 BufferedReader输入流来读取URL的响应
    		in = new BufferedReader(new InputStreamReader(
    				connection.getInputStream()));
    		String line;
    		while ((line = in.readLine()) != null) {
    			result += line;
    		}
    	} catch (Exception e) {
    		System.out.println("发送GET请求出现异常！" + e);
    		e.printStackTrace();
    	}
    	// 使用finally块来关闭输入流
    	finally {
    		try {
    			if (in != null) {
    				in.close();
    			}
    		} catch (Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    	return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");// 设置 URLConnection的接收的文件类型
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");// 检查浏览页面的访问者在用什么操作系统（包括版本号）浏览器（包括版本号）和用户个人偏好
            conn.setRequestProperty("Accept-Charset", "utf-8");// 设置 HttpURLConnection的字符编码
            conn.setRequestProperty("contentType", "application/x-www-form-urlencoded; charset=UTF-8");//c#
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
//            out.print(new String(param.getBytes("utf-8"), "utf-8"));
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
            in = new BufferedReader(
            		new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    public static String sendPost(String servletUrl) {
    	PrintWriter out = null;
    	BufferedReader in = null;
    	String result = "";
    	try {
    		URL realUrl = new URL(servletUrl);
    		// 打开和URL之间的连接
    		URLConnection conn = realUrl.openConnection();
    		// 设置通用的请求属性
    		conn.setRequestProperty("accept", "*/*");// 设置 URLConnection的接收的文件类型
    		conn.setRequestProperty("connection", "Keep-Alive");
    		conn.setRequestProperty("user-agent",
    				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");// 检查浏览页面的访问者在用什么操作系统（包括版本号）浏览器（包括版本号）和用户个人偏好
    		conn.setRequestProperty("Accept-Charset", "utf-8");// 设置 HttpURLConnection的字符编码
    		conn.setRequestProperty("contentType", "application/x-www-form-urlencoded; charset=UTF-8");//c#
    		// 发送POST请求必须设置如下两行
    		conn.setDoOutput(true);
    		conn.setDoInput(true);
    		// 获取URLConnection对象对应的输出流
    		out = new PrintWriter(conn.getOutputStream());
    		// 发送请求参数
//            out.print(new String(param.getBytes("utf-8"), "utf-8"));
    		// flush输出流的缓冲
    		out.flush();
    		// 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
    		in = new BufferedReader(
    				new InputStreamReader(conn.getInputStream(), "utf-8"));
    		String line;
    		while ((line = in.readLine()) != null) {
    			result += line;
    		}
    	} catch (Exception e) {
    		System.out.println("发送 POST 请求出现异常！"+e);
    		e.printStackTrace();
    	}
    	//使用finally块来关闭输出流、输入流
    	finally{
    		try{
    			if(out!=null){
    				out.close();
    			}
    			if(in!=null){
    				in.close();
    			}
    		}
    		catch(IOException ex){
    			ex.printStackTrace();
    		}
    	}
    	return result;
    }
    
    /**
     * 向指定 URL 发送POST方法的(参数经Utf8方式编码后的)请求，param要先进行URLEncoder.encode(jsonStr, "utf-8")方式编码
     * 
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPostUtf8(String url, String param) {
    	DataOutputStream out = null;//数据输出流
    	BufferedReader in = null;//数据输入流，即返回的响应信息
    	String result = "";
    	try {
    		//建立连接
    		URL postUrl = new URL(url);
    		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
    		//设置参数
    		connection.setDoOutput(true);	//需要输出
    		connection.setDoInput(true);	//需要输入
    		connection.setUseCaches(false); //不允许缓存
    		connection.setRequestMethod("POST");//设置POST方式连接
    		connection.setInstanceFollowRedirects(true);
    		//设置请求属性
    		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    		connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
    		connection.setRequestProperty("Charset", "UTF-8");
    		//连接,也可以不用明文connect，使用下面的connection.getOutputStream()会自动connect
    		connection.connect();
    		//建立输入流，向指向的URL传入参数
    		out = new DataOutputStream(connection.getOutputStream());
    		//组装post请求参数
//    		String param = "data=" + URLEncoder.encode(data, "utf-8") + "&token=" + token;
    		System.out.println("param=" +param);
    		out.writeBytes(param);// 将字符串按字节顺序写出到基础输出流中
    		out.flush();// 刷新此输出流并强制写出所有缓冲的输出字节
    		out.close();
    		
			// 获得响应状态
			int resultCode = connection.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				// 定义BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				while ((readLine = in.readLine()) != null) {
					sb.append(readLine);
				}
				in.close();
				result = sb.toString();
				System.out.println(result);
			}
    	    
    	} catch (Exception e) {
    		System.out.println("发送 POST 请求出现异常！"+e);
    		e.printStackTrace();
    	}
    	//使用finally块来关闭输出流、输入流
    	finally{
    		try{
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
    		}
    		catch(IOException ex){
    			ex.printStackTrace();
    		}
    	}
    	return result;
    }

    /**
     * 向指定 URL 发送POST方法的(参数经Utf8方式编码后的)请求，param要先进行URLEncoder.encode(jsonStr, "utf-8")方式编码
     * 
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param authString
     * 			  授权字符串base64(appKey:masterSecret)
     * @return 所代表远程资源的响应结果
     */
    public static String sendPostUtf8(String url, String param, String authString) {
    	DataOutputStream out = null;//数据输出流
    	BufferedReader in = null;//数据输入流，即返回的响应信息
    	String result = "";
    	try {
    		//建立连接
    		URL postUrl = new URL(url);
    		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
    		//设置参数
    		connection.setDoOutput(true);	//需要输出
    		connection.setDoInput(true);	//需要输入
    		connection.setUseCaches(false); //不允许缓存
    		connection.setRequestMethod("POST");//设置POST方式连接
    		connection.setInstanceFollowRedirects(true);
    		//设置请求属性
    		connection.setRequestProperty("Content-Type", "application/json");
    		connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
    		connection.setRequestProperty("Charset", "UTF-8");
    		connection.setRequestProperty("Authorization", "Basic " + authString);
    	
    		//连接,也可以不用明文connect，使用下面的connection.getOutputStream()会自动connect
    		connection.connect();
    		//建立输入流，向指向的URL传入参数
    		out = new DataOutputStream(connection.getOutputStream());
    		//组装post请求参数
//    		String param = "data=" + URLEncoder.encode(data, "utf-8") + "&token=" + token;
    		System.out.println(param);
    		out.writeBytes(param);// 将字符串按字节顺序写出到基础输出流中
    		out.flush();// 刷新此输出流并强制写出所有缓冲的输出字节
    		out.close();
    		
			// 获得响应状态
			int resultCode = connection.getResponseCode();
			//if (HttpURLConnection.HTTP_OK == resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				// 定义BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				while ((readLine = in.readLine()) != null) {
					sb.append(readLine);
				}
				in.close();
				result = sb.toString();
				System.out.println(result);
			//}
    	    
    	} catch (Exception e) {
    		System.out.println("发送 POST 请求出现异常！"+e);
    		e.printStackTrace();
    	}
    	//使用finally块来关闭输出流、输入流
    	finally{
    		try{
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
    		}
    		catch(IOException ex){
    			ex.printStackTrace();
    		}
    	}
    	return result;
    }
}
