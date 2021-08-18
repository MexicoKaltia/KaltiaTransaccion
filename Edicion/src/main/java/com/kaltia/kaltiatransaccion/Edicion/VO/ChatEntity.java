package com.kaltia.kaltiatransaccion.Edicion.VO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="tw_videos")
@NamedQueries({
//	@NamedQuery(query ="Select a from tw_chat a where a.idEmpresa= :id", name = "find chat by idEmpresa")
	
})
public class ChatEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idChat;
	@Column
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String numeroChat;
	@Column
	private String chatContexto;
	@Column
	private String status;
	@Column
	private String userCreate;
	@Column
	private String timestamp;
	
	public ChatEntity() {}

	@Override
	public String toString() {
		return "ChatEntity [idChat=" + idChat + ", idEmpresa=" + idEmpresa + ", idAction=" + idAction + ", numeroChat="
				+ numeroChat + ", chatContexto=" + chatContexto + ", status=" + status + ", userCreate=" + userCreate
				+ ", timestamp=" + timestamp + "]";
	}

	public ChatEntity(String idChat, String idEmpresa, String idAction, String numeroChat, String chatContexto,
			String status, String userCreate, String timestamp) {
		super();
		this.idChat = idChat;
		this.idEmpresa = idEmpresa;
		this.idAction = idAction;
		this.numeroChat = numeroChat;
		this.chatContexto = chatContexto;
		this.status = status;
		this.userCreate = userCreate;
		this.timestamp = timestamp;
	}

	public String getIdChat() {
		return idChat;
	}

	public void setIdChat(String idChat) {
		this.idChat = idChat;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getIdAction() {
		return idAction;
	}

	public void setIdAction(String idAction) {
		this.idAction = idAction;
	}

	public String getNumeroChat() {
		return numeroChat;
	}

	public void setNumeroChat(String numeroChat) {
		this.numeroChat = numeroChat;
	}

	public String getChatContexto() {
		return chatContexto;
	}

	public void setChatContexto(String chatContexto) {
		this.chatContexto = chatContexto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
		
	}
