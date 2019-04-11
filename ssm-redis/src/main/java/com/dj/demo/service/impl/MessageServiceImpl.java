package com.dj.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dj.demo.dao.MsgDao;
import com.dj.demo.model.Msg;
import com.dj.demo.service.MsgService;
import com.dj.demo.utils.RedisUtil;

@Service
public class MessageServiceImpl implements MsgService{

	@Autowired
	private MsgDao msgDao;
	
	@Autowired
	RedisUtil rd;
	public void addMsge(Msg msg) {
		// TODO Auto-generated method stub
		rd.expire("msg", 0);
		msgDao.addMsge(msg);
	}

	public List<Msg> queryMsg() {
		// TODO Auto-generated method stub
		List<Msg> mm=null;
		List<Object> lGet = rd.lGet("msg", 0, -1);
		if(lGet!=null && lGet.size()>0)
		{
			mm=JSON.parseArray(lGet.get(0).toString(), Msg.class);
		}
		else {
			mm = msgDao.queryMsg();
			rd.lSet("msg", JSON.toJSONString(mm));
		}
		return mm;
	}

}
