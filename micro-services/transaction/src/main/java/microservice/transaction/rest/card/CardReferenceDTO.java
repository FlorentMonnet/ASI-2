package microservice.transaction.rest.card;

public class CardReferenceDTO {
	private Integer id;
	private String name;
	private String description;
	private String family;
	private String affinity;
	private String imgUrl;
	private String smallImgUrl;
	
	public CardReferenceDTO() {
		super();
	}

	public CardReferenceDTO(Integer id, String name, String description, String family, String affinity, String imgUrl,
			String smallImgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl = imgUrl;
		this.smallImgUrl = smallImgUrl;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getAffinity() {
		return affinity;
	}
	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getSmallImgUrl() {
		return smallImgUrl;
	}
	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}

	@Override
	public String toString() {
		return "CardReferenceDTO [id=" + id + ", name=" + name + ", description=" + description + ", family=" + family
				+ ", affinity=" + affinity + ", imgUrl=" + imgUrl + ", smallImgUrl=" + smallImgUrl + "]";
	}
}