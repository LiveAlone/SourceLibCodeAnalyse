package org.yqj.source.demo.mapper;

import org.yqj.source.demo.mapper.beans.car.CarDto;
import org.yqj.source.demo.mapper.beans.car.Person;
import org.yqj.source.demo.mapper.beans.user.Score;
import org.yqj.source.demo.mapper.beans.user.Student;
import org.yqj.source.demo.mapper.mapper.CarMapper;
import org.yqj.source.demo.mapper.mapper.UserMapper;
import org.yqj.source.demo.mapper.beans.car.Car;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/9/9
 * Email: yaoqijunmail@foxmail.com
 */
public class MainTest {
    public static void main(String[] args) {
        carTest();
//        testUser();
    }

    public static void testUser(){
//        Score score = new Score(123);
//        UserInfo userInfo = new UserInfo("yaoqijun");
//        System.out.println(UserMapper.INSTANCE.userInfoAndScoreToStudent(userInfo, score));

        Student student = new Student();
        UserMapper.INSTANCE.updateStudentScore(new Score(100), student);
        System.out.println(student);

    }

    public static void carTest(){
        Car car = new Car("Morris", null, Car.CarType.A, new Person("yaoqijun", 18));
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println(carDto);
    }
}
