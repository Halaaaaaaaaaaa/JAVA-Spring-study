package com.ezen.view.controller;

public class ViewResolver {
	public String prefix;	// ��θ�(���λ�)
	public String suffix;   // Ȯ����(���̻�)
	
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
	
	//�Է� �Ķ����: viewName - jsp ���ϸ�
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
