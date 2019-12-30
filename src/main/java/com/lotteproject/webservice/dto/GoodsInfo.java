package com.lotteproject.webservice.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "product")
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class GoodsInfo {

	@XmlElement
	private String ranking;
	
	@XmlElement
	private String price;
	
	@XmlElement
	private String deliveryCost;
	
	@XmlElement
	private String nvMid;
	
	@XmlElement
	private String mallId;

	@XmlElement
	private String mallPid;
	
}
