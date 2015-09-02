/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *******************************************************************************/
package com.hp.ov.sdk.storage;

import com.hp.ov.sdk.bean.factory.HPOneViewSdkBeanFactory;
import com.hp.ov.sdk.constants.ResourceCategory;
import com.hp.ov.sdk.dto.AddStorageVolumeV2;
import com.hp.ov.sdk.dto.StorageVolumeCollection;
import com.hp.ov.sdk.dto.StorageVolumeProvisioningParameters;
import com.hp.ov.sdk.dto.StorageVolumeV2;
import com.hp.ov.sdk.dto.TaskResourceV2;
import com.hp.ov.sdk.exceptions.SDKApplianceNotReachableException;
import com.hp.ov.sdk.exceptions.SDKBadRequestException;
import com.hp.ov.sdk.exceptions.SDKInvalidArgumentException;
import com.hp.ov.sdk.exceptions.SDKNoResponseException;
import com.hp.ov.sdk.exceptions.SDKNoSuchUrlException;
import com.hp.ov.sdk.exceptions.SDKResourceNotFoundException;
import com.hp.ov.sdk.exceptions.SDKTasksException;
import com.hp.ov.sdk.rest.client.StoragePoolClient;
import com.hp.ov.sdk.rest.client.StorageSystemClient;
import com.hp.ov.sdk.rest.client.StorageVolumeClient;
import com.hp.ov.sdk.rest.http.core.client.RestParams;
import com.hp.ov.sdk.util.SdkUtils;
import com.hp.ov.sdk.util.UrlUtils;
import com.hp.ov.sdk.util.samples.SampleRestParams;

/*
 * StorageVolumeClientSample is a sample program consume the container that is defined over the storage pool HP OneView.  
 * It invokes APIs of StorageVolumeClient which is in sdk library to perform GET/PUT/POST/DELETE
 * operations on storage volume resource
 */
public class StorageVolumeClientSample {
    private RestParams params;
    private static SdkUtils sdkUtils;
    private static SampleRestParams sampleRestParams;
    private static UrlUtils urlUtils;
    private static TaskResourceV2 taskResourceV2;
    private static StorageVolumeClient storageVolumeClient;
    private static StoragePoolClient storagePoolClient;
    private static StorageSystemClient storageSystemClient;

    // These are variables to be defined by user
    // ================================
    private static final String resourceName = "Volume101";
    private static final String storageSystemName = "ThreePAR7200-3050";
    private static final String storagePoolName = "FST_CPG1";
    private static final String resourceNameForPrivateStorage = "volume103";
    private static final String resourceId = "50A95C8F-B279-44E8-9496-C633EAA82EF1";
    private static final String capacity = "1234567898";

    // ================================

    private static void init() {
        sdkUtils = HPOneViewSdkBeanFactory.getSdkUtils();
        urlUtils = HPOneViewSdkBeanFactory.getUrlUtils();
        sampleRestParams = new SampleRestParams();
        storageVolumeClient = HPOneViewSdkBeanFactory.getStorageVolumeClient();
        storagePoolClient = HPOneViewSdkBeanFactory.getStoragePoolClient();
        storageSystemClient = HPOneViewSdkBeanFactory.getStorageSystemClient();
    }

