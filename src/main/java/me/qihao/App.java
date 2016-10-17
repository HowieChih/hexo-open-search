package me.qihao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 主函数
 */
public class App {

    static {
        LogInitializer.init();
    }

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("start...");
        HtmlProcessor.process("Chih's Blog");
        logger.info("end.");
    }
}
