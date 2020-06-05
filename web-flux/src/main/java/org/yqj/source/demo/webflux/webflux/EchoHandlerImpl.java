package org.yqj.source.demo.webflux.webflux;

import org.springframework.stereotype.Component;
import org.yqj.source.demo.webflux.domain.Person;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2018/8/15
 * Email: yaoqijunmail@foxmail.com
 */
@Component
public class EchoHandlerImpl implements EchoHandler{

    public reactor.core.publisher.Mono<org.springframework.web.reactive.function.server.ServerResponse> echo(org.springframework.web.reactive.function.server.ServerRequest request) {
        return org.springframework.web.reactive.function.server.ServerResponse.ok().body(request.bodyToMono(String.class), String.class);
    }

    @Override
    public reactor.core.publisher.Mono<Person> queryById(Integer id){
        return reactor.core.publisher.Mono.just(new Person(id, String.valueOf(id) + "-name HaHa", 18));
    }
}