    private void getStorageVolumeById() throws InstantiationException, IllegalAccessException {
        StorageVolumeV2 storageVolumeDto = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // then make sdk service call to get resource
            storageVolumeDto = storageVolumeClient.getStorageVolume(params, resourceId);

            System.out.println("StorageVolumeClientTest : getStorageVolumeById : storageVolume object returned to client : "
                    + storageVolumeDto.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeById : resource you are looking is not found ");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeById : no such url : " + params.getUrl());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeById : Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeById : No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeById : arguments are null ");
            return;
        }

    }

    private void getAllStorageVolume() throws InstantiationException, IllegalAccessException, SDKResourceNotFoundException,
            SDKNoSuchUrlException {
        StorageVolumeCollection storageVolumeCollectionDto = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // then make sdk service call to get resource
            storageVolumeCollectionDto = storageVolumeClient.getAllStorageVolumes(params);

            System.out.println("StorageVolumeClientTest : getAllStorageVolume : storageVolume object returned to client : "
                    + storageVolumeCollectionDto.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : getAllStorageVolume : resource you are looking is not found");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : getAllStorageVolume : no such url : " + params.getHostname());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : getAllStorageVolume : Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("StorageVolumeClientTest : getAllStorageVolume : No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : getAllStorageVolume : arguments are null ");
            return;
        }
    }

    private void getStorageVolumeByName() throws InstantiationException, IllegalAccessException {
        StorageVolumeV2 storageVolumeDto = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // then make sdk service call to get resource
            storageVolumeDto = storageVolumeClient.getStorageVolumeByName(params, resourceName);

            System.out.println("StorageVolumeClientTest : getStorageVolumeByName : storageVolume object returned to client : "
                    + storageVolumeDto.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeByName : resource you are looking is not found ");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeByName : no such url : " + params.getUrl());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeByName : Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeByName : No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : getStorageVolumeByName : arguments are null ");
            return;
        }

    }

    private void createStorageVolume() throws InstantiationException, IllegalAccessException {

        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // create storageVolume request body
            final AddStorageVolumeV2 addStorageVolumeDto = buildTestStorageVolumeDto();
            /**
             * then make sdk service call to get resource aSync parameter
             * indicates sync vs async useJsonRequest parameter indicates
             * whether json input request present or not
             */
            taskResourceV2 = storageVolumeClient.createStorageVolume(params, addStorageVolumeDto, false, false);

            System.out.println("StorageVolumeClientTest : createStorageVolume : storageVolume object returned to client : "
                    + taskResourceV2.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : createStorageVolume : resource you are looking is not found");
            return;
        } catch (final SDKBadRequestException ex) {
            System.out.println("StorageVolumeClientTest : createStorageVolume : bad request, try again : "
                    + "may be duplicate resource name or invalid inputs. check inputs and try again");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : createStorageVolume : no such url : " + params.getHostname());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : createStorageVolume : Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : createStorageVolume : arguments are null ");
            return;
        } catch (final SDKTasksException e) {
            System.out
                    .println("StorageVolumeClientTest : createStorageVolume : errors in task, please check task resource for more details ");
            return;
        }

    }

    private void createPrivateStorageVolume() throws InstantiationException, IllegalAccessException {

        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // create storageVolume request body
            final AddStorageVolumeV2 addStorageVolumeDto = buildTestPrivateStorageVolumeDto();
            /**
             * then make sdk service call to get resource aSync parameter
             * indicates sync vs async useJsonRequest parameter indicates
             * whether json input request present or not
             */
            taskResourceV2 = storageVolumeClient.createStorageVolume(params, addStorageVolumeDto, false, false);

            System.out.println("StorageVolumeClientTest : createPrivateStorageVolume : storageVolume object returned to client : "
                    + taskResourceV2.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : createPrivateStorageVolume : resource you are looking is not found");
            return;
        } catch (final SDKBadRequestException ex) {
            System.out.println("StorageVolumeClientTest : createPrivateStorageVolume : bad request, try again : "
                    + "may be duplicate resource name or invalid inputs. check inputs and try again");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : createPrivateStorageVolume : no such url : " + params.getHostname());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : createPrivateStorageVolume : Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : createPrivateStorageVolume : arguments are null ");
            return;
        } catch (final SDKTasksException e) {
            System.out
                    .println("StorageVolumeClientTest : createPrivateStorageVolume : errors in task, please check task resource for more details ");
            return;
        }

    }

    private void updateStorageVolume() throws InstantiationException, IllegalAccessException {
        StorageVolumeV2 storageVolumeDto = null;
        String updateStorage = null;
        String resourceId = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // fetch resource Id using resource name
            storageVolumeDto = storageVolumeClient.getStorageVolumeByName(params, resourceName);

            if (null != storageVolumeDto.getUri()) {
                resourceId = urlUtils.getResourceIdFromUri(storageVolumeDto.getUri());
            }
            storageVolumeDto.setName(resourceName);

            /**
             * then make sdk service call to get resource aSync parameter
             * indicates sync vs async useJsonRequest parameter indicates
             * whether json input request present or not
             */
            updateStorage = storageVolumeClient.updateStorageVolume(params, resourceId, storageVolumeDto, false);

            System.out.println("StorageVolumeClientTest : updateStorageVolume : " + "storageVolume object returned to client : "
                    + updateStorage);
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume :"
                    + " resource you are looking is not found for update ");
            return;
        } catch (final SDKBadRequestException ex) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume :" + " bad request, try again : "
                    + "may be duplicate resource name or invalid inputs. check inputs and try again");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume :" + " no such url : " + params.getUrl());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume :" + " Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume :" + " No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume : " + "arguments are null ");
            return;
        } catch (final SDKTasksException e) {
            System.out.println("StorageVolumeClientTest : updateStorageVolume : " + "errors in task, please check task "
                    + "resource for more details ");
            return;
        }
    }

    private void deleteStorageVolume() throws InstantiationException, IllegalAccessException {
        StorageVolumeV2 storageVolumeDto = null;
        String resourceId = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // fetch resource Id using resource name
            storageVolumeDto = storageVolumeClient.getStorageVolumeByName(params, resourceName);

            if (null != storageVolumeDto.getUri()) {
                resourceId = urlUtils.getResourceIdFromUri(storageVolumeDto.getUri());
            }

            // then make sdk service call to get resource
            taskResourceV2 = storageVolumeClient.deleteStorageVolume(params, resourceId, false);

            System.out.println("StorageVolumeClientTest : deleteStorageVolume : storageVolume object returned to client : "
                    + taskResourceV2.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("StorageVolumeClientTest : deleteStorageVolume : resource you are looking is not found for delete ");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("StorageVolumeClientTest : deleteStorageVolume : no such url : " + params.getUrl());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("StorageVolumeClientTest : deleteStorageVolume : Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("StorageVolumeClientTest : deleteStorageVolume : No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("StorageVolumeClientTest : deleteStorageVolume : arguments are null ");
            return;
        }

    }

    // TODO - Move Uri fetch logic to SdkUtils

    private AddStorageVolumeV2 buildTestStorageVolumeDto() {
        final AddStorageVolumeV2 dto = new AddStorageVolumeV2();

        dto.setName(resourceName);
        dto.setDescription("Volume description");
        dto.setStorageSystemUri(storageSystemClient.getStorageSystemByName(params, storageSystemName).getUri());
        dto.setType(ResourceCategory.RC_ADD_STORAGE_VOLUME);

        final StorageVolumeProvisioningParameters provisioningParameters = new StorageVolumeProvisioningParameters();
        provisioningParameters.setProvisionType("Full");
        provisioningParameters.setShareable(true);
        provisioningParameters.setRequestedCapacity(capacity);
        provisioningParameters.setStoragePoolUri(storagePoolClient.getStoragePoolByName(params, storagePoolName,
                getStorageSystemUri()).getUri());
        dto.setProvisioningParameters(provisioningParameters);

        return dto;
    }

    // TODO - Move Uri fetch logic to SdkUtils

    private AddStorageVolumeV2 buildTestPrivateStorageVolumeDto() {
        final AddStorageVolumeV2 dto = new AddStorageVolumeV2();

        dto.setName(resourceNameForPrivateStorage);
        dto.setDescription("Volume description");
        dto.setStorageSystemUri(storageSystemClient.getStorageSystemByName(params, storageSystemName).getUri());
        dto.setType(ResourceCategory.RC_ADD_STORAGE_VOLUME);

        final StorageVolumeProvisioningParameters provisioningParameters = new StorageVolumeProvisioningParameters();
        provisioningParameters.setProvisionType("Full");
        provisioningParameters.setShareable(false);
        provisioningParameters.setRequestedCapacity("1234567898");
        provisioningParameters.setStoragePoolUri(storagePoolClient.getStoragePoolByName(params, storagePoolName,
                getStorageSystemUri()).getUri());
        dto.setProvisioningParameters(provisioningParameters);

        return dto;
    }

    private String getStorageSystemUri() {
        return storageSystemClient.getStorageSystemByName(params, storageSystemName).getUri();
    }

    // Main
    public static void main(final String[] args) throws Exception {
        init();
        StorageVolumeClientSample client = new StorageVolumeClientSample();
        client.getStorageVolumeById();
        client.createStorageVolume();
        client.createPrivateStorageVolume();
        client.getAllStorageVolume();
        client.getStorageVolumeByName();
        client.updateStorageVolume();
        client.deleteStorageVolume();
    }
}