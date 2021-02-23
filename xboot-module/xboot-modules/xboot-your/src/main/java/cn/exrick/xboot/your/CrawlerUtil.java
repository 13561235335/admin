package cn.exrick.xboot.your;

import cn.exrick.xboot.core.common.utils.ResultUtil;
import cn.exrick.xboot.core.common.vo.Result;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CrawlerUtil {

    // 存线程安全的map
    public Result test(String link, String siteUrl, String cookie){
        ResultUtil result = new ResultUtil();
        Integer rCode = -1;
        String rUrl = "";
        BufferedReader reader=null;
        try {


            URL url = new URL("http://haitaoe.cn/index/index/parse.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接

            connection.setConnectTimeout(1000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(1000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false


            connection.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.setRequestProperty("Host", "haitaoe.cn");
            connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Content-Length", "57");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.setRequestProperty("Origin", "http://haitaoe.cn");
            connection.setRequestProperty("Referer", "http://haitaoe.cn/index/index/index.html");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4384.0 Safari/537.36");
            connection.setRequestProperty("Cookie", "think_lang=zh-cn; PHPSESSID=83a7eb5031ebaf61b21bb10c07f2f160; login=4d8cquIOPR6W46%2FLO5OLMrdhhi3mhf3I8ox0NRl3UX1x%2BXcMdlLIr0L7Qk0W52asPBJGTniJWduRL918BGM0M8zvXGEOet8hwAfiZ%2BcSirbm9h8j%2BzsqwiyKLW%2BYxx5Pi%2B8UYDMzkFhe4ozrSr4V69rd4Wgld2%2B%2FhapWEDQRt9TcXw1gjL6NNKP6");

            connection.connect();// 连接会话

            Map<String,Object> map = new HashMap<>();
            map.put("link","https://www.58pic.com/newpic/38712427.html");
            DataOutputStream out = new DataOutputStream(
                    connection.getOutputStream());// 打开输出流往对端服务器写数据
            String content=buildUrlQuery(map);
            out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
            out.flush();// 刷新
            out.close();// 关闭输出流

            reader=new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);

                Gson gson = new Gson();
                JsonObject map1 = gson.fromJson(line,JsonObject.class);
                JsonElement code = map1.get("code");
                if(code.getAsInt() == 200){
                    JsonObject map2 = gson.fromJson(map1.get("msg"),JsonObject.class);
                    rUrl = map2.get("立即下载").getAsString();
                    rCode = 200;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            rCode = 500;

        }finally {
            if(reader != null){
                try{
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        if (rCode == -1) {
            result.setErrorMsg(500, "系统异常");
            return result.setErrorMsg("错误");
        }else if(rCode == 500){
            return result.setErrorMsg(500,"系统异常");
        }
        return result.setData(rUrl);
    }


    private static String buildUrlQuery(Map<String, Object> querys) throws UnsupportedEncodingException {
        StringBuilder sbQuery = new StringBuilder();
        if (null != querys) {
            for (Map.Entry<String, Object> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (String.valueOf((query.getKey())).equals("null") && !String.valueOf((query.getValue().toString())).equals("null")) {
                    sbQuery.append(query.getValue());
                }
                if (!String.valueOf((query.getKey())).equals("null")) {
                    sbQuery.append(query.getKey());
                    if (!String.valueOf(query.getValue()).equals("null")) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue().toString(), "utf-8"));
                    }
                }
            }

        }

        return sbQuery.toString();
    }
}
