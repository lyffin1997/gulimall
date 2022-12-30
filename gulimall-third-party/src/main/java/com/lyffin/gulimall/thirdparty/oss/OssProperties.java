package com.lyffin.gulimall.thirdparty.oss;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "alicloud")
@NoArgsConstructor
@AllArgsConstructor
public class OssProperties {

    private String accessKey;
    private String secretKey;
    private String endpoint;

}
