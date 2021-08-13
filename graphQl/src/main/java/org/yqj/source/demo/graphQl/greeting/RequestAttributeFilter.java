package org.yqj.source.demo.graphQl.greeting;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2021/8/13
 * Email: yaoqijunmail@foxmail.com
 */
@Component
public class RequestAttributeFilter implements Filter {

    public static final String NAME_ATTRIBUTE = RequestAttributeFilter.class.getName() + ".name";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setAttribute(NAME_ATTRIBUTE, "007");
        chain.doFilter(request, response);
    }
}
