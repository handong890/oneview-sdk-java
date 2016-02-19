/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
/**
 * A SAN represents a physical or logical fibre channel SAN or a Flat SAN (i.e. direct wire attach)
 */
package com.hp.ov.sdk.rest.client;

import com.hp.ov.sdk.dto.EndpointResponseCollection;
import com.hp.ov.sdk.dto.FcSansManagedSanTask;
import com.hp.ov.sdk.dto.SanRequest;
import com.hp.ov.sdk.dto.SanResponse;
import com.hp.ov.sdk.dto.SanResponseCollection;
import com.hp.ov.sdk.rest.http.core.client.RestParams;

public interface FcSansManagedSanClient {
    /**
     * The module aids in fetching the Managed San details for the specified
     * Managed San resourceId.
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for Managed San as seen in HP OneView.
     * @return sanResponseDto, which is a object containing the Managed San
     *         details.
     */
    SanResponse getManagedSan(final RestParams params, final String resourceId);

    /**
     * The module aids in fetching the Managed San details for all the Managed
     * San found under the current HP OneView.
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @return sanResponseCollectionDto, which is a object containing the
     *         collection of Managed San details.
     */
    SanResponseCollection getAllManagedSan(final RestParams params);

    /**
     * The module aids in fetching the Managed San details for the Managed San
     * name as specified in HP OneView.
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param name
     *            The resourceName is the Managed San name as seen in HP
     *            OneView.
     * @return sanResponseDto, which is a object containing the Managed San
     *         details.
     */
    SanResponse getManagedSanByName(final RestParams params, final String name);

    /**
     * The module takes in an Managed San object or JsonRequest and updates the
     * existing Managed San based on resource Id. It can process the request
     * asynchronously or synchronously based on flag input.
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for Managed San as seen in HP OneView.
     * @param updateSanRequest
     *            This is a object containing the Managed San details, used to
     *            update a Managed San
     * @param aSync
     *            Flag input to process request asynchronously or synchronously.
     * @param useJsonRequest
     *            The JsonRequest body is part of Managed San Object which takes
     *            in a String containing the update to be made, which is
     *            converted to Managed San Object using adaptor and processed.
     * @return taskResource which returns the task status for the process
     */
    SanResponse updateManagedSan(final RestParams params, final String resourceId, final SanRequest updateSanRequest,
            final boolean aSync, final boolean useJsonRequest);

    /**
     * Reports all endpoints known within the specified SAN, and data about that endpoint.
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for Managed San as seen in HP OneView.
     * @return {@link EndpointResponseCollection} which contains data of all endpoints
     *          os the specified SAN.
     */
    EndpointResponseCollection getEndpointsOfManagedSan(final RestParams params, final String resourceId);

    /**
     * Creates a new SAN issues report indicating any connectivity issues in the specified SAN
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for Managed San as seen in HP OneView.
     * @param aSync
     *            Flag input to process request asynchronously or synchronously.
     * @return {@link FcSansManagedSanTask} which contains the task status for the process
     *          and the report data.
     */
    FcSansManagedSanTask createManagedSanIssuesReport(final RestParams params, final String resourceId, boolean aSync);

    /**
     * Creates an endpoints CSV file for a SAN. Clients should perform a GET on the
     * URI in the response to download the file.
     *
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for Managed San as seen in HP OneView.
     * @return {@link EndpointsCsvFileResponse} contains the data of the created CSV file
     */
    EndpointsCsvFileResponse createEndpointsCsvOfManagedSan(final RestParams params, final String resourceId);

    /**
     * The module aids in fetching the ManagedSan details for the ManagedSan
     * name as specified in HP OneView.
     *
     * @param creds
     *            The RestParams is a structure containing the connection
     *            details.
     * @param name
     *            The resourceName is the ManagedSan name as seen in HP OneView.
     * @return String, which is a resource Id for the ManagedSan name as seen in
     *         HPOneView.
     */
    String getId(final RestParams creds, final String name);
}
