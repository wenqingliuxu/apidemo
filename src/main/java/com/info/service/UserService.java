package com.info.service;

import com.info.common.ReturnValue;
import com.info.common.StateMsg;
import com.info.converter.UserInfoConverter;
import com.info.dto.UserInfoDto;
import com.info.entity.UserInfoEntity;
import com.info.formbean.UserIdFormBean;
import com.info.mapper.UserInfoMapper;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by TerryJ on 2020/03/04.
 */
@Service
public class UserService {

    @Resource
    private UserInfoConverter userInfoConverter;

    @Resource
    private UserInfoMapper userInfoMapper;

    @ApiOperation(value = "获取用户信息")
    public ReturnValue<UserInfoDto> getUserInfo(UserIdFormBean userIdFormBean) {
        ReturnValue returnValue = new ReturnValue();

        int userId = userIdFormBean.getUserId();
        if(userId <=0 ){
            returnValue.setStateMsg(StateMsg.StatusMsg_101);
            return returnValue;
        }

        UserInfoEntity userInfoEntity = userInfoMapper.getOneUser(userId);
        if(null == userInfoEntity){
            returnValue.setStateMsg(StateMsg.StatusMsg_202);
            return returnValue;
        }

        UserInfoDto userInfoDto = userInfoConverter.userInfoConverter(userInfoEntity);

        returnValue.setObject(userInfoDto);
        return returnValue;
    }

}
