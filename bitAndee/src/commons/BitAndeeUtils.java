package commons;

import java.util.Map;
import java.util.Map.Entry;

public class BitAndeeUtils {

	public static String generateGetURL(String url, Map<String, String> paramMap) {
		StringBuilder sbURL = new StringBuilder(url);
		if (paramMap != null && paramMap.size() != 0) {
			for (Entry<String, String> paramEntry : paramMap.entrySet()) {
				sbURL.append("?").append(paramEntry.getKey()).append("=").append(paramEntry.getValue());
			}
		}
		return sbURL.toString();
	}
}
