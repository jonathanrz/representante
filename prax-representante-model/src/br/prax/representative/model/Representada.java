package br.prax.representative.model;


public class Representada {

	private String nome;
	private String pathLogo; // nao tenho certeza se Ã© a melhor classe para
						// representar imagem

	private Address endereco;
	private String email;
	private String telefone;
	private String site;	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPathLogo() {
		return pathLogo;
	}
	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}
	public Address getEndereco() {
		return endereco;
	}
	public void setEndereco(Address endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public void Fill(){
		nome = "MALHAS DE' CELO";
		pathLogo = "logos/decelo.jpg";
		email = "decelo@decelo.com.br";
		telefone = "(41)3248-1793 / 3248-4764";
		site = "www.decelo.com.br";
		
		endereco = new Address();
		endereco.setRua("Av. Presidente Wenceslau Braz");
		endereco.setNumeroCasa(2614);
		endereco.setBairro("Guaíra");
		endereco.setCep(81010000);
		endereco.setCidade("Curitiba");
		endereco.setEstado("Paraná");
	}
}
