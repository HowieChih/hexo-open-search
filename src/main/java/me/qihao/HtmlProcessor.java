package me.qihao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * index page processor
 */
public class HtmlProcessor {

    private static final Logger logger = LoggerFactory.getLogger(HtmlProcessor.class);

    static void process(File htmlFile, String title) {
        if (!htmlFile.exists()) {
            logger.info("读取文件目录：" + htmlFile.getAbsolutePath());
            logger.info("index.html文件不存在，请在该文件目录下运行程序");
        } else {
            try {
                logger.info("开始解析index.html");
                Document doc = Jsoup.parse(htmlFile, "UTF-8");
                Element head = doc.head();

                logger.info("开始添加OpenSearch引用");
                head.appendElement("link")
                        .attr("rel", "search")
                        .attr("title", title)
                        .attr("href", "/opensearch.xml")
                        .attr("type", "application/opensearchdescription+xml");

                logger.info("回写文件...");
                FileOutputStream fos = new FileOutputStream(htmlFile, false);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(doc.html());
                osw.close();

                logger.info("成功添加OpenSearch");
            } catch (IOException e) {
                logger.error("程序运行出错：" + e.getMessage());
            }
        }
    }

    static void process(String htmlPath, String title) {
        File htmlFile = new File(htmlPath);
        process(htmlFile, title);
    }

    static void process(String title) {
        String htmlPath = "index.html";
        process(htmlPath, title);
    }

}
