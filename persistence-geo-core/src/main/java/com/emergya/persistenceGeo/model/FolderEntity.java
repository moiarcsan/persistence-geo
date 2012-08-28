/*
 * FolderEntity.java
 * 
 * Copyright (C) 2011
 * 
 * This file is part of Proyecto persistenceGeo
 * 
 * This software is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * As a special exception, if you link this library with other files to produce
 * an executable, this library does not by itself cause the resulting executable
 * to be covered by the GNU General Public License. This exception does not
 * however invalidate any other reasons why the executable file might be covered
 * by the GNU General Public License.
 * 
 * Authors:: Moisés Arcos Santiago (mailto:marcos@emergya.com)
 */
package com.emergya.persistenceGeo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad de carpeta
 * 
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
@Entity
@Table(name = "folder")
public class FolderEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2877181555393537995L;
	
	private Long id;
	private String folder;
	private Boolean enabled;
	private Boolean es_canal;
	private Boolean es_instrumento_planificacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	private List<FolderEntity> folderList;

	public FolderEntity(){
		
	}
	
	public FolderEntity(String folderString){
		folder = folderString;
	}
	
	@Column(name = "folder", nullable = false)
	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	@Column(name = "enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "canal")
	public Boolean getEs_canal() {
		return es_canal;
	}

	public void setEs_canal(Boolean es_canal) {
		this.es_canal = es_canal;
	}

	@Column(name = "instrumento_planificacion")
	public Boolean getEs_instrumento_planificacion() {
		return es_instrumento_planificacion;
	}

	public void setEs_instrumento_planificacion(Boolean es_instrumento_planificacion) {
		this.es_instrumento_planificacion = es_instrumento_planificacion;
	}

	@Column(name = "fechaCreacion")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "fechaActualizacion")
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = (Long) id;
	}
	
	@OneToMany(targetEntity = ZoneEntity.class,
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "folders_in_folder",
	joinColumns =
	@JoinColumn(name = "folder_id"),
	inverseJoinColumns =
	@JoinColumn(name = "subfolder_id"))
	public List<FolderEntity> getFolderList() {
		return folderList;
	}

	public void setFolderList(List<FolderEntity> folderList) {
		this.folderList = folderList;
	}
}
