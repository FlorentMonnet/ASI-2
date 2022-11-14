package microservice.transaction.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer userId;
	private Integer cardId;
	private TransactionAction action;
    private Timestamp timeSt;
	
	public Transaction() {
		this.timeSt=new Timestamp(System.currentTimeMillis());
	}

	public Transaction( Integer userId, Integer cardId, TransactionAction action) {
		super();
		this.userId = userId;
		this.cardId = cardId;
		this.action = action;
		this.timeSt=new Timestamp(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public TransactionAction getAction() {
		return action;
	}

	public void setAction(TransactionAction action) {
		this.action = action;
	}

	public Timestamp getTimeSt() {
		return timeSt;
	}

	public void setTimeSt(Timestamp sqlTimestamp) {
		this.timeSt = sqlTimestamp;
	}
}
