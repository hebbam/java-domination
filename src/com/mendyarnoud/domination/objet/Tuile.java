package com.mendyarnoud.domination.objet;

public class Tuile {
	private int crown;
	private String type;

	public Tuile(int crown,String type) {
		this.crown = crown;
		this.type=type;
		
	}
	
	public int getCrown() {
		return crown;
	}

	public void setCrown(int crown) {
		this.crown = crown;
	}

	public String getType() {
		return type;
	}
	
	public void setType( String type) {
		this.type=type;
	}

}
