package org.yqj.source.demo.mapper.struct.beans.car;

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
public class CarDto {

    private String make;

    private int seatCount;

    private String type;

    private PersonDto person;

}
