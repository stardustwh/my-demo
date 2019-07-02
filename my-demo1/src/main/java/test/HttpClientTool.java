package test;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HttpClientTool {
	 private static Log log = LogFactory.getLog(HttpClientTool.class); 

     /** 
      * 执行一个HTTP GET请求，返回请求响应的HTML 
      * 
      * @param url                 请求的URL地址 
      * @param queryString 请求的查询参数,可以为null 
      * @param charset         字符集 
      * @param pretty            是否美化 
      * @return 返回请求响应的HTML 
      */ 
     public static String httpget(String url, String queryString,boolean pretty) { 
             StringBuffer response = new StringBuffer(); 
             HttpClient client = new HttpClient(); 
             try { 
            	 HttpMethod method = new GetMethod(URIUtil.encodeQuery(url)); 
                 if (StringUtils.isNotBlank(queryString)) 
                         //对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串 
                         method.setQueryString(URIUtil.encodeQuery(queryString)); 
                 client.executeMethod(method); 
                 if (method.getStatusCode() == HttpStatus.SC_OK) { 
                         BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8")); 
                         String line; 
                         while ((line = reader.readLine()) != null) { 
                                 if (pretty) 
                                         response.append(line).append(System.getProperty("line.separator"));
                                 else 
                                         response.append(line); 
                         } 
                         reader.close(); 
                 } 
                 method.releaseConnection(); 
             } catch (URIException e) { 
                     log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
             } catch (IOException e) { 
                     log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
             } finally { 
                     
             } 
             return response.toString(); 
     } 

     /**
 	 * JSON+HTTP POST
 	 * 
 	 * @param url
 	 * @param jsonStr
 	 * @return String
 	 * @throws CommException
 	 */
 	public static String httpPost(String url, NameValuePair[] data)
 			throws Exception {
 		// TODO Auto-generated method stub
 		HttpClient httpClient = new HttpClient();
 	
 		PostMethod postMethod = new PostMethod(url);
 		
 		// 设置编码,httppost同时会用编码进行url.encode
 		httpClient.getParams().setContentCharset("UTF-8");
         postMethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
 		// 将表单的值放入postMethod中
 		postMethod.setRequestBody(data);
 		// 执行postMethod
 		int statusCode = 0;
 		try {
 			statusCode = httpClient.executeMethod(postMethod);
 		} catch (HttpException e) {
 			//logger.error(e.getMessage());
 		} catch (IOException e) {
 			//logger.error(e.getMessage());
 		}
 		// HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发
 		// 301或者302
 		if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
 				|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
 			// 从头中取出转向的地址
 			Header locationHeader = postMethod.getResponseHeader("location");
 			String location = null;
 			if (locationHeader != null) {
 				location = locationHeader.getValue();
 				//logger.error("The page was redirected to:" + location);
 			} else {
 				//logger.error("Location field value is null.");
 			}
 			return null;
 		} else {
 			String str = "";
 			try {
 				str = postMethod.getResponseBodyAsString();
 				return str;
 			} catch (IOException e) {
 				//logger.error(e.getMessage());
 			}
 		}
 		return null;
 	}
}

