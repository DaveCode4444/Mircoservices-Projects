package com.metamagic.common.bean;

public class MessageWrapper<T> {

	private T wrapped;
	
	private Boolean status;
	
	private String message;
	
	private String messageId;
	
	public MessageWrapper(T wrapper, Boolean status,String message, String messageId){
		this.wrapped = wrapper;
		this.status = status;
		this.message = message;
		this.messageId = messageId;
	}


	public T getWrapped() {
		return wrapped;
	}


	public String getMessageId() {
		return messageId;
	}


	public String getMessage() {
		return message;
	}


	public Boolean getStatus() {
		return status;
	}
	
	


	@Override
	public String toString() {
		return "MessageWrapper [wrapped=" + wrapped + ", status=" + status + ", message=" + message + "]";
	}
	
	
	
	
}
