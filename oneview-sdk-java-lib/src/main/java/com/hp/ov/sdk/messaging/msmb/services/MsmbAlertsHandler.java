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
package com.hp.ov.sdk.messaging.msmb.services;

import com.hp.ov.sdk.adaptors.MsmbAlertsMessageAdaptor;
import com.hp.ov.sdk.dto.MsmbAlertsMessageDto;
import com.hp.ov.sdk.messaging.msmb.listeners.MsmbListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsmbAlertsHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsmbAlertsHandler.class);

    private final MsmbAlertsMessageAdaptor adaptor;
    private final MsmbListener msmbListener;

    public MsmbAlertsHandler(final MsmbListener msmbListener) {
        this.msmbListener = msmbListener;
        this.adaptor = new MsmbAlertsMessageAdaptor();
    }

    public void handleMessage(final String message) {
        LOGGER.debug("MsmbAlertsHandler : handlMessage : Message Received: " + message);

        // call adaptor
        final MsmbAlertsMessageDto alertsDto = adaptor.buildDto(message);
        // invoke listener
        msmbListener.handleMsmbMessage(alertsDto);
    }
}
