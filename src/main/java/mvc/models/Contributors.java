package mvc.models;

public class Contributors extends Peoples {

	private int rates;
	private int nbComments;
	
	public Contributors (int rates, int nbComments) {
		super();
		this.rates = rates;
		this.nbComments = nbComments;
	}

	public int getRates() {
		return rates;
	}
	
	public void setRates(int rates) {
		this.rates = rates;
	}
	
	public int getNbComments() {
		return nbComments;
	}
	
	public void setNbComments(int nbComments) {
		this.nbComments = nbComments;
	}

}