/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Dataset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String dataSourceNameinWebInterface;
	private String agencyId;
	@ManyToOne(optional = false)
	@JoinColumn(name = "instrumentId", referencedColumnName = "id")
	private Instrument instrument;
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinTable(name = "DatasetAndService", joinColumns = { @JoinColumn(name ="datasetId", referencedColumnName = "id")}, inverseJoinColumns = { @JoinColumn(name = "climateServiceId", referencedColumnName = "id") })
	private List<ClimateService> climateServiceSet;
	private Date publishTimeStamp;
	private String url;
	private String physicalVariable;
	private String CMIP5VarName;
	private String units;
	private String gridDimension;
	private String source;
	private String status;
	private String responsiblePerson;
	private String variableNameInWebInterface;
	private String dataSourceInputParameterToCallScienceApplicationCode;
	private String variableNameInputParameterToCallScienceApplicationCode;
	private String comment;
	private Date startTime;
	private Date endTime;
	

	public Dataset() {
	}
	
	public Dataset(String name, String dataSourceNameinWebInterface,
			String agencyId, Instrument instrument,
			List<ClimateService> climateServiceSet, Date publishTimeStamp,
			String url, String physicalVariable, String cMIP5VarName,
			String units, String gridDimension, String source, String status,
			String responsiblePerson, String variableNameInWebInterface,
			String dataSourceInputParameterToCallScienceApplicationCode,
			String variableNameInputParameterToCallScienceApplicationCode,
			String comment, Date startTime, Date endTime) {
		super();
		this.name = name;
		this.dataSourceNameinWebInterface = dataSourceNameinWebInterface;
		this.agencyId = agencyId;
		this.instrument = instrument;
		this.climateServiceSet = climateServiceSet;
		this.publishTimeStamp = publishTimeStamp;
		this.url = url;
		this.physicalVariable = physicalVariable;
		CMIP5VarName = cMIP5VarName;
		this.units = units;
		this.gridDimension = gridDimension;
		this.source = source;
		this.status = status;
		this.responsiblePerson = responsiblePerson;
		this.variableNameInWebInterface = variableNameInWebInterface;
		this.dataSourceInputParameterToCallScienceApplicationCode = dataSourceInputParameterToCallScienceApplicationCode;
		this.variableNameInputParameterToCallScienceApplicationCode = variableNameInputParameterToCallScienceApplicationCode;
		this.comment = comment;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDataSourceNameinWebInterface() {
		return dataSourceNameinWebInterface;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public List<ClimateService> getClimateServiceSet() {
		return climateServiceSet;
	}

	public Date getPublishTimeStamp() {
		return publishTimeStamp;
	}

	public String getUrl() {
		return url;
	}

	public String getPhysicalVariable() {
		return physicalVariable;
	}

	public String getCMIP5VarName() {
		return CMIP5VarName;
	}

	public String getUnits() {
		return units;
	}

	public String getGridDimension() {
		return gridDimension;
	}

	public String getSource() {
		return source;
	}

	public String getStatus() {
		return status;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public String getVariableNameInWebInterface() {
		return variableNameInWebInterface;
	}

	public String getDataSourceInputParameterToCallScienceApplicationCode() {
		return dataSourceInputParameterToCallScienceApplicationCode;
	}

	public String getVariableNameInputParameterToCallScienceApplicationCode() {
		return variableNameInputParameterToCallScienceApplicationCode;
	}

	public String getComment() {
		return comment;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDataSourceNameinWebInterface(String dataSourceNameinWebInterface) {
		this.dataSourceNameinWebInterface = dataSourceNameinWebInterface;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public void setClimateServiceSet(List<ClimateService> climateServiceSet) {
		this.climateServiceSet = climateServiceSet;
	}

	public void setPublishTimeStamp(Date publishTimeStamp) {
		this.publishTimeStamp = publishTimeStamp;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPhysicalVariable(String physicalVariable) {
		this.physicalVariable = physicalVariable;
	}

	public void setCMIP5VarName(String cMIP5VarName) {
		CMIP5VarName = cMIP5VarName;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public void setGridDimension(String gridDimension) {
		this.gridDimension = gridDimension;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public void setVariableNameInWebInterface(String variableNameInWebInterface) {
		this.variableNameInWebInterface = variableNameInWebInterface;
	}

	public void setDataSourceInputParameterToCallScienceApplicationCode(
			String dataSourceInputParameterToCallScienceApplicationCode) {
		this.dataSourceInputParameterToCallScienceApplicationCode = dataSourceInputParameterToCallScienceApplicationCode;
	}

	public void setVariableNameInputParameterToCallScienceApplicationCode(
			String variableNameInputParameterToCallScienceApplicationCode) {
		this.variableNameInputParameterToCallScienceApplicationCode = variableNameInputParameterToCallScienceApplicationCode;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Dataset [id=" + id + ", name=" + name
				+ ", dataSourceNameinWebInterface="
				+ dataSourceNameinWebInterface + ", agencyId=" + agencyId
				+ ", instrument=" + instrument + ", climateServiceSet="
				+ climateServiceSet + ", publishTimeStamp=" + publishTimeStamp
				+ ", url=" + url + ", physicalVariable=" + physicalVariable
				+ ", CMIP5VarName=" + CMIP5VarName + ", units=" + units
				+ ", gridDimension=" + gridDimension + ", source=" + source
				+ ", status=" + status + ", responsiblePerson="
				+ responsiblePerson + ", variableNameInWebInterface="
				+ variableNameInWebInterface
				+ ", dataSourceInputParameterToCallScienceApplicationCode="
				+ dataSourceInputParameterToCallScienceApplicationCode
				+ ", variableNameInputParameterToCallScienceApplicationCode="
				+ variableNameInputParameterToCallScienceApplicationCode
				+ ", comment=" + comment 
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+"]";
	}
	
}