#byte解码器

```java
public static class Coder{
		//普通解码
		@Rule(start = 0, end = 2)
		private String name;
		
		@Rule(start = 4, end = 10)
		private int age;
		//自定义引擎解码
		//不指定引擎，默认解码，支持对象递归注解
		@Rule(start = 11,end= 20,engine = SuperEnger.class)
		private User user;
		
		//集合解码 支持Array List Set Map 正在完成
		@Collection(start = 0,step = 2,repeat = 2)
		private Data[] data;
	}
	
	public static class SuperEnger implements DecoderEngine{
		
		//自定义引擎解码
		@Override
		public <T> Object decoder(Rule e, byte[] data, Class<T> clz) {
			
			return null;
		}

		@Override
		public <T> Object decoder(Collection c, byte[] data, Class<T> clz) {
			
			return null;
		}
	}
```
