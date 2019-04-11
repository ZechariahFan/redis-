package com.dj.demo.dao;

import java.util.List;

import com.dj.demo.model.Msg;

public interface MsgDao {

	void addMsge(Msg msg);

	List<Msg> queryMsg();

}
