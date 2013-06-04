/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:25
 * @version
 * @name guide.org.wuidl.noip.tourguide.WikipediaRequest.java
 * @description WikipediaRequest
 */
package webServices.tourGuide.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Class WikipediaRequest.
 */
public class WikipediaRequest {
	
	/** The Constant WIKIPEDIA_API_BASE. */
	public static final String WIKIPEDIA_API_BASE = "http://en.wikipedia.org/w/api.php?format=json&action=query&titles=";
	
	/**
	 * Requests a JSON representation of an article title. e.g.
	 * {"query":{"normalized"
	 * :[{"from":"pi","to":"Pi"}],"pages":{"23601":{"pageid"
	 * :23601,"ns":0,"title":"Pi"}}}}
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the string
	 */
	private static String request(String searchTerm) {
		HttpURLConnection conn = null;
		String result = "";
		StringBuilder jsonResults = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		sb.append(WIKIPEDIA_API_BASE);
		sb.append(searchTerm);
		try {
			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			int read;
			char[] buffer = new char[1024];
			while ((read = in.read(buffer)) != -1) {
				jsonResults.append(buffer, 0, read);
			}
		} catch (MalformedURLException e) {
			return result + "missing";
		} catch (IOException e) {
			return result + "missing";
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return jsonResults.toString();
	}

	/**
	 * Gets the wiki link. Parses a JSON String
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the wiki link
	 */
	public static String getWikiLink(String searchTerm) {
		String s = "http://en.wikipedia.org/wiki/";
		if (existsArticle(request(searchTerm))) {
			String tmp = searchTerm.charAt(0) + "";
			tmp = tmp.toUpperCase();
			return s + tmp + searchTerm.substring(1);
		} else {
			return "No article for \"" + searchTerm + "\"";
		}
	}

	/**
	 * Checks if an article exists. If there is no article the pattern "missing"
	 * is contained in the JSON String.
	 * 
	 * @param jsonResponse
	 *            the json response
	 * @return true, if successful
	 */
	private static boolean existsArticle(String jsonResponse) {
		if (jsonResponse.contains("missing")) {
			return false;
		} else {
			return true;
		}
	}

	// public static void main(String[] args) {
	// System.out.println(getWikiLink("pi"));
	// System.out.println(getWikiLink("dfewdfsdf"));
	// }

}
