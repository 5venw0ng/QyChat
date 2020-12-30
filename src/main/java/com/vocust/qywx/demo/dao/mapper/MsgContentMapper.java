package com.vocust.qywx.demo.dao.mapper;

import java.util.List;
import java.util.Map;

import com.vocust.qywx.demo.dao.entity.MsgContent;
import com.vocust.qywx.demo.utils.page.PageParam;
import org.apache.ibatis.annotations.Param;

/**
 * @author hf
 * @version 1.0
 * @date 2020年5月15日 下午7:20:17
 * @desc
 */

public interface MsgContentMapper {

	List<MsgContent> findAllByUserid(@Param("page") PageParam page, @Param("mc") MsgContent mc);

	List<MsgContent> findGroupByUserid(@Param("mc") MsgContent mc);

	List<MsgContent> findMsgByUserid(@Param("page") PageParam page,@Param("mc") MsgContent mc);
	
	int counts(@Param("mc") MsgContent mc);
	
	void insertMsgContent(MsgContent msgContent);

	void clearDatas();

	String getMsgByIdAndType(Map map);

	void updateFileName(Map map);

	String getFileById(int id);

}
