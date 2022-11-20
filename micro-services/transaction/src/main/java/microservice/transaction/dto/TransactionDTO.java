package microservice.transaction.dto;

import java.sql.Timestamp;

import microservice.transaction.entity.TransactionAction;

public class TransactionDTO {
	private Integer id;
	private Integer userId;
	private Integer cardId;
	private TransactionAction action;
    private Timestamp timeSt;
    private boolean isUserOk;
    private boolean isCardOk;
    
    public TransactionDTO() {
    	
    }
    
	public TransactionDTO(Integer id, Integer userId, Integer cardId, TransactionAction action, Timestamp timeSt,
			boolean isUserOk, boolean isCardOk) {
		super();
		this.id = id;
		this.userId = userId;
		this.cardId = cardId;
		this.action = action;
		this.timeSt = timeSt;
		this.isUserOk = isUserOk;
		this.isCardOk = isCardOk;
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
	public void setTimeSt(Timestamp timeSt) {
		this.timeSt = timeSt;
	}

	public boolean isUserOk() {
		return isUserOk;
	}

	public void setUserOk(boolean isUserOk) {
		this.isUserOk = isUserOk;
	}

	public boolean isCardOk() {
		return isCardOk;
	}

	public void setCardOk(boolean isCardOk) {
		this.isCardOk = isCardOk;
	}
    
    
}
