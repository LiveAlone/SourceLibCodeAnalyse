package org.yqj.source.demo.mapper.struct.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.yqj.source.demo.mapper.struct.beans.car.Car;
import org.yqj.source.demo.mapper.struct.beans.car.CarDto;
import org.yqj.source.demo.mapper.struct.beans.car.Person;
import org.yqj.source.demo.mapper.struct.beans.car.PersonDto;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/9/9
 * Email: yaoqijunmail@foxmail.com
 */
@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mappings({
            @Mapping(source = "numberOfSeats", target = "seatCount"),
    })
//    @BeanMapping(ignoreByDefault = true)
    CarDto carToCarDto(Car car);

//    @InheritInverseConfiguration
//    Car carDtoToCar(CarDto carDto);

    PersonDto personToPersonDto(Person person);
}
