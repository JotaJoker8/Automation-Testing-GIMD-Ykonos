package es.sescam.automation.testing.gimd.ykonos.util;
	
import java.text.MessageFormat;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public final class I18n {
	
    private static final String MESSAGES_KEY = "i18n/messages_es_ES";
    
    private I18n() {}
    
    private static ResourceBundle bundle;
    
    public static Locale getLocale() {
        return Locale.getDefault();
    }
    
    public static boolean isSupported(Locale l) {
    	
        Locale[] availableLocales = Locale.getAvailableLocales();
        return Arrays.asList(availableLocales).contains(l);
        
    }
    
    public static void setLocale(Locale l) {
        Locale.setDefault(l);
    }
    
    public static String getMessage(String key) {
    	
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(MESSAGES_KEY);
        }

        return bundle.getString(key);
        
    }
    
    public static String getMessage(String key, Object ... arguments) {
        return MessageFormat.format(getMessage(key), arguments);
    }
    
}
