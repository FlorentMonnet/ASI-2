package microservice.card.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card_reference")
public class CardReference {
	@Id
	@GeneratedValue
	private Integer id_card_reference;
	@Column(name="name_card_reference")
	private String name;
	@Column(name="description_card_reference")
	private String description;
	@Column(name="family_card_reference")
	private String family;
	@Column(name="affinity_card_reference")
	private String affinity;
	@Column(name="img_url_card_reference")
	private String imgUrl;
	@Column(name="small_img_url_card_reference")
	private String smallImgUrl;
	
	public CardReference() {
		super();
	}
	
	public CardReference(String name, String description, String family, String affinity, String imgUrl,
			String smallImgUrl) {
		super();
		this.name = name;
		this.description = description;
		this.family = family;
		this.affinity = affinity;
		this.imgUrl = imgUrl;
		this.smallImgUrl = smallImgUrl;
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
	
	public Integer getId() {
		return id_card_reference;
	}

	public void setId(Integer id) {
		this.id_card_reference = id;
	}
	
	@Override
	public String toString() {
		return "CardReference [id=" + id_card_reference + ", name=" + name + ", description=" + description + ", family=" + family
				+ ", affinity=" + affinity + ", imgUrl=" + imgUrl + ", smallImgUrl=" + smallImgUrl + "]";
	}

}
