package com.wisdomregulation.pdflink;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.event.COSProgressListener;
import com.qcloud.cos.event.ProgressEvent;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.PersistableTransfer;
import net.lingala.zip4j.exception.ZipException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by King6rf on 2017/7/12. 239 11.28日使用腾讯云
 */
public class DownLoaderTask {
//    public static final String qiniuhost="http://optlspedt.bkt.clouddn.com/";
    private String SecretId = "AKIDe7LK4YDqhIdiZAlfgSzHK8h041jCRREm";;
    private String SecretKey = "RdfRxEF2ZrtlOllYYMuDeroWyB9rKcx3";;
    private String region_name = "ap-chengdu";;
    private String bucketName = "66vrht-1253423617";;
    DownLoaderListener listener=new DownLoaderListener() {
        @Override
        public void downloadstart() {
            //PdfFactoryLog.println("开始下载");
        }

        @Override
        public void downloadin(int now, int total) {
            float jindu=now/total;
            //PdfFactoryLog.println("下载进度"+now+"/"+total);
        }

        @Override
        public void downloadend() {
            //PdfFactoryLog.println("结束下载");
        }

        @Override
        public void compressionstart() {
            //PdfFactoryLog.println("开始解压");
        }

        @Override
        public void compressionin(int now, int total) {
            //PdfFactoryLog.println("解压进度"+now+"/"+total);
        }

        @Override
        public void compressionend() {
            //PdfFactoryLog.println("结束解压");
        }
    };
    private static final DownLoaderTask instance=new DownLoaderTask();

    private DownLoaderTask(){

    }

    public DownLoaderTask setListener(DownLoaderListener listener) {
        if(listener!=null){
            this.listener = listener;
        }

        return  this;
    }

    public static DownLoaderTask getInstance(){
        return  instance;
    }
    /**
     *
     * @param desfile
     *            网盘目标文件
     * @param downloadDir
     *            下载存放目录
     * @return 返回下载文件
     */
    public File downloadFile(String desfile, String downloadDir) {
        COSCredentials cred = new BasicCOSCredentials(SecretId, SecretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region_name));
// 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);

        File file = new File(downloadDir+"/"+desfile);
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, desfile);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, file);
//        File file = new File(downloadDir+"/"+desfile);
//        try {
//            // 统一资源
//            if(listener!=null){
//                listener.downloadstart();
//            }
//            URL url = new URL(desfile);
//            // 连接类的父类，抽象类
//            URLConnection urlConnection = url.openConnection();
//            // http的连接类
//            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
//            // 设定请求的方法，默认是GET
//            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
//            // 设置字符编码
//            httpURLConnection.setRequestProperty("Charset", "UTF-8");
//            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
//            httpURLConnection.connect();
//
//            // 文件大小
//            int fileLength = httpURLConnection.getContentLength();
//
//            // 文件名
//            String filePathUrl = httpURLConnection.getURL().getFile();
//            String fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);
//
//            //PdfFactoryLog.println("file length---->" + fileLength);
//
//            URLConnection con = url.openConnection();
//
//            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
//
//            String path = downloadDir + File.separatorChar + fileFullName;
//            if("".equals(downloadDir)){
//                path=fileFullName;
//            }
//            file = new File(path);
//            if (!file.getParentFile().exists()) {
//                file.getParentFile().mkdirs();
//            }
//            OutputStream out = new FileOutputStream(file);
//            int size = 0;
//            int len = 0;
//            byte[] buf = new byte[1024];
//            while ((size = bin.read(buf)) != -1) {
//                len += size;
//                out.write(buf, 0, size);
//                if(listener!=null){
//                    listener.downloadin(len,fileLength);
//                }
//                // 打印下载百分比
//                // //PdfFactoryLog.println("下载了-------> " + len * 100 / fileLength +
//                // "%\n");
//            }
//            bin.close();
//            out.close();
//            if(listener!=null){
//                listener.downloadend();
//            }
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            if(file!=null){
//                file.delete();
//            }
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            if(file!=null){
//                file.delete();
//            }
//            e.printStackTrace();
//        } finally {
//
//        }
        return file;

    }
    /**
     *
     * @param urlPath
     *            下载路径
     * @param downloadDir
     *            下载存放目录
     * @return 返回下载文件
     */
    public DownLoaderTask downloadFileandcompression(String urlPath, String downloadDir) {
        File file = downloadFile(urlPath,downloadDir);
        decompression(file.getAbsolutePath(),downloadDir);
        return  this;

    }
    private DownLoaderTask decompression(String zipfilestring,String dir){
        try {
            if(listener!=null){
                listener.compressionstart();
            }
            net.lingala.zip4j.core.ZipFile zipFile=new net.lingala.zip4j.core.ZipFile(zipfilestring);
            List fileHeaderList = zipFile.getFileHeaders();
                int number = fileHeaderList.size();
                for (int i = 0; i < number; i++) {
                    zipFile.extractFile((net.lingala.zip4j.model.FileHeader) fileHeaderList.get(i), dir);
                    if(listener!=null){
                        listener.compressionin(i+1,number);
                    }
                }

        } catch (ZipException e) {
            e.printStackTrace();
        }
        if(listener!=null){
            listener.compressionend();
        }
        return  this;

    }
    public interface  DownLoaderListener{
        void  downloadstart();
        void downloadin(int now,int total);
        void  downloadend();
        void compressionstart();
        void compressionin(int now,int total);
        void compressionend();
    }
}
