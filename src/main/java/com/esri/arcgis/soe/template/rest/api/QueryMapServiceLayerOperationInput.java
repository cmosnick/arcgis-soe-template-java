package com.esri.arcgis.soe.template.rest.api;

import com.esri.arcgis.geometry.IGeometry;
import com.esri.arcgis.geometry.ISpatialReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryMapServiceLayerOperationInput extends OperationInput {

    private static final long serialVersionUID = 1L;

    private String text;
    private IGeometry geometry;
    private GeometryType geometryType;
    private ISpatialReference inSR;
    private SpatialRelationship spatialRel;
    private String relationParam;
    private String where;
    private String objectIds;
    private String time;
    private Double distance;
    private UnitType units;
    private String outFields;
    private Boolean returnGeometry;
    private Double maxAllowableOffset;
    private Short geometryPrecision;
    private ISpatialReference outSR;
    private Boolean returnIdsOnly;
    private Boolean returnCountOnly;
    private Boolean returnExtentOnly;
    private String orderByFields;
    private List<Statistic> outStatistics;
    private String groupByFieldsForStatistics;
    private Boolean returnZ;
    private Boolean returnM;
    private String gdbVersion;
    private Boolean returnDistinctValues;
    private Boolean returnTrueCurves;
    private Integer resultOffset;
    private Integer resultRecordCount;

    public QueryMapServiceLayerOperationInput() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(IGeometry geometry) {
        this.geometry = geometry;
    }

    public GeometryType getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(GeometryType geometryType) {
        this.geometryType = geometryType;
    }

    public ISpatialReference getInSR() {
        return inSR;
    }

    public void setInSR(ISpatialReference inSR) {
        this.inSR = inSR;
    }

    public SpatialRelationship getSpatialRel() {
        return spatialRel;
    }

    public void setSpatialRel(SpatialRelationship spatialRel) {
        this.spatialRel = spatialRel;
    }

    public String getRelationParam() {
        return relationParam;
    }

    public void setRelationParam(String relationParam) {
        this.relationParam = relationParam;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getObjectIds() {
        return objectIds;
    }

    public void setObjectIds(String objectIds) {
        this.objectIds = objectIds;
    }

    @JsonIgnore
    public Integer[] getObjectIDsAsArray() {
        List<Integer> objectIDList = new ArrayList<Integer>();
        if (objectIds != null) {
            String[] objectIDArr = objectIds.split(",");
            for (int i = 0; i < objectIDArr.length; i++) {
                String objectIDStr = objectIDArr[i];
                if (StringUtils.isNumeric(objectIDStr)) {
                    objectIDList.add(Integer.valueOf(objectIDStr));
                }
            }
        }
        return objectIDList.toArray(new Integer[0]);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public UnitType getUnits() {
        return units;
    }

    public void setUnits(UnitType units) {
        this.units = units;
    }

    public String getOutFields() {
        return outFields;
    }

    public void setOutFields(String outFields) {
        this.outFields = outFields;
    }

    @JsonIgnore
    public String[] getOutFieldsAsArray() {
        return outFields != null ? outFields.split(",") : new String[0];
    }

    public Boolean isReturnGeometry() {
        return returnGeometry;
    }

    public void setReturnGeometry(Boolean returnGeometry) {
        this.returnGeometry = returnGeometry;
    }

    public Double getMaxAllowableOffset() {
        return maxAllowableOffset;
    }

    public void setMaxAllowableOffset(Double maxAllowableOffset) {
        this.maxAllowableOffset = maxAllowableOffset;
    }

    public Short getGeometryPrecision() {
        return geometryPrecision;
    }

    public void setGeometryPrecision(Short geometryPrecision) {
        this.geometryPrecision = geometryPrecision;
    }

    public ISpatialReference getOutSR() {
        return outSR;
    }

    public void setOutSR(ISpatialReference outSR) {
        this.outSR = outSR;
    }

    public Boolean isReturnIDsOnly() {
        return returnIdsOnly;
    }

    public void setReturnIDsOnly(Boolean returnIdsOnly) {
        this.returnIdsOnly = returnIdsOnly;
    }

    public Boolean isReturnCountOnly() {
        return returnCountOnly;
    }

    public void setReturnCountOnly(Boolean returnCountOnly) {
        this.returnCountOnly = returnCountOnly;
    }

    public Boolean getReturnExtentOnly() {
        return returnExtentOnly;
    }

    public void setReturnExtentOnly(Boolean returnExtentOnly) {
        this.returnExtentOnly = returnExtentOnly;
    }

    public String getOrderByFields() {
        return orderByFields;
    }

    public void setOrderByFields(String orderByFields) {
        this.orderByFields = orderByFields;
    }

    @JsonIgnore
    public String[] getOrderByFieldsAsArray() {
        return orderByFields != null ? orderByFields.split(",") : new String[0];
    }

    public List<Statistic> getOutStatistics() {
        return outStatistics;
    }

    public void setOutStatistics(List<Statistic> outStatistics) {
        this.outStatistics = outStatistics;
    }

    public String getGroupByFieldsForStatistics() {
        return groupByFieldsForStatistics;
    }

    public void setGroupByFieldsForStatistics(String groupByFieldsForStatistics) {
        this.groupByFieldsForStatistics = groupByFieldsForStatistics;
    }

    @JsonIgnore
    public String[] getGroupByFieldsForStatisticsAsArray() {
        return groupByFieldsForStatistics != null ? groupByFieldsForStatistics
                .split(",") : new String[0];
    }

    public Boolean getReturnZ() {
        return returnZ;
    }

    public void setReturnZ(Boolean returnZ) {
        this.returnZ = returnZ;
    }

    public Boolean getReturnM() {
        return returnM;
    }

    public void setReturnM(Boolean returnM) {
        this.returnM = returnM;
    }

    public String getGdbVersion() {
        return gdbVersion;
    }

    public void setGdbVersion(String gdbVersion) {
        this.gdbVersion = gdbVersion;
    }

    public Boolean isReturnDistinctValues() {
        return returnDistinctValues;
    }

    public void setReturnDistinctValues(Boolean returnDistinctValues) {
        this.returnDistinctValues = returnDistinctValues;
    }

    public Integer getResultOffset() {
        return resultOffset;
    }

    public void setResultOffset(Integer resultOffset) {
        this.resultOffset = resultOffset;
    }

    public Integer getResultRecordCount() {
        return resultRecordCount;
    }

    public void setResultRecordCount(Integer resultRecordCount) {
        this.resultRecordCount = resultRecordCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
