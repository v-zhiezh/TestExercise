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
              //获取test.yaml文件中的配置数据，然后转换为obj，
              //也可以将值转换为Map
               map =(HashMap)yaml.load(new FileInputStream(url.getFile()));
              System.out.println(map);	
              System.out.println("执行testyaml文件完成。。。。");
	}
		return map;
	}
}
