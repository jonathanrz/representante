package br.prax.representative.model;

public class Representative {

	private String name;
	private String fone;
	private String email;
	private String titulo;//TODO: pensar em como mudar isto, talvez criar uma logo e mudar para o path da logo, agora tem o problema de depender do tamanho da fonte
	private String subTitulo; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubTitulo() {
		return subTitulo;
	}
	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}	
}
