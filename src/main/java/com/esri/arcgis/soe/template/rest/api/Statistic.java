package com.esri.arcgis.soe.template.rest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistic implements Serializable {

    private static final long serialVersionUID = 1L;

    private String statisticType;
    private String onStatisticField;
    private String outStatisticFieldName;

    public Statistic() {
    }

    public Statistic(String statisticType, String onStatisticField) {
        super();
        this.statisticType = statisticType;
        this.onStatisticField = onStatisticField;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }

    public String getOnStatisticField() {
        return onStatisticField;
    }

    public void setOnStatisticField(String onStatisticField) {
        this.onStatisticField = onStatisticField;
    }

    public String getOutStatisticFieldName() {
        return outStatisticFieldName;
    }

    public void setOutStatisticFieldName(String outStatisticFieldName) {
        this.outStatisticFieldName = outStatisticFieldName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
