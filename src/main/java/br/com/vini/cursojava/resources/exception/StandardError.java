package br.com.vini.cursojava.resources.exception;
// esta é uma classe pra representação de erros
public class StandardError {
	private Integer sattus;
	private String msg;
	private Long timeStamp;
	public StandardError(Integer sattus, String msg, Long timeStamp) {
		super();
		this.sattus = sattus;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	public Integer getSattus() {
		return sattus;
	}
	public void setSattus(Integer sattus) {
		this.sattus = sattus;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
