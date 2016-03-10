package com.esri.arcgis.soe.template.rest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private String[] details;

    public ErrorObject() {
    }

    public ErrorObject(Integer code, String message, String[] details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String[] getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
