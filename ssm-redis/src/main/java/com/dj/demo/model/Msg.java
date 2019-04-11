package com.dj.demo.model;

public class Msg {
    private  Long id;
    private  String msg;
    private  String name;

    
    
    public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}