package microservice.transaction.rest.card;

public class CardDTO {
	
	private Integer id;
	private float energy;
	private float hp;
	private float defense;
	private float attack;
	private float price;
	private Integer id_user;
	
	public CardDTO() {
		super();
	}
	
	public CardDTO(float energy, float hp, float defense, float attack, float price, Integer id_user) {
		super();
		this.energy = energy;
		this.hp = hp;
		this.defense = defense;
		this.attack = attack;
		this.price = price;
		this.id_user = id_user;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getEnergy() {
		return energy;
	}

	public void setEnergy(float energy) {
		this.energy = energy;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getDefense() {
		return defense;
	}

	public void setDefense(float defense) {
		this.defense = defense;
	}

	public float getAttack() {
		return attack;
	}

	public void setAttack(float attack) {
		this.attack = attack;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
}
