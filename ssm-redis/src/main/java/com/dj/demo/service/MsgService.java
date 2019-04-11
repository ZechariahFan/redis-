package com.dj.demo.service;

import java.util.List;

import com.dj.demo.model.Msg;

public interface MsgService {

	public void addMsge(Msg msg);
	
	public List<Msg> queryMsg();
}
