package com.esri.arcgis.soe.template.rest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    private ErrorObject error;

    public Error() {
    }

    public Error(ErrorObject error) {
        this.error = error;
    }

    public ErrorObject getError() {
        return error;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
