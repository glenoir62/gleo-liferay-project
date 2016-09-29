package com.gleo.plugins.hexiagon.portlet.categories.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "com.gleo.plugins.hexiagon")
public class Asset {

	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "vocabularies")
	// XmlElement sets the name of the entities
	@XmlElement(name = "vocabulary")
	private ArrayList<Vocabulary> vocabularyList;
	private String companyName;
	private String groupName;
	
	public void setVocabularyList(ArrayList<Vocabulary> vocabularyList) {
		this.vocabularyList = vocabularyList;
	}
	
	public ArrayList<Vocabulary> getVocabulariesList() {
		return vocabularyList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}