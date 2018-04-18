package com.decoder.engine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.decoder.anno.Collection;
import com.decoder.anno.Rule;
import com.decoder.util.ByteUtil;

public class SimpleEngine implements DecoderEngine{

	@Override
	public <T> Object decoder(Rule r, byte[] data, Class<T> clz) {
		int s = r.start();
		int e = r.end();
		byte[] tmp = Arrays.copyOfRange(data, s, e);
		
		Object obj = null;
		
		if("java.lang.String".equals(clz.getName())) {
			obj = new String(tmp);
		}
		
		if("java.lang.Integer".equals(clz.getName())) {
			obj = ByteUtil.ByteArray2Int(tmp);
		}
		
		if("java.lang.Double".equals(clz.getName())) {
			obj = ByteUtil.bytes2Double(tmp);
		}
		
		if("java.lang.Float".equals(clz.getName())) {
			obj = ByteUtil.ByteArray2Float(tmp);
		}
		
		if("java.lang.Short".equals(clz.getName())) {
			obj = ByteUtil.byteToShort(tmp);
		}
		
		if("java.lang.Long".equals(clz.getName())) {
			obj = ByteUtil.bytes2Long(tmp);
		}
		
		if("java.lang.Byte".equals(clz.getName())) {
			obj = tmp[0];
		}
		
		if("java.lang.Character".equals(clz.getName())) {
			obj = ByteUtil.ByteArray2Char(tmp);
		}
		
		if("java.lang.Boolean".equals(clz.getName())) {
			obj = ByteUtil.ByteArray2Boolean(tmp);
		}
		
		return obj;
	}

	@Override
	public <T> Object decoder(Collection c, byte[] data, Class<T> clz) {
		Object obj = null;
		
		if(clz.isArray()) {
			
		}
		
		if(clz.isAssignableFrom(List.class)){ //判断是否为List  
			
        }
		
		if(clz.isAssignableFrom(Set.class)){ //判断是否为List  
			
        }
		
		if(clz.isAssignableFrom(Map.class)) {
			
		}
		
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new int[] {}.getClass().getName());
	}
}
