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
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class InterconnectLocation implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private List<LocationEntry> locationEntries = new ArrayList<LocationEntry>();

    /**
     * 
     * @return The locationEntries
     */
    public List<LocationEntry> getLocationEntries() {
        return locationEntries;
    }

    /**
     * 
     * @param locationEntries
     *            The locationEntries
     */
    public void setLocationEntries(final List<LocationEntry> locationEntries) {
        this.locationEntries = locationEntries;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(locationEntries).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InterconnectLocation) == false) {
            return false;
        }
        final InterconnectLocation rhs = ((InterconnectLocation) other);
        return new EqualsBuilder().append(locationEntries, rhs.locationEntries).isEquals();
    }

}
