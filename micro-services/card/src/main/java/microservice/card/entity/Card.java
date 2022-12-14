package microservice.card.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
		@Id
		@GeneratedValue
		private Integer id_card;
		@Column(name="energy_card")
		private float energy;
		@Column(name="hp_card")
		private float hp;
		@Column(name="defense_card")
		private float defense;
		@Column(name="attack_card")
		private float attack;
		@Column(name="price_card")
		private float price;
		@Column(name="id_user")
		private Integer user;
		
		@ManyToOne
	    @JoinColumn(name="id_card_reference", nullable=false, foreignKey=@ForeignKey(name = "fk_card_card_reference_id"))
		private CardReference cardReference;
		public Card() {		
		}
		
		public Integer getId_card() {
			return id_card;
		}

		public void setId_card(Integer id_card) {
			this.id_card = id_card;
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
			return user;
		}

		public void setId_user(Integer id_user) {
			this.user = id_user;
		}

		public CardReference getCardReference() {
			return cardReference;
		}

		public void setCardReference(CardReference cardReference) {
			this.cardReference = cardReference;
		}
		
		public float computePrice() {
			return this.hp * 20 + this.defense*20 + this.energy*20 + this.attack*20;
		}

		@Override
		public String toString() {
			return "Card [id_card=" + id_card + ", energy=" + energy + ", hp=" + hp + ", defense=" + defense
					+ ", attack=" + attack + ", price=" + price + ", user=" + user + ", cardReference=" + cardReference
					+ "]";
		}
		
}
