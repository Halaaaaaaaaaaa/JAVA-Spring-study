package com.ezen.view.controller;

public class ViewResolver {
	public String prefix;	// 경로명(접두사)
	public String suffix;   // 확장자(접미사)
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	//입력 파라미터: viewName - jsp 파일명
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
