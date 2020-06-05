package org.yqj.source.demo.webflux.webflux;


import org.yqj.source.demo.webflux.domain.Person;

/**
 * @author yaoqijun on 2017-11-05.
 */
public interface EchoHandler {
    reactor.core.publisher.Mono<Person> queryById(Integer id);
}
