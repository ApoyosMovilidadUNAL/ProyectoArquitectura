package encriptar.md5;

public class md5 {
	
	public static String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double rd = Math.random()*1000000000;
		Integer r= rd.intValue();
		System.out.println(r);
		System.out.println(MD5(r.toString()));

	}

}