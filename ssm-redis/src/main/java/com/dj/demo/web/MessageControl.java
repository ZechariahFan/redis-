package com.dj.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.demo.model.Msg;
import com.dj.demo.service.MsgService;
import com.dj.demo.utils.RedisUtil;

@Controller
public class MessageControl {

	@Autowired
	MsgService ms;
	
	
	
	@RequestMapping("/addMsg")
	public void addMsg(Msg msg)
	{
		ms.addMsge(msg);
	}
	
	@ResponseBody
	@RequestMapping("/queryMsg")
	public List<Msg> queryMsg()
	{
		List<Msg> msg = ms.queryMsg();
		return msg;
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return null;
	}
}
