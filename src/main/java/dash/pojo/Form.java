package dash.pojo;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.beanutils.BeanUtils;

import dash.dao.FormEntity;
import dash.helpers.DateISO8601Adapter;
import dash.security.IAclObject;

/**
 * Form object definition
 * Data representation of a collection of questions to be presented to a user
 * as a single document or Form to fill out.
 *
 * @author tyler.swensen@gmail.com
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Form implements  IAclObject {

	/** id of the form */
	@XmlElement(name = "id")
	private Long id;

	/** name of the form */
	@XmlElement(name = "name")
	private String name;

	/** insertion date in the database */
	@XmlElement(name = "insertion_date")
	@XmlJavaTypeAdapter(DateISO8601Adapter.class)
	private Date insertion_date;

	public Form(FormEntity formEntity) {
		try {
			BeanUtils.copyProperties(this, formEntity);
		} catch ( IllegalAccessException e) {

			e.printStackTrace();
		} catch ( InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	public Form( String name) {

		this.name = name;
		
	}

	public Form() {
	}

	public String getName() {
		return name;
	}

	public void setName( String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id) {
		this.id = id;
	}

	public Date getinsertion_date() {
		return insertion_date;
	}

	public void setinsertion_date( Date insertion_date) {
		this.insertion_date = insertion_date;
	}



}