package com.metamagic.common.bean;


public class MessageWrapper<T> {

	private T wrapped;
	
	private Boolean status;
	
	private String message;
	
	private String messageId;
	
	public MessageWrapper(){
	}
	
	public MessageWrapper(T wrapper, Boolean status,String message, String messageId){
		this.wrapped = wrapper;
		this.status = status;
		this.message = message;
		this.messageId = messageId;
	}

	public T getWrapped() {
		return wrapped;
	}

	public void setWrapped(T wrapped) {
		this.wrapped = wrapped;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "MessageWrapper [wrapped=" + wrapped + ", status=" + status + ", message=" + message + "]";
	}
	
	
	
	
}
