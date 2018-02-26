package util;

import java.util.regex.Pattern;

public class EmailValidator {
	private Pattern pattern; 
    private static final String EMAIL_PATTERN = "^(.+)@(.+)\\.(.+)$"; 
    
    public EmailValidator() { 
        pattern = Pattern.compile(EMAIL_PATTERN); 
    } 
    
    public boolean isEmailValid(final String email) { 
        return pattern.matcher(email).matches(); 
    }
}
