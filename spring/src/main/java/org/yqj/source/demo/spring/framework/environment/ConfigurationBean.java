package org.yqj.source.demo.spring.framework.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2022/1/11
 * Email: yaoqijunmail@foxmail.com
 */
//@Configuration
public class ConfigurationBean {

    @Value("${config.value_first:value_first}")
    private String valueFirst;

    @Value("${config.value_second:value_second}")
    private String valueSecond;
}
