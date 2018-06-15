


import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class Properties {

	private static final String BUNDLE_NAME = "shrewdSoft";
	private static final ResourceBundle RESOURCE_BUNDLE =
		ResourceBundle.getBundle(BUNDLE_NAME);

	public static String getProperty(String property) {
		try {
			return RESOURCE_BUNDLE.getString(property);
		} catch (MissingResourceException e) {
			return '!' + property + '!';
		}
	}


}
