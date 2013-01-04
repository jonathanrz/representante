package br.prax.representative.model;

public class Address {

	// bairro, rua numero, cidade, estado, cep
	// pode ser em portugues para fazer funcionar e nao perder tempo, depois
	// mudamos, refactor do eclipse Ã© facil, renomeia e tudo funciona

	private String bairro;
	private String cidade;
	private String estado;

	private String rua;
	private int numeroCasa;
	private int cep; // nem se preocupa com coisas como consulta online de CEP
						// por enquanto

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public int getCep() {
		return cep;
	}
	
	public String getCepAsString() {
		String s = new String();
		s += cep / 1000;
		s += "-";
		int digitos = cep % 1000;
		if(digitos == 0)//TODO: melhorar formatação de CEP
			s += "000";
		else
			s += digitos;
		return s;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void FillWithMyData(){
		setRua("Alice Ferreira dos Santos");
		setNumeroCasa(236);
		setBairro("Badenfurt");
		setCidade("Blumenau");
		setEstado("SC");
		setCep(89070600);
	}
}
