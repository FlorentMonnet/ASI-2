package microservice.card.dto;

public class CardReferenceDTO {
	private Integer id_card_reference;
	private String name;
	private String description;
	private String family;
	private String affinity;
	private String imgUrl;
	private String smallImgUrl;
	
	public CardReferenceDTO() {
		super();
	}

	public CardReferenceDTO(Integer id_card_reference, String name, String description, String family, String affinity, String imgUrl,
			String smallImgUrl) {
		super();
		this.id_card_reference = id_card_reference;
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl = imgUrl;
		this.smallImgUrl = smallImgUrl;
	}

	public Integer getId() {
		return id_card_reference;
	}
	public void setId(Integer id) {
		this.id_card_reference = id;
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
		return "CardReferenceDTO [id=" + id_card_reference + ", name=" + name + ", description=" + description + ", family=" + family
				+ ", affinity=" + affinity + ", imgUrl=" + imgUrl + ", smallImgUrl=" + smallImgUrl + "]";
	}
}
