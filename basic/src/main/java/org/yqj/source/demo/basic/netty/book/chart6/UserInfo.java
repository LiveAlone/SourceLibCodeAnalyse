package org.yqj.source.demo.basic.netty.book.chart6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-06-17
 * Email: yaoqijunmail@foxmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 6824156275797552073L;

    private String username;

    private Integer age;

    private Double score;
}
