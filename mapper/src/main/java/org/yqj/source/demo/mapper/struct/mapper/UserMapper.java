package org.yqj.source.demo.mapper.struct.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.yqj.source.demo.mapper.struct.beans.user.Score;
import org.yqj.source.demo.mapper.struct.beans.user.Student;
import org.yqj.source.demo.mapper.struct.beans.user.UserInfo;

import java.util.List;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2020/9/11
 * Email: yaoqijunmail@foxmail.com
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userInfo.name", target = "name")
    @Mapping(source = "score.score", target = "score")
    Student userInfoAndScoreToStudent(UserInfo userInfo, Score score);

    void updateStudentScore(Score score, @MappingTarget Student student);

    @IterableMapping(numberFormat = "$#.00")
    List<String> prices(List<Integer> prices);

}
