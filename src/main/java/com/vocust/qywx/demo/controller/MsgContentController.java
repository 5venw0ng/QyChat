package com.vocust.qywx.demo.controller;

import java.util.Map;

import com.vocust.qywx.demo.dao.entity.MsgContent;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vocust.qywx.demo.service.MsgContentService;
import com.vocust.qywx.demo.utils.EnumMsgType;
import com.vocust.qywx.demo.utils.page.PageBean;
import com.vocust.qywx.demo.utils.page.PageParam;
import com.vocust.qywx.demo.utils.page.PageResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/msg")
public class MsgContentController {
	@Autowired
	private MsgContentService msgContentService;

	@RequestMapping(value = "/findAllByUserid", method = RequestMethod.POST)
	public PageResponse findAllByUserid(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("userid") String userid) {
		PageResponse pageResponse = new PageResponse();
		PageParam page = new PageParam();
		page.setPageNum(pageNum);
		page.setNumPerPage(pageSize);
		MsgContent mc = new MsgContent();
		mc.setFrom(userid);
		PageBean pageBean = msgContentService.findAllByUserid(page,mc);
		pageResponse.setTotal(pageBean.getTotalCount());
		pageResponse.setRes(pageBean.getRecordList());
		return pageResponse;
	}


	@RequestMapping(value = "/findMsgByUserid", method = RequestMethod.POST)
	public PageResponse findMsgByUserid(@RequestParam("pageNum") int pageNum,
										@RequestParam("pageSize") int pageSize,
										@RequestParam("userid") String userid,
										@RequestParam(value="tolist",required=false) String tolist,
										@RequestParam(value="roomid",required=false) String roomid,
										@RequestParam(value="fromDate",required=false) String fromDate,
										@RequestParam(value="thruDate",required=false) String thruDate) {
		PageResponse pageResponse = new PageResponse();
		PageParam page = new PageParam();
		page.setPageNum(pageNum);
		page.setNumPerPage(pageSize);
		MsgContent mc = new MsgContent();

		mc.setFrom(userid);
		if(StringUtils.isNotEmpty(tolist)){
			mc.setTolist(tolist);
		}
		if(StringUtils.isNotEmpty(roomid)){
			mc.setRoomid(roomid);
		}
		if(StringUtils.isNotEmpty(fromDate)){
			mc.setFromDate(fromDate);
		}
		if(StringUtils.isNotEmpty(thruDate)){
			mc.setThruDate(thruDate);
		}

		PageBean pageBean = msgContentService.findMsgByUserid(page,mc);
		pageResponse.setTotal(pageBean.getTotalCount());
		pageResponse.setRes(pageBean.getRecordList());
		return pageResponse;
	}

	@RequestMapping(value = "/getMsgById", method = RequestMethod.POST)
	public Map getMsgById(@RequestParam("id") int id, @RequestParam("msgtype") String msgtype) {
		Map map = msgContentService.getMsgByIdAndType(id, EnumMsgType.getIndex(msgtype));
		return map;
	}
}

