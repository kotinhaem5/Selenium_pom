package com.bankguru.user;

import java.util.Random;

public class Part_07_Random_Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int randomNumber(){
		Random random = new Random();
		return random.nextInt(999);
	}
}
