package com.status204.nacosprovider.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by status200 on 2019/11/17.
 */
@Component
@RefreshScope
@Data
@Slf4j
public class ConfigProperties {

    @Value("${third.service.host}")
    private String thirdServiceHost;

    @Value("${local.id}")
    private String localID;

    // 注入Environment以便拿到变化后的值
    @Autowired
    private Environment env;

    // 目前版本暂时不支持
    @NacosConfigListener(dataId = "provider")
    public void onMessage(Properties config) {
        log.info("config changed: {}", config);
    }

    @EventListener(EnvironmentChangeEvent.class)
    public void refreshEvent(EnvironmentChangeEvent event) {
        StringBuilder mes = new StringBuilder();
        mes.append("listening config event\n");

        // 遍历所有变化后的key,从environment中拿到值并输出
        for (String key : event.getKeys()) {
            mes.append("changed properties key=").append(key).append(", new value=").append(env.getProperty(key)).append("\n");
        }

        log.info(mes.toString());
    }
}
