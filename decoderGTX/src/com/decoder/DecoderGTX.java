package com.decoder;



import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import com.decoder.anno.Collection;
import com.decoder.anno.Rule;
import com.decoder.anno.Validate;
import com.decoder.engine.DecoderEngine;
import com.decoder.util.ByteUtil;
/**
 *
 *  注解解码器
 * @author james
 * @date 2018/4/25 0025 11:02
 * @param
 * @return
 */
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

    /**
     * 通过返回true
     * @param class1
     * @return
     */
	public boolean validate(Class<?> class1){
        Validate v = class1.getAnnotation(Validate.class);
        if (v != null){
            String crc = null;
            String key = null;
            if(v.offset() != 0) {
                //偏移
                crc = ByteUtil.getCRC(Arrays.copyOfRange(data, 0, data.length - v.offset()));
                key = ByteUtil.bytesToHexFun1(Arrays.copyOfRange(data, data.length - v.offset(),data.length));
            }else{
                //起止
                crc = ByteUtil.getCRC(Arrays.copyOfRange(data, v.ds(),v.de()));
                key = ByteUtil.bytesToHexFun1(Arrays.copyOfRange(data, v.ks(),v.ke()));
            }
            if(crc.length() < 4) {
                crc = "0" + crc;
            }
            return !(crc.toUpperCase().equals(key.toUpperCase()));
        }

        return false;
    }

	public <T> T decode(Class<?> class1){
		T i = null;
		try {
            i = (T) class1.newInstance();
			Field[] fs = class1.getDeclaredFields();

			for (Field f : fs) {
				f.setAccessible(true);
				
				Rule r = f.getAnnotation(Rule.class);
				Collection col = f.getAnnotation(Collection.class);
				if (r != null) {
					
					if(r.sub()) {
						//嵌套
						f.set(i, decode(f.getType()));
					}else {
						DecoderEngine engine = (DecoderEngine) r.engine().newInstance();
						f.set(i, engine.decoder(r, data, f.getType()));
					}
				}
				
				if (col != null) {
					//TODO
					DecoderEngine engine = (DecoderEngine) r.engine().newInstance();
					f.set(i, engine.decoder(col, data, f.getClass()));
				}
			}
		} catch (Exception e) {
            //
		}
		
		return i;
	}
}
