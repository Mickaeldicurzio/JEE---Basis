package mvc.models;

public class Admin extends Peoples {
	
	private int nbDeletedComments;
	
	public Admin (int nbDeletedComments) {
		super();
		this.nbDeletedComments = nbDeletedComments;
	}
	
	public int getNbDeletedComments() {
		return nbDeletedComments;
	}
	
	public void setNbDeletedComments(int nbDeletedComments) {
		this.nbDeletedComments = nbDeletedComments;
	}
}
