package com.kaltia.kaltiatransaccion.Edicion.VO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="tw_videos")
@NamedQueries({
	@NamedQuery(query ="Select a from tw_videos a where a.idEmpresa= :id", name = "find videos by idEmpresa")
	
})
public class VideoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idVideo;
	@Column
	private String idEmpresa;
	@Column
	private String idAction;
	@Column
	private String videoTitulo;
	@Column
	private String videoURL;
	@Column
	private String videoContexto;
	@Column
	private String status;
	@Column
	private String userCreate;
	@Column
	private String timestamp;
	
	
	
	public VideoEntity(String idVideo, String idEmpresa, String idAction, String videoTitulo, String videoURL,
			String videoContexto, String status, String userCreate, String timestamp) {
		super();
		this.idVideo = idVideo;
		this.idEmpresa = idEmpresa;
		this.idAction = idAction;
		this.videoTitulo = videoTitulo;
		this.videoURL = videoURL;
		this.videoContexto = videoContexto;
		this.status = status;
		this.userCreate = userCreate;
		this.timestamp = timestamp;
	}
	
	public VideoEntity() {
	
	}
	@Override
	public String toString() {
		return "VideoEntity [idVideo=" + idVideo + ", idEmpresa=" + idEmpresa + ", idAction=" + idAction
				+ ", videoTitulo=" + videoTitulo + ", videoURL=" + videoURL + ", videoContexto=" + videoContexto
				+ ", status=" + status + ", userCreate=" + userCreate + ", timestamp=" + timestamp + "]";
	}
	public String getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
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
	public String getVideoTitulo() {
		return videoTitulo;
	}
	public void setVideoTitulo(String videoTitulo) {
		this.videoTitulo = videoTitulo;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
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
	public String getVideoContexto() {
		return videoContexto;
	}
	public void setVideoContexto(String videoContexto) {
		this.videoContexto = videoContexto;
	}	
	
	
}