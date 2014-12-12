package com.tradenow.domains;

import java.io.Serializable;

public interface IEntity extends Serializable{
	public IDTO toDTO();
}
