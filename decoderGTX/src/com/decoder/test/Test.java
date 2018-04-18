package com.decoder.test;

import com.decoder.DecoderGTX;
import com.decoder.anno.Rule;

public class Test {
	public static void main(String[] args) throws Exception {
		DecoderGTX d = DecoderGTX.newGTX(new byte[] {1,2,3,4});
	}
	
	public static class B{
		
		@Rule()
		private String value;
	}
}
