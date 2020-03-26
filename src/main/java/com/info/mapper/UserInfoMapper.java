package com.info.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.info.entity.UserInfoEntity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by TerryJ on 2020/03/04.
 *
 */
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

	@Select("select uid, nickname, phonenumber from db_user_info where uid = #{uid}")
	UserInfoEntity getOneUser(@Param("uid") int userid);

	@Insert("insert into db_user_info (nickname,phonenumber) values (#{nickname},#{phonenumber})  ")
	int saveDemo(UserInfoEntity userInfoEntity);
}
