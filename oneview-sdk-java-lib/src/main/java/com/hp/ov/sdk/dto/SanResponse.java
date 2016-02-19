/*******************************************************************************
 * (C) Copyright 2015-2016 Hewlett Packard Enterprise Development LP
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
package com.hp.ov.sdk.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Since;

public class SanResponse extends BaseModelResource {

    private static final long serialVersionUID = -1495921065098648747L;

    public enum RefreshState {
        RefreshFailed, RefreshPending, Refreshing, Stable, Unknown
    }

    private Integer aliasCount;
    private String aliasesUri;

    @Since(200)
    private List<NetworkResponse> associatedNetworks = new ArrayList<>();

    private String deviceManagerName;
    private String deviceManagerUri;
    private String deviceManagersUri;
    private String displayName;
    private String endpointsUri;
    private Boolean imported;

    @Since(200)
    private Boolean isActualFc;
    @Since(200)
    private Boolean isActualFcoe;
    @Since(200)
    private Boolean isExpectedFc;
    @Since(200)
    private Boolean isExpectedFcoe;
    @Since(200)
    private Boolean isFcCapable;
    @Since(200)
    private Boolean isFcoeCapable;

    private Boolean isInternal;
    private Integer portsFreeCount;
    private Integer portsTotalCount;
    private String portsUri;
    private Integer portsUsedCount;
    private String principalSwitch;
    private String providerName;

    private List<Property> publicAttributes = new ArrayList<>();
    private RefreshState refreshState;

    private String routingId;
    private SanPolicy sanPolicy;
    private Integer sanServicesCount;
    private String sanServicesUri;
    private String sanType;
    private Integer switchCount;
    private String switchesUri;

    @Since(200)
    private Integer vLanId;
    
    private Integer zoneCount;
    private String zonesUri;
    private ZoningState zoningState;

    public Integer getAliasCount() {
        return aliasCount;
    }

    public void setAliasCount(Integer aliasCount) {
        this.aliasCount = aliasCount;
    }

    public String getAliasesUri() {
        return aliasesUri;
    }

    public void setAliasesUri(String aliasesUri) {
        this.aliasesUri = aliasesUri;
    }

    public String getDeviceManagerName() {
        return deviceManagerName;
    }

    public void setDeviceManagerName(String deviceManagerName) {
        this.deviceManagerName = deviceManagerName;
    }

    public String getDeviceManagerUri() {
        return deviceManagerUri;
    }

    public void setDeviceManagerUri(String deviceManagerUri) {
        this.deviceManagerUri = deviceManagerUri;
    }

    public String getDeviceManagersUri() {
        return deviceManagersUri;
    }

    public void setDeviceManagersUri(String deviceManagersUri) {
        this.deviceManagersUri = deviceManagersUri;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEndpointsUri() {
        return endpointsUri;
    }

    public void setEndpointsUri(String endpointsUri) {
        this.endpointsUri = endpointsUri;
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public Boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }

    public Integer getPortsFreeCount() {
        return portsFreeCount;
    }

    public void setPortsFreeCount(Integer portsFreeCount) {
        this.portsFreeCount = portsFreeCount;
    }

    public Integer getPortsTotalCount() {
        return portsTotalCount;
    }

    public void setPortsTotalCount(Integer portsTotalCount) {
        this.portsTotalCount = portsTotalCount;
    }

    public String getPortsUri() {
        return portsUri;
    }

    public void setPortsUri(String portsUri) {
        this.portsUri = portsUri;
    }

    public Integer getPortsUsedCount() {
        return portsUsedCount;
    }

    public void setPortsUsedCount(Integer portsUsedCount) {
        this.portsUsedCount = portsUsedCount;
    }

    public String getPrincipalSwitch() {
        return principalSwitch;
    }

    public void setPrincipalSwitch(String principalSwitch) {
        this.principalSwitch = principalSwitch;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public List<Property> getPublicAttributes() {
        return publicAttributes;
    }

    public void setPublicAttributes(List<Property> publicAttributes) {
        this.publicAttributes = publicAttributes;
    }

    public RefreshState getRefreshState() {
        return refreshState;
    }

    public void setRefreshState(RefreshState refreshState) {
        this.refreshState = refreshState;
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public SanPolicy getSanPolicy() {
        return sanPolicy;
    }

    public void setSanPolicy(SanPolicy sanPolicy) {
        this.sanPolicy = sanPolicy;
    }

    public Integer getSanServicesCount() {
        return sanServicesCount;
    }

    public void setSanServicesCount(Integer sanServicesCount) {
        this.sanServicesCount = sanServicesCount;
    }

    public String getSanServicesUri() {
        return sanServicesUri;
    }

    public void setSanServicesUri(String sanServicesUri) {
        this.sanServicesUri = sanServicesUri;
    }

    public String getSanType() {
        return sanType;
    }

    public void setSanType(String sanType) {
        this.sanType = sanType;
    }

    public Integer getSwitchCount() {
        return switchCount;
    }

    public void setSwitchCount(Integer switchCount) {
        this.switchCount = switchCount;
    }

    public String getSwitchesUri() {
        return switchesUri;
    }

    public void setSwitchesUri(String switchesUri) {
        this.switchesUri = switchesUri;
    }

    public Integer getZoneCount() {
        return zoneCount;
    }

    public void setZoneCount(Integer zoneCount) {
        this.zoneCount = zoneCount;
    }

    public String getZonesUri() {
        return zonesUri;
    }

    public void setZonesUri(String zonesUri) {
        this.zonesUri = zonesUri;
    }

    public ZoningState getZoningState() {
        return zoningState;
    }

    public void setZoningState(ZoningState zoningState) {
        this.zoningState = zoningState;
    }

    public Boolean getIsActualFc() {
        return isActualFc;
    }

    public void setIsActualFc(Boolean isActualFc) {
        this.isActualFc = isActualFc;
    }

    public Boolean getIsActualFcoe() {
        return isActualFcoe;
    }

    public void setIsActualFcoe(Boolean isActualFcoe) {
        this.isActualFcoe = isActualFcoe;
    }

    public Boolean getIsExpectedFc() {
        return isExpectedFc;
    }

    public void setIsExpectedFc(Boolean isExpectedFc) {
        this.isExpectedFc = isExpectedFc;
    }

    public Boolean getIsExpectedFcoe() {
        return isExpectedFcoe;
    }

    public void setIsExpectedFcoe(Boolean isExpectedFcoe) {
        this.isExpectedFcoe = isExpectedFcoe;
    }

    public Boolean getIsFcCapable() {
        return isFcCapable;
    }

    public void setIsFcCapable(Boolean isFcCapable) {
        this.isFcCapable = isFcCapable;
    }

    public Boolean getIsFcoeCapable() {
        return isFcoeCapable;
    }

    public void setIsFcoeCapable(Boolean isFcoeCapable) {
        this.isFcoeCapable = isFcoeCapable;
    }

    public Integer getVlanId() {
        return vLanId;
    }

    public void setVlanId(Integer vLanId) {
        this.vLanId = vLanId;
    }

    public List<NetworkResponse> getAssociatedNetworks() {
        return associatedNetworks;
    }

    public void setAssociatedNetworks(List<NetworkResponse> associatedNetworks) {
        this.associatedNetworks = associatedNetworks;
    }

    //TODO equals && hashcode && toString

}
