package com.backend;
public abstract class Abstract implements Interface {
	int x;
	int y;
	public Abstract(int x,int a) {
		this.x=x;
		this.y=a;
	}
	@Override
	public void m1(int y,int z) {
		this.x=y;
		this.y=z;
		System.out.println(x);
		System.out.println(y);
	}
	@Override
	public abstract void m1(int a);
    }
