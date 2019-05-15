
/**
 * @author zhouzhie
 *
 */

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;

public class TestExercise {

	public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println("a1234567加密后为："+getMD5Test("SS1234567"));
		System.out.println("开始执行testyaml方法。。。。");
		 TestYaml ty=new  TestYaml();
		 HashMap<String,Object> hm= ty.testYaml();
		 System.out.println("account:"+ hm.get("account"));
		 System.out.println("password:"+hm.get("password"));
	}

public void testRandomString() {
	List<String> stringList=new ArrayList<String>();
    Random rm=new Random();
    String k="1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuffer str=new StringBuffer(); 
  //添加10个随机数
    do {
  	  int stringLength=rm.nextInt(10)+1;
  	 for(int i=0;i<=stringLength;i--) {
  		int number=rm.nextInt(k.charAt(i)); 
  	 }
    }while(stringList.contains(str.toString()));
    stringList.add(str.toString());
    System.out.println("元素添加成功！！！");
		
}
//随机产生汉字
public static char getRandomChar() {
    return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
}

public static String getRandomHan() {
	Random rand=new Random();
	Integer rd=null;
    rd=rand.nextInt(7)+1;
    String rdHanzi="";
    System.out.println("随机数："+rd);
  for(int j=0;j<rd;j++) {
	//随机产生汉字
	char getRandomChar=(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
	rdHanzi=rdHanzi+getRandomChar;
   }
	return rdHanzi.trim();
}

public static String getMd5(String plainText) throws NoSuchAlgorithmException {
	int i=0;
	MessageDigest md=MessageDigest.getInstance("MD5");
	md.update(plainText.getBytes());
	byte b[]=md.digest();
	StringBuffer buf=new StringBuffer("");
	for(int offset=0;offset<b.length;offset++) {
		i=b[offset];
		if(i<0) {
		i+=256;	
		}
		if(i<16) {
			buf.append("0");
			buf.append(Integer.toHexString(i)); 
		}
		//32位加密	
	}

	return buf.toString();
}


public static String getMD5Test(String password) {
    // 需要加密的字符串
	StringBuffer sb=null;
    try {
        // 加密对象，指定加密方式
        MessageDigest md5 = MessageDigest.getInstance("md5");
        // 准备要加密的数据
        byte[] b = password.getBytes();
        // 加密
        byte[] digest = md5.digest(b);
        char[] chars = new char[] { '0', '1', '2', '3', '4', '5',
                '6', '7' , '8', '9', 'a', 'b', 'c', 'd', 'e','f' };
       sb = new StringBuffer();
        // 处理成十六进制的字符串(通常)
        for (byte bb : digest) {
            sb.append(chars[(bb >> 4) & 15]);
            sb.append(chars[bb & 15]);
        }
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
	return sb.toString();
}


 }
