import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotteproject.webservice.dto.GoodsInfo;

public class UnmarshalExample {

	public void unmarshalTest() {
		
		try {
			
			File file = new File("D://sample.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(GoodsInfo.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			GoodsInfo goodsInfo = (GoodsInfo) jaxbUnmarshaller.unmarshal(file);

			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(goodsInfo);
			
			System.out.println(goodsInfo.getPrice());
			System.out.println(jsonString);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new UnmarshalExample().unmarshalTest();
	}
}
