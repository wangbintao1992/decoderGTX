package com.decoder.engine;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.decoder.anno.Collection;
import com.decoder.anno.Rule;
import com.decoder.util.ByteUtil;

public class SimpleEngine implements DecoderEngine{

	@Override
	public <T> Object decoder(Rule r, byte[] data, Class<T> clz) {
        Object obj = null;

		if (r.bytesit() != -1){
            if("byte".equals(clz.getName())) {
                obj = data[r.bytesit()];
            }
        }else {
            int s = r.start();
            int e = r.end();
            byte[] tmp = Arrays.copyOfRange(data, s, e);

            if("java.lang.String".equals(clz.getName())) {
                obj = new String(tmp);
            }

            if("java.lang.Integer".equals(clz.getName()) || "int".equals(clz.getName())) {
                obj = ByteUtil.ByteArray2Int(tmp);
            }

            if("double".equals(clz.getName())) {
                obj = ByteUtil.bytes2Double(tmp);
            }

            if("float".equals(clz.getName())) {
                obj = ByteUtil.ByteArray2Float(tmp);
            }

            if("short".equals(clz.getName())) {
                obj = ByteUtil.byteToShort(tmp);
            }

            if("long".equals(clz.getName())) {
                obj = ByteUtil.bytes2Long(tmp);
            }

            if("java.lang.Character".equals(clz.getName())) {
                obj = ByteUtil.ByteArray2Char(tmp);
            }

            if("boolean".equals(clz.getName())) {
                obj = ByteUtil.ByteArray2Boolean(tmp);
            }
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
}
