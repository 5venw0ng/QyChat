package com.vocust.qywx.demo.dao.mapper;

import java.util.List;

import com.vocust.qywx.demo.dao.entity.MsgContent;
import com.vocust.qywx.demo.dao.entity.User;
import com.vocust.qywx.demo.utils.page.PageParam;
import org.apache.ibatis.annotations.Param;

/**
*@author  hf
*@version 1.0
*@date  2020年5月15日 下午7:20:17
*@desc 
*/

public interface  UserMapper {

	 public List<User> queryAllUsers();

	 public User getToken();

	public int saveToken(@Param("token") String token, @Param("tokentime") String tokentime);

}
