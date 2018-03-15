package mvc.models;

public class Techno {

	private int id;
	private String name;
	private String description;
	// Open source - Proprio
	private Boolean status;
	private String image_path;

	// constructor
	
	public Techno(int id, String name, String description, Boolean status, String image_path) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.image_path = image_path;
	}
	
	// Getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

}
