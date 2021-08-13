package org.yqj.source.demo.graphQl.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.GraphQlController;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/13
 * Email: yaoqijunmail@foxmail.com
 */
@GraphQlController
@Slf4j
public class GreetingController {

    @QueryMapping
    public String greeting() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return "Hello " + requestAttributes.getAttribute(RequestAttributeFilter.NAME_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
    }

}
