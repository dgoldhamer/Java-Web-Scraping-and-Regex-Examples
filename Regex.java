package pp04;
 

import java.util.regex.Pattern;

public class Regex {
	
	
	
	private Pattern regexPattern;
	
	
	
	//constructor
	public Regex(Pattern regexPattern) {
		this.regexPattern = Pattern.compile("(<td class=\"tbdy\">(.?CB|DB|SAF|FS|SS)</td>"
	    			+ "<td class=\"tbdy\">(.?[0-9]*[0-9]*)</td>"
	    			+ "<td><a href=\"/player/[a-zA-z]*/[0-9]*/profile\">([a-zA-z]*, [a-zA-z]*)</a></td>"
	    			+ "<td class=\"tbdy\">(ACT|UFA)</td>"
	    			+ "<td class=\"ra\">\t*TCKL(.*?)>(.?[0-9]*|--)</td>"
	    			+ "<td class=\"ra\">\t*SCK(.*?)>(.?[0-9]*.[0-9]*|--)</td>"
	    			+ "<td class=\"ra\">\t*INT(.*?)>(.?[0-9]*|--)</td>"
	    			+ "<td class=\"tbdy1\"><a href=\"/teams(.*?)>(/?[A-Z]*)</a></td></tr>)");
	}
	
	public Pattern getregexPattern() {
	return regexPattern;
}

public void setregexPattern(Pattern regexPattern) {
	this.regexPattern = regexPattern;
}
}