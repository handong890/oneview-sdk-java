/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *******************************************************************************/
package com.hp.ov.sdk.dto;

import java.util.ArrayList;
import java.util.List;

import com.hp.ov.sdk.dto.generated.Interconnects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class InterconnectsCollection extends BaseCollectionResource<Interconnects> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final List<Interconnects> members = new ArrayList<Interconnects>();

    @Override
    public List<Interconnects> getMembers() {
        final List<Interconnects> _members = new ArrayList<Interconnects>();
        if (this.members != null && !this.members.isEmpty()) {
            _members.addAll(this.members);
        }
        return _members;
    }

    @Override
    public void setMembers(final List<Interconnects> _members) {
        this.members.clear();
        if (_members != null && !_members.isEmpty()) {
            this.members.addAll(_members);
            this.setCount(this.members.size());
        }

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Interconnects searchName(final String value) {
        if (this.members != null && !this.members.isEmpty()) {
            for (final Interconnects member : this.members) {
                if (member.getName().equalsIgnoreCase(value)) {
                    return member;
                }
            }
        }
        return null;
    }

}