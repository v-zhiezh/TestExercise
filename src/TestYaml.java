import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
public class TestYaml{
	public HashMap<String,Object> testYaml() throws FileNotFoundException {
		  Yaml yaml = new Yaml();
		  HashMap<String, Object> map=null;
          URL url = TestYaml.class.getClassLoader().getResource("jcywTestData_admin.yaml");
          if (url!= null) {
              //��ȡtest.yaml�ļ��е��������ݣ�Ȼ��ת��Ϊobj��
              //Ҳ���Խ�ֵת��ΪMap
               map =(HashMap)yaml.load(new FileInputStream(url.getFile()));
              System.out.println(map);	
              System.out.println("ִ��testyaml�ļ���ɡ�������");
	}
		return map;
	}
}
