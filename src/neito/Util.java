package neito;

public class Util {
	public static String genrateCoverURI(String path)
	{
		String res = "";
		res += path.substring(System.getProperty("user.dir").length()+4);
		
		return res;
	}
}
