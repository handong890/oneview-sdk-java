/*******************************************************************************
 * // (C) Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 *******************************************************************************/
package com.hp.ov.sdk.dto;

import java.io.Serializable;

public class StorageSystemCredentials implements Serializable
{

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String ip_hostname;
    private String username;

    /**
     * 
     * @return
     *         The ip_hostname
     */
    public String getIp_hostname()
    {
        return ip_hostname;
    }

    /**
     * 
     * @param ip_hostname
     *        The ip_hostname
     */
    public void setIp_hostname(final String ip_hostname)
    {
        this.ip_hostname = ip_hostname;
    }

    /**
     * 
     * @return
     *         The username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @param username
     *        The username
     */
    public void setUsername(final String username)
    {
        this.username = username;
    }

}