package com.test;

//import com.qcloud.cos.COSClient;
//import com.qcloud.cos.ClientConfig;
//import com.qcloud.cos.auth.BasicCOSCredentials;
//import com.qcloud.cos.auth.COSCredentials;
//import com.qcloud.cos.model.GetObjectRequest;
//import com.qcloud.cos.model.ObjectMetadata;
//import com.qcloud.cos.region.Region;
//import com.wisdomregulation.pdflink.DownLoaderTask;
//import utils.Util_Http;
//
//import java.io.File;


public class TestPost {

    public static void main(String[] args) throws InterruptedException {
//        COSCredentials cred = new BasicCOSCredentials("AKIDe7LK4YDqhIdiZAlfgSzHK8h041jCRREm", "RdfRxEF2ZrtlOllYYMuDeroWyB9rKcx3");
//        ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
//// 3 生成cos客户端
//        COSClient cosClient = new COSClient(cred, clientConfig);
//        String bucketName = "66vrht-1253423617";
//        File downFile = new File("D:\\App\\AIDE\\Fonts\\Font.zip");
//        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, "Font.zip");
//        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
//        String simdir="D:\\App\\AIDE\\Fonts\\";
//        DownLoaderTask.getInstance().setListener(null).downloadFileandcompression("https://www.dropbox.com/s/jyohe37dr9edg9h/Font.zip?dl=0", simdir);
//    	//发送 GET 请求
//        String s = Util_Http.sendGet("http://fanyi.youdao.com/openapi.do?keyfrom=srxffcc1&key=188764344&type=data&doctype=json&version=1.1&q=%E5%A5%BD", "");
//        System.out.println(s);
//        
//        //发送 POST 请求
//        String sr=Util_Http.sendPost("http://fanyi.youdao.com/openapi.do?", "keyfrom=srxffcc1&key=188764344&type=data&doctype=json&version=1.1&q=%E5%A5%BD");
//        System.out.println(sr);
//        new ReadByPost().start();
//        Thread.sleep(10000);
    }

}

//class ReadByPost extends Thread{
//    @Override
//    public void run() {
//        try {
//
//
//            URL url = new URL("http://fanyi.youdao.com/openapi.do");
//            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//            connection.addRequestProperty("encoding", "UTF-8");
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//
//            connection.setRequestMethod("POST");
//
//            OutputStream os = connection.getOutputStream();
//            OutputStreamWriter osw = new OutputStreamWriter(os);
//            BufferedWriter bw = new BufferedWriter(osw);
//
//
//            bw.write("keyfrom=srxffcc1&key=188764344&type=data&doctype=json&version=1.1&q=Microsoft");
//            bw.flush();
//            connection.connect();
//            InputStream is = connection.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//
//            String line;
//            StringBuilder builder = new StringBuilder();
//            while((line = br.readLine()) != null){
//                builder.append(line);
//            }
//
//            bw.close();
//            osw.close();
//            os.close();
//
//            br.close();
//            isr.close();
//            is.close();
//
//            System.out.println(builder.toString());
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
