
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
		//System.out.println("a1234567���ܺ�Ϊ��"+getMD5Test("SS1234567"));
		System.out.println("��ʼִ��testyaml������������");
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
  //���10�������
    do {
  	  int stringLength=rm.nextInt(10)+1;
  	 for(int i=0;i<=stringLength;i--) {
  		int number=rm.nextInt(k.charAt(i)); 
  	 }
    }while(stringList.contains(str.toString()));
    stringList.add(str.toString());
    System.out.println("Ԫ����ӳɹ�������");
		
}
//�����������
public static char getRandomChar() {
    return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
}

public static String getRandomHan() {
	Random rand=new Random();
	Integer rd=null;
    rd=rand.nextInt(7)+1;
    String rdHanzi="";
    System.out.println("�������"+rd);
  for(int j=0;j<rd;j++) {
	//�����������
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
		//32λ����	
	}

	return buf.toString();
}


public static String getMD5Test(String password) {
    // ��Ҫ���ܵ��ַ���
	StringBuffer sb=null;
    try {
        // ���ܶ���ָ�����ܷ�ʽ
        MessageDigest md5 = MessageDigest.getInstance("md5");
        // ׼��Ҫ���ܵ�����
        byte[] b = password.getBytes();
        // ����
        byte[] digest = md5.digest(b);
        char[] chars = new char[] { '0', '1', '2', '3', '4', '5',
                '6', '7' , '8', '9', 'a', 'b', 'c', 'd', 'e','f' };
       sb = new StringBuffer();
        // �����ʮ�����Ƶ��ַ���(ͨ��)
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
