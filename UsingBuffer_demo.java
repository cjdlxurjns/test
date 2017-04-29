package second;
import java.nio.*;

public class UsingBuffer_demo {
	private static void re(CharBuffer buffer){
		while(buffer.hasRemaining()){
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2);
			buffer.put(c1);
		}
	}
	public static void main(String[] args){
		char[] data = "abcdefgh".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length*2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		re(cb);
		System.out.println(cb.rewind());
	}
}
