package com.travelsky.threadpool;

public class Worker implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// for (int i = 0; i < Integer.MAX_VALUE; i++)
		for (int j = 0; j < Integer.MAX_VALUE; j++)
			;
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ThreadGroup topGroup = group;

		// 遍历线程组树，获取根线程组
		while (group != null) {
			topGroup = group;
			group = group.getParent();
		}
		Thread[] list = new Thread[10000];
		int count = topGroup.enumerate(list);

		System.out.println(count);
	}
}
