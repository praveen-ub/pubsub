package com.pubsub.project2.dto;

public class AppResponse{
	
	
		public AppResponse(int status, String message){
			this.status = status;
			this.message = message;
		}
		
		public AppResponse(int status, String message, Object response){
			this.status = status;
			this.message = message;
			this.response = response;
		}
	
		private int status;
		
		private String message;
		
		private Object response;
		
		public Object getResponse() {
			return response;
		}

		public void setResponse(Object response) {
			this.response = response;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	
}