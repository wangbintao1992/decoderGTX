package com.decoder;
import java.lang.reflect.Field;

import com.decoder.anno.Collection;
import com.decoder.anno.Rule;
import com.decoder.engine.DecoderEngine;

public class DecoderGTX{
	
	private final byte[] data;
	
	public static DecoderGTX newGTX(byte[] data) {
		if (data == null || data.length == 0) {
			throw new IllegalArgumentException();
		}
		return new DecoderGTX(data);
	}
	
	private DecoderGTX(byte[] data) {
		this.data = data;
	}
	
	public <T> T decoder(Class<?> class1){
		T i = null;
		try {
			i = (T) class1.newInstance();
			Field[] fs = class1.getFields();
			
			for (Field f : fs) {
				f.setAccessible(true);
				
				Rule r = f.getAnnotation(Rule.class);
				Collection col = f.getAnnotation(Collection.class);
				if (r != null) {
					
					if(r.sub()) {
						//嵌套
						f.set(i, decoder(f.getType()));
					}else {
						DecoderEngine engine = (DecoderEngine) r.engine().newInstance();
						f.set(i, engine.decoder(r, data, f.getClass()));
					}
				}
				
				if (col != null) {
					//TODO
					DecoderEngine engine = (DecoderEngine) r.engine().newInstance();
					f.set(i, engine.decoder(col, data, f.getClass()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
}
