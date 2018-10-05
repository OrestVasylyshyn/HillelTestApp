/*
 * Copyright 2018 Orest Vasylyshyn.
 */
package com.orest.hilleltestapp;

/**
 *
 * @author Orest Vasylyshyn
 */
public class IncrementSynchronize {

	private int value = 0;

	public synchronized int getNextValue1() {
		return value++;
	}

	public int getNextValue2() {
		synchronized (this) {
			return value++;
		}
	}
	
	public int getNextValue3() {
		synchronized (IncrementSynchronize.class) {
			return value++;
		}
	}
	

}
