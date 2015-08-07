/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *******************************************************************************/
package com.hp.ov.sdk.interconnects.samples;

import com.hp.ov.sdk.bean.factory.HPOneViewSdkBeanFactory;
import com.hp.ov.sdk.dto.InterconnectTypeCollectionV2;
import com.hp.ov.sdk.dto.generated.InterconnectTypes;
import com.hp.ov.sdk.exceptions.SDKApplianceNotReachableException;
import com.hp.ov.sdk.exceptions.SDKInvalidArgumentException;
import com.hp.ov.sdk.exceptions.SDKNoResponseException;
import com.hp.ov.sdk.exceptions.SDKNoSuchUrlException;
import com.hp.ov.sdk.exceptions.SDKResourceNotFoundException;
import com.hp.ov.sdk.rest.client.InterconnectTypeClient;
import com.hp.ov.sdk.rest.http.core.client.RestParams;
import com.hp.ov.sdk.util.SdkUtils;
import com.hp.ov.sdk.util.samples.SampleRestParams;

public class InterconnectTypeClientSample {
    private RestParams params;
    private static SdkUtils sdkUtils;
    private static SampleRestParams sampleRestParams;
    private static InterconnectTypeClient interconnectTypeClient;

    // These are variables to be defined by user
    // ================================
    private static final String resourceName = "HP VC FlexFabric-20/40 F8 Module";
    private static final String resourceId = "f4a7d44e-b0c5-4c9c-9c83-142e24aac7b3";

    // ================================

    private static void init() {
        interconnectTypeClient = HPOneViewSdkBeanFactory.getInterconnectTypeClient();
        sdkUtils = HPOneViewSdkBeanFactory.getSdkUtils();
        sampleRestParams = new SampleRestParams();
    }

    private void getInterconnectTypeById() throws InstantiationException, IllegalAccessException {
        InterconnectTypes interconnectTypeDto = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // then make sdk service call to get resource
            interconnectTypeDto = interconnectTypeClient.getInterconnectType(params, resourceId);

            System.out.println("InterconnectTypeClientTest : getInterconnectTypeById :"
                    + " interconnect type object returned to client : " + interconnectTypeDto.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out
                    .println("InterconnectTypeClientTest : getInterconnectTypeById :" + " resource you are looking is not found ");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeById :" + " no such url : " + params.getUrl());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeById :" + " Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeById :" + " No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeById :" + " arguments are null ");
            return;
        }

    }

    private void getAllInterconnectType() throws InstantiationException, IllegalAccessException, SDKResourceNotFoundException,
            SDKNoSuchUrlException {
        InterconnectTypeCollectionV2 interconnectTypeCollectionDto = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // then make sdk service call to get resource
            interconnectTypeCollectionDto = interconnectTypeClient.getAllInterconnectType(params);

            System.out.println("InterconnectTypeClientTest : getAllInterconnectType :"
                    + " interconnect type object returned to client : " + interconnectTypeCollectionDto.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("InterconnectTypeClientTest : getAllInterconnectType " + ": resource you are looking is not found");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("InterconnectTypeClientTest : getAllInterconnectType :" + " no such url : " + params.getHostname());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("InterconnectTypeClientTest : getAllInterconnectType :" + " Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("InterconnectTypeClientTest : getAllInterconnectType :" + " No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("InterconnectTypeClientTest : getAllInterconnectType :" + " arguments are null ");
            return;
        }
    }

    private void getInterconnectTypeByName() throws InstantiationException, IllegalAccessException {
        InterconnectTypes interconnectTypeDto = null;
        try {
            // Get the basic REST parameters like hostname, username and
            // password
            params = sampleRestParams.getBasicRestParams();

            // update the parameters with version and sessionId
            params = sdkUtils.createRestParams(params);

            // then make sdk service call to get resource
            interconnectTypeDto = interconnectTypeClient.getInterconnectTypeByName(params, resourceName);

            System.out.println("InterconnectTypeClientTest : getInterconnectTypeByName :"
                    + " interconnect type object returned to client : " + interconnectTypeDto.toString());
        } catch (final SDKResourceNotFoundException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeByName :" + " resource not found : ");
            return;
        } catch (final SDKNoSuchUrlException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeByName :" + " no such url : " + params.getUrl());
            return;
        } catch (final SDKApplianceNotReachableException e) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeByName :" + " Applicance Not reachabe at : "
                    + params.getHostname());
            return;
        } catch (final SDKNoResponseException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeByName :" + " No response from appliance : "
                    + params.getHostname());
            return;
        } catch (final SDKInvalidArgumentException ex) {
            System.out.println("InterconnectTypeClientTest : getInterconnectTypeByName :" + " arguments are null ");
            return;
        }

    }

    // Main
    public static void main(final String[] args) throws Exception {
        init();
        InterconnectTypeClientSample client = new InterconnectTypeClientSample();
        client.getInterconnectTypeById();
        client.getAllInterconnectType();
        client.getInterconnectTypeByName();
    }

}