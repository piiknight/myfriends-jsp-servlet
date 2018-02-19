package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StringUtil {
	static public String formatTimestamp(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(timestamp);
	}
}
