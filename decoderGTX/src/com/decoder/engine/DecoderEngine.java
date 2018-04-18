package com.decoder.engine;

import com.decoder.anno.Collection;
import com.decoder.anno.Rule;

public interface DecoderEngine {
	public <T> Object decoder(Rule e,byte[] data,Class<T> clz);
	
	public <T> Object decoder(Collection c,byte[] data,Class<T> clz);
}