/*
 * Copyright 2015 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortmocks.mock.soap.model.project.dto;

import com.fortmocks.core.model.project.dto.ProjectDto;
import com.fortmocks.mock.soap.model.project.SoapOperationStatus;
import org.dozer.Mapping;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The DTO class for the Project class
 * @author Karl Dahlgren
 * @since 1.0
 */
public class SoapProjectDto extends ProjectDto {

    @Mapping("soapPorts")
    private List<SoapPortDto> soapPorts = new LinkedList<SoapPortDto>();
    private Map<SoapOperationStatus, Integer> statusCount = new HashMap<SoapOperationStatus, Integer>();

    /**
     * The default SOAP project constructor
     */
    public SoapProjectDto() {
    }

    /**
     * The constructor will create a new SOAP project DTO based on the provided projectDto
     * @param projectDto The new SOAP project DTO will be based on the provided project DTO and contain
     *                   the same information as the provided project DTO
     */
    public SoapProjectDto(final ProjectDto projectDto){
        super(projectDto);
    }

    /**
     * Returns all the SOAP ports
     * @return The SOAP ports for the SOAP project
     */
    public List<SoapPortDto> getSoapPorts() {
        return soapPorts;
    }

    /**
     * Set new value to the variable soapPorts
     * @param soapPorts The new value to soapPorts
     */
    public void setSoapPorts(List<SoapPortDto> soapPorts) {
        this.soapPorts = soapPorts;
    }

    /**
     * The status count is used in the GUI to information the user on the SOAP operation status distribution.
     * @return The status counts.
     */
    public Map<SoapOperationStatus, Integer> getStatusCount() {
        return statusCount;
    }

    /**
     * Sets a new value to the statusCount variable
     * @param statusCount The new value to statusCount
     */
    public void setStatusCount(Map<SoapOperationStatus, Integer> statusCount) {
        this.statusCount = statusCount;
    }

}
