package di0retsa.userlogin.mapper;

import di0retsa.userlogin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户相关SQL
 */
@Mapper
public interface UserMapper {
    @Select("select * from szulab.user where stu_id = #{stuId}")
    User getByStuId(String stuId);

    void insert(User user);
}
