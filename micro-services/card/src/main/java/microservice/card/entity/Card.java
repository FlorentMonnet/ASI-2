package microservice.card.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card_Entity")
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
		private Integer id_user;
		
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
			return id_user;
		}

		public void setId_user(Integer id_user) {
			this.id_user = id_user;
		}

		@Override
		public String toString() {
			return "Card [id_card=" + id_card + ", energy=" + energy + ", hp=" + hp + ", defense=" + defense
					+ ", attack=" + attack + ", price=" + price + ", id_user=" + id_user + "]";
		}		
}
