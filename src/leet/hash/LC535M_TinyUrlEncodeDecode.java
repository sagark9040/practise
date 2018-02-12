package leet.hash;

import java.util.HashMap;

public class LC535M_TinyUrlEncodeDecode {

    // 825pm-->832pm ... ridiculously simple
	
	// Problems with this approach:

	//	If I’m asked to encode the same long URL several times, it will get several entries. That wastes codes and memory.
	//	People can find out how many URLs have already been encoded. Not sure I want them to know.
	//	People might try to get special numbers by spamming me with repeated requests shortly before their desired number comes up.
	//	Only using digits means the codes can grow unnecessarily large. Only offers a million codes with length 6 (or smaller). 
	// 	Using six digits or lower or upper case letters would offer (10+26*2)6 = 56,800,235,584 codes with length 6.
    
    HashMap<String, String> tinyMap = new HashMap<String, String>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String size=String.valueOf(tinyMap.size());
        tinyMap.put(size, longUrl);
        tinyMap.put(longUrl, size);
        return size;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyMap.get(shortUrl);
    }
}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(url));