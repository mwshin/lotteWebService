package com.lotteproject.marshal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.lotteproject.webservice.dto.GoodsInfo;

public class MarshalExample {

	
	public void marshalTest(){
		
		try {
			
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setDeliveryCost("2500");
		goodsInfo.setMallId("test");
		goodsInfo.setMallPid("test");
		goodsInfo.setNvMid("test");
		goodsInfo.setPrice("12000");
		goodsInfo.setRanking("3");
		
		JAXBContext context = JAXBContext.newInstance(GoodsInfo.class);
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(goodsInfo, System.out);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MarshalExample().marshalTest();
	}
}
