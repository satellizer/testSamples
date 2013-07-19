package com.travelsky.threadpool;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

public class ThreadPoolService {

	public static void main(String[] args) throws InterruptedException {
		final ThreadPoolExecutor t = new ThreadPoolExecutor(1, 100, 60L,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100),
				new ThreadPoolExecutor.CallerRunsPolicy());
		t.prestartAllCoreThreads();
		for (int i = 0; i < 600; i++) {
			t.execute(new Worker());
			// t.execute(new Thread() {
			// @Override
			// public void run() {
			// // for (int i = 0; i < Integer.MAX_VALUE; i++)
			// for (int j = 0; j < Integer.MAX_VALUE; j++)
			// ;
			// }
			//
			// });
		}
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		ThreadGroup topGroup = group;

		// 遍历线程组树，获取根线程组
		while (group != null) {
			topGroup = group;
			group = group.getParent();
		}
		Thread[] list = new Thread[10000];
		int count = topGroup.enumerate(list);

		System.out.println("===========" + count + "============");

	}
}
