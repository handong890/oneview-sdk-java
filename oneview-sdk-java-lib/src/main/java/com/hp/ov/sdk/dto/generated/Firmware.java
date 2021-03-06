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
package com.hp.ov.sdk.dto.generated;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Since;

public class Firmware implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean forceInstallFirmware;
    private String firmwareBaselineUri;
    private Boolean manageFirmware;
    @Since(200)
    private FirmwareInstallType firmwareInstallType;

    /**
     *
     * @return The forceInstallFirmware
     */
    public Boolean getForceInstallFirmware() {
        return forceInstallFirmware;
    }

    /**
     *
     * @param forceInstallFirmware
     *            The forceInstallFirmware
     */
    public void setForceInstallFirmware(final Boolean forceInstallFirmware) {
        this.forceInstallFirmware = forceInstallFirmware;
    }

    /**
     *
     * @return The firmwareBaselineUri
     */
    public String getFirmwareBaselineUri() {
        return firmwareBaselineUri;
    }

    /**
     *
     * @param firmwareBaselineUri
     *            The firmwareBaselineUri
     */
    public void setFirmwareBaselineUri(final String firmwareBaselineUri) {
        this.firmwareBaselineUri = firmwareBaselineUri;
    }

    /**
     *
     * @return The manageFirmware
     */
    public Boolean getManageFirmware() {
        return manageFirmware;
    }

    /**
     *
     * @param manageFirmware
     *            The manageFirmware
     */
    public void setManageFirmware(final Boolean manageFirmware) {
        this.manageFirmware = manageFirmware;
    }

    /**
     * @return the firmwareInstallType
     */
    public FirmwareInstallType getFirmwareInstallType() {
        return firmwareInstallType;
    }

    /**
     * @param firmwareInstallType the firmwareInstallType to set
     */
    public void setFirmwareInstallType(FirmwareInstallType firmwareInstallType) {
        this.firmwareInstallType = firmwareInstallType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(forceInstallFirmware).append(firmwareBaselineUri).append(manageFirmware).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Firmware) == false) {
            return false;
        }
        final Firmware rhs = ((Firmware) other);
        return new EqualsBuilder().append(forceInstallFirmware, rhs.forceInstallFirmware)
                .append(firmwareBaselineUri, rhs.firmwareBaselineUri).append(manageFirmware, rhs.manageFirmware).isEquals();
    }


    public static enum FirmwareInstallType {

        FirmwareOnly("FirmwareOnly"),
        FirmwareAndOSDrivers("FirmwareAndOSDrivers"),
        FirmwareOnlyOfflineMode("FirmwareOnlyOfflineMode");

        private final String value;
        private static Map<String, Firmware.FirmwareInstallType> constants = new HashMap<String, Firmware.FirmwareInstallType>();

        static {
            for (final Firmware.FirmwareInstallType c : values()) {
                constants.put(c.value, c);
            }
        }

        private FirmwareInstallType(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static Firmware.FirmwareInstallType fromValue(final String value) {
            final Firmware.FirmwareInstallType constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }
}
