package me.kkang.tools.bridge_server.config;

import me.kkang.tools.bridge_server.socket.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class BeforeStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(BeforeStartup.class);

    @Autowired
    private Server server;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("spring加载完毕，开始自定义初始化......");
        //系统配置
        server.init();
        //other tod...

    }

}
