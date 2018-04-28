/*
 * Copyright 2018 Karl Dahlgren
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

package com.castlemock.web.mock.rest.model.project.repository;

import com.castlemock.core.basis.model.Repository;
import com.castlemock.core.mock.rest.model.project.domain.RestApplication;
import com.castlemock.core.mock.rest.model.project.domain.RestProject;
import com.castlemock.core.mock.rest.model.project.domain.RestResource;
import com.castlemock.core.mock.rest.model.project.dto.RestApplicationDto;
import com.castlemock.core.mock.rest.model.project.dto.RestProjectDto;
import com.castlemock.core.mock.rest.model.project.dto.RestResourceDto;

import java.util.List;

public interface RestResourceRepository extends Repository<RestResource, RestResourceDto, String> {

    /**
     * Delete all {@link RestResource} that matches the provided
     * <code>applicationId</code>.
     * @param applicationId The id of the applicationId.
     */
    void deleteWithApplicationId(String applicationId);

    /**
     * Find all {@link RestResourceDto} that matches the provided
     * <code>applicationId</code>.
     * @param applicationId The id of the applicationId.
     * @return A list of {@link RestResourceDto}.
     */
    List<RestResourceDto> findWithApplicationId(String applicationId);


    /**
     * Finds a {@link RestResourceDto} with a URI
     * @param applicationId The id of the {@link RestApplication}
     * @param resourceUri The URI of a {@link RestResource}
     * @return A {@link RestResourceDto} that matches the search criteria.
     * @see RestProject
     * @see RestProjectDto
     * @see RestApplication
     * @see RestApplicationDto
     * @see RestResource
     * @see RestResourceDto
     */
    RestResourceDto findRestResourceByUri(String applicationId, String resourceUri);



}