package com.mendyarnoud.domination.objet;

public class Tuile {
	private int crown;
	private String type;

	public Tuile(int crown,String type) {
		this.crown = crown;
		this.type=type;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuile other = (Tuile) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
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
