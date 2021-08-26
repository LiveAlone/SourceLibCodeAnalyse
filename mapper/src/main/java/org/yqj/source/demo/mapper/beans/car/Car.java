package org.yqj.source.demo.mapper.beans.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/9/9
 * Email: yaoqijunmail@foxmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String make;

    private Integer numberOfSeats;

    private CarType type;

    private Person person;

    public static enum CarType {
        A, B, C, D,
    }
}
