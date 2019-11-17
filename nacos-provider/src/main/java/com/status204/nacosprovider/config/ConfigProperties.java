package com.status204.nacosprovider.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by status200 on 2019/11/17.
 */
@Component
@RefreshScope
@Data
public class ConfigProperties {

    @Value("${third.service.host}")
    private String thirdServiceHost;

    @Value("${local.id}")
    private String localID;
}
